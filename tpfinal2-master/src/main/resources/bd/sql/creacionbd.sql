CREATE DATABASE dbThea;
USE dbThea;

CREATE TABLE usuarios (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  nombre varchar(100) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  apellido varchar(100) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  email varchar(100) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  contraseña varchar(100) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  activo tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;