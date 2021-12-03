import Exception.ClienteException;

public class Cliente extends Pessoa{
    private static int numeroConta = 0;
    private int conta = 0;
    protected Pessoa informacoesPessoais = null;
    private float saldo = 0.0f;
    private float limiteEspecial = 0.0f;

    public Cliente() {}

    public Cliente(String nome, int idade, String cpf, String endereco, String telefone, float saldoInicial, float limiteEspecial) throws Exception {
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
        this.saldo = saldoInicial;
        this.limiteEspecial = limiteEspecial;

        numeroConta++;
        conta = numeroConta;
    }

    public Cliente(int conta, String nome, int idade, String cpf, String endereco, String telefone, float saldoInicial, float limiteEspecial) throws Exception {
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
        this.saldo = saldoInicial;
        this.limiteEspecial = limiteEspecial;

        this.conta = conta;
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

    public int getConta() {
        return conta;
    }

    public float getSaldo() {
        return saldo;
    }

    public float getLimiteEspecial() {
        return limiteEspecial;
    }

    public static int getNumeroConta() {
        return numeroConta;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public static void setNumeroConta(int numeroConta) {
        Cliente.numeroConta = numeroConta;
    }

    public void toText() {
        System.out.println("Cliente [conta = " + conta + "\nnome = " + nome + "\nidade = " + idade + "\ncpf = " + cpf + "\nendereco = " + endereco + "\ntelefone = " + telefone + "\nlimiteEspecial = " + limiteEspecial + "\nsaldo = " + saldo + "]");
    }
}