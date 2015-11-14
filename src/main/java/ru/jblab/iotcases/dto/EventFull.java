package ru.jblab.iotcases.dto;

/**
 * Created by ainurminibaev on 09.11.15.
 */
public class EventFull extends EventSimple {
    private String organizerFIO;

    private String organizerEmail;

    private String organizerPhone;
    private String link;

    public String getOrganizerFIO() {
        return organizerFIO;
    }

    public void setOrganizerFIO(String organizerFIO) {
        this.organizerFIO = organizerFIO;
    }

    public String getOrganizerEmail() {
        return organizerEmail;
    }

    public void setOrganizerEmail(String organizerEmail) {
        this.organizerEmail = organizerEmail;
    }

    public String getOrganizerPhone() {
        return organizerPhone;
    }

    public void setOrganizerPhone(String organizerPhone) {
        this.organizerPhone = organizerPhone;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }
}
