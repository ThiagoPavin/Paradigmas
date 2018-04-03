--PARTE 3
--A codificação EAN-13 é um padrão de código de barras usado em vários tipos de produtos. O número codificado em barras tem 13 dígitos (0-9), sendo o último um dígito verificador (exemplo: 5901234123457, dígito verificador 7). O cálculo do dígito verificador obedece a algumas regras simples disponíveis em: https://www.gs1.org/services/how-calculate-check-digit-manually

--Você deverá implementar uma função isEanOk :: String -> Bool, que verifique se uma dada string representa um número EAN-13 com dígito verificador válido.

import Data.Char

somaMul :: String -> Int
somaMul str = sum (zipWith (*) (map (digitToInt) str) (cycle [1,3]))

verifica :: Int -> Int
verifica x 
  | x `mod` 10 == 0 = 0
  | x `mod` 10 == 1 = 9
  | x `mod` 10 == 2 = 8
  | x `mod` 10 == 3 = 7
  | x `mod` 10 == 4 = 6
  | x `mod` 10 == 5 = 5
  | x `mod` 10 == 6 = 4
  | x `mod` 10 == 7 = 3
  | x `mod` 10 == 8 = 2
  | x `mod` 10 == 9 = 1

isEanOk :: String -> Bool
isEanOk str = if (digitToInt (last str)) == verifica (somaMul (init str)) then True else False
