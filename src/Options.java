import java.util.Scanner;

public class Options {
    private static boolean eight = true;
    private static boolean six = false;
    private static boolean four = false;
    private static boolean two = false;
    private static boolean cheats = false;

    private static void resize(int length) {
        Main.row = length;
        Main.col = length;
    }

    private static void Setup(int option) {
        int length = Main.row;
        if (length != option){
            eight = false;
            six = false;
            four = false;
            two = false;

            switch (option) {
                case 2:
                    two = true;
                    resize(option);
                    break;

                case 4:
                    four = true;
                    resize(option);
                    break;

                case 6:
                    six = true;
                    resize(option);
                    break;

                case 8:
                    eight = true;
                    resize(option);
                    break;
            }
        }
    }

    private static void Cheats(){
        cheats = !cheats;
        Main.cheats = cheats;
    }

    private static String arrow(boolean value) {
        String text = " ";
        if (value) text = "✔";
        return text;
    }

    public static void menu(Scanner input) throws InterruptedException {
        boolean menu = true;
        while (menu) {
            // Mostrar menú
            Setup(Main.row);
            System.out.println();
            System.out.println("╔═══════════════════════════════╗");
            System.out.println("║           Opciones            ║");
            System.out.println("╠═══╦═══════════════════════╦═══╣");
            System.out.printf("║ 2 ║ Matriz 2x2            ║ %s ║\n", arrow(two));
            System.out.printf("║ 4 ║ Matriz 4x4            ║ %s ║\n", arrow(four));
            System.out.printf("║ 6 ║ Matriz 6x6            ║ %s ║\n", arrow(six));
            System.out.printf("║ 8 ║ Matriz 8x8            ║ %s ║\n", arrow(eight));
            System.out.println("╟───╫                       ║   ╢");
            System.out.printf("║ C ║ Ayuda en juegos       ║ %s ║\n", arrow(cheats));
            System.out.println("╟───╫                       ║   ╢");
            System.out.println("║ A ║ Acerca de...          ║   ║");
            System.out.println("╟───╫───────────────────────╨───╢");
            System.out.println("║ V ║ Volver                    ║");
            System.out.println("╚═══╩═══════════════════════════╝");
            System.out.print("Selecciona un opción: ");

            String option = input.nextLine();
            System.out.println();

            switch (option.toLowerCase()) {
                case "8":
                    Setup(8);
                    break;

                case "6":
                    Setup(6);
                    break;

                case "4":
                    Setup(4);
                    break;

                case "2":
                    Setup(2);
                    break;

                case "c":
                    Cheats();
                    break;

                case "a":
                    AboutAs.show();
                    Main.presskey(input);
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
