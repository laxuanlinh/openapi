package com.example.openapi.controllers;

import com.example.openapi.api.UserApi;
import com.example.openapi.client.api.BookApi;
import com.example.openapi.client.api.OrderApi;
import com.example.openapi.model.User;
import com.example.openapi.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController implements UserApi {

    @Autowired
    private BookApi bookApi;

    @Autowired
    private OrderApi orderApi;

    @Override
    public ResponseEntity<User> getUser() {
        var user = new User(1l, "Linh", "laxuanlong@gmail.com");
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<User> getUserById(String id) {
        return ResponseEntity.ok(new User(2l, "still Linh", "laxuanlong@gmail.com"));
    }

    @Override
    public ResponseEntity<UserProfile> getUserProfile(String id) {
        System.out.println(bookApi.getBooks());
        System.out.println(orderApi.getOrder());
        return ResponseEntity.ok(new UserProfile("123"));
    }
}
