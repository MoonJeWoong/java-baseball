package baseball.service;

import baseball.domain.BaseballResults;
import baseball.utils.NumberListGenerator;
import baseball.domain.BaseballNumbers;

public class Service {
    private static final int NUMBERS_SIZE = 3;
    private static final int INITIAL_COUNT = 0;
    private static final int INITIAL_INDEX = 0;
    private BaseballNumbers computerNumbers;

    public void setComputerNumbers(NumberListGenerator numberListGenerator) throws IllegalArgumentException{
        computerNumbers = BaseballNumbers.of(numberListGenerator.generate(NUMBERS_SIZE));
    }

    public BaseballResults getBaseballResults(BaseballNumbers userNumbers){
        int strikes = countStrikes(userNumbers);
        int balls = countBalls(userNumbers);
        return BaseballResults.getBaseballResults(strikes,balls);
    }

    private int countStrikes(BaseballNumbers userNumbers){
        int count = INITIAL_COUNT;
        for(int index=INITIAL_INDEX; index<NUMBERS_SIZE; index++){
            if(computerNumbers.isValueAt(userNumbers.valueAt(index), index)){
                count++;
            }
        }
        return count;
    }

    private int countBalls(BaseballNumbers userNumbers){
        int count = INITIAL_COUNT;
        for(int index=INITIAL_INDEX; index<NUMBERS_SIZE; index++){
            if(computerNumbers.contains(userNumbers.valueAt(index))
                    && !computerNumbers.isValueAt(userNumbers.valueAt(index), index)){
                count++;
            }
        }
        return count;
    }
}
