
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
public class Subscribe {

    public Subscribe(String connectionName, Subscriber subscriber) {
        try {
            Naming.rebind("//127.0.0.1:1099/" + connectionName, subscriber);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws RemoteException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do assinante:");
        String nome = scanner.nextLine().trim();

        System.out.println("Digite os tópicos de interesse ou 0 para sair:");
        SubscriberImpl subscriber = new SubscriberImpl();
        while (true) {
            String topic = scanner.nextLine().trim();
            if (topic.equals("0")) {
                break;
            }
            subscriber.subscribe(topic);
        }
        Subscribe s = new Subscribe(nome, subscriber);

    }

}
