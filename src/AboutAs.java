public class AboutAs {
    public static void show() throws InterruptedException {
        String credits = """
                ***********************
                      MatrixEight
                ***********************
                \s
                Desarrollado por:
                  - Sergio Trujillo de la Nuez
                    (GitHub: TRuHa83)
                
                Repositorio:
                  - https://github.com/TRuHa83/MatrixEight
                
                Agradecimientos especiales
                  - Carlos Ramírez Rey
                
                Versión: 1.0.0
                Fecha: Diciembre 2024
                \s
                ¡GRACIAS POR USAR ESTE PROGRAMA! :)
                """;

        for (char letter : credits.toCharArray()) {
            System.out.print(letter);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
