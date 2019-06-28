package recursion;

public class LCMAndHCF {
    /**
     * This method finds LCM of two numbers i.e. x and y using recursion
     *
     * @param x is{@code Integer} first number requires x>0
     * @param y is{@code Integer} second number requires y>0
     * @return Least Common Multiple of x & y
     */
    static int findLCM(int x, int y) {
        return (x * y) / findHCF(x, y);
    }

    /**
     * This method finds HCF of two numbers i.e. x and y
     *
     * @param x is{@code Integer} first number requires x>0
     * @param y is{@code Integer} second number requires y>0
     * @return Highest Common Factor of x & y
     */
    static int findHCF(int x, int y) {
        if (y != 0)
            return findHCF(y, x % y);
        else
            return x;
    }
}
