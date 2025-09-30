-- 1. Tabela para o cadastro de Usuários
-- Mapeia a classe Usuario (Para controle de acesso: Admin, Operador)
CREATE TABLE TB_USUARIO (
    id_usuario INT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    tipo_acesso VARCHAR(20) NOT NULL -- 'Admin' ou 'Operador'
);

-- 2. Tabela para o cadastro de Áreas Agrícolas
-- Mapeia a classe AreaAgricola
CREATE TABLE TB_AREA (
    id_area INT PRIMARY KEY,
    tamanho_ha DECIMAL(10, 2) NOT NULL,
    localizacao VARCHAR(255) NOT NULL,
    tipo_cultivo VARCHAR(50)
);

-- 3. Tabela para o cadastro de Drones
-- Mapeia a classe Drone (Contém os atributos de segurança/checklist)
CREATE TABLE TB_DRONE (
    id_drone INT PRIMARY KEY,
    modelo VARCHAR(50) NOT NULL,
    sensores_disp VARCHAR(255),
    status VARCHAR(50) NOT NULL, -- 'Disponível', 'Em Missão', 'Manutenção'
    bateria_minima INT,          -- Simula o percentual de bateria na checagem
    sensores_funcionando BOOLEAN -- Simula o status do checklist
);

-- 4. Tabela para as Missões de Voo
-- Mapeia a classe MissaoVoo (Contém as Associações com Drone, Area e Operador)
CREATE TABLE TB_MISSAO (
    id_missao INT PRIMARY KEY,
    data DATE NOT NULL,
    horario_inicio TIME NOT NULL,
    horario_fim TIME NOT NULL,
    
    -- Chaves Estrangeiras para as Associações
    fk_drone INT NOT NULL,
    fk_area INT NOT NULL,
    fk_operador INT NOT NULL,

    -- Definição das chaves estrangeiras
    FOREIGN KEY (fk_drone) REFERENCES TB_DRONE(id_drone),
    FOREIGN KEY (fk_area) REFERENCES TB_AREA(id_area),
    FOREIGN KEY (fk_operador) REFERENCES TB_USUARIO(id_usuario)
);

-- 5. Tabela para os Dados Coletados
-- Mapeia a classe DadoColetado (Relacionamento de Composição com MissaoVoo)
CREATE TABLE TB_DADOS_COLETADOS (
    id_dado INT PRIMARY KEY,
    fk_missao INT NOT NULL, -- Chave Estrangeira
    
    imagem_url VARCHAR(255),
    temperatura DECIMAL(5, 2),
    umidade DECIMAL(5, 2),
    valor_sensor_simulado DECIMAL(10, 2),

    -- Define a Composição: o Dado Coletado depende da Missão
    FOREIGN KEY (fk_missao) REFERENCES TB_MISSAO(id_missao)
);
