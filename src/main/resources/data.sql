-- =========================
-- USUÁRIOS
-- senha: 123456
-- =========================
INSERT INTO usuarios (email, senha, role) VALUES
('admin@movix.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzVymObVp0z9Vf67FVYt3K8H1C', 'ROLE_ADMIN'),
('motorista1@movix.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzVymObVp0z9Vf67FVYt3K8H1C', 'ROLE_MOTORISTA'),
('motorista2@movix.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzVymObVp0z9Vf67FVYt3K8H1C', 'ROLE_MOTORISTA');

-- =========================
-- CLIENTES
-- =========================
INSERT INTO clientes (
    nome, documento, telefone, email,
    cep, logradouro, numero, complemento,
    ponto_referencia, bairro, cidade, estado
) VALUES
(
    'Empresa Logística X',
    '12345678000199',
    '11999999999',
    'contato@logx.com',
    '01001000',
    'Praça da Sé',
    '100',
    'Bloco A',
    'Perto do metrô',
    'Sé',
    'São Paulo',
    'SP'
),
(
    'João Silva',
    '98765432100',
    '21988887777',
    'joao@email.com',
    '20040000',
    'Av Rio Branco',
    '50',
    'Sala 201',
    'Próximo ao teatro',
    'Centro',
    'Rio de Janeiro',
    'RJ'
);

-- =========================
-- MOTORISTAS
-- =========================
INSERT INTO motoristas (
    nome, cnh, placa_veiculo, disponivel, usuario_id
) VALUES
('Carlos Oliveira', '123456789', 'ABC-1234', true, 2),
('Ricardo Souza', '987654321', 'XYZ-5678', true, 3);

-- =========================
-- PEDIDOS
-- =========================
INSERT INTO pedidos (
    descricao, origem, destino, peso,
    valor_frete, criado_em, cliente_id
) VALUES
(
    'Carga de eletrônicos',
    'São Paulo, SP',
    'Rio de Janeiro, RJ',
    150.50,
    450.00,
    CURRENT_TIMESTAMP,
    1
),
(
    'Móveis de escritório',
    'Rio de Janeiro, RJ',
    'Curitiba, PR',
    80.00,
    250.00,
    CURRENT_TIMESTAMP,
    2
);

-- =========================
-- ENTREGAS
-- =========================
INSERT INTO entregas (
    status, pedido_id, criado_em, codigo_rastreio,
    motorista_id, placa_veiculo, data_prevista,
    latitude_destino, longitude_destino
) VALUES
(
    'SAIU_PARA_ENTREGA',
    1,
    CURRENT_TIMESTAMP,
    'MVXABC123',
    1,
    'ABC-1234',
    CURRENT_TIMESTAMP + interval '2 hours',
    -22.9068,
    -43.1729
),
(
    'EM_TRANSPORTE',
    2,
    CURRENT_TIMESTAMP,
    'MVXDEF456',
    2,
    'XYZ-5678',
    CURRENT_TIMESTAMP + interval '5 hours',
    -25.4284,
    -49.2733
);

-- =========================
-- LOCALIZAÇÕES
-- =========================
INSERT INTO location (
    latitude, longitude, timestamp, entrega_id
) VALUES
(
    -22.9120,
    -43.2000,
    CURRENT_TIMESTAMP,
    1
),
(
    -25.4200,
    -49.2800,
    CURRENT_TIMESTAMP,
    2
);

-- =========================
-- MOVIMENTAÇÕES / HISTÓRICO
-- =========================
INSERT INTO movimentacoes (
    entrega_id, status_atual, descricao,
    localizacao_origem, localizacao_destino, data_hora
) VALUES
(
    1,
    'SAIU_PARA_ENTREGA',
    'Motorista saiu para entrega',
    'Centro de distribuição RJ',
    'Cliente final',
    CURRENT_TIMESTAMP
),
(
    2,
    'EM_TRANSPORTE',
    'Carga em trânsito',
    'Rio de Janeiro',
    'Curitiba',
    CURRENT_TIMESTAMP
);