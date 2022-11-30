package baseball.controller;

import baseball.service.Service;
import baseball.utils.NumberListGenerator;
import baseball.utils.RandomNumberListGenerator;

public class Controller {
    private static final Service service = new Service();
    private static final NumberListGenerator numberListGenerator = new RandomNumberListGenerator();

    public void run(){
        initGame();
    }

    private void initGame(){
        service.setComputerNumbers(numberListGenerator);
    }
}
