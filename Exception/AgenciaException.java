package Exception;

public class AgenciaException extends Exception {
    public AgenciaException(int codigoAgencia, String endereco, String cidade, String estado, String pais){
        if(codigoAgencia <= 0){
            codigoAgenciaErro();
        }

        if(endereco == null){
            enderecoErro();
        }

        if(cidade == null){
            cidadeErro();
        }

        if(estado == null){
            estadoErro();
        }

        if(pais == null){
            paisErro();
        }
    }

    private void codigoAgenciaErro(){
        System.out.println("Erro: Codigo da Agencia invalido!");
    }

    private void enderecoErro() {
        System.out.println("Erro: Endereco da Agencia invalido!");
    }

    private void cidadeErro() {
        System.out.println("Erro: Cidade da Agencia invalido!");
    }

    private void estadoErro() {
        System.out.println("Erro: Estado da Agencia invalido!");
    }

    private void paisErro() {
        System.out.println("Erro: Pais da Agencia invalido!");
    }
    
}
