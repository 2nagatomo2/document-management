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
@Table(name = "thumbnail")
@Getter
@Setter
@NoArgsConstructor
public class Thumbnail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    @Column(name = "version_id")
    private Long versionId;

    @Nonnull
    private String kind;

    @Nonnull
    @Column(name = "object_key")
    private String objectKey;

    private Integer width;

    private Integer height;

    @Nonnull
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
