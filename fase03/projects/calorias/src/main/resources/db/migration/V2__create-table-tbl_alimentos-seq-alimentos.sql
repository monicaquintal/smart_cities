CREATE SEQUENCE SEQ_ALIMENTOS
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE TBL_ALIMENTOS (
                               ALIMENTO_ID INTEGER DEFAULT SEQ_ALIMENTOS.NEXTVAL NOT NULL,
                               NOME VARCHAR2(100) NOT NULL,
                               PORCAO VARCHAR2(30) NOT NULL,
                               QTDE_PROTEINA NUMBER(9,3) NOT NULL,
                               QTDE_CARBOIDRATO NUMBER(9,3) NOT NULL,
                               QTDE_GORDURAS NUMBER(9,3) NOT NULL,
                               TOTAL_CALORIAS NUMBER(9,3) NOT NULL
);