package ua.lutsenko.project.security;


public class SecurityContextHolder {
    private static final ThreadLocal<SecurityContext> context = ThreadLocal.withInitial(SecurityContext::new);

    public static SecurityContext getSecurityContext(){
        return context.get();
    }

}
