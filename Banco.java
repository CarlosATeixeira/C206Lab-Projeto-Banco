import Exception.BancoException;

public class Banco {
    private String nome = null;
    private String enderecoSede = null;
    private String cnpj = null;

    public Banco(String nome, String enderecoSede, String cnpj) throws Exception {
        Boolean erros = nome.length() == 0 || enderecoSede.length() == 0 || cnpj.length() == 0;
        if (erros) {
            Exception e = new BancoException(nome, enderecoSede, cnpj);
            throw e;
        }
        this.nome = nome;
        this.enderecoSede = enderecoSede;
        this.cnpj = cnpj;
    }
}
