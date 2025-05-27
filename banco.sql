-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS controle_estoque;
USE controle_estoque;

-- Tabela de categorias
CREATE TABLE categoria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    tamanho ENUM('Pequeno', 'Médio', 'Grande') NOT NULL,
    embalagem ENUM('Lata', 'Vidro', 'Plástico') NOT NULL
);

-- Tabela de produtos
CREATE TABLE produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    preco_unitario DECIMAL(10, 2) NOT NULL,
    unidade VARCHAR(20) NOT NULL,
    quantidade_estoque INT DEFAULT 0,
    quantidade_min INT NOT NULL,
    quantidade_max INT NOT NULL,
    categoria_id INT,
    FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);

-- Tabela de movimentações (entrada e saída)
CREATE TABLE movimentacao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo ENUM('Entrada', 'Saída') NOT NULL,
    data_movimentacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    quantidade INT NOT NULL,
    produto_id INT,
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);