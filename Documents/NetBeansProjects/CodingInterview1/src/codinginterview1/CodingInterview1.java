/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codinginterview1;

/**
 *
 * @author dsli
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class CodingInterview1 {

    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        String[] portStocks;
        String[] benchStocks;
        Portfolio[] portfolios;
        Portfolio[] benchPortfolios;
        ArrayList<DiffPortfolio> differentials = new ArrayList<DiffPortfolio>();
        while ((line = in.readLine()) != null) {
            // First getting PORT
            int benchStringIndex = line.indexOf('|');
            String portStockString = line.substring(line.indexOf(':') + 1, benchStringIndex);
            portStocks = portStockString.split(";");
            portfolios = storePortfolioData(portStocks);

            // Get BENCH
            String remainder = line.substring(benchStringIndex + 1);
            int benchStringColonIndex = remainder.indexOf(':');
            String benchStockString = remainder.substring(benchStringColonIndex + 1);
            benchStocks = benchStockString.split(";");
            benchPortfolios = storePortfolioData(benchStocks);

            // Now we have our portfolios, so now calculate nav(PORT)
            int navPORT = calculateNav(portfolios);
            int navBENCH = calculateNav(benchPortfolios);
            // now calculate differentials with respect to portfolios array
            for (int i = 0; i < portfolios.length; i++) {
                double portDiff = 0;
                double benchDiff = 0;
                portDiff = ((double) (portfolios[i].getPartialNav() * 100)) / navPORT;
                if (containsStock(portfolios[i], benchPortfolios)) {
                    System.out.println(portfolios[i].getLabel() + "duplicate found");
                    Portfolio benchPort = getPortfolio(portfolios[i], benchPortfolios);
                    benchDiff = ((double) (benchPort.getPartialNav() * 100)) / navBENCH;
                }
                System.out.println(portDiff + " " + benchDiff);
                double diff = portDiff - benchDiff;
                //System.out.printf("%s:%.2f", portfolios[i].getLabel(), diff);
                differentials.add(new DiffPortfolio(portfolios[i].getLabel(), diff));

            }

            // Now find any stray differentials in bench
            for (int i = 0; i < benchPortfolios.length; i++) {
                double portDiff = 0;
                double benchDiff = 0;
                benchDiff = ((double) (benchPortfolios[i].getPartialNav() * 100)) / navPORT;
                if (!(containsStock(benchPortfolios[i], portfolios))) {
                    benchDiff = ((double) (benchPortfolios[i].getPartialNav() * 100)) / navBENCH;
                    double diff = -benchDiff;
                    differentials.add(new DiffPortfolio(benchPortfolios[i].getLabel(), diff));
                }
                
            }

            // Now print the sorted differentials
            while (!(differentials.isEmpty())) {
                DiffPortfolio minPortfolio = differentials.get(0);
                for (int i = 1; i < differentials.size(); i++) {
                    DiffPortfolio d = differentials.get(i);
                    if (minPortfolio.compareTo(d) < 0) {
                        minPortfolio = d;
                    }
                }
                System.out.print(minPortfolio.toString());
                differentials.remove(minPortfolio);
                if (!(differentials.isEmpty())) {
                    System.out.print(",");
                }
            }
        }
    }

    public static Portfolio[] storePortfolioData(String[] portStocks) {
        Portfolio[] portfolios = new Portfolio[portStocks.length];
        for (int i = 0; i < portStocks.length; i++) {
            String[] portStockInfo = portStocks[i].split(",");
            String label = portStockInfo[0];
            int quantity = Integer.parseInt(portStockInfo[1]);
            int price = Integer.parseInt(portStockInfo[2]);
            portfolios[i] = new Portfolio(label, quantity, price);
        }
        return portfolios;
    }

    public static int calculateNav(Portfolio[] stocks) {
        int total = 0;
        for (int i = 0; i < stocks.length; i++) {
            total += stocks[i].getPartialNav();
        }
        return total;
    }

    public static boolean containsStock(Portfolio p, Portfolio[] other) {
        for (int i = 0; i < other.length; i++) {
            if (p.getLabel().equals(other[i].getLabel())) {
                return true;
            }
        }
        return false;
    }

    public static Portfolio getPortfolio(Portfolio p, Portfolio[] other) {
        for (int i = 0; i < other.length; i++) {
            if (p.getLabel().equals(other[i].getLabel())) {
                return other[i];
            }
        }
        return null;
    }
}

class Portfolio {

    private String label;
    private int quantity;
    private int price;

    public Portfolio(String label, int quantity, int price) {
        this.label = label;
        this.quantity = quantity;
        this.price = price;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLabel() {
        return this.label;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getPrice() {
        return this.price;
    }

    public int getPartialNav() {
        return (this.quantity * this.price);
    }

}

class DiffPortfolio {

    private String label;
    private double differential;

    public DiffPortfolio(String label, double differential) {
        this.label = label;
        this.differential = differential;
    }

    public String getLabel() {
        return this.label;
    }

    public String toString() {
        return String.format("%s:%.2f", this.label, differential);
    }

    public int compareTo(DiffPortfolio p) {
        if (p.getLabel().charAt(0) < this.label.charAt(0)) {
            return -1;
        } else if (p.getLabel().charAt(0) > this.label.charAt(0)) {
            return 1;
        }
        return 0;
    }
}
