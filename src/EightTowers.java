import java.util.Scanner;

public class EightTowers {
    public static final int[][] board = new int[8][8];
    private static final int[] move = {0,0};
    public static boolean loop = true;
    private static String select;
    private static int count = 0;

    private static void addMove() {
        for (int r = 0; r < board[0].length; r++) {
            board[move[0]][r] = 9;
            board[r][move[1]] = 9;
        }

        board[move[0]][move[1]] = 2;
    }

    private static boolean validate(String value) {
        try {
            move[0] = value.charAt(0) - 97;
            move[1] = value.charAt(1) - 49;

            if (board[move[0]][move[1]] != 0) return false;

            return move[0] < 8 && move[1] < 8;

        } catch (Exception e) {
            return false;
        }
    }

    private static void countEight() {
        count = 0;
        for (int[] row : board) {
            for (int col : row) {
                if (col == 2) {
                    count++;
                }
            }
        }

        if (count == 8) {
            loop = false;
            System.out.println("ENHORABUENA, HAS GANADO!!");
            System.out.println("Otro juego?");
        }

    }

    public static void game(Scanner input) {
        while (loop) {
            Main.printPretty(board);
            System.out.println("[Q] para salir.");
            System.out.print("introduce coordenadas: ");
            select = input.nextLine().toLowerCase();
            System.out.println();

            if (validate(select)) {
                addMove();
                countEight();

            } else {
                if (select.equals("q")) {
                    loop = false;
                    System.out.println("Partida terminada, hasta pronto.");

                } else {
                    System.out.println("Movimiento erróneo, vuélvalo a internar.");

                }
                Main.presskey(input);
            }
        }
    }
}
