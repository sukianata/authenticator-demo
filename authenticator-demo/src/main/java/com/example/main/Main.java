/**  
 * @Title: Main.java
 * @Description: TODO
 * @author H2605718
 * @date 2018/7/3
 */
package com.example.main;

import java.net.URI;

import com.example.other.Token;
import com.example.other.TokenCode;
import com.example.util.QRCodeDecoderHandler;
import com.example.util.URIUtil;

/**
 * ClassName: Main 
 * @Description: TODO
 * @author H2605718
 * @date 2018/7/3
 */
public class Main {
	
	private static Token token; 
	
	/*
	 * 1、讀取二維碼照片-->獲取內容：otpauth://totp/LinOTP:TOTP0001AAAB:web%20ui%20generated?secret=CFDCYM5IC72YLKMJ6T766V7ZFVOPLPC6&period=60&issuer=LinOTP
	 * 2、創建Token
	 * 3、根據Token生成動態密碼
	 */
	public static void main(String[] args) {
		//二維碼位置
		String imgPath="D:/qrcode/linotp2.png";
		
		//讀取二維碼，返回內容
		String text=QRCodeDecoderHandler.decoderQRCode(imgPath);
		
		//根據二維碼內容創建Token
		addTokenAndFinish(text);
		
		//根據Token獲取動態密碼
		TokenCode tokenCode=token.generateCodes();
		
		//輸出密碼
		System.out.println(tokenCode.getCurrentCode());
		
	}
	public static String getAuthCode(){
		//二維碼位置
		String imgPath="D:/qrcode/linotp.png";
		
		//讀取二維碼，返回內容
		String text=QRCodeDecoderHandler.decoderQRCode(imgPath);
		
		//根據二維碼內容創建Token
		addTokenAndFinish(text);
		
		//根據Token獲取動態密碼
		TokenCode tokenCode=token.generateCodes();
		
		return tokenCode.getCurrentCode();
		
	}
	
	public static String getInterval(){
		//二維碼位置
		String imgPath="D:/qrcode/linotp.png";
		
		//讀取二維碼，返回內容
		String text=QRCodeDecoderHandler.decoderQRCode(imgPath);
		
		return URIUtil.getQueryParameter(URI.create(text).getQuery(), "period");
	}
	
	private static void addTokenAndFinish(String text){
        try {
            token = new Token(text);//初始化令牌
        } catch (Token.TokenUriInvalidException e) {
            e.printStackTrace();
        }
		
	}
}
