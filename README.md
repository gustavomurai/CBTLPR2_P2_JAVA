# 📝 TP02 - Cadastro de Alunos em Java (Swing)

Este projeto foi desenvolvido como parte da disciplina de **Interfaces Gráficas em Java**.  
O objetivo é criar uma aplicação simples em **Java Swing** para cadastrar alunos, utilizando **UUID** e armazenando os dados em memória.

---

## 🚀 Funcionalidades

- 📌 **Classe `Aluno`**
  - Atributos: `uuid` (UUID), `nome` (String), `idade` (int), `endereco` (String).
  - Métodos **getters** e **setters**.
  - `toString()` para exibir informações do aluno.

- 📌 **Formulário Swing (`AlunoForm`)**
  - Campo para **Nome**.
  - Campo para **Idade**.
  - Campo para **Endereço**.
  - Botões:
    - **Ok** → cadastra um novo aluno (gera `UUID` automaticamente e armazena na lista).
    - **Limpar** → apaga os conteúdos dos campos de texto.
    - **Mostrar** → exibe todos os alunos cadastrados em um pop-up com `JOptionPane`.
    - **Sair** → encerra a aplicação.

- 📌 **Armazenamento em memória**
  - Lista de alunos (`ArrayList<Aluno>`).
  - Não há persistência em arquivos ou banco de dados.

---

## 🖼️ Layout da Aplicação

A interface segue as especificações do enunciado:  

- Painel superior com **GridLayout (3x2)** → Nome, Idade, Endereço.  
- Painel inferior com **GridLayout (1x4)** → Ok, Limpar, Mostrar, Sair.  
- Janela com tamanho **400 x 180**, centralizada na tela. 
