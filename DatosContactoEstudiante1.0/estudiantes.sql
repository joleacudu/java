-- Se recomienda para esta practica dejar como nombre de tabla estudiantes, 
-- Este sería un ejemplo de script sql para sqlite tenerlo presente 
-- porque puede cambiar un poco respecto al que realizaron

CREATE TABLE estudiantes (
    id INTEGER NOT NULL PRIMARY KEY,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    website TEXT NOT NULL );