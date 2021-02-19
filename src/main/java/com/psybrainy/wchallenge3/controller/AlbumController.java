package com.psybrainy.wchallenge3.controller;

import com.psybrainy.wchallenge3.dto.request.AccessRequest;
import com.psybrainy.wchallenge3.dto.request.AlbumRequest;
import com.psybrainy.wchallenge3.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;


    @GetMapping("/{id}")
    public AlbumRequest getById(@PathVariable("id") Long id){
        return albumService.getById(id);
    }

    @PostMapping("/{albumId}/access")
    public void createAlbumWhithPermission(@RequestBody AccessRequest accessRequest , @PathVariable("albumId") Long albumId){
        albumService.albumWithPermmission(accessRequest,albumId);
    }



}
