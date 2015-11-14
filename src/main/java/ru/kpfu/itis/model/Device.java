package ru.kpfu.itis.model;

import javax.persistence.*;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

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
    @Override
    public boolean equals(Object obj) {
        Device device = (Device) obj;
        if(device.getId() == this.getId()){
            return true;
        }else{
            return false;
        }
    }
}
