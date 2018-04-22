
import java.rmi.Naming;
import java.rmi.NotBoundException;
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
public class Publish {

    private Middle middle;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            Publish publisher = new Publish();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Publish() throws NotBoundException, Exception {
        this.middle = (Middle) Naming.lookup("//127.0.0.1:1099/i1");
        this.middle.publish("Topic", "Conteudo");
    }

    private boolean enviaEmail() {
        Scanner s = new Scanner(System.in);

        System.out.println("Destinatario:");
        String destinatario = s.nextLine().trim();

        System.out.println("Conteudo");
        String conteudo = s.nextLine().trim();

        if (destinatario.isEmpty() || conteudo.isEmpty()) {
            System.err.println("Destinatario ou conteudo vazio!");
            return false;
        }

        try {
            return middle.publish(destinatario, conteudo);
        } catch (RemoteException ex) {
            System.err.println("Email não pode ser enviado!");
            System.err.println(ex.getMessage());
        }
        return false;
    }

    private void enviaMultiplesEmails() {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("1- Mandar e-mail | 0- Sair");
            if (s.nextLine().trim().equals("0")) {
                break;
            }

            this.enviaEmail();

        }
    }

}
