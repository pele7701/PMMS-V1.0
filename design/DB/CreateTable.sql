CREATE TABLE tb_project(
    project_code VARCHAR (32)  NOT NULL ,
    project_name VARCHAR (150)   ,
    state VARCHAR (1)   ,
    PRIMARY KEY (project_code)
);

CREATE TABLE tb_material(
    material_code VARCHAR (32)  NOT NULL ,
    material_name VARCHAR (150)   ,
    material_unit VARCHAR (50)   ,
    material_pi_spec VARCHAR (50)   ,
    state VARCHAR (1)   ,
    PRIMARY KEY (material_code)
);

CREATE TABLE tb_material_price(
    price_id VARCHAR (32)  NOT NULL ,
    material_code VARCHAR (32)   ,
    price VARCHAR (50)   ,
    ticket VARCHAR (50)   ,
    seq VARCHAR (50)   ,
    PRIMARY KEY (price_id)
);

CREATE TABLE tb_project_material(
    pm_id VARCHAR (32)  NOT NULL ,
    project_code VARCHAR (32)   ,
    material_code VARCHAR (32)   ,
    quota VARCHAR (50)   ,
    PRIMARY KEY (pm_id)
);