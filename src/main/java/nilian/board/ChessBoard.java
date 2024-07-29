package nilian.board;

import nilian.Move.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class ChessBoard
{
    /*
    Holds all the squares of the board.
     */
    private final List<List<ChessSquare>> allPieces = new ArrayList<>();

    /**
     * Adds a new square to the board. used when making the board
     * @param square the square you want add
     */
    public void addSquare(ChessSquare square)
    {
        System.out.println(square.getI()+" : "+square.getJ());
        if(allPieces.size() <= square.getJ())
        {
            List<ChessSquare> temp = new ArrayList<>();
            allPieces.add(temp);
        }
        allPieces.get(square.getI()).add(square.getJ(), square);
    }

    /**
     * returns any square at the specified coordinates
     * @param cord coordination of the square you seek
     * @return square
     */
    public ChessSquare getSquare(Coordinate cord)
    {
        System.out.println("get square: "+cord.toString());
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
