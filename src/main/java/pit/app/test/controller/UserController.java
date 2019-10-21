package pit.app.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pit.app.test.entity.User;
import pit.app.test.service.UserService;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getByIdUser(@PathVariable("id") long userId){
        return userService.getUserById(userId);
    }

    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    @ResponseBody
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void deleteUser(@PathVariable("id") long userId) {
        userService.deleteUser(userId);
    }

    @RequestMapping(value = "/user/auth/{email}/{password}", method = RequestMethod.GET)
    @ResponseBody
    public User getAuth(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.getUserByEmailAndPassword(email, password);
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    @ResponseBody
    public int updateUser(@RequestBody User user) {
        return userService.updateUser(user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getPassword(), user.getPhone(), user.getId());
    }

}








