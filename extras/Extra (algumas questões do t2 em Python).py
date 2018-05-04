
# 1. Escreva uma função geraTabela :: Int -> [(Int,Int)] que produza uma lista com n tuplas, cada tupla com números de n a 1 e seus respectivos quadrados.

def geraTabela(N):
  lista = []
  for x in range(1,N):
    lista.append([x,x**2])

  return lista

# 2. Defina uma função que verifique se um dado caracter está contido numa string.

def contido(a,str):
  Num = 0
  for c in str:
    if a == c:
      Num = Num + 1
    else:
      Num = Num
  
  if Num >= 1:
    return True
  else:
    return False

# 3. Escreva uma função não recursiva isBin :: String -> Bool para verificar se uma dada String representa um número binário, ou seja, contém apenas caracteres '0' ou '1'.

def isBin(str):
  Num = len(str)
  for x in str:
    if x == '1' or x == '0':
      Num = Num - 1
    
  if Num == 0:
    return True
  else:
    return False
    
# 4. Escreva uma função não recursiva bin2dec :: [Int] -> Int, que converte uma lista de 0's e 1's (representando um número binário), em seu equivalente em decimal.

def bin2dec(L):
  Num = 0
  Aux = len(L) - 1
  for X in L:
    Num = Num + X*(2**Aux)
    Aux = Aux - 1
  return Num
  
# 5. Implemente uma dessas funções: isHex :: String -> Bool ou hex2dec :: String -> Int ou dec2hex :: Int -> String, que são semelhantes às dos exercícios anteriores, porém com números hexadecimais no lugar de números binários. Aqui está tudo liberado: você pode escolher qual das funções irá implementar, sem restrições sobre como deve fazer isso.

def isHex(str):
  Num = len(str)
  for x in str:
    if x == '0' or x == '1'or x == '2'or x == '3'or x == '4'or x == '5'or x == '6'or x == '7'or x == '8'or x == '9'or x == 'A'or x == 'B'or x == 'C'or x == 'D'or x == 'E'or x == 'F':
      Num = Num - 1
    
  if Num == 0:
    return True
  else:
    return False
