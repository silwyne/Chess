package nilian.Move;

import nilian.board.ChessSquare;

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
            lastSquareClicked = square ;
            possibleMoves = MoveShower.showMoves(square);
        } else //normal days
        {
            possibleMoves = MoveShower.showMoves(square);
        }

        possibleMoves
                .forEach( e -> System.out.println(e.toString()));
        possibleMoves.clear();
        possibleMoves = new ArrayList<>();
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

}
