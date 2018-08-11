/**  
 * @Title: URIUtil.java
 * @Description: TODO
 * @author H2605718
 * @date 2018/7/3
 */
package com.example.util;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: URIUtil 
 * @Description: 處理uri，相當於對URI功能的擴展
 * @author H2605718
 * @date 2018/7/3
 */
public class URIUtil {

	public static String getQueryParameter(String param,String key){
		
		String[] arrays=param.split("&");
		Map<String,String> map=new HashMap<String, String>();
		for (int i = 0; i < arrays.length; i++) {
			String k=arrays[i].split("=")[0];
			String v=arrays[i].split("=")[1];
			map.put(k, v);
		}
		return map.get(key);
	}
	public static void main(String[] args) {
		String params="secret=B4SG356VAVBQBBQL3VMVEKXPKQ3VBIJA&period=60&issuer=LinOTP";
		System.out.println(getQueryParameter(params, "secret"));
	}
}
