/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Filippo
 * Created: Jul 12, 2021
 */

CREATE TABLE "DATA" (ID INTEGER NOT NULL, FIXEDCELLS VARCHAR(200), SOLUTION VARCHAR(200), PRIMARY KEY (ID));

INSERT INTO WEBENGINE."DATA" (ID, FIXEDCELLS, SOLUTION) VALUES (1, '11 13 17 19 22 23 27 28 31 32 35 36 38 39 43 44 53 55 57 66 67 71 72 74 75 78 79 82 83 87 88 91 93 97 99', '4 2 6 1 3 8 7 5 9 7 8 5 9 4 2 6 3 1 3 1 9 5 7 6 4 8 2 8 6 7 2 5 3 9 1 4 1 5 3 4 9 7 8 2 6 2 9 4 8 6 1 5 7 3 9 4 1 3 8 5 2 6 7 6 3 8 7 2 9 1 4 5 5 7 2 6 1 4 3 9 8');
INSERT INTO WEBENGINE."DATA" (ID, FIXEDCELLS, SOLUTION) VALUES (2, '14 18 22 24 25 31 32 34 38 39 44 45 46 49 51 54 56 59 61 64 65 66 71 72 76 78 79 85 86 88 92 96', '6 9 7 8 5 4 3 1 2 4 3 8 2 9 1 7 6 5 5 1 2 3 7 6 9 4 8 1 5 3 4 6 9 8 2 7 9 8 4 7 2 3 1 5 6 2 7 6 1 8 5 4 9 3 7 4 1 4 6 8 2 3 9 3 2 5 9 1 7 6 8 4 8 6 9 4 3 2 5 7 1');
INSERT INTO WEBENGINE."DATA" (ID, FIXEDCELLS, SOLUTION) VALUES (3, '13 14 16 17 22 24 26 32 33 43 45 47 53 55 57 63 65 67 77 78 84 86 88 93 94 96 97', '2 7 9 8 6 4 3 1 5 3 6 5 9 1 7 4 2 8 8 1 4 2 3 5 7 9 6 1 2 8 7 5 3 9 6 4 6 4 3 1 2 9 8 5 7 6 9 7 6 4 8 1 3 2 9 3 6 4 8 2 5 7 1 7 8 1 5 9 6 2 4 3 4 5 2 3 7 1 6 8 9');