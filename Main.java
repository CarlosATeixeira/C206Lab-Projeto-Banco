import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        try {
            Arquivo arq = new Arquivo();
            ArrayList<Cliente> contas = new ArrayList<>();

            contas = arq.lerContas();

            new Controller(contas);

            arq.salvar(contas);

        } catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return;
        }
    }
}