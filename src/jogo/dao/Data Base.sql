
CREATE DATABASE Jogo_POO;

USE Jogo_POO;

CREATE TABLE Action(
	idMatch INT NOT NULL,
	idAction INT NOT NULL AUTO_INCREMENT,
    Name VARCHAR(50) NULL,
    Status VARCHAR(20) NULL,
    MarketQuantity FLOAT NULL,
    PlayerQuantity FLOAT NULL,
    PRIMARY KEY (idAction)
);
CREATE TABLE ValueHistory(
	id INT NOT NULL AUTO_INCREMENT,
	idAction INT NOT NULL,
    Value FLOAT NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE VariationHistory(
	id INT NOT NULL AUTO_INCREMENT,
	idAction INT NOT NULL,
    Value FLOAT NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE PurchaseOrderList(
	id INT NOT NULL AUTO_INCREMENT,
	idAction INT NOT NULL,
    Quantity INT NULL,
    Value FLOAT NULL,
    StartTurn INT NULL,
    EndTurn INT NULL,
    IsFromPlayer BOOLEAN,
    PRIMARY KEY (id)
);
CREATE TABLE SalesOrderList(
	id INT NOT NULL AUTO_INCREMENT,
	idAction INT NOT NULL,
    Quantity INT NULL,
    Value FLOAT NULL,
    StartTurn INT NULL,
    EndTurn INT NULL,
    IsFromPlayer BOOLEAN,
    PRIMARY KEY (id)
);



CREATE TABLE Game(
	idMatch INT NOT NULL AUTO_INCREMENT,
    NumTurn INT NOT NULL,
    PRIMARY KEY (idMatch)
);



CREATE TABLE Loan(
	id int NOT NULL AUTO_INCREMENT,
	idMatch INT NOT NULL,
    Value FLOAT NULL,
    Interest FLOAT NULL,
    StartTurn Int NULL,
    PRIMARY KEY (id)
);



CREATE TABLE Market(
	idMatch INT NOT NULL AUTO_INCREMENT,
    Status VARCHAR(20) NULL,
    PRIMARY KEY (idMatch)
);
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



/*CREATE TABLE financial_order(
	idMatch INT NOT NULL,
    Quantity INT NULL,
    Value FLOAT NULL,
    StartTurn INT NULL,
    EndTurn INT NULL,
    IsFromPlayer BOOLEAN
);*/



CREATE TABLE Player(
	idMatch INT NOT NULL,
    name VARCHAR(50) NOT NULL,
	Money FLOAT NULL,
    Income FLOAT NULL,
    PRIMARY KEY (idMatch)
);

/*CREATE TABLE FixedIncome(
	idMatch INT NOT NULL,
    value FLOAT NULL
);*/
/*DROP DATABASE jogo_poo*/