package tree;

import junit.framework.TestCase;
import org.junit.Test;

public class TrieTest extends TestCase {

    @Test
    public void testTrie() {
        Trie contacts = new Trie();
        contacts.add("hack");
        contacts.add("hack");
        contacts.add("hackerrank");
        contacts.add("hackerranking");

        assertEquals(3, contacts.findPartial("hack"));
        assertEquals(0, contacts.findPartial("hak"));
    }
}
