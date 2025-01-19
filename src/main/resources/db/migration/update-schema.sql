CREATE TABLE test_model
(
    id              BIGINT       NOT NULL,
    created_at      datetime     NULL,
    last_updated_at datetime     NULL,
    state           SMALLINT     NULL,
    text_field      VARCHAR(255) NULL,
    number_field    INT          NULL,
    CONSTRAINT pk_testmodel PRIMARY KEY (id)
);

ALTER TABLE st_user
    ADD phone_number VARCHAR(255) NULL;

ALTER TABLE st_user
    MODIFY user_type INT NULL;