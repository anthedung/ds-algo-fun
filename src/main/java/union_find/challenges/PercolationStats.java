package union_find.challenges;

import java.util.Random;

/**
 * 1,1 is the top left
 */
class PercolationStats {

    private double[] trialResults;

    public PercolationStats(int n, int trials)    // perform trials independent experiments on an n-by-n grid
    {
        if (n < 1 || trials < 1)
            throw new IllegalArgumentException();

        trialResults = new double[trials];

        for (int i = 0; i < trials; i++) {
            Percolation p = new Percolation(n);
            while (!p.percolates()) {
                // open a random site
                Random random = new Random();
                int row = random.nextInt(n) + 1;
                int col = random.nextInt(n) + 1;

                p.open(row, col);
            }

            trialResults[i] = 1.0 * p.numberOfOpenSites() / (n * n);
        }
    }

    public double mean()                          // sample mean of percolation threshold
    {
        double sum = 0.0;
        for (int i = 0; i < trialResults.length; i++) {
            sum += trialResults[i];
        }

        return sum / trialResults.length;
    }

    public double stddev()                        // sample standard deviation of percolation threshold
    {
        double v = 0.0;
        double mean = mean();
        for (int i = 0; i < trialResults.length; i++) {
            v += (trialResults[i] - mean) * (trialResults[i] - mean);
        }

        return Math.sqrt(v / (trialResults.length - 1));
    }

    public double confidenceLo()                  // low  endpoint of 95% confidence interval
    {
        return mean() - 1.96 * stddev() / Math.sqrt(trialResults.length);
    }

    public double confidenceHi()                  // high endpoint of 95% confidence interval
    {
        return mean() + 1.96 * stddev() / Math.sqrt(trialResults.length);
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[0]);

        PercolationStats ps = new PercolationStats(n, T);
        System.out.printf("\n%-35s=%f", "mean", ps.mean());
        System.out.printf("\n%-35s=%f", "stddev", ps.stddev());
        System.out.printf("\n%-35s=[%f, %f]", "95% confidence interval", ps.confidenceLo(), ps.confidenceHi());
    }
}
