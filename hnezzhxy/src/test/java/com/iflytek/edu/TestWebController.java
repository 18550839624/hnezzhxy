package com.iflytek.edu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


/**
 * @author 叶清
 * @create 2020-07-13-15:18
 **/
@SpringBootTest
public class TestWebController {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/test").param("id","1"));
       // System.out.println("result : "+responseString);
    }

}
