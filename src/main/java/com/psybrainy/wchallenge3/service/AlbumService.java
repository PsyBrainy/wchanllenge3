package com.psybrainy.wchallenge3.service;

import com.psybrainy.wchallenge3.dto.request.AccessRequest;
import com.psybrainy.wchallenge3.dto.request.AlbumRequest;
import com.psybrainy.wchallenge3.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    public List<AlbumRequest> getAll(){
        return albumRepository.findAllAlbums();
    }

    public AlbumRequest getById(Long id){
        return albumRepository.findById(id);
    }

    public void albumWithPermmission(AccessRequest accessRequest, Long albumId){
        albumRepository.extendAlbum(accessRequest,albumId);
    }

    public List<AlbumRequest> getByUserId(Long userId){
        return albumRepository.findByUserId(userId);
    }
}
