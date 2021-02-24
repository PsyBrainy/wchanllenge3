package com.psybrainy.wchallenge3.repository;

import com.psybrainy.wchallenge3.dto.request.AccessRequest;
import com.psybrainy.wchallenge3.dto.request.AlbumRequest;
import com.psybrainy.wchallenge3.repository.entity.AccessEntity;
import com.psybrainy.wchallenge3.repository.mapper.AccessMapper;
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
    private RestTemplate restTemplate;

    @Autowired
    private AccessRepository repo;

    @Autowired
    AccessMapper mapper;

    private static final String URL_ALBUM_ID = "https://jsonplaceholder.typicode.com/albums/{id}";
    private static final String URL_ALBUM = "https://jsonplaceholder.typicode.com/albums";
    private static final String URL_ALBUM_USER_ID = "https://jsonplaceholder.typicode.com/albums?userId={userId}";


    public List<AlbumRequest> findAllAlbums(){

        AlbumRequest[] albumRequests = restTemplate.getForObject(URL_ALBUM, AlbumRequest[].class);

        return Arrays.asList(albumRequests);
    }

    public AlbumRequest findById(Long id){
        Map<String,Long> param = new HashMap<>();

        param.put("id",id );

        return restTemplate.getForObject(URL_ALBUM_ID, AlbumRequest.class, param);
    }

    public List<AlbumRequest> findByUserId(Long userId){
        Map<String,Long> param = new HashMap<>();

        param.put("userId",userId );

        AlbumRequest[] albumRequests = restTemplate.getForObject(URL_ALBUM_USER_ID, AlbumRequest[].class, param);

        return Arrays.asList(albumRequests);
    }

    public void extendAlbum(AccessRequest accessRequest, Long albumId){

        AlbumRequest albumRequest = findById(albumId);

        AccessEntity accessEntity = new AccessEntity(albumRequest.getId(),albumRequest.getTitle(),
                accessRequest.getUserId(),accessRequest.getAccess());

        AccessRequest access = mapper.toAccessRequest(accessEntity);

        repo.saveAccess(access);
    }


}
