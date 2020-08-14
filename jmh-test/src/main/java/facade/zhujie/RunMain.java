package facade.zhujie;

import facade.StringBuilderBenchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author shaozhenya
 * @date 2020/8/13
 */
public class RunMain {
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(StringBuilderBenchmark.class.getSimpleName())
                .output("/Users/shaozhenya/Downloads/jmh.log")
                .build();
        new Runner(options).run();
    }
}
