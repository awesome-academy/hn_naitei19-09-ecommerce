package com.example.ecommerce.service;
import com.example.ecommerce.dto.UserRegistrationDto;
//import com.example.ecommerce.DTO.UserLoginDto;
import com.example.ecommerce.model.User;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends BaseService<Long, User> {

    User save(UserRegistrationDto registrationDto);

//    User login(UserLoginDto loginDto);

    Page<User> searchByFullname(String name, int page, int size, String sortField, String sortOrder);

    boolean deactivateUser(Long userId);

    boolean activateUser(Long userId);

}