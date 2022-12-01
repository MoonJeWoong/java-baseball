package baseball.domain;

import java.util.Arrays;
import java.util.Objects;

public enum RetryCommands {

    RETRY(1),
    QUIT(2);

    private static final String COMMAND_ERROR_MESSAGE = "[ERROR] 1 혹은 2의 숫자만 입력이 가능합니다. 재입력 해 주십시오.";

    private final int command;

    RetryCommands(int command) {
        this.command = command;
    }

    public static RetryCommands from(int input) throws IllegalArgumentException {
        return Arrays.stream(RetryCommands.values())
                .filter(retryCommands -> Objects.equals(retryCommands.value(), input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(COMMAND_ERROR_MESSAGE));
    }

    public int value() {
        return this.command;
    }

}
