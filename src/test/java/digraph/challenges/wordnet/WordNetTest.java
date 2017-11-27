package digraph.challenges.wordnet;


import junit.framework.TestCase;
import org.junit.Test;

import java.util.Set;

public class WordNetTest extends TestCase {

    @Test
    public void testWordNet() {
        WordNet net = new WordNet("wordnet/synsets500-subgraph.txt", "wordnet/hypernyms500-subgraph.txt");

        assertTrue(net.isNoun("aldohexose"));
        assertEquals(6, net.distance("aldohexose", "enzyme"));
        assertEquals("macromolecule supermolecule", net.sap("aldohexose", "enzyme"));
        assertEquals(751, ((Set) net.nouns()).size());
    }
}
