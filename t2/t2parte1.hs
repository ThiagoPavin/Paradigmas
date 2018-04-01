--1. Usando recursão, escreva uma função geraTabela :: Int -> [(Int,Int)] que produza uma lista com n tuplas, cada tupla com números de n a 1 e seus respectivos quadrados. Exemplo:

geraTabela :: Int -> [(Int,Int)]
geraTabela 1 = [(1,1)]
geraTabela x = (x,(x^2)) : (geraTabela (x-1))

--2. Defina uma função recursiva que verifique se um dado caracter está contido numa string, conforme os exemplos abaixo:

elemento :: Char -> String -> Bool
elemento c str
  | str == "" = False
  | (head str) == c = True
  | (head str) /= c = elemento c (tail str)
  
  