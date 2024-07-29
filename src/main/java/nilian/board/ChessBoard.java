package nilian.board;

import nilian.Move.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class ChessBoard
{
    /*
    Holds all the squares of the board.
     */
    private List<List<ChessSquare>> allPieces = new ArrayList<>();

    /**
     * adds a new square to the board. used when making the board
     * @param square
     */
    public void addSquare(ChessSquare square)
    {
        allPieces.get(square.getI()).add(square.getJ(), square);
    }

    /**
     * returns any square at the specified coordinates
     * @param cord
     * @return square
     */
    public ChessSquare getSquare(Coordinate cord)
    {
        return allPieces.get(cord.i).get(cord.j);
    }

    /**
     * replaces the new square with the old one on the coordinate
     * @param cord coordinate of the old square
     * @param square the new square
     */
    public void setSquare(Coordinate cord, ChessSquare square)
    {
        //making it empty first
        allPieces.get(cord.i).set(cord.j, null);
        //putting new value
        allPieces.get(cord.i).set(cord.j, square);
    }
}
