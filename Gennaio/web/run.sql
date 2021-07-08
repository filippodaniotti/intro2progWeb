/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Filippo
 * Created: Jul 7, 2021
 */

CREATE TABLE Alloggi ( 
    ID int PRIMARY KEY, 
    NOME varchar(255), 
    PREZZO int, 
    PUNTEGGIO decimal(2,1),
    TIPO int, 
    IMAGE varchar(255),
    EXTRA int 
);
INSERT INTO WEBENGINE.ALLOGGI (ID, NOME, PREZZO, PUNTEGGIO, TIPO, IMAGE,EXTRA) VALUES (1,'Alpenhof', 60, 8.5, 2, 'Alpenhof.jpg',2);
INSERT INTO WEBENGINE.ALLOGGI (ID, NOME, PREZZO, PUNTEGGIO, TIPO, IMAGE,EXTRA) VALUES (2,'Artemide', 100, 8.4, 1, 'Artemide.jpg',4);
INSERT INTO WEBENGINE.ALLOGGI (ID, NOME, PREZZO, PUNTEGGIO, TIPO, IMAGE,EXTRA) VALUES (3,'Belste', 35, 6.2, 2, 'Belste.jpg',1);
INSERT INTO WEBENGINE.ALLOGGI (ID, NOME, PREZZO, PUNTEGGIO, TIPO, IMAGE,EXTRA) VALUES (4,'Gruber', 75, 9.3, 2, 'Gruber.jpg',3);
INSERT INTO WEBENGINE.ALLOGGI (ID, NOME, PREZZO, PUNTEGGIO, TIPO, IMAGE,EXTRA) VALUES (5,'Majestic', 65, 8.8, 1, 'Majestic.jpg',3);
INSERT INTO WEBENGINE.ALLOGGI (ID, NOME, PREZZO, PUNTEGGIO, TIPO, IMAGE,EXTRA) VALUES (6,'Palace', 200, 8.3, 1, 'Palace.jpg',5);
INSERT INTO WEBENGINE.ALLOGGI (ID, NOME, PREZZO, PUNTEGGIO, TIPO, IMAGE,EXTRA) VALUES (7,'Pietra Bianca ', 40, 9.5, 3, 'PietraBianca.jpg',4);
INSERT INTO WEBENGINE.ALLOGGI (ID, NOME, PREZZO, PUNTEGGIO, TIPO, IMAGE,EXTRA) VALUES (8,'Sapore Di Sale', 80, 7.9, 3, 'SaporeDiSale.jpg',8);
INSERT INTO WEBENGINE.ALLOGGI (ID, NOME, PREZZO, PUNTEGGIO, TIPO, IMAGE,EXTRA) VALUES (9,'Tenuta Di Artimino', 60, 5.5, 3, 'TenutaDiArtimino.jpg',6);
INSERT INTO WEBENGINE.ALLOGGI (ID, NOME, PREZZO, PUNTEGGIO, TIPO, IMAGE,EXTRA) VALUES (10,'Zenith', 70, 6.2, 1, 'Zenith.jpg',3);

