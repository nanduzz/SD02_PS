
import java.rmi.Naming;
import java.rmi.RemoteException;
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

    public Intermediario(MiddleImpl middleImpl) {

        try {
//            Subscriber disparador = (Subscriber) Naming.lookup("//127.0.0.1:1099/ServidorEmail");
            Naming.rebind("//127.0.0.1:1099/" + middleImpl.getConnectionName(), middleImpl);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws RemoteException {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o nome do intermediario");
        String nome = s.nextLine().trim();

        MiddleImpl middleImpl = new MiddleImpl(nome);
        Intermediario i = new Intermediario(middleImpl);
        System.out.println("Digite o endereco das conexoes, 0 para sair");
        String conexao;
        while (true) {
            conexao = s.nextLine();
            if (conexao.equals("0")) {
                break;
            }
            middleImpl.adicionaIntermediario(conexao);
        }
    }

}
