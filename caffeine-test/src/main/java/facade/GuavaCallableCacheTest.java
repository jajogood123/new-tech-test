package facade;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @author shaozhenya
 * @date 2020/8/14
 */
public class GuavaCallableCacheTest {
    static Cache<String, String> cache = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .build();

    public static void main(String[] args) throws ExecutionException {
        // 获取某个key时，在Cache.get中单独为其指定load方法
        System.out.println(cache.get("hello", new Callable<String>() {
            public String call() {
                System.out.println("进来到callable");
                return "hello world!";
            }
        }));
        System.out.println(cache.get("hello", new Callable<String>() {
            public String call() {
                System.out.println("进来到callable");
                return "hello world!";
            }
        }));
        System.out.println(cache.get("hello", new Callable<String>() {
            public String call() {
                System.out.println("进来到callable");
                return "hello world!";
            }
        }));
    }
}
