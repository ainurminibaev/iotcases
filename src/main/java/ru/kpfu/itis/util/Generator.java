package ru.kpfu.itis.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import ru.kpfu.itis.model.Action;

import java.io.File;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by vlad on 15.11.15.
 */
public class Generator {

    private List<JsonObjectETF> rootList;

    public Generator() {
        try {
            JsonElement root = new JsonParser().parse(new FileReader(new File(getPath() + "/data.json").getCanonicalPath()));
            rootList = new Gson().fromJson(root, new TypeToken<List<JsonObjectETF>>() {
            }.getType());
        } catch (Exception e) {
        }
    }

    private String getPath() throws UnsupportedEncodingException {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        String fullPath = URLDecoder.decode(path, "UTF-8");

        return fullPath;
    }

    private int random() {
        return (int) (Math.random() * rootList.size());
    }

    private int random(int max) {
        return (int) (Math.random() * max);
    }

    public String randomName() {
        return rootList.get(random()).getFirstName();
    }

    public String randomLastname() {
        return rootList.get(random()).getLastName();
    }

    public String randomDevice() {
        String name = null;
        switch (random(8)) {
            case 0:
                name = "Room door";
                break;
            case 1:
                name = "Locker";
                break;
            case 2:
                name = "Bedside table";
                break;
            case 3:
                name = "Kitchen drawer";
                break;
            case 4:
                name = "Bedroom drawer";
                break;
            case 5:
                name = "Draw";
                break;
            case 6:
                name = "Safe";
                break;
            case 7:
                name = "Enter door";
                break;
            default:
                name = "Safe";
        }
        return name;
    }

    public boolean randomAccess() {
        if (Math.random() > 0.3) {
            return true;
        }
        return false;
    }

    public Date dateBefore() {
        return new Date((long) (new Date().getTime() * (1 - Math.random() * 0.05)));
    }

    public Action randomAction() {
        return new Action(dateBefore(), randomName(), randomDevice(), randomAccess());
    }

    public List<Action> randomActions(int n) {
        List<Action> actions = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            actions.add(randomAction());
        }
        return actions;
    }

}
