/**  
 * @Title: JSPController.java
 * @Description: TODO
 * @author H2605718
 * @date 2018/7/3
 */
package com.example.authenticatordemo;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.main.Main;

/**
 * ClassName: JSPController 
 * @Description: TODO
 * @author H2605718
 * @date 2018/7/3
 */
@Controller
@RequestMapping("/")
public class JSPController {
    private String hello;

    @RequestMapping("/helloJsp")
    public String helloJsp(Map<String,Object> map){
        System.out.println("HelloController.helloJsp().hello=hello");
        map.put("hello", hello);
        return "index";
    }   
    
    @ResponseBody
    @RequestMapping(value = "/getCode", method = RequestMethod.POST,produces={"text/html;charset=UTF-8"})
	public String getCode(){
		
		return Main.getAuthCode();
	}
    
    @ResponseBody
    @RequestMapping(value = "/getInterval", method = RequestMethod.POST,produces={"text/html;charset=UTF-8"})
	public String getInterval(){
		
		return Main.getInterval();
	}
}