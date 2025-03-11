package facade;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * https://www.cnblogs.com/yizhiamumu/p/8999482.html
 * @author shaozhenya
 * @date 2020/8/14
 */
public class NullableTest {
    private static final List<Integer> DATA = Lists.newArrayList(1,2,3,4,5);

//    ji
    private static final List<Integer> EMPTY = null;

    /**
     * 注意这里测试的方法都是optional的方法
     * @param args
     */
    public static void main(String[] args) {
        // 1.如果不是null就输出
        Optional.ofNullable(EMPTY).ifPresent(u -> System.out.println(u));

        // 2.orElse
        System.out.println(Optional.ofNullable(EMPTY).orElse(Lists.newArrayList(1,2,3)).stream().filter(o -> o > 2).collect(Collectors.toList()));

        System.out.println(Optional.ofNullable(DATA).filter(o -> CollectionUtils.isEmpty(o)).map(o -> o).orElse(Lists.newArrayList(9,9,9)));

        //3.orElseGet
        System.out.println(Optional.ofNullable(DATA).filter(o -> CollectionUtils.isEmpty(o)).map(o -> o).orElseGet(NullableTest::defaultGet));


    }


    private static List<Integer> defaultGet() {
        return Lists.newArrayList(8,8,8);
    }
}
