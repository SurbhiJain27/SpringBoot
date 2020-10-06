-- Table: public.payment

-- DROP TABLE public.payment;

CREATE TABLE public.payment
(
    payment_id bigint NOT NULL,
    customer_id integer,
    card_no character varying COLLATE pg_catalog."default",
    payment_type character varying COLLATE pg_catalog."default",
    merchant character varying COLLATE pg_catalog."default",
    address_id bigint,
    CONSTRAINT "Payment_pkey" PRIMARY KEY (payment_id),
    CONSTRAINT payment_addr_id_fkey FOREIGN KEY (address_id)
        REFERENCES public.address (address_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT payment_cust_id_fkey FOREIGN KEY (customer_id)
        REFERENCES public.customer (customer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.payment
    OWNER to postgres;