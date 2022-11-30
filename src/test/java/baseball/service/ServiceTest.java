package baseball.service;

import static org.assertj.core.util.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import baseball.service.Service;
import baseball.utils.NumberListGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ServiceTest {
    private Service service;

    @BeforeEach
    void beforeEach(){
        service = new Service();
    }

    @ParameterizedTest
    @MethodSource("generateNormalNumbers")
    void 임의의_세자리_수로_컴퓨터의_수를_생성한다(List<Integer> numbers){
        //given
        TestNumberListGenerator generator = new TestNumberListGenerator(numbers);

        //when
        Throwable result = catchThrowable(()->{service.setComputerNumbers(generator);});

        //then
        assertThat(result).doesNotThrowAnyException();
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

    static Stream<Arguments> generateNormalNumbers(){
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3)),
                Arguments.of(Arrays.asList(9,3,6))
        );
    }
}
