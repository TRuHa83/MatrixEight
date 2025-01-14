import java.util.Scanner;

public class EightQueens {
    public static final int[][] board = new int[8][8];
    private static final int[] move = {0,0};
    public static boolean loop = true;

    // Define el número del símbolo correspondiente
    private static void addMove() {
        int row = move[0];
        int col = move[1];

        // Marca la fila y columna completa
        for (int r = 0; r < board.length; r++) {
            board[row][r] = 9;
            board[r][col] = 9;

            // Movimiento de la reina
            int[] cor1 = {row-r, col-r};
            int[] cor2 = {row-r, col+r};
            int[] cor3 = {row+r, col-r};
            int[] cor4 = {row+r, col+r};

            // Define el número del símbolo correspondiente
            if (cor1[0] >= 0 && cor1[0] < board.length && cor1[1] >= 0 && cor1[1] < board.length) {
                board[cor1[0]][cor1[1]] = 9;
            }
            if (cor2[0] >= 0 && cor2[0] < board.length && cor2[1] >= 0 && cor2[1] < board.length) {
                board[cor2[0]][cor2[1]] = 9;
            }
            if (cor3[0] >= 0 && cor3[0] < board.length && cor3[1] >= 0 && cor3[1] < board.length) {
                board[cor3[0]][cor3[1]] = 9;
            }
            if (cor4[0] >= 0 && cor4[0] < board.length && cor4[1] >= 0 && cor4[1] < board.length) {
                board[cor4[0]][cor4[1]] = 9;
            }
        }
        board[row][col] = 3;
    }

    // Valida el movimiento seleccionado
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

    // Cuenta el número de reinas y determinar si ha acabado el juego
    private static void countMoves() {
        int eight = 0;
        int zeros = 0;

        for (int[] row : board) {
            for (int col : row) {
                if (col == 3) {
                    eight++;
                }

                if (col == 0) {
                    zeros++;
                }

            }
        }

        if (eight == 8) {
            loop = false;
            Main.printPretty(board);
            System.out.println("ENHORABUENA, HAS GANADO!!");
            System.out.println("Otro juego?");

        } else if (zeros == 0){
            loop = false;
            Main.printPretty(board);
            System.out.println("OOOHHH!! NO QUEDAN MAS MOVIMIENTOS");
            System.out.printf("Has conseguido un total de %s Reinas\n", eight);
            System.out.println("Otro juego?");

        }

    }

    // Loop principal del juego
    public static void game(Scanner input) {
        while (loop) {
            Main.printPretty(board);
            System.out.println("[Q] para salir.");
            System.out.print("Introduce coordenadas: ");
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
