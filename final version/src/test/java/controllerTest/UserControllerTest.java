package controllerTest;

import cn.edu.zju.bean.User;
import cn.edu.zju.dao.UserDao;
import cn.edu.zju.web.controller.UserController;
import com.google.gson.Gson;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)

public class UserControllerTest {
    @Autowired
    private UserDao userDao;

    @Autowired
    MockMvc mockMvc;
    WebApplicationContext webApplicationContext;
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        User user1 = new User(8888,"Yes","pass","Yes@test.com","12345"); // will be tested as correct account
        User user2 = new User(9999,"No","nopass","No@test.com","12345");
        Assert.assertFalse(userDao.Search(user1)[0]);
        Assert.assertFalse(userDao.Search(user2)[0]);
        userDao.registration(user1);
    }
    @Test
    public void RegisterandLoginTest() throws Exception {
        String url = "/views/signin";
        ResultActions resultAction1 = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET,url).
                param("username","Yes").
                param("password","pass"));
        resultAction1.andDo(MockMvcResultHandlers.print()).
                andExpect(ResultMatcher.matchAll()).
                andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        ResultActions resultAction2 = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET,url).
                param("username","No").
                param("password","nopass"));
        resultAction2.andDo(MockMvcResultHandlers.print()).
                andExpect(ResultMatcher.matchAll()).
                andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    }
    @After
    public void cleanup(){
        userDao.deleteByName("Yes");
    }

}
