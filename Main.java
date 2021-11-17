public class Main{
    public static void main(String[] args){
        try {
            Banco bancoBradesco = new Banco("Bradesco", "Osasco, São Paulo", "60.746.948.0001-12");

            Agencia bradescoSaoLourenco = new Agencia(bancoBradesco, 1868, "Av. Dom Pedro II, 298/304, São Lourenço - MG, 37470-000");

            Agencia bradescoSantaRitaSapucai = new Agencia(bancoBradesco, 1875, "R. Silvestre Ferraz, 295, Santa Rita do Sapucaí - MG, 37540-000");

            Cliente cliente1 = new Cliente("Carlos Alberto Teixeira", 21, "123.456.789-10", "Rua abc, 123, Sao Lourenco, 37470-000, Minas Gerais", "(35)991234567", bradescoSaoLourenco, 500, 500);

            Cliente cliente2 = new Cliente("Carol Ferreira Santos", 20, "987.654.321-00", "Rua cba, 321, Santa Rita do Sapucai, 37540-000, Minas Gerais", "(35)999876543", bradescoSantaRitaSapucai, 0, 200);



            System.out.println("Cliente 1: " + cliente1.verSaldo());
            cliente1.sacar(200);
            System.out.println("Cliente 1: " + cliente1.verSaldo());
            cliente1.transferir(cliente2, 400);
            System.out.println("Cliente 1: " + cliente1.verSaldo());

            System.out.println("Cliente 2: " + cliente2.verSaldo());
            cliente2.sacar(700);
            System.out.println("Cliente 2: " + cliente2.verSaldo());
            cliente2.depositar(100);
            System.out.println("Cliente 2: " + cliente2.verSaldo());
            cliente2.sacar(700);
            System.out.println("Cliente 2: " + cliente2.verSaldo());


        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}