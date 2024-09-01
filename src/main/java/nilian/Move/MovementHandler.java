package nilian.Move;

import nilian.board.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MovementHandler
{
    private static List<Coordinate> possibleMoves = new ArrayList<>();
    private static Set<Coordinate> highlightedSquares = new HashSet<>();

    public static void handleClick(ChessSquare square, ChessBoard board)
    {
        if(!possibleMoves.isEmpty())
        {
            System.out.println("###### STATE CLICK :1 : No Square is clicked before");
            if(checkForMovement(square))
            {
                System.out.println("###### STATE CLICK :2: Moving last square to clicked square");
                moveTheLastSquareToDestination();
                possibleMoves.clear();
                turnLights(new HashSet<>(possibleMoves));
            }
            else {
                System.out.println("###### STATE CLICK :3: extracting possible moves");
                possibleMoves.clear();
                possibleMoves = MoveShower.showMoves(square);
                turnLights(new HashSet<>(possibleMoves));
            }
        } else {
            System.out.println("###### STATE CLICK :4: ");
            if(square.getPiece() != Piece.EMPTY && board.whoTurnIsIt() == square.getPieceColor())
            {
                System.out.println("###### STATE CLICK :5");
                possibleMoves.clear();
                possibleMoves = MoveShower.showMoves(square);
                turnLights(new HashSet<>(possibleMoves));
            } else if(square.getPiece() == Piece.EMPTY)
            {
                System.out.println("###### STATE CLICK :6");
                turnEmpty(square.getCoordinate());
                possibleMoves.clear();
            }
        }
        possibleMoves.forEach(e -> System.out.println("Possible move: "+e.toString()));
    }


    private static boolean checkForMovement(ChessSquare destinationSquare)
    {
        if(possibleMoves != null)
        {
            //get the coordinates of destination
            Coordinate theSquareCoordinate = new Coordinate(destinationSquare.getI(), destinationSquare.getJ());
            if(possibleMoves.contains(theSquareCoordinate))
            {
                return true;
            }
        }
        return false ;
    }

    private static void moveTheLastSquareToDestination()
    {
        System.out.println("MOVING");
        //To Do
    }


    private static void turnEmpty(Coordinate cor)
    {
        System.out.println(cor.toString()+" is empty and on");
    }

    private static void turnLights(Set<Coordinate> newPossibleMoves) {
        Set<Coordinate> squaresToTurnOn = new HashSet<>(newPossibleMoves);
        squaresToTurnOn.removeAll(highlightedSquares);

        Set<Coordinate> squaresToTurnOff = new HashSet<>(highlightedSquares);
        squaresToTurnOff.removeAll(newPossibleMoves);

        // Turn off lights
        for (Coordinate coord : squaresToTurnOff) {
            ChessSquare square = BoardMaker.theBoard.getSquare(coord);
            String style;
            // If the sum of row and column is even, it's a white square, otherwise it's black
            if ((coord.i + coord.j) % 2 == 0)
            { style = BoardStyles.getWhiteColor();
            } else {style = BoardStyles.getBlackColor();}
            updateSquareStyle(square, style);
        }

        // Turn on lights
        for (Coordinate cord : squaresToTurnOn) {
            ChessSquare square = BoardMaker.theBoard.getSquare(cord);
            updateSquareStyle(square, BoardStyles.getPossibleStyle());
        }

        // Update the set of highlighted squares
        highlightedSquares = new HashSet<>(newPossibleMoves);
    }

    private static void updateSquareStyle(ChessSquare square, String style) {
        square.setStyle(style);
        square.applyCss();
        square.requestLayout();

        // If needed, uncomment these lines:
        // BoardMaker.chessboard.getChildren().remove(square);
        // BoardMaker.chessboard.add(square, square.getI(), square.getJ());

        // Update the model if necessary
        BoardMaker.theBoard.setSquare(new Coordinate(square.getI(), square.getJ()), square);
    }
}