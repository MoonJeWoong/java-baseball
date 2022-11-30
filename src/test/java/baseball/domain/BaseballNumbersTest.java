package baseball.domain;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.utils.NumberListGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


class BaseballNumbersTest {
    @ParameterizedTest
    @MethodSource("generateNormalSizeNumbers")
    void 야구게임에_사용되는_세자리_숫자를_저장한다(List<Integer> numbers){
        //given
        TestNumberListGenerator generator = new TestNumberListGenerator(numbers);

        //when
        Throwable result = catchThrowable(()->{BaseballNumbers.of(generator.generate(0));});

        //then
        assertThat(result).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("generateExceptionalNumbers")
    void 야구게임_숫자가_올바른_형식인지_검증하는_기능(List<Integer> numbers){
        //given
        TestNumberListGenerator generator = new TestNumberListGenerator(numbers);

        //when
        Throwable result = catchThrowable(()->{BaseballNumbers.of(generator.generate(0));});

        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    static class TestNumberListGenerator implements NumberListGenerator {

        private final List<Integer> numbers;

        TestNumberListGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public List<Integer> generate(int size) {
            return numbers;
        }
    }

    static Stream<Arguments> generateNormalSizeNumbers(){
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3)),
                Arguments.of(Arrays.asList(9,2,5))
        );
    }

    static Stream<Arguments> generateExceptionalNumbers(){
        return Stream.of(
                Arguments.of(Arrays.asList()),
                Arguments.of(Arrays.asList(1,2)),
                Arguments.of(Arrays.asList(9,2,5,3)),
                Arguments.of(Arrays.asList(1,2,2)),
                Arguments.of(Arrays.asList(8,8,8)),
                Arguments.of(Arrays.asList(0,1,5)),
                Arguments.of(Arrays.asList(4,9,0))
        );
    }
}