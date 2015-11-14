package ru.kpfu.itis.util;

import ru.kpfu.itis.model.SecList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladislav on 14.11.15.
 */
public class SecListUtil {

    public static List<SecList> transformToList(Long userId, Long[] arr) {
        List<SecList> secLists = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            SecList secList = new SecList();
            secList.setUserId(userId);
            secList.setDeviceId(arr[i]);
            secLists.add(secList);
        }
        return secLists;
    }
}
