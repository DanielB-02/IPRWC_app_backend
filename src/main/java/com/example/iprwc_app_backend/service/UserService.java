package com.example.iprwc_app_backend.service;

import com.example.iprwc_app_backend.model.User;
import com.example.iprwc_app_backend.repository.UserRepository;
import com.example.iprwc_app_backend.exception.NotFoundException;
import com.example.iprwc_app_backend.security.AdminSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @AdminSecurity
    public void delete(long id) throws NotFoundException {
        Optional<User> optionalUser = this.userRepository.findById(id);

        if(optionalUser.isEmpty()){
            throw new NotFoundException("User with id: " + id + " not found");
        }

        User user = optionalUser.get();
        this.userRepository.delete(user);
    }


    public List<User> findAll() {
        return userRepository.findAll();
    }
}
