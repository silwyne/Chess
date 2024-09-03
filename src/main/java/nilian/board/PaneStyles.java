package nilian.board;

public class PaneStyles
{
    // Classic Chess Square Style
    private static String classicSquareStyle =
            "-fx-background-color: %s;" +
                    "-fx-border-color: #000000;" +
                    "-fx-border-width: 1;";

    // Wooden Chess Square Style
    private static String woodenSquareStyle =
            "-fx-background-color: %s;" +
                    "-fx-background-image: url('wood-texture.png');" +
                    "-fx-background-size: cover;" +
                    "-fx-border-color: #8B4513;" +
                    "-fx-border-width: 1;";

    // Marble Chess Square Style
    private static String marbleSquareStyle =
            "-fx-background-color: %s;" +
                    "-fx-background-image: url('marble-texture.png');" +
                    "-fx-background-size: cover;" +
                    "-fx-border-color: #A9A9A9;" +
                    "-fx-border-width: 1;";

    // Modern Minimalist Chess Square Style
    private static String modernSquareStyle =
            "-fx-background-color: %s;" +
                    "-fx-background-radius: 5;" +
                    "-fx-border-radius: 5;" +
                    "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 5, 0, 0, 1);";

    // Metallic Chess Square Style
    private static String metallicSquareStyle =
            "-fx-background-color: linear-gradient(to bottom right, %1$s, derive(%1$s, -20%%));" +
                    "-fx-background-radius: 2;" +
                    "-fx-border-color: derive(%1$s, -30%%);" +
                    "-fx-border-width: 1;" +
                    "-fx-border-radius: 2;" +
                    "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 3, 0, 0, 1);";

    // Neon Chess Square Style
    private static String neonSquareStyle =
            "-fx-background-color: %s;" +
                    "-fx-background-radius: 0;" +
                    "-fx-border-color: derive(%s, 50%%);" +
                    "-fx-border-width: 1;" +
                    "-fx-effect: dropshadow(gaussian, derive(%s, 90%%), 10, 0.5, 0, 0);";

    // Frosted Glass Chess Square Style
    private static String frostedGlassSquareStyle =
            "-fx-background-color: rgba(%d, %d, %d, 0.3);" +
                    "-fx-background-radius: 5;" +
                    "-fx-border-radius: 5;" +
                    "-fx-border-color: rgba(255, 255, 255, 0.5);" +
                    "-fx-border-width: 1;" +
                    "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0.1, 0, 1);" +
                    "-fx-background-insets: 1;";

    public static String getStyle(String colorCode)
    {
        // example: colorCode = "#FFFFFF" or "#000000"
        String style = String.format(frostedGlassSquareStyle, colorCode);
        return style ;
    }
}
