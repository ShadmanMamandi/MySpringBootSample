package com.grading.gradingStudentSystem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private UserRepository userRepository;


   /* @RequestMapping(value="/list", method = RequestMethod.GET)

    public String showTodos(ModelMap model){

       // String name = (String) model.get("shiva");

        model.put("todos", userServiceImp.getAllUsers());

        return "list-todos";

    }*/


   // @PutMapping("user")
    @RequestMapping(value="/user", method=RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity UpdateUser(@RequestBody UserEntity userEntity) {

        return userServiceImp.addUser(userEntity);

    }

    @RequestMapping(value="/delete", method=RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void DeletUser(@RequestParam(defaultValue = "1") int id) {

         userServiceImp.deleteUser(id);

    }


    @RequestMapping(value="/get" , method = RequestMethod.GET)
    @ResponseBody
    public UserEntity GetUserByID(@RequestParam(defaultValue = "1") int id) {

        return userServiceImp.getUserById(id);

    }


    @RequestMapping(value="/lists" , method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Iterable GetAllUsers() {


                return userServiceImp.getAllUsers();

    }
}
