package union_find.challenges;

import junit.framework.TestCase;
import org.junit.Test;


public class SocialConnectivityTest extends TestCase {

    @Test
    public void testUnionTillMax() {
        SocialConnectivity s = new SocialConnectivity();

        SocialConnectivity.Relationship[] rel = prepareTestRelData();

        for (SocialConnectivity.Relationship r : rel) {
            boolean allConnected = s.unionTillMax(r.friendA, r.friendB);

            if (allConnected) {
                assertEquals(37, r.timestamp);
            }
        }
    }

    static SocialConnectivity.Relationship[] prepareTestRelData() {
        return new SocialConnectivity.Relationship[]{
                new SocialConnectivity.Relationship(0, 1, 4),
                new SocialConnectivity.Relationship(1, 1, 7),
                new SocialConnectivity.Relationship(2, 4, 0),
                new SocialConnectivity.Relationship(9, 4, 5),
                new SocialConnectivity.Relationship(13, 6, 1),
                new SocialConnectivity.Relationship(25, 5, 3),
                new SocialConnectivity.Relationship(27, 1, 3),
                new SocialConnectivity.Relationship(37, 2, 3),
                new SocialConnectivity.Relationship(47, 5, 3),
        };
    }
}