package com.chrislomeli.localizestore.repository;

import com.chrislomeli.localizestore.model.base.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<T extends BaseModel> extends JpaRepository<T, String> {

}