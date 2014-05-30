public class SymbolFrequency {
    public double language(String[] frequencies, String[] text) {
        double a[] = new double[26];
        for (int i = 0; i < a.length; i++) {
            a[i] = 0;
        }
        double result = Double.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < text[i].length(); j++) {
                int value = text[i].charAt(j) - 'a';
                if (value >= 0 && value < 26) {
                    a[value]++;
                    count++;
                }
            }
        }
        for (int i = 0; i < frequencies.length; i++) {
            double e[] = getFrequency(frequencies[i], count);
            result = Math.min(result, getDeviation(a, e));
        }
        return result;
    }

    private double[] getFrequency(String frequency, int count) {
        double a[] = new double[26];
        for (int i = 0; i < frequency.length(); i += 3) {
           int value = frequency.charAt(i) - 'a';
           int digit1 = frequency.charAt(i + 1) - '0';
           int digit2 = frequency.charAt(i + 2) - '0';
           a[value] = count * (digit1 * 10 + digit2) / 100.0;
        }
        return a;
    }
    
    private double getDeviation(double a[], double e[]) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            double value = a[i] - e[i];
            sum += value * value;
        }
        return sum;
    }
}
