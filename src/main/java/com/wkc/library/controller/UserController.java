package com.wkc.library.controller;

import com.wkc.library.entity.R;
import com.wkc.library.entity.User;
import com.wkc.library.mapper.UserMapper;
import com.wkc.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xiaoniao
 * @date 2023/2/17 13:28
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

//   @PostMapping("/login")
//    public String login(HttpServletRequest request){
//       String username = request.getParameter("username");
//       String password = request.getParameter("password");
//       LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper();
//       queryWrapper.eq(User::getName,username).eq(User::getPassword,password);
//       if(userService.getOne(queryWrapper) == null){
//           return "登录失败";
//       }
//       return "登录成功";
//   }

    @PostMapping("login")
    public R login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userMapper.login(username, password);
        if (user != null){
            return R.success("用户登录成功");
        }else {
            return R.error("账号或密码错误，登录失败");
        }
    }

    @PostMapping("logon")
    public R logon(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        String address = request.getParameter("address");
        Integer age1 = Integer.parseInt(age);
        User user = new User();
        user.setName(username);
        user.setAge(age1);
        user.setPassword(password);
        user.setAddress(address);
        if(userMapper.selectByName(user) == null){
            Integer result = userMapper.logon(user);
            if(result > 0){
                return R.success("用户注册成功");
            }
            return R.error("用户注册失败");
        }
        return R.error("该用户账号已存在，请重新输入");
    }

}
