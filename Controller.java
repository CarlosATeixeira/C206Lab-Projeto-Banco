import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    Scanner sc = new Scanner(System.in);
    ArrayList<Cliente> clientes = new ArrayList<>();

    public Controller(ArrayList<Cliente> contas) throws Exception{
        this.clientes = contas;
        start();
    }

    private void start() throws Exception {
        while(true) {
            System.out.println("1 - Acesso Cliente");
            System.out.println("2 - Acesso Administrador");
            System.out.println("0 - Sair");
    
            int op = sc.nextInt();
            sc.nextLine();
    
            switch(op){
                case 1:
                    acessoCliente();
                    break;
                case 2:
                    acessoAdministrador();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("OPCAO INVALIDA!");
                    start();
            }
        }
    }

    private void acessoCliente() throws Exception {
        while(true){
            System.out.print("Insira o numero de sua conta: ");

            int conta = sc.nextInt();
            sc.nextLine();

            if(!existe(conta)){
                System.out.println("Conta não encontrada!");
                return;
            }

            System.out.println("1 - Ver Saldo");
            System.out.println("2 - Sacar");
            System.out.println("3 - Depositar");
            System.out.println("4 - Transferir");
            System.out.println("0 - Voltar");

            int op = sc.nextInt();
            sc.nextLine();

            switch(op){
                case 1:
                    verSaldo(conta);
                    break;
                case 2:
                    sacar(conta);
                    break;
                case 3:
                    depositar(conta);
                    break;
                case 4:
                    transferir(conta);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("OPCAO INVALIDA!");
                    acessoCliente();
            }
        }
    }

    private void verSaldo(int conta){
        for(Cliente cliente : clientes){
            if(cliente.getConta() == conta){
                System.out.println("Saldo: " + cliente.getSaldo());
            }
        }
    }

    private void sacar(int conta) {
        System.out.print("Valor a sacar: ");
        float valor = sc.nextFloat();
        sc.nextLine();

        for(Cliente cliente : clientes){
            if(cliente.getConta() == conta){
                cliente.sacar(valor);
            }
        }
    }   
    
    private void depositar(int conta) {
        System.out.print("Valor a depositar: ");
        float valor = sc.nextFloat();
        sc.nextLine();

        for(Cliente cliente : clientes){
            if(cliente.getConta() == conta){
                cliente.depositar(valor);
            }
        }
    }

    private void transferir(int conta) throws Exception {
        System.out.print("Valor a transferir: ");
        float valor = sc.nextFloat();
        sc.nextLine();

        System.out.print("Conta do destinatario: ");
        int conta2 = sc.nextInt();
        sc.nextLine();

        if(!existe(conta)){
            System.out.println("Conta não encontrada!");
            return;
        }

        for(Cliente cliente1 : clientes){
            if(cliente1.getConta() == conta){
                for(Cliente cliente2 : clientes){
                    if(cliente2.getConta() == conta2){
                        cliente1.transferir(cliente2, valor);
                    }
                }
            }
        }
    }

    private void acessoAdministrador() throws Exception {
        while(true){
            System.out.println("1 - Listar Todas Contas");
            System.out.println("2 - Abrir Conta");
            System.out.println("3 - Excluir Conta");
            System.out.println("0 - Voltar");

            int op = sc.nextInt();
            sc.nextLine();

            switch(op){
                case 1:
                    listarContas();
                    break;
                case 2:
                    abrirConta();
                    break;
                case 3:
                    excluirConta();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("OPCAO INVALIDA!");
                    acessoAdministrador();
            }
        } 
    }

    private void listarContas() {
        if(clientes.size() != 0){
            for(Cliente cliente : clientes){
                System.out.println("");
                cliente.toText();
                System.out.println("");
            }
        }
    }

    private void abrirConta() throws Exception {
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Idade: ");
        int idade = sc.nextInt();
        sc.nextLine();

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        System.out.print("Endereço: ");
        String endereco = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("Saldo: ");
        float saldo = sc.nextFloat();
        sc.nextLine();

        System.out.print("Limite Especial: ");
        float limiteEspecial = sc.nextFloat();
        sc.nextLine();


        Cliente cliente = new Cliente(nome, idade, cpf, endereco, telefone, saldo, limiteEspecial);

        clientes.add(cliente);
    }

    private void excluirConta() throws Exception {
        System.out.print("Conta a ser excluida: ");
        int conta = sc.nextInt();
        sc.nextLine();

        if(!existe(conta)){
            System.out.println("Conta não encontrada!");
            return;
        }
        
        Cliente deletar = new Cliente();

        for(Cliente cliente : clientes){
            if(cliente.getConta() == conta){
                System.out.println("conta deletada");
                deletar = cliente;
            }
        }

        clientes.remove(deletar);
    }

    Boolean existe(int conta){
        Boolean achou = false;

        for(Cliente cliente : clientes){
            if(cliente.getConta() == conta){
                achou = true;
            }
        }

        return achou;
    }
}
