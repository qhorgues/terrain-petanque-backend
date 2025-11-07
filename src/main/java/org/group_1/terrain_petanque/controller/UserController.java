package org.group_1.terrain_petanque.controller;

import org.group_1.terrain_petanque.dto.UserDTO;
import org.group_1.terrain_petanque.dto.UserInputDTO;
import org.group_1.terrain_petanque.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable int id) {
        try {
            return ResponseEntity.ok(userService.getUser(id));
        }
        catch(Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserInputDTO userInput) {
        return ResponseEntity.ok(userService.addUser(userInput));
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable int id,
                                                            @RequestBody UserInputDTO userInput) {
        try {
            return ResponseEntity.ok(userService.updateUser(id, userInput));
        }
        catch(Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
