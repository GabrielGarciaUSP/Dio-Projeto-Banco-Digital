public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Cliente cliente1 = new Cliente("João Silva", "12345678900");
        Cliente cliente2 = new Cliente("Maria Oliveira", "09876543211");

        ContaCorrente conta1 = new ContaCorrente("001", cliente1);
        ContaPoupanca conta2 = new ContaPoupanca("002", cliente2);

        banco.adicionarCliente(cliente1);
        banco.adicionarCliente(cliente2);

        banco.adicionarConta(conta1);
        banco.adicionarConta(conta2);

        conta1.depositar(1000);
        conta2.depositar(500);

        conta1.sacar(200);
        conta1.transferir(300, conta2);

        System.out.println("Saldo conta 1: " + conta1.getSaldo());
        System.out.println("Saldo conta 2: " + conta2.getSaldo());
    }
}
