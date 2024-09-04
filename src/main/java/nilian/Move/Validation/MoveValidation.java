package nilian.Move.PieceMoves;

import nilian.Move.Coordinate;
import nilian.Move.Move;
import nilian.board.ChessBoard;
import nilian.board.ChessSquare;
import nilian.board.Color;
import nilian.board.Piece;

import java.util.List;

public class MoveValidation
{
    private static ChessBoard board;

    private static Coordinate source;
    private static Coordinate dst;
    private static Color friendColor;
    /**
     * Checks if the Piece moves to the destination the king gets in danger or not
     *
     * @param dst_cord the coordinate of where the piece can go
     * @param src_cord the coordinate of where the piece is now
     * @return true if king stays safe
     */
    public static boolean isThisMoveValid(Coordinate src_cord, Coordinate dst_cord, ChessBoard boardToAnalyse)
    {
        board = boardToAnalyse;
        source = src_cord;
        dst = dst_cord;
        friendColor = board.whoTurnIsIt();
        /*
        1. who's turn is it? find his king ...
        2. check if the king by the move is safe
        3.enemy pawns!
        4.enemy horses!
        5.enemy bishops!(or queen)
        6.enemy Rooks!(or queen)
         */
        //STEP 1: GETTING THE KING COORDINATE
        Coordinate kingCoordinate;
        if(board.whoTurnIsIt() == Color.BLACK)
        {
            kingCoordinate = board.getKingCoordinate(Color.BLACK);
        } else {
            kingCoordinate = board.getKingCoordinate(Color.WHITE);
        }
        /*
        NOTE : if the source cord is equal to king cord :
        So the dst Cord is actually the king cord !
         */
        if(source == kingCoordinate)
        {
            kingCoordinate = dst_cord;
        }
        //king coordinate
        int ki = kingCoordinate.i;
        int kj = kingCoordinate.j;
        //finally in both situations the source is considered empty
        //and the dst is considered the mover or the friend
        //that is why we take squares from our own function which filters the result
        //to the reality we seek not the present board

        Coordinate destination ;
        ChessSquare checkSquare;
        //CHECK FOR BLACK PAWN
        if(friendColor == Color.BLACK)
        {
            //RIGHT DOWN WHITE PAWN?
            if(ki + 1 <8 && kj + 1 < 8)
            {
                destination = new Coordinate(ki + 1, kj + 1);
                checkSquare = getSquare(destination);
                if(checkSquare.getPiece() == Piece.PAWN
                && checkSquare.getPieceColor() != friendColor)
                {
                    return false;
                }
            }
            //LEFT DOWN WHITE PAWN?
            if(ki + 1 <8 && kj - 1 >= 0)
            {
                destination = new Coordinate(ki + 1, kj - 1);
                checkSquare = getSquare(destination);
                if(checkSquare.getPiece() == Piece.PAWN
                        && checkSquare.getPieceColor() != friendColor)
                {
                    return false;
                }
            }
        //CHECK FOR WHITE PAWN
        } else {
            //RIGHT UP BLACK PAWN?
            if(ki - 1 >= 0 && kj + 1 < 8)
            {
                destination = new Coordinate(ki - 1, kj + 1);
                checkSquare = getSquare(destination);
                if(checkSquare.getPiece() == Piece.PAWN
                        && checkSquare.getPieceColor() != friendColor)
                {
                    return false;
                }
            }
            //LEFT UP BLACK PAWN?
            if(ki - 1 >= 0 && kj - 1 >= 0)
            {
                destination = new Coordinate(ki - 1, kj - 1);
                checkSquare = getSquare(destination);
                if(checkSquare.getPiece() == Piece.PAWN
                        && checkSquare.getPieceColor() != friendColor)
                {
                    return false;
                }
            }
        }

        //CHECK FOR HORSE
        List<Move> horseMoves = Horse.calculatePossibleMoves(ki, kj)

        return true;
    }

    private static ChessSquare getSquare(Coordinate cord)
    {
        if(cord == source)
        {
            ChessSquare result = new ChessSquare(cord.i, cord.j, board);
            result.setPiece(Piece.EMPTY);
            return result;

        } else if (cord == dst)
        {
            ChessSquare result = new ChessSquare(cord.i, cord.j, board);
            result.setPieceColor(board.whoTurnIsIt());
            return result;
        }
        return board.getSquare(cord);
    }
}
