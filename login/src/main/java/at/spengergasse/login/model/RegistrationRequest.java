package at.spengergasse.login.model;

/**
 * @author david on 08.12.2022
 * @version 1.0.0
 */
public record RegistrationRequest(String firstName, String lastName, String email, String password) {
}
