package facade;

import com.alibaba.fastjson.JSONObject;
import lombok.*;

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
        test.setAge(1);
        test.setName("你好");

        System.out.println(JSONObject.toJSON(test));
    }
}
