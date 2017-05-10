package com.miku.web.tools;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;

/**
 * 二维码工具类
 * Created by henrybit on 2017/3/15.
 * @version 1.0
 */
public class QrCodeTools {

    private final static String BASE_FILE_PATH = "/develop/qrcode/";

    /**
     * 返回生成后二维码路径
     * @param url
     * @return String 文件路径
     */
    public static String createQrCode(String url) {
        if (StringTools.isEmpty(url))
            return null;
        try {
            String picFormat = "png";
            String filePath = BASE_FILE_PATH + System.currentTimeMillis()+ "." + picFormat;
            File file = new File(filePath);
//            url = new String(url.getBytes("GBK"), "ISO-8859-1");
            Hashtable hints = new Hashtable();
            BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, 200, 200, hints);
            MatrixToImageWriter.writeToFile(bitMatrix, picFormat, file);
            return filePath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 从二维码解出相应的内容
     * @param filePath 图片地址
     * @return String 内容
     */
    public static String decodeQrCode(String filePath) {
        if (StringTools.isEmpty(filePath))
            return null;
        try {
            File file = new File(filePath);
            Result result = null;
            BufferedImage image = null;

            image = ImageIO.read(file);
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            Hashtable<Object, Object> hints = new Hashtable<Object, Object>();
            hints.put(DecodeHintType.CHARACTER_SET, "utf8");

            result = new MultiFormatReader().decode(bitmap);
            String text = result.getText();
            return text;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) throws Exception{
        String url = "http://blog.csdn.net/wangwei_cq/article/details/9224381";
        String filePath = createQrCode(url);
        System.out.println(filePath);
        String text = decodeQrCode(filePath);
        System.out.println(text);
    }

}
