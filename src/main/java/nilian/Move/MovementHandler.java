package nilian.Move;

import javafx.scene.Node;
import nilian.board.*;

import java.util.ArrayList;
import java.util.List;

public class MovementHandler
{
    private static boolean isSomeSquareClicked = false;
    private static ChessSquare lastSquareClicked;
    private static List<Coordinate> possibleMoves = new ArrayList<>();
    private static boolean isLightsOn = false ;


    public static void handleClick(ChessSquare square, ChessBoard board)
    {
        if(!possibleMoves.isEmpty())
        {
            System.out.println("1");
            if(checkForMovement(square))
            {
                System.out.println("2");
                moveTheLastSquareToDestination();
                possibleMoves.clear();
                turnLights(false);
                isLightsOn = false;
            }
            else {
                System.out.println("3");
                possibleMoves.clear();
                turnLights(false);
                possibleMoves = MoveShower.showMoves(square);
                turnLights(true);
                isLightsOn = false;
            }
        } else {
            System.out.println("4");
            if(square.getPiece() != Piece.EMPTY && board.whoTurnIsIt() == square.getPieceColor())
            {
                System.out.println("5");
                turnLights(false);
                possibleMoves.clear();
                possibleMoves = MoveShower.showMoves(square);
                turnLights(true);
                isLightsOn = true ;
                System.out.println("6");
            } else if(square.getPiece() == Piece.EMPTY)
            {
                System.out.println("7");
                turnEmpty(square.getCoordinate());
                possibleMoves.clear();
                isLightsOn = true;
            }
        }
        possibleMoves.forEach(e -> System.out.println(e.toString()));
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

    private static void turnEmpty(Coordinate cor)
    {
        System.out.println(cor.toString()+" is empty and on");
    }

    private static void replaceNode(Node oldNode, Node newNode, int col , int row) {
        BoardMaker.chessboard.getChildren().remove(oldNode);
        // Add the new node
        BoardMaker.chessboard.add(newNode, col, row);
    }

}
