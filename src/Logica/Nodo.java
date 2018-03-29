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
public class Nodo {

    /** variables **/ 
    
    private Nodo padre;
    private Posicion posicion;
    private boolean tieneFlor;
    private int profundidad;
    private String operador;
    private int meta;
    //El ambiente es determinista y accesible para el agente
    private int[][] tableroDeJuego;
    private int costo;
    
    
    /* getter and setter */
    
    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public boolean isTieneFlor() {
        return tieneFlor;
    }

    public void setTieneFlor(boolean tieneFlor) {
        this.tieneFlor = tieneFlor;
    }

    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public int getMeta() {
        return meta;
    }

    public void setMeta(int meta) {
        this.meta = meta;
    }

    public int[][] getTableroDeJuego() {
        return tableroDeJuego;
    }

    public void setTableroDeJuego(int[][] tableroDeJuego) {
        this.tableroDeJuego = tableroDeJuego;
    }
    
    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    /*** Constructores ***/
    public Nodo(Nodo padre, boolean flor, int profundidad, String operador, int meta, int[][] tablero, int costo){
        
        //si nodo padre es null => el nodo es raiz
        this.padre = padre;
        
        //asigno la misma posicion del padre y luego aplico el movimiento correspondiente que se encarga de setear la posicion
        if (padre != null) {
            this.posicion = padre.getPosicion();
        }
        
        this.tieneFlor = flor;
        this.profundidad = profundidad;
        this.operador = operador;
        this.meta = meta;
        this.tableroDeJuego = tablero;
        this.costo = costo;
    
    }
    
    public Nodo() {

        this.padre = null;
        this.posicion = null;
        this.tieneFlor = false;
        this.profundidad = 0;
        this.operador = null;
        this.meta = -1;
        this.tableroDeJuego = null;
        this.costo = 0;

    }
    
    //operadores que se aplican al expadir el nodo  
    
    public Posicion subir(){
        
        Posicion pos = new Posicion(posicion.getPositionX()-1,posicion.getPositionY());        
        return pos;
    }
        
    public Posicion bajar() {
        
        Posicion pos = new Posicion(posicion.getPositionX()+1,posicion.getPositionY()); 
        return pos;
    }
    
    public Posicion izquierda() {
        
        Posicion pos = new Posicion(posicion.getPositionX(),posicion.getPositionY()-1); 
        return pos;
    }
    
    public Posicion derecha() {
        
        Posicion pos = new Posicion(posicion.getPositionX(),posicion.getPositionY()+1); 
        return pos;
    }
    
    /**
     * ********************* validadores de los movimientos *********
     */
    public boolean puedeSubir() {

        if (posicion.getPositionX() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean puedeBajar() {

        if (posicion.getPositionX() != 10) {
            return true;
        } else {
            return false;
        }
    }

    public boolean puedeIzquierda() {

        if (posicion.getPositionY() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean puedeDerecha() {

        if (posicion.getPositionY() != 10) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean esMeta(){
        //si la posicion actual de mario tiene el valor igual a la meta => esMeta
        if (meta == tableroDeJuego[posicion.getPositionX()][posicion.getPositionY()]) {
            return true;
        }else{
            return false;
        }
    }
    
    public boolean tieneFlor(){
        //si la posicion actual de mario tiene el valor igual a la meta => esMeta
        if (tableroDeJuego[posicion.getPositionX()][posicion.getPositionY()] == 3) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean seEstaDevolviendo(Posicion pos){
        
        //se busca la posicion del padre y se pregunta se la posicion actual es igual a la del padre
        if (padre != null) {
            if (pos.getPositionX() == padre.getPosicion().getPositionX() && pos.getPositionY() == padre.getPosicion().getPositionY()) {
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }

    }

    public Nodo expandir(String operador) {
               
        Nodo miNodo = new Nodo(this, this.isTieneFlor(), this.profundidad+1, null, this.meta, this.tableroDeJuego, this.costo+1);
        //variable que cambia la posicion
        Posicion pos;
        
        switch (operador) {
            case "subir"://camino libre costo 1
                pos = miNodo.subir();
                miNodo.setPosicion(pos);
                break;
            case "bajar"://camino libre costo 1
                pos = miNodo.bajar();
                miNodo.setPosicion(pos);
                break;
            case "izquierda"://camino libre costo 1
                pos = miNodo.izquierda();
                miNodo.setPosicion(pos);
                break;
            case "derecha"://camino libre costo 1
                pos = miNodo.derecha();
                miNodo.setPosicion(pos);
                break;                
        }
        
        //seteo el operador que acabo de aplicar
        miNodo.setOperador(operador);
        //verifico que tenga flor. Si la flor ya es true no se puede volver a setear
        if (!this.isTieneFlor()) {
            miNodo.setTieneFlor(this.tieneFlor());
        }
                
        return miNodo;
    }
    
    
    
    
}
