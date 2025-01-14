import java.util.Scanner;

public class Games {

    // Menu lanzador de juegos
    public static void menu(Scanner input) {
        boolean menu = true;
        while (menu) {
            System.out.println();
            System.out.println("╔═══════════════════════════════╗");
            System.out.println("║            JUEGOS             ║");
            System.out.println("╠═══╦═══════════════════════════╣");
            System.out.println("║ 1 ║ 8 Torres                  ║");
            System.out.println("║ 2 ║ 8 Reinas                  ║");
            System.out.println("║ 3 ║ Recorrido del caballo     ║");
            System.out.println("╟───╫───────────────────────────╢");
            System.out.println("║ V ║ Volver                    ║");
            System.out.println("╚═══╩═══════════════════════════╝");
            System.out.print("Selecciona un opción: ");

            String option = input.nextLine();
            System.out.println();
            switch (option.toLowerCase()) {
                case "1":
                    EightTowers.loop = true;
                    MatrixEight.clearMatrix(EightTowers.board);
                    EightTowers.game(input);
                    break;

                case "2":
                    EightQueens.loop = true;
                    MatrixEight.clearMatrix(EightQueens.board);
                    EightQueens.game(input);
                    break;

                case "3":
                    KnightsTour.loop = true;
                    KnightsTour.firstMove = true;
                    MatrixEight.clearMatrix(KnightsTour.board);
                    KnightsTour.game(input);
                    break;

                case "v":
                    menu = false;
                    break;

                default:
                    System.out.println("\nOpción no válida, por favor intente nuevamente.\n");
            }
        }
    }
}
