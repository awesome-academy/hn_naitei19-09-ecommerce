package com.example.ecommerce.service.impl;

import com.example.ecommerce.DTO.UserRegistrationDto;
import com.example.ecommerce.dao.RoleRepository;
import com.example.ecommerce.dao.UserRepository;
import com.example.ecommerce.exeptions.RegistrationException;
import com.example.ecommerce.model.AccountStatus;
import com.example.ecommerce.model.Role;
import com.example.ecommerce.model.RoleName;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    @Override
    public List<User> findAll() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        if (registrationDto.getPassword().equals(registrationDto.getConfirmPassword())) {
            User existsUser = userRepository.findByEmail(registrationDto.getEmail());
            if (existsUser == null) {
                Role role = roleRepository.findById(1).orElse(null);
                User user = new User(
                        registrationDto.getName(), registrationDto.getEmail(),
                        registrationDto.getPassword(), role);
                return userRepository.save(user);
            } else {
                throw new RegistrationException("Email already exists");
            }
        } else {
            throw new RegistrationException("The Confirm Password confirmation does not match");
        }
    }




    @Override
    public Page<User> searchByFullname(String name, int page, int size, String sortField, String sortOrder) {
        try {
            Sort sort = Sort.by(sortField);
            if ("desc".equalsIgnoreCase(sortOrder)) {
                sort = sort.descending();
            } else {
                sort = sort.ascending();
            }

            Pageable pageable = PageRequest.of(page, size, sort);

            if (name != null) {
                return userRepository.findByFullnameContainingAndRoleName(name, RoleName.USER, pageable);
            } else {
                return userRepository.findByRoleName(RoleName.USER, pageable);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Page.empty(); // Return an empty page in case of an error
        }

    }

    @Override
    public boolean activateUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getAccountStatus() == AccountStatus.INACTIVE) {
                user.setAccountStatus(AccountStatus.ACTIVE);
                userRepository.save(user); // Lưu thay đổi vào cơ sở dữ liệu
                return true; // Thành công
            }
        }
        return false;
    }

    @Override
    public boolean deactivateUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getAccountStatus() == AccountStatus.ACTIVE) {
                user.setAccountStatus(AccountStatus.INACTIVE);
                userRepository.save(user); // Lưu thay đổi vào cơ sở dữ liệu
                return true; // Thành công
            }
        }
        return false;
    }
}