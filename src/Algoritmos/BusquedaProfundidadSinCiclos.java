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
import java.util.Stack;


public class BusquedaProfundidadSinCiclos {
    
    private int tablero[][];
    private Nodo raiz;
    private Nodo meta;
    private Stack<Nodo> arbol;
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

    public Stack<Nodo> getArbol() {
        return arbol;
    }

    public void setArbol(Stack<Nodo> arbol) {
        this.arbol = arbol;
    }
    
    
    public void addElementArbol(Nodo n){
        this.arbol.push(n);
    }
    
    public void removeElementArbol() {
        this.arbol.pop();
    }
    
    public BusquedaProfundidadSinCiclos(int tablero[][]) {
        
        this.tablero = tablero;
        this.raiz = new Nodo();
        this.arbol = new Stack<Nodo>();
        
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
            
            Nodo nodoToExpand = arbol.pop();
            
            //verifico que el nodo que voy a expandir no haga parte de un ciclo
            //si lo es, paso de el y no lo expando. Tomo el siguiente nodo en el arbol que seria el mas profundo            
            if (!evitarCiclo(nodoToExpand)) {
                
                expandirNodo(nodoToExpand);

            }
                       
            
            
        }
        
        return rutaTablero;
        
    
    }
    
    public void expandirNodo(Nodo nodo){
   
        
        
        /*Nodo nodoExpandido1 = new Nodo(null, false, 0, null, 0, null, 0);
        Nodo nodoExpandido2 = new Nodo(null, false, 1, null, 0, null, 0);
        Nodo nodoExpandido3 = new Nodo(null, false, 2, null, 0, null, 0);
        Nodo nodoExpandido4 = new Nodo(null, false, 3, null, 0, null, 0);        
        Nodo nodoExpandido5 = new Nodo(null, false, 4, null, 0, null, 0);
        
        //ingreso el elemento expandido al arbol de busqueda
        addElementArbol(nodoExpandido1);
        addElementArbol(nodoExpandido2);
        addElementArbol(nodoExpandido3);
        addElementArbol(nodoExpandido4);
        addElementArbol(nodoExpandido5);
        
        while (!arbol.isEmpty()) {
            
            Nodo nodoToExpand = arbol.pop();
            System.out.println("heuristica del elemento " + nodoToExpand.getProfundidad());

        }*/
                
        Nodo nodoExpandido = null;
        
        if (!nodo.esMeta()){
            
            ArrayList<String> movimientos = validarMovimientos(nodo);
            
            Iterator<String> nombreIterator = movimientos.iterator();
            
            while (nombreIterator.hasNext()) {
                
                String operador = nombreIterator.next();
                System.out.println("\n\noperador a expandir " + operador);
                informacionAgente += "<b>Operador aplicado</b>: " + operador + "<br>";
                nodoExpandido = nodo.expandir(operador);
                

                //ingreso el elemento expandido al arbol de busqueda
                addElementArbol(nodoExpandido);
                //aumento uno la cantidad de los nodos expandidos
                this.cantidadNodosExpandidos++;
                
            }
            
            
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
    
    
    //si lo vemos bien no es tan costoso. Solo busca por cada nivel del arbol si el estado actual se repite.
    public boolean evitarCiclo(Nodo nodo) {

        Nodo miNodo;
        //si no es raiz entonces le busco el padre
        if (nodo.getProfundidad() != 0) {
            miNodo = nodo.getPadre();
        }else{
            //si es padre entonces ni pregunto, solo returno false
            return false;
        }
        
        boolean ciclo = false;
        
        while (miNodo.getProfundidad() != 0) {
            
            //evitar ciclo se define como que el nodo no se repita en una misma rama - con  esto verifico si alguno de sus ancestros ha estado en esa posicion
            if (nodo.getPosicion().getPositionX() == miNodo.getPosicion().getPositionX() && nodo.getPosicion().getPositionY() == miNodo.getPosicion().getPositionY()) {
                //si mario tiene flor && cuando estuvo en la posicion del ancestro no tenia entonces lo dejo pasar - sino quiere decir que el mismo estado se repite
                //sobre la misma rama. Lo que me indica un ciclo.
                if (nodo.isTieneFlor() == miNodo.isTieneFlor()) {
                    return true; 
                    //lo retorno de una para romper el ciclo. Si ya se que hay ciclo no necesito mas
                }
            } 
            
            miNodo = miNodo.getPadre();

        }

        return ciclo;
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
        //aqui el orden de lo operadores si afecta el rendimiento del algoritmo
        String operadores[] = {"bajar","izquierda","derecha","subir"};
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
            
            System.out.println("\n\npara validar " + operadores[i] + " : \n reglas del mundo: " + reglasMundo(valorTablero, nodo.tieneFlor()) + "\nlimite del mundo : " + limiteMundo + "\ndevolviendo : " + devolviendo);

            //si cumple con las reglas del mundo y no se sale del mapa y ademas no se devuelve=> puede aplicar el operador
            
            //evitando devolverme
            if (reglasMundo(valorTablero, nodo.isTieneFlor()) && limiteMundo && !devolviendo) {
            //no evite devolverse
            //if (reglasMundo(valorTablero, nodo.isTieneFlor()) && limiteMundo) {
                
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

                validar = true;
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

