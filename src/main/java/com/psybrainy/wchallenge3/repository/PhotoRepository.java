package com.psybrainy.wchallenge3.repository;

import com.psybrainy.wchallenge3.dto.request.AlbumRequest;
import com.psybrainy.wchallenge3.dto.request.PhotoRequest;
import com.psybrainy.wchallenge3.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Repository
public class PhotoRepository {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AlbumService albumService;

    private static final String URL_PHOTOS = "https://jsonplaceholder.typicode.com/photos";
    private static final String URL_PHOTOS_BY_ALBUM_ID = "https://jsonplaceholder.typicode.com/photos?albumId={albumId}";

    public List<PhotoRequest> findAllPhotos(){

        PhotoRequest[] photoRequests = restTemplate.getForObject(URL_PHOTOS, PhotoRequest[].class);

        return Arrays.asList(photoRequests);
    }

    public List<PhotoRequest> findByAlbumId(Long albumId){

        Map<String,Long> param = new HashMap<>();

        param.put("albumId",albumId);

        PhotoRequest[] photoRequests = restTemplate.getForObject(URL_PHOTOS_BY_ALBUM_ID, PhotoRequest[].class,param);

        return Arrays.asList(photoRequests);
    }

    public List<List<PhotoRequest>> findPhotosByUserId(Long userId){

        List<AlbumRequest> albumRequestList = albumService.getByUserId(userId);
        List<List<PhotoRequest>> photoRequestList = new ArrayList<>();

        Iterator<AlbumRequest> iterator = albumRequestList.iterator();

        List<Long> albumsId = new ArrayList<>();

        while(iterator.hasNext()){
            Long id = iterator.next().getId();
            albumsId.add(id);
        }

        Iterator<Long> longIterator = albumsId.iterator();

        while(longIterator.hasNext()){

            photoRequestList.add(findByAlbumId(longIterator.next())) ;
        }
        return photoRequestList;
    }
}
