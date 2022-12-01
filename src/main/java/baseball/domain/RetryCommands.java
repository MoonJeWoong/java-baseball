package baseball.domain;

import java.util.Arrays;
import java.util.Objects;

public enum RetryCommands {

    RETRY(1),
    QUIT(2);

    private int command;

    RetryCommands(int command){
        this.command = command;
    }

    public static RetryCommands from(int input) throws IllegalArgumentException{
        return Arrays.stream(RetryCommands.values())
                .filter(retryCommands -> Objects.equals(retryCommands.value(), input))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException());
    }

    public int value(){
        return this.command;
    }

}
