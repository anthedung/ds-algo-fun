package union_find.challenges;

import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * 1,1 is the top left
 */
public class PercolationStats {

    private final double[] trialResults;
    private static final double CONFIDENCE_95 = 1.96;

    public PercolationStats(int n, int trials)    // perform trials independent experiments on an n-by-n grid
    {
        if (n < 1 || trials < 1)
            throw new IllegalArgumentException();

        trialResults = new double[trials];

        for (int i = 0; i < trials; i++) {
            Percolation p = new Percolation(n);
            while (!p.percolates()) {
                // open a random site
                int row = StdRandom.uniform(n) + 1;
                int col = StdRandom.uniform(n) + 1;

                p.open(row, col);
            }

            trialResults[i] = 1.0 * p.numberOfOpenSites() / (n * n);
        }
    }

    public double mean()                          // sample mean of percolation threshold
    {
        return StdStats.mean(trialResults);
    }

    public double stddev()                        // sample standard deviation of percolation threshold
    {
        return StdStats.stddev(trialResults);
    }

    public double confidenceLo()                  // low  endpoint of 95% confidence interval
    {
        return mean() - CONFIDENCE_95 * stddev() / Math.sqrt(trialResults.length);
    }

    public double confidenceHi()                  // high endpoint of 95% confidence interval
    {
        return mean() + CONFIDENCE_95 * stddev() / Math.sqrt(trialResults.length);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[0]);

        PercolationStats ps = new PercolationStats(n, T);

        Out out = new Out(System.out);
        out.printf("\n%-35s=%f", "mean", ps.mean());
        out.printf("\n%-35s=%f", "stddev", ps.stddev());
        out.printf("\n%-35s=[%f, %f]", "95% confidence interval", ps.confidenceLo(), ps.confidenceHi());
    }
}