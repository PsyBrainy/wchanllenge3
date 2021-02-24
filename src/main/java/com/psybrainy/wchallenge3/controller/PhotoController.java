package com.psybrainy.wchallenge3.controller;

import com.psybrainy.wchallenge3.dto.request.PhotoRequest;
import com.psybrainy.wchallenge3.service.PhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/photos")
public class PhotoController {

    @Autowired
    private PhotosService photosService;


    @GetMapping("/{userId}")
    public List<List<PhotoRequest>> getByUserId(@PathVariable("userId") Long userId){
        return photosService.getPhotosByUserId(userId);
    }
}
