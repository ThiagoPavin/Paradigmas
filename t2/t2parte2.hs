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
