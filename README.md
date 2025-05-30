# Lista de Preços

Programa simples para cadastrar produtos e mostrar lista de preços. Trabalho realizado por Kayky, Arthur, Eduardo e João.

## Como usar

1. Criar o banco de dados:
```
mysql -u root -p < banco.sql
```

2. Compilar o programa:
```
javac ListaPrecos.java
```

3. Executar:
```
java ListaPrecos
```

## O que o programa faz

- Cadastra produtos com nome e preço
- Mostra lista de preços dos produtos cadastrados

## Requisitos Funcionais

- RF01: Sistema deve permitir cadastrar produtos com nome e preço
- RF02: Sistema deve exibir lista de preços ordenada por nome do produto
- RF03: Sistema deve permitir a navegação através de um menu de opções
- RF04: Sistema deve permitir encerrar o programa através do menu

## Requisitos Não Funcionais

- RNF01: Sistema deve ser executado em terminal/console
- RNF02: Sistema deve utilizar banco de dados MySQL para persistência dos dados
- RNF03: Sistema deve exibir valores monetários formatados com duas casas decimais
- RNF04: Sistema deve tratar e exibir mensagens de erro de forma amigável ao usuário
- RNF05: Sistema deve manter os produtos ordenados alfabeticamente na listagem

## Tecnologias Utilizadas

- Java 8
- MySQL
