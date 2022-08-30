package com.adriano.helpedesk.service;

import com.adriano.helpedesk.domain.Profiles;
import com.adriano.helpedesk.domain.User;
import com.adriano.helpedesk.domain.dto.request.UserRequest;
import com.adriano.helpedesk.domain.dto.response.UserResponse;
import com.adriano.helpedesk.exception.Message;
import com.adriano.helpedesk.repository.ProfileRepository;
import com.adriano.helpedesk.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.*;

@Service
@Validated
@Slf4j
@AllArgsConstructor
public class UserService implements UserDetailsService {

    UserRepository userRepository;

    ProfileRepository profileRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("method=loadUserByUsername username={}",username);
        return userRepository.findByEmail(username)
                .orElseThrow(Message.NOT_FOT_USER_PERMISSION::asBusinessException);
    }


    public UserResponse save(@Valid UserRequest userRequest) {

        userRepository.findByEmail(userRequest.getEmail()).ifPresent(p -> {
            throw Message.IS_PRESENT_USER.asBusinessException();
        });

        Profiles profiles = profileRepository.findByName("USER").orElseThrow(Message.NAME_PROFILE_NOT_FOUND::asBusinessException);

        List<Profiles> listProfile = new ArrayList<>();

        listProfile.add(profiles);

        User user = User.builder().email(userRequest.getEmail())
                .password(new BCryptPasswordEncoder().encode(userRequest.getPassword())).name(userRequest.getUsername())
                .build();


        user.setPerfis(listProfile);

        userRepository.save(user);

        log.info("method=save username={} email={}", userRequest.getUsername(),userRequest.getEmail());

        return user.toDto();
    }

}
