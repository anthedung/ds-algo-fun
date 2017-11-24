package union_find.challenges;

/**
 * 1,1 is the top left
 */
class Percolation {
    private int n; // size of system n * n
    private int noOpen; // number of open sites

    // convert the system into 1 dimensional array
    // where i,j => index (i-1) * n + (j-1)
    private int[] UF;

    //maintain an array of smallest in connected components
    // if s = smallestFind(x) = smallest[root(x)]; s < n => isFull;
    private int[] smallest;

    // similarly, largest keep track of the bottom row
    private int[] largest;

    // sz for balancing tree to ensure log(n) performance
    private int[] sz;

    // state of percolation
    // checked and updated while opening a new site
    private boolean isPercolated = false;

    // UFOpen to keep track of open sites
    private boolean[] UFOpen;

    public Percolation(int n)             // create n-by-n grid, with all sites blocked
    {
        this.n = n;

        if (n < 1) throw new java.lang.IllegalArgumentException();

        this.UF = new int[n * n];
        this.sz = new int[n * n];
        this.UFOpen = new boolean[n * n]; // default all false
        this.smallest = new int[n * n];
        this.largest = new int[n * n];

        for (int i = 0; i < n * n; i++) {
            UF[i] = i;
            sz[i] = 1;

            smallest[i] = largest[i] = i;
        }
    }


    int convertIndex(int i, int j) {
        return (i - 1) * n + j - 1;
    }

    public void open(int row, int col)    // open site (row, col) if it is not open already
    {
        checkValidSite(row,col);

        if (row < 1 || row > n || col < 0 || col > n) {
            throw new IllegalArgumentException();
        }
        int index = convertIndex(row, col);

        if (isOpen(row, col)) return; // if already open then skip
        else UFOpen[index] = true;

        ++noOpen;

        int[][] adjSitesToCheck = new int[4][2]; // arrays of node, top, right, bottom, left

        // top
        adjSitesToCheck[0][0] = row - 1;
        adjSitesToCheck[0][1] = col;
        // right
        adjSitesToCheck[1][0] = row;
        adjSitesToCheck[1][1] = col + 1;
        // bottom
        adjSitesToCheck[2][0] = row + 1;
        adjSitesToCheck[2][1] = col;
        // left
        adjSitesToCheck[3][0] = row;
        adjSitesToCheck[3][1] = col - 1;

        int[] adjacentSites = new int[4];
        for (int i = 0; i < adjSitesToCheck.length; i++) {
            // if within the table
            if (adjSitesToCheck[i][0] > 0 && adjSitesToCheck[i][0] <= n
                    && adjSitesToCheck[i][1] > 0 && adjSitesToCheck[i][1] <= n) {
                adjacentSites[i] = convertIndex(adjSitesToCheck[i][0], adjSitesToCheck[i][1]);
            } else {
                adjacentSites[i] = -1;
            }
        }
        for (int i = 0; i < adjacentSites.length; i++) {
            if (adjacentSites[i] > -1) {
                if (UFOpen[adjacentSites[i]]) {
                    union(index, adjacentSites[i]);
                }
            }
        }

        // when open check if percolate
        // if smallest < n and largest > (n-1) * n => connected
        if (smallest[root(index)] < n && largest[root(index)] > (n - 1) * n) {
            this.isPercolated = true;
        }
    }

    public boolean isOpen(int row, int col)  // is site (row, col) open?
    {
        checkValidSite(row,col);
        return UFOpen[convertIndex(row, col)];
    }

    public boolean isFull(int row, int col)  // is site (row, col) full?
    {
        checkValidSite(row,col);
        // check if the smallest in the connected component is first row
        return smallest[root(convertIndex(row, col))] < n;
    }

    // number of open sites
    public int numberOfOpenSites() {
        return noOpen;
    }

    // does the system percolate?
    public boolean percolates() {
        return isPercolated;
    }


    // helper union finds methods
    private int root(int a) {
        while (a != UF[a]) {
            UF[a] = UF[UF[a]]; // cut tree, re-balancing

            a = UF[a];
        }

        return a;
    }

    // 1. union with weighted tree
    // 2. update smallest
    // 3. update largest
    private void union(int a, int b) {
        int rA = root(a);
        int rB = root(b);

        if (rA == rB) return;

        if (sz[rA] < sz[rB]) {
            UF[rA] = rB;
            sz[rB] += sz[rA];

            if (largest[rB] < largest[rA]) {
                largest[rB] = largest[rA];
            }

            if (smallest[rB] > smallest[rA]) {
                smallest[rB] = smallest[rA];
            }
        } else {
            UF[rB] = rA;
            sz[rA] += sz[rB];

            if (largest[rA] < largest[rB]) {
                largest[rA] = largest[rB];
            }

            if (smallest[rA] > smallest[rB]) {
                smallest[rA] = smallest[rB];
            }
        }
    }

    public void printGrid() {
        System.out.println("UF: ");
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.printf("%5d ", UF[convertIndex(i, j)]);
            }
            System.out.println();
        }

        System.out.println("UFOpen: ");
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.printf("%5d ", UFOpen[convertIndex(i, j)] ? 1 : 0);
            }
            System.out.println();
        }

        System.out.println("sz: ");
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.printf("%5d ", sz[convertIndex(i, j)]);
            }
            System.out.println();
        }

        System.out.println("smallest: ");
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.printf("%5d ", smallest[convertIndex(i, j)]);
            }
            System.out.println();
        }

        System.out.println("largest: ");
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.printf("%5d ", largest[convertIndex(i, j)]);
            }
            System.out.println();
        }

        System.out.println("root: ");
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.printf("%5d ", root(convertIndex(i, j)));
            }
            System.out.println();
        }
        System.out.println("percolated: " + this.percolates());
    }

    private void checkValidSite(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n)
            throw new java.lang.IllegalArgumentException();
    }
}
