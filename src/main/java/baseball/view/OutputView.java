package baseball.view;

import baseball.domain.BaseballResults;

public class OutputView {
    public void printGameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printGameResult(BaseballResults result){
        System.out.println(result.toString());
    }
}
