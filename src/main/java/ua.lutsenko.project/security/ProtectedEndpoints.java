package ua.lutsenko.project.security;

import java.util.List;

public class ProtectedEndpoints {

    private final static List<String> endpoints = List.of(
            "/auth/login", "auth/register"
    );

    public static List<String> getEndpoints(){ return endpoints;}
}
