# 1. Crie uma função isVowel :: Char -> Bool que verifique se um caracter é uma vogal ou não.(Python)

def isVowel(V):
  if V in ('a','e','i','o','u','A','E','I','O','U'):
    return True
  else:
    return False

# 2. Escreva uma função addComma, que adicione uma vírgula no final de cada string contida numa lista.(Python)

def addCommaAux(L):
  return L + ","

def addComma(L):
  return list(map(addCommaAux,L))

# 3. Crie uma função htmlListItems :: [String] -> [String], que receba uma lista de strings e retorne outra lista contendo as strings formatadas como itens de lista em HTML. Resolva este exercício COM e SEM funções anônimas (lambda). (Python)

# SEM 
def htmlListItems1Aux(L):
  return "<LI>" + L + "</LI>"
  
def htmlListItems1(L):
  return list(map(htmlListItems1Aux,L))
  
# COM

def htmlListItems2(L):
  return list(map(map(lambda x: "<LI>" + x + "</LI>",L)))
  
# 4. Defina uma função que receba uma string e produza outra retirando as vogais.

def retiraVogais(str):
  vogais ='aeiouAEIOU'
  nova_str =''
  for c in str:
    if c in vogais:
      nova_str = nova_str + ''
    else:
      nova_str = nova_str + c
  return nova_str

# 5. Defina uma função que receba uma string, possivelmente contendo espaços, e que retorne outra string substituindo os demais caracteres por '-', mas mantendo os espaços.
  
def codifica(str):
  caracter ='qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNMÇç'
  nova_str =''
  for c in str:
    if c in caracter:
      nova_str = nova_str + '-'
    else:
      nova_str = nova_str + c
  return nova_str
  
# 6. Escreva uma função firstName :: String -> String que, dado o nome completo de uma pessoa, obtenha seu primeiro nome.

def firstName(str):
  caracter ='qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNMÇç'
  nova_str =''
  for c in str:
    if c in caracter:
      nova_str = nova_str + c
    else:
      return nova_str
  return nova_str
  
# 7. Escreva uma função isInt :: String -> Bool que verifique se uma dada string só contém dígitos de 0 a 9.

def isInt(str):
  caracter ='0123456789'
  N = 0
  L = len(str)
  for c in str:
    if c in caracter:
      N = N + 1
  if N == L:
    return True
  else:
    return False
    
# 8. Escreva uma função lastName :: String -> String que, dado o nome completo de uma pessoa, obtenha seu último sobrenome. Suponha que cada parte do nome seja separada por um espaço e que não existam espaços no início ou fim do nome.

def lastName(str):
  caracter ='qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNMÇç'
  nova_str =''
  Num = 0
  for c in str:
    if c == ' ':
      Num = Num + 1
      
  for c in str:
    if c in caracter:
      if Num > 0:
        nova_str = nova_str + ''
      else:
        nova_str = nova_str + c
    else:
      Num = Num - 1
  return nova_str
  
# 9. Escreva uma função userName :: String -> String que, dado o nome completo de uma pessoa, crie um nome de usuário (login) da pessoa, formado por: primeira letra do nome seguida do sobrenome, tudo em minúsculas.

def userName(str):
  string = str[0] + lastName(str)
  return string.lower()
  
# 10. Escreva uma função encodeName :: String -> String que substitua vogais em uma string, conforme o esquema a seguir: a = 4, e = 3, i = 2, o = 1, u = 0.

def encodeName(str):
  nova_str =''
  for c in str:
    if c == 'a' or c == 'A':
      nova_str = nova_str + '4'
    elif c == 'e' or c == 'E':
      nova_str = nova_str + '3'
    elif c == 'i' or c == 'I':
      nova_str = nova_str + '2'
    elif c == 'o' or c == 'O':
      nova_str = nova_str + '1'
    elif c == 'u' or c == 'U':
      nova_str = nova_str + '0'
    else:
      nova_str = nova_str + c
  return nova_str
  
# 11. Escreva uma função betterEncodeName :: String -> String que substitua vogais em uma string, conforme este esquema: a = 4, e = 3, i = 1, o = 0, u = 00.

def betterEncodeName(str):
  nova_str =''
  for c in str:
    if c == 'a' or c == 'A':
      nova_str = nova_str + '4'
    elif c == 'e' or c == 'E':
      nova_str = nova_str + '3'
    elif c == 'i' or c == 'I':
      nova_str = nova_str + '1'
    elif c == 'o' or c == 'O':
      nova_str = nova_str + '0'
    elif c == 'u' or c == 'U':
      nova_str = nova_str + "00"
    else:
      nova_str = nova_str + c
  return nova_str
  
# 12. Dada uma lista de strings, produzir outra lista com strings de 10 caracteres, usando o seguinte esquema: strings de entrada com mais de 10 caracteres são truncadas, strings com até 10 caracteres são completadas com '.' até ficarem com 10 caracteres.

def funcAUX(str):
  caracter ='qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNMÇç0123456789'
  nova_str =''
  Tam = len(str)
  AUX = 10
  if Tam >= 10:
    for c in str:
      if c in caracter and AUX > 0:
        nova_str = nova_str + c
        AUX = AUX - 1
  else:
    for c in str:
      if c in caracter:
        nova_str = nova_str + c
    AUX = 10 - Tam
    for c in range(0,AUX):
      nova_str = nova_str + '.'
  
  return nova_str
  
def func(L):
  return list(map(funcAUX,L))
