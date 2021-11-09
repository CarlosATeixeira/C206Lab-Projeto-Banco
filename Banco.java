import Exception.BancoException;

public class Banco {
    private String nome = null;
    private String enderecoSede = null;
    private String cidadeSede = null;
    private String estadoSede = null;
    private String paisSede = null;
    private Agencia agencia = null;

    public Banco(String nome, String enderecoSede, String cidadeSede, Agencia agencia) throws Exception {
        Boolean erros = nome == null || enderecoSede == null || cidadeSede == null 
            || estadoSede == null || paisSede == null || agencia == null;
        if (erros) {
            Exception e = new BancoException(nome, enderecoSede, cidadeSede, estadoSede, paisSede);
            throw e;
        }
    }
}
