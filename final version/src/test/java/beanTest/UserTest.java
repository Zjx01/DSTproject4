package beanTest;

import cn.edu.zju.bean.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User a = new User();
    @Test
    void TestUser(){
        a.setEmail("email");
        a.setPassword("password");
        a.setPhone("phone number");
        a.setUsername("name");
        a.setId(12345);
        Assert.assertEquals("email",a.getEmail());
        Assert.assertEquals("password",a.getPassword());
        Assert.assertEquals("phone number",a.getPhone());
        Assert.assertEquals("name",a.getUsername());
        Assert.assertEquals(12345,a.getId());

    }
}