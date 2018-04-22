
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author guest-vuu80z
 */
public class ServidorEmailImpl extends java.rmi.server.UnicastRemoteObject implements Subscriber {

    private List<String> topics;

    public ServidorEmailImpl() throws RemoteException {
        super();
        this.topics = new ArrayList<>();
    }

    private void subscribe(String topic) {
        this.topics.add(topic);
    }

    @Override
    public void recebeDados(String topic, String dados) throws RemoteException {
        if (this.topics.contains(topic)) {
            System.out.println("---------------------------");
            System.out.println("Recebendo Tópico:" + topic);
            System.out.println("Conteudo:" + dados);
            System.out.println("---------------------------");
        }
    }
}
