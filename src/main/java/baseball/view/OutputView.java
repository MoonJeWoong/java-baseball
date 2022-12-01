package baseball.view;

import baseball.domain.BaseballResults;

public class OutputView {
    public void printGameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printGameResult(BaseballResults result){
        System.out.println(result.toString());
    }

    public void printGameFinished(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printProgramQuit(){
        System.out.println("프로그램이 종료되었습니다. 감사합니다.");
    }
}
