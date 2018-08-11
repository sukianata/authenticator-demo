package com.example.util;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
 
import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.data.QRCodeImage;
import jp.sourceforge.qrcode.exception.DecodingFailedException;

/**
 * ClassName: QRCodeDecoderHandler 
 * @Description: 解析二維碼
 * @author H2605718
 * @date 2018/7/3
 */
public class QRCodeDecoderHandler {
 
    /**
     * read the qrcode
     * @param imgPath
     * @return String
     */
    public static String decoderQRCode(String imgPath) {
 
        // QRCode 二维码图片的文件
        File imageFile = new File(imgPath);
 
        BufferedImage bufImg = null;
        String decodedData = null;
        try {
            bufImg = ImageIO.read(imageFile);
 
            QRCodeDecoder decoder = new QRCodeDecoder();
            decodedData = new String(decoder.decode(new J2SEImage(bufImg)),"utf-8");
 
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } catch (DecodingFailedException dfe) {
            System.out.println("Error: " + dfe.getMessage());
            dfe.printStackTrace();
        }
        return decodedData;
    }
 
 
    static class J2SEImage implements QRCodeImage {
        BufferedImage bufImg;
 
        public J2SEImage(BufferedImage bufImg) {
            this.bufImg = bufImg;
        }
 
        public int getWidth() {
            return bufImg.getWidth();
        }
 
        public int getHeight() {
            return bufImg.getHeight();
        }
 
        public int getPixel(int x, int y) {
            return bufImg.getRGB(x, y);
        }
 
    }
}
