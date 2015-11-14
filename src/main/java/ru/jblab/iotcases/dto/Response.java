package ru.jblab.iotcases.dto;

/**
 * Created by ainurminibaev on 27.10.15.
 */
public class Response {

    private String msg;

    public Response(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
