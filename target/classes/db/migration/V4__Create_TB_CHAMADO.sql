CREATE TABLE TB_CHAMADO (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  data_abertura DATE NOT NULL,
  data_fechamento DATE NOT NULL,
  prioridade VARCHAR(255) NOT NULL,
  status VARCHAR(255) NOT NULL,
  titulo VARCHAR(100) NOT NULL,
  observacoes VARCHAR(200) NOT NULL,
  tecnico_id BIGINT,
  cliente_id BIGINT,
  FOREIGN KEY (tecnico_id) REFERENCES TB_PESSOA (pessoa_id),
  FOREIGN KEY (cliente_id) REFERENCES TB_PESSOA (pessoa_id)
);
