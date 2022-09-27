package edu.ayham.cassebrique;

import edu.ayham.cassebrique.Balle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CasseBrique extends Canvas {

    protected int largeurEcran = 500;
    protected int hauteurgeurEcran = 700;
    public CasseBrique() throws InterruptedException {


        JFrame fenetre = new JFrame("Casse brique");
        //On récupère le panneau de la fenetre principale
        JPanel panneau = (JPanel) fenetre.getContentPane();
        //On définie la hauteur / largeur de l'écran
        panneau.setPreferredSize(new Dimension(largeurEcran, hauteurgeurEcran));
        setBounds(0, 0, largeurEcran,hauteurgeurEcran);
        //On ajoute cette classe (qui hérite de Canvas) comme composant du panneau principal
        panneau.add(this);

        fenetre.pack();
        fenetre.setResizable(false);
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fenetre.requestFocus();

        //On indique que le raffraichissement de l'ecran doit être fait manuellement.
        createBufferStrategy(2);
        setIgnoreRepaint(true);
        this.setFocusable(false);

        demarrer();
    }

    public void demarrer() throws InterruptedException {

        long indexFrame = 0;

        ArrayList<Balle> listBalles = new ArrayList<>();
        for (int i = 0; i<1; i++)
        {
            listBalles.add(new Balle(
                    (int)(Math.random()*largeurEcran),
                    (int)(Math.random()*hauteurgeurEcran),
                    (int)(Math.random()*5),
                    (int)(Math.random()*5),
                    (int)(Math.random()*25),
                    new Color((float) Math.random(),(float) Math.random(),(float) Math.random())));
        }



       /*Balle balle = new Balle(
               250,
               250,
               4,
               -6,
               30,
               Color.RED);

        Balle balle1 = new Balle(
                250,
                250,
                4,
                -5,
                30,
                Color.GREEN);

        Balle balle2 = new Balle(
                250,
                250,
                3,
                -6,
                30,
                Color.BLUE);*/

        while(true) {
            indexFrame ++;


            Graphics2D dessin = (Graphics2D) getBufferStrategy().getDrawGraphics();

            //-----------------------------
            //reset dessin
            dessin.setColor(Color.WHITE);
            dessin.fillRect(0,0,largeurEcran,hauteurgeurEcran);

            //dessin balle

            for (Balle balle:listBalles
            ) {
                balle.deplacer();
                balle.dessiner(dessin);
                balle.testCollisition(largeurEcran,hauteurgeurEcran);
            }


           /* balle.deplacer();
            balle1.deplacer();
            balle2.deplacer();
            balle.dessiner(dessin);
            balle1.dessiner(dessin);
            balle2.dessiner(dessin);*/

            //balle.setX(balle.getX()+balle.getVtesseHorizontal());
            //balle.setY(balle.getY()+balle.getVitesseVertical());


            //dessin.setColor(balle.getColour());
            //dessin.fillOval(balle.getX(),balle.getY(), balle.getDiametre(),balle.getDiametre());

            //dessin.setColor(Color.WHITE);
            //dessin.fillOval(balle.getX() + balle.getDecalageReflet(), balle.getY() +balle.getDecalageReflet(), balle.getDiametreReflet() , balle.getDiametreReflet());

            //mouvement balle

            //balle.tesrcollision
            /*balle.testCollisition();
            balle1.testCollisition();
            balle2.testCollisition();*/

           /* if (balle.getX()<0 || balle.getX()>500 -balle.getDiametre()){balle.inverseVitesseHreozontal();
                //if (balle.getX()<0 || balle.getX()>500 -balle.getDiametre()){balle.setVtesseHorizontal(balle.getVtesseHorizontal()*-1);
                    //vitesseHorizontalBalle=*vitesseHorizontalBalle*-1
            }
            if (balle.getY()<0 || balle.getY()>700-balle.getDiametre()){balle.inverseVitesseVertical();
            }*/


          /*  if (balle1.getX()<0 || balle1.getX()>500 -balle1.getDiametre()) {
                balle1.inverseVitesseHreozontal();
            }
            if (balle1.getY()<0 || balle1.getY()>700-balle1.getDiametre()){balle1.inverseVitesseVertical();
            }*/




            //-----------------------------
            dessin.dispose();
            getBufferStrategy().show();
            Thread.sleep(1000 / 60);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new CasseBrique();
    }
}