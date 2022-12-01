package baseball.validators;

import java.util.HashSet;
import java.util.List;

public final class Validators {
    private static final List<Integer> NATURAL_NUMBERS = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private static final String SIZE_ERROR_MESSAGE = "[ERROR] 숫자의 길이를 확인 후 재입력 해 주십시오.";
    private static final String DUPLICATED_ERROR_MESSAGE = "[ERROR] 숫자의 중복 여부를 확인 후 재입력 해 주십시오.";
    private static final String NATURAL_NUMBER_ERROR_MESSAGE = "[ERROR] 자연수만 입력했는지 확인 후 재입력 해 주십시오.";

    public static void validateListSize(List<Integer> list, int size) throws IllegalArgumentException {
        if (list.size() != size) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    public static void validateNoDuplicatedList(List<Integer> list) throws IllegalArgumentException {
        HashSet<Integer> validationNumbers = new HashSet<>(list);
        if (validationNumbers.size() != list.size()) {
            throw new IllegalArgumentException(DUPLICATED_ERROR_MESSAGE);
        }
    }

    public static void validateNaturalNumberList(List<Integer> list) throws IllegalArgumentException {
        for (int x : list) {
            if (!NATURAL_NUMBERS.contains(x)) {
                throw new IllegalArgumentException(NATURAL_NUMBER_ERROR_MESSAGE);
            }
        }
    }
}
