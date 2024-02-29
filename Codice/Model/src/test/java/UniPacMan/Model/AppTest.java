package UniPacMan.Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.AssetSetter;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	//testiamo vari punti della mappa di spawn
	@Test
    public void testSpawnPointGhost() {
        AssetSetter assetSetter = new AssetSetter();
        int i = 2;
        int j = 1;
        int expected = 4;
        int actual = assetSetter.spawnPointGhost(i, j);
        assertEquals(expected, actual);
    }
	
	@Test
    public void testSpawnPointGhost1() {
        AssetSetter assetSetter = new AssetSetter();
        int i = 1;
        int j = 0;
        int expected = 10;
        int actual = assetSetter.spawnPointGhost(i, j);
        assertEquals(expected, actual);
    }
	
	@Test
    public void testSpawnPointGhost2() {
        AssetSetter assetSetter = new AssetSetter();
        int i = 2;
        int j = 0;
        int expected = 11;
        int actual = assetSetter.spawnPointGhost(i, j);
        assertEquals(expected, actual);
    }
	
	@Test
    public void testSpawnPointGhost3() {
        AssetSetter assetSetter = new AssetSetter();
        int i = 3;
        int j = 0;
        int expected = 12;
        int actual = assetSetter.spawnPointGhost(i, j);
        assertEquals(expected, actual);
    }
	
	@Test
    public void testSpawnPointGhost4() {
        AssetSetter assetSetter = new AssetSetter();
        int i = 3;
        int j = 0;
        int expected = 2;
        int actual = assetSetter.spawnPointGhost(i, j);
        assertNotEquals(expected, actual);
    }
}
