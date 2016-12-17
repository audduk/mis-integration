CREATE TABLE DIR_MED_SIMPLE_SERVICE_FTYPE (
    id BIGINT PRIMARY KEY NOT NULL,
    entity_uid character varying(36) NOT NULL,
    version BIGINT,
    entitystatus BIGINT,
    code character varying(255) NOT NULL,
    name character varying(255) NOT NULL
);

INSERT INTO DIR_MED_SIMPLE_SERVICE_FTYPE (id, version, entityStatus, ENTITY_UID, code, name)
VALUES (1, 0, 0, 'xxx', '02', 'ЛИ');--Функциональные тип ЛИ для поддержания работы алгоритма

CREATE TABLE DIR_BIOMATERIALS (
    id BIGINT PRIMARY KEY NOT NULL,
    entity_uid character varying(36) NOT NULL,
    version BIGINT,
    entitystatus BIGINT,
    code character varying(255) NOT NULL,
    name character varying(255) NOT NULL
);
CREATE SEQUENCE  "DIR_BIOMATERIAL_ID_SEQ"  MINVALUE 1 INCREMENT BY 1 ;

CREATE TABLE DIR_MED_SIMPLE_SERVICE (
    id BIGINT PRIMARY KEY NOT NULL,
    entity_uid character varying(36) NOT NULL,
    version BIGINT,
    entitystatus BIGINT,
    fType_id BIGINT REFERENCES DIR_MED_SIMPLE_SERVICE_FTYPE(ID),
    code character varying(255) NOT NULL,
    shortname character varying(255) NOT NULL,
    name character varying(255) NOT NULL
);
CREATE SEQUENCE  "DIR_MED_MANIPULATION_ID_SEQ"  MINVALUE 1 INCREMENT BY 1 ;

CREATE TABLE LINK_A_BIOMATERIALS (
    A_SERVICE_ID BIGINT REFERENCES DIR_MED_SIMPLE_SERVICE(ID),
    BIOMATERIAL_ID BIGINT REFERENCES DIR_BIOMATERIALS(ID)
);