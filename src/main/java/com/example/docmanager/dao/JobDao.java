package com.example.docmanager.dao;

import java.util.List;
import java.util.Optional;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import com.example.docmanager.entity.Job;

@Dao
public interface JobDao {

    @Select
    Optional<Job> findById(Long id);

    @Select
    List<Job> findAll();

    @Insert
    int insert(Job job);

    @Update
    int update(Job job);

    @Delete
    int delete(Job job);
}
