package baseball.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class RetryCommandsTest {
    @ParameterizedTest
    @MethodSource("generateNormalRetryCommands")
    void 입력값에_따라_재시작_종료_명령어를_반환한다(int input, RetryCommands expected) {
        //when
        RetryCommands result = RetryCommands.from(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("generateExceptionalRetryCommands")
    void 입력값으로_정해진_값이_주어지지_않으면_예외를_발생시킨다(int input) {
        //when
        Throwable result = catchThrowable(() -> {
            RetryCommands.from(input);
        });

        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> generateNormalRetryCommands() {
        return Stream.of(
                Arguments.of(1, RetryCommands.RETRY),
                Arguments.of(2, RetryCommands.QUIT)
        );
    }

    static Stream<Arguments> generateExceptionalRetryCommands() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(123)
        );
    }
}
