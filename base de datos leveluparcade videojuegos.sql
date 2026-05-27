-- 1. Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS levelup_arcade;
USE levelup_arcade;

-- 2. Tabla de Usuarios (Jugadores)
CREATE TABLE IF NOT EXISTS usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL, -- Guardarás el hash en Java
    email VARCHAR(100) UNIQUE,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 3. Tabla de Juegos
CREATE TABLE IF NOT EXISTS juegos (
    id_juego INT AUTO_INCREMENT PRIMARY KEY,
    nombre_juego VARCHAR(100) NOT NULL,
    descripcion TEXT,
    genero VARCHAR(50)
);

-- 4. Tabla de Puntuaciones (Relaciona usuarios con juegos)
CREATE TABLE IF NOT EXISTS puntuaciones (
    id_puntuacion INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    id_juego INT,
    puntos INT DEFAULT 0,
    fecha_logros DATETIME DEFAULT CURRENT_TIMESTAMP,
    -- Claves foráneas para mantener la integridad
    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) 
        REFERENCES usuarios(id_usuario) ON DELETE CASCADE,
    CONSTRAINT fk_juego FOREIGN KEY (id_juego) 
        REFERENCES juegos(id_juego) ON DELETE CASCADE
);

-- ---------------------------------------------------------
-- DATOS DE PRUEBA (Para que la web/app no esté vacía)
-- ---------------------------------------------------------

INSERT INTO usuarios (username, password, email) VALUES 
('admin_cyber', '1234', 'admin@levelup.com'),
('player_one', 'pass123', 'p1@mail.com');

INSERT INTO juegos (nombre_juego, descripcion, genero) VALUES 
('Space Invaders 2026', 'Defiende la tierra de los aliens pixelados.', 'Arcade'),
('Neon Runner', 'Corre por una ciudad futurista sin chocar.', 'Plataformas');

INSERT INTO puntuaciones (id_usuario, id_juego, puntos) VALUES 
(1, 1, 5000),
(2, 1, 3200),
(1, 2, 150);