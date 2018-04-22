/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public interface Middle extends java.rmi.Remote {

    public boolean publish(String topic, String conteudo) throws java.rmi.RemoteException;

    public Email subscribe(String login) throws java.rmi.RemoteException;

    public void connect(String endereco) throws java.rmi.RemoteException;

}
