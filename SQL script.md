INSERT INTO comitente (descripcion) VALUES
    ('Comitente A'),
    ('Comitente B'),
    ('Comitente C');

-- Datos para la tabla mercado
INSERT INTO mercado (codigo, descripcion, pais) VALUES
    ('MELI', 'Mercado Libre', 'ARGENTINA'),
    ('FENIX', 'Fernando Nixon', 'URUGUAY'),
    ('DHL', 'Diligencias Homero Ludobico', 'ARGENTINA');

-- Datos para la tabla de relación comitente_mercado
INSERT INTO comitente_mercado (comitente_id, mercado_id) VALUES
    (1, 1),  -- Asociar Comitente A con MELI
    (1, 2),  -- Asociar Comitente A con FENIX
    (2, 1),  -- Asociar Comitente B con MELI
    (3, 3);  -- Asociar Comitente C con DHL
