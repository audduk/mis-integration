CREATE TABLE DIR_RESEARCH_TARGET (
    id BIGINT PRIMARY KEY NOT NULL,
    entity_uid character varying(36) NOT NULL,
    version BIGINT,
    entitystatus BIGINT,
    code character varying(255) NOT NULL,
    name character varying(255) NOT NULL
);

CREATE TABLE DIR_CYCLE_PHASE (
    id BIGINT PRIMARY KEY NOT NULL,
    entity_uid character varying(36) NOT NULL,
    version BIGINT,
    entitystatus BIGINT,
    code character varying(255) NOT NULL,
    name character varying(255) NOT NULL
);

CREATE TABLE DIR_BIOMATERIALS (
    id BIGINT PRIMARY KEY NOT NULL,
    entity_uid character varying(36) NOT NULL,
    version BIGINT,
    entitystatus BIGINT,
    code character varying(255) NOT NULL,
    name character varying(255) NOT NULL
);
