import java.util.Random;

public class AboutAs {
    // Muestra los créditos
    public static void show() throws InterruptedException {
        String credits = """
                ***********************
                      MatrixEight
                ***********************
                \s
                Desarrollado por:
                  - Sergio Trujillo de la Nuez
                    (GitHub: TRuHa83)
                \s
                Repositorio:
                  - https://github.com/TRuHa83/MatrixEight
                \s
                Agradecimientos especiales
                  - Carlos Ramírez Rey
                \s
                Versión: 1.2.2
                Fecha: Enero 2025
                \s
                ¡GRACIAS POR USAR ESTE PROGRAMA! :)
                """;

        Random sleep = new Random();
        for (char letter : credits.toCharArray()) {
            System.out.print(letter);

            try {
                Thread.sleep(sleep.nextInt(50, 250));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
