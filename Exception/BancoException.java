package Exception;

public class BancoException extends Exception {
    public BancoException(String nome, String enderecoSede, String cnpj) {
        if(nome.length() == 0) throw new IllegalArgumentException("Nome do Banco invalido!");
        if(enderecoSede.length() == 0) throw new IllegalArgumentException("Endereço sede do Banco invalido!");
        if(cnpj.length() == 0) throw new IllegalArgumentException("CNPJ do Banco invalido!");
    }
}