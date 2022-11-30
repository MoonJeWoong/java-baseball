package baseball.domain;

import baseball.validators.Validators;

import java.util.List;

public class BaseballNumbers {
    private static final int NUMBERS_SIZE = 3;

    private final List<Integer> numbers;

    public static BaseballNumbers of(List<Integer> numbers){
        return new BaseballNumbers(numbers);
    }

    private BaseballNumbers(List<Integer> numbers) throws IllegalArgumentException{
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) throws IllegalArgumentException{
        Validators.validateListSize(numbers, NUMBERS_SIZE);
        Validators.validateNoDuplicatedList(numbers);
        Validators.validateNaturalNumberList(numbers);
    }
}
