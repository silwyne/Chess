package nilian.Game;

import nilian.Move.Move;
import nilian.Move.MoveShower;
import nilian.board.ChessBoard;
import nilian.board.ChessSquare;
import nilian.board.Color;
import nilian.board.PieceSetIdentifier;

import java.util.List;

public class EndGameChecker
{

    public static boolean isEndGame(ChessBoard board)
    {
        /*
        1. all present Pieces
        2. get list of valid moves
        3. if only 1 move there is break return true
         */
        //GET LIST OF PRESENT PIECES
        List<PieceSetIdentifier> presentPieces;
        if(board.whoTurnIsIt() == Color.BLACK)
        {
            presentPieces = board.getBlackPieces();
        } else {
            presentPieces = board.getWhitePieces();;
        }
        //IF THERE IS ANY VALID MOVE BETWEEN THEM
        List<Move> validMoves ;
        ChessSquare tempSquare;
        ChessSquare checkSquare;
        for(PieceSetIdentifier psi: presentPieces)
        {
            checkSquare = board.getSquare(psi.getCord());
            if(checkSquare.getPiece().equals(psi.getPiece())
            && checkSquare.getPieceColor().equals(psi.getPieceColor()))
            {
                tempSquare = new ChessSquare(psi.getCord().i, psi.getCord().j, board);
                tempSquare.setPiece(psi.getPiece());
                tempSquare.setPieceColor(psi.getPieceColor());
                validMoves = MoveShower.showMoves(tempSquare);
                if(!validMoves.isEmpty())//THERE IS STILL A POSSIBLE MOVE
                {
                    return false;
                }
            }
        }
        return true;
    }
}
