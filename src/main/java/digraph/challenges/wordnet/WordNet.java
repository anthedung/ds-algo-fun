package digraph.challenges.wordnet;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordNet {
    private final Map<Integer, String> idToSynetMap = new HashMap<>();
    private final Map<String, Bag<Integer>> wordToIdsMap = new HashMap<>();
    private final Set<String> wordBag = new HashSet<>();
    private final SAP sap;

    private int v;

    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        if (synsets == null || hypernyms == null) throw new IllegalArgumentException();

        In synIn = new In(synsets);

        // init bag of string
        while (synIn.hasNextLine()) {
            v++;

            String[] components = synIn.readLine().split(",");
            int id = Integer.parseInt(components[0]);
            idToSynetMap.put(id, components[1]);

            String[] words = components[1].split("\\s");
            for (int i = 0; i < words.length; i++) {
                wordBag.add(words[i]);

                if (wordToIdsMap.get(words[i]) == null) {
                    wordToIdsMap.put(words[i], new Bag<>());
                }
                wordToIdsMap.get(words[i]).add(id);
            }
        }

        // init WordNetGraph
        Digraph wordNetGraph = new Digraph(v);

        In hyper = new In(hypernyms);

        while (hyper.hasNextLine()) {
            String[] ids = hyper.readLine().split(",");

            // build edges
            for (int i = 1; i < ids.length; i++) {
                wordNetGraph.addEdge(Integer.parseInt(ids[0]), Integer.parseInt(ids[i]));
            }
        }

        sap = new SAP(wordNetGraph);
    }

    // returns all WordNet nouns
    public Iterable<String> nouns() {
        return wordBag;
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word) {
        checkArg(word);
        return wordToIdsMap.get(word) != null;
    }

    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB) {
        checkArg(nounA, nounB);
        if (!isNoun(nounA) || !isNoun(nounB)) throw new IllegalArgumentException();

        // O(1)
        Bag<Integer> synetIdsA = wordToIdsMap.get(nounA);

        // O(1)
        Bag<Integer> synetIdsB = wordToIdsMap.get(nounB);

        return sap.length(synetIdsA, synetIdsB);
    }

    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB) {
        checkArg(nounA, nounB);
        if (!isNoun(nounA) || !isNoun(nounB)) throw new IllegalArgumentException();

        // O(1)
        Bag<Integer> synetIdsA = wordToIdsMap.get(nounA);

        // O(1)
        Bag<Integer> synetIdsB = wordToIdsMap.get(nounB);

        return idToSynetMap.get(sap.ancestor(synetIdsA, synetIdsB));
    }

    private void checkArg(String... args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i] == null) throw new IllegalArgumentException();
        }
    }
}
