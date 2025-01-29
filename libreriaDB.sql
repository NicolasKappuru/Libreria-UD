CREATE TABLE public.usuario (
	idusuario integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	nombre varchar(255) NOT NULL,
	contrasena varchar(255) NOT NULL,
	correoelectronico varchar(255) NOT NULL,
	direccionfisica varchar(255) NOT NULL,
	numerotelefonico varchar(255) NOT NULL,
	tipo varchar(255) NOT NULL,
	CONSTRAINT usuario_pk PRIMARY KEY (idusuario),
	CONSTRAINT usuario_unique UNIQUE (nombre)
);

CREATE TABLE public.documento (
	iddocumento integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	titulo varchar(255) NOT NULL,
	fechapublicacion date NOT NULL,
	autores varchar(255) NOT NULL,
	mespublicacion varchar(10) NOT NULL,
	diapublicacion varchar(10) NOT NULL,
	editorial varchar(255) NOT NULL,
	estado varchar(11) NOT NULL,
	propietario smallint NOT NULL,
	CONSTRAINT documento_pk PRIMARY KEY (iddocumento),
	CONSTRAINT "usuario_FK" FOREIGN KEY (propietario) REFERENCES public.usuario(idusuario)
);

CREATE TABLE public.reserva (
	idreserva integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	fechareserva date NOT NULL,
	fechaentrega date NULL,
	estado varchar(10) NOT NULL,
	documento integer NOT NULL,
	usuario integer NOT NULL,
	CONSTRAINT reserva_pk PRIMARY KEY (idreserva),
	CONSTRAINT "usuario_FK" FOREIGN KEY (usuario) REFERENCES public.usuario(idusuario),
	CONSTRAINT "documento_FK" FOREIGN KEY (documento) REFERENCES public.documento(iddocumento)
);

CREATE TABLE public.evento (
	idevento integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	tipoevento varchar NOT NULL,
	archivo varchar(255) NULL,
	usuario integer NOT NULL,
	documento integer NOT NULL,
	CONSTRAINT evento_pk PRIMARY KEY (idevento),
	CONSTRAINT "documento_FK" FOREIGN KEY (documento) REFERENCES public.documento(iddocumento),
	CONSTRAINT "usuario_FK" FOREIGN KEY (usuario) REFERENCES public.usuario(idusuario)
);

CREATE TABLE public.libro (
	idlibro integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	numeropaginas smallint NOT NULL,
	isbn varchar NOT NULL,
	documento integer NOT NULL,
	CONSTRAINT libro_pk PRIMARY KEY (idlibro),
	CONSTRAINT libro_unique UNIQUE (documento),
	CONSTRAINT "documento_FK" FOREIGN KEY (documento) REFERENCES public.documento(iddocumento)
);

CREATE TABLE public.ponencia (
	idponencia integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	congreso varchar(255) NOT NULL,
	isbn varchar NOT NULL,
	documento integer NOT NULL,
	CONSTRAINT ponencia_pk PRIMARY KEY (idponencia),
	CONSTRAINT ponencia_unique UNIQUE (documento),
	CONSTRAINT "documento_FK" FOREIGN KEY (documento) REFERENCES public.documento(iddocumento)
);

CREATE TABLE public.articulo (
	idarticulo integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	ssn varchar NOT NULL,
	documento integer NOT NULL,
	CONSTRAINT articulo_pk PRIMARY KEY (idarticulo),
	CONSTRAINT articulo_unique UNIQUE (documento),
	CONSTRAINT "documento_FK" FOREIGN KEY (documento) REFERENCES public.documento(iddocumento)
);
