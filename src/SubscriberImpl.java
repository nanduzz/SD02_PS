
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
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
public class SubscriberImpl extends java.rmi.server.UnicastRemoteObject implements Subscriber {

    private List<String> topics;

    private final String nome;

    public SubscriberImpl(String nome) throws RemoteException {
        super();
        this.topics = new ArrayList<>();
        this.nome = nome;
    }

    public void subscribe(String topic) {
        this.topics.add(topic);
    }

    @Override
    public void receberDados(String topic, String dados) throws RemoteException {
        System.out.println("---------------------------");
        System.out.println("Recebendo Tópico:" + topic);
        System.out.println("Conteudo:" + dados);
        System.out.println("---------------------------");
    }

    @Override
    public String getConnectionName() {
        return this.nome;
    }

    @Override
    public void subscribe(String topic, String nome) throws RemoteException {
        try {
            Subscriber s = (Subscriber) Naming.lookup("//127.0.0.1:1099/" + nome);
            s.subscribe(topic, this.getConnectionName());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
