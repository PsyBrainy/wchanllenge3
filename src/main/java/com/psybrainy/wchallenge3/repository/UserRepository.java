package com.psybrainy.wchallenge3.repository;

import com.psybrainy.wchallenge3.dto.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class UserRepository {

    @Autowired
    private RestTemplate restTemplate;

    private static final String URL_USER = "https://jsonplaceholder.typicode.com/users";

    public List<UserRequest> findAllUsers(){

        UserRequest[] userRequests = restTemplate.getForObject(URL_USER, UserRequest[].class);

        return Arrays.asList(userRequests);
    }
}
