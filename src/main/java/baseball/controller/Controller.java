package baseball.controller;

import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballResults;
import baseball.domain.RetryCommands;
import baseball.service.Service;
import baseball.utils.NumberListGenerator;
import baseball.utils.Parser;
import baseball.utils.RandomNumberListGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class Controller {
    private static final Service service = new Service();
    private static final NumberListGenerator numberListGenerator = new RandomNumberListGenerator();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public Controller(){
        outputView.printGameStart();
    }

    public void run(){
        initGame();
        playGame();
        retryGameOrQuit();
    }

    private void initGame(){
        service.setComputerNumbers(numberListGenerator);
    }

    private void playGame(){
        BaseballResults result = service.getBaseballResults(getPlayerNumbers());
        outputView.printGameResult(result);
        isGameEnded(result);
    }

    private BaseballNumbers getPlayerNumbers(){
        List<Integer> numbers = Parser.stringToIntegerList(inputView.readPlayerNumbers());
        try{
            return BaseballNumbers.of(numbers);
        } catch (IllegalArgumentException error){
            System.out.println("[ERROR] 숫자의 길이, 중복 여부, 자연수 여부를 확인 후 재입력 해 주십시오.");   //outputView 로 분리하기
            return getPlayerNumbers();
        }
    }

    private void isGameEnded(BaseballResults result){
        if(!result.equals(BaseballResults.THREE_STRIKES)){
            playGame();
            return;
        }
        outputView.printGameFinished();
    }

    private void retryGameOrQuit(){
        RetryCommands retryCommands = getRetryCommands();
        if(retryCommands.equals(RetryCommands.RETRY)){
            run();
            return;
        }
        outputView.printProgramQuit();
    }

    private RetryCommands getRetryCommands(){
        try{
            return RetryCommands.from(inputView.readRetryCommands());
        } catch (IllegalArgumentException error) {
            System.out.println("[ERROR] 1 혹은 2의 숫자만 입력이 가능합니다. 재입력 해 주십시오.");   //outputView 로 분리하기
            return getRetryCommands();
        }
    }
}
