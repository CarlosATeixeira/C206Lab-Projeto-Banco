import Exception.ClienteException;

public class Cliente extends Pessoa{
    private Agencia agencia = null;
    private Pessoa informacoesPessoais = null;
    private float saldo = 0.0f;
    private float limiteEspecial = 0.0f;

    public Cliente(String nome, int idade, String cpf, String endereco, String telefone, Agencia agencia, float saldoInicial, float limiteEspecial) throws Exception {
        Boolean erros = nome.length() == 0 || idade < 16 || cpf.length() == 0 || endereco.length() == 0 || telefone.length() == 0 || saldoInicial < 0 || limiteEspecial < 0;
        if(erros) {
            Exception e = new ClienteException(nome, idade, cpf, endereco, telefone, saldoInicial, limiteEspecial);
            throw e;
        }

        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.agencia = agencia;
        this.saldo = saldoInicial;
        this.limiteEspecial = limiteEspecial;
    }

    public float verSaldo(){
        return saldo;
    }

    public void sacar(float quantidade){
        try {
            if(quantidade <= saldo + limiteEspecial){
                saldo -= quantidade;
            }
            else throw new IllegalArgumentException("Saldo insuficiente!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void depositar(float quantidade){
        saldo += quantidade;
    }

    public void transferir(Cliente c, float quantidade){
        try {
            if(quantidade <= saldo + limiteEspecial){
                saldo -= quantidade;
                c.depositar(quantidade);
            }
            else throw new IllegalArgumentException("Saldo insuficiente!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}