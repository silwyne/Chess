package nilian.Move;

public class Coordinate
{
    public int i ;
    public int j ;

    public Coordinate(int i, int j)
    {
        this.i = i ;
        this.j = j  ;
    }

    @Override
    public String toString()
    {
        return i+" : "+j;
    }

    public boolean equalsCoordinate(Coordinate obj) {
        return (i == obj.i && j  == obj.j);
    }

    public boolean equalsCoordinate(int l, int m) {
        return (i == l && j  == m);
    }
}
