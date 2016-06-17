/**
 * MagicP4 IUT Lyon 1 - 2016
 */
package model;

import java.util.Random;

/**
 *
 * @author hakkahi - IUT Lyon 1 - 2016
 */
public class AppearEffect extends Effect {

    /**
     * This effect changes the color of the tile that has just been played and
     * thus the owner of the tile)
     *
     * @param line
     * @param column
     * @param game
     */
    @Override
    public void playEffect(int line, int column, Game game) {

        /*
         On initialise les borne de notre nombre aleatoire
         le max est égale au nombre de colones de la board -1
         */
        int min = 0;
        int max = game.getBoard().getWidth() - 1;

        Random rand = new Random();
        /*
        On genere le nombre aleatoire
        on appelle la méthode .playMove en envoyant comme paramettre un numero de colene aleatoir
        ainsi la fonction ajoute un autre pions sur une colone aleatoire
         */
        int random = rand.nextInt(max - min + 1) + min;

        game.playMove(random);
    }

}
