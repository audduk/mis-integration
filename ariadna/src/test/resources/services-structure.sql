CREATE TABLE DIR_BIOMATERIALS (
    id BIGINT PRIMARY KEY NOT NULL,
    entity_uid character varying(36) NOT NULL,
    version BIGINT,
    entitystatus BIGINT,
    code character varying(255) NOT NULL,
    name character varying(255) NOT NULL
);

CREATE TABLE DIR_MED_SIMPLE_SERVICE (
    id BIGINT PRIMARY KEY NOT NULL,
    entity_uid character varying(36) NOT NULL,
    version BIGINT,
    entitystatus BIGINT,
    code character varying(255) NOT NULL,
    name character varying(255) NOT NULL
);

CREATE TABLE LINK_A_BIOMATERIALS (
    A_SERVICE_ID BIGINT REFERENCES DIR_MED_SIMPLE_SERVICE(ID),
    BIOMATERIAL_ID BIGINT REFERENCES DIR_BIOMATERIALS(ID)
);