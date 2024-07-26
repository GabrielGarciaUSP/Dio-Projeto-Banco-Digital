import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> contas;
    private List<Cliente> clientes;

    public Banco() {
        this.contas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    public Conta buscarContaPorNumero(String numero) {
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numero)) {
                return conta;
            }
        }
        return null;
    }
}
