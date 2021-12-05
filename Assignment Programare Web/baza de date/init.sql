use bazadedate

CREATE TABLE magazine(
    id varchar(255) NOT NULL,
    nume varchar(255),
    oras varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE produse(
    id varchar(255) NOT NULL,
    denumire varchar(255),
    categorie varchar(255),
    pret varchar(255),
    magazin_id varchar(255),
    PRIMARY KEY (id),
    FOREIGN KEY (magazin_id) REFERENCES magazine(id)
);