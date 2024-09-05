package nilian.Move;

import nilian.Style.BoardStyles;
import nilian.board.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClickHandler
{
    private static List<Move> possibleMoves = new ArrayList<>();
    private static Set<Move> highlightedSquares = new HashSet<>();
    private static Coordinate emptyLight ;
    private static Coordinate movedToCoordinateLight;
    private static Coordinate movedFromCoordinateLight;
    private static ChessSquare lastSquareClicked;

    public static void handleClick(ChessSquare square, ChessBoard board)
    {
        if(!possibleMoves.isEmpty())
        {
            //Check for movement
            if(checkForMovement(square))
            {
                //moving the square
                PieceMover.move(lastSquareClicked, new Coordinate(square.getI(), square.getJ()));
                clearPossibleMoves();
                turnLights(new HashSet<>(possibleMoves));
                lastSquareClicked = null ;
            }
            //check for showing possible moves
            else if(square.getPieceColor() == board.whoTurnIsIt()) {
                clearPossibleMoves();
                possibleMoves = MoveShower.showMoves(square);
                turnLights(new HashSet<>(possibleMoves));
                lastSquareClicked = square ;
            }
            //EMPTY CLICKED
            else if(square.getPiece() == Piece.EMPTY)
            {
                clearPossibleMoves();
                turnLights(new HashSet<>(possibleMoves));
                turnEmpty(square.getCoordinate());
                clearPossibleMoves();
                lastSquareClicked = null;
            }
        } else {
            //check for show possible moves
            if(square.getPiece() != Piece.EMPTY && board.whoTurnIsIt() == square.getPieceColor())
            {
                clearPossibleMoves();
                possibleMoves = MoveShower.showMoves(square);
                turnLights(new HashSet<>(possibleMoves));
                lastSquareClicked = square;
            //check for empty click
            } else if(square.getPiece() == Piece.EMPTY)
            {
                turnEmpty(square.getCoordinate());
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


    private static boolean checkForMovement(ChessSquare destinationSquare)
    {
        for (Move possibleMove : possibleMoves) {
            if (possibleMove.dstCord.equalsCoordinate(destinationSquare.getI(), destinationSquare.getJ())) {
                return true;
            }
        }
        return false ;
    }


    private static void turnEmpty(Coordinate cor) {
        // Remove the highlighting from the previous empty square
        if (emptyLight != null) {
            ChessSquare previousSquare = BoardMaker.theBoard.getSquare(emptyLight);
            String style;
            // Determine the square's color based on its coordinates
            if ((emptyLight.i + emptyLight.j) % 2 == 0) {
                style = BoardStyles.getWhiteColor();
            } else {
                style = BoardStyles.getBlackColor();
            }
            previousSquare.updateSquareStyle(style);
        }

        // Highlight the new empty square
        emptyLight = cor;
        ChessSquare currentSquare = BoardMaker.theBoard.getSquare(cor);
        currentSquare.updateSquareStyle(BoardStyles.getEmptyStyle());
    }

    private static void turnLights(Set<Move> newPossibleMoves)
    {
        Set<Move> squaresToTurnOn = new HashSet<>(newPossibleMoves);
        squaresToTurnOn.removeAll(highlightedSquares);

        Set<Move> squaresToTurnOff = new HashSet<>(highlightedSquares);
        squaresToTurnOff.removeAll(newPossibleMoves);
        if(emptyLight != null)
        {
            squaresToTurnOff.add(new Move(emptyLight, MoveName.MOVE));
        }

        // Turn off lights
        for (Move move : squaresToTurnOff) {
            ChessSquare square = BoardMaker.theBoard.getSquare(move.dstCord);
            String style;
            // If the sum of row and column is even, it's a white square, otherwise it's black
            if ((move.dstCord.i + move.dstCord.j) % 2 == 0)
            { style = BoardStyles.getWhiteColor();
            } else {style = BoardStyles.getBlackColor();}
            square.updateSquareStyle(style);
        }

        // Turn on lights
        String onStyle ;
        for (Move move : squaresToTurnOn) {
            ChessSquare square = BoardMaker.theBoard.getSquare(move.dstCord);
            // If the sum of row and column is even, it's a white square, otherwise it's black
            if(move.moveName== MoveName.MOVE)
            {
                if ((move.dstCord.i + move.dstCord.j) % 2 == 0)
                { onStyle = BoardStyles.getPossibleStyle(Color.WHITE);
                } else {onStyle = BoardStyles.getPossibleStyle(Color.BLACK);}
                square.updateSquareStyle(onStyle);
            } else {
                if ((move.dstCord.i + move.dstCord.j) % 2 == 0)
                { onStyle = BoardStyles.getKillStyle(Color.WHITE);
                } else {onStyle = BoardStyles.getKillStyle(Color.BLACK);}
                square.updateSquareStyle(onStyle);
            }
        }

        // Update the set of highlighted squares
        highlightedSquares = new HashSet<>(newPossibleMoves);
    }
}