package com.example.docmanager.dao;

import java.util.List;
import java.util.Optional;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import com.example.docmanager.entity.Document;

@Dao
public interface DocumentDao {

    @Select
    Optional<Document> findById(Long id);

    @Select
    List<Document> findAll();

    @Insert
    int insert(Document document);

    @Update
    int update(Document document);

    @Delete
    int delete(Document document);

}
