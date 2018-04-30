% CD Independente

% Uma banda formada por alunos e alunas da escola est� gravando um CD com exatamente sete m�sicas
% distintas � S, T, V, W, X, Y e Z. Cada m�usica ocupa exatamente uma das sete faixas contidas no
% CD. Algumas das m�sicas s�o sucessos antigos de rock; outras s�o composi��oes da pr�pria banda. As
% seguintes restri��es devem ser obedecidas:

% regra 1) -> S ocupa a quarta faixa do CD.
% regra 2) -> Tanto W como Y precedem S no CD (ou seja, W e Y est�o numa faixa que � tocada antes de S no CD).
% regra 3) -> T precede W no CD (ou seja, T est� numa faixa que � tocada antes de W).
% regra 4) -> Um sucesso de rock ocupa a sexta faixa do CD.
% regra 5) -> Cada sucesso de rock � imediatamente precedido no CD por uma composi��o da banda (ou seja,
%   no CD cada sucesso de rock toca imediatamente ap�s uma composi��o da banda).
% regra 6) -> Z � um sucesso de rock.

regra1(L) :- nth0(X,L,s), X = 3.

regra2(L) :- nth0(X1,L,s), nth0(X2,L,w), nth0(X3,L,y), X2 < X1, X3 < X1.

regra3(L) :- nth0(X1,L,w), nth0(X2,L,t), X2 < X1.

% regra 4, regra 5 e regra 6 
banda(M,N) :- N \= 5, M \= z.

sucesso(_,5).
sucesso(z,N) :- N > 0, N \= 4, N \= 6.

regra5(L,Ind) :- L = [_|T], T = [H2|_], N is Ind+1, banda(H2,N), regra5(T,N).
regra5(L,Ind) :- L = [_|T], T = [H2|_], N is Ind+1, sucesso(H2,N), regra5(T,N).
regra5([_,M],Ind) :- N is Ind+1, banda(M,N).
regra5([_,M],Ind) :- N is Ind+1, sucesso(M,N).

cdindependente(L) :-
    regra1(L),
    regra2(L),
    regra3(L),
    regra5(L,0).

% Quest�o 11. Qual das seguintes alternativas poderia
% ser a ordem das m�sicas no CD, da primeira
% para a s�tima faixa?
% (A) T, W, V, S, Y, X, Z -> cdindependente([t,w,v,s,y,x,z]).
% (B) V, Y, T, S, W, Z, X -> cdindependente([v,y,t,s,w,z,x]).
% (C) X, Y, W, S, T, Z, S -> cdindependente([x,y,w,s,t,z,s]).
% (D) Y, T, W, S, X, Z, V -> cdindependente([y,t,w,s,x,z,v]).
% (E) Z, T, X, W, V, Y, S -> cdindependente([y,t,w,s,x,z,v]).