INSERT INTO cliente (nome, telefone, email, endereco) VALUES 
('Ana Silva', '21988776655', 'ana.silva@email.com', 'Rua das Flores, 123, Rio de Janeiro'),
('Bruno Costa', '11977665544', 'bruno.costa@email.com', 'Avenida Paulista, 456, São Paulo'),
('Carla Dias', '31966554433', 'carla.dias@email.com', 'Rua dos Inconfidentes, 789, Belo Horizonte');


INSERT INTO pedido (origem, destino, peso, valor_frete, data_criacao, cliente_id) VALUES
('Rio de Janeiro', 'São Paulo', 10.0, 15.00, '2025-11-08', 1),   
('Rio de Janeiro', 'Belo Horizonte', 5.0, 7.50, '2025-11-08', 1), 
('São Paulo', 'Curitiba', 25.5, 38.25, '2025-11-08', 2);         


INSERT INTO entregas (status, data_criacao, pedido_id) VALUES
('PENDENTE', '2025-11-08T21:30:00', 1),  
('EM_TRANSITO', '2025-11-08T21:35:00', 2); 