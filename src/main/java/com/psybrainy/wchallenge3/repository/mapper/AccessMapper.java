package com.psybrainy.wchallenge3.repository.mapper;

import com.psybrainy.wchallenge3.dto.request.AccessRequest;
import com.psybrainy.wchallenge3.repository.entity.AccessEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class AccessMapper {

    @Autowired
    private ModelMapper mapper;

    public AccessRequest toAccessRequest(AccessEntity accessEntity){
        AccessRequest accessRequest = mapper.map(accessEntity,AccessRequest.class);
        mapper.addMappings(new PropertyMap<AccessRequest, AccessEntity>() {
            @Override
            protected void configure() {
                map().setUserId(source.getUserId());
                map().setAccess(source.getAccess());
            }
        });

        accessRequest.setUserId(accessEntity.getUserId());
        accessRequest.setAccess(accessEntity.getAccess());

        return accessRequest;

    }

    public AccessEntity toAccessEntity(AccessRequest accessRequest) {
        AccessEntity accessEntity = mapper.map(accessRequest,AccessEntity.class);
        mapper.addMappings(new PropertyMap<AccessEntity, AccessRequest>() {
            @Override
            protected void configure() {
                map().setUserId(source.getUserId());
                map().setAccess(source.getAccess());
            }
        });

        accessEntity.setUserId(accessRequest.getUserId());
        accessEntity.setAccess(accessRequest.getAccess());

        return accessEntity;
    }
}