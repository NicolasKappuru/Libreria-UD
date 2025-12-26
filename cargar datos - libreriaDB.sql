-- ==================================================
-- USUARIOS
-- ==================================================
INSERT INTO public.usuario
(nombre, contrasena, correoelectronico, direccionfisica, numerotelefonico)
VALUES
('Admin', '1234', 'admin@libreria.com', 'Calle Principal 100', '3001001000'),
('Juan', '1234', 'juan@correo.com', 'Carrera 10 20 30', '3002002000'),
('Maria', '1234', 'maria@correo.com', 'Avenida 5 15 60', '3003003000'),
('Carlos', '1234', 'carlos@correo.com', 'Calle 8 45 90', '3004004000'),
('Ana', '1234', 'ana@correo.com', 'Carrera 7 11 22', '3005005000');

-- ==================================================
-- DOCUMENTOS
-- ==================================================
INSERT INTO public.documento
(titulo, fechapublicacion, autores, mespublicacion, diapublicacion, editorial, estado, propietario, tipo)
VALUES
-- Libros
('Ingenieria de Software', '2018-06-15', 'Ian Sommerville', 'Junio', '15', 'Pearson', 'Disponible', 'Admin', 'libro'),
('Bases de Software Libre', '2019-03-10', 'Richard Stallman', 'Marzo', '10', 'GNU Press', 'Disponible', 'Juan', 'libro'),
('Bases de Redes de Comunicacion', '2020-09-20', 'Andrew Tanenbaum', 'Septiembre', '20', 'Pearson', 'Disponible', 'Maria', 'libro'),
('Ingenieria de Requisitos de Software', '2017-11-05', 'Karl Wiegers', 'Noviembre', '05', 'Microsoft Press', 'Reservado', 'Carlos', 'libro'),
('Arquitectura de Software Moderna', '2021-01-18', 'Len Bass', 'Enero', '18', 'Addison Wesley', 'Disponible', 'Ana', 'libro'),

-- Articulos
('Software Libre en la Ingenieria Moderna', '2022-04-12', 'Laura Gomez', 'Abril', '12', 'IEEE', 'Disponible', 'Admin', 'articulo'),
('Bases de Datos y Software Distribuido', '2021-08-30', 'Miguel Torres', 'Agosto', '30', 'ACM', 'Disponible', 'Juan', 'articulo'),
('Redes de Comunicacion en la Nube', '2020-12-02', 'Sofia Martinez', 'Diciembre', '02', 'Springer', 'Reservado', 'Maria', 'articulo'),

-- Ponencias
('Ingenieria de Software en la Industria', '2019-10-14', 'Carlos Ruiz', 'Octubre', '14', 'ACM', 'Disponible', 'Carlos', 'ponencia'),
('Bases de Redes y Software Empresarial', '2023-02-22', 'Ana Lopez', 'Febrero', '22', 'IEEE', 'Disponible', 'Ana', 'ponencia'),
('Software Libre y Redes Abiertas', '2022-06-09', 'Pedro Ramirez', 'Junio', '09', 'GNU Conference', 'Eliminado', 'Admin', 'ponencia');

-- ==================================================
-- LIBROS
-- ==================================================
INSERT INTO public.libro
(iddocumento, numeropaginas, isbn)
VALUES
(1, 550, '9780137035151'),
(2, 320, '9781882114986'),
(3, 480, '9780132126953'),
(4, 410, '9780735626086'),
(5, 360, '9780321815736');

-- ==================================================
-- ARTICULOS
-- ==================================================
INSERT INTO public.articulo
(iddocumento, ssn)
VALUES
(6, '1111-2222'),
(7, '3333-4444'),
(8, '5555-6666');

-- ==================================================
-- PONENCIAS
-- ==================================================
INSERT INTO public.ponencia
(iddocumento, congreso, isbn)
VALUES
(9, 'Congreso Internacional de Software', '9789580000001'),
(10, 'Simposio de Redes y Software', '9789580000002'),
(11, 'Encuentro de Software Libre', '9789580000003');

-- ==================================================
-- RESERVAS
-- ==================================================
INSERT INTO public.reserva
(fechareserva, fechaentrega, estado, documento, usuario)
VALUES
('2025-01-05', '2025-01-15', 'Reservado', 1, 'Juan'),
('2025-01-07', '2025-01-20', 'Entregado', 3, 'Maria'),
('2025-01-10', NULL, 'Reservado', 4, 'Carlos'),
('2025-01-12', '2025-01-22', 'Entregado', 6, 'Ana');

-- ==================================================
-- EVENTOS
-- ==================================================
INSERT INTO public.evento
(tipoevento, usuario, documento, fechaevento)
VALUES
('Reserva', 'Juan', 1, '2025-01-05'),
('Entrega', 'Maria', 3, '2025-01-20'),
('Consulta', 'Admin', 2, '2025-01-08'),
('Reserva', 'Carlos', 4, '2025-01-10'),
('Consulta', 'Ana', 7, '2025-01-12');
