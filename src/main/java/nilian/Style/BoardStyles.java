package nilian.Style;

public class BoardStyles
{
    // Glass-like dark brown for black squares
    private static String blackStyle_1 =
            "-fx-background-color: rgba(139, 69, 19, 0.7);" +
                    "-fx-background-radius: 5;" +
                    "-fx-border-radius: 5;" +
                    "-fx-border-color: rgba(255, 255, 255, 0.3);" +
                    "-fx-border-width: 1;" +
                    "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0.0, 0, 1);" +
                    "-fx-background-insets: 1;";

    // Glass-like light wheat for white squares
    private static String whiteStyle_1 =
            "-fx-background-color: rgba(245, 222, 179, 0.7);" +
                    "-fx-background-radius: 5;" +
                    "-fx-border-radius: 5;" +
                    "-fx-border-color: rgba(255, 255, 255, 0.5);" +
                    "-fx-border-width: 1;" +
                    "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 5, 0.0, 0, 1);" +
                    "-fx-background-insets: 1;";

    // Glass-like bright blue for possible moves
    private static String brightBlueStyle =
            "-fx-background-color: rgba(0, 147, 255, 0.6);" +
                    "-fx-background-radius: 5;" +
                    "-fx-border-radius: 5;" +
                    "-fx-border-color: rgba(255, 255, 255, 0.5);" +
                    "-fx-border-width: 1;" +
                    "-fx-effect: dropshadow(three-pass-box, rgba(0,147,255,0.8), 10, 0.7, 0, 0);" +
                    "-fx-background-insets: 1;";



    public static String getBlackColor()
    {
        return blackStyle_1;
    }

    public static String getWhiteColor()
    {
        return whiteStyle_1;
    }

    public static String getPossibleStyle()
    {
        return brightBlueStyle;
    }
}
