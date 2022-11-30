package baseball.service;

import baseball.utils.NumberListGenerator;
import baseball.domain.BaseballNumbers;

public class Service {
    private static final int NUMBERS_SIZE = 3;

    private BaseballNumbers computerNumbers;

    public void setComputerNumbers(NumberListGenerator numberListGenerator) throws IllegalArgumentException{
        computerNumbers = BaseballNumbers.of(numberListGenerator.generate(NUMBERS_SIZE));
    }

}
