package com.psybrainy.wchallenge3.repository;

import com.psybrainy.wchallenge3.dto.request.AlbumRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AlbumRepository {

    @Autowired
    RestTemplate restTemplate;

    private static final String URL_ALBUM_ID = "https://jsonplaceholder.typicode.com/albums/{id}";
    private static final String URL_ALBUM = "https://jsonplaceholder.typicode.com/albums";


    public List<AlbumRequest> findAllAlbums(){

        AlbumRequest[] albumRequests = restTemplate.getForObject(URL_ALBUM, AlbumRequest[].class);

        return Arrays.asList(albumRequests);
    }

    public AlbumRequest findById(Long id){
        Map<String,Long> param = new HashMap<>();

        param.put("id",id );

        return restTemplate.getForObject(URL_ALBUM_ID, AlbumRequest.class, param);
    }
}
