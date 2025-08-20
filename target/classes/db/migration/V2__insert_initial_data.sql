INSERT INTO usuarios (nome, email, senha) VALUES
('Ana Silva', 'ana@email.com', '$2a$10$ABCDEFGHIJKLMNOPQRSTUVWXYZ012345'),
('Carlos Souza', 'carlos@email.com', '$2a$10$ABCDEFGHIJKLMNOPQRSTUVWXYZ012345'),
('Maria Oliveira', 'maria@email.com', '$2a$10$ABCDEFGHIJKLMNOPQRSTUVWXYZ012345');

INSERT INTO cursos (nome, categoria) VALUES
('Java Básico', 'Programação'),
('Spring Boot', 'Framework'),
('Python', 'Programação'),
('JavaScript', 'Programação');

INSERT INTO topicos (titulo, mensaje, autor_id, curso_id, status) VALUES
('Dúvida sobre loops', 'Como faço um loop em Java?', 1, 1, 'SOLUCIONADO'),
('Problema com Spring', 'Não consigo autenticar no Spring Security', 2, 2, 'NAO_SOLUCIONADO'),
('Erro no Python', 'SyntaxError no meu código', 3, 3, 'SOLUCIONADO');

INSERT INTO respuestas (mensaje, topico_id, autor_id, solucion) VALUES
('Use um for loop: for(int i=0; i<10; i++) {}', 1, 2, TRUE),
('Verifique suas configurações de segurança', 2, 1, FALSE),
('Verifique a indentação do seu código', 3, 2, TRUE);
