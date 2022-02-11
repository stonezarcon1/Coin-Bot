public class Entry {

    public static void main(String[] args) throws InterruptedException {

        API api = new API();
        Market market = new Market();
        CoinBot bot = new CoinBot(api, market);
        boolean upper;
        boolean lower;
        bot.purchase();
        while (true) {

            market.updateMovingAverage(api.getMarketPrice("BTC"));

            upper = bot.isAboveUpperBound();
            lower = bot.isAboveLowerBound();

            bot.setAboveUpperBound();
            bot.setAboveLowerBound();

            System.out.println("Upper: " + upper);
            System.out.println("Lower: " + lower);
            System.out.println("isUpper: " + bot.isAboveUpperBound());
            System.out.println("isLower: " + bot.isAboveLowerBound());

            if (upper != bot.isAboveUpperBound() && upper && bot.getHoldings() != 0) {
                bot.sell();
                System.out.println("Making a sale because I dipped below upper bound.");
            } else if (lower != bot.isAboveLowerBound() && !lower && bot.getHoldings() == 0) {
                bot.purchase();
                System.out.println("Making a purchase because I went above lower bound.");
            } else if (lower != bot.isAboveLowerBound() && lower && bot.getHoldings() != 0) {
                bot.sell();
                System.out.println("Making a sale because I went below lower bound.");
            }

            bot.printStatus();
            System.out.println("Current Moving Average: " + market.getMovingAverage());
            System.out.println("--------------------------------------------------------------");

            Thread.sleep(5000);
        }
    }
}
