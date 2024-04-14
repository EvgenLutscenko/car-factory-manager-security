package ua.lutsenko.project.security;

public interface Authentication {
    Object getPrincipals();

    Object getCredentials();
}
