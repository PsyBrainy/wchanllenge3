package com.psybrainy.wchallenge3.repository.crud;

import com.psybrainy.wchallenge3.dto.request.AccessRequest;
import com.psybrainy.wchallenge3.repository.entity.AccessEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccessCrudRepository extends CrudRepository<AccessEntity,Long> {


    Optional<AccessEntity> findByIdAlbumAndUserId(Long idAlbum, Long userId);


}
