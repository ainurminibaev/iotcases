package ru.kpfu.itis.model.helper;

/**
 * Created by vlad on 14.11.15.
 */
public class ChangingUser {

    private String pin;

    private String name;

    private String password;

    public ChangingUser() {
    }

    public ChangingUser(String pin, String name, String password) {
        this.pin = pin;
        this.name = name;
        this.password = password;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
