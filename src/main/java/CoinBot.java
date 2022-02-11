import com.mashape.unirest.http.exceptions.UnirestException;

public class CoinBot {

    private API api;
    private Market market;
    private int funds;
    private double coinHoldings;
    private double buyInPrice;
    private boolean aboveUpperBound;
    private boolean aboveLowerBound ;

    CoinBot(API api, Market market) {
        this.funds = 10000;
        this.api = api;
        this.market = market;
        this.coinHoldings = 0;
    }

    public double getBuyInPrice() {
        return buyInPrice;
    }

    public void setBuyInPrice(double buyInPrice) {
        this.buyInPrice = buyInPrice;
    }

    public double getHoldings() {
        return this.coinHoldings;
    }

    public void purchase() {

        coinHoldings += funds/api.getMarketPrice("BTC");
        funds = 0;
        setBuyInPrice(api.getMarketPrice("BTC"));
        System.out.println("Making a purchase");
        printStatus();
    }

    public void sell() {

        funds += api.getMarketPrice("BTC")*coinHoldings;
        coinHoldings = 0;
        System.out.println("Making a sale.");
        printStatus();
    }

    public void printStatus() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Current funds available: " + funds + "(" + coinHoldings*api.getMarketPrice("BTC") + ")");
        System.out.println("Current BTC holdings: " + coinHoldings);
        System.out.println("Current price of BTC: " + api.getMarketPrice("BTC"));
        System.out.println("Buy in price: " + this.buyInPrice);
        System.out.println("Upper Bound: " + market.getUpperBound());
        System.out.println("Lower Bound: " + market.getLowerBound());
    }

    public boolean isAboveUpperBound() {
        return aboveUpperBound;
    }

    public void setAboveUpperBound() {
        aboveUpperBound = !(market.getUpperBound() > api.getMarketPrice("BTC"));

    }

    public boolean isAboveLowerBound() {
        return aboveLowerBound;
    }

    public void setAboveLowerBound() {
        aboveLowerBound = !(market.getLowerBound() > api.getMarketPrice("BTC"));

    }
}
