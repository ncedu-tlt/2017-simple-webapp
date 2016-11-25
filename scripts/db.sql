--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.1
-- Dumped by pg_dump version 9.6.1

-- Started on 2016-11-25 18:29:06

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE simpleweb;
--
-- TOC entry 2128 (class 1262 OID 16393)
-- Name: simpleweb; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE simpleweb WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';


ALTER DATABASE simpleweb OWNER TO postgres;

\connect simpleweb

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner:
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2130 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner:
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 186 (class 1259 OID 16396)
-- Name: category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE category (
  id integer NOT NULL,
  name character varying(100) NOT NULL,
  description character varying(1000)
);


ALTER TABLE category OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 16394)
-- Name: category_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE category_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;


ALTER TABLE category_id_seq OWNER TO postgres;

--
-- TOC entry 2131 (class 0 OID 0)
-- Dependencies: 185
-- Name: category_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE category_id_seq OWNED BY category.id;


--
-- TOC entry 2002 (class 2604 OID 16399)
-- Name: category id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY category ALTER COLUMN id SET DEFAULT nextval('category_id_seq'::regclass);


--
-- TOC entry 2123 (class 0 OID 16396)
-- Dependencies: 186
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO category (id, name, description) VALUES (1, 'Category A', 'test category');
INSERT INTO category (id, name, description) VALUES (2, 'Category B', 'test category');
INSERT INTO category (id, name, description) VALUES (3, 'Category C', 'test category');


--
-- TOC entry 2132 (class 0 OID 0)
-- Dependencies: 185
-- Name: category_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('category_id_seq', 3, true);


--
-- TOC entry 2004 (class 2606 OID 16404)
-- Name: category category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY category
  ADD CONSTRAINT category_pkey PRIMARY KEY (id);


-- Completed on 2016-11-25 18:29:06

--
-- PostgreSQL database dump complete
--

