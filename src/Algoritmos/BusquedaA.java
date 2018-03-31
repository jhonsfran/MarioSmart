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
import java.util.PriorityQueue;
import java.util.Queue;


public class BusquedaA {
    
    private int tablero[][];
    private Nodo raiz;
    private Nodo meta;
    private Queue<Nodo> arbol;
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

    public Queue<Nodo> getArbol() {
        return arbol;
    }

    public void setArbol(Queue<Nodo> arbol) {
        this.arbol = arbol;
    }
    
    
    public void addElementArbol(Nodo n){
        this.arbol.add(n);
    }
    
    public void removeElementArbol(Nodo n) {
        this.arbol.remove(n);
    }
    
    public BusquedaA(int tablero[][]) {
        
        this.tablero = tablero;
        this.raiz = new Nodo();
        this.arbol = new PriorityQueue<Nodo>();
        
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
        
    public void buscarMeta() throws Exception{
        
        Nodo miNodoMeta = null;
    
        for (int i = 0; i < this.tablero.length; i++) {
            for (int j = 0; j < this.tablero.length; j++) {
                
                if (this.tablero[i][j] == 5) {
                                    
                    miNodoMeta = new Nodo(null, false, 0, null, 5, this.tablero, 0);
                    // i es x y j es y
                    Posicion pos = new Posicion(i,j);
                    miNodoMeta.setPosicion(pos);
                    
                    break;
                    
                }
                
            }
        }
        
        if (miNodoMeta.getMeta() == 0) {
            throw new Exception("La meta no esta en el archivo");
        }else{
            this.meta = miNodoMeta;
        }
    }
    
    public int[][] aplicarBusqueda(){
        
        while (!arbol.isEmpty()) {
            
            Nodo nodoToExpand = arbol.element();            
            expandirNodo(nodoToExpand);
            
        }
        
        return rutaTablero;
        
    
    }
    
    public void expandirNodo(Nodo nodo){
    
        System.out.println("Costo del nodo " + nodo.getCosto());
        System.out.println("Heuristica del nodo " + nodo.getHeuristica());
        
        /*
        Nodo nodoExpandido1 = new Nodo(null, false, 0, null, 0, null, 0);
        nodoExpandido1.setTieneHeuristica(true);
        nodoExpandido1.setHeuristica(6);
        
        Nodo nodoExpandido2 = new Nodo(null, false, 0, null, 0, null, 0);
        nodoExpandido2.setTieneHeuristica(true);
        nodoExpandido2.setHeuristica(8);
        
        Nodo nodoExpandido3 = new Nodo(null, false, 0, null, 0, null, 0);
        nodoExpandido3.setTieneHeuristica(true);
        nodoExpandido3.setHeuristica(1);
        
        Nodo nodoExpandido4 = new Nodo(null, false, 0, null, 0, null, 0);
        nodoExpandido4.setTieneHeuristica(true);
        nodoExpandido4.setHeuristica(0);
        
        Nodo nodoExpandido5 = new Nodo(null, false, 0, null, 0, null, 0);
        nodoExpandido5.setTieneHeuristica(true);
        nodoExpandido5.setHeuristica(3);

        //ingreso el elemento expandido al arbol de busqueda
        addElementArbol(nodoExpandido1);
        addElementArbol(nodoExpandido2);
        addElementArbol(nodoExpandido3);
        addElementArbol(nodoExpandido4);
        addElementArbol(nodoExpandido5);
        
        while (!arbol.isEmpty()) {
            
            Nodo nodoToExpand = arbol.element();
            System.out.println("heuristica del elemento " + nodoToExpand.getHeuristica());
            arbol.remove();

        }
        */
        
        
        Nodo nodoExpandido = null;
        
        if (!nodo.esMeta()){
            
            ArrayList<String> movimientos = validarMovimientos(nodo);
            
            Iterator<String> nombreIterator = movimientos.iterator();
            
            while (nombreIterator.hasNext()) {
                
                String operador = nombreIterator.next();
                System.out.println("\n\noperador a expandir " + operador);
                informacionAgente += "<b>Operador aplicado</b>: " + operador + "<br>";
                nodoExpandido = nodo.expandir(operador);
                
                //seteo la heuristica - al setear el campo de tiene heuristica cambio la prioridad de la cola
                nodoExpandido.setTieneHeuristica(true);
                nodoExpandido.setHeuristica(f(nodoExpandido),false);
                
                //ingreso el elemento expandido al arbol de busqueda
                addElementArbol(nodoExpandido);
                
                //aumento uno la cantidad de los nodos expandidos
                this.cantidadNodosExpandidos++;
                
                System.out.println("Tiene Heuristica: " + nodoExpandido.isTieneHeuristica());
                System.out.println("Valor Heuristica: " + nodoExpandido.getHeuristica());
                
                
                System.out.println("\n\nPosicion X Padre: " + nodo.getPosicion().getPositionX());
                System.out.println("Posicion Y Padre: " + nodo.getPosicion().getPositionY());
                System.out.println("Tiene flor Padre: " + nodo.isTieneFlor());
                System.out.println("Posicion X: " + nodoExpandido.getPosicion().getPositionX());
                System.out.println("Posicion Y: " + nodoExpandido.getPosicion().getPositionY());
                System.out.println("Tiene flor: " + nodoExpandido.isTieneFlor());
                
            }
            
            //luego de que se expanda lo que hago es eliminar el nodo expandido del arbol de busqueda
            removeElementArbol(nodo);
            
            
        }else{
            
            System.out.println("<br><br>Se encontro la meta");
            informacionAgente += "<br><br><b>Se encontro la meta</b><br><br>";
            System.out.println("Costo de la meta: " + nodo.getCosto()); 
            
            informacionAgente += "<b>Costo de la meta:</b>: " + nodo.getCosto() + "<br>";
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
            //if (reglasMundo(valorTablero) && limiteMundo) {
                
                //System.out.println("\n\npara validar " + operadores[i] + " : \n reglas del mundo: " + reglasMundo(valorTablero) + "\nlimite del mundo : " + limiteMundo + "\ndevolviendo : " + devolviendo);
            
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
                } else {
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
    
    //diseno de la funcion heuristica
    public int f(Nodo nodo){
        
        System.out.println("Valor de las coordenadas meta X: " + meta.getPosicion().getPositionX());
        System.out.println("Valor de las coordenadas meta Y: " + meta.getPosicion().getPositionY());
        
        
        System.out.println("Valor de las coordenadas actual X: " + nodo.getPosicion().getPositionX());
        System.out.println("Valor de las coordenadas actual Y: " + nodo.getPosicion().getPositionY());
                
        //distancia de manhathan
        int heuristica = Math.abs(meta.getPosicion().getPositionX() - nodo.getPosicion().getPositionX()) + Math.abs(meta.getPosicion().getPositionY() - nodo.getPosicion().getPositionY());
        
        //la heuristica seria la funcion f
        int f = heuristica + nodo.getCosto();
        System.out.println("Valor Heuristica desde la funcion f: " + f);
                
        return f;
    }
}

