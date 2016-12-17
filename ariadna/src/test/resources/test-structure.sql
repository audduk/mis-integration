CREATE TABLE DIR_RESEARCH_TARGET (
    id BIGINT PRIMARY KEY NOT NULL,
    entity_uid character varying(36) NOT NULL,
    version BIGINT,
    entitystatus BIGINT,
    code character varying(255) NOT NULL,
    name character varying(255) NOT NULL
);
CREATE SEQUENCE  "DIR_RESEARCH_TARGETS_ID_SEQ"  MINVALUE 1 INCREMENT BY 1 ;

CREATE TABLE DIR_CYCLE_PHASE (
    id BIGINT PRIMARY KEY NOT NULL,
    entity_uid character varying(36) NOT NULL,
    version BIGINT,
    entitystatus BIGINT,
    code character varying(255) NOT NULL,
    name character varying(255) NOT NULL
);
CREATE SEQUENCE  "DIR_CYCLE_PHASE_ID_SEQ"  MINVALUE 1 INCREMENT BY 1 ;

CREATE TABLE DIR_BIOMATERIALS (
    id BIGINT PRIMARY KEY NOT NULL,
    entity_uid character varying(36) NOT NULL,
    version BIGINT,
    entitystatus BIGINT,
    code character varying(255) NOT NULL,
    name character varying(255) NOT NULL
);
CREATE SEQUENCE  "DIR_BIOMATERIAL_ID_SEQ"  MINVALUE 1 INCREMENT BY 1 ;
