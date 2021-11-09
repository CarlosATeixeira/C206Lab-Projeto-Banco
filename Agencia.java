import Exception.AgenciaException;

public class Agencia {
    private int codigoAgencia = 0;
    private String endereco = null;
    private String cidade = null;
    private String estado = null;
    private String pais = null;

    public Agencia(int codigoAgencia, String endereco, String cidade, String estado, String pais) throws Exception {
        Boolean erros = codigoAgencia <= 0 || endereco == null || cidade == null || estado == null || pais == null;
        if(erros) {
            Exception e = new AgenciaException(codigoAgencia, endereco, cidade, estado, pais);
            throw e;
        }
        else{
            this.codigoAgencia = codigoAgencia;
            this.endereco = endereco;
            this.cidade = cidade;
            this.estado = estado;
            this.pais = pais;
        }
    }
}
