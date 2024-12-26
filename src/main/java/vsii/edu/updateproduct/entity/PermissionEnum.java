package vsii.edu.updateproduct.entity;

public enum PermissionEnum {
    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    MANAGER_READ("manager:read"),
    MANAGER_UPDATE(",manager:update");


    private final String permissionName;

    PermissionEnum(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionName() {
        return permissionName;
    }

}
