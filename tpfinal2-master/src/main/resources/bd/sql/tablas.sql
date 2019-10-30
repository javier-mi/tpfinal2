--mysql -u root -p
--GRANT ALL PRIVILEGES ON *.* TO 'dbUser'@'localhost' IDENTIFIED BY 'root';
--\q

DROP DATABASE IF EXISTS dbThea;

CREATE DATABASE dbThea;
USE dbThea;

--DROP TABLE IF EXISTS Acceso;
--DROP TABLE IF EXISTS Registro;
--DROP TABLE IF EXISTS Usuario;
--DROP TABLE IF EXISTS Rol_Permiso;
--DROP TABLE IF EXISTS Rol;
--DROP TABLE IF EXISTS Permiso;
--DROP TABLE IF EXISTS Foto;
--DROP TABLE IF EXISTS Persona;
--DROP TABLE IF EXISTS Funcion;

CREATE TABLE Funcion (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  descripcion varchar(100) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

CREATE TABLE Persona (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  nombre varchar(100) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  apellido varchar(100) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  dni int(10) unsigned NOT NULL,
  idFuncion int(10) unsigned NOT NULL,
  matricula int(10) unsigned,
  PRIMARY KEY (id),
  FOREIGN KEY (idFuncion) REFERENCES Funcion(id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

CREATE TABLE Foto (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  archivo longblob NOT NULL,
  idPersona int(10) unsigned NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (idPersona) REFERENCES Persona(id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

CREATE TABLE Permiso (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  descripcion varchar(100) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

CREATE TABLE Rol (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  descripcion varchar(100) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

CREATE TABLE Rol_Permiso (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  idRol int(10) unsigned NOT NULL,
  idPermiso int(10) unsigned NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (idRol) REFERENCES Rol(id),
  FOREIGN KEY (idPermiso) REFERENCES Permiso(id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

CREATE TABLE Usuario (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  nombre varchar(100) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  apellido varchar(100) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  email varchar(100) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  id_rol int(10) unsigned NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (idRol) REFERENCES Rol(id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

CREATE TABLE Registro (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  idPersona int(10) unsigned NOT NULL,
  fechaIngreso date NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (idPersona) REFERENCES Persona(id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

CREATE TABLE Acceso (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  idUsuario int(10) unsigned NOT NULL,
  fechaAcceso date NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (idUsuario) REFERENCES Usuario(id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

insert into Permiso (descripcion) values ('Login');
insert into Permiso (descripcion) values ('Recuperar clave');
insert into Permiso (descripcion) values ('Camara');
insert into Permiso (descripcion) values ('Listado Personas');
insert into Permiso (descripcion) values ('Modificar Personas');
insert into Permiso (descripcion) values ('Crear Personas');
insert into Permiso (descripcion) values ('Listado Usuarios');
insert into Permiso (descripcion) values ('Modificar Usuarios');
insert into Permiso (descripcion) values ('Crear Usuarios');

insert into Rol (descripcion) values ('Admin');
insert into Rol (descripcion) values ('Seguridad');

insert into Rol_Permiso (idRol,idPermiso) values (1,1);
insert into Rol_Permiso (idRol,idPermiso) values (1,2);
insert into Rol_Permiso (idRol,idPermiso) values (1,3);
insert into Rol_Permiso (idRol,idPermiso) values (1,4);
insert into Rol_Permiso (idRol,idPermiso) values (1,5);
insert into Rol_Permiso (idRol,idPermiso) values (1,6);
insert into Rol_Permiso (idRol,idPermiso) values (1,7);
insert into Rol_Permiso (idRol,idPermiso) values (1,8);
insert into Rol_Permiso (idRol,idPermiso) values (1,9);
insert into Rol_Permiso (idRol,idPermiso) values (2,1);
insert into Rol_Permiso (idRol,idPermiso) values (2,2);
insert into Rol_Permiso (idRol,idPermiso) values (2,3);
insert into Rol_Permiso (idRol,idPermiso) values (2,4);

insert into Funcion (descripcion) values ('Profesor');
insert into Funcion (descripcion) values ('Alumno');
insert into Funcion (descripcion) values ('Administrativo');

insert into Usuario (id,nombre,apellido,email,id_rol) values (1,'Oscar','Rodriguez','spyrofran@gmail.com',1);
insert into Usuario (id,nombre,apellido,email,id_rol) values (2,'Julio','Rodriguez','spyrofran@gmail.com',2);
insert into Usuario (id,nombre,apellido,email,id_rol) values (3,'Mario','Rodriguez','spyrofran@gmail.com',2);

insert into Persona (id,nombre,apellido,dni,id_funcion,matricula) values (1,'Javier','Testa',39044332,1,956475);
insert into Persona (id,nombre,apellido,dni,id_funcion,matricula) values (2,'Natalia','Testa',42657467,1,956432);
insert into Persona (id,nombre,apellido,dni,id_funcion,matricula) values (3,'Juan','Testa',43564565,1,956443);

