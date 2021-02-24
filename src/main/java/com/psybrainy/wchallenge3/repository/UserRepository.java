package com.psybrainy.wchallenge3.repository;

import com.psybrainy.wchallenge3.dto.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    @Autowired
    private RestTemplate restTemplate;

    private static final String URL_USER = "https://jsonplaceholder.typicode.com/users";
    private static final String URL_USER_ID = "https://jsonplaceholder.typicode.com/users/{id}";

    public List<UserRequest> findAllUsers(){

        UserRequest[] userRequests = restTemplate.getForObject(URL_USER, UserRequest[].class);

        return Arrays.asList(userRequests);
    }

    public UserRequest findById(Long id){
        Map<String, Long> param = new HashMap<>();

        param.put("id",id);

        return restTemplate.getForObject(URL_USER_ID, UserRequest.class, param);
    }
}
