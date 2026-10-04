CREATE DATABASE  IF NOT EXISTS `srs_ev2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `srs_ev2`;
-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: srs_ev2
-- ------------------------------------------------------
-- Server version	8.0.46

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
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `idCategoria` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Enfermera General'),(2,'Enfermera Pediatrica'),(3,'Enfermera Geriatrica'),(4,'Enfermera de Emergencias'),(5,'Enfermera de Cuidados Intensivos');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enfermera`
--

DROP TABLE IF EXISTS `enfermera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enfermera` (
  `idEnfermera` int NOT NULL AUTO_INCREMENT,
  `nombres` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `fechaContratacion` date DEFAULT NULL,
  `telefono` varchar(9) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `dni` varchar(8) DEFAULT NULL,
  `categoria` int DEFAULT NULL,
  PRIMARY KEY (`idEnfermera`),
  UNIQUE KEY `dni_UNIQUE` (`dni`),
  KEY `fk_enfermera_categoria_idx` (`categoria`),
  CONSTRAINT `fk_enfermera_categoria` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enfermera`
--

LOCK TABLES `enfermera` WRITE;
/*!40000 ALTER TABLE `enfermera` DISABLE KEYS */;
INSERT INTO `enfermera` VALUES (1,'Juana','Largo Romero','1980-01-20','2001-10-14','987741147','juan12@hotmail.com','87965885',1),(2,'Lana','Peralta Torres','1981-02-14','2002-07-10','998741369','lana87@gmail.com','97965885',3),(3,'Sarah','Castillo Lopez','1991-03-11','2004-02-20','993274369','saRA57@gmail.com','91265181',2),(4,'Matea','Vargas Mendoza','1995-03-14','2020-01-05','912345678','mat_vargas@gmail.com','91234567',4),(5,'Sofia','Mendoza Rojas','1998-07-27','2013-02-18','923456789','fia.mends@hotmail.com','82345678',5),(6,'Daniela','Castillo Fontana','1992-11-09','2022-06-12','934567890','daniel999@hotmail.com','93456789',3),(7,'Valeria','Rojas Paredes','1997-01-22','2014-09-25','945678901','1Vali21@gmail.com','84567890',4),(8,'Alejandra','Torres Vargas','1990-05-03','2011-03-10','956789012','torrAlej5@gmail.com','95678901',2),(9,'Camila','Navarro Rivero','1996-08-18','2016-11-07','967890123','camcam74@gmail.com','86789012',5),(10,'Gabriela','Herrera Salazar','1994-12-30','2020-04-14','978901234','salGab7@hotmail.com','97890123',3);
/*!40000 ALTER TABLE `enfermera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'srs_ev2'
--

--
-- Dumping routines for database 'srs_ev2'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-10-04  2:44:07
