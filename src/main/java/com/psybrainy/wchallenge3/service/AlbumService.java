package com.psybrainy.wchallenge3.service;

import com.psybrainy.wchallenge3.dto.request.AlbumRequest;
import com.psybrainy.wchallenge3.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    public AlbumRequest getById(Long id){
        return albumRepository.findById(id);
    }
}
