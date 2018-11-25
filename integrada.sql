--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.19
-- Dumped by pg_dump version 9.4.19
-- Started on 2018-09-13 14:01:10

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2062 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 173 (class 1259 OID 16750)
-- Name: estado_viaje; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.estado_viaje (
    id_estado bigint NOT NULL,
    descripcion character varying(15)
);


ALTER TABLE public.estado_viaje OWNER TO postgres;

--
-- TOC entry 2063 (class 0 OID 0)
-- Dependencies: 173
-- Name: TABLE estado_viaje; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.estado_viaje IS 'Tabla parametrica del estado de los viajes';


--
-- TOC entry 174 (class 1259 OID 16753)
-- Name: estado_viaje_id_estado_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.estado_viaje_id_estado_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.estado_viaje_id_estado_seq OWNER TO postgres;

--
-- TOC entry 2064 (class 0 OID 0)
-- Dependencies: 174
-- Name: estado_viaje_id_estado_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.estado_viaje_id_estado_seq OWNED BY public.estado_viaje.id_estado;


--
-- TOC entry 175 (class 1259 OID 16755)
-- Name: reserva; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.reserva (
    id_reserva bigint NOT NULL,
    id_usuario integer NOT NULL,
    id_viaje integer NOT NULL,
    cupos integer NOT NULL,
    valor numeric(5,0) NOT NULL,
    act_esta text NOT NULL,
    act_hora date NOT NULL
);


ALTER TABLE public.reserva OWNER TO postgres;

--
-- TOC entry 2065 (class 0 OID 0)
-- Dependencies: 175
-- Name: TABLE reserva; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.reserva IS 'Tabla Historica de las reservas';


--
-- TOC entry 176 (class 1259 OID 16758)
-- Name: reserva_id_reserva_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.reserva_id_reserva_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reserva_id_reserva_seq OWNER TO postgres;

--
-- TOC entry 2066 (class 0 OID 0)
-- Dependencies: 176
-- Name: reserva_id_reserva_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.reserva_id_reserva_seq OWNED BY public.reserva.id_reserva;


--
-- TOC entry 177 (class 1259 OID 16760)
-- Name: tipo_usuario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.tipo_usuario (
    id_tipo bigint NOT NULL,
    description character varying(15) NOT NULL
);


ALTER TABLE public.tipo_usuario OWNER TO postgres;

--
-- TOC entry 2067 (class 0 OID 0)
-- Dependencies: 177
-- Name: TABLE tipo_usuario; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.tipo_usuario IS 'Tabla parametrica de los tipos de usuario';


--
-- TOC entry 178 (class 1259 OID 16763)
-- Name: tipo_usuario_id_tipo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_usuario_id_tipo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_usuario_id_tipo_seq OWNER TO postgres;

--
-- TOC entry 2068 (class 0 OID 0)
-- Dependencies: 178
-- Name: tipo_usuario_id_tipo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_usuario_id_tipo_seq OWNED BY public.tipo_usuario.id_tipo;


