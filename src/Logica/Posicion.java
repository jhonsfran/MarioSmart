/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author user
 */
public class Posicion {
    
    int positionX;
    int positionY;
    
    //el mapa del mundo es una matriz 10 x 10 -> por lo que X representa las columnas y Y las filas
    
    public Posicion(int x, int y){
        this.positionX = x;
        this.positionY = y;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
      
    
}
