package nilian.Move;

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
            } else {
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
            //removing the old one
            BoardMaker.chessboard.getChildren().remove(lightCord.i, lightCord.j);
            //adding a new Pane
            BoardMaker.chessboard.getChildren().add(square);
        }
    }

}
