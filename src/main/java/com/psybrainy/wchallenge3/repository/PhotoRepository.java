package com.psybrainy.wchallenge3.repository;

import com.psybrainy.wchallenge3.dto.request.PhotoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Repository
public class PhotoRepository {

    @Autowired
    private RestTemplate restTemplate;

    private static final String URL_PHOTOS = "https://jsonplaceholder.typicode.com/photos";

    public List<PhotoRequest> findAllPhotos(){

        PhotoRequest[] photoRequests = restTemplate.getForObject(URL_PHOTOS, PhotoRequest[].class);

        return Arrays.asList(photoRequests);
    }
}