--
-- TOC entry 179 (class 1259 OID 16765)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.usuario (
    id_usuario bigint NOT NULL,
    user_name character varying(15) NOT NULL,
    pass character varying(50) NOT NULL,
    activo character varying(15) NOT NULL,
    act_hora date NOT NULL,
    id_tipo integer
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 2069 (class 0 OID 0)
-- Dependencies: 179
-- Name: TABLE usuario; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.usuario IS 'Tabla principal de usuarios';


--
-- TOC entry 180 (class 1259 OID 16768)
-- Name: usuario_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_id_usuario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_id_usuario_seq OWNER TO postgres;

--
-- TOC entry 2070 (class 0 OID 0)
-- Dependencies: 180
-- Name: usuario_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuario_id_usuario_seq OWNED BY public.usuario.id_usuario;


--
-- TOC entry 181 (class 1259 OID 16770)
-- Name: viaje; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.viaje (
    id_viaje bigint NOT NULL,
    id_estado integer NOT NULL,
    origen character varying(50) NOT NULL,
    destino character varying(50) NOT NULL,
    fec_inicio date NOT NULL,
    fec_fin date NOT NULL,
    id_usuario integer NOT NULL,
    cupos integer NOT NULL,
    valor_cupo numeric(5,0) NOT NULL,
    act_hora date NOT NULL,
    id_tipo integer
);


ALTER TABLE public.viaje OWNER TO postgres;

--
-- TOC entry 2071 (class 0 OID 0)
-- Dependencies: 181
-- Name: TABLE viaje; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.viaje IS 'Tabla historica de los viajes';


--
-- TOC entry 182 (class 1259 OID 16773)
-- Name: viaje_id_viaje_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.viaje_id_viaje_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.viaje_id_viaje_seq OWNER TO postgres;

--
-- TOC entry 2072 (class 0 OID 0)
-- Dependencies: 182
-- Name: viaje_id_viaje_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.viaje_id_viaje_seq OWNED BY public.viaje.id_viaje;


--
-- TOC entry 1906 (class 2604 OID 16775)
-- Name: id_estado; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estado_viaje ALTER COLUMN id_estado SET DEFAULT nextval('public.estado_viaje_id_estado_seq'::regclass);


--
-- TOC entry 1907 (class 2604 OID 16776)
-- Name: id_reserva; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reserva ALTER COLUMN id_reserva SET DEFAULT nextval('public.reserva_id_reserva_seq'::regclass);


--
-- TOC entry 1908 (class 2604 OID 16777)
-- Name: id_tipo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_usuario ALTER COLUMN id_tipo SET DEFAULT nextval('public.tipo_usuario_id_tipo_seq'::regclass);


--
-- TOC entry 1909 (class 2604 OID 16778)
-- Name: id_usuario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario ALTER COLUMN id_usuario SET DEFAULT nextval('public.usuario_id_usuario_seq'::regclass);


--
-- TOC entry 1910 (class 2604 OID 16779)
-- Name: id_viaje; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.viaje ALTER COLUMN id_viaje SET DEFAULT nextval('public.viaje_id_viaje_seq'::regclass);


--
-- TOC entry 2044 (class 0 OID 16750)
-- Dependencies: 173
-- Data for Name: estado_viaje; Type: TABLE DATA; Schema: public; Owner: postgres
--




--
-- TOC entry 2073 (class 0 OID 0)
-- Dependencies: 174
-- Name: estado_viaje_id_estado_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.estado_viaje_id_estado_seq', 1, true);


--
-- TOC entry 2046 (class 0 OID 16755)
-- Dependencies: 175
-- Data for Name: reserva; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2074 (class 0 OID 0)
-- Dependencies: 176
-- Name: reserva_id_reserva_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reserva_id_reserva_seq', 2, true);


--
-- TOC entry 2048 (class 0 OID 16760)
-- Dependencies: 177
-- Data for Name: tipo_usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2075 (class 0 OID 0)
-- Dependencies: 178
-- Name: tipo_usuario_id_tipo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_usuario_id_tipo_seq', 1, true);


--
-- TOC entry 2050 (class 0 OID 16765)
-- Dependencies: 179
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2076 (class 0 OID 0)
-- Dependencies: 180
-- Name: usuario_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_id_usuario_seq', 1, true);


--
-- TOC entry 2052 (class 0 OID 16770)
-- Dependencies: 181
-- Data for Name: viaje; Type: TABLE DATA; Schema: public; Owner: postgres
--

--
-- TOC entry 2077 (class 0 OID 0)
-- Dependencies: 182
-- Name: viaje_id_viaje_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.viaje_id_viaje_seq', 6, true);


--
-- TOC entry 1912 (class 2606 OID 16781)
-- Name: pk_estado_viaje; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.estado_viaje
    ADD CONSTRAINT pk_estado_viaje PRIMARY KEY (id_estado);


--
-- TOC entry 1917 (class 2606 OID 16783)
-- Name: pk_reserva; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.reserva
    ADD CONSTRAINT pk_reserva PRIMARY KEY (id_reserva);


--
-- TOC entry 1919 (class 2606 OID 16785)
-- Name: pk_tipo_usuario; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.tipo_usuario
    ADD CONSTRAINT pk_tipo_usuario PRIMARY KEY (id_tipo);


--
-- TOC entry 1922 (class 2606 OID 16787)
-- Name: pk_usuario; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT pk_usuario PRIMARY KEY (id_usuario);


--
-- TOC entry 1929 (class 2606 OID 16789)
-- Name: pk_viaje; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.viaje
    ADD CONSTRAINT pk_viaje PRIMARY KEY (id_viaje);


--
-- TOC entry 1913 (class 1259 OID 16790)
-- Name: ixfk_reserva_usuario; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ixfk_reserva_usuario ON public.reserva USING btree (id_usuario);


--
-- TOC entry 1914 (class 1259 OID 16791)
-- Name: ixfk_reserva_usuario_02; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ixfk_reserva_usuario_02 ON public.reserva USING btree (id_usuario);


--
-- TOC entry 1915 (class 1259 OID 16792)
-- Name: ixfk_reserva_viaje; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ixfk_reserva_viaje ON public.reserva USING btree (id_viaje);


--
-- TOC entry 1920 (class 1259 OID 16793)
-- Name: ixfk_usuario_tipo_usuario; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ixfk_usuario_tipo_usuario ON public.usuario USING btree (id_tipo);


--
-- TOC entry 1923 (class 1259 OID 16794)
-- Name: ixfk_viaje_estado_viaje; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ixfk_viaje_estado_viaje ON public.viaje USING btree (id_estado);


--
-- TOC entry 1924 (class 1259 OID 16795)
-- Name: ixfk_viaje_estado_viaje_02; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ixfk_viaje_estado_viaje_02 ON public.viaje USING btree (id_estado);


--
-- TOC entry 1925 (class 1259 OID 16796)
-- Name: ixfk_viaje_tipo_usuario; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ixfk_viaje_tipo_usuario ON public.viaje USING btree (id_tipo);


--
-- TOC entry 1926 (class 1259 OID 16797)
-- Name: ixfk_viaje_usuario; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ixfk_viaje_usuario ON public.viaje USING btree (id_usuario);


--
-- TOC entry 1927 (class 1259 OID 16798)
-- Name: ixfk_viaje_usuario_02; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ixfk_viaje_usuario_02 ON public.viaje USING btree (id_usuario);


--
-- TOC entry 1930 (class 2606 OID 16799)
-- Name: fk_reserva_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reserva
    ADD CONSTRAINT fk_reserva_usuario FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario);


--
-- TOC entry 1931 (class 2606 OID 16804)
-- Name: fk_reserva_viaje; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reserva
    ADD CONSTRAINT fk_reserva_viaje FOREIGN KEY (id_viaje) REFERENCES public.viaje(id_viaje);


--
-- TOC entry 1932 (class 2606 OID 16809)
-- Name: fk_usuario_tipo_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT fk_usuario_tipo_usuario FOREIGN KEY (id_tipo) REFERENCES public.tipo_usuario(id_tipo);


--
-- TOC entry 1933 (class 2606 OID 16814)
-- Name: fk_viaje_estado_viaje; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.viaje
    ADD CONSTRAINT fk_viaje_estado_viaje FOREIGN KEY (id_estado) REFERENCES public.estado_viaje(id_estado);


--
-- TOC entry 1934 (class 2606 OID 16819)
-- Name: fk_viaje_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.viaje
    ADD CONSTRAINT fk_viaje_usuario FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario);


--
-- TOC entry 2061 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2018-09-13 14:01:10

--
-- PostgreSQL database dump complete
--

