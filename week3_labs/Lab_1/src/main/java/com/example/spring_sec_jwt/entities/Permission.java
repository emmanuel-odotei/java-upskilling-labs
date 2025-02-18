package week3_labs.Lab_1.src.main.java.com.example.spring_sec_jwt.model;

public enum Permission {
    ADMIN_GET("admin_get"),
    ADMIN_UPDATE("admin_update"),
    ADMIN_DELETE("admin_delete"),
    ADMIN_CREATE("admin_create"),
    MANAGER_GET("manager_get"),
    MANAGER_UPDATE("manager_update"),
    MANAGER_DELETE("manager_delete"),
    MANAGER_CREATE("manager_create");
    Permission(String name) {
    }
}
