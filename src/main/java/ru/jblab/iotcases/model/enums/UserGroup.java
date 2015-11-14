package ru.jblab.iotcases.model.enums;

/**
 * Created by ainurminibaev on 26.08.14.
 */
public enum UserGroup {
    ADMIN("Администратор"), USER("Обычный пользователь");
    String title;

    UserGroup(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
