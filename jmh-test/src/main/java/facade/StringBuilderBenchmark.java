package facade;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * @author shaozhenya
 * @date 2020/8/13
 */
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 3)
@Measurement(iterations = 6, time = 5)
@Threads(8)
@Fork(2)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class StringBuilderBenchmark {
    @Param({"10", "50", "100"})
    private int loop;

    @Benchmark
    public void testStringAdd() {
        String a = "";
        for (int i = 0; i < loop; i++) {
            a += i;
        }
        print(a);
    }

    @Benchmark
    public void testStringBuilderAdd() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < loop; i++) {
            sb.append(i);
        }
        print(sb.toString());
    }

    private void print(String a) {
    }
}
