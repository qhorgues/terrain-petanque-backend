package com.polytech.terrainpetanque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.polytech.terrainpetanque.dto.input.UserInputDTO;
import com.polytech.terrainpetanque.dto.mapper.UserMapper;
import com.polytech.terrainpetanque.dto.output.UserOutputDTO;
import com.polytech.terrainpetanque.entity.User;
import com.polytech.terrainpetanque.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

/**
 * This class represent the service to handle the users.
 */
@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

    /**
     * This attribute represents the repository for the users.
     */
    private final UserRepository userRepository;



    /**
     * This attribute represents the mapper for the users.
     */
    private final UserMapper userMapper;



    /**
     * This method creates a user in the database.
     *
     * @param userInputDTO The user's informations.
     * @return The created user.
     */
    @Modifying
    public UserOutputDTO createUser(UserInputDTO userInputDTO) {
        User user = userMapper.toEntity(userInputDTO);

        Optional<User> userOptional = userRepository.findByMail(userInputDTO.mail());
        if (userOptional.isPresent()) {
            throw new RuntimeException();
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);

        return userMapper.toDTO(userRepository.save(user));
    }



    /**
     * This method checks if the credential for the users are good.
     *
     * @param userInputDTO The user's credential.
     * @return Return the user if credential are correct. Null ortherwise.
     * @throws NotFoundException If the user doesn't exist.
     */
    public UserOutputDTO checkCredential(UserInputDTO userInputDTO) throws NotFoundException {
        Optional<User> userOptional = userRepository.findByMail(userInputDTO.mail());
        if (userOptional.isEmpty()) {
            throw new NotFoundException();
        }
        User user = userOptional.get();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(userInputDTO.password(), user.getPassword()) == true) {
            return userMapper.toDTO(user);
        }
        return null;
    }



    /**
     * This method get all users.
     *
     * @return Return all the users.
     */
    public List<UserOutputDTO> getAllUsers() {
        List<User> users = userRepository.findAll();

        List<UserOutputDTO> result = new ArrayList<>();

        for (User user : users) {
            result.add(userMapper.toDTO(user));
        }

        return result;
    }



    /**
     * This method get a specific user.
     *
     * @param id The user's id.
     * @return Return the user.
     * @throws NotFoundException If the user are not in the database.
     */
    public UserOutputDTO getUser(int id) throws NotFoundException {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            throw new NotFoundException();
        }

        User user = userOptional.get();

        return userMapper.toDTO(user);
    }



    /**
     * This method updates partially a user in the database.
     *
     * @param id The user's id.
     * @param userInputDTO The user's informations.
     * @return Return the updated user.
     * @throws NotFoundException If the user are not in the database.
     */
    @Modifying
    public UserOutputDTO partialUpdateUser(int id, UserInputDTO userInputDTO)
        throws NotFoundException {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            throw new NotFoundException();
        }

        User user = userOptional.get();

        userMapper.partialUpdate(user, userInputDTO);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);

        return userMapper.toDTO(userRepository.save(user));
    }



    /**
     * This method updates fully a user in the database.
     *
     * @param id The user's id.
     * @param userInputDTO The user's informations.
     * @return Return the updated user.
     * @throws NotFoundException If the user are not in the database.
     */
    @Modifying
    public UserOutputDTO fullUpdateUser(int id, UserInputDTO userInputDTO)
        throws NotFoundException {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            throw new NotFoundException();
        }

        User user = userOptional.get();

        userMapper.fullUpdate(user, userInputDTO);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);

        return userMapper.toDTO(userRepository.save(user));
    }



    /**
     * This methods delete a user in the database.
     *
     * @param id The user's id.
     */
    @Modifying
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

}
