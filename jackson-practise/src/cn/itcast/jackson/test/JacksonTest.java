package cn.itcast.jackson.test;

import cn.itcast.jackson.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class JacksonTest {

    /**
     * Java对象转为JSON字符串
     */
    @Test
    public void jacksonTest1() throws IOException {
        // 1.创建Person对象
        Person person = new Person(1, "张三", true, new Date(), "123456");
        // 2.创建jackson的核心对象 ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        // jackson时区问题
        objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        // 3.转换
        /**
         * 转换方法：
         *    writeValue(参数1, Object obj)
         *       参数1：
         *          File：将obj转为字符串并保存到指定的文件中
         *          Writer：将obj转为字符串并将json字符串数据填充到一个字符输出流中
         *          OutputStream：将obj转为字符串并将json字符串数据填充到一个字节输出流中
         *    writeValueAsString(Object obj)将对象转为字符串
         */
        System.out.println(person.getBirthday());
        String personJson = objectMapper.writeValueAsString(person);
        System.out.println(personJson);
        System.out.println("--------------------------------");
        objectMapper.writeValue(new File("./person_json_test1.txt"), person);

    }


    @Test
    public void jacksonTest2() throws IOException {
        // 1.创建Person对象
        Person person = new Person(1, "张三", true, new Date(), "123456");
        System.out.println(person.getBirthday());
        // 2.创建jackson的核心对象 ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        // 3.转换
        String personJson = objectMapper.writeValueAsString(person);
        System.out.println(personJson);

    }

    @Test
    public void jacksonTest3() throws IOException {
        // 1.创建Person对象
        Person person1 = new Person(1, "张三", true, new Date(), "123456");
        Person person2 = new Person(1, "张三", true, new Date(), "123456");
        Person person3 = new Person(1, "张三", true, new Date(), "123456");
        List<Person> people = new ArrayList<Person>();
        people.add(person1);
        people.add(person2);
        people.add(person3);
        // 2.创建jackson的核心对象 ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        // 3.转换
        String peopleJson = objectMapper.writeValueAsString(people);
        System.out.println(peopleJson);
    }

    @Test
    public void jacksonTest4() throws IOException {
        // 1.创建Map对象
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 23);
        map.put("gender", true);

        // 2.创建jackson的核心对象 ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        // 3.转换
        String mapJson = objectMapper.writeValueAsString(map);
        System.out.println(mapJson);
    }

    /**
     * 演示json字符串转换为java对象
     * @throws IOException
     */
    @Test
    public void jacksonTest5() throws IOException {
        // 1.初始化json字符串
        String json = "{\"gender\":true,\"name\":\"张三\",\"age\":23}";
        // 2.创建jackson的核心对象 ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        // 3.转换
        Map<String, Object> hashMap = objectMapper.readValue(json, HashMap.class);
        System.out.println(hashMap);
        System.out.println(hashMap.get("name"));
    }
}
