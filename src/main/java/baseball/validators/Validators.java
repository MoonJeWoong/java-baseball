package baseball.validators;

import java.util.HashSet;
import java.util.List;

public final class Validators {
    public static void validateListSize(List<Integer> list, int size) throws IllegalArgumentException{
        if(list.size() != size){
            throw new IllegalArgumentException();
        }
    }
}
