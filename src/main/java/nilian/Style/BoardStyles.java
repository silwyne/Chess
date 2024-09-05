package nilian.Style;

import nilian.board.Color;

public class BoardStyles
{
    private static String choosenBlackCss;

    private static String choosenWhiteCss;


    // Glass-like bright blue for possible moves
    private static final String darkPossibleMoveStyle =
            "-fx-background-color: rgba(0, 147, 255, 0.6);" +
            "-fx-background-radius: 5;" +
            "-fx-border-radius: 5;" +
            "-fx-border-color: rgba(255, 255, 255, 0.5);" +
            "-fx-border-width: 1;" +
            "-fx-effect: dropshadow(three-pass-box, rgba(0,147,255,0.8), 10, 0.7, 0, 0);" +
            "-fx-background-insets: 1;";

    private static final String lightPossibleMoveStyle =
            "-fx-background-color: rgba(0, 237, 255, 0.6);" +
            "-fx-background-radius: 5;" +
            "-fx-border-radius: 5;" +
            "-fx-border-color: rgba(255, 255, 255, 0.5);" +
            "-fx-border-width: 1;" +
            "-fx-effect: dropshadow(three-pass-box, rgba(0,237,255,0.8), 10, 0.7, 0, 0);" +
            "-fx-background-insets: 1;";

    private static final String lightKillStyle =
            "-fx-background-color: rgba(255, 0, 255, 0.6);" +
            "-fx-background-radius: 5;" +
            "-fx-border-radius: 5;" +
            "-fx-border-color: rgba(255, 255, 255, 0.5);" +
            "-fx-border-width: 1;" +
            "-fx-effect: dropshadow(three-pass-box, rgba(255, 0, 255, 0.8), 10, 0.7, 0, 0);" +
            "-fx-background-insets: 1;";


    private static final String darkKillStyle =
            "-fx-background-color: rgba(255, 0, 0, 0.6);" +
            "-fx-background-radius: 5;" +
            "-fx-border-radius: 5;" +
            "-fx-border-color: rgba(255, 255, 255, 0.5);" +
            "-fx-border-width: 1;" +
            "-fx-effect: dropshadow(three-pass-box, rgba(255, 0, 0, 0.8), 10, 0.7, 0, 0);" +
            "-fx-background-insets: 1;";

    private static final String checkStyle =
            "-fx-background-color: rgba(252, 250, 42, 0.6);" +
            "-fx-background-radius: 5;" +
            "-fx-border-radius: 5;" +
            "-fx-border-color: rgba(255, 255, 255, 0.5);" +
            "-fx-border-width: 1;" +
            "-fx-effect: dropshadow(three-pass-box, rgba(252, 250, 42, 0.8), 10, 0.7, 0, 0);" +
            "-fx-background-insets: 1;";

    private static final String emptyStyle =
            "-fx-background-color: rgba(51, 253, 189, 0.6);" +
            "-fx-background-radius: 5;" +
            "-fx-border-radius: 5;" +
            "-fx-border-color: rgba(255, 255, 255, 0.5);" +
            "-fx-border-width: 1;" +
            "-fx-effect: dropshadow(three-pass-box, rgba(51, 253, 189, 0.8), 10, 0.7, 0, 0);" +
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

    public static String getPossibleStyle(Color color)
    {
        if(color == Color.BLACK)
        {
            return darkPossibleMoveStyle;
        }
        return lightPossibleMoveStyle;
    }

    public static String getKillStyle(Color color)
    {
        if(color == Color.BLACK)
        {
            return darkKillStyle;
        }
        return lightKillStyle;
    }

    public static String getCheckStyle()
    {
        return checkStyle;
    }

    public static String getEmptyStyle()
    {
        return emptyStyle;
    }
}
