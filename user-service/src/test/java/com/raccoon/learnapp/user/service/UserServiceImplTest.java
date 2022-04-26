package com.raccoon.learnapp.user.service;

import com.raccoon.learnapp.user.UserTestData;
import com.raccoon.learnapp.user.dao.UserRepository;
import com.raccoon.learnapp.user.dao.entity.UserEntity;
import com.raccoon.learnapp.user.mapper.UserMapper;
import com.raccoon.learnapp.user.model.UserDTO;
import com.raccoon.learnapp.user.model.UserRegistrationData;
import com.raccoon.learnapp.user.exception.UserDoesNotExistException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @Mock
    private UserRegistrationData userRegistrationData;

    @Mock
    private UserEntity userEntity;

    @Mock
    private UserDTO userDTO;

    @Test
    void shouldReturnUsers() {
        // given
        when(userRepository.findAll()).thenReturn(List.of(userEntity));
        when(userMapper.convertToDTO(userEntity)).thenReturn(userDTO);

        // when
        List<UserDTO> result = userService.getUsers();

        // then
        assertThat(result).asList().containsExactly(userDTO);
        verify(userRepository).findAll();
        verify(userMapper).convertToDTO(userEntity);
    }

    @Test
    void shouldSaveUser() {
        // given
        when(userMapper.convertToEntity(userRegistrationData)).thenReturn(userEntity);

        // when
        userService.saveUser(userRegistrationData);

        // then
        verify(userMapper).convertToEntity(userRegistrationData);
        verify(userRepository).save(userEntity);
    }

    @Test
    void shouldGetUserById() {
        // given
        when(userRepository.findById(UserTestData.ID)).thenReturn(Optional.of(userEntity));
        when(userMapper.convertToDTO(userEntity)).thenReturn(userDTO);

        // when
        UserDTO result = userService.getUser(UserTestData.ID);

        // then
        assertThat(result).isEqualTo(userDTO);
        verify(userRepository).findById(UserTestData.ID);
        verify(userMapper).convertToDTO(userEntity);
    }

    @Test
    void shouldGetExceptionIfUserDoesNotExistById() {
        when(userRepository.findById(UserTestData.ID)).thenReturn(Optional.empty());
        assertThrows(UserDoesNotExistException.class, () -> userService.getUser(UserTestData.ID));
        verifyNoInteractions(userMapper);
    }
}