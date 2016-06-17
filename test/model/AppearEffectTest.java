package model;

import static model.AppearEffectTest.aGame;
import static model.ChangeColorEffectTest.aGame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author p1500787
 */
public class AppearEffectTest {
    
    static Game aGame;
    
    public AppearEffectTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {

        // Création d'un jeu vide
        aGame = new Game();
        Board b = new Board(10, 10);
        aGame.setBoard(b);

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of playEffect method, of class AppearEffect.
     */
     @Test
        public void testDisappearEffectEmptyGame() {
     
            // Effet fixé sur une case 
            int height = aGame.getBoard().getHeight();
            aGame.getBoard().getTileIJ(height - 1, 0).setEffect(new AppearEffect());
     
            // Récupération de l'ID du joueur courant 
            int id_player = aGame.getCurrentPlayer().getId();
            
            // Récupération du nombre de pions sur le board
            int nbPions = aGame.getBoard().getTotalTilesCount();
            
            // Coup joué sur la case de l'effet 
            aGame.playMove(0);
            
            // Vérifications :
            // - la case est bien vide après
            // - l'effet est bien appliqué sur la case 
            // - le tour de jeu a bien changé
            // - le nombre de pions ajouté apres le tour à bien augmenté de 2
            assertEquals(1, aGame.getBoard().getTileIJ(height - 1, 0).getStatus());
            assertTrue("Doit être d'effet appear", aGame.getBoard().getTileIJ(height - 1, 0).getEffect() instanceof AppearEffect);
            assertEquals(nbPions + 2, aGame.getBoard().getTotalTilesCount());
        }
    
}
