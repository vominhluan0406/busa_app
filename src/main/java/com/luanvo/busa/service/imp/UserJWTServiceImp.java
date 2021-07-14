package com.luanvo.busa.service.imp;

import com.luanvo.busa.io.entity.UserEntity;
import com.luanvo.busa.io.values.UserJWT;
import com.luanvo.busa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserJWTServiceImp implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.getByUserName(username);
        if(userEntity == null){
            throw new UsernameNotFoundException("Không tìm thấy User " + username);
        }
        return new UserJWT(userEntity);
    }
}
