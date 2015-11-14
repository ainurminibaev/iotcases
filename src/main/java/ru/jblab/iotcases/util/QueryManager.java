package ru.jblab.iotcases.util;

import com.google.common.collect.ImmutableMap;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;


public class QueryManager {

    protected static final Logger log = LoggerFactory.getLogger(QueryManager.class);

    private static final Configuration config = new Configuration();

    static {
        try {
            // загрузка шаблонов из classpath
            config.setClassForTemplateLoading(QueryManager.class, "/");
            // вывод чисел без форматирования
            config.setNumberFormat("0.######");
            // не ищем фтл-ку по локали, потому что это SQL
            config.setLocalizedLookup(false);
            config.setDefaultEncoding("UTF-8");
            // для доступа к полям объектов
            BeansWrapper wrapper = new BeansWrapper();
            wrapper.setSimpleMapWrapper(true);
            config.setObjectWrapper(wrapper);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    private QueryManager() {
    }


    public static <V> String getQuery (final String templateName, Map<String, V> params){
        if(params == null)
            params = ImmutableMap.of();
        final Map<String, Object> model = ImmutableMap.<String, Object>builder()
                .putAll(params)
                .build();
        log.trace("Sql template({}), params({}),", templateName, params.toString());
        String result = null;
        try (
                StringWriter stringWriter = new StringWriter();
                Writer writer = new BufferedWriter(stringWriter)
        ) {
            Template template = config.getTemplate(templateName);
            template.process(model, writer);
            writer.flush();
            result = stringWriter.toString();
        } catch (Exception e) {
            log.error("Error in sql template. Exception: {}, message: {}", e.getClass(), e.getMessage());
        }
        log.trace("Sql query:\n{}", result);
        return result;
    }
}
