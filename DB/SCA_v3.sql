-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.30 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para ipst_sca
CREATE DATABASE IF NOT EXISTS `ipst_sca` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ipst_sca`;

-- Volcando estructura para tabla ipst_sca.cargos
CREATE TABLE IF NOT EXISTS `cargos` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `CARGO` varchar(50) COLLATE utf8mb3_spanish_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;

-- Volcando datos para la tabla ipst_sca.cargos: ~2 rows (aproximadamente)
REPLACE INTO `cargos` (`ID`, `CARGO`) VALUES
	(1, 'Administrador'),
	(2, 'Supervisor'),
	(3, 'Empleado');

-- Volcando estructura para tabla ipst_sca.marcaciones
CREATE TABLE IF NOT EXISTS `marcaciones` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `RUT` int NOT NULL,
  `FECHA` date NOT NULL,
  `HORA` time NOT NULL,
  `TIPO` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_REALIZA_UNA` (`RUT`),
  CONSTRAINT `FK_REALIZA_UNA` FOREIGN KEY (`RUT`) REFERENCES `trabajadores` (`RUT`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;

-- Volcando datos para la tabla ipst_sca.marcaciones: ~6 rows (aproximadamente)
REPLACE INTO `marcaciones` (`ID`, `RUT`, `FECHA`, `HORA`, `TIPO`) VALUES
	(1, 12345678, '2024-09-20', '09:36:01', 0),
	(2, 12345678, '2024-09-21', '09:14:54', 0),
	(3, 12345678, '2024-09-22', '09:29:15', 0),
	(4, 12345678, '2024-09-20', '17:06:13', 1),
	(5, 12345678, '2024-09-21', '17:32:45', 1),
	(6, 12345678, '2024-09-22', '19:48:15', 1),
	(7, 12345678, '2024-09-19', '09:55:51', 0);

-- Volcando estructura para tabla ipst_sca.trabajadores
CREATE TABLE IF NOT EXISTS `trabajadores` (
  `RUT` int NOT NULL AUTO_INCREMENT,
  `DV` varchar(1) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `ID` int DEFAULT NULL,
  `CAR_ID` int DEFAULT NULL,
  `NOMBRES` varchar(60) COLLATE utf8mb3_spanish_ci NOT NULL,
  `APELLIDOS` varchar(80) COLLATE utf8mb3_spanish_ci NOT NULL,
  `DEPARTAMENTO` varchar(25) COLLATE utf8mb3_spanish_ci NOT NULL,
  `AREA` varchar(25) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `CORREO` varchar(100) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `CLAVE` varchar(60) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `ESTADO` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`RUT`),
  KEY `FK_TIENE_ASIGNADO_UN` (`ID`),
  KEY `FK_TIENE_UN` (`CAR_ID`),
  CONSTRAINT `FK_TIENE_ASIGNADO_UN` FOREIGN KEY (`ID`) REFERENCES `turnos` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_TIENE_UN` FOREIGN KEY (`CAR_ID`) REFERENCES `cargos` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=987654323 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;

-- Volcando datos para la tabla ipst_sca.trabajadores: ~4 rows (aproximadamente)
REPLACE INTO `trabajadores` (`RUT`, `DV`, `ID`, `CAR_ID`, `NOMBRES`, `APELLIDOS`, `DEPARTAMENTO`, `AREA`, `CORREO`, `CLAVE`, `ESTADO`) VALUES
	(12345678, 'K', 1, 3, 'Jhon', 'Doe', 'IT', 'Operaciones', '2', '2', 1),
	(15472660, '8', 1, 2, 'Juanito', 'Guzman', 'AA', 'FF', 'jguz@gmail.com', '123456', 1),
	(18093137, '6', 1, 3, 'Ricardo', 'Alvea', 'TECH', 'INFO', 'ralvea.14@google.cl', '951', 1),
	(99999999, 'Z', 1, 1, 'Robert', 'Doe', 'IT', 'Técnica', '1', '1', 1);

-- Volcando estructura para tabla ipst_sca.turnos
CREATE TABLE IF NOT EXISTS `turnos` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` varchar(25) COLLATE utf8mb3_spanish_ci NOT NULL,
  `INGRESO` time NOT NULL,
  `SALIDA` time NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;

-- Volcando datos para la tabla ipst_sca.turnos: ~0 rows (aproximadamente)
REPLACE INTO `turnos` (`ID`, `DESCRIPCION`, `INGRESO`, `SALIDA`) VALUES
	(1, 'Turno 1', '09:30:00', '17:30:00');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
