/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos;

import Logica.Nodo;
import Logica.Posicion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author user
 */
public class BusquedaAmplitud {
    
    private int tablero[][];
    private Nodo raiz;
    private LinkedList<Nodo> arbol;
    int cantidadNodosExpandidos = 0;
    long TFin, tiempo; //Variables para determinar el tiempo de ejecución
    long TInicio = System.currentTimeMillis();
    private String informacionAgente = "";

    public String getInformacionAgente() {
        return informacionAgente;
    }

    public void setInformacionAgente(String informacionAgente) {
        this.informacionAgente = informacionAgente;
    }

    public int getCantidadNodosExpandidos() {
        return cantidadNodosExpandidos;
    }

    public void setCantidadNodosExpandidos(int cantidadNodosExpandidos) {
        this.cantidadNodosExpandidos = cantidadNodosExpandidos;
    }

    public int[][] getRutaTablero() {
        return rutaTablero;
    }

    public void setRutaTablero(int[][] rutaTablero) {
        this.rutaTablero = rutaTablero;
    }
    
    private int[][] rutaTablero;
    
    public int[][] getTablero() {
        return tablero;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public LinkedList<Nodo> getArbol() {
        return arbol;
    }

    public void setArbol(LinkedList<Nodo> arbol) {
        this.arbol = arbol;
    }
    
    
    public void addElementArbol(Nodo n){
        this.arbol.addLast(n);
    }
    
    public void removeElementArbol(Nodo n) {
        this.arbol.remove(n);
    }
    
    public BusquedaAmplitud(int tablero[][]) {
        this.tablero = tablero;
        this.raiz = new Nodo();
        this.arbol = new LinkedList<>();
    }

    public void buscarRaiz() throws Exception{
        
        Nodo miNodoRaiz = null;
    
        for (int i = 0; i < this.tablero.length; i++) {
            for (int j = 0; j < this.tablero.length; j++) {
                
                if (this.tablero[i][j] == 2) {
                                    
                    miNodoRaiz = new Nodo(null, false, 0, null, 5, this.tablero, 0);
                    // i es x y j es y
                    Posicion pos = new Posicion(i,j);
                    miNodoRaiz.setPosicion(pos);
                    
                    break;
                    
                }
                
            }
        }
        
        if (miNodoRaiz.getMeta() == 0) {
            throw new Exception("Mario no esta en el archivo");
        }else{
            //ingreso el elemento raiz al arbol de busqueda
            this.raiz = miNodoRaiz;
            addElementArbol(miNodoRaiz);
        }
    }
    
    public void buscarMeta() throws Exception {

        Nodo miNodoMeta = null;

        for (int i = 0; i < this.tablero.length; i++) {
            for (int j = 0; j < this.tablero.length; j++) {

                if (this.tablero[i][j] == 5) {

                    miNodoMeta = new Nodo(null, false, 0, null, 5, this.tablero, 0);
                    // i es x y j es y
                    Posicion pos = new Posicion(i, j);
                    miNodoMeta.setPosicion(pos);

                    break;

                }

            }
        }

        if (miNodoMeta.getMeta() == 0) {
            throw new Exception("La meta no esta en el archivo");
        }
    }
    
    public int[][] aplicarBusqueda(){
    
        Iterator<Nodo> nombreIterator = this.arbol.iterator();

        while (nombreIterator.hasNext()) {

            Nodo nodoToExpand = nombreIterator.next();
            expandirNodo(nodoToExpand);
            nombreIterator = this.arbol.iterator();
            
        }
        
        return rutaTablero;
        
    
    }
    
    public void expandirNodo(Nodo nodo){
    
        Nodo nodoExpandido = null;
        
        
        if (!nodo.esMeta()) {
            
            ArrayList<String> movimientos = validarMovimientos(nodo);
            
            Iterator<String> nombreIterator = movimientos.iterator();
            
            while (nombreIterator.hasNext()) {
                
                String operador = nombreIterator.next();
                System.out.println("operador a expandir " + operador);
                informacionAgente += "<b>Operador aplicado</b>: " + operador + "<br>";
                nodoExpandido = nodo.expandir(operador);
                //ingreso el elemento expandido al arbol de busqueda
                addElementArbol(nodoExpandido);
                
                //aumento uno la cantidad de los nodos expandidos
                this.cantidadNodosExpandidos++;
                
                //System.out.println("\n\nPosicion X Padre: " + nodo.getPosicion().getPositionX());
                //System.out.println("Posicion Y Padre: " + nodo.getPosicion().getPositionY());
                //System.out.println("Tiene flor Padre: " + nodo.isTieneFlor());
                //System.out.println("Posicion X: " + nodoExpandido.getPosicion().getPositionX());
                //System.out.println("Posicion Y: " + nodoExpandido.getPosicion().getPositionY());
                //System.out.println("Tiene flor: " + nodoExpandido.isTieneFlor());

                
            }
            
            //luego de que se expanda lo que hago es eliminar el nodo expandido del arbol de busqueda
            removeElementArbol(nodo);
            
        }else{
            System.out.println("\n\nSe encontro la meta");
            informacionAgente += "<br><br><b>Se encontro la meta</b><br><br>";
            informacionAgente += "<b>Profundidad del arbol:</b>: " + nodo.getProfundidad() + "<br>";
                      
            System.out.println("Profundidad del arbol: " + nodo.getProfundidad());
            
            //genero la ruta
            generarRuta(nodo);
            //elimino todos los elementos del arbol
            this.arbol.removeAll(arbol);
            
            TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
            tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
            System.out.println("Tiempo de ejecución en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos
            
            informacionAgente += "<b>Tiempo de ejecución en milisegundos:</b>: " + tiempo + "<br>";
            informacionAgente += "<b>Cantidad de nodos expandidos:</b>: " + getCantidadNodosExpandidos() + "<br>";
        }
    
    }
    
    public int[][] generarRuta(Nodo nodo){
        
        Nodo miNodo = nodo;
        int valorRuta = 0;
        
        
        while(miNodo.getProfundidad() != 0){
            
            //System.out.println("Padre : " + miNodo.getProfundidad());
            //ruta.addLast(miNodo.getPosicion());
            if (miNodo.isTieneFlor()) {
                //mario con flor 
                valorRuta = 6; 
            }else{
                //mario sin flor
                valorRuta = 2; 
            }
            
            if (tablero[miNodo.getPosicion().getPositionX()][miNodo.getPosicion().getPositionY()] == 5) {
                //mario con princesa 
                valorRuta = 7; 
            }
            
            //copio la ruta del tablero inicial
            rutaTablero = this.tablero;
            rutaTablero[miNodo.getPosicion().getPositionX()][miNodo.getPosicion().getPositionY()] = valorRuta;
            miNodo = miNodo.getPadre();
        }
        
        return rutaTablero;
    }
    
    public ArrayList<String> validarMovimientos(Nodo nodo) {
        
        //este es el orden de los operadores. Asi se ejecutaran al expandir el nodo
        String operadores[] = {"subir","bajar","izquierda","derecha"};
        ArrayList<String> salida = new ArrayList<String>();
        int valorTablero = 0;
        //verifica si al realizar la operacion el agente no se sale del mundo 10 x 10
        boolean limiteMundo = false;
        //verifico que la posicion a la cual me muevo no signifique que me estoy devolviendo
        boolean devolviendo = false;
        //esta variable me sirve para guardar la posicion temporal del movimiento
        Posicion pos = null;
        
        for (int i = 0; i < operadores.length; i++) {
        
            switch (operadores[i]) {
                
                case "subir"://camino libre costo 1
                    
                    try{
                        
                        valorTablero = tablero[nodo.getPosicion().getPositionX()-1][nodo.getPosicion().getPositionY()];
                        limiteMundo = nodo.puedeSubir();
                        pos = new Posicion(nodo.getPosicion().getPositionX()-1,nodo.getPosicion().getPositionY());
                        devolviendo = nodo.seEstaDevolviendo(pos);
                        //System.out.println("\n\npara validar " + operadores[i] + " : \n reglas del mundo: " + reglasMundo(valorTablero, nodo.tieneFlor()) + "\nlimite del mundo : " + limiteMundo + "\ndevolviendo : " + devolviendo);

                        break;
                    
                    //por si el index del array llega a un valor raro
                    }catch(ArrayIndexOutOfBoundsException e){
                        
                        valorTablero = 100;
                        break;
                    }
                    
                    
                case "bajar"://camino libre costo 1
                    
                    try{
                    
                        valorTablero = tablero[nodo.getPosicion().getPositionX()+1][nodo.getPosicion().getPositionY()];
                        limiteMundo = nodo.puedeBajar();
                        pos = new Posicion(nodo.getPosicion().getPositionX()+1, nodo.getPosicion().getPositionY());
                        devolviendo = nodo.seEstaDevolviendo(pos);
                        //System.out.println("\n\npara validar " + operadores[i] + " : \n reglas del mundo: " + reglasMundo(valorTablero, nodo.tieneFlor()) + "\nlimite del mundo : " + limiteMundo + "\ndevolviendo : " + devolviendo);

                        break;
                    
                    }catch(ArrayIndexOutOfBoundsException e){
                        
                        valorTablero = 100;
                        break;
                    }

                case "izquierda"://camino libre costo 1
                    
                                        
                    try{
                        
                        valorTablero = tablero[nodo.getPosicion().getPositionX()][nodo.getPosicion().getPositionY()-1];
                        limiteMundo = nodo.puedeIzquierda();
                        pos = new Posicion(nodo.getPosicion().getPositionX(),nodo.getPosicion().getPositionY()-1);
                        devolviendo = nodo.seEstaDevolviendo(pos);
                        //System.out.println("\n\npara validar " + operadores[i] + " : \n reglas del mundo: " + reglasMundo(valorTablero, nodo.tieneFlor()) + "\nlimite del mundo : " + limiteMundo + "\ndevolviendo : " + devolviendo);

                        break;
                    
                    }catch(ArrayIndexOutOfBoundsException e){
                        
                        valorTablero = 100;
                        break;
                    }
                    
                case "derecha"://camino libre costo 1
                    
                    try{
                        
                        valorTablero = tablero[nodo.getPosicion().getPositionX()][nodo.getPosicion().getPositionY()+1];
                        limiteMundo = nodo.puedeDerecha();
                        pos = new Posicion(nodo.getPosicion().getPositionX(),nodo.getPosicion().getPositionY()+1);
                        devolviendo = nodo.seEstaDevolviendo(pos);
                        //System.out.println("\n\npara validar " + operadores[i] + " : \n reglas del mundo: " + reglasMundo(valorTablero, nodo.tieneFlor()) + "\nlimite del mundo : " + limiteMundo + "\ndevolviendo : " + devolviendo );

                        break;
                    
                    }catch(ArrayIndexOutOfBoundsException e){
                        
                        valorTablero = 100;
                        break;
                    }
                    
            }
            
            
            //si cumple con las reglas del mundo y no se sale del mapa y ademas no se devuelve => puede aplicar el operador
            //evitando devolverme
            if (reglasMundo(valorTablero, nodo.isTieneFlor()) && limiteMundo && !devolviendo) {
            //no evite devolverse
            //if (reglasMundo(valorTablero, nodo.isTieneFlor()) && limiteMundo) {
            
                //System.out.println("\n\nse anade el operador" + operadores[i]);
                salida.add(operadores[i]);
            }
        
        }
        
        return salida;
    }
    
    public boolean reglasMundo(int valor, boolean tieneFlor) {
        
        boolean validar = false; 
        
        switch (valor) {
            
            case 0://camino libre
                validar = true;
                break;
            case 1://muro no se puede pasar
                validar = false;
                break;
            case 3://flor
                validar = true;
                break;
            case 4://tortuga costo 7
                
                //si tiene flor puedo pasar por las tortugas
                if (tieneFlor) {
                    validar = true;
                }else{
                    validar = false;
                }
                
                break;
            case 5://princesa
                validar = true;
                break;
                
            default:
                validar = false;
                break;
        }
                
        return validar;
    }
}
