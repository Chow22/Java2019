-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-03-2020 a las 13:08:29
-- Versión del servidor: 10.1.19-MariaDB
-- Versión de PHP: 7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mf0966_3`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `codigo` int(11) NOT NULL COMMENT 'el campo clave de la tabla. Es auto generado.',
  `nombre` varchar(50) COLLATE utf8_bin NOT NULL,
  `apellidos` varchar(250) COLLATE utf8_bin NOT NULL,
  `fNacimiento` date DEFAULT NULL,
  `direccion` varchar(250) COLLATE utf8_bin DEFAULT NULL,
  `poblacion` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `codigopostal` int(5) UNSIGNED ZEROFILL DEFAULT NULL,
  `telefono` int(11) NOT NULL,
  `email` varchar(150) COLLATE utf8_bin NOT NULL,
  `dni` varchar(9) COLLATE utf8_bin NOT NULL,
  `nHermanos` int(11) DEFAULT '0',
  `activo` tinyint(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`codigo`, `nombre`, `apellidos`, `fNacimiento`, `direccion`, `poblacion`, `codigopostal`, `telefono`, `email`, `dni`, `nHermanos`, `activo`) VALUES
(0, 'alumno', 'sin asignar', NULL, NULL, NULL, 00000, 0, 'aaaaaaa@aaaaa.com', '0000000x', 0, 0),
(1, 'sergio', 'aparicio vargas', '1977-12-01', '', '', 00000, 944110293, 'aaaa@aaaa.com', '44974398z', 0, 1),
(2, 'maite', 'monasterio', '1986-11-11', '', '', 48007, 944110293, 'mmonasterio@gmail.com', '16071559x', 0, 1),
(4, 'enrique javier', 'ruiz jimenez', '2017-02-14', '', '', 00048, 944110239, 'enrique@gmail.com', '45677362y', 0, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `codigo` int(11) NOT NULL,
  `nombre` text COLLATE utf8_bin NOT NULL,
  `email` varchar(150) COLLATE utf8_bin NOT NULL,
  `telefono` int(11) NOT NULL,
  `direccion` varchar(250) COLLATE utf8_bin DEFAULT NULL,
  `poblacion` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `codigopostal` int(5) UNSIGNED ZEROFILL DEFAULT NULL,
  `identificador` varchar(15) COLLATE utf8_bin NOT NULL,
  `activo` tinyint(4) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`codigo`, `nombre`, `email`, `telefono`, `direccion`, `poblacion`, `codigopostal`, `identificador`, `activo`) VALUES
(0, 'Sin Definir', 'aaaaaa@aaaaa.com', 9444, NULL, NULL, NULL, '#######', 0),
(1, 'SERIKAT CONSULTORÍA E INFORMÁTICA, S.A.', 'info@serikat.es', 944250100, 'c/ Ercilla 19', 'Bilbao', 48009, 'A-48476006', 1),
(2, 'lanbide - servicio vasco de empleo', 'info@lanbide.net', 945160601, 'Jose Atxotegi 1', 'Vitoria-Gazteiz', 01009, 'Q0100571l', 1),
(3, 'hobetuz', 'bizkaia@hobetuz.eus', 944150808, 'gran vía, 35-6º', NULL, NULL, 'g48850127', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

CREATE TABLE `curso` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(100) COLLATE utf8_bin NOT NULL,
  `identificador` varchar(12) COLLATE utf8_bin NOT NULL,
  `fInicio` date DEFAULT NULL,
  `fFin` date DEFAULT NULL,
  `nHoras` int(11) NOT NULL,
  `temario` text COLLATE utf8_bin,
  `activo` tinyint(4) DEFAULT '1',
  `cliente_codigo` int(11) DEFAULT NULL,
  `precio` double(8,2) DEFAULT '0.00',
  `profesor_codigo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `curso`
--

