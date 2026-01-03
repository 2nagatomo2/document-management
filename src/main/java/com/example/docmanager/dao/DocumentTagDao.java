package com.example.docmanager.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;

import com.example.docmanager.entity.DocumentTag;

@Dao
public interface DocumentTagDao {

    @Select
    List<DocumentTag> findAll();

    @Insert
    int insert(DocumentTag documentTag);

    @Delete
    int delete(DocumentTag documentTag);
}
