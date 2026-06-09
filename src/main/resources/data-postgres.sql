-- Datos semilla para PostgreSQL (perfil prod).
-- Las tablas las crea Hibernate (ddl-auto: update); aqui solo se insertan datos.
-- ON CONFLICT DO NOTHING => idempotente, no falla si ya existen.

INSERT INTO app_user (id, "rolId", name, password) VALUES (1, 1, 'admin', 'admin')
    ON CONFLICT (id) DO NOTHING;
INSERT INTO app_user (id, "rolId", name, password) VALUES (2, 2, 'user', 'user')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO product (id, name, price, stock) VALUES (1, 'Teclado', 25.99, 100)
    ON CONFLICT (id) DO NOTHING;
INSERT INTO product (id, name, price, stock) VALUES (2, 'Mouse', 15.50, 200)
    ON CONFLICT (id) DO NOTHING;
INSERT INTO product (id, name, price, stock) VALUES (3, 'Monitor', 150.00, 50)
    ON CONFLICT (id) DO NOTHING;
INSERT INTO product (id, name, price, stock) VALUES (4, 'Auriculares', 45.75, 80)
    ON CONFLICT (id) DO NOTHING;
INSERT INTO product (id, name, price, stock) VALUES (5, 'Webcam', 60.00, 0)
    ON CONFLICT (id) DO NOTHING;

-- Reinicia las secuencias al MAX(id) para que los nuevos INSERT de Hibernate no choquen.
SELECT setval(pg_get_serial_sequence('app_user', 'id'), (SELECT MAX(id) FROM app_user));
SELECT setval(pg_get_serial_sequence('product', 'id'), (SELECT MAX(id) FROM product));
