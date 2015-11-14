package ru.kpfu.itis.model.helper;

import ru.kpfu.itis.model.User;

import java.util.List;

/**
 * Created by vlad on 14.11.15.
 */
public class DeviceJson {

    private Long id;

    private String name;

    private List<Long> users;

    public DeviceJson() {
    }

    public DeviceJson(Long id, String name, List<Long> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getUsers() {
        return users;
    }

    public void setUsers(List<Long> users) {
        this.users = users;
    }
}