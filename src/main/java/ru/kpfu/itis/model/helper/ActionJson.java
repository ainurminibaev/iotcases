package ru.kpfu.itis.model.helper;

/**
 * Created by vlad on 15.11.15.
 */
public class ActionJson {

    private String d_name;

    private String u_name;

    private boolean access;

    public ActionJson() {
    }

    public ActionJson(String d_name, String u_name, boolean access) {
        this.d_name = d_name;
        this.u_name = u_name;
        this.access = access;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }
}
