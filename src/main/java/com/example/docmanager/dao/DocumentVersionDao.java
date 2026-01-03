package com.example.docmanager.dao;

import java.util.List;
import java.util.Optional;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import com.example.docmanager.entity.DocumentVersion;

@Dao
public interface DocumentVersionDao {

    @Select
    Optional<DocumentVersion> findById(Long id);

    @Select
    List<DocumentVersion> findAll();

    @Insert
    int insert(DocumentVersion documentVersion);

    @Update
    int update(DocumentVersion documentVersion);

    @Delete
    int delete(DocumentVersion documentVersion);
}
