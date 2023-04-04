package br.com.bvilela.application;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Application {
    public static void main(String[] args) {
        moveCursor(100);
    }

    private static void moveCursor(int numberMoves) {
        long TIME_BETWEEN_MOVES_IN_SECOND = 30;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int min = 0;
        int maxX = (int) screenSize.getWidth();
        int maxY = (int) screenSize.getHeight();

        try {
            System.out.println("Started...");

            Robot robot = new Robot();

            for (int i = 1; i < numberMoves + 1; i++) {
                Thread.sleep(TIME_BETWEEN_MOVES_IN_SECOND * 1000);

                int x = ThreadLocalRandom.current().nextInt(min, maxX + 1);
                int y = ThreadLocalRandom.current().nextInt(min, maxY + 1);

                System.out.println("Cursor Move: " + i + "/" + numberMoves + " - Coordinates: " + x + "x / " + y + "y");
                robot.mouseMove(x, y);
            }

            System.out.println("Finish!");

        } catch (AWTException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}