Basic coin bot that uses principles of 'Simple Moving Average'.

This bot operates off of a 1 hour moving average that is calculated in 3 minute intervals. This correlates to using 20 data points per evaluation.
If the bot isn't supplied with an initial moving average it will build one on it's own. The bot monitors upper and lower bounds that are offset by +-1.5%.
A trade is triggered in 3 scenarios.
  1. The market price of BTC crosses below the upper bound. In this case a sell will be initiated.
  2. The market price of BTC crosses below the lower bound. In this case a sell will be initiated.
  3. The market price of BTC crosses above the lower bound. In this case a buy will be initiated.
  
These rules will allow the bot to predict when market drops are happening and sell out of shares. It will rebuy when it predicts a market rise, monitoring the lower bound.

You can adjust for market conditions in several ways:
  1. Provide a custom bound offset when creating the market object.
  2. Editing the purchase/sell logical text
  3. Tracking a different coin, when passing your code in through getMarketPrice();
 
