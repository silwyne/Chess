package nilian.Move;

import nilian.Style.BoardStyles;
import nilian.board.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MovementHandler
{
    private static List<Coordinate> possibleMoves = new ArrayList<>();
    private static Set<Coordinate> highlightedSquares = new HashSet<>();
    private static Coordinate emptyLight ;
    private static ChessSquare lastSquareClicked;

    public static void handleClick(ChessSquare square, ChessBoard board)
    {
        if(!possibleMoves.isEmpty())
        {
            System.out.println("###### STATE CLICK :1 : No Square is clicked before");
            if(checkForMovement(square))
            {
                System.out.println("###### STATE CLICK :2: Moving last square to clicked square");
                moveTheLastSquareToDestination(lastSquareClicked, new Coordinate(square.getI(), square.getJ()));
                possibleMoves.clear();
                turnLights(new HashSet<>(possibleMoves));
                lastSquareClicked = null ;
            }
            else {
                System.out.println("###### STATE CLICK :3: extracting possible moves");
                possibleMoves.clear();
                possibleMoves = MoveShower.showMoves(square);
                turnLights(new HashSet<>(possibleMoves));
                lastSquareClicked = square ;
            }
        } else {
            System.out.println("###### STATE CLICK :4: ");
            if(square.getPiece() != Piece.EMPTY && board.whoTurnIsIt() == square.getPieceColor())
            {
                System.out.println("###### STATE CLICK :5");
                possibleMoves.clear();
                possibleMoves = MoveShower.showMoves(square);
                turnLights(new HashSet<>(possibleMoves));
                lastSquareClicked = square;
            } else if(square.getPiece() == Piece.EMPTY)
            {
                System.out.println("###### STATE CLICK :6");
                turnEmpty(square.getCoordinate());
                possibleMoves.clear();
                lastSquareClicked = null;
            }
        }
        possibleMoves.forEach(e -> System.out.println("Possible move: "+e.toString()));
    }


    private static boolean checkForMovement(ChessSquare destinationSquare)
    {
        System.out.println("CHECKING FOR MOVEMENT");
        for (Coordinate possibleMove : possibleMoves) {
            if (possibleMove.equalsCoordinate(destinationSquare.getI(), destinationSquare.getJ())) {
                return true;
            }
        }
        return false ;
    }


    private static void moveTheLastSquareToDestination(ChessSquare square, Coordinate dstCord)
    {
        System.out.println("MOVEMENT IS CALLED");
        ChessSquare emptySquare = new ChessSquare(square.getI(), square.getJ(), square.getBoard());
        emptySquare.setPiece(Piece.EMPTY);
        String emptyStyle ;
        if ((emptySquare.getI() + emptySquare.getJ()) % 2 == 0) {
            emptyStyle = BoardStyles.getWhiteColor();
        } else {
            emptyStyle = BoardStyles.getBlackColor();
        }
        updateSquareStyle(emptySquare, emptyStyle);

        //extracting picture
//        Node piecePicture = square.getChildren().get(0);
//        ChessSquare newSquare = new ChessSquare(dstCord.i, dstCord.j, square.getBoard());
//        newSquare.getChildren().add(piecePicture);
//        newSquare.setPiece(square.getPiece());
//        newSquare.setPieceColor(square.getPieceColor());
//        String newStyle ;
//        if ((newSquare.getI() + newSquare.getJ()) % 2 == 0) {
//            newStyle = BoardStyles.getWhiteColor();
//        } else {
//            newStyle = BoardStyles.getBlackColor();
//        }
//        updateSquareStyle(newSquare, newStyle);
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

    private static void turnLights(Set<Coordinate> newPossibleMoves) {
        Set<Coordinate> squaresToTurnOn = new HashSet<>(newPossibleMoves);
        squaresToTurnOn.removeAll(highlightedSquares);

        Set<Coordinate> squaresToTurnOff = new HashSet<>(highlightedSquares);
        squaresToTurnOff.removeAll(newPossibleMoves);
        if(emptyLight != null)
        {
            squaresToTurnOff.add(emptyLight);
        }

        // Turn off lights
        for (Coordinate cord : squaresToTurnOff) {
            ChessSquare square = BoardMaker.theBoard.getSquare(cord);
            String style;
            // If the sum of row and column is even, it's a white square, otherwise it's black
            if ((cord.i + cord.j) % 2 == 0)
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