package com.ab;

import com.ab.beans.User;
import com.ab.config.DB2BeanProperties;
import com.ab.mapper.DB2BeanUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

public class DB2BeanTest {

    @Test
    public void testDB2Bean() throws Exception{
        List<Map<String, Object>> records = new ArrayList<>(0);

        Map<String, Object> record1 = new HashMap<>(0);
        record1.put("User Name","John");
        record1.put("AGE",33);
        record1.put("BirthdayOn", Date.from(Instant.now()));
        record1.put("Hitched",Boolean.TRUE);

        Map<String, Object> record2 = new HashMap<>(0);
        record2.put("User Name","Jacob");
        record2.put("AGE",39);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        record2.put("BirthdayOn", simpleDateFormat.parse("1920-05-10"));
        record2.put("Hitched",Boolean.FALSE);

        Map<String, Object> record3 = new HashMap<>(0);
        record3.put("User Name", null);
        record3.put("AGE", null);
        record3.put("BirthdayOn", null);
        record3.put("Hitched",null);

        records.add(record1);
        records.add(record2);
        records.add(record3);

        String mappingString = DB2BeanProperties.getInstance().getString("user_mapping");

        List<User> userList = new ArrayList<>(0);

        records.forEach(record -> {
            User user = new User();
            DB2BeanUtils<User> instance = new DB2BeanUtils<>();
            instance.mapDB2Bean(user, mappingString, record);

            userList.add(user);
        });

        System.out.println(userList);
    }
}
