package com.example.docmanager.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "document_text")
@Getter
@Setter
@NoArgsConstructor
public class DocumentText {

    @Id
    @Nonnull
    @Column(name = "document_id")
    private Long documentId;

    @Nonnull
    @Column(name = "version_id")
    private Long versionId;

    @Column(name = "raw_text")
    private String rawText;

    // text_tsv は GENERATED カラムなので、エンティティには含めない

    @Nonnull
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
