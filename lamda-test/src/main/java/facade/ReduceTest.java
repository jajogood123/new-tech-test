package facade;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shaozhenya
 * @date 2020/8/14
 */
public class ReduceTest {
    private static final List<Integer> DATA = Lists.newArrayList(1,2,3,4,5);

    private static final List<List<Integer>> DATA_LIST =
            Lists.newArrayList(
                    Lists.newArrayList(1,3),
                    Lists.newArrayList(2, 9),
                    Lists.newArrayList(8,8)
            );


    /**
     * 变形1
     *未定义初始值，从而第一次循环的时候第一个参数的值是Stream的第一个元素，第二个参数是Stream的第二个元素
     */
    public static void process_1() {
        Integer result = DATA.stream()
                .reduce((pre, cur) -> {
                    return pre > cur ? pre : cur;
                }).get();
        System.out.println(result);
    }

    /**
     * 变形2
     * 循环的值和初始值的类型需要一样
     * 定义了初始值，从而第一次循环的时候第一个参数的值是初始值，第二个参数是Stream的第一个元素
     */
    public static void process_2(){
        List<Integer> result = DATA_LIST.stream()
                .reduce(new ArrayList<>(), (all, item) -> {
                        if (!item.contains(8)) {
                            all.addAll(item);
                        }
                        return all;
                    }
                );

        System.out.println(result);

    }


    public static void main(String[] args) {
        process_1();
        process_2();
    }
}
