package nilian.Window;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import nilian.board.BoardMaker;
import nilian.board.Color;
import nilian.board.SizeEntity;


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
        Scene starterScene = StarterSceneProvider.getScene();
        mainStage.setScene(starterScene);
        mainStage.show();
    }

    public static void setChessScene()
    {
        //getting the chess board
        if(chessBoard == null)
        {
            try {
                chessBoard = BoardMaker.getInitialBoard(Color.WHITE);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        //getting other stuff
        HBox hbox = new HBox();
        hbox.getChildren().add(chessBoard);
        Scene scene = new Scene(hbox, SizeEntity.GameWindow_width, SizeEntity.GameWindow_height);
        mainStage.setScene(scene);
    }
}
