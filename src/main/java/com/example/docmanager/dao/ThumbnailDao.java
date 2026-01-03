package com.example.docmanager.dao;

import java.util.List;
import java.util.Optional;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import com.example.docmanager.entity.Thumbnail;

@Dao
public interface ThumbnailDao {

    @Select
    Optional<Thumbnail> findById(Long id);

    @Select
    List<Thumbnail> findAll();

    @Insert
    int insert(Thumbnail thumbnail);

    @Update
    int update(Thumbnail thumbnail);

    @Delete
    int delete(Thumbnail thumbnail);
}
