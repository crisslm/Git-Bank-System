🏦 Git Bank System

Um sistema bancário simples desenvolvido em Java, com foco em conceitos fundamentais de Programação Orientada a Objetos (POO), controle de fluxo, listas dinâmicas e interação via terminal.

O projeto simula operações básicas de um banco, como criação de conta, login, consulta de saldo, saque, transferência e cancelamento de conta.

📌 Funcionalidades

✅ Criar nova conta bancária

🔐 Login por nome de usuário

💰 Visualizar saldo

💸 Realizar saques

🔄 Transferir valores entre contas

❌ Cancelar conta

🔎 Buscar usuários pelo nome de login

⚠️ Validações básicas (saldo insuficiente, usuário inexistente, usuário duplicado)

🛠️ Tecnologias Utilizadas

Java (JDK 8+)

Scanner para entrada de dados

ArrayList como base de dados em memória

Paradigma de Programação Orientada a Objetos

📂 Estrutura do Projeto
src/
 ├── BankSystem.java        # Classe principal (main)
 ├── CurrentAccount.java   # Representa a conta bancária
 ├── Login.java            # Responsável por login e senha


⚠️ Observação: o projeto utiliza uma “base de dados” em memória (ArrayList), portanto os dados são perdidos ao encerrar o programa.

▶️ Como Executar o Projeto

Clone o repositório:

git clone https://github.com/seu-usuario/git-bank-system.git


Compile os arquivos:

javac *.java


Execute o programa:

java BankSystem

🧭 Fluxo de Uso
Tela Inicial

Ao iniciar o programa, o usuário verá:

WELCOME TO GIT BANK!
---------------------

Choose an option bellow:
1) Login
2) Create a new account

Criar Conta

Usuário escolhe um nome de login único

Define uma senha

Informa nome completo e data de nascimento

Recebe um número de conta gerado aleatoriamente

Saldo inicial definido automaticamente

Login

O sistema busca o usuário pelo username

Caso não exista, retorna uma mensagem de erro

Caso exista, exibe mensagem de boas-vindas

🧠 Principais Métodos Explicados
withdraw(CurrentAccount user, double value)

Realiza um saque, verificando se o saldo é suficiente antes da operação.

transfer(CurrentAccount user1, CurrentAccount user2, double value)

Transfere valores entre duas contas, validando saldo do remetente.

findByUserName(ArrayList<CurrentAccount> list, String userName)

Busca e retorna uma conta a partir do nome de usuário.

sameUserCheck(ArrayList<CurrentAccount> list, String userName)

Evita criação de usuários duplicados.

createAccountNumber()

Gera um número de conta aleatório dentro de um intervalo definido.

🚧 Limitações Atuais

Não há persistência de dados (arquivo ou banco de dados)

Senhas não são criptografadas

Não existe menu pós-login com múltiplas operações

Data de nascimento não é validada nem convertida para formato Date

🚀 Melhorias Futuras

📦 Persistência de dados (arquivo ou banco de dados)

🔐 Criptografia de senha

📋 Menu completo após login

🧪 Testes unitários

🧾 Histórico de transações

🖥️ Interface gráfica (JavaFX ou Swing)

👨‍💻 Autor

Desenvolvido por [Seu Nome]
Projeto com fins educacionais para prática de Java e POO.