-- Table: public.item

-- DROP TABLE public.item;

CREATE TABLE public.item
(
    item_id integer NOT NULL,
    item_quantity integer,
    item_unit_price double precision,
    created_date timestamp without time zone,
    created_by character varying COLLATE pg_catalog."default",
    modified_date timestamp without time zone,
    modified_by character varying COLLATE pg_catalog."default",
    soft_delete boolean,
    CONSTRAINT item_pkey PRIMARY KEY (item_id)
)

TABLESPACE pg_default;

ALTER TABLE public.item
    OWNER to postgres;