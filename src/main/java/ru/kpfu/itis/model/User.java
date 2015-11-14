package ru.kpfu.itis.model;


import ru.kpfu.itis.model.enums.Role;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Enumerated(EnumType.ORDINAL)
    private Role role;

    private String password;

    public Long getId() {
        switch (("" + id).length()) {
            case 1: return Long.parseLong("00" + id);
            case 2: return Long.parseLong("0" + id);
            case 3: return id;
            default: return null;
        }
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
