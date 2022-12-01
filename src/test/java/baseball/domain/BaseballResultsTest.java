package baseball.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballResultsTest {
    @ParameterizedTest
    @MethodSource("baseballResultsByStrikesAndBalls")
    void 스트라이크_볼_개수에_따라_결과를_반환한다(int strikes, int balls, BaseballResults expected){
        //when
        BaseballResults result = BaseballResults.getBaseballResults(strikes, balls);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("baseballResultsStringByStrikesAndBalls")
    void 스트라이크_볼_개수에_따라_출력문구를_반환한다(int strikes, int balls, String expected){
        //when
        BaseballResults result = BaseballResults.getBaseballResults(strikes, balls);

        //then
        assertThat(result.toString()).isEqualTo(expected);
    }

    static Stream<Arguments> baseballResultsByStrikesAndBalls(){
        return Stream.of(
                Arguments.of(3,0,BaseballResults.THREE_STRIKES),
                Arguments.of(2,0,BaseballResults.TWO_STRIKES),
                Arguments.of(1,0,BaseballResults.ONE_STRIKES),
                Arguments.of(1,1,BaseballResults.ONE_STRIKES_ONE_BALL),
                Arguments.of(1,2,BaseballResults.ONE_STRIKES_TWO_BALLS),
                Arguments.of(0,1,BaseballResults.ONE_BALLS),
                Arguments.of(0,2,BaseballResults.TWO_BALLS),
                Arguments.of(0,3,BaseballResults.THREE_BALLS),
                Arguments.of(0,0,BaseballResults.NOTHING)
        );
    }

    static Stream<Arguments> baseballResultsStringByStrikesAndBalls(){
        return Stream.of(
                Arguments.of(3,0,"3스트라이크"),
                Arguments.of(2,0,"2스트라이크"),
                Arguments.of(1,0,"1스트라이크"),
                Arguments.of(1,1,"1볼 1스트라이크"),
                Arguments.of(1,2,"2볼 1스트라이크"),
                Arguments.of(0,1,"1볼"),
                Arguments.of(0,2,"2볼"),
                Arguments.of(0,3,"3볼"),
                Arguments.of(0,0,"낫싱")
        );
    }

}