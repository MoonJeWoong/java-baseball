package baseball.utils;

import static org.assertj.core.api.Assertions.assertThat;


import baseball.utils.RandomNumberListGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class RandomNumberListGeneratorTest {

    private final RandomNumberListGenerator generator = new RandomNumberListGenerator();

    @ParameterizedTest
    @ValueSource(ints = {2,3,4})
    void 지정된_사이즈만큼의_무작위_숫자_리스트를_생성한다(int size){
        //when
        List<Integer> result = generator.generate(size);

        //then
        assertThat(result.size()).isEqualTo(size);

    }
}
