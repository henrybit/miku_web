package com.miku.web.controller;

import com.miku.web.dao.JoinGameDao;
import com.miku.web.entity.JoinGame;
import com.miku.web.entity.response.BaseResponse;
import com.miku.web.entity.weixin.GetTokenResponse;
import com.miku.web.entity.weixin.ResultType;
import com.miku.web.tools.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 比赛相关
 * Created by henrybit on 2017/3/30.
 * @version 1.0
 */
@Controller
@RequestMapping(value="/game")
public class GameController extends BaseController{

    @Autowired
    private JoinGameDao joinGameDao;

    @RequestMapping(value="exist.json")
    public ModelAndView exist(HttpServletRequest request, HttpServletResponse response) {
        String wechatId = null;
        try {
            wechatId = URLDecoder.decode(request.getParameter("wechatId"),"utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("wechatId",wechatId);
        JoinGame joinGame = this.joinGameDao.getOne(map);
        boolean exist = false;
        if (joinGame != null)
            exist = true;
        BaseResponse info = new BaseResponse();
        info.setCode(1);
        info.setData(exist);
        outWrite(response, info);

        return null;
    }

    @RequestMapping(value="join.json")
    public ModelAndView join(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("name");
        String wechatId = request.getParameter("wechatId");
        String job = request.getParameter("job");
        String phone = request.getParameter("phone");
        String refereeWechatId = request.getParameter("rwid");
        String refereeWechat = request.getParameter("wname");
        String sexStr = request.getParameter("sex");
        String corporation = request.getParameter("cor");
        String registerTimeStr = request.getParameter("regtime");
        String corPeopleNumStr = request.getParameter("corpn");
        String projectName = request.getParameter("pname");
        String projectDesc = request.getParameter("pdesc");
        String fstr = request.getParameter("tpf");
        String pstr = request.getParameter("tpp");
        String cstr = request.getParameter("tpc");
        String ptstr = request.getParameter("tppt");
        String sstr = request.getParameter("tps");
        String headpic = request.getParameter("headpic");

        JoinGame joinGame = new JoinGame();
        joinGame.setWechatId(wechatId);
        joinGame.setName(name);
        joinGame.setJob(job);
        joinGame.setPhone(phone);
        joinGame.setRefereeWechatId(refereeWechatId);
        joinGame.setRefereeWechat(refereeWechat);
        joinGame.setSex(NumberTools.stringToInt(sexStr));
        joinGame.setCorporation(corporation);
        joinGame.setRegisterTime(TimeTools.parserYYYYMMDD(registerTimeStr));
        joinGame.setCorporationPeopleNum(NumberTools.stringToInt(corPeopleNumStr));
        joinGame.setProjectName(projectName);
        joinGame.setProjectDesc(projectDesc);
        joinGame.setTpFinancing(NumberTools.stringToInt(fstr));
        joinGame.setTpPrice(NumberTools.stringToInt(pstr));
        joinGame.setTpContacts(NumberTools.stringToInt(cstr));
        joinGame.setTpPinTui(NumberTools.stringToInt(ptstr));
        joinGame.setTpStudy(NumberTools.stringToInt(sstr));
        joinGame.setHeadPic(headpic);
        joinGame.setCreateTime(TimeTools.getCurrentDate());

        int el = this.joinGameDao.addOne(joinGame);

        BaseResponse info = new BaseResponse();
        if (el > 0)
            info.setCode(1);
        else {
            info.setCode(0);
            info.setMessage("创建失败");
        }
        outWrite(response, info);

        return null;
    }


    @RequestMapping(value="list.do")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {

        String pnoStr = request.getParameter("pno");
        String psizeStr = request.getParameter("psize");

        int pno = NumberTools.stringToInt(pnoStr);
        int psize = NumberTools.stringToInt(psizeStr);
        if (pno < 0)
            pno = 0;
        if (psize < 0)
            psize = 10;

        int start = pno*psize;
        int end = psize;

        ModelAndView modelAndView = new ModelAndView();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("start", start);
        map.put("end", end);
        List<JoinGame> joinGameList = this.joinGameDao.getList(map);
        for (int i=0; joinGameList!=null&&i<joinGameList.size(); i++) {
            JoinGame joinGame = joinGameList.get(i);
            if (joinGame == null) continue;
            String wechatid = joinGame.getWechatId();
            Integer rtimes = this.joinGameDao.getRefereeTimes(wechatid);
            //查询这个id推荐了多少人
            joinGame.setTjtimes(rtimes);
        }
        modelAndView.setViewName("game/list");
        modelAndView.addObject("joinGameList", joinGameList);
        return modelAndView;
    }


    @RequestMapping(value="list.json")
    public ModelAndView listjson(HttpServletRequest request, HttpServletResponse response) {

        String pnoStr = request.getParameter("pno");
        String psizeStr = request.getParameter("psize");

        int pno = NumberTools.stringToInt(pnoStr);
        int psize = NumberTools.stringToInt(psizeStr);
        if (pno < 0)
            pno = 0;
        if (psize < 0)
            psize = 10;

        int start = pno*psize;
        int end = psize;

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("start", start);
        map.put("end", end);
        List<JoinGame> joinGameList = this.joinGameDao.getList(map);
        for (int i=0; joinGameList!=null&&i<joinGameList.size(); i++) {
            JoinGame joinGame = joinGameList.get(i);
            if (joinGame == null) continue;
            String wechatid = joinGame.getWechatId();
            Integer rtimes = this.joinGameDao.getRefereeTimes(wechatid);
            //查询这个id推荐了多少人
            joinGame.setTjtimes(rtimes);
            if (joinGame.getRegisterTime() != null)
                joinGame.setRegisterTimeLong(joinGame.getRegisterTime().getTime());
            int sex = joinGame.getSex();
            if (sex == 1)
                joinGame.setSexDesc("男");
            else
                joinGame.setSexDesc("女");
        }

        BaseResponse baseResponse = new BaseResponse();
        if (joinGameList != null) {
            baseResponse.setCode(1);
            baseResponse.setData(joinGameList);
            baseResponse.setRows(joinGameList);
            baseResponse.setTotal(joinGameList.size());
        } else {
            baseResponse.setCode(0);
            baseResponse.setMessage("暂无数据");
        }

        outWrite(response, baseResponse);

        return null;
    }

    @RequestMapping(value="cimg.json")
    public ModelAndView createImage(HttpServletRequest request, HttpServletResponse response) {

        String name = "大侠";
        try {
            name = URLDecoder.decode(request.getParameter("name"),"utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String openid = "";
        try {
            openid = URLDecoder.decode(request.getParameter("openid"),"utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("wechatId", openid);
        JoinGame joinGame = this.joinGameDao.getOne(map);
        String suggestName = "";
        if (joinGame != null) {
            suggestName = joinGame.getName();
        }

        String indexPath = "http://sai.syzckjlm.com/miku/";
        String bgPath = "/data/bg.png";
        //String url = "http://114.215.166.232/miku/index.html?suggestId="+openid+"&suggestName="+suggestName;
        String url = indexPath+"index.html?suggestId="+openid+"&suggestName="+suggestName;
        String qrcodePath = ImageTools.createQrcode(url);
        String imagePath = ImageTools.createImage(name, bgPath, qrcodePath,936, 1082);

        BaseResponse baseResponse = new BaseResponse();
        if (StringTools.isNotEmpty(imagePath)) {
            baseResponse.setCode(1);
            //baseResponse.setData("http://114.215.166.232/miku/"+imagePath);
            baseResponse.setData(indexPath+imagePath);
        } else {
            baseResponse.setCode(0);
        }
        outWrite(response, baseResponse);
        return null;
    }


    @RequestMapping(value="getToken.json")
    public ModelAndView getAccessToken(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx48b6a4660d0bebce&secret=2e13e2525fb42ec976479191de84d958&code=CODE&grant_type=authorization_code&pass_ticket=Yu4%2FOeoH7eVWtvg3OdPtICcZA1la6hXJ5oIpD0tKV7NkRVCuiAXQCuva4UlsLWaN";
        url = url.replace("CODE",code);
        com.miku.web.entity.weixin.BaseResponse baseResponse = NetWorkCenter.get(url);
        String resultJson = isSuccess(baseResponse.getErrcode()) ? baseResponse.getErrmsg() : baseResponse.toString();
        GetTokenResponse tokenResponse = JSONUtil.parse(resultJson, GetTokenResponse.class);

        try {
            OutputStream os = response.getOutputStream();
            os.write(JSONTools.toJson(tokenResponse).getBytes());
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @RequestMapping(value="getuser.json")
    public ModelAndView getUserInfo(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx48b6a4660d0bebce&secret=2e13e2525fb42ec976479191de84d958&code=CODE&grant_type=authorization_code&pass_ticket=Yu4%2FOeoH7eVWtvg3OdPtICcZA1la6hXJ5oIpD0tKV7NkRVCuiAXQCuva4UlsLWaN";
        url = url.replace("CODE",code);
        com.miku.web.entity.weixin.BaseResponse baseResponse = NetWorkCenter.get(url);
        String resultJson = isSuccess(baseResponse.getErrcode()) ? baseResponse.getErrmsg() : baseResponse.toString();
        GetTokenResponse tokenResponse = JSONUtil.parse(resultJson, GetTokenResponse.class);

        if (tokenResponse != null) {
            String openid = tokenResponse.getOpenid();
            String token = tokenResponse.getAccessToken();
            String uurl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

            try {
                uurl = uurl.replace("OPENID", openid).replace("ACCESS_TOKEN", token);
                com.miku.web.entity.weixin.BaseResponse uinfoResponse = NetWorkCenter.get(uurl);

                OutputStream os = response.getOutputStream();
                os.write(uinfoResponse.getErrmsg().getBytes());
                os.flush();
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    protected boolean isSuccess(String errCode) {
        return ResultType.SUCCESS.getCode().toString().equals(errCode);
    }
}
