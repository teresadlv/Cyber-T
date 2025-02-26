CREATE DATABASE  IF NOT EXISTS `bdciber` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bdciber`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bdciber
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `catalogos`
--

DROP TABLE IF EXISTS `catalogos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `catalogos` (
  `ID` int NOT NULL,
  `NombreCatalogo` varchar(40) NOT NULL,
  `Activo` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NombreCatalogo_UNIQUE` (`NombreCatalogo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalogos`
--

LOCK TABLES `catalogos` WRITE;
/*!40000 ALTER TABLE `catalogos` DISABLE KEYS */;
/*!40000 ALTER TABLE `catalogos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `codigosemp`
--

DROP TABLE IF EXISTS `codigosemp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `codigosemp` (
  `Code` int NOT NULL,
  `Usado` tinyint DEFAULT '0',
  `Activo` tinyint DEFAULT '1',
  PRIMARY KEY (`Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `codigosemp`
--

LOCK TABLES `codigosemp` WRITE;
/*!40000 ALTER TABLE `codigosemp` DISABLE KEYS */;
/*!40000 ALTER TABLE `codigosemp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `composicionsalas`
--

DROP TABLE IF EXISTS `composicionsalas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `composicionsalas` (
  `numSala` int NOT NULL,
  `numPuesto` int NOT NULL,
  `Activo` tinyint DEFAULT '1',
  PRIMARY KEY (`numSala`,`numPuesto`),
  KEY `numPuesto_idx` (`numPuesto`),
  CONSTRAINT `numPuesto` FOREIGN KEY (`numPuesto`) REFERENCES `puestos` (`NumPuesto`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `numSala` FOREIGN KEY (`numSala`) REFERENCES `salasgrupales` (`NumSala`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `composicionsalas`
--

LOCK TABLES `composicionsalas` WRITE;
/*!40000 ALTER TABLE `composicionsalas` DISABLE KEYS */;
/*!40000 ALTER TABLE `composicionsalas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuentas`
--

DROP TABLE IF EXISTS `cuentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuentas` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `email` varchar(80) NOT NULL,
  `passwd` varchar(30) NOT NULL,
  `username` varchar(80) NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `apellido` varchar(80) NOT NULL,
  `fNac` date NOT NULL,
  `esEmp` tinyint NOT NULL,
  `Activo` tinyint DEFAULT '1',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentas`
--

LOCK TABLES `cuentas` WRITE;
/*!40000 ALTER TABLE `cuentas` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidoscomida`
--

DROP TABLE IF EXISTS `pedidoscomida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidoscomida` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `IDReserva` int NOT NULL,
  `Producto` int NOT NULL,
  `Activo` tinyint DEFAULT '1',
  PRIMARY KEY (`ID`),
  KEY `PedidoReserva_idx` (`IDReserva`),
  CONSTRAINT `PedidoReserva` FOREIGN KEY (`IDReserva`) REFERENCES `reservas` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidoscomida`
--

LOCK TABLES `pedidoscomida` WRITE;
/*!40000 ALTER TABLE `pedidoscomida` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedidoscomida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productoscomida`
--

DROP TABLE IF EXISTS `productoscomida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productoscomida` (
  `ID` int NOT NULL,
  `Nombre` varchar(80) NOT NULL,
  `Precio` decimal(5,2) NOT NULL,
  `RutaImagen` varchar(255) NOT NULL,
  `CatalogoRaiz` varchar(40) DEFAULT NULL COMMENT 'Catálogo al que pertenece',
  `Activo` tinyint DEFAULT '1',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Nombre_UNIQUE` (`Nombre`),
  KEY `catalogoPertenece_idx` (`CatalogoRaiz`),
  CONSTRAINT `catalogoPerteneceComida` FOREIGN KEY (`CatalogoRaiz`) REFERENCES `catalogos` (`NombreCatalogo`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productoscomida`
--

LOCK TABLES `productoscomida` WRITE;
/*!40000 ALTER TABLE `productoscomida` DISABLE KEYS */;
/*!40000 ALTER TABLE `productoscomida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puestos`
--

DROP TABLE IF EXISTS `puestos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `puestos` (
  `NumPuesto` int NOT NULL,
  `precioMediaHora` decimal(4,2) NOT NULL,
  `estaActivo` tinyint NOT NULL,
  `tieneVolante` tinyint NOT NULL,
  `tieneConsolas` tinyint NOT NULL,
  `Activo` tinyint DEFAULT '1',
  PRIMARY KEY (`NumPuesto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puestos`
--

LOCK TABLES `puestos` WRITE;
/*!40000 ALTER TABLE `puestos` DISABLE KEYS */;
/*!40000 ALTER TABLE `puestos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservas` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `numPuesto` int DEFAULT NULL,
  `fechaReserva` datetime NOT NULL,
  `duracion` time NOT NULL,
  `precio` decimal(4,2) NOT NULL,
  `pedidoComida` tinyint NOT NULL,
  `Activo` tinyint DEFAULT '1',
  PRIMARY KEY (`ID`),
  KEY `numPuesto_idx` (`numPuesto`),
  CONSTRAINT `PuestoReserva` FOREIGN KEY (`numPuesto`) REFERENCES `puestos` (`NumPuesto`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salasgrupales`
--

DROP TABLE IF EXISTS `salasgrupales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salasgrupales` (
  `NumSala` int NOT NULL,
  `Capacidad` int NOT NULL,
  `Activo` tinyint DEFAULT '1',
  PRIMARY KEY (`NumSala`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salasgrupales`
--

LOCK TABLES `salasgrupales` WRITE;
/*!40000 ALTER TABLE `salasgrupales` DISABLE KEYS */;
/*!40000 ALTER TABLE `salasgrupales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videojuegos`
--

DROP TABLE IF EXISTS `videojuegos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `videojuegos` (
  `ID` int NOT NULL,
  `Nombre` varchar(80) NOT NULL,
  `TipoJuego` varchar(40) NOT NULL,
  `RutaImagen` varchar(255) NOT NULL,
  `CatalogoRaiz` varchar(40) DEFAULT NULL COMMENT 'Catálogo al que pertenece',
  `desc` varchar(500) DEFAULT NULL,
  `Activo` tinyint DEFAULT '1',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Nombre_UNIQUE` (`Nombre`),
  KEY `catalogoPerteneceVideojuego_idx` (`CatalogoRaiz`),
  CONSTRAINT `catalogoPerteneceVideojuego` FOREIGN KEY (`CatalogoRaiz`) REFERENCES `catalogos` (`NombreCatalogo`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videojuegos`
--

LOCK TABLES `videojuegos` WRITE;
/*!40000 ALTER TABLE `videojuegos` DISABLE KEYS */;
/*!40000 ALTER TABLE `videojuegos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bdciber'
--

--
-- Dumping routines for database 'bdciber'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-09 12:38:48
