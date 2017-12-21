--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.7
-- Dumped by pg_dump version 9.5.7

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: appconfiguration; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE appconfiguration (
    propertykey character varying(30),
    propertyvalue text
);


ALTER TABLE appconfiguration OWNER TO postgres;

--
-- Name: translate; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE translate (
    code character varying(50),
    en text,
    es text
);


ALTER TABLE translate OWNER TO postgres;

--
-- Data for Name: appconfiguration; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY appconfiguration (propertykey, propertyvalue) FROM stdin;
delay.ajax	3000
\.


--
-- Data for Name: translate; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY translate (code, en, es) FROM stdin;
home-ubigeo-link	Ubications	Ubicaciones
txt-departament	Departament	Departamento
txt-province	Province	Provincia
txt-district	District	Distrito
txt-description	Description	Descripcion
txt-actions	Actions	Acciones
txt-add	Add	Agregar
txt-edit	Edit	Editar
txt-drop	Delete	Eliminar
txt-save	Save	Guardar
ubigeo-list-find-placeholder	Name of department, province or district.	Nombre de departamento, provincia o distrito.
txt-code	Code	Codigo
txt-find	Find	Buscar
ubigeo-create-title	Register of Ubigeo	Registro de ubigeo
txt-go-back	Go Back	Atrás
\.


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

