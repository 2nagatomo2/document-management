package com.example.docmanager.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "document")
@Getter
@Setter
@NoArgsConstructor
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    @Column(name = "title")
    private String title;

    private String description;

    @Nonnull
    @Column(name = "owned_by")
    private Long ownedBy;

    @Column(name = "current_version_id")
    private Long currentVersionId;

    @Nonnull
    @Column(name = "is_public")
    private Boolean isPublic;

    @Nonnull
    @Column(name = "created_by")
    private Long createdBy;


    @Nonnull
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Nonnull
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
