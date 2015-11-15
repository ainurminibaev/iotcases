package ru.kpfu.itis.util.logger;

import java.util.ArrayList;

/**
 * Created by vlad on 15.11.15.
 */
public class Logger {

    private static ArrayList<Action> actions;

    static {
        actions = new ArrayList<>();
    }

    public static Action get(int n) {
        return actions.get(n);
    }

    public static void add(Action action) {
        actions.add(action);
    }

    public static void show() {
        for (Action a : actions) {
            System.out.println(a.getDate() + ", "
                    + a.getUser().getName() + ", "
                    + a.getDevice().getName()+ ", "
                    + a.isAccess());
        }
    }

    public static ArrayList<Action> actions() {
        return actions;
    }

    public static int size() {
        return actions.size();
    }
}
