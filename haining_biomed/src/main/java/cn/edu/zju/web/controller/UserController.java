package cn.edu.zju.web.controller;

import cn.edu.zju.bean.User;
import cn.edu.zju.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("email") String email,
                           @RequestParam("phone") String phone
    ) {
        User u = new User();
        u.setPhone(phone);
        u.setUsername(username);
        u.setPassword(password);
        u.setEmail(email);
        UserDao dao = new UserDao();
        dao.registration(u);
    }


    @RequestMapping(path = "/doLogin",method = RequestMethod.POST)
    public String doLogin(@RequestParam("username") String username,
                        @RequestParam("password") String password
                        ){





    }
}
