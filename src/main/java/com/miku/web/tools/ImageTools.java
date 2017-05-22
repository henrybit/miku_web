package com.miku.web.tools;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 图片工具
 * Created by henrybit on 2017/4/8.
 * @version 1.0
 */
public class ImageTools {

    /**
     * 创建一张图片
     * @param keywords 关键字
     * @param bgPath 背景图地址
     * @param width 图片宽度
     * @param height 图片高度
     * @return String-图片生成的存放路径
     */
    public static String createImage(String keywords, String bgPath, int width, int height) {
        String outPath = "/data/"+System.currentTimeMillis()+".png";
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        try {
            BufferedImage bg = ImageIO.read(new File(bgPath));
            graphics.drawImage(bg, 0, 0, null);
            // Font font=new Font("楷体",Font.PLAIN,40);
            Font font=new Font("sans-serif",Font.PLAIN,40);
            graphics.setFont(font);
            graphics.setColor(new Color(0,0,0));//设置黑色字体,同样可以graphics.setColor(Color.black);
            graphics.drawString(keywords+"英雄", 280, 520);
            ImageIO.write(image, "PNG", new File(outPath));//生成图片方法一
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            //生成图片方法二结束
            graphics.dispose();//释放资源
        }
        return outPath;
    }

    public static String createImage(String keywords, String bgPath, String qrPath,int width, int height) {
        String outPath = "/data/"+System.currentTimeMillis()+".png";
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        try {
            BufferedImage bg = ImageIO.read(new File(bgPath));
            BufferedImage qrcode = ImageIO.read(new File(qrPath));
            graphics.drawImage(bg, 0, 0, null);
            graphics.drawImage(qrcode,  206, 675, null);
            // graphics.drawImage(qrcode,  206, 600 + 75, null);
            // Font font=new Font("楷体",Font.PLAIN,40);
            Font font=new Font("sans-serif",Font.PLAIN,40);
            graphics.setFont(font);
            graphics.setColor(new Color(0,0,0));//设置黑色字体,同样可以graphics.setColor(Color.black);
            // graphics.drawString(keywords, 280 + 45, 520);
            graphics.drawString(keywords, 355, 520);
            ImageIO.write(image, "PNG", new File(outPath));//生成图片方法一
            File file = new File(outPath);
            file.setExecutable(true, false);//设置可执行权限
            file.setReadable(true, false);//设置可读权限
            file.setWritable(true,false);//设置可写权限
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            //生成图片方法二结束
            graphics.dispose();//释放资源
        }
        return outPath;
    }

    /**
     * 创建一个二维码
     * @param url
     * @return string
     */
    public static String createQrcode(String url) {
        try {
            String filePath = "/data/qrcode_"+System.currentTimeMillis()+".png";
            String content = url;// 内容
            int width = 190; // 图像宽度
            int height = 190; // 图像高度
            String format = "png";// 图像类型
            Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵
            File file = new File(filePath);
            OutputStream outputStream = new FileOutputStream(file);
            MatrixToImageWriter.writeToStream(bitMatrix, format, outputStream);
            return filePath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        String qrcode = createQrcode("http://www.baidu.com");

        int imageWidth = 936;//图片的宽度
        int imageHeight = 1082;//图片的高度

        createImage("小二","/data/bg.png", qrcode, imageWidth, imageHeight);
    }

}
