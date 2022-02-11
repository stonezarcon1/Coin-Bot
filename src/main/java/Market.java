import java.util.LinkedList;

public class Market {

    private double movingAverage;
    private double upperBound = 1000;
    private double lowerBound = 1000;
    private double dataPoints;
    private LinkedList<Double> historicPrices;

    Market() {
        historicPrices = new LinkedList<>();
    }

    public void updateMovingAverage(double data) {

        if (historicPrices.size() == 20) {
            historicPrices.removeFirst();
            historicPrices.addLast(data);
        } else {
            historicPrices.addLast(data);
        }
        movingAverage = 0;
        for (double i : historicPrices) {
            movingAverage += i;
        }
        dataPoints = historicPrices.size();
        movingAverage /= dataPoints;
        setLowerBound();
        setUpperBound();

    }

    public double getMovingAverage() {

        return movingAverage;
    }

    public double getUpperBound() {
        return upperBound;
    }

    public double getLowerBound() {
        return lowerBound;
    }

    public void setUpperBound() {

        this.upperBound = movingAverage * 1.015;
    }

    public void setLowerBound() {

        this.lowerBound = movingAverage * .985;
    }

}
