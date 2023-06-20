-- V5__insert_data.sql

--inserindo tecnico
INSERT INTO TB_PESSOA(DTYPE, PESSOA_ID, CPF, DATA_CRIACAO, EMAIL, NOME, SENHA) VALUES
  ('Tecnico', 1, '55555555555', '2022-05-23', 'dre@email.com', 'dre', 'dre123'),
  ('Tecnico', 2, '66666666666', '2022-05-13', 'pri@email.com', 'pri', 'pri123'),
  ('Tecnico', 3, '77777777777', '2022-05-13', 'adriano@email.com', 'adriano', 'adriano123'),
  ('Tecnico', 4, '88888888888', '2022-05-23', 'priscila@email.com', 'priscila', 'priscila123');

--inserindo cliente
INSERT INTO TB_PESSOA(DTYPE, PESSOA_ID, CPF, DATA_CRIACAO, EMAIL, NOME, SENHA) VALUES
  ('Cliente', 5, '22222222222', '2022-05-23', 'valentina@email.com', 'valentina dog', '123'),
  ('Cliente', 6, '00000000000', '2022-05-24', 'odin@email.com', 'Odin dog', '123'),
  ('Cliente', 7, '11111111111', '2022-05-21', 'josevaldo@email.com', 'josevaldo', '123'),
  ('Cliente', 8, '33333333333', '2022-05-23', 'joelia@email.com', 'joelia', '123');

--inserindo perfis(TECNICO)
INSERT INTO PERFIS(PESSOA_PESSOA_ID, PERFIS) VALUES (1, 2), (2, 2), (3, 2), (4, 2);

--inserindo perfis(CLIENTE)
INSERT INTO PERFIS(PESSOA_PESSOA_ID, PERFIS) VALUES (5, 1), (6, 1), (7, 1), (8, 1);

--inserindo chamado
INSERT INTO TB_CHAMADO(ID, DATA_ABERTURA, DATA_FECHAMENTO, OBSERVACOES, PRIORIDADE, STATUS, TITULO, CLIENTE_ID, TECNICO_ID) VALUES
  (1, '2022-05-14', '2022-05-24', 'Primeiro chamado', 'MEDIA', 1, 'Chamado 01', 5, 1),
  (2, '2022-05-20', '2022-05-28', 'Segundo chamado', 'ALTA', 1, 'Chamado 01', 6, 3),
  (3, '2022-05-14', '2022-05-24', 'Primeiro chamado', 'MEDIA', 1, 'Chamado 01', 7, 2);

--inserindo usuário
INSERT INTO TB_USER(username, email, password_user) VALUES ('Admin', 'admin@email.com', '$2a$10$ScxWIRKjc4MAX4czBWFC1.A2BjxMdflbo3dgMmqdY8a.MirR2OPVS');

--inserindo perfis
INSERT INTO tb_profiles VALUES (1, 'ADMIN'), (2, 'USER');

--associando perfil ao usuário
INSERT INTO TB_USER_PERFIS VALUES (1, 1);
