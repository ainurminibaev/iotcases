package ru.kpfu.itis.controller;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.model.Action;
import ru.kpfu.itis.model.helper.ActionJson;
import ru.kpfu.itis.repository.Logger;
import ru.kpfu.itis.service.LogService;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.*;
import java.net.URLDecoder;
import java.util.List;
import java.util.Locale;

/**
 * Created by vlad on 15.11.15.
 */
@Controller
public class StatController {

    @Autowired
    LogService logService;

    public String getPath() throws UnsupportedEncodingException {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        String fullPath = URLDecoder.decode(path, "UTF-8");
        String pathArr[] = fullPath.split("/target/");
        System.out.println(pathArr[0]);
        fullPath = pathArr[0];

        return fullPath;
    }

    @RequestMapping(value = "get/stat", method = RequestMethod.GET)
    public void download(HttpServletResponse response) throws IOException {

        String absoluteFile = generate(getPath());

        File file = new File(absoluteFile);
        InputStream is = new FileInputStream(file);

        // MIME type of the file
        response.setContentType("application/octet-stream");
        // Response header
        response.setHeader("Content-Disposition", "attachment; filename=\""
                + file.getName() + "\"");
        // Read from the file and write into the response
        OutputStream os = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }

        os.flush();
        os.close();
        is.close();
    }

    private String generate(String path) {
        String filename = path + "/stat.xls";
        try {
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
        return filename;
    }

    private void writeDataSheet(WritableSheet s) throws WriteException {

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
        cf.setAlignment(jxl.format.Alignment.CENTRE);

        List<Action> actions = logService.findAll();

    /* Date*/
        Label l = new Label(date_col, 0, "Дата", cf);
        s.addCell(l);
        WritableCellFormat cf1 = new WritableCellFormat(DateFormats.FORMAT9);
        cf1.setAlignment(jxl.format.Alignment.CENTRE);

        int i = 0;
        for (Action a : actions) {
            DateTime dt = new DateTime(date_col, ++i, a.getDate(), cf1, DateTime.GMT);
            s.addCell(dt);
        }

    /* User*/
        l = new Label(user_col, 0, "Пользователь", cf);
        s.addCell(l);

        i = 0;
        for (Action a : actions) {
            l = new Label(user_col, ++i, a.getUser(), cf);
            s.addCell(l);
        }

    /* Device*/
        l = new Label(device_col, 0, "Устройство", cf);
        s.addCell(l);

        i = 0;
        for (Action a : actions) {
            l = new Label(device_col, ++i, a.getDevice(), cf);
            s.addCell(l);
        }

    /* Access*/
        l = new Label(access_col, 0, "Доступ", cf);
        s.addCell(l);

        i = 0;
        for (Action a : actions) {
            if (a.isAccess()) {
                l = new Label(access_col, ++i, "Разрешен", cf);
            } else {
                l = new Label(access_col, ++i, "Запрещен", cf);
            }
            s.addCell(l);
        }

    }

    @ResponseBody
    @RequestMapping(value = "/api/log", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void recordAction(@RequestBody ActionJson actionJson) {
        Action action = new Action(actionJson.getU_name(), actionJson.getD_name(), actionJson.isAccess());
        logService.save(action);
    }

}
