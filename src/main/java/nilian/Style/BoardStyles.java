package nilian.Style;

public class BoardStyles
{
    private static String choosenBlackCss;

    private static String choosenWhiteCss;


    // Glass-like bright blue for possible moves
    private static final String possibleMoveStyle =
            "-fx-background-color: rgba(0, 147, 255, 0.6);" +
            "-fx-background-radius: 5;" +
            "-fx-border-radius: 5;" +
            "-fx-border-color: rgba(255, 255, 255, 0.5);" +
            "-fx-border-width: 1;" +
            "-fx-effect: dropshadow(three-pass-box, rgba(0,147,255,0.8), 10, 0.7, 0, 0);" +
            "-fx-background-insets: 1;";

    private static final String killStyle =
            "-fx-background-color: rgba(255, 0, 0, 0.6);" +
            "-fx-background-radius: 5;" +
            "-fx-border-radius: 5;" +
            "-fx-border-color: rgba(255, 255, 255, 0.5);" +
            "-fx-border-width: 1;" +
            "-fx-effect: dropshadow(three-pass-box, rgba(255, 0, 0, 0.8), 10, 0.7, 0, 0);" +
            "-fx-background-insets: 1;";


    public static void setStyles(String style, ThemeSelector theme)
    {
        choosenBlackCss = String.format(
                style, theme.blackColor);

        choosenWhiteCss = String.format(
                style, theme.whiteColor);
    }

    public static String getBlackColor()
    {
        return choosenBlackCss;
    }

    public static String getWhiteColor()
    {
        return choosenWhiteCss;
    }

    public static String getPossibleStyle()
    {
        return possibleMoveStyle;
    }

    public static String getKillStyle(){
        return killStyle;
    }
}
