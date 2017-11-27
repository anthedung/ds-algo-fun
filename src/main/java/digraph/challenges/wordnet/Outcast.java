package digraph.challenges.wordnet;

public class Outcast {
    private WordNet wordNet;

    public Outcast(WordNet wordnet) {
        this.wordNet = wordnet;
    }

    public String outcast(String[] nouns) {
        int[] dis = new int[nouns.length];

        int maxDis = -1;
        String mostDis = null;
        for (int i = 0; i < nouns.length; i++) {
            for (int j = 0; j < nouns.length; j++) {
                if (i != j)
                    dis[i] += wordNet.distance(nouns[i], nouns[j]);
            }
            if (maxDis < dis[i]) {
                maxDis = dis[i];
                mostDis = nouns[i];
            }
        }

        return mostDis;
    }
}
