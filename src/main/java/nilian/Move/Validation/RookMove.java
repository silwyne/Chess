package nilian.Move.Validation;

import nilian.Move.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class RookMove
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
        Coordinate destination;

        //right moves
        for (int ei = 1; ei < 8; ei++) {
            if (j + ei < 8)
            {
                destination = new Coordinate(i, j + ei);
                result.add(destination);
            } else {
                break;
            }
        }
        //left moves
        for (int ei = 1; ei < 8; ei++) {
            if (j - ei >= 0)//validation
            {
                destination = new Coordinate(i, j - ei);
                result.add(destination);
            } else {
                break;
            }
        }
        //up moves
        for (int ei = 1; ei < 8; ei++) {
            if (i - ei >= 0)//validation
            {
                destination = new Coordinate(i - ei, j);
                result.add(destination);
            } else {
                break;
            }
        }
        //down moves
        for (int ei = 1; ei < 8; ei++) {
            if (i + ei < 8)//validation
            {
                destination = new Coordinate(i + ei, j);
                result.add(destination);
            } else {
                break;
            }
        }
        return result;
    }

}
