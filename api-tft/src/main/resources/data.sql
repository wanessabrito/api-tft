CREATE TABLE IF NOT EXISTS campeoes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    classe VARCHAR(255) NOT NULL,
    origem VARCHAR(255),
    custo INT,
    dificuldade INT
);

INSERT INTO campeoes (nome, classe, origem, custo, dificuldade) VALUES
('Lux', 'Mago', 'Luz', 2, 3),
('Ahri', 'Feiticeiro', 'Ionia', 5, 3),
('Annie', 'Mago', 'Gadgeteen', 1, 2),
('Gwen', 'Lutadora', 'Shadow Isles', 4, 3),
('Jinx', 'Atirador', 'Zaun', 2, 2),
('Ekko', 'Cibernético', 'Piltover, Zaun', 3, 3),
('Wander', 'Místico', 'Targon', 1, 1);
