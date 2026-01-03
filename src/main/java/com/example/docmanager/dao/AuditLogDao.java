package com.example.docmanager.dao;

import java.util.List;
import java.util.Optional;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;

import com.example.docmanager.entity.AuditLog;

@Dao
public interface AuditLogDao {

    @Select
    Optional<AuditLog> findById(Long id);

    @Select
    List<AuditLog> findAll();

    @Insert
    int insert(AuditLog auditLog);

    @Delete
    int delete(AuditLog auditLog);
}
