% Bolsa de estudo

% Exatamente sete alunas – Fafá, Gal, Hebe, Isa, Juju, Kia e Lia – concorrem por uma bolsa de estudos
% para um Curso de Programação de Computadores e vão ser entrevistadas pela Diretora. Cada aluna
% será entrevistada exatamente uma vez, uma de cada vez, obedecendo as seguintes condições:

% regra 1) -> Isa é a primeira ou última aluna a ser entrevistada.
% regra 2) -> A quarta aluna a ser entrevistada deve ser ou Gal ou Juju.
% regra 3) -> Hebe é entrevistada imediatamente antes de Lia.
% regra 4) -> Gal é entrevistada em algum momento antes de de Kia.
% regra 5) -> Juju não é entrevistada imediatamente antes ou imediatamente após Kia.

regra1(L) :- nth0(0,L,isa); nth0(6,L,isa).

regra2(L) :- nth0(3,L,gal); nth0(3,L,juju).

regra3(L) :- nth0(X1,L,lia), nth0(X2,L,hebe), Dif is abs(X1-X2), Dif = 1.

regra4(L) :- nth0(X1,L,gal), nth0(X2,L,kia), X1 < X2.

regra5(L) :- nth0(X1,L,juju), nth0(X2,L,kia), Dif is abs(X1-X2), Dif > 1.

bolsaDeEstudo(L) :- 
    regra1(L),
    regra2(L),
   	regra3(L),
   	regra4(L),
   	regra5(L).

% Questão 1. Qual das alternativas seguintes poderia
% ser uma lista completa e correta da ordem em que 
% as alunas são entrevistadas, da primeira à última?
% (A) Hebe, Lia, Kia, Gal, Fafá, Juju, Isa -> bolsaDeEstudo([hebe,lia,kia,gal,fafa,juju,isa]).
% (B) Isa, Fafá, Gal, Juju, Kia, Hebe, Lia -> bolsaDeEstudo([isa,fafa,gal,juju,kia,hebe,lia]).
% (C) Isa, Hebe, Lia, Gal, Juju, Fafá, Kia -> bolsaDeEstudo([isa,hebe,lia,gal,juju,fafa,kia]).
% (D) Isa, Hebe, Gal, Juju, Fafá, Kia, Lia -> bolsaDeEstudo([isa,hebe,gal,juju,fafa,kia,lia]).
% (E) Gal, Hebe, Lia, Juju, Isa, Kia, Fafá -> bolsaDeEstudo([gal,hebe,lia,juju,isa,kia,fafa]).