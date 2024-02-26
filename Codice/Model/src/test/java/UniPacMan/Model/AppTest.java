package UniPacMan.Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.AssetSetter;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	@Test
    public void testSpawnPointGhost() {
        AssetSetter assetSetter = new AssetSetter();
        int i = 2;
        int j = 1;
        int expected = 4;
        int actual = assetSetter.spawnPointGhost(i, j);
        assertEquals(expected, actual);
    }
}
