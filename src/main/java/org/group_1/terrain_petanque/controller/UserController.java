package org.group_1.terrain_petanque.controller;

import java.util.List;

import org.group_1.terrain_petanque.dto.UserDTO;
import org.group_1.terrain_petanque.dto.UserInputDTO;
import org.group_1.terrain_petanque.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class represents the controller of a user.
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    /**
     * This attribute represents the service.
     */
    private final UserService userService;



    /**
     * The constructors.
     * 
     * @param The user's service.
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }



    /**
     * This method returns all users.
     * 
     * @return Return all users.
     */
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUsers());
    }



    /**
     * This method returns a specific user.
     * 
     * @param id The user's id.
     * @return Return the specific user.
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable int id) {
        try {
            return ResponseEntity.ok(userService.getUser(id));
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }



    /**
     * This method creates a user.
     * 
     * @param userInput The user's informations.
     * @return Return the created user.
     */
    @PostMapping
    public ResponseEntity<UserDTO> createUser(
        @RequestBody UserInputDTO userInput
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(userInput));
    }



    /**
     * This method fully updates a user.
     * 
     * @param id The user's id.
     * @param userInput The user's informations.
     * @return Return the updated user.
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> fullUpdateUser(
        @PathVariable int id,
        @RequestBody UserInputDTO userInput
    ) {
        try {
            return ResponseEntity.ok(userService.fullUpdateUser(id, userInput));
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }



    /**
     * This method partially updates a user.
     * 
     * @param id The user's id.
     * @param userInput The user's informations.
     * @return Return the updated user.
     */
    @PatchMapping("/{id}")
    public ResponseEntity<UserDTO> partialUpdateUser(
        @PathVariable int id,
        @RequestBody UserInputDTO userInput
    ) {
        try {
            return ResponseEntity.ok(userService.partialUpdateUser(id, userInput));
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }



    /**
     * This method deletes a user.
     * 
     * @param id the user's id.
     * @return Return no content as the deleted user.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
