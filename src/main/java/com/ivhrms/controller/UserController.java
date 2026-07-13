package com.ivhrms.controller;

import com.ivhrms.model.User;
import com.ivhrms.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{login_id}")
    public User getUserByLoginId(@PathVariable("login_id") String loginId) {
        return userService.getUserByLoginId(loginId);
    }

    @PostMapping("/createuser")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/createusers")
    public List<User> createUsers(@RequestBody List<User> users) {
        return userService.createUsers(users);
    }

    @DeleteMapping("/deleteuser/{login_id}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable("login_id") String loginId) {
        userService.deleteUser(loginId);
        return ResponseEntity.ok(Map.of("message", "User deleted successfully"));
    }

    @PutMapping("/disableuser/{login_id}/disable")
    public ResponseEntity<Map<String, String>> disableUser(@PathVariable("login_id") String loginId) {
        userService.disableUser(loginId);
        return ResponseEntity.ok(Map.of("message", "User disabled successfully"));
    }

    @PutMapping("/enableuser/{login_id}/enable")
    public ResponseEntity<Map<String, String>> enableUser(@PathVariable("login_id") String loginId) {
        userService.enableUser(loginId);
        return ResponseEntity.ok(Map.of("message", "User enabled successfully"));
    }

    @PutMapping("/updateuser/{login_id}")
    public User updateUser(@PathVariable("login_id") String loginId, @RequestBody Map<String, Object> updates) {
        return userService.updateUser(loginId, updates);
    }
}
