package nilian;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import nilian.Pieces.PiecesImages;
import nilian.board.BoardMaker;
import nilian.board.Color;
import nilian.Pieces.ImageExtractor;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane chessBoard = BoardMaker.getInitialBoard(Color.WHITE);
        Scene scene = new Scene(chessBoard, 640, 640);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) throws IOException {
        ImageExtractor setExtractor = new ImageExtractor("/PeicesSets/set_3.png");
        List<BufferedImage> pieces = setExtractor.extractPiecesFromImageSet();
        PiecesImages.setPieces(pieces);
        launch(args);
    }
}