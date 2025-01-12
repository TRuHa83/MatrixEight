import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int row = 8;
    public static int col = 8;
    private static int[][] board = new int[row][col];
    private static final int[] count = new int[2];
    public static boolean cheats = false;

    public static void printPretty(int[][] matriz) {
        int row = matriz.length * 2;
        int col = matriz[0].length + 2;
        for (int r = 0; r < row + 2; r++) {
            for (int c = 0; c < col - 1; c++) {
                if (r == 0) {
                    if (c == 0) {
                        System.out.print("    ");
                    } else {
                        System.out.printf("%s   ", c);
                        if (matriz[0].length == 1) {
                            System.out.print("\b\b\b\b");
                            System.out.print("    ");
                        }
                    }

                } else if (r == 1) {
                    if (c == 0) {
                        System.out.print("  ┌─");
                    } else if (c == col - 2) {
                        System.out.print("──┐ ");
                    } else {
                        System.out.print("──┬─");

                    }

                } else if (r % 2 == 0) {
                    if (c == 0) {
                        char letter = (char) (r / 2 + 96);
                        System.out.printf("%s │ ", letter);
                        if (matriz.length == 1) {
                            System.out.print("\b\b\b\b");
                            System.out.print("  │ ");
                        }

                    } else {
                        String value = " ";
                        if (matriz[r / 2 - 1][c - 1] == 1) value = "█";
                        if (matriz[r / 2 - 1][c - 1] == 2) value = "♜";
                        if (matriz[r / 2 - 1][c - 1] == 3) value = "♛";
                        if (matriz[r / 2 - 1][c - 1] == 4) value = "♞";
                        if (matriz[r / 2 - 1][c - 1] == 5) value = "♘";
                        if (cheats) if (matriz[r / 2 - 1][c - 1] == 9) value = "░";
                        System.out.printf("%s │ ", value);

                        if (matriz.length == 1) {
                            int base = matriz[0][c - 1];
                            System.out.print("\b\b\b\b\b");
                            if (base < 10) {
                                System.out.printf(" %s │ ", base);

                            } else if (base < 100){
                                System.out.printf("%s │ ", base);

                            } else {
                                System.out.printf("%s│ ", base);

                            }

                        }

                        if (matriz[0].length == 1) {
                            int base = matriz[r/2-1][0];
                            System.out.print("\b\b\b\b\b");
                            if (base < 10) {
                                System.out.printf(" %s │ ", base);

                            } else if (base < 100){
                                System.out.printf("%s │ ", base);

                            } else {
                                System.out.printf("%s│ ", base);

                            }

                        }
                    }

                } else if (r == row + 1) {
                    if (c == 0) {
                        System.out.print("  └─");
                    } else if (c == col - 2) {
                        System.out.print("──┘ ");
                    } else {
                        System.out.print("──┴─");
                    }

                } else {
                    if (c == 0) {
                        System.out.print("  ├─");
                    } else if (c == col - 2) {
                        System.out.print("──┤ ");
                    } else {
                        System.out.print("──┼─");
                    }
                }
            }
            System.out.println();
        }
    }

    private static void genMatrix() {
        Random num = new Random();
        for (int f = 0; f < board.length; f++) {
            for (int c = 0; c < board[f].length; c++) {
                board[f][c] = num.nextInt(2);

            }
        }

    }

    private static void invertMatrix(){
        for (int f = 0; f < board.length; f++) {
            for (int c = 0; c < board[f].length; c++) {
                int value = board[f][c];
                if (value == 1) {
                    board[f][c] = 0;

                } else {
                    board[f][c] = 1;

                }

            }
        }
    }

    public static void clearMatrix(int[][] matriz) {
        for (int[] row : matriz) {
            for (int c = 0; c < row.length; c++) {
                row[c] = 0;
            }
        }
    }

    private static void countNum(int value) {
        count[value] = 0;

        for (int[] row : board) {
            for (int col : row) {
                if (col == value) {
                    count[value]++;
                }
            }
        }

        String text = "ceros";
        String num = Integer.toString(count[value]);

        System.out.print("Actualmente ");

        if (num.equals("0")) {
            System.out.print("no hay ");
            num = "";

        } else {
            System.out.printf("hay %s ", num);
        }

        if (value == 1) text = "unos";
        System.out.printf("%s en la matriz\n", text);
    }

    private static void rowBase() {
        int[][] rowbase = new int[1][board.length];
        for (int i = 0; i < rowbase[0].length; i++) rowbase[0][i] = 0;

        for (int r = 0; r < board.length; r++) {
            String data = "";
            for (int c = 0; c < board[r].length; c++) {
                data += board[r][c];
            }
            rowbase[0][r] = Integer.parseInt(data, 2);
        }

        printPretty(rowbase);
    }

    private static void columnBase() {
        int[][] colbase = new int[board.length][1];
        for (int i = 0; i < colbase.length; i++) {
            colbase[i][0] = 0;
        }

        for (int r = 0; r < board.length; r++) {
            String data = "";
            for (int c = 0; c < board[r].length; c++) {
                data += board[r][c];
            }
            colbase[r][0] = Integer.parseInt(data, 2);
        }

        printPretty(colbase);
    }

    public static void presskey(Scanner input) {
        System.out.println("\nPresiona [ENTER] para continuar...");
        input.nextLine();
    }

    private static void resize() {
        if (board.length != row) {
            board = new int[row][col];
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);

        boolean menu = true;
        while (menu) {
            // Mostrar menú
            resize();
            System.out.println();
            System.out.println("╔═══════════════════════════════╗");
            System.out.printf("║          MATRIZ %sx%s           ║\n", row, col);
            System.out.println("╠═══╦═══════════════════════════╣");
            System.out.println("║ 1 ║ Mostrar matriz            ║");
            System.out.println("╟───╫                           ╢");
            System.out.println("║ 2 ║ Generar matriz aleatorio  ║");
            System.out.println("║ 3 ║ Invertir matriz           ║");
            System.out.println("║ 4 ║ Vaciar matriz             ║");
            System.out.println("╟───╫                           ╢");
            System.out.println("║ 5 ║ Contar cuantos 0 hay      ║");
            System.out.println("║ 6 ║ Contar cuantos 1 hay      ║");
            System.out.println("╟───╫                           ╢");
            System.out.println("║ 7 ║ Filas en base 10          ║");
            System.out.println("║ 8 ║ Columnas en base 10       ║");
            System.out.println("╟───╫                           ╢");
            System.out.println("║ 9 ║ juegos                    ║");
            System.out.println("╟───╫────────────╥───╥──────────╢");
            System.out.println("║ Q ║ Salir      ║ O ║ Opciones ║");
            System.out.println("╚═══╩════════════╩═══╩══════════╝");
            System.out.print("Selecciona un opción: ");

            String option = input.nextLine();
            System.out.println();

            switch (option.toLowerCase()) {
                case "1":
                    printPretty(board);
                    presskey(input);
                    break;

                case "2":
                    genMatrix();
                    printPretty(board);
                    presskey(input);
                    break;

                case "3":
                    invertMatrix();
                    printPretty(board);
                    presskey(input);
                    break;

                case "4":
                    clearMatrix(board);
                    printPretty(board);
                    presskey(input);
                    break;

                case "5":
                    printPretty(board);
                    countNum(0);
                    presskey(input);
                    break;

                case "6":
                    printPretty(board);
                    countNum(1);
                    presskey(input);
                    break;

                case "7":
                    rowBase();
                    presskey(input);
                    break;

                case "8":
                    columnBase();
                    presskey(input);
                    break;

                case "9":
                    Games.menu(input);
                    break;

                case "o":
                    Options.menu(input);
                    break;

                case "q":
                    input.close();
                    menu = false;
                    break;

                default:
                    System.out.println("\nOpción no válida, por favor intente nuevamente.\n");
            }
        }
        System.out.println("Hasta luego :)\n");
    }
}

