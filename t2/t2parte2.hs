--PARTE 2
--1. Escreva uma função recursiva isBin :: String -> Bool para verificar se uma dada String representa um número binário, ou seja, contém apenas caracteres '0' ou '1'. As únicas funções pré-definidas autorizadas aqui são head e tail.

tamanho :: String -> Int
tamanho str
  | str == "" = 0
  | str /= "" = (1 + tamanho(tail str))

verifica :: Char -> Bool
verifica c
  | c == '0' || c == '1' = True
  | c /= '0' || c /= '1' = False

isBin :: String -> Bool
isBin str
  | str == "" = False
  | tamanho str == 1 = verifica (head str)
  | tamanho str > 1 = isBin (tail str)

--2. Reescreva a função acima de forma não-recursiva. Dê outro nome para ela, por exemplo isBin'. Aqui você pode usar quaisquer funções auxiliares pré-definidas em Haskell.

isBin' :: String -> Bool
isBin' "" = False
isBin' str = length(filter (\str -> if str == '0' || str == '1' then False else True)str) == 0

--3. Implemente a função auxBin2Dec de forma recursiva, para que bin2dec funcione corretamente:

auxBin2Dec :: [Int] -> Int -> Int
auxBin2Dec lista tam
  | lista == [] = 0
  | lista /= [] = (head lista) * (2^tam) + auxBin2Dec (tail lista) (tam-1)

bin2dec :: [Int] -> Int
bin2dec [] = undefined
bin2dec bits = auxBin2Dec bits ((length bits)-1)

--4. Reescreva a função do exercício anterior de forma não-recursiva, usando funções pré-definidas em Haskell. Dê outro nome para a função (por exemplo, bin2dec').

bin2dec' :: [Int] -> Int
bin2dec' lista = sum (zipWith (*) lista (map (\x -> 2^x) [(length lista)-1, (length lista)-2..0]))


--5. Crie uma função recursiva dec2bin :: Int -> [Int] que receba um número inteiro positivo e retorne sua representação em binário, sob forma de uma lista de 0's e 1's. As funções auxiliares autorizadas aqui são mod, div e reverse. 

dec2bin :: Int -> [Int]
dec2bin x
  | x == 1 = [1]
  | x == 0 = [0]
  | (x `div` 2) == 0 = (x `mod` 2) : [0]
  | (x `div` 2) == 1 = (x `mod` 2) : [1]
  | (x `div` 2) > 1 = reverse((x `mod` 2) : dec2bin (x `div` 2))








