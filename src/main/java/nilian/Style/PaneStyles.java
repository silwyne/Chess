package nilian.Style;

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
            "-fx-background-size: cover;" +
            "-fx-border-color: #8B4513;" +
            "-fx-border-width: 1;";

    // Marble Chess Square Style
    private static String marbleSquareStyle =
            "-fx-background-color: %s;" +
            "-fx-background-size: cover;" +
            "-fx-border-color: #A9A9A9;" +
            "-fx-border-width: 1;";

    // Modern Minimalist Chess Square Style
    private static String modernSquareStyle =
            "-fx-background-color: %s;" +
            "-fx-background-radius: 5;" +
            "-fx-border-radius: 5;" +
            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 5, 0, 0, 1);";

    // Frosted Glass Chess Square Style
    private static String frostedGlassSquareStyle =
            "-fx-background-color: %s;" +
            "-fx-background-radius: 5;" +
            "-fx-border-radius: 5;" +
            "-fx-border-color: rgba(255, 255, 255, 0.5);" +
            "-fx-border-width: 1;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 10, 0.1, 0, 1);" +
            "-fx-background-insets: 1;";

    public static String getStyleCss(String styleFrame)
    {
        StyleName style = StyleName.valueOf(styleFrame);
        if(style == StyleName.MARBLE)
        {
            return marbleSquareStyle;

        }else if(style == StyleName.CLASSIC)
        {
            return classicSquareStyle;

        }else if(style == StyleName.FROSTED_GLASS)
        {
            return frostedGlassSquareStyle;

        }else if(style == StyleName.MODERN)
        {
            return modernSquareStyle;

        }else if(style == StyleName.WOODEN)
        {
            return woodenSquareStyle;
        }
        return "shit";
    }
}
