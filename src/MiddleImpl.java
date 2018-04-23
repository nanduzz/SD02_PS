
import java.rmi.Naming;
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
public class MiddleImpl extends java.rmi.server.UnicastRemoteObject implements Middle, Subscriber {

    HashMap<String, List<Subscriber>> destinos;
    private final String nome;
    private final List<String> listaIntermediarios;

    public MiddleImpl(String nome) throws RemoteException {
        super();
        this.destinos = new HashMap<>();
        this.nome = nome;
        this.listaIntermediarios = new ArrayList<>();
//        this.disparador = disparador;;
    }

    @Override
    public boolean publish(String topic, String conteudo) throws RemoteException {
        System.out.println("publish topic:" + topic);
        System.out.println("publish conteudo:" + conteudo);
        if (destinos.containsKey(topic)) {
            for (Subscriber s : destinos.get(topic)) {
                s.receberDados(topic, conteudo);
            }
        }
        return true;
    }

    @Override
    public void subscribe(String topic, String nome) throws RemoteException {
        try {
            if (!this.destinos.containsKey(topic)) {
                this.destinos.put(topic, new ArrayList<>());
            }
            Subscriber s = (Subscriber) Naming.lookup("//127.0.0.1:1099/" + nome);
            this.destinos.get(topic).add(s);

            for (String middleName : this.listaIntermediarios) {
                try {
                    Subscriber subs = (Subscriber) Naming.lookup("//127.0.0.1:1099/" + middleName);
                    subs.subscribe(topic, this.getConnectionName());
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void receberDados(String topic, String dados) throws RemoteException {
        System.out.println("Topic " + topic);
        System.out.println("dados " + dados);
        this.publish(topic, dados);
    }

    @Override
    public String getConnectionName() {
        return this.nome;
    }

    public void adicionaIntermediario(String nome) {
        this.listaIntermediarios.add(nome);
    }

}
