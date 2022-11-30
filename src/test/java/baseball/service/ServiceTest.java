package baseball.service;

import static org.assertj.core.util.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballResults;
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

    @ParameterizedTest
    @MethodSource("generateUserNumbers")
    void 플레이어_입력값에_대한_게임결과를_계산한다(BaseballNumbers userNumbers, BaseballResults expected){
        //given
        service.setComputerNumbers(new TestNumberListGenerator(Arrays.asList(1,2,3)));

        //when
        BaseballResults result = service.getBaseballResults(userNumbers);

        //then
        assertThat(result).isEqualTo(expected);
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

    static Stream<Arguments> generateUserNumbers(){
        return Stream.of(
                Arguments.of(BaseballNumbers.of(Arrays.asList(1,2,3)), BaseballResults.THREE_STRIKES),
                Arguments.of(BaseballNumbers.of(Arrays.asList(1,2,5)), BaseballResults.TWO_STRIKES),
                Arguments.of(BaseballNumbers.of(Arrays.asList(1,4,5)), BaseballResults.ONE_STRIKES),
                Arguments.of(BaseballNumbers.of(Arrays.asList(1,4,2)), BaseballResults.ONE_STRIKES_ONE_BALL),
                Arguments.of(BaseballNumbers.of(Arrays.asList(1,3,2)), BaseballResults.ONE_STRIKES_TWO_BALLS),
                Arguments.of(BaseballNumbers.of(Arrays.asList(4,1,5)), BaseballResults.ONE_BALLS),
                Arguments.of(BaseballNumbers.of(Arrays.asList(2,1,5)), BaseballResults.TWO_BALLS),
                Arguments.of(BaseballNumbers.of(Arrays.asList(2,3,1)), BaseballResults.THREE_BALLS),
                Arguments.of(BaseballNumbers.of(Arrays.asList(4,5,6)), BaseballResults.NOTHING)
        );
    }
}
