package nilian.Move;

import nilian.board.ChessSquare;

import java.util.List;

public class MovementHandler
{
    private static boolean isSomeSquareClicked ;
    private static ChessSquare lastSquareClicked;
    private static List<Coordinate> lastSquarePossibleMovements ;


    public static void handleClick(ChessSquare square)
    {
        if(lastSquareClicked == null)
        {
            lastSquareClicked = square ;
            lastSquarePossibleMovements = MoveShower.showMoves(square);
        } else
        {
            //check if the last square can come to the clicked point
            checkForMovement(square);
        }
    }


    private static void checkForMovement(ChessSquare destinationSquare)
    {
        if(lastSquarePossibleMovements != null)
        {
            //get the coordinates of destination
            Coordinate theSquareCoordinate = new Coordinate(destinationSquare.getI(), destinationSquare.getJ());
            if(lastSquarePossibleMovements.contains(theSquareCoordinate))
            {
                moveTheLastSquareToDestination();
            }
        }
    }

    private static void moveTheLastSquareToDestination()
    {
        //To Do
    }

}
