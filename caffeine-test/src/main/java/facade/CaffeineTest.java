package facade;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

/**
 * @author shaozhenya
 * @date 2020/8/13
 */
public class CaffeineTest {
    private static LoadingCache<String, String> cache = Caffeine.newBuilder()
            //设置缓存容器的初始容量为10
            .initialCapacity(10)
            //设置缓存最大容量为100，超过100之后就会按照LRU策略(Least Recently Used，最小使用算法)来移除缓存项
            .maximumSize(100)
            //设置缓存的最大权重
//            .maximumWeight(1000)
            //是否需要统计缓存情况,该操作消耗一定的性能,生产环境应该去除
            .recordStats()
            //设置写缓存后n秒钟过期
            .expireAfterWrite(5, TimeUnit.SECONDS)
            //设置读写缓存后n秒钟过期,实际很少用到,类似于expireAfterWrite
            //.expireAfterAccess(17, TimeUnit.SECONDS)
            //只阻塞当前数据加载线程，其他线程返回旧值
            .refreshAfterWrite(3, TimeUnit.SECONDS)
            //设置缓存的移除通知
//            .weigher(new Weigher<String, String>() {
//
//                @Override
//                public int weigh(String key, String value) {
//                    return 0;
//                }
//            })
            .removalListener((key, value, cause) -> System.out.println("被移除`"))
            //build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
            .build(
                    s -> {
                        System.out.println("进入到load接口");
                        if (s.equals("aK")) {
                            return "aV";
                        } else {
                            return "bV";
                        }
                    }
            );
    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 30; i++) {
            System.out.println(cache.get("aK"));
            System.out.println(cache.get("bK"));
            Thread.sleep(200);
        }
    }
}
