 Sistema de Cadastro de Veículos

Este projeto é um sistema simples em Java que permite cadastrar, listar, excluir e pesquisar veículos.  
Foi desenvolvido com foco em Programação Orientada a Objetos (POO), utilizando encapsulamento e abstração.
Funcionalidades
Cadastrar veículo 
Valida marca, modelo, ano (1986 a 2026) e placa no formato `ABC-123`.  
Não permite cadastro de veículos com placa duplicada.  

Listar veículos 
Mostra todos os veículos cadastrados no sistema.  

Excluir veículo 
Exclusão feita informando a **placa**.  

Pesquisar veícul 
Pesquisa por **placa exata**.  
 Pesquisa por parte do modelo (usando `contains`).  

Tecnologias
Java 17+ (pode rodar também em versões anteriores, a partir do Java 8)
Programação Orientada a Objetos
`ArrayList` para armazenamento de veículos
`Scanner` para entrada de dados
