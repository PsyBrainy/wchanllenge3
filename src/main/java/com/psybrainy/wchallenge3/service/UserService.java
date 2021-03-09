package com.psybrainy.wchallenge3.service;

import com.psybrainy.wchallenge3.dto.request.UserRequest;
import com.psybrainy.wchallenge3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserRequest> getAll(){
        return userRepository.findAllUsers();
    }

    public UserRequest getById(Long id){
        return userRepository.findById(id);
    }
}
