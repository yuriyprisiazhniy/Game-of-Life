/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;
import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.Graphics;
/**
 *
 * @author Yura
 */
public class WorkPanel extends JPanel{
    private int x,y,width,height;
    private int pointX, pointY;
    public workPanel(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public void drawPoint(int x, int y){
        pointX = x;
        pointY = y;
        this.repaint();
    }
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        g2.drawRect(x, y, width, height);
        g2.drawLine(pointX,pointY,pointX,pointY);
    }
}
