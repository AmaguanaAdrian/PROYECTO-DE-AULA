CREATE database proyecto2;


CREATE TABLE Usuario (
  usu_id INT AUTO_INCREMENT PRIMARY KEY,
  usu_nombres VARCHAR(40) NOT NULL,
  usu_apellidos VARCHAR(40) NOT NULL,
  usu_contraseña VARCHAR(30) NOT NULL,
  usu_cedula VARCHAR(15) NOT NULL UNIQUE,
  usu_direccion VARCHAR(100) NOT NULL,
  usu_telefono DOUBLE NOT NULL,
  usu_correolnstitucional VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE Bibliotecario (
  bib_id INT AUTO_INCREMENT PRIMARY KEY,
  bib_tituloRegistrado VARCHAR(50) NOT NULL,
  usu_id INT NOT NULL,
  FOREIGN KEY (usu_id) REFERENCES Usuario(usu_id)
);

CREATE TABLE Estudiante (
  est_id INT AUTO_INCREMENT PRIMARY KEY,
  est_carreraCursando VARCHAR(50) NOT NULL,
  est_numMatricula VARCHAR(20) NOT NULL UNIQUE,
  est_nivelCursando INT NOT NULL,
  usu_id INT NOT NULL,
  FOREIGN KEY (usu_id) REFERENCES Usuario(usu_id)
);

CREATE TABLE Reserva (
  res_id INT AUTO_INCREMENT PRIMARY KEY,
  res_fechaRetiro DATE NOT NULL,
  res_fechaReserva DATE NOT NULL,
  res_fechaDevolucion DATE NOT NULL,
  est_id INT NOT NULL,
  FOREIGN KEY (est_id) REFERENCES Estudiante(est_id)
  
);

CREATE TABLE Genero (
  gen_id INT AUTO_INCREMENT PRIMARY KEY,
  gen_nombreGen VARCHAR(85) NOT NULL
);

CREATE TABLE Autor(
  aut_id INT AUTO_INCREMENT PRIMARY KEY,
  aut_nombres VARCHAR(40) NOT NULL,
  aut_apellidos VARCHAR(40) NOT NULL,
);

CREATE TABLE Libro(
  lib_id INT AUTO_INCREMENT PRIMARY KEY,
  lib_titulo VARCHAR(80) NOT NULL,
  lib_fechaPublicado DATE NOT NULL,
  aut_id INT NOT NULL,
  gen_id INT NOT NULL,
  FOREIGN KEY (aut_id) REFERENCES Autor(aut_id),
  FOREIGN KEY (gen_id) REFERENCES Genero(gen_id)
);
CREATE TABLE Ejemplar(
  eje_id INT AUTO_INCREMENT PRIMARY KEY,
  eje_codigoEjem VARCHAR(25) NOT NULL UNIQUE,
  eje_estado BOOLEAN NOT NULL DEFAULT TRUE,
  eje_isbn VARCHAR(60) NOT NULL,
  lib_id INT NOT NULL,
  FOREIGN KEY (lib_id) REFERENCES Libro(lib_id)
);
CREATE TABLE Detalle_reserva (
  det_id INT AUTO_INCREMENT PRIMARY KEY,
  res_id INT NOT NULL,
  eje_id INT NOT NULL,
  FOREIGN KEY (res_id) REFERENCES Reserva(res_id),
  FOREIGN KEY (eje_id) REFERENCES Ejemplar(eje_id)
);


INSERT INTO bibliotecarios (bib_tituloRegistrado,usu_id)VALUES('"+b.getTituloRegistrado()+"',"+b.getIdUsuario()+");
INSERT INTO usuarios( usu_nombres,usu_apellidos,usu_clave,usu_cedula,usu_direccion,usu_telefono,usu_correolnstitucional,usu_rol)VALUES('" + usuC.getNombres() + "','" + usuC.getApellidos() + "','" + usuC.getClave() + "','" + usuC.getCedula() + "','" + usuC.getDireccion() + "'," + usuC.getTelefono() + ",'" + usuC.getCorreoInstitucional() + "', " + usuC.getRol() + ");
INSERT INTO estudiantes (est_carreraCursando,est_numMatricula,est_nivelCursando,usu_id) VALUES ('"+est.getCarreraCursando()+"','"+est.getNumMatricula()+"',"+est.getNivelCursando()+","+est.getIdUsuario()+");