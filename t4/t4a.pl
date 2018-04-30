% CD Independente

% Uma banda formada por alunos e alunas da escola está gravando um CD com exatamente sete músicas
% distintas – S, T, V, W, X, Y e Z. Cada m´usica ocupa exatamente uma das sete faixas contidas no
% CD. Algumas das músicas são sucessos antigos de rock; outras são composiçõoes da própria banda. As
% seguintes restrições devem ser obedecidas:

% regra 1) -> S ocupa a quarta faixa do CD.
% regra 2) -> Tanto W como Y precedem S no CD (ou seja, W e Y estão numa faixa que é tocada antes de S no CD).
% regra 3) -> T precede W no CD (ou seja, T está numa faixa que é tocada antes de W).
% regra 4) -> Um sucesso de rock ocupa a sexta faixa do CD.
% regra 5) -> Cada sucesso de rock é imediatamente precedido no CD por uma composição da banda (ou seja,
%   no CD cada sucesso de rock toca imediatamente após uma composição da banda).
% regra 6) -> Z é um sucesso de rock.

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

% Questão 11. Qual das seguintes alternativas poderia
% ser a ordem das músicas no CD, da primeira
% para a sétima faixa?
% (A) T, W, V, S, Y, X, Z -> cdindependente([t,w,v,s,y,x,z]).
% (B) V, Y, T, S, W, Z, X -> cdindependente([v,y,t,s,w,z,x]).
% (C) X, Y, W, S, T, Z, S -> cdindependente([x,y,w,s,t,z,s]).
% (D) Y, T, W, S, X, Z, V -> cdindependente([y,t,w,s,x,z,v]).
% (E) Z, T, X, W, V, Y, S -> cdindependente([y,t,w,s,x,z,v]).