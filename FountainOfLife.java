public class FountainOfLife {

    public double elixirOfDeath(int e, int p, int k) {
        if (p == e || p < e) {
            return -1.0;
        }
        return (double) k / (p - e);
    }
}
