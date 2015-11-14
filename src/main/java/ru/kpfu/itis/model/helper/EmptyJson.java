package ru.kpfu.itis.model.helper;

/**
 * Created by vlad on 14.11.15.
 */
public class EmptyJson {

    private boolean need;

    public EmptyJson(boolean need) {
        this.need = need;
    }

    public boolean isNeed() {
        return need;
    }

    public void setNeed(boolean need) {
        this.need = need;
    }

}
