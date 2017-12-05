/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter9Review;

/**
 *
 * @author dsli
 */
public class Stock {
    public String symbol = "";
    public String name = "";
    public double previousClosingPrice = 0;
    public double currentPrice = 0;
    public Stock(String newSymbol, String newName) {
        symbol = newSymbol;
        name = newName;
    }
    public double getChangedPercent() {
        return ((currentPrice - previousClosingPrice) / previousClosingPrice) * 100;
    }
}
