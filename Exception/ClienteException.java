package Exception;

public class ClienteException extends Exception {
    public ClienteException(String nome, int idade, String cpf, String endereco, String telefone, float saldoInicial, float limiteEspecial){
        if(nome.length() == 0) throw new IllegalArgumentException("Nome do Cliente invalido!");
        if(idade < 16) throw new IllegalArgumentException("Idade do Cliente invalida!");
        if(cpf.length() == 0) throw new IllegalArgumentException("CPF do Cliente invalido!");
        if(endereco.length() == 0) throw new IllegalArgumentException("Endereco do Cliente invalido!");
        if(telefone.length() == 0) throw new IllegalArgumentException("Telefone do Cliente invalido!");
        if(saldoInicial < 0) throw new IllegalArgumentException("Saldo Inicial do Cliente invalido!");
        if(limiteEspecial < 0) throw new IllegalArgumentException("Limite Especial do Cliente invalido!");
    }
}