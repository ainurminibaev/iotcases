package ru.jblab.iotcases.util;

import ru.jblab.iotcases.form.FilterForm;

/**
 * Created by ainurminibaev on 06.11.15.
 */
public class Utils {

    public static FilterForm fixForm(FilterForm filterForm) {
        if (filterForm == null) {
            filterForm = new FilterForm();
        }
        if (filterForm.getPage() == null) {
            filterForm.setPage(0);
        }
        return filterForm;
    }
}
