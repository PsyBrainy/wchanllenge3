package com.psybrainy.wchallenge3.repository;

import com.psybrainy.wchallenge3.repository.crud.AccessCrudRepository;
import com.psybrainy.wchallenge3.repository.crud.AlbumCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DatabaseRepository {

    @Autowired
    AlbumCrudRepository albumCrud;

    @Autowired
    AccessCrudRepository accessCrud;
}
