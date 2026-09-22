# BibliotecaPOO

Sistema simples de gerenciamento de biblioteca desenvolvido em **Java**, como exercício de **Programação Orientada a Objetos (POO)**. O projeto modela autores, livros, exemplares físicos, usuários e empréstimos, aplicando conceitos como encapsulamento, validação de dados e composição entre classes.
## 📚 Sobre o projeto

O sistema permite:

- Cadastrar autores e livros (um livro pode ter vários exemplares físicos);
- Cadastrar usuários e controlar se estão ativos ou inativos;
- Registrar empréstimos de exemplares disponíveis;
- Realizar devoluções, liberando o exemplar novamente;
- Listar livros e usuários cadastrados na biblioteca.

## 🗂 Estrutura do projeto

```
BibliotecaPOO/
└── src/
    ├── Autor.java        # Dados do autor (código, nome, nacionalidade)
    ├── Livro.java         # Livro, seu autor e a lista de exemplares
    ├── Exemplar.java      # Exemplar físico de um livro (disponível/emprestado)
    ├── Usuario.java       # Usuário da biblioteca (matrícula, nome, e-mail, status)
    ├── Emprestimo.java    # Relação entre usuário, livro e exemplar emprestado
    └── Biblioteca.java    # Cadastro geral de livros/usuários + classe de teste (main)
```

> O ponto de entrada do programa (método `main`) fica dentro da classe interna `TesteBiblioteca`, declarada em `Biblioteca.java`.

## 🧩 Classes principais

| Classe | Responsabilidade |
|---|---|
| `Autor` | Guarda código, nome e nacionalidade do autor |
| `Livro` | Guarda ISBN, título, ano e autor; gerencia a lista de exemplares |
| `Exemplar` | Representa uma cópia física de um livro e seu status (disponível/emprestado) |
| `Usuario` | Guarda matrícula, nome, e-mail e status (ativo/inativo) |
| `Emprestimo` | Associa usuário, livro e exemplar; controla empréstimo e devolução |
| `Biblioteca` | Mantém as listas de livros e usuários; busca e listagem |

## ✅ Pré-requisitos

- **JDK 17 ou superior** instalado ([Adoptium Temurin](https://adoptium.net/) ou OpenJDK)
- Verifique a instalação:
  ```bash
  java -version
  javac -version
  ```

## ▶️ Como executar

### Pelo terminal (VSCode ou qualquer terminal)

1. Clone o repositório e entre na pasta:
   ```bash
   git clone https://github.com/JLpensador/BibliotecaPOO.git
   cd BibliotecaPOO
   ```

2. Compile as classes (usando UTF-8 para não bagunçar os acentos):
   ```bash
   cd src
   javac -encoding UTF-8 -d ../bin *.java
   ```

3. Execute a classe de teste (que contém o `main`):
   ```bash
   cd ../bin
   java -Dfile.encoding=UTF-8 "Biblioteca$TesteBiblioteca"
   ```
   > No PowerShell (Windows), se der problema com o `$`, use aspas simples: `java -Dfile.encoding=UTF-8 'Biblioteca$TesteBiblioteca'`

### Pelo VSCode (modo visual)

1. Instale a extensão **Extension Pack for Java** (Microsoft).
2. Abra a pasta do projeto no VSCode.
3. Abra `src/Biblioteca.java`.
4. Clique em **Run** (▶) que aparece acima do método `main` dentro da classe `TesteBiblioteca`.

## 🖥 Exemplo de saída

```
=== CRIANDO AUTORES ===

=== CRIANDO LIVROS ===

=== CRIANDO EXEMPLARES ===

=== CRIANDO USUÁRIOS ===

=== CRIANDO BIBLIOTECA ===

=== LIVROS DA BIBLIOTECA ===
ISBN: 9788535910663
Título: Dom Casmurro
Ano: 1899
Autor: Machado de Assis
Quantidade de exemplares: 3
---------------------------
...

=== REALIZANDO EMPRÉSTIMO ===
=== EMPRÉSTIMO ===
Usuário: Ana Silva
Livro: Dom Casmurro
Exemplar: EX001
Situação: Em andamento
...
```

## 🛠 Tecnologias

- Java (sem dependências externas — usa apenas `java.util.ArrayList` da biblioteca padrão)

## 📄 Licença

Projeto acadêmico, livre para fins de estudo.
