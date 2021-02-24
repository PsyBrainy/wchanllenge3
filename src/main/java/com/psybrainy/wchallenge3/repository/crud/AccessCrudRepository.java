package com.psybrainy.wchallenge3.repository.crud;


import com.psybrainy.wchallenge3.repository.entity.AccessEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AccessCrudRepository extends CrudRepository<AccessEntity,Long> {


    Optional<AccessEntity> findByIdAlbumAndUserId(Long idAlbum, Long userId);

    List<AccessEntity> findByIdAlbumAndAccess(Long idAlbum, String access);


}
