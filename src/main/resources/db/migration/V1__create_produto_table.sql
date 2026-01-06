CREATE TABLE product
(
    id            BIGSERIAL PRIMARY KEY,
    nome          VARCHAR(255)   NOT NULL,
    categoria     VARCHAR(100)   NOT NULL,
    marca         VARCHAR(100)   NOT NULL,
    quantidade    INT            NOT NULL,
    preco_venda   NUMERIC(10, 2) NOT NULL,
    preco_custo   NUMERIC(10, 2) NOT NULL,
    estoque_atual INT            NOT NULL,
    data_criacao  DATE           NOT NULL
);
