package ua.lutsenko.project.security;

public class LoginPasswordAuthenticationToken implements Authentication{

    private final String username;
    private final String password;

    public LoginPasswordAuthenticationToken(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Object getPrincipals() {
        return username;
    }

    @Override
    public Object getCredentials() {
        return password;
    }
}
