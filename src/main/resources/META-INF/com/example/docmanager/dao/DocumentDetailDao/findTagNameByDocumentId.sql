SELECT
    tag.name
FROM
    tag
INNER JOIN document_tag dt ON tag.id = dt.tag_id
WHERE
    dt.document_id = /* id */0
