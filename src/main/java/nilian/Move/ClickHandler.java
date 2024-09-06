package nilian.Move;

import nilian.board.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ClickHandler
{
    private static List<Move> possibleMoves = new ArrayList<>();
    private static ChessSquare lastSquareClicked;

    public static void handleClick(ChessSquare square, ChessBoard board)
    {
        if(!possibleMoves.isEmpty())
        {
            //Check for movement
            if(PieceMover.checkForMovement(square))
            {
                //moving the square
                LightHandler.turnMoveLightsOff();
                PieceMover.move(lastSquareClicked, new Coordinate(square.getI(), square.getJ()));
                clearPossibleMoves();
                LightHandler.turnLights(new HashSet<>(possibleMoves));
                LightHandler.turnMoveLightsOn(lastSquareClicked, square.getCoordinate());
                lastSquareClicked = null ;
            }
            //check for showing possible moves
            else if(square.getPieceColor() == board.whoTurnIsIt()) {
                clearPossibleMoves();
                possibleMoves = MoveShower.showMoves(square);
                LightHandler.turnLights(new HashSet<>(possibleMoves));
                lastSquareClicked = square ;
            }
            //EMPTY CLICKED
            else if(square.getPiece() == Piece.EMPTY)
            {
                clearPossibleMoves();
                LightHandler.turnLights(new HashSet<>(possibleMoves));
                LightHandler.turnEmpty(square.getCoordinate());
                clearPossibleMoves();
                lastSquareClicked = null;
            }
        } else {
            //check for show possible moves
            if(square.getPiece() != Piece.EMPTY && board.whoTurnIsIt() == square.getPieceColor())
            {
                clearPossibleMoves();
                possibleMoves = MoveShower.showMoves(square);
                LightHandler.turnLights(new HashSet<>(possibleMoves));
                lastSquareClicked = square;
            //check for empty click
            } else if(square.getPiece() == Piece.EMPTY)
            {
                LightHandler.turnEmpty(square.getCoordinate());
                clearPossibleMoves();
                lastSquareClicked = null;
            }
        }
    }

    private static void clearPossibleMoves()
    {
        if(!possibleMoves.isEmpty())
        {
            possibleMoves.clear();
        }
    }

    public static List<Move> getPossibleMoves() {
        return possibleMoves;
    }
}