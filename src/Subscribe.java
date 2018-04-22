
import java.rmi.Naming;

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

    public Subscribe() {
        try {
            Subscriber disparador = new ServidorEmailImpl();
            Naming.rebind("//127.0.0.1:1099/ServidorEmail", disparador);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Subscribe s = new Subscribe();
    }

}
