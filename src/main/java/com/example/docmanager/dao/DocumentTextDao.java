package com.example.docmanager.dao;

import java.util.List;
import java.util.Optional;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import com.example.docmanager.entity.DocumentText;

@Dao
public interface DocumentTextDao {
    
    @Select
     Optional<DocumentText> findById(Long documentId);

    @Select
     List<DocumentText> findAll();

    @Insert
    int insert(DocumentText documentText);

    @Update
    int update(DocumentText documentText);

    @Delete
    int delete(DocumentText documentText);
}
