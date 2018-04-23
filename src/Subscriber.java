/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guest-vuu80z
 */
public interface Subscriber extends java.rmi.Remote {
    
    public void receberDados(String topic, String dados) throws java.rmi.RemoteException;
    
    public void subscribe(String topic, String nome) throws java.rmi.RemoteException;
    
    public String getConnectionName() throws java.rmi.RemoteException;
    
}
