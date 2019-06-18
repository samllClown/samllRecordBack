package com.taoran.demo.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component("prinWriterUtils")
public class PrinWriterUtils {

    public void outUserInfo(HttpServletResponse response,Object data){
        PrintWriter out = null;
        try {

            out = response.getWriter();

            out.print(JSON.toJSON(data));

        } catch (IOException e) {
            e.printStackTrace();
            out.print("");
            System.out.println("返回值异常");
        }finally {
            out.flush();
            out.close();
        }

    }
}
