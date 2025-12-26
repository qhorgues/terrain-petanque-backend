package org.group_1.terrain_petanque.service;

import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.group_1.terrain_petanque.dto.UserDTO;
import org.group_1.terrain_petanque.dto.UserInputDTO;
import org.group_1.terrain_petanque.dto.mapper.UserMapper;
import org.group_1.terrain_petanque.entity.User;
import org.group_1.terrain_petanque.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

/**
 * This class represent the service to handle a user.
 */
@Service
@Transactional
public class UserService {

    /**
     * This attribute is the repository.
     */
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    /**
     * The constructor.
     *
     * @param userRepository The repository.
     */
    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    /**
     * This methods add a user in the database.
     *
     * @param userDTO The user's informations.
     */
    @Modifying
    public UserDTO addUser(UserInputDTO userInputDTO) {
        User user = userMapper.toEntity(userInputDTO);
        return userMapper.toDTO(userRepository.save(user));
    }

    /**
     * This methods update partially a user in the database.
     *
     * @param id The user's id.
     * @param userDTO The user's informations.
     * @throws NotFoundException If the user are not in the database.
     */
    @Modifying
    public UserDTO partialUpdateUser(int id, UserInputDTO userInputDTO)
        throws NotFoundException {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            throw new NotFoundException();
        }

        User user = userOptional.get();

        userMapper.partialUpdate(user, userInputDTO);

        return userMapper.toDTO(userRepository.save(user));
    }

    /**
     * This methods update fully a user in the database.
     *
     * @param id The user's id.
     * @param userDTO The user's informations.
     * @throws NotFoundException If the user are not in the database.
     */
    @Modifying
    public UserDTO fullUpdateUser(int id, UserInputDTO userInputDTO)
        throws NotFoundException {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            throw new NotFoundException();
        }

        User user = userOptional.get();

        userMapper.fullUpdate(user, userInputDTO);

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

    /**
     * This method get a specific user.
     *
     * @param id The user's id.
     * @return Return the user's informations.
     * @throws NotFoundException If the user are not in the database.
     */
    public UserDTO getUser(int id) throws NotFoundException {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            throw new NotFoundException();
        }

        User user = userOptional.get();

        return userMapper.toDTO(user);
    }

    /**
     * This method get all users.
     *
     * @return Return all the users.
     */
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();

        List<UserDTO> result = new ArrayList<>();

        for (User user : users) {
            result.add(userMapper.toDTO(user));
        }

        return result;
    }
}
