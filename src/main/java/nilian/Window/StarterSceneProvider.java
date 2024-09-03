package nilian.Window;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import nilian.Style.*;

public class StarterSceneProvider
{
    public static Scene getScene()
    {
        ChoiceBox<String> styleBox = new ChoiceBox<>();
        styleBox.getItems().addAll(
        "CLASSIC", "WOODEN", "MARBLE", "MODERN", "FROSTED_GLASS");

        ChoiceBox<String> themeBox = new ChoiceBox<>();
        themeBox.getItems().addAll(
        "CLASSIC_GREEN_AND_WHITE", "BROWN_AND_CREAM", "DARK_WOOD", "ICY_SEA", "MARBLE", "GLASS", "BLUE_AND_GRAY");


        //Default value
        //Note: you must set the Default value to a value that already exists!!
        styleBox.setValue("MODERN");
        themeBox.setValue("BLUE_AND_GRAY");
        //notice on click
        styleBox.getSelectionModel().selectedItemProperty();

        Button confirmation = new Button("confirm");
        confirmation.setOnAction(e ->{
            System.out.println("style is: "+styleBox.getValue());
            System.out.println("black is: "+themeBox.getValue());
            BoardStyles.setStyles(PaneStyles.getStyleCss(styleBox.getValue()), new ThemeSelector(themeBox.getValue()));
            OriginStarter.setChessScene();
        });


        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(styleBox, themeBox, confirmation);
        return new Scene(layout, 300, 250);
    }
}
