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


    private static final int COUNT_ZERO = 0;

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

    public String toString(){
        if(isSameStrikes(COUNT_ZERO) && isSameBalls(COUNT_ZERO)){
            return nothingToString();
        }
        return resultToString();
    }

    private String nothingToString(){
        return "낫싱";
    }

    private String resultToString(){
        StringBuilder result = new StringBuilder();
        appendBallCount(result);
        appendStrikeCount(result);
        return result.toString().trim();
    }

    private void appendBallCount(StringBuilder result){
        if(!isSameBalls(COUNT_ZERO)){
            result.append(String.format("%d볼 ",balls));
        }
    }

    private void appendStrikeCount(StringBuilder result){
        if(!isSameStrikes(COUNT_ZERO)){
            result.append(String.format("%d스트라이크", strikes));
        }
    }
}
