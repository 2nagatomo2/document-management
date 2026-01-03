package com.example.docmanager.dao;

import java.util.List;
import java.util.Optional;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import com.example.docmanager.model.DocumentDetailModel;

@Dao
@ConfigAutowireable
public interface DocumentDetailDao {
    
    @Select
    public Optional<DocumentDetailModel> findDocumentDetail(Long id);

    @Select
    public List<String> findTagNameByDocumentId(Long id);
 
}
