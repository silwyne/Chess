package nilian.Move;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import nilian.board.*;

import java.util.ArrayList;
import java.util.List;

public class MovementHandler
{
    private static boolean isSomeSquareClicked ;
    private static ChessSquare lastSquareClicked;
    private static List<Coordinate> possibleMoves ;


    public static void handleClick(ChessSquare square)
    {
        if(lastSquareClicked == null)//first time clicking on anything
        {
            isSomeSquareClicked = true;
            lastSquareClicked = square ;
            possibleMoves = MoveShower.showMoves(square);
            turnLights(true);
        } else //normal days
        {
            if(isSomeSquareClicked)
            {
                isSomeSquareClicked = false ;
                turnLights(false);
                checkForMovement(square);
                possibleMoves.clear();
                possibleMoves = new ArrayList<>();
            } else
            {
                isSomeSquareClicked = true ;
                possibleMoves = MoveShower.showMoves(square);
                turnLights(true);
            }
        }

        possibleMoves
                .forEach( e -> System.out.println(e.toString()));
    }


    private static void checkForMovement(ChessSquare destinationSquare)
    {
        if(possibleMoves != null)
        {
            //get the coordinates of destination
            Coordinate theSquareCoordinate = new Coordinate(destinationSquare.getI(), destinationSquare.getJ());
            if(possibleMoves.contains(theSquareCoordinate))
            {
                moveTheLastSquareToDestination();
            }
        }
    }

    private static void moveTheLastSquareToDestination()
    {
        System.out.println("MOVING");
        //To Do
    }

    private static void turnLights(boolean isLightsOn)
    {
        Coordinate lightCord ;
        for (Coordinate possibleMove : possibleMoves) {
            //get the coordinates
            lightCord = possibleMove;
            //first form the board
            ChessSquare square = BoardMaker.theBoard.getSquare(lightCord);

            ChessSquare newSquare = square ;
            // special style
            String style;
            if (isLightsOn)
            {//turn them off
                System.out.println("TURNING LIGHTS ON");
                style = BoardStyles.getPossibleStyle();
                isLightsOn = false;
            } else
            {//turn them on
                System.out.println("TURNING LIGHTS OFF");
                style = (square.getSquareColor() == Color.WHITE) ^ ((lightCord.i + lightCord.j) % 2 == 0) ?
                        BoardStyles.getBlackColor() : BoardStyles.getWhiteColor();
                isLightsOn = true;
            }
            square.setStyle(style);

            //replacing the old one
            replaceNode(square, newSquare, square.getI(), square.getJ());
            //setting the new square back to place
            BoardMaker.theBoard.setSquare(lightCord, newSquare);
        }
    }

    private static void replaceNode(Node oldNode, Node newNode, int col , int row) {
        BoardMaker.chessboard.getChildren().remove(oldNode);
        // Add the new node
        BoardMaker.chessboard.add(newNode, col, row);
    }

}
