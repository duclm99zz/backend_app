package com.project.shopapp.services;

import com.project.shopapp.dtos.UserDTO;
import com.project.shopapp.exceptions.DataNotFoundException;
import com.project.shopapp.models.Role;
import com.project.shopapp.models.User;
import com.project.shopapp.repositories.RoleRepository;
import com.project.shopapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements IUserService {

    private final  UserRepository userRepository;
    private final  RoleRepository roleRepository;



    @Override
    public User createUser(UserDTO userDto) {
        String phoneNumber = userDto.getPhoneNumber();
        if (userRepository.existsByPhoneNumber(phoneNumber)) {
            throw new DataIntegrityViolationException("Phone number already exist");
        }
        User newUser = User.builder()
                .fullName(userDto.getFullName())
                .phoneNumber(userDto.getPhoneNumber())
                .address(userDto.getAddress())
                .dateOfBirth(userDto.getDateOfBirth())
                .facebookAccountId(userDto.getFacebookAccountId())
                .googleAccountId(userDto.getGoogleAccountId())
                .build();
        Role role = null;
        try {
            role = roleRepository.findById(userDto.getRoleId()).orElseThrow(
                    () -> new DataNotFoundException("Role not found")
            );
        } catch (DataNotFoundException e) {
            throw new RuntimeException(e);
        }
        newUser.setRole(role);
         if (userDto.getFacebookAccountId() == 0 && userDto.getGoogleAccountId() == 0) {
             String password = userDto.getPassword();
//             newUser.setPassword()
         }

        return userRepository.save(newUser);
    }

    @Override
    public String login(String phoneNumber, String password) {

        return null;
    }
}