INSERT INTO `curso` (`codigo`, `nombre`, `identificador`, `fInicio`, `fFin`, `nHoras`, `temario`, `activo`, `cliente_codigo`, `precio`, `profesor_codigo`) VALUES
(1, 'Desarrrollo de Aplicaciones con Tecnologias Web', '18482675', '2017-01-09', '2017-06-13', 510, NULL, 1, 2, 300000.00, 1),
(2, 'Desarrollo de Bases de Datos y Programacion orientada a Objetos', '18488225', '2017-02-20', '2017-09-29', 630, 'IFCD0112_FIC.pdf', 1, 2, 400000.00, 1),
(3, 'Publicidad en internet', '18482678', '2017-03-27', '2017-03-30', 10, NULL, 1, 3, 1500.00, 1),
(4, 'Programación en Bases de Datos relaciones con Oracle 12c', 'CI67', '2017-05-02', '2017-05-30', 30, 'CI67.pdf', 1, 3, 3500.00, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imparticion`
--

CREATE TABLE `imparticion` (
  `codigo` int(11) NOT NULL,
  `curso_codigo` int(11) NOT NULL,
  `alumno_codigo` int(11) NOT NULL,
  `fMatriculacion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `imparticion`
--

INSERT INTO `imparticion` (`codigo`, `curso_codigo`, `alumno_codigo`, `fMatriculacion`) VALUES
(9, 3, 2, NULL),
(10, 3, 4, NULL),
(15, 2, 1, NULL),
(16, 2, 2, NULL),
(17, 2, 4, NULL),
(48, 1, 1, NULL),
(49, 1, 2, NULL),
(50, 1, 4, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

CREATE TABLE `profesor` (
  `codigo` int(11) NOT NULL,
  `NSS` bigint(20) DEFAULT NULL,
  `nombre` varchar(50) COLLATE utf8_bin NOT NULL,
  `apellidos` varchar(250) COLLATE utf8_bin NOT NULL,
  `fNacimiento` date DEFAULT NULL,
  `DNI` varchar(9) COLLATE utf8_bin NOT NULL,
  `direccion` varchar(250) COLLATE utf8_bin DEFAULT NULL,
  `poblacion` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `codigopostal` int(5) UNSIGNED ZEROFILL DEFAULT NULL,
  `telefono` int(11) NOT NULL,
  `email` varchar(150) COLLATE utf8_bin NOT NULL,
  `activo` tinyint(4) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`codigo`, `NSS`, `nombre`, `apellidos`, `fNacimiento`, `DNI`, `direccion`, `poblacion`, `codigopostal`, `telefono`, `email`, `activo`) VALUES
(0, 0, 'profesor', 'sin asignar', NULL, '00000000z', NULL, NULL, NULL, 0, 'aaaaaaaa@aaaaa.aaa', 0),
(1, 481234567840, 'Ander', 'Ipartek', '1976-11-24', '30693142x', 'Av. Mazustegi 9', 'Bilbao', 48009, 944110293, 'auraga@ipartek.com', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `resena`
--

CREATE TABLE `resena` (
  `id` bigint(20) NOT NULL,
  `resena` varchar(250) COLLATE utf8_bin DEFAULT NULL,
  `calificacion` int(2) DEFAULT NULL,
  `id_alumno` int(11) NOT NULL,
  `id_imparticion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `resena`
--

INSERT INTO `resena` (`id`, `resena`, `calificacion`, `id_alumno`, `id_imparticion`) VALUES
(1, 'Muy buen curso', 9, 1, 10),
(2, 'Muy contento con lo aprendido', 7, 2, 48),
(3, 'Fatal no he aprendido nada', 2, 1, 15);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `dni_UNIQUE` (`dni`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_curso_cliente_codigo_idx` (`cliente_codigo`),
  ADD KEY `fk_curso_profesor_codigo_idx` (`profesor_codigo`);

--
-- Indices de la tabla `imparticion`
--
ALTER TABLE `imparticion`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_imparticion_alumno_codigo_idx` (`alumno_codigo`),
  ADD KEY `fk_imparticion_curso_codigo_idx` (`curso_codigo`);

--
-- Indices de la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `resena`
--
ALTER TABLE `resena`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_cliente` (`id_alumno`),
  ADD KEY `id_imparticion` (`id_imparticion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT COMMENT 'el campo clave de la tabla. Es auto generado.', AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `curso`
--
ALTER TABLE `curso`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `imparticion`
--
ALTER TABLE `imparticion`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;
--
-- AUTO_INCREMENT de la tabla `profesor`
--
ALTER TABLE `profesor`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `resena`
--
ALTER TABLE `resena`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `curso`
--
ALTER TABLE `curso`
  ADD CONSTRAINT `fk_curso_cliente_codigo` FOREIGN KEY (`cliente_codigo`) REFERENCES `cliente` (`codigo`),
  ADD CONSTRAINT `fk_curso_profesor_codigo` FOREIGN KEY (`profesor_codigo`) REFERENCES `profesor` (`codigo`);

--
-- Filtros para la tabla `imparticion`
--
ALTER TABLE `imparticion`
  ADD CONSTRAINT `fk_imparticion_alumno_codigo` FOREIGN KEY (`alumno_codigo`) REFERENCES `alumno` (`codigo`),
  ADD CONSTRAINT `fk_imparticion_curso_codigo` FOREIGN KEY (`curso_codigo`) REFERENCES `curso` (`codigo`);

--
-- Filtros para la tabla `resena`
--
ALTER TABLE `resena`
  ADD CONSTRAINT `resena_ibfk_1` FOREIGN KEY (`id_alumno`) REFERENCES `alumno` (`codigo`) ON UPDATE CASCADE,
  ADD CONSTRAINT `resena_ibfk_2` FOREIGN KEY (`id_imparticion`) REFERENCES `imparticion` (`codigo`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
