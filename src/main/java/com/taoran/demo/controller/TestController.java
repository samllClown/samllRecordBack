package com.taoran.demo.controller;

import com.taoran.demo.entity.UserEntity;
import com.taoran.demo.service.IUserService;
import com.taoran.demo.utils.PrinWriterUtils;
import com.taoran.demo.utils.RSAUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    @Autowired
    private PrinWriterUtils prinWriterUtils;

    @Autowired
    private IUserService userService;

    @RequestMapping("/phoneLogin")
    @ResponseBody
    public void phoneLogin(HttpServletRequest request, HttpServletResponse response){

        Map<String, Object> map = null;

        try {
            map = userService.getLogin(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("解密异常");
        }

        prinWriterUtils.outUserInfo(response,map);

    }

    @RequestMapping(value = "/phoneUserCK")
    @ResponseBody
    public void phoneUserCK(HttpServletRequest request,HttpServletResponse response,UserEntity userEntity){

        Map<String,Object> map = new HashMap<>();

        Map<String,Object> userMap = null;

        try{
            userMap = userService.addUser(userEntity);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("uuid未传入");
        }

        map.putAll(userMap);
        prinWriterUtils.outUserInfo(response,map);

    }
}
