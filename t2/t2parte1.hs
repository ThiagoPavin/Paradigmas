--1. Usando recursão, escreva uma função geraTabela :: Int -> [(Int,Int)] que produza uma lista com n tuplas, cada tupla com números de n a 1 e seus respectivos quadrados.

geraTabela :: Int -> [(Int,Int)]
geraTabela 1 = [(1,1)]
geraTabela x = (x,(x^2)) : (geraTabela (x-1))

--2. Defina uma função recursiva que verifique se um dado caracter está contido numa string.

elemento :: Char -> String -> Bool
elemento c str
  | str == "" = False
  | (head str) == c = True
  | (head str) /= c = elemento c (tail str)
  
--3. Defina uma função recursiva que receba uma lista de coordenadas de pontos 2D e desloque esses pontos em 2 unidades:

translate :: [(Float,Float)] -> [(Float,Float)]
translate [] = []
translate (x:xs) = ((fst x) + 2, (snd x) + 2) : translate xs
  
--4. Defina uma função que receba um número n e retorne uma lista de n tuplas, cada tupla com números de 1 a n e seus respectivos quadrados. Dica: defina uma função auxiliar recursiva com 2 argumentos, sendo um deles que se mantém inalterado na chamada recursiva.  

aux :: Int -> Int -> [(Int, Int)]
aux x y
  | x > y = []
  | x <= y = (x,x^2) : aux (x+1) y

geraTabela' :: Int -> [(Int,Int)]
geraTabela' x = (aux 1 x)
