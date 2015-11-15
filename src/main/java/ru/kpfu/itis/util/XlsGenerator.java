package ru.kpfu.itis.util;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.*;
import jxl.format.Alignment;
import jxl.write.*;
import jxl.write.Number;
import ru.kpfu.itis.model.Device;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.util.logger.Action;
import ru.kpfu.itis.util.logger.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by vlad on 15.11.15.
 */
public class XlsGenerator {

    public static void main(String[] args) {

//        log generation
        boolean access = true;
        for (int i = 0; i < 50; i++) {
            if (Math.random() > 0.5) access = !access;
            Logger.add(new Action(new User("User" + i), new Device("Device" + i), access));
        }

//        output log to console
        Logger.show();

//        output log to .xls
        try {
            String filename = "input.xls";
            WorkbookSettings ws = new WorkbookSettings();
            ws.setLocale(new Locale("ru", "RU"));
            WritableWorkbook workbook = Workbook.createWorkbook(new File(filename), ws);
            WritableSheet s = workbook.createSheet("Лог", 0);
            writeDataSheet(s);
            workbook.write();
            workbook.close();
        } catch (IOException | WriteException e) {
            e.printStackTrace();
        }
    }

    private static void writeDataSheet(WritableSheet s) throws WriteException {

        int date_col = 0;
        int user_col = 1;
        int device_col = 2;
        int access_col = 3;

        s.setColumnView(date_col, 20);
        s.setColumnView(user_col, 20);
        s.setColumnView(device_col, 20);
        s.setColumnView(access_col, 20);

    /* Format the Font */
        WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
        WritableCellFormat cf = new WritableCellFormat(wf);
        cf.setWrap(true);
        cf.setAlignment(Alignment.CENTRE);

    /* Date*/
        Label l = new Label(date_col, 0, "Дата", cf);
        s.addCell(l);
        WritableCellFormat cf1 = new WritableCellFormat(DateFormats.FORMAT9);
        cf1.setAlignment(Alignment.CENTRE);

        for (int i = 0; i < Logger.size(); i++) {
            DateTime dt = new DateTime(date_col, i + 1, Logger.get(i).getDate(), cf1, DateTime.GMT);
            s.addCell(dt);
        }

    /* User*/
        l = new Label(user_col, 0, "Пользователь", cf);
        s.addCell(l);

        for (int i = 0; i < Logger.size(); i++) {
            l = new Label(user_col, i + 1, Logger.get(i).getUser().getName(), cf);
            s.addCell(l);
        }

    /* Device*/
        l = new Label(device_col, 0, "Устройство", cf);
        s.addCell(l);

        for (int i = 0; i < Logger.size(); i++) {
            l = new Label(device_col, i + 1, Logger.get(i).getDevice().getName(), cf);
            s.addCell(l);
        }

    /* Access*/
        l = new Label(access_col, 0, "Доступ", cf);
        s.addCell(l);

        for (int i = 0; i < Logger.size(); i++) {
            if (Logger.get(i).isAccess()) {
                l = new Label(access_col, i + 1, "Разрешен" , cf);
            } else {
                l = new Label(access_col, i + 1, "Запрещен" , cf);
            }
            s.addCell(l);
        }

    }

}
