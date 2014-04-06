package com.github.diseng.action;

import com.github.diseng.dao.UserDao;
import com.github.diseng.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dengqinglin on 14-4-4.
 */
@Controller
public class UserAction {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/user/get")
    public ModelAndView test(@RequestParam("id")Integer id){
        List<User> userList = userDao.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("username",userList.get(id).getUsername());
        return  modelAndView;
    }

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/user/add")
    public ModelAndView add(@RequestParam("username")String username){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setUsername(username);
        user.setPassword("123456");
        user.setEmail("heeh@163.com");
        userDao.save(user);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
