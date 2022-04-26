package com.raccoon.learnapp.user.mapper;

import com.raccoon.learnapp.user.dao.entity.UserEntity;
import com.raccoon.learnapp.user.model.UserRegistrationData;
import com.raccoon.learnapp.user.model.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public abstract UserDTO convertToDTO(UserEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "level", ignore = true)
    @Mapping(source = "password", target = "password", qualifiedByName = "encodePassword")
    public abstract UserEntity convertToEntity(UserRegistrationData data);

    @Named("encodePassword")
    String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
