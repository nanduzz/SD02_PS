
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author guest-vuu80z
 */
public class Email implements Serializable {

    private String email;
    private String conteudo;
    private String servidorSMTP;
    private int portaSMTP;

    public Email(String email, String conteudo, String servidorSMTP, int portaSMTP) {
        this.email = email;
        this.conteudo = conteudo;
        this.servidorSMTP = servidorSMTP;
        this.portaSMTP = portaSMTP;
    }

    @Override
    public String toString() {
        return "Email{" + "email=" + email + ", conteudo=" + conteudo + ", servidorSMTP=" + servidorSMTP + ", portaSMTP=" + portaSMTP + '}';
    }

    public String getEmail() {
        return email;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void leEmail() {
        System.out.println("Emial:" + this.getConteudo());
    }

}
