public class SpeedRadar {
    public double averageSpeed(int minLimit, int maxLimit, int[] readings) {
    	long sum = 0;
    	int infringements = 0;
    	int withinLimits = 0;
        for (int i = 0; i < readings.length; i++) {
        	int value = readings[i];
        	if (value >= minLimit && value <= maxLimit) {
        		sum += value;
        		withinLimits++;
        	} else {
        		infringements++;
        	}
        }
        if (infringements * 100 / readings.length > 10) {
        	return 0.0;
        }
        return (double) sum / withinLimits;
    }
}
