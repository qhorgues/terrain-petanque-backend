package com.polytech.terrainpetanque.controller;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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

import com.polytech.terrainpetanque.JWTGenerator;
import com.polytech.terrainpetanque.dto.input.UserInputDTO;
import com.polytech.terrainpetanque.dto.output.UserOutputDTO;
import com.polytech.terrainpetanque.service.UserService;

import lombok.RequiredArgsConstructor;

/**
 * This class represents the controller of the users.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    /**
     * This attribute represents the service for the users.
     */
    private final UserService userService;



    /**
     * This attribute represents the generator of JSON Web Token.
     */
    private final JWTGenerator jwtGenerator;



    /**
     * This method creates a user.
     *
     * @param userInput The user's informations.
     * @return Return the created user.
     */
    @PostMapping
    public ResponseEntity<UserOutputDTO> createUser(@RequestBody UserInputDTO userInput) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userInput));
    }



    /**
     * This method do the login of a user.
     *
     * @param userInput The user's credential.
     * @return Return a ... if the credential are valid. Unauthaurized if not. And not found if the user's doesn't exist.
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserInputDTO userInput) {
        try {
            UserOutputDTO result = userService.checkCredential(userInput);
            if (result == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            String token = jwtGenerator.generateToken(result);
            return ResponseEntity.ok("{\"token\":\""+ token + "\"}");
        }
        catch (NotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }



    /**
     * This method gets all the users.
     *
     * @return Return all the users.
     */
    @GetMapping
    public ResponseEntity<List<UserOutputDTO>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUsers());
    }



    /**
     * This method gets a specific user.
     *
     * @param id The user's id.
     * @return Return the specific user. Return not found if the user doesn't exist.
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserOutputDTO> getUser(@PathVariable int id) {
        try {
            return ResponseEntity.ok(userService.getUser(id));
        } catch (NotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }



    /**
     * This method partially updates a user.
     *
     * @param id The user's id.
     * @param userInput The user's informations.
     * @return Return the updated user. Return not found if the user doesn't exist.
     */
    @PatchMapping("/{id}")
    public ResponseEntity<UserOutputDTO> partialUpdateUser(@PathVariable int id, @RequestBody UserInputDTO userInput) {
        try {
            return ResponseEntity.ok(userService.partialUpdateUser(id, userInput));
        } catch (NotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }



    /**
     * This method fully updates a user.
     *
     * @param id The user's id.
     * @param userInput The user's informations.
     * @return Return the updated user. Return not found if the user doesn't exist.
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserOutputDTO> fullUpdateUser(@PathVariable int id, @RequestBody UserInputDTO userInput) {
        try {
            return ResponseEntity.ok(userService.fullUpdateUser(id, userInput));
        } catch (NotFoundException exception) {
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
