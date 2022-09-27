package edu.ayham.cassebrique;

import java.awt.*;
import java.util.ArrayList;

public class Balle {
    protected int x;
    protected int y;
    protected int vitesseHorizontal;
    protected int vitesseVertical;
    protected int diametre;
    protected int diametreReflet;
    protected int decalageReflet;
    protected Color colour;

    protected ArrayList<Balle> listePoints = new ArrayList<>();
    protected long indexFrame = 0;

    public Balle(int x, int y, int vtisseHorizontal, int vitesseVertical, int diametre, Color colour) {
        this.x = x;
        this.y = y;
        this.vitesseHorizontal = vtisseHorizontal ==0?1:vtisseHorizontal;
        this.vitesseVertical = vitesseVertical==0?1:vitesseVertical;
        this.diametre = diametre;
        this.colour = colour;
       this.setDiametre(diametre); //attention!
    }

    public Balle(int x, int y) {
        this.x = x;
        this.y = y;
        this.colour = Color.MAGENTA;
        this.setDiametre(5);
    }


    public void deplacer (){
        x += vitesseHorizontal;
        y += vitesseVertical;
    } //attention

    public void inverseVitesseHreozontal() {
        vitesseHorizontal*=-1;
    } //attention

    public void inverseVitesseVertical() {
        vitesseVertical*=-1;
    } //attention

    public void dessiner (Graphics2D dessin) {
        indexFrame++;
        if (indexFrame %10 ==0 && vitesseVertical != 0 && vitesseHorizontal!=0) {
            listePoints.add(new Balle(x,y)) ;

        }

        dessin.setColor(colour);
        dessin.fillOval(x,y,diametre,diametre);
        dessin.setColor(Color.WHITE);
        dessin.fillOval(x +decalageReflet,y+decalageReflet,diametreReflet,diametreReflet);


        for (Balle balle :listePoints
             ) {
            balle.dessiner(dessin);
        }
    }


    public void testCollisition (int largeurEcran, int hauteurgeurEcran){
        if (x<0 ||x>largeurEcran -diametre) {
            inverseVitesseHreozontal();
        }
        if (y<0 ||y>hauteurgeurEcran -diametre) {
           inverseVitesseVertical();
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVtesseHorizontal() {
        return vitesseHorizontal;
    }

    public void setVtesseHorizontal(int vtesseHorizontal) {
        this.vitesseHorizontal = vtesseHorizontal;
    }

    public int getVitesseVertical() {
        return vitesseVertical;
    }

    public void setVitesseVertical(int vitesseVertical) {
        this.vitesseVertical = vitesseVertical;
    }

    public int getDiametre() {
        return diametre;
    }

    public void setDiametre(int diametre) {
        this.diametre = diametre;
        this.diametreReflet= (int) (diametre*0.3f); //attention!
        this.decalageReflet= (int) (diametre*0.2f); //attention!
    }

    public int getDiametreReflet() {
        return diametreReflet;
    }


    public int getDecalageReflet() {
        return decalageReflet;
    }



    public Color getColour() {
        return colour;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }

    public ArrayList<Balle> getListePoints() {
        return listePoints;
    }

    public void setListePoints(ArrayList<Balle> listePoints) {
        this.listePoints = listePoints;
    }



}
