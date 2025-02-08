-- Eliminar tablas si existen en orden inverso para evitar conflictos con FK
DROP TABLE IF EXISTS public.articulo CASCADE;
DROP TABLE IF EXISTS public.ponencia CASCADE;
DROP TABLE IF EXISTS public.libro CASCADE;
DROP TABLE IF EXISTS public.evento CASCADE;
DROP TABLE IF EXISTS public.reserva CASCADE;
DROP TABLE IF EXISTS public.documento CASCADE;
DROP TABLE IF EXISTS public.usuario CASCADE;

-- Crear la tabla usuario con PK en 'nombre'
CREATE TABLE public.usuario (
    nombre varchar(255) NOT NULL,
    contrasena varchar(255) NOT NULL,
    correoelectronico varchar(255) NOT NULL,
    direccionfisica varchar(255) NOT NULL,
    numerotelefonico varchar(255) NOT NULL,
    tipo varchar(255) NOT NULL,
    CONSTRAINT usuario_pk PRIMARY KEY (nombre)
);

-- Crear la tabla documento con FK a usuario(nombre)
CREATE TABLE public.documento (
    iddocumento integer GENERATED ALWAYS AS IDENTITY NOT NULL,
    titulo varchar(255),
    fechapublicacion date,
    autores varchar(255),
    mespublicacion varchar(10),
    diapublicacion varchar(10),
    editorial varchar(255),
    estado varchar(11) NOT NULL,
    propietario varchar(255) NOT NULL,
    CONSTRAINT documento_pk PRIMARY KEY (iddocumento),
    CONSTRAINT "usuario_FK" FOREIGN KEY (propietario) REFERENCES public.usuario(nombre) ON DELETE CASCADE
);

-- Crear la tabla reserva con FK a documento y usuario(nombre)
CREATE TABLE public.reserva (
    idreserva integer GENERATED ALWAYS AS IDENTITY NOT NULL,
    fechareserva date NOT NULL,
    fechaentrega date NULL,
    estado varchar(10) NOT NULL,
    documento integer NOT NULL,
    usuario varchar(255) NOT NULL,
    CONSTRAINT reserva_pk PRIMARY KEY (idreserva),
    CONSTRAINT "usuario_FK" FOREIGN KEY (usuario) REFERENCES public.usuario(nombre) ON DELETE CASCADE,
    CONSTRAINT "documento_FK" FOREIGN KEY (documento) REFERENCES public.documento(iddocumento) ON DELETE CASCADE
);

-- Crear la tabla evento con FK a documento y usuario(nombre)
CREATE TABLE public.evento (
    idevento integer GENERATED ALWAYS AS IDENTITY NOT NULL,
    tipoevento varchar NOT NULL,
    usuario varchar(255) NOT NULL,
    documento integer NOT NULL,
    CONSTRAINT evento_pk PRIMARY KEY (idevento),
    CONSTRAINT "documento_FK" FOREIGN KEY (documento) REFERENCES public.documento(iddocumento) ON DELETE CASCADE,
    CONSTRAINT "usuario_FK" FOREIGN KEY (usuario) REFERENCES public.usuario(nombre) ON DELETE CASCADE
);

-- Crear la tabla libro con PK y FK en documento
CREATE TABLE public.libro (
    iddocumento integer NOT NULL,
    numeropaginas smallint
    isbn varchar,
    CONSTRAINT libro_pk PRIMARY KEY (iddocumento),
    CONSTRAINT "documento_FK" FOREIGN KEY (iddocumento) REFERENCES public.documento(iddocumento) ON DELETE CASCADE
);

-- Crear la tabla ponencia con PK y FK en documento
CREATE TABLE public.ponencia (
    iddocumento integer NOT NULL,
    congreso varchar(255),
    isbn varchar,
    CONSTRAINT ponencia_pk PRIMARY KEY (iddocumento),
    CONSTRAINT "documento_FK" FOREIGN KEY (iddocumento) REFERENCES public.documento(iddocumento) ON DELETE CASCADE
);

-- Crear la tabla articulo con PK y FK en documento
CREATE TABLE public.articulo (
    iddocumento integer NOT NULL,
    ssn varchar,
    CONSTRAINT articulo_pk PRIMARY KEY (iddocumento),
    CONSTRAINT "documento_FK" FOREIGN KEY (iddocumento) REFERENCES public.documento(iddocumento) ON DELETE CASCADE
);
