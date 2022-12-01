package baseball.view;

import baseball.domain.BaseballNumbers;
import baseball.domain.RetryCommands;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String readPlayerNumbers(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = readLine();
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException error) {
            System.out.println("[ERROR] 숫자로 이루어진 입력값이 아닙니다. 숫자만 입력해 주십시오.");
            return readPlayerNumbers();
        }
        return input;
    }

    public int readRetryCommands(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try{
            return Integer.parseInt(readLine());
        } catch (NumberFormatException error) {
            System.out.println("[ERROR] 유효한 입력값이 아닙니다. 1과 2중 하나의 숫자만 입력해 주십시오.");
            return readRetryCommands();
        }
    }
}
