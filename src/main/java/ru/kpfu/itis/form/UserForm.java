package ru.kpfu.itis.form;

import ru.kpfu.itis.model.enums.Role;

public class UserForm {

    private Long id;

    private String name;

    private Integer role;

    private String password;

    private Long[] device;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long[] getDevice() {
        return device;
    }

    public void setDevice(Long[] device) {
        this.device = device;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
