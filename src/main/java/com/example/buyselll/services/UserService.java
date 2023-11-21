package com.example.buyselll.services;

import com.example.buyselll.models.User;
import com.example.buyselll.models.enums.Role;
import com.example.buyselll.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public boolean createUser(User user){
        String email = user.getEmail();
        if(userRepository.findByEmail(email) != null){
            return false;
        }
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        log.info("Saving new User with email: {}", email);
        userRepository.save(user);
        return  true;
    }

    public List<User> list(){
        return userRepository.findAll();
    }

    public void banUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user != null){
            user.setActive(!user.isActive());
            if(!user.isActive()) {
                log.info("Ban user with id = {}, email: {}", user.getId(), user.getEmail());
            }
        }
        assert user != null;
        userRepository.save(user);
    }

    public void changeUserroles(User user, Map<String, String> form) {
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role ::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();
        for (String key : form.keySet()){
            if(roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepository.save(user);
    }
}
