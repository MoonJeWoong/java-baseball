package baseball.validators;

import java.util.HashSet;
import java.util.List;

public final class Validators {
    private static final List<Integer> NATURAL_NUMBERS = List.of(1,2,3,4,5,6,7,8,9);

    public static void validateListSize(List<Integer> list, int size) throws IllegalArgumentException{
        if(list.size() != size){
            throw new IllegalArgumentException();
        }
    }

    public static void validateNoDuplicatedList(List<Integer> list) throws IllegalArgumentException{
        HashSet<Integer> validationNumbers = new HashSet<>(list);
        if(validationNumbers.size() != list.size()){
            throw new IllegalArgumentException();
        }
    }

    public static void validateNaturalNumberList(List<Integer> list) throws IllegalArgumentException{
        for(int x : list){
            if(!NATURAL_NUMBERS.contains(x)){
                throw new IllegalArgumentException();
            }
        }
    }
}
