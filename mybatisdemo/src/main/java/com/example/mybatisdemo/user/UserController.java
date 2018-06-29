package com.example.mybatisdemo.user;

import com.example.mybatisdemo.response.ResponseCode;
import com.example.mybatisdemo.response.ResponseResult;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    @RequiresRoles("admin")
    public ResponseResult getUserList(HttpServletRequest request) {
        return new ResponseResult(ResponseCode.Success, "", userService.findAll());
    }

    @RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
    public ResponseResult unauth() {
        return new ResponseResult(ResponseCode.Unauthorized, "", null);
    }
}
