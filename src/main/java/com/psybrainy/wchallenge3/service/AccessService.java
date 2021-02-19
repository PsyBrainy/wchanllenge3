package com.psybrainy.wchallenge3.service;

import com.psybrainy.wchallenge3.dto.request.AccessRequest;
import com.psybrainy.wchallenge3.repository.AccessRepository;
import com.psybrainy.wchallenge3.repository.entity.AccessEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessService {

    @Autowired
    AccessRepository accessRepository;

    public AccessRequest updatePermissionByAlbum(Long albumId, Long userId) {
        return accessRepository.updatePermissionByAlbum(albumId,userId);
    }
}
