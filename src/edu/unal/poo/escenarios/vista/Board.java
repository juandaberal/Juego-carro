/*
PLANTILLA BASE PARA CREACION DE ESCENARIOS.
 */
package edu.unal.poo.escenarios.vista;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener{
    int xRef = 30;
    int yRef = 100;
    private Timer timer;    

    public Board() {
        this.timer = new Timer(30, this);
        this.timer.start();
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //Poligono
        g.fillOval(xRef+20, yRef+50, 50, 50);
        g.fillOval(xRef+170, yRef+50, 50, 50);
        Polygon poligono = new Polygon();
        poligono.addPoint(xRef, yRef);
        poligono.addPoint(xRef+50, yRef);
        poligono.addPoint(xRef+100, yRef-50);
        poligono.addPoint(xRef+150, yRef-50);
        poligono.addPoint(xRef+200, yRef);
        poligono.addPoint(xRef+250, yRef);
        poligono.addPoint(xRef+250, yRef+50);
        poligono.addPoint(xRef, yRef+50);
        
        
        g.fillPolygon(poligono);
        
        g.setColor(Color.red);
        
        g.drawRect(400, 100, 50, 50);
        Rectangle obstaculo = new Rectangle(400, 100, 50, 50);
        
        
        g.setColor(Color.BLUE);
        g.drawOval(400, 100, 49, 49);
        
        if(poligono.intersects(obstaculo)){
          this.timer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.xRef++;
        repaint();
    }
}