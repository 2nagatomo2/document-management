package com.example.docmanager.dao;

import java.util.List;
import java.util.Optional;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import com.example.docmanager.entity.Tag;

@Dao
public interface TagDao {

    @Select
    Optional<Tag> findById(Long id);

    @Select
    List<Tag> findAll();

    @Insert
    int insert(Tag tag);

    @Update
    int update(Tag tag);

    @Delete
    int delete(Tag tag);
}
