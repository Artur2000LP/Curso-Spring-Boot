-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-11-2024 a las 03:03:16
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cursojava`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `telefono` varchar(40) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `edad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `apellido`, `correo`, `telefono`, `password`, `edad`) VALUES
(18, 'Artur', 'Letona', 'soyArtur@gmail.com', NULL, '$argon2id$v=19$m=1024,t=1,p=1$/gkjnvSkbtqQjNQrSOQs2A$rkkFu+7rP9MIApfg2/bvRUpfPYPsx0Wy+9mwUnazbIA', 0),
(19, 'oscar', 'alcides', 'oscar@gmail.com', NULL, '$argon2id$v=19$m=1024,t=1,p=1$KsDDIaei2GKP1OeHoEGYrQ$qtNOk4LwNpAvwsoKzvzfukYXVqyOvC7Ucf6yvzM9xL8', 0),
(20, 'jose', 'chaquere', 'joselito@gmail.com', NULL, '$argon2id$v=19$m=1024,t=1,p=1$o/vXK8qUCFbmjrq1vxgKNA$OR6bxjpPtIDAidRkb8rwE20gKJQlHZh2DcPazR/U2JE', 0),
(21, 'Maria', 'chaquere', 'maria@gmail.com', NULL, '$argon2id$v=19$m=1024,t=1,p=1$f37i+Eq8wIsmYVGqCRuXhw$MczlH/nWQnuXZh/XyX9dcO0sI/A60JpMbfLt8972rRo', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
