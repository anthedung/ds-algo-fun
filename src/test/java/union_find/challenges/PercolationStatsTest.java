package union_find.challenges;

import edu.princeton.cs.algs4.Out;
import junit.framework.TestCase;
import org.junit.Test;

public class PercolationStatsTest extends TestCase {

    @Test
    public void testPercolationStats() {
        int n = Integer.parseInt("100");
        int T = Integer.parseInt("200");

        PercolationStats ps = new PercolationStats(n, T);

        Out out = new Out(System.out);
        out.printf("\n%-35s=%f", "mean", ps.mean());
        out.printf("\n%-35s=%f", "stddev", ps.stddev());
        out.printf("\n%-35s=[%f, %f]", "95% confidence interval", ps.confidenceLo(), ps.confidenceHi());

        assertTrue(Math.abs(0.592456-ps.mean()) <= 0.00001);
    }
}
