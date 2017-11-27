package digraph.challenges.wordnet;


import junit.framework.TestCase;
import org.junit.Test;

public class OutCastTest extends TestCase {

    @Test
    public void testOutCast() {
        WordNet net = new WordNet("wordnet/synsets500-subgraph.txt", "wordnet/hypernyms500-subgraph.txt");

        Outcast outcast = new Outcast(net);

        assertEquals("Otaheite_arrowroot", outcast.outcast(new String[]{
                "Otaheite_arrowroot",
                "actin",
                "adenosine_deaminase",
                "aldohexose",
                "agglutinin",
        }));
    }
}
