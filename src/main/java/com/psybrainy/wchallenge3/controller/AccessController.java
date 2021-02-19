package com.psybrainy.wchallenge3.controller;

import com.psybrainy.wchallenge3.dto.request.AccessRequest;
import com.psybrainy.wchallenge3.repository.entity.AccessEntity;
import com.psybrainy.wchallenge3.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/permission")
public class AccessController {

    @Autowired
    private AccessService accessService;


    @ResponseStatus
    @PutMapping("/{albumId}/user/{userId}")
    public AccessRequest updatePermissionByAlbum(@RequestBody AccessRequest accessRequest , @PathVariable("albumId")Long albumId,
                                                 @PathVariable("userId") Long userId){
        return accessService.updatePermissionByAlbum(accessRequest,albumId,userId);
    }

}
