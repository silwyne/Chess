package nilian.Move.Validation;

import nilian.Move.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class KingMove
{

    /**
     *  calculates all the possible coordinates as destination the bishop can go without getting the king killed.
     * @return a list of possible coordinates
     */
    public static List<Coordinate> calculateOnBoardMoves(Coordinate source)
    {
        List<Coordinate> result = new ArrayList<>();
        int i = source.i;
        int j = source.j;
        Coordinate destination ;
        //right, left, up, down , ru, lu, rd, ld
        //right
        if(j + 1 < 8)//move is in board
        {
            destination = new Coordinate(i, j + 1);
            result.add(destination);
        }
        //left
        if(j - 1 >= 0)//move is in board
        {
            destination = new Coordinate(i, j - 1);
            result.add(destination);
        }
        //up
        if(i - 1 >= 0)//move is in board
        {
            destination = new Coordinate(i - 1, j);
            result.add(destination);
        }
        //down
        if(i + 1 < 8)//move is in board
        {
            destination = new Coordinate(i + 1, j);
            result.add(destination);
        }
        //right up
        if(i - 1 >= 0 && j + 1 < 8)//move is in board
        {
            destination = new Coordinate(i - 1, j + 1);
            result.add(destination);
        }
        //right down
        if(i + 1 < 8 && j + 1 < 8)//move is in board
        {
            destination = new Coordinate(i + 1, j + 1);
            result.add(destination);
        }
        //left up
        if(i - 1 >= 0 && j - 1 >= 0)//move is in board
        {
            destination = new Coordinate(i - 1, j - 1);
            result.add(destination);
        }
        //left down
        if(i + 1 < 8 && j - 1 >= 0)//move is in board
        {
            destination = new Coordinate(i + 1, j - 1);
            result.add(destination);
        }
        return result;
    }

}
