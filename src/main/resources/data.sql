-- 1. CLIENTES (5 exemplos)
-- Colunas: nome, email, telefone, cep, logradouro, numero, bairro, cidade, estado, ponto_referencia, complemento
INSERT INTO cliente (nome, email, telefone, cep, logradouro, numero, bairro, cidade, estado, ponto_referencia, complemento) VALUES
('Ana Silva', 'ana.silva@email.com', '21988776655', '20000-001', 'Rua das Flores', '123', 'Centro', 'Rio de Janeiro', 'RJ', 'Perto da Lanchonete', 'Apto 101'),
('Bruno Costa', 'bruno.costa@email.com', '11977665544', '01311-000', 'Avenida Paulista', '456', 'Bela Vista', 'São Paulo', 'SP', 'Em frente ao MASP', 'Sala 302'),
('Carla Dias', 'carla.dias@email.com', '31966554433', '30000-002', 'Rua dos Inconfidentes', '789', 'Savassi', 'Belo Horizonte', 'MG', 'Esquina com a praça', 'Loja 10'),
('Daniel Moreira', 'daniel.moreira@email.com', '71955443322', '40000-003', 'Ladeira do Pelourinho', 'S/N', 'Pelourinho', 'Salvador', 'BA', 'Casa azul', 'Fundos'),
('Elisa Fernandes', 'elisa.fernandes@email.com', '41944332211', '80000-004', 'Rua XV de Novembro', '1000', 'Centro', 'Curitiba', 'PR', 'Próximo ao shopping', '');

-- 2. PEDIDOS (5 exemplos)
-- Colunas: origem, destino, peso, valor_frete, data_criacao, cliente_id, descricao
INSERT INTO pedido (origem, destino, peso, valor_frete, data_criacao, cliente_id, descricao, codigo_rastreio) VALUES
('Rio de Janeiro', 'São Paulo', 10.0, 15.00, '2025-11-09', 1, 'Caixa de livros (Frágil)', 'MVX-TESTE-001'),
('Belo Horizonte', 'Rio de Janeiro', 5.5, 8.25, '2025-11-09', 3, 'Documentos importantes', 'MVX-TESTE-002'),
('São Paulo', 'Curitiba', 25.0, 37.50, '2025-11-09', 2, 'Equipamento eletrônico', 'MVX-TESTE-003'),
('Salvador', 'Rio de Janeiro', 15.0, 22.50, '2025-11-09', 4, 'Artesanato local', 'MVX-TESTE-004'),
('Curitiba', 'São Paulo', 8.0, 12.00, '2025-11-09', 5, 'Roupas e amostras de tecido', 'MVX-TESTE-005');

-- 3. ENTREGAS (5 exemplos)
-- Colunas: status, data_criacao, pedido_id, motorista, veiculo_placa, data_prevista
INSERT INTO entregas (status, data_criacao, pedido_id, motorista, veiculo_placa, data_prevista) VALUES
('CRIADO', '2025-11-09T14:30:00', 1, 'João Pereira', 'ABC-1234', '2025-11-12'),
('EM_TRANSPORTE', '2025-11-09T14:31:00', 2, 'Maria Souza', 'XYZ-5678', '2025-11-11'),
('AGUARDANDO_COLETA', '2025-11-09T14:32:00', 3, 'Carlos Lima', 'QWE-9876', '2025-11-10'),
('CRIADO', '2025-11-09T14:33:00', 4, 'Lucas Martins', 'RTY-4561', '2025-11-13'),
('EM_TRANSPORTE', '2025-11-09T14:34:00', 5, 'João Pereira', 'ABC-1234', '2025-11-10');