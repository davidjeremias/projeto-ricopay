INSERT INTO public.tb001_endereco(
	co_endereco, co_cep, no_logradouro, no_complemento, no_bairro, no_cidade, no_uf, co_ibge)
	VALUES (1, '76360000', 'R 03', '', 'parque florestal', 'ITAPACI', 'GO', '5210901');

INSERT INTO public.tb002_contato(
	co_contato, nu_telefone_movel, nu_telefone_fixo, no_email)
	VALUES (1, '61989497443', '6233611088', 'cadastrorederico@gmail.com');

INSERT INTO public.tb004_empresa(
	co_empresa, co_cnpj, no_razao_social, no_nome_fantasia, de_situacao, no_natureza_juridica, dt_abertura, no_tipo_empresa, de_porte, de_status, contato_co, endereco_co)
	VALUES (1, '30923069000158', 'rede rico bank', 'rede rico bank', 'ATIVA', '230-5 - Empresa Individual de Responsabilidade Limitada (de Natureza Empresária)', '13/07/2018', 'MATRIZ', 'MICRO EMPRESA', 'OK', 1, 1);

INSERT INTO public.tb005_usuario(
	co_usuario, no_nome, nu_cpf, co_senha, de_email, empresa_co)
	VALUES (1, 'david', '01696587166', '$2a$10$/6hcNUcKSQIv112gkJTUcOq2B/BVWsg9Vg9rMrIMOHhef6dUvVQJy', 'u2dtecnologia@gmail.com', 1);

INSERT INTO public.tb005_usuario(
	co_usuario, no_nome, nu_cpf, co_senha, de_email, empresa_co)
	VALUES (2, 'brito', '35353678400', '$2a$10$/6hcNUcKSQIv112gkJTUcOq2B/BVWsg9Vg9rMrIMOHhef6dUvVQJy', 'cadastrorederico@gmail.com', 1);

INSERT INTO public.tb006_permissao(
	co_permissao, de_permissao)
	VALUES (1, 'ROLE_MASTER');

INSERT INTO public.tb006_permissao(
	co_permissao, de_permissao)
	VALUES (2, 'ROLE_ADMINISTRADOR');

INSERT INTO public.tb006_permissao(
	co_permissao, de_permissao)
	VALUES (3, 'ROLE_LOGISTA');

INSERT INTO public.tb006_permissao(
	co_permissao, de_permissao)
	VALUES (4, 'ROLE_OPERADOR');


INSERT INTO public.tb007_usuario_permissao(
	usuario_co, permissao_co)
	VALUES (1, 1);

INSERT INTO public.tb007_usuario_permissao(
	usuario_co, permissao_co)
	VALUES (1, 2);

INSERT INTO public.tb007_usuario_permissao(
	usuario_co, permissao_co)
	VALUES (1, 3);

INSERT INTO public.tb007_usuario_permissao(
	usuario_co, permissao_co)
	VALUES (1, 4);

INSERT INTO public.tb007_usuario_permissao(
	usuario_co, permissao_co)
	VALUES (2, 2);



