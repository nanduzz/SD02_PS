
import java.rmi.Naming;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author guest-vuu80z
 */
public class Intermediario {

    public Intermediario(String nome) {

        try {
//            Subscriber disparador = (Subscriber) Naming.lookup("//127.0.0.1:1099/ServidorEmail");
            MiddleImpl middleImpl = new MiddleImpl(nome);
            Naming.rebind("//127.0.0.1:1099/" + middleImpl.getConnectionName(), middleImpl);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o nome do intermediario");
        String nome = s.nextLine().trim();

        Intermediario i = new Intermediario(nome);
        System.out.println("Digite o endereco das conexoes, 0 para sair");
        String conexao;
        while (true) {
            conexao = s.nextLine();
            if (conexao.equals("0")) {
                break;
            } else if (conexao.startsWith("i")) {

            }
        }
    }

}
