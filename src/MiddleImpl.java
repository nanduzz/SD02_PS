
import java.io.Serializable;
import java.rmi.RemoteException;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fernando
 */
public class MiddleImpl extends java.rmi.server.UnicastRemoteObject implements Middle, Serializable {

    private final Subscriber disparador;

    public MiddleImpl(Subscriber disparador) throws RemoteException {
        super();
        this.disparador = disparador;
    }

    @Override
    public boolean publish(String destino, String conteudo) throws RemoteException {
        Email email = new Email(destino, conteudo, "smtp.fernando.com", 587);
        
        
        return true;
    }

    @Override
    public Email subscribe(String login) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void connect(String endereco) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    
    
    
    
}
