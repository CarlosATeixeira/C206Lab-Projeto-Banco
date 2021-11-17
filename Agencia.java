import Exception.AgenciaException;

public class Agencia {
    private Banco banco = null;
    private int codigoAgencia = 0;
    private String endereco = null;

    public Agencia(Banco banco, int codigoAgencia, String endereco) throws Exception {
        Boolean erros = codigoAgencia <= 0 || endereco.length() == 0;
        if(erros) {
            Exception e = new AgenciaException(codigoAgencia, endereco);
            throw e;
        }
        else{
            this.banco = banco;
            this.codigoAgencia = codigoAgencia;
            this.endereco = endereco;
        }
    }
}
