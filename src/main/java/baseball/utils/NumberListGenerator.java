package baseball.utils;

import java.util.List;

@FunctionalInterface
public interface NumberListGenerator {

    List<Integer> generate(int size);
}
