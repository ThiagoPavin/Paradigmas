import Data.Char

--PARTE 4

-- Converte um caracter em um inteiro
encodeChar :: Char -> Int
encodeChar c = ord c - ord 'a'

-- Converte um inteiro em um caracter
decodeChar :: Int -> Char
decodeChar n = chr (ord 'a' + n)

--1. Usando encodeChar e decodeChar, defina uma função shiftChar :: Char -> Int -> Char. Essa função, ao receber um caracter de 'a' a 'z', aplicará um deslocamento de 'n' unidades sobre ele, produzindo outro caracter no intervalo ['a'..'z'].

shiftChar :: Char -> Int -> Char
shiftChar c num
  | c == ' ' = ' '
  | (encodeChar c) >= 0 && (encodeChar c) <= 25 = decodeChar(mod((encodeChar c) + num)26)
  | (encodeChar c) <= -7 && (encodeChar c) >= -32 = c

--2. Usando shiftChar, defina uma função encodeStr :: String -> Int -> String que codifique uma string usando um dado deslocamento. 

encodeStr :: String -> Int -> String
encodeStr str num = map (\c -> shiftChar c num)str

--3. Defina uma função countValids :: String -> Int, que receba uma string e retorne a quantidade de seus caracteres contidos no intervalo ['a'..'z'].

countValids :: String -> Int
countValids str = length(filter(`elem` "abcdefghijklmnopqrstuvxyz")str)

--4. Defina uma função countChar :: Char -> String -> Int, que retorne a quantidade de um dado caracter em uma string.

countChar :: Char -> String -> Int
countChar c str = length(filter(== c)str)

