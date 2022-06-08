package ru.gb.bullsandcows;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

//В этом классе описывается логика работы с визуальной частью программы
public class Controller {
    @FXML
    private TextArea historyArea;
    @FXML
    private TextField userAnswer;

    private Game game;
    private int step;
    private final static int WIN_GAME = 4;

    public Controller() {
        this.game = new Game();
    }


    public void clickCheckButton(ActionEvent actionEvent) {
        final String answer = userAnswer.getText();
        if(answer.isBlank()){
            return;
        }

        final Game.BullsAndCows count = game.calculateBullsAndCows(answer);
        String text = String.format("%d. Введено число %s, количество быков %d, количество коров %d", ++step, answer, count.getBulls(), count.getCows());
        historyArea.appendText(text + "\n");
        userAnswer.clear();
        userAnswer.requestFocus();

        if(count.getBulls() == WIN_GAME){
            if(wontToPlayAgain()){
                clickNewGame();
            } else{
                System.exit(0);
            }
        }
    }

    private boolean wontToPlayAgain() {
        final Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Поздравляю, вы выиграли!\n" + game.getGuessNum() + ".\n\n" + "Желаете сыграть еще?",
                new ButtonType("Да", ButtonBar.ButtonData.YES),
                new ButtonType("Нет", ButtonBar.ButtonData.NO));
        alert.setTitle("Поздравляю");
        ButtonType answer = alert.showAndWait().get();
        return answer.getButtonData() == ButtonBar.ButtonData.YES;
    }

    public void clickNewGame() {
        step = 0;
        historyArea.appendText("\n\n--- Начинаем новую игру! ---\n");
        this.game = new Game();
    }

    public void clickExitGame(ActionEvent actionEvent) {
        System.exit(0);
    }
}