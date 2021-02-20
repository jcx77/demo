package com.example.springboot.test;



public class UserController {
    @MyAutowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }
}
