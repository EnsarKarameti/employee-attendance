--
-- PostgreSQL database dump
--

-- Dumped from database version 11.6
-- Dumped by pg_dump version 11.6

-- Started on 2020-01-30 14:17:00

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 199 (class 1259 OID 16655)
-- Name: admin; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.admin (
    id integer NOT NULL,
    name text NOT NULL,
    surname text NOT NULL,
    email text NOT NULL,
    password text NOT NULL,
    phone text NOT NULL
);


ALTER TABLE public.admin OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16653)
-- Name: admin_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.admin_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.admin_id_seq OWNER TO postgres;

--
-- TOC entry 2851 (class 0 OID 0)
-- Dependencies: 198
-- Name: admin_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.admin_id_seq OWNED BY public.admin.id;


--
-- TOC entry 197 (class 1259 OID 16640)
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee (
    id integer NOT NULL,
    name text NOT NULL,
    surname text NOT NULL,
    email text NOT NULL,
    password text NOT NULL,
    phone text NOT NULL
);


ALTER TABLE public.employee OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16638)
-- Name: employee_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.employee_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employee_id_seq OWNER TO postgres;

--
-- TOC entry 2852 (class 0 OID 0)
-- Dependencies: 196
-- Name: employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.employee_id_seq OWNED BY public.employee.id;


--
-- TOC entry 201 (class 1259 OID 16685)
-- Name: hours; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hours (
    recdate date DEFAULT now() NOT NULL,
    checkin timestamp without time zone DEFAULT now() NOT NULL,
    checkout timestamp without time zone,
    employeeid integer NOT NULL,
    month integer NOT NULL,
    year integer NOT NULL
);


ALTER TABLE public.hours OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16683)
-- Name: hours_employeeid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hours_employeeid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hours_employeeid_seq OWNER TO postgres;

--
-- TOC entry 2853 (class 0 OID 0)
-- Dependencies: 200
-- Name: hours_employeeid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.hours_employeeid_seq OWNED BY public.hours.employeeid;


--
-- TOC entry 2700 (class 2604 OID 16658)
-- Name: admin id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admin ALTER COLUMN id SET DEFAULT nextval('public.admin_id_seq'::regclass);


--
-- TOC entry 2699 (class 2604 OID 16643)
-- Name: employee id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee ALTER COLUMN id SET DEFAULT nextval('public.employee_id_seq'::regclass);


--
-- TOC entry 2703 (class 2604 OID 16690)
-- Name: hours employeeid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hours ALTER COLUMN employeeid SET DEFAULT nextval('public.hours_employeeid_seq'::regclass);


--
-- TOC entry 2843 (class 0 OID 16655)
-- Dependencies: 199
-- Data for Name: admin; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.admin (id, name, surname, email, password, phone) VALUES (1, 'admin', 'admin', 'admin@admin.com', '123456', '00112233');


--
-- TOC entry 2841 (class 0 OID 16640)
-- Dependencies: 197
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.employee (id, name, surname, email, password, phone) VALUES (1, 'Test', 'Test', 'test@test.com', '123456', '0012300');
INSERT INTO public.employee (id, name, surname, email, password, phone) VALUES (2, 'Test1', 'Test1', 'test1@test.com', '123456', '0011223344');
INSERT INTO public.employee (id, name, surname, email, password, phone) VALUES (4, 'test2', 'test2', 'test2@test.com', '123456', '001122334455');


--
-- TOC entry 2845 (class 0 OID 16685)
-- Dependencies: 201
-- Data for Name: hours; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.hours (recdate, checkin, checkout, employeeid, month, year) VALUES ('2020-01-30', '2020-01-30 13:06:28.796', NULL, 1, 1, 2020);
INSERT INTO public.hours (recdate, checkin, checkout, employeeid, month, year) VALUES ('2020-01-30', '2020-01-30 13:06:35.641', NULL, 2, 1, 2020);
INSERT INTO public.hours (recdate, checkin, checkout, employeeid, month, year) VALUES ('2020-01-30', '2020-01-30 13:06:42.64', NULL, 4, 1, 2020);


--
-- TOC entry 2854 (class 0 OID 0)
-- Dependencies: 198
-- Name: admin_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.admin_id_seq', 1, true);


--
-- TOC entry 2855 (class 0 OID 0)
-- Dependencies: 196
-- Name: employee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.employee_id_seq', 4, true);


--
-- TOC entry 2856 (class 0 OID 0)
-- Dependencies: 200
-- Name: hours_employeeid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hours_employeeid_seq', 1, false);


--
-- TOC entry 2711 (class 2606 OID 16665)
-- Name: admin admin_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admin
    ADD CONSTRAINT admin_email_key UNIQUE (email);


--
-- TOC entry 2713 (class 2606 OID 16667)
-- Name: admin admin_phone_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admin
    ADD CONSTRAINT admin_phone_key UNIQUE (phone);


--
-- TOC entry 2715 (class 2606 OID 16663)
-- Name: admin admin_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admin
    ADD CONSTRAINT admin_pkey PRIMARY KEY (id);


--
-- TOC entry 2705 (class 2606 OID 16650)
-- Name: employee employee_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_email_key UNIQUE (email);


--
-- TOC entry 2707 (class 2606 OID 16652)
-- Name: employee employee_phone_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_phone_key UNIQUE (phone);


--
-- TOC entry 2709 (class 2606 OID 16648)
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);


--
-- TOC entry 2717 (class 2606 OID 16692)
-- Name: hours hours_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hours
    ADD CONSTRAINT hours_pkey PRIMARY KEY (employeeid, recdate);


--
-- TOC entry 2718 (class 2606 OID 16693)
-- Name: hours hours_employeeid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hours
    ADD CONSTRAINT hours_employeeid_fkey FOREIGN KEY (employeeid) REFERENCES public.employee(id);


-- Completed on 2020-01-30 14:17:01

--
-- PostgreSQL database dump complete
--

