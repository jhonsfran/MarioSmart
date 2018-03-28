/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author user
 */
public class ArchiveManager {

    private int[][] tableroDeJuego;

    public ArchiveManager() {
        tableroDeJuego = new int[10][10];
    }

    public void leerArchivoTablero(FileReader frLector) {
        int[][] tablero = new int[10][10];
        String linea = null;
        int contadorFilas = 0;
        try {
            BufferedReader brLector = new BufferedReader(frLector);
            while ((linea = brLector.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(linea);
                for (int i = 0; i < 10; i++) {
                    tablero[contadorFilas][i] = Integer.parseInt(stk.nextToken());
                }
                contadorFilas++;
            }
        } catch (IOException ex) {
        }
        tableroDeJuego = tablero;
    }

    public int[][] getTableroDeJuego() {
        return tableroDeJuego;
    }
}
