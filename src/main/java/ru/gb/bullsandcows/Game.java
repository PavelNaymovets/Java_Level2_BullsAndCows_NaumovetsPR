package ru.gb.bullsandcows;

//В этом классе описывается логика работы самой программы. В данном случае игры

import java.util.*;

public class Game {
    /*
        4 6 1 0 - Загаданное число. Число состоит из 4 цифр. Цифры не должны повторяться.
        1 6 3 4 - Введенное пользователем число.
        к б   к
        Корова - угадана цифра без точного расположения в числе.
        Бык - угаданы и цифра и точное расположение этой цифры в числе.
        В данном примере 2 коровы и 1 бык.
    */

    public static class BullsAndCows{

        private final int bulls;
        private final int cows;
        public BullsAndCows(int bulls, int cows) {
            this.bulls = bulls;
            this.cows = cows;
        }

        public int getBulls() {
            return bulls;
        }

        public int getCows() {
            return cows;
        }
    }
    private final int[] guessNum;
    public Game() {
        this.guessNum = generateNumber();
        System.out.println(Arrays.toString(guessNum));
    }

    public String getGuessNum(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < guessNum.length; i++) {
            str.append(guessNum[i]);
        }
        return str.toString();
    }

    public BullsAndCows calculateBullsAndCows(String playerNum) {
        int bulls = 0, cows = 0;
        for (int i = 0; i < 4; i++) {
            if (guessNum[i] == playerNum.charAt(i) - '0') {
                bulls++;
            } else if (playerNum.contains(String.valueOf(guessNum[i]))) {
                cows++;
            }
        }
        return new BullsAndCows(bulls, cows);
    }

    private int[] generateNumber() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(numbers);
        return new int[]{numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(3)};
    }
}
