# TOTALMENTE INCOMPLETO: ESTE É APENAS UM ESQUELETO!

Este é um projeto de um jogo "OnMyWay", um jogo singleplayer em turnos!

Basicamente, o jogador precisa sobreviver em um mapa 2D por X segundos (na implementação, são os movimentos do mesmo) a alguns tipos de inimigos, onde cada um deles tem seu próprio estilo de comportamento e movimento. O objetivo é simples: sobreviva correndo deles pelo mapa-labirinto até que a ajuda chegue e elimine-os! 

O Jogador perde se um dos inimigos entrar em contato com o mesmo e ambos colidem com os "muros".

No inicio do jogo, o jogador sempre começará num lugar aleatório (e os inimigos também). 

Pretende-se (sem promessas) criar um sistema de "vidas-extra" e uma opcão "dificuldade" (spawn rate/movimento) dos inimigos.

*** Note to self: usar uma classe de Fábrica para instanciar os objetos do jogo (inimigos, mapas, etc)