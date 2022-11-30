package baseball.domain;

public enum BaseballResults {

    THREE_STRIKES(3,0),
    TWO_STRIKES(2,0),
    ONE_STRIKES(1,0),
    ONE_STRIKES_ONE_BALL(1,1),
    ONE_STRIKES_TWO_BALLS(1,2),
    THREE_BALLS(0,3),
    TWO_BALLS(0,2),
    ONE_BALLS(0,1),
    NOTHING(0,0);


    private final int strikes;
    private final int balls;

    BaseballResults(int strikes, int balls){
        this.strikes = strikes;
        this.balls = balls;
    }

    private boolean isSameStrikes(int strikes){
        return this.strikes == strikes;
    }

    private boolean isSameBalls(int balls){
        return this.balls == balls;
    }

    public static BaseballResults getBaseballResults(int strikes, int balls){
        for(BaseballResults result : BaseballResults.values()){
            if(result.isSameStrikes(strikes) && result.isSameBalls(balls)){
                return result;
            }
        }
        return NOTHING;
    }
}
