package union_find.challenges;

/**
 * Social network connectivity.
 * Given a social network containing n members and a log file containing m timestamps at which times pairs of members formed friendships,
 * design an algorithm to determine the earliest time at which all members are connected
 * (i.e., every member is a friend of a friend of a friend ... of a friend).
 * Assume that the log file is sorted by timestamp and that friendship is an equivalence relation.
 * The running time of your algorithm should be mlogn or better and use extra space proportional to n.
 */
public class SocialConnectivity {
    int N = 8;
    int[] friendIds = new int[N];
    int[] sz = new int[N];

    SocialConnectivity() {
        for (int i = 0; i < N; i++) {
            friendIds[i] = i;
            sz[i] = 1;
        }
    }

    static class Relationship {
        int timestamp;
        int friendA, friendB;

        Relationship(int timestamp, int friendA, int friendB) {
            this.timestamp = timestamp;
            this.friendA = friendA;
            this.friendB = friendB;
        }
    }

    public static void main(String[] args) {
        SocialConnectivity s = new SocialConnectivity();

        Relationship[] rel = prepareTestRelData();

        for (Relationship r : rel) {
            boolean allConnected = s.unionTillMax(r.friendA, r.friendB);

            if (allConnected) {
                System.out.println("All connected: " + r.timestamp);
                System.exit(0);
            }
        }

        System.out.println("Not all connected");
    }

    boolean unionTillMax(int a, int b) {
        int rA = root(a);
        int rB = root(b);

        if (rA == rB) return false;
        if (rA < rB) {
            friendIds[rA] = rB;
            sz[rB] = sz[rB] + sz[rA];

            if (sz[rB] == N)
                return true;
        } else {
            friendIds[rB] = rA;
            sz[rA] = sz[rA] + sz[rB];

            if (sz[rA] == N)
                return true;
        }

        return false;
    }

    int root(int a) {
        while (a != friendIds[a]) {
            friendIds[a] = friendIds[friendIds[a]];

            a = friendIds[a];
        }

        return a;
    }

    static Relationship[] prepareTestRelData() {
        return new Relationship[]{
                new Relationship(0, 1, 4),
                new Relationship(1, 1, 7),
                new Relationship(2, 4, 0),
                new Relationship(9, 4, 5),
                new Relationship(13, 6, 1),
                new Relationship(25, 5, 3),
                new Relationship(27, 1, 3),
                new Relationship(37, 2, 3),
                new Relationship(47, 5, 3),
        };
    }
}