# Projeto Banco em Java

## Autor: Gabriel Garcia Ferreira

Este projeto simula um sistema bancário simples em Java, utilizando os conceitos de Orientação a Objetos (OO). O banco oferece aos seus clientes dois tipos de contas (corrente e poupança), as quais possuem as funcionalidades de depósito, saque e transferência entre contas da própria instituição.

## Estrutura do Projeto

- `Conta.java`: Classe abstrata que define os métodos comuns para contas bancárias.
- `ContaCorrente.java`: Classe que representa uma conta corrente, herda de `Conta`.
- `ContaPoupanca.java`: Classe que representa uma conta poupança, herda de `Conta`.
- `Cliente.java`: Classe que representa um cliente do banco.
- `Banco.java`: Classe que gerencia as contas e clientes do banco.
- `Main.java`: Classe principal para executar e testar a aplicação.

## Exemplos dos 4 Pilares da Orientação a Objetos

### 1. Abstração

A classe `Conta` é uma abstração de uma conta bancária, contendo os atributos e métodos comuns a todas as contas.

```java
public abstract class Conta {
    private String numero;
    private double saldo;
    private Cliente cliente;

    public Conta(String numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente ou valor de saque inválido.");
        }
    }

    public void transferir(double valor, Conta contaDestino) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            contaDestino.depositar(valor);
        } else {
            System.out.println("Saldo insuficiente ou valor de transferência inválido.");
        }
    }
}
```

### 2. Encapsulamento

Os atributos da classe Cliente são privados e acessados através de métodos públicos (getters e setters).

```java

    public class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
```

### 3. Herança

As classes ContaCorrente e ContaPoupanca herdam da classe abstrata Conta.
```java
public class ContaCorrente extends Conta {
    public ContaCorrente(String numero, Cliente cliente) {
        super(numero, cliente);
    }
}

public class ContaPoupanca extends Conta {
    public ContaPoupanca(String numero, Cliente cliente) {
        super(numero, cliente);
    }
}
```

### 4. Polimorfismo

O método transferir da classe Conta demonstra o polimorfismo, pois pode transferir valores entre diferentes tipos de contas (corrente e poupança).

```java
public void transferir(double valor, Conta contaDestino) {
    if (valor > 0 && this.saldo >= valor) {
        this.saldo -= valor;
        contaDestino.depositar(valor);
    } else {
        System.out.println("Saldo insuficiente ou valor de transferência inválido.");
    }
}
```

### Considerações Finais

Este projeto fornece uma base sólida para um sistema bancário orientado a objetos em Java. Futuramente pretendo mudar algumas funcionalidades e adicionar novas idéias. Sinta-se à vontade para estender o projeto, adicionando novas funcionalidades ou classes conforme necessário.