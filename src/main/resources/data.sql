-- =========================================
-- 1. USUARIOS
-- =========================================
INSERT INTO usuarios (email, senha, role) VALUES
('admin@movix.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzVymObVp0z9Vf67FVYt3K8H1C', 'ROLE_ADMIN'),
('motorista1@movix.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzVymObVp0z9Vf67FVYt3K8H1C', 'ROLE_MOTORISTA'),
('motorista2@movix.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzVymObVp0z9Vf67FVYt3K8H1C', 'ROLE_MOTORISTA');

-- =========================================
-- 2. CLIENTES
-- =========================================
INSERT INTO clientes (
    nome, documento, telefone, email,
    cep, logradouro, numero, complemento,
    ponto_referencia, bairro, cidade, estado
) VALUES
('Empresa Logística X', '12345678000199', '11999999999', 'contato@logx.com',
 '01001000', 'Praça da Sé', '100', 'Bloco A',
 'Perto do Metrô', 'Sé', 'São Paulo', 'SP'),

('João Silva', '98765432100', '21888888888', 'joao@email.com',
 '20040000', 'Av. Rio Branco', '50', 'Apto 101',
 'Próximo ao Teatro Municipal', 'Centro', 'Rio de Janeiro', 'RJ');

-- =========================================
-- 3. MOTORISTAS
-- =========================================
INSERT INTO motoristas (
    usuario_id, nome, cnh, placa_veiculo, disponivel
) VALUES
(2, 'Carlos Oliveira', '123456789', 'ABC-1234', true),
(3, 'Ricardo Souza', '987654321', 'XYZ-5678', true);

-- =========================================
-- 4. PEDIDOS
-- =========================================
INSERT INTO pedidos (
    cliente_id, descricao,
    origem, destino, peso, valor_frete, criado_em
) VALUES
(1,'Carga de Eletrônicos',
 'São Paulo, SP', 'Rio de Janeiro, RJ',
 150.50, 450.00, CURRENT_TIMESTAMP),

(2,'Móveis de Escritório',
 'Rio de Janeiro, RJ', 'Curitiba, PR',
 80.00, 250.00, CURRENT_TIMESTAMP);

-- =========================================
-- 5. ENTREGAS
-- =========================================
INSERT INTO entregas (
    pedido_id, status, codigo_rastreio, criado_em,
    motorista_id, data_prevista
) VALUES
(1, 'EM_TRANSPORTE','MVX-1001', CURRENT_TIMESTAMP, 1, '2026-04-01 18:00:00'),
(2, 'CRIADO', 'MVX-1002', CURRENT_TIMESTAMP, 2, '2026-04-05 14:00:00');

-- =========================================
-- 6. MOVIMENTACOES
-- =========================================
INSERT INTO movimentacoes (
    entrega_id, status_atual, descricao,
    localizacao_origem, localizacao_destino, data_hora
) VALUES
(1, 'EM_TRANSPORTE',
 'Produto coletado no centro de distribuição',
 'São Paulo, SP', 'Em rota para RJ',
 CURRENT_TIMESTAMP),

(1, 'SAIU_PARA_ENTREGA',
 'Veículo em deslocamento na BR-116',
 'Resende, RJ', 'Rio de Janeiro, RJ',
 CURRENT_TIMESTAMP + interval '5 hours');

-- =========================================
-- 7. LOCALIZACAO EM TEMPO REAL
-- =========================================
INSERT INTO location (
    entrega_id, latitude, longitude, timestamp
) VALUES
(1, -22.9068, -43.1729, CURRENT_TIMESTAMP),
(1, -22.9110, -43.2094, CURRENT_TIMESTAMP + interval '10 minutes'),
(2, -25.4284, -49.2733, CURRENT_TIMESTAMP);