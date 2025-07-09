-- Altera tabela de categorias para receber o id correspondente de receita ou despesa
ALTER TABLE FINAI_CATEGORY ADD (
  movement_type_id NUMBER NOT NULL
);

ALTER TABLE FINAI_CATEGORY ADD CONSTRAINT fk_category_movement_type
  FOREIGN KEY (movement_type_id) REFERENCES FINAI_MOVEMENT_TYPE (movement_type_id);

-- INSERE tipos de movimentação: Receita e Despesa
INSERT INTO FINAI_MOVEMENT_TYPE (movement_type_id, movement_name, movement_type_description)
VALUES (1, 'INCOME', 'Receita — Entradas de dinheiro');

INSERT INTO FINAI_MOVEMENT_TYPE (movement_type_id, movement_name, movement_type_description)
VALUES (2, 'EXPENSE', 'Despesa — Saídas de dinheiro');


--INSERE Metodos de pagamento
INSERT INTO FINAI_PAYMENT_METHOD (payment_method_id, payment_method_name, description) VALUES (1, 'CREDIT_CARD', 'Cartão de Crédito');
INSERT INTO FINAI_PAYMENT_METHOD (payment_method_id, payment_method_name, description) VALUES (2, 'DEBIT_CARD', 'Cartão de Débito');
INSERT INTO FINAI_PAYMENT_METHOD (payment_method_id, payment_method_name, description) VALUES (3, 'CASH', 'Dinheiro em espécie');
INSERT INTO FINAI_PAYMENT_METHOD (payment_method_id, payment_method_name, description) VALUES (4, 'PIX', 'Transferência instantânea via PIX');
INSERT INTO FINAI_PAYMENT_METHOD (payment_method_id, payment_method_name, description) VALUES (5, 'TRANSFER', 'Transferência Bancária');
INSERT INTO FINAI_PAYMENT_METHOD (payment_method_id, payment_method_name, description) VALUES (6, 'BOLETO', 'Pagamento via Boleto');
INSERT INTO FINAI_PAYMENT_METHOD (payment_method_id, payment_method_name, description) VALUES (7, 'DIGITAL_WALLET', 'Carteira Digital');
INSERT INTO FINAI_PAYMENT_METHOD (payment_method_id, payment_method_name, description) VALUES (8, 'CHEQUE', 'Pagamento com Cheque');
INSERT INTO FINAI_PAYMENT_METHOD (payment_method_id, payment_method_name, description) VALUES (9, 'LOAN', 'Empréstimo');
INSERT INTO FINAI_PAYMENT_METHOD (payment_method_id, payment_method_name, description) VALUES (10, 'SALARY', 'Salário recebido diretamente');
INSERT INTO FINAI_PAYMENT_METHOD (payment_method_id, payment_method_name, description) VALUES (11, 'OTHER', 'Outro método de pagamento');

-- INSERE sim ou não na tabela de recorrentes
INSERT INTO FINAI_RECURRING (recurring_id, name) VALUES (1, 'YES');
INSERT INTO FINAI_RECURRING (recurring_id, name) VALUES (2, 'NO');


-- Insere categorias
-- 👉 Básicas (Despesas)
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (1, 'GROCERIES', 'Alimentação Supermercado', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (2, 'RESTAURANTS', 'Alimentação Restaurante', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (3, 'PUBLIC_TRANSPORT', 'Transporte Público', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (4, 'FUEL', 'Combustível', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (5, 'VEHICLE_MAINTENANCE', 'Manutenção de Veículo', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (6, 'RENT', 'Aluguel / Condomínio', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (7, 'WATER_BILL', 'Contas de Água', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (8, 'ELECTRICITY_BILL', 'Contas de Luz', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (9, 'GAS_BILL', 'Contas de Gás', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (10, 'INTERNET', 'Internet', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (11, 'PHONE', 'Telefone / Celular', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (12, 'TV_STREAMING', 'TV a Cabo / Streaming', 2);

-- 👉 Pessoais (Despesas)
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (13, 'HEALTH', 'Saúde (consultas, exames)', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (14, 'PHARMACY', 'Farmácia / Remédios', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (15, 'GYM', 'Academia / Esportes', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (16, 'EDUCATION', 'Educação (escola, faculdade, cursos)', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (17, 'PERSONAL_CARE', 'Cuidados Pessoais (cabeleireiro, estética)', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (18, 'CLOTHING', 'Vestuário', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (19, 'PETS', 'Pets (alimentação, veterinário)', 2);

-- 👉 Lazer e Cultura (Despesas)
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (20, 'ENTERTAINMENT', 'Cinema / Shows', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (21, 'TRAVEL', 'Viagens', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (22, 'BARS_RESTAURANTS', 'Restaurantes / Bares', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (23, 'SUBSCRIPTIONS', 'Assinaturas (Netflix, Spotify, etc.)', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (24, 'GIFTS', 'Presentes', 2);

-- 👉 Despesas Financeiras
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (25, 'INTEREST_FEES', 'Juros / Multas', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (26, 'BANK_FEES', 'Taxas Bancárias', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (27, 'CREDIT_CARD_FEE', 'Anuidade de Cartão de Crédito', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (28, 'LOANS', 'Empréstimos / Parcelas', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (29, 'TAXES', 'Impostos', 2);

-- 👉 Despesas Variáveis
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (30, 'ONLINE_SHOPPING', 'Compras Online', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (31, 'APPLIANCES', 'Eletrodomésticos', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (32, 'FURNITURE', 'Móveis', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (33, 'DECORATION', 'Decoração', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (34, 'HOME_REPAIRS', 'Reparos da Casa', 2);

-- 👉 Despesas Especiais
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (35, 'DONATIONS', 'Doações / Caridade', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (36, 'DOMESTIC_SERVICES', 'Serviços Domésticos (faxina, diarista)', 2);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (37, 'INSURANCE', 'Seguros (carro, vida, casa)', 2);

-- 👉 Renda Principal (INCOME)
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (38, 'SALARY', 'Salário', 1);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (39, 'THIRTEENTH_SALARY', '13º Salário', 1);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (40, 'VACATION', 'Férias', 1);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (41, 'BONUS', 'Bônus / PLR', 1);

-- 👉 Renda Extra (INCOME)
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (42, 'FREELANCE', 'Freelance', 1);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (43, 'SELF_EMPLOYED', 'Serviços Autônomos', 1);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (44, 'ITEM_SALES', 'Vendas de Itens Usados', 1);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (45, 'LOTTERY', 'Prêmios / Loteria', 1);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (46, 'CASHBACK', 'Cashback', 1);

-- 👉 Investimentos (INCOME)
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (47, 'SAVINGS_INTEREST', 'Juros de Poupança', 1);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (48, 'DIVIDENDS', 'Dividendos de Ações', 1);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (49, 'FUNDS_REVENUE', 'Rendimentos de Fundos', 1);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (50, 'RENTAL_INCOME', 'Aluguel de Imóveis', 1);

-- 👉 Outras Receitas (INCOME)
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (51, 'PENSION', 'Pensão Recebida', 1);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (52, 'ALLOWANCE', 'Mesada / Ajuda Familiar', 1);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (53, 'REIMBURSEMENT', 'Reembolso de Despesas', 1);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (54, 'TAX_REFUND', 'Restituição de Imposto de Renda', 1);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (55, 'COMPENSATION', 'Indenizações', 1);
INSERT INTO FINAI_CATEGORY (category_id, category_name, category_description, movement_type_id) VALUES (56, 'INHERITANCE', 'Herança', 1);
