package facade;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.*;

import java.util.concurrent.ConcurrentHashMap;


/**
 * @author shaozhenya
 * @date 2025/03/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Test {
    public static final String a = "12312";

    /**
     * 年龄
     */
    private Integer age;
    
    /**
     * 名字
     */
    private String name;

    public static void main(String[] args) {
        Test test = new Test();

        Test test1 = new Test();


        test.setAge(12);

        test1.setName("123");
        test1.setAge(12);
        test.setName("123");
        test.setAge(12);
        System.out.println(JSON.toJSONString(test));

    }

}