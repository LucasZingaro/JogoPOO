CREATE DATABASE Jogo_POO;

USE Jogo_POO;

CREATE TABLE Action(
    idMatch INT NOT NULL,
    Name VARCHAR(50) NULL,
    MarketQuantity FLOAT NULL,
    PlayerQuantity FLOAT NULL,
    PRIMARY KEY (idMatch)
);
CREATE TABLE ValueHistory(
	idMatch INT NOT NULL,
    Value FLOAT NOT NULL
);
/*FixedIncome*/



CREATE TABLE Game(
	idMatch INT NOT NULL,
    NumTurn INT NOT NULL,
    PRIMARY KEY (idMatch)
);



CREATE TABLE Loan(
	idMatch INT NOT NULL,
    Value FLOAT NULL,
    Interest FLOAT NULL,
    StartTurn Int NULL
);



/*CREATE TABLE Market(
	idMatch INT NOT NULL AUTO_INCREMENT,
);*/
CREATE TABLE inflationHistory(
	idMatch INT NOT NULL,
	Inflation FLOAT NULL
);
CREATE TABLE cdiHistory(
	idMatch INT NOT NULL,
    CDI FLOAT NULL
);
CREATE TABLE selicHistory(
	idMatch INT NOT NULL,
    Selic FLOAT NULL
);



CREATE TABLE financial_order(
	idMatch INT NOT NULL,
    Quantity INT NULL,
    Value INT NULL,
    StartTurn INT NULL,
    EndTurn INT NULL,
    IsFromPlayer BOOLEAN
);



CREATE TABLE Player(
	idMatch INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
	Money FLOAT NULL,
    Income FLOAT NULL,
    PRIMARY KEY (idMatch)
);
/*DROP DATABASE jogo_poo*/