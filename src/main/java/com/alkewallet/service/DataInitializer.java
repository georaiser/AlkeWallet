package com.alkewallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.alkewallet.entity.Role;
import com.alkewallet.entity.User;
import com.alkewallet.repository.RoleRepository;
import com.alkewallet.repository.UserRepository;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class DataInitializer {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        try {
            // Check if roles already exist
            if (roleRepository.count() == 0) {
                // Create starter roles
                Role adminRole = new Role();
                adminRole.setRoleName("ROLE_ADMIN");
                roleRepository.save(adminRole);

                Role userRole = new Role();
                userRole.setRoleName("ROLE_USER");
                roleRepository.save(userRole);

                // Create starter users if not exist
                if (!userRepository.existsByUsername("admin")) {
                    User admin = new User();
                    admin.setUsername("admin");
                    admin.setPassword(passwordEncoder.encode("admin"));
                    List<Role> adminRoles = new ArrayList<>();
                    adminRoles.add(adminRole);
                    admin.setRoles(adminRoles);
                    userRepository.save(admin);
                }

                if (!userRepository.existsByUsername("user")) {
                    User user = new User();
                    user.setUsername("user");
                    user.setPassword(passwordEncoder.encode("user"));
                    List<Role> userRoles = new ArrayList<>();
                    userRoles.add(userRole);
                    user.setRoles(userRoles);
                    userRepository.save(user);
                }
            }
        } catch (Exception e) {
            System.out.println("Starter data already exists in the database");
        }
    }
}

