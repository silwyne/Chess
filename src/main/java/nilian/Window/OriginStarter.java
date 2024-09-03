package nilian.Window;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import nilian.board.BoardMaker;
import nilian.board.Color;

public class OriginStarter extends Application
{
    static Stage mainStage;
    static GridPane chessBoard;

    public static void runner(String[] mainArgs)
    {
        launch(mainArgs);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //INITIALIZING THE MAIN STAGE
        mainStage = new Stage();
        //GETTING THE STARTER SCENE
//        Scene starterScene = getStarterScene();
        chessBoard = BoardMaker.getInitialBoard(Color.WHITE);
        Scene scene = new Scene(chessBoard, 640, 640);
        mainStage.setScene(scene);
        mainStage.show();
    }

//    private static Scene getStarterScene()
//    {
//
//    }
}
