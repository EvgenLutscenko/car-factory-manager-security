package ua.lutsenko.project.exception.factory;

public class FactoryNotFoundException extends RuntimeException{
    public FactoryNotFoundException(String message) {
        super(message);
    }
}
