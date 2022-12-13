package at.spengergasse.login.email;

/**
 * @author david on 08.12.2022
 * @version 1.0.0
 */
public interface EmailSender {
    void send(String to, String email);
}
