package Exception;

public class AgenciaException extends Exception {
    public AgenciaException(int codigoAgencia, String endereco){
        if(codigoAgencia <= 0) throw new IllegalArgumentException("Erro: Codigo da Agencia invalido!");
        if(endereco.length() == 0) throw new IllegalArgumentException("Erro: Endereco da Agencia invalido!");
    }
}
