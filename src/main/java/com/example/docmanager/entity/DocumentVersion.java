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
@Table(name = "document_version")
@Getter
@Setter
@NoArgsConstructor
public class DocumentVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    @Column(name = "document_id")
    private Long documentId;

    @Nonnull
    private Integer version;

    @Nonnull
    @Column(name = "object_key")
    private String objectKey;

    @Nonnull
    @Column(name = "content_type")
    private String contentType;

    @Nonnull
    @Column(name = "size_bytes")
    private Long sizeBytes;

    @Nonnull
    @Column(name = "checksum_sha256")
    private String checksumSha256;

    @Nonnull
    @Column(name = "uploaded_by")
    private Long uploadedBy;

    @Nonnull
    @Column(name = "uploaded_at")
    private LocalDateTime uploadedAt;
}
