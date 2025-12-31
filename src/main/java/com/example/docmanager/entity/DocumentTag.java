package com.example.docmanager.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "document_tag")
@Getter
@Setter
@NoArgsConstructor
public class DocumentTag {

    @Id
    @Nonnull
    @Column(name = "document_id")
    private Long documentId;

    @Id
    @Nonnull
    @Column(name = "tag_id")
    private Long tagId;
}
