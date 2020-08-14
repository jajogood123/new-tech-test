package facade.feizhujie;

import facade.StringBuilderBenchmark;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.Collection;

/**
 * @author shaozhenya
 * @date 2020/8/13
 */
public class RunMain {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(StringBuilderBenchmark.class.getSimpleName())
                .output("/Users/shaozhenya/Downloads/jmh.log")
                .forks(2)
                .threads(8)
                .warmupIterations(3)
                .measurementIterations(10)
                .measurementTime(TimeValue.seconds(5))
                .build();
        Collection<RunResult> results =  new Runner(opt).run();
    }
}
