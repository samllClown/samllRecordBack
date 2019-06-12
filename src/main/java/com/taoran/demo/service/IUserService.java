package com.taoran.demo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface IUserService {

    /**
     * 获取登陆情况下返回信息
     * @return
     */
    public Map<String,Object> getLogin(HttpServletRequest request, HttpServletResponse response)  throws Exception;

}
