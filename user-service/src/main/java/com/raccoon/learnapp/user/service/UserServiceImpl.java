package com.raccoon.learnapp.user.service;

import com.raccoon.learnapp.user.dao.UserRepository;
import com.raccoon.learnapp.user.dao.entity.UserEntity;
import com.raccoon.learnapp.user.exception.UserDoesNotExistException;
import com.raccoon.learnapp.user.model.UserRegistrationData;
import com.raccoon.learnapp.user.model.UserDTO;
import com.raccoon.learnapp.user.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDTO> getUsers() {
        log.debug("Retrieve all users");
        return userRepository.findAll().stream()
                .map(userMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void saveUser(UserRegistrationData data) {
        log.debug("Save new user: {}", data);
        UserEntity entity = userMapper.convertToEntity(data);
        userRepository.save(entity);
    }

    @Override
    public UserDTO getUser(Long id) {
        log.debug("Retrieve user by id: {}", id);
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> {
            log.error("User with id: {} does not exist", id);
            throw new UserDoesNotExistException(id);
        });
        return userMapper.convertToDTO(userEntity);
    }
}
