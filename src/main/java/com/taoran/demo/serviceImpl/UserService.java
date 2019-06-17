package com.taoran.demo.serviceImpl;

import com.taoran.demo.entity.UserEntity;
import com.taoran.demo.service.IUserService;
import com.taoran.demo.utils.RSAUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService implements IUserService {
    @Override
    public Map<String, Object> getLogin(HttpServletRequest request, HttpServletResponse response) throws Exception{

        HashMap<String, Object> map = new HashMap<String,Object>();
        UserEntity userEntity = null;

        String username = request.getParameter("username");
        String password = request.getParameter("password")== "" ? "":new String(RSAUtils.decryptByPrivateKey(RSAUtils.decryptBASE64(request.getParameter("password")), RSAUtils.LOGIN_PRIVATE_KEY));
        userEntity = new UserEntity(username,password);


        String result = userEntity == null?"ERROR":"SUCCESS";

        map.put("RESULT",result);
        map.put("UserEntity",userEntity);

        return map;
    }

    @Override
    public Map<String, Object> CkUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HashMap<String,Object> map = new HashMap<String,Object>();

        String userUuid = request.getParameter("userUuid");

        return map;
    }
}
