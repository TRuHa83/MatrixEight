import java.util.Scanner;

public class KnightsTour {
    public static final int[][] board = new int[8][8];
    private static final int[] move = {0, 0};
    public static boolean loop = true;
    private static boolean firstMove = true;

    private static void addMove() {
        int row = move[0];
        int col = move[1];

        for (int[] r : board) {
            for (int c = 0; c < r.length; c++) {
                if (r[c] == 9) r[c] = 0;
            }
        }

        int[] pos1 = {row-2, col+1};
        int[] pos2 = {row-2, col-1};
        int[] pos3 = {row+2, col+1};
        int[] pos4 = {row+2, col-1};
        int[] pos5 = {row-1, col+2};
        int[] pos6 = {row+1, col+2};
        int[] pos7 = {row-1, col-2};
        int[] pos8 = {row+1, col-2};

        if (pos1[0] >= 0 && pos1[0] < board.length && pos1[1] >= 0 && pos1[1] < board.length) {
            if (board[pos1[0]][pos1[1]] != 4) board[pos1[0]][pos1[1]] = 9;
        }
        if (pos2[0] >= 0 && pos2[0] < board.length && pos2[1] >= 0 && pos2[1] < board.length) {
            if (board[pos2[0]][pos2[1]] != 4) board[pos2[0]][pos2[1]] = 9;
        }
        if (pos3[0] >= 0 && pos3[0] < board.length && pos3[1] >= 0 && pos3[1] < board.length) {
            if (board[pos3[0]][pos3[1]] != 4) board[pos3[0]][pos3[1]] = 9;
        }
        if (pos4[0] >= 0 && pos4[0] < board.length && pos4[1] >= 0 && pos4[1] < board.length) {
            if (board[pos4[0]][pos4[1]] != 4) board[pos4[0]][pos4[1]] = 9;
        }
        if (pos5[0] >= 0 && pos5[0] < board.length && pos5[1] >= 0 && pos5[1] < board.length) {
            if (board[pos5[0]][pos5[1]] != 4) board[pos5[0]][pos5[1]] = 9;
        }
        if (pos6[0] >= 0 && pos6[0] < board.length && pos6[1] >= 0 && pos6[1] < board.length) {
            if (board[pos6[0]][pos6[1]] != 4) board[pos6[0]][pos6[1]] = 9;
        }
        if (pos7[0] >= 0 && pos7[0] < board.length && pos7[1] >= 0 && pos7[1] < board.length) {
            if (board[pos7[0]][pos7[1]] != 4) board[pos7[0]][pos7[1]] = 9;
        }
        if (pos8[0] >= 0 && pos8[0] < board.length && pos8[1] >= 0 && pos8[1] < board.length) {
            if (board[pos8[0]][pos8[1]] != 4) board[pos8[0]][pos8[1]] = 9;
        }

        board[row][col] = 4;
    }

    private static boolean validate(String value) {
        try {
            move[0] = value.charAt(0) - 97;
            move[1] = value.charAt(1) - 49;

            if (board[move[0]][move[1]] != 9 && !firstMove) return false;

            firstMove = false;
            return move[0] < 8 && move[1] < 8;

        } catch (Exception e) {
            return false;
        }
    }

    private static void countMoves() {
        int horse = 0;
        int nine = 0;

        for (int[] row : board) {
            for (int col : row) {
                if (col == 4) {
                    horse++;
                }

                if (col == 9) {
                    nine++;
                }

            }
        }

        if (horse == 64) {
            loop = false;
            Main.printPretty(board);
            System.out.println("ENHORABUENA, HAS GANADO!!");
            System.out.println("Otro juego?");

        } else if (nine == 0) {
            loop = false;
            Main.printPretty(board);
            System.out.println("OOOHHH!! NO QUEDAN MAS MOVIMIENTOS");
            System.out.printf("Has conseguido un poner total de %s caballos\n", horse);
            System.out.println("Otro juego?");

        }

    }

    public static void game(Scanner input) {
        while (loop) {
            Main.printPretty(board);
            System.out.println("[Q] para salir.");
            System.out.print("introduce coordenadas: ");
            String select = input.nextLine().toLowerCase();
            System.out.println();

            if (validate(select)) {
                addMove();
                countMoves();

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