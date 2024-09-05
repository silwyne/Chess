package nilian.Move.Validation;

import nilian.Move.Coordinate;
import nilian.board.ChessBoard;
import nilian.board.ChessSquare;
import nilian.board.Color;
import nilian.board.Piece;


public class MoveValidation
{
    private static ChessBoard board;

    private static Coordinate source;
    private static Coordinate dst;
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
        if(source.equalsCoordinate(kingCoordinate))
        {
            kingCoordinate = dst_cord;
        }
        //finally in both situations the source is considered empty
        //and the dst is considered the mover or the friend
        //that is why we take squares from our own function which filters the result
        //to the reality we seek not the present board

        //CHECK FOR ENEMY PAWN
        if(PawnMove.isEnemyThere(kingCoordinate, board.whoTurnIsIt(), Piece.PAWN))
        {
            return false;//in danger
        }

        //CHECK FOR HORSES
        if(HorseMove.isEnemyThere(kingCoordinate, board.whoTurnIsIt(), Piece.HORSE))
        {
            return false;//in danger
        }

        //CHECK FOR BISHOPS
        if(BishopMove.isEnemyThere(kingCoordinate, board.whoTurnIsIt(), Piece.BISHOP))
        {
            return false;//in danger
        }
        //CHECK FOR QUEEN
        if(BishopMove.isEnemyThere(kingCoordinate, board.whoTurnIsIt(), Piece.QUEEN))
        {
            return false;//in danger
        }

        //CHECK FOR ROOKS
        if(RookMove.isEnemyThere(kingCoordinate, board.whoTurnIsIt(), Piece.ROOK))
        {
            return false;//in danger
        }
        //CHECK FOR QUEEN
        if(RookMove.isEnemyThere(kingCoordinate, board.whoTurnIsIt(), Piece.QUEEN))
        {
            return false;//in danger
        }

        //GET KING LOCATIONS
        //CHECK FOR KING
        if(KingMove.isEnemyThere(kingCoordinate, board.whoTurnIsIt(), Piece.KING))
        {
            return false;//in danger
        }
        return true;//safe
    }

    public static ChessSquare getSquare(Coordinate cord)
    {
        if(cord.equalsCoordinate(source))
        {
            ChessSquare result = new ChessSquare(cord.i, cord.j, board);
            result.setPiece(Piece.EMPTY);
            return result;

        } else if (cord.equalsCoordinate(dst))
        {
            ChessSquare result = new ChessSquare(cord.i, cord.j, board);
            result.setPieceColor(board.whoTurnIsIt());
            result.setPiece(board.getSquare(source).getPiece());
            return result;
        }
        return board.getSquare(cord);
    }

}
