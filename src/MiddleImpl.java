
import java.io.Serializable;
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
 * @author fernando
 */
public class MiddleImpl extends java.rmi.server.UnicastRemoteObject implements Middle, Serializable, Subscriber {

    private Subscriber disparador;

    HashMap<String, List<Subscriber>> destinos;

    public MiddleImpl() throws RemoteException {
        super();
        this.destinos = new HashMap<>();
//        this.disparador = disparador;;
    }

    @Override
    public boolean publish(String topic, String conteudo) throws RemoteException {
        if (destinos.containsKey(topic)) {
            for (Subscriber s : destinos.get(topic)) {
                s.receberDados(topic, conteudo);
            }
        }
        return true;
    }

    @Override
    public void subscribe(String topic, Subscriber subscriber) throws RemoteException {
        if (!destinos.containsKey(topic)) {
            destinos.put(topic, new ArrayList<>());
        }
        destinos.get(topic).add(subscriber);
    }

    @Override
    public void receberDados(String topic, String dados) throws RemoteException {
        this.publish(topic, dados);
    }

}
