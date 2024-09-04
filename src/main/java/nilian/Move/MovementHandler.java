package nilian.Move;

import javafx.scene.Node;
import nilian.Style.BoardStyles;
import nilian.board.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MovementHandler
{
    private static List<Move> possibleMoves = new ArrayList<>();
    private static Set<Move> highlightedSquares = new HashSet<>();
    private static Coordinate emptyLight ;
    private static ChessSquare lastSquareClicked;

    public static void handleClick(ChessSquare square, ChessBoard board)
    {
        if(!possibleMoves.isEmpty())
        {
            //Check for movement
            if(checkForMovement(square))
            {
                //moving the square
                moveTheLastSquareToDestination(lastSquareClicked, new Coordinate(square.getI(), square.getJ()));
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


    private static void moveTheLastSquareToDestination(ChessSquare sourceSquare, Coordinate dstCord) {
        ChessBoard board = sourceSquare.getBoard();
        // Get the destination square
        ChessSquare destSquare = board.getSquare(dstCord);

        // Move the piece to the destination square
        Node piecePicture = sourceSquare.getChildren().get(0);
        destSquare.getChildren().clear();
        destSquare.getChildren().add(piecePicture);
        destSquare.setPiece(sourceSquare.getPiece());
        // Clear the source square
        sourceSquare.setPiece(Piece.EMPTY);
        destSquare.setPieceColor(sourceSquare.getPieceColor());
        updateSquareStyle(sourceSquare, getSquareStyle(sourceSquare.getI(), sourceSquare.getJ()));
        updateSquareStyle(destSquare, getSquareStyle(dstCord.i, dstCord.j));

        // Update the board model
        board.setSquare(new Coordinate(sourceSquare.getI(), sourceSquare.getJ()), sourceSquare);
        board.setSquare(dstCord, destSquare);

        //UPDATE the turn
        board.nextTurn();

        //if the piece is king update the king coordinate
        if(destSquare.getPiece() == Piece.KING)
        {
            board.updateBoardKingCoordinates(destSquare.getPieceColor(), dstCord);
        }
    }

    private static String getSquareStyle(int i, int j) {
        return (i + j) % 2 == 0 ? BoardStyles.getWhiteColor() : BoardStyles.getBlackColor();
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
            updateSquareStyle(previousSquare, style);
        }

        // Highlight the new empty square
        emptyLight = cor;
        ChessSquare currentSquare = BoardMaker.theBoard.getSquare(cor);
        updateSquareStyle(currentSquare, BoardStyles.getPossibleStyle());
    }

    private static void turnLights(Set<Move> newPossibleMoves) {
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
            updateSquareStyle(square, style);
        }

        // Turn on lights
        for (Move move : squaresToTurnOn) {
            ChessSquare square = BoardMaker.theBoard.getSquare(move.dstCord);
            if(move.moveName== MoveName.MOVE)
            {
                updateSquareStyle(square, BoardStyles.getPossibleStyle());
            } else {
                updateSquareStyle(square, BoardStyles.getKillStyle());
            }
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