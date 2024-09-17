package utils;


public class Clipping{

    public static int calcule_code(int x, int y, int xmin, int ymin, int xmax, int ymax)
    {
        int code = 0;
        if (x < xmin)
            code += 1;
        if (x > xmax)
            code += 2;
        if (y < ymin)
            code += 4;
        if (y > ymax)
            code += 8;
        return code;
    }

}