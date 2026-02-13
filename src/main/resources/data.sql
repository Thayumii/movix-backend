-- 1. CLIENTES
INSERT INTO cliente (nome, email, telefone, cep, logradouro, numero, bairro, cidade, estado, ponto_referencia, complemento) VALUES
('Ana Silva', 'ana.silva@email.com', '21988776655', '20000-001', 'Rua das Flores', '123', 'Centro', 'Rio de Janeiro', 'RJ', 'Perto da Lanchonete', 'Apto 101'),
('Bruno Costa', 'bruno.costa@email.com', '11977665544', '01311-000', 'Avenida Paulista', '456', 'Bela Vista', 'São Paulo', 'SP', 'Em frente ao MASP', 'Sala 302'),
('Carla Dias', 'carla.dias@email.com', '31966554433', '30000-002', 'Rua dos Inconfidentes', '789', 'Savassi', 'Belo Horizonte', 'MG', 'Esquina com a praça', 'Loja 10'),
('Daniel Moreira', 'daniel.moreira@email.com', '71955443322', '40000-003', 'Ladeira do Pelourinho', 'S/N', 'Pelourinho', 'Salvador', 'BA', 'Casa azul', 'Fundos'),
('Elisa Fernandes', 'elisa.fernandes@email.com', '41944332211', '80000-004', 'Rua XV de Novembro', '1000', 'Centro', 'Curitiba', 'PR', 'Próximo ao shopping', '');

-- 2. PEDIDOS
INSERT INTO pedido (origem, destino, peso, valor_frete, criado_em, cliente_id, descricao, codigo_rastreio) VALUES
('Rio de Janeiro', 'São Paulo', 10.0, 15.00, '2025-11-09', 1, 'Caixa de livros (Frágil)', 'MVX-TESTE-001'),
('Belo Horizonte', 'Rio de Janeiro', 5.5, 8.25, '2025-11-09', 3, 'Documentos importantes', 'MVX-TESTE-002'),
('São Paulo', 'Curitiba', 25.0, 37.50, '2025-11-09', 2, 'Equipamento eletrônico', 'MVX-TESTE-003'),
('Salvador', 'Rio de Janeiro', 15.0, 22.50, '2025-11-09', 4, 'Artesanato local', 'MVX-TESTE-004'),
('Curitiba', 'São Paulo', 8.0, 12.00, '2025-11-09', 5, 'Roupas e amostras de tecido', 'MVX-TESTE-005');

-- 3. ENTREGAS
INSERT INTO entregas (status, criado_em, pedido_id, motorista, veiculo_placa, data_prevista) VALUES
('CRIADO', '2025-11-09 14:30:00', 1, 'João Pereira', 'ABC-1234', '2025-11-12'),
('EM_TRANSPORTE', '2025-11-09 14:31:00', 2, 'Maria Souza', 'XYZ-5678', '2025-11-11'),
('AGUARDANDO_COLETA', '2025-11-09 14:32:00', 3, 'Carlos Lima', 'QWE-9876', '2025-11-10'),
('CRIADO', '2025-11-09 14:33:00', 4, 'Lucas Martins', 'RTY-4561', '2025-11-13'),
('EM_TRANSPORTE', '2025-11-09 14:34:00', 5, 'João Pereira', 'ABC-1234', '2025-11-10');

-- 4. MOVIMENTACOES (Histórico das entregas)
-- Colunas: entrega_id, status_no_momento, descricao, localizacao_origem, localizacao_destino, data_hora
INSERT INTO movimentacoes (entrega_id, status_atual, descricao, localizacao_origem, localizacao_destino, data_hora) VALUES
-- Histórico para a Entrega 1
(1, 'CRIADO', 'Pedido recebido e entrega gerada', 'Centro Logístico RJ', 'Aguardando Despacho', '2025-11-09 14:30:00'),

-- Histórico para a Entrega 2 (Já em transporte)
(2, 'CRIADO', 'Pedido recebido', 'Centro Logístico BH', 'Aguardando', '2025-11-09 14:31:00'),
(2, 'EM_TRANSPORTE', 'Carga saiu do centro de distribuição', 'Centro Logístico BH', 'Centro Distribuição RJ', '2025-11-09 16:00:00'),

-- Histórico para a Entrega 3
(3, 'AGUARDANDO_COLETA', 'Motorista Carlos Lima a caminho do local de coleta', 'Garagem Movix', 'Ponto de Coleta SP', '2025-11-09 15:00:00'),

-- Histórico para a Entrega 5
(5, 'CRIADO', 'Entrega inicializada', 'Centro Curitiba', 'Aguardando', '2025-11-09 14:34:00'),
(5, 'EM_TRANSPORTE', 'Em trânsito para destino final', 'Centro Curitiba', 'Centro Logístico SP', '2025-11-10 08:00:00');