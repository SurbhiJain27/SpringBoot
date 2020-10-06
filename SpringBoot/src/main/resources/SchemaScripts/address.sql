-- Table: public.address

-- DROP TABLE public.address;

CREATE TABLE public.address
(
    address_id bigint NOT NULL,
    address_line1 character varying COLLATE pg_catalog."default",
    address_line2 character varying COLLATE pg_catalog."default",
    city character varying COLLATE pg_catalog."default",
    state character varying COLLATE pg_catalog."default",
    postcode character varying(5) COLLATE pg_catalog."default",
    CONSTRAINT "Address_pkey" PRIMARY KEY (address_id)
)

TABLESPACE pg_default;

ALTER TABLE public.address
    OWNER to postgres;