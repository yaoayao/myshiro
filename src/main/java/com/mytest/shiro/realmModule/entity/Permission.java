package com.mytest.shiro.realmModule.entity;

import java.io.Serializable;

/**
 * Created by miyan(弥彦) on 2017/3/1 18:54.
 */
public class Permission implements Serializable {
    private Long id;
    private String permission;
    private String description;
    private Boolean available = Boolean.FALSE;

    public Permission( String permission, String description, Boolean available) {
        this.permission = permission;
        this.description = description;
        this.available = available;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permission='" + permission + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permission that = (Permission) o;

        if (available != null ? !available.equals(that.available) : that.available != null) return false;
        if (!description.equals(that.description)) return false;
        if (!id.equals(that.id)) return false;
        if (!permission.equals(that.permission)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + permission.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + (available != null ? available.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
