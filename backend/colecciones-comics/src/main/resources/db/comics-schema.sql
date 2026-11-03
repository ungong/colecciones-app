-- Tipos ENUM
CREATE TYPE character_role AS ENUM ('PROTAGONIST', 'SECONDARY', 'VILLAIN', 'GUEST', 'CAMEO');
CREATE TYPE creator_role AS ENUM ('WRITER', 'PENCILLER', 'INKER', 'COLORIST', 'LETTERER', 'EDITOR', 'COVER_ARTIST');
CREATE TYPE collection_status AS ENUM ('OWNED', 'MISSING', 'WISHLIST', 'ORDERED');
CREATE TYPE edition_format AS ENUM ('SINGLE_ISSUE', 'TPB', 'HARDCOVER', 'OMNIBUS', 'DIGITAL', 'ABSOLUTE', 'DELUXE');

-- Tablas principales
CREATE TABLE publisher (
    publisher_id BIGSERIAL PRIMARY KEY,
    name VARCHAR(200) UNIQUE NOT NULL,
    country VARCHAR(100)
);

CREATE TABLE creator (
    creator_id BIGSERIAL PRIMARY KEY,
    full_name VARCHAR(250) NOT NULL
);

CREATE TABLE universe (
    universe_id BIGSERIAL PRIMARY KEY,
    name VARCHAR(150) UNIQUE NOT NULL,
    publisher_id BIGINT REFERENCES publisher
);

CREATE TABLE series (
    series_id BIGSERIAL PRIMARY KEY,
    publisher_id BIGINT NOT NULL REFERENCES publisher,
    universe_id BIGINT REFERENCES universe,
    title VARCHAR(250) NOT NULL
);

CREATE TABLE volume (
    volume_id BIGSERIAL PRIMARY KEY,
    series_id BIGINT NOT NULL REFERENCES series,
    volume_number INT NOT NULL
);

CREATE TABLE issue (
    issue_id BIGSERIAL PRIMARY KEY,
    volume_id BIGINT NOT NULL REFERENCES volume,
    issue_number VARCHAR(30) NOT NULL,
    title VARCHAR(300)
);

CREATE TABLE character (
    character_id BIGSERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    alter_ego VARCHAR(200),
    first_appearance_issue_id BIGINT REFERENCES issue
);

CREATE TABLE edition (
    edition_id BIGSERIAL PRIMARY KEY,
    issue_id BIGINT NOT NULL REFERENCES issue,
    publisher_id BIGINT NOT NULL REFERENCES publisher,
    format edition_format NOT NULL,
    isbn VARCHAR(50)
);

CREATE TABLE story_arc (
    arc_id BIGSERIAL PRIMARY KEY,
    title VARCHAR(250) NOT NULL
);

-- Tablas de relación
CREATE TABLE story_arc_issue (
    arc_id BIGINT REFERENCES story_arc,
    issue_id BIGINT REFERENCES issue,
    reading_order INT,
    PRIMARY KEY (arc_id, issue_id)
);

CREATE TABLE issue_character (
    issue_id BIGINT REFERENCES issue,
    character_id BIGINT REFERENCES character,
    role character_role,
    PRIMARY KEY (issue_id, character_id)
);

CREATE TABLE issue_creator (
    issue_id BIGINT REFERENCES issue,
    creator_id BIGINT REFERENCES creator,
    role creator_role,
    PRIMARY KEY (issue_id, creator_id, role)
);

CREATE TABLE character_creator (
    character_id BIGINT REFERENCES character,
    creator_id BIGINT REFERENCES creator,
    contribution VARCHAR(100),
    PRIMARY KEY (character_id, creator_id)
);

CREATE TABLE collector (
    collector_id BIGSERIAL PRIMARY KEY,
    username VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE collection_item (
    collection_item_id BIGSERIAL PRIMARY KEY,
    collector_id BIGINT REFERENCES collector,
    edition_id BIGINT REFERENCES edition,
    status collection_status NOT NULL,
    quantity INT DEFAULT 1,
    UNIQUE (collector_id, edition_id)
);