/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class Mundo extends JPanel
{
    private JLabel tablero[][];
    private int[][] tableroDeJuego;

    public Mundo() {
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(new GridLayout(10, 10));
        tableroDeJuego = new int[10][10];
        this.setMaximumSize(new java.awt.Dimension(400,400));
    }
    
    public void mostrarMundo() {
        tablero = new JLabel[10][10];
        for (int i = 0; i < tableroDeJuego.length; i++) {
            for (int j = 0; j < tableroDeJuego.length; j++) {
                switch (tableroDeJuego[i][j]) {
                    case 0:
                        tablero[i][j] = new JLabel(new ImageIcon(getClass().getResource("/resource/blanco.png")));
                        break;
                    case 1:
                        tablero[i][j] = new JLabel(new ImageIcon(getClass().getResource("/resource/pared.png")));
                        break;
                    case 2:
                        tablero[i][j] = new JLabel(new ImageIcon(getClass().getResource("/resource/mario.png")));
                        break;
                    case 3:
                        tablero[i][j] = new JLabel(new ImageIcon(getClass().getResource("/resource/flor.png")));
                        break;
                    case 4:
                        tablero[i][j] = new JLabel(new ImageIcon(getClass().getResource("/resource/tortuga.png")));
                        break;
                    case 5:
                        tablero[i][j] = new JLabel(new ImageIcon(getClass().getResource("/resource/princesa.png")));
                        break;
                    case 6:
                        tablero[i][j] = new JLabel(new ImageIcon(getClass().getResource("/resource/mario_con_flor.png")));
                        break;
                    case 7:
                        tablero[i][j] = new JLabel(new ImageIcon(getClass().getResource("/resource/mario_princesa.jpg")));
                        break;

                }
                this.add(tablero[i][j]);
                this.repaint();
            }
        }
        this.setSize(310, 320);
    }
    

    public void setTableroDeJuego(int[][] tableroDeJuego)
    {
        this.tableroDeJuego = tableroDeJuego;
    }
    
}
