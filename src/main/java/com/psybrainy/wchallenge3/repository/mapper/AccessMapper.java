package com.psybrainy.wchallenge3.repository.mapper;

import com.psybrainy.wchallenge3.dto.request.AccessRequest;
import com.psybrainy.wchallenge3.repository.entity.AccessEntity;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class AccessMapper {


    public AccessRequest toAccessRequest(AccessEntity accessEntity){
        AccessRequest accessRequest = new AccessRequest();

        accessRequest.setAccessId(accessEntity.getIdAccess());
        accessRequest.setAlbumId(accessEntity.getIdAlbum());
        accessRequest.setAlbumTitle(accessEntity.getAlbumTitle());
        accessRequest.setUserId(accessEntity.getUserId());
        accessRequest.setAccess(accessEntity.getAccess());

        return accessRequest;
    }

    public AccessEntity toAccessEntity(AccessRequest accessRequest) {
        AccessEntity accessEntity = new AccessEntity();

        accessEntity.setIdAccess(accessRequest.getAccessId());
        accessEntity.setIdAlbum(accessRequest.getAlbumId());
        accessEntity.setAlbumTitle(accessRequest.getAlbumTitle());
        accessEntity.setUserId(accessRequest.getUserId());
        accessEntity.setAccess(accessRequest.getAccess());

        return accessEntity;
    }

}