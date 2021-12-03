import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Arquivo {
    public void salvar(ArrayList<Cliente> contas){
        OutputStream op;
        OutputStreamWriter osw;
        BufferedWriter bw = null;

        try{
            op = new FileOutputStream("contas.txt", false);
            osw = new OutputStreamWriter(op);
            bw = new BufferedWriter(osw);

            bw.write(Cliente.getNumeroConta() + "\n");

            for(Cliente conta : contas){
                bw.write("-----Conta-----\n");
                bw.write(conta.getConta() + "\n");
                bw.write(conta.getSaldo() + "\n");
                bw.write(conta.getLimiteEspecial() + "\n");
                bw.write(conta.getNome() + "\n");
                bw.write(conta.getIdade() + "\n");
                bw.write(conta.getCpf() + "\n");
                bw.write(conta.getEndereco() + "\n");
                bw.write(conta.getTelefone() + "\n");
            }
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        finally{
            try{
                bw.close();
            }
            catch (IOException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    public ArrayList<Cliente> lerContas(){
        InputStream is;
        InputStreamReader isr;
        BufferedReader br = null;

        ArrayList<Cliente> contas = new ArrayList<>();

        try{
            is = new FileInputStream("contas.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            String linha = br.readLine();

            if(linha != null){
                Cliente.setNumeroConta(Integer.parseInt(linha));
                linha = br.readLine();
            }

            while(linha != null){
                if(linha.contains("-Conta-")){
                    int conta = Integer.parseInt(br.readLine());
                    float saldo = Float.parseFloat(br.readLine());
                    float limiteEspecial = Float.parseFloat(br.readLine());
                    String nome = br.readLine();
                    int idade = Integer.parseInt(br.readLine());
                    String cpf = br.readLine();
                    String endereco = br.readLine();
                    String telefone = br.readLine();

                    Cliente cliente = new Cliente(conta, nome, idade, cpf, endereco, telefone, saldo, limiteEspecial);

                    contas.add(cliente);
                }

                linha = br.readLine();
            }

            return contas;
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        finally{
            try{
                br.close();
            }
            catch (IOException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

        return contas;
    }
}
