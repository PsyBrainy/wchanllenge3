package com.psybrainy.wchallenge3.service;

import com.psybrainy.wchallenge3.dto.request.PhotoRequest;
import com.psybrainy.wchallenge3.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotosService {

    @Autowired
    private PhotoRepository photoRepository;

    public List<List<PhotoRequest>> getPhotosByUserId(Long userId){
        return photoRepository.findPhotosByUserId(userId);
    }
}
