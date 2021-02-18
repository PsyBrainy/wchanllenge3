package com.psybrainy.wchallenge3.controller;

import com.psybrainy.wchallenge3.dto.request.AlbumRequest;
import com.psybrainy.wchallenge3.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;


    @GetMapping("/{id}")
    public AlbumRequest getById(@PathVariable("id") Long id){
        return albumService.getById(id);
    }
}
