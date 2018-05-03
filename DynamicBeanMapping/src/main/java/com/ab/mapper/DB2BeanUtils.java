package com.ab.mapper;

import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DB2BeanUtils<T> {

    public void mapDB2Bean(T bean, String mappingString, Map<String, Object> dbRecord) {

        List<String> allDB2BeanMappers = new ArrayList<>(Arrays.asList(mappingString.split(",")));


        allDB2BeanMappers.forEach(db2beanmap -> {
            String[] mapper = db2beanmap.split("\\|");

            if (dbRecord.containsKey(mapper[0])) {
                Object finalValue = dbRecord.get(mapper[0]) == null ? getDefaultValue(mapper[2], mapper[3]) : dbRecord.get(mapper[0]);

                try {
                    if (PropertyUtils.getPropertyDescriptor(bean, mapper[1]) != null) {
                        PropertyUtils.setProperty(bean, mapper[1], finalValue);
                    }
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }

        });

    }

    private Object getDefaultValue(Object defaultValue, String dataType) {

        try {
            switch (dataType) {
                case "Date":
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    return simpleDateFormat.parse(defaultValue.toString());
                case "Boolean":
                    return Boolean.valueOf(defaultValue.toString());
                case "Integer":
                    return Integer.valueOf(defaultValue.toString());
                case "String":
                    return defaultValue.toString();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

}
