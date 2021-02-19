package com.psybrainy.wchallenge3.service;

import com.psybrainy.wchallenge3.dto.request.AccessRequest;
import com.psybrainy.wchallenge3.repository.AccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccessService {

    @Autowired
    AccessRepository accessRepository;

    public AccessRequest updatePermissionByAlbum(AccessRequest accessRequest, Long albumId, Long userId) {
        return accessRepository.updatePermissionByAlbum(accessRequest,albumId,userId);
    }

    public Optional<List<AccessRequest>> getByAccess(Long albumId, String access) {
        return accessRepository.getByAlbunAndAccess(albumId,access);
    }
}
