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

        String username = request.getParameter("userName");
        String password = request.getParameter("userPassword")== "" ? "":new String(RSAUtils.decryptByPrivateKey(RSAUtils.decryptBASE64(request.getParameter("userPassword")), RSAUtils.LOGIN_PRIVATE_KEY));

        //模拟登陆数据
        userEntity = new UserEntity(username,password,"","");

        String result = userEntity == null?"ERROR":"SUCCESS";

        map.put("RESULT",result);
        map.put("UserEntity",userEntity);

        return map;
    }

    @Override
    public Map<String, Object> addUser(UserEntity userEntity) throws Exception {

        HashMap<String,Object> map = new HashMap<String,Object>();

        String userUuid = userEntity.getUserUuid();

        String result = userEntity.getUserUuid().equals("") ? "ERROR":"SUCCESS";

        map.put("result",result);

        System.out.println(result);

        if(result.equals("SUCCESS")){
            map.put("userEntity",userEntity);
        }
        return map;
    }
}
