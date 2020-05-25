package cn.edu.zju.web.controller;

import cn.edu.zju.bean.DrugLabel;
import cn.edu.zju.bean.User;
import cn.edu.zju.dao.UserDao;
import cn.edu.zju.filter.AuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.desktop.SystemEventListener;
import java.util.List;

@Controller
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("email") String email,
                           @RequestParam("phone") String phone,
                           HttpServletRequest request
    ) {
        User user = new User();
        user.setPhone(phone);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        boolean b = userDao.Search(user)[0];
        if (!b) {
            userDao.registration(user);
            return "index";
        } else {
            System.out.println("error");
            request.setAttribute("error", "ERROR:already been registered");
            return "registerForm";
        }


    }


    @RequestMapping(path = "/signin", method = RequestMethod.POST)
    public String doLogin(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          HttpServletRequest request
    ) {
        User user = new User(username, password);
        boolean b = userDao.Search(user)[1];
        if (b) {
            HttpSession session = request.getSession();
            session.setAttribute(AuthenticationFilter.ROLE_VIEW_DOSING_GUIDELINE, 1);
            session.setAttribute(AuthenticationFilter.USERNAME, username);
            return "drugs";
        } else {
            System.out.println("error");
            return "signin";
        }


    }

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public String search() {
        return "searchpage";
    }

    @RequestMapping(path = "/searchDrugs", method = RequestMethod.POST)
    public ModelAndView searchDrugs(@RequestParam("query") String query,
                         HttpServletRequest request) {
        List<DrugLabel> druginfo =  userDao.searchdrug(query);

        ModelAndView q = new ModelAndView();
        q.addObject("druginfo", druginfo);
        q.setViewName("searchresult");
        return q;
    }


    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "index";
    }


    @RequestMapping(path = "aboutus")
    private String showAboutUs() {
        return "aboutus";
    }
}


