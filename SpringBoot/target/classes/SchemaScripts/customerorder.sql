-- Table: public.customerorder

-- DROP TABLE public.customerorder;

CREATE TABLE public.customerorder
(
    order_id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    customer_id integer,
    order_date timestamp without time zone,
    order_subtotal double precision,
    order_tax double precision,
    order_total double precision,
    shipping_charge double precision,
    payment_date time without time zone,
    payment_conf_no bigint,
    created_date timestamp with time zone,
    created_by character varying COLLATE pg_catalog."default",
    modified_date timestamp with time zone,
    modified_by character varying COLLATE pg_catalog."default",
    soft_delete boolean,
    CONSTRAINT "CustomerOrder_pkey" PRIMARY KEY (order_id),
    CONSTRAINT order_cust_id_fkey FOREIGN KEY (customer_id)
        REFERENCES public.customer (customer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.customerorder
    OWNER to postgres;