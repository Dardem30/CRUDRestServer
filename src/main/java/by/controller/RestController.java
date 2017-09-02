package by.controller;

import by.model.User;
import by.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Роман on 30.08.2017.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/restController")
public class RestController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET
            ,produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<User> getUserById(@PathVariable int id){
        User user=userService.getUserById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    @RequestMapping(value = "/users",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<User>> listUser(){
        List<User> userList=userService.getListUser();
        return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
    }
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public ResponseEntity<User> saveUser(@RequestBody User user){
        userService.saveUser(user);
        return new ResponseEntity<User>(user,HttpStatus.CREATED);
    }
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User user){
        userService.updateUser(user);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<User> updateUser(@PathVariable int id){
        User user=userService.getUserById(id);
        userService.deleteUser(user);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
}
