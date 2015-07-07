/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Yura
 */

public class MainFrame extends WindowAdapter implements MouseListener{
    private Frame frame;
    private Button button;
    private workPanel panel;
    private byte[][] currentStep;
    private byte[][] nextStep;
    private boolean buttonPressed;
    public MainFrame(){
        frame = new Frame("Game of life");
        frame.setSize(408, 465);
        button = new Button("Start");
        currentStep = new byte[400][400];
        nextStep = new byte[400][400];
        panel = new workPanel(0,0,400,400);
        buttonPressed = false;
    }
    private boolean isAdd(int x, int y){
        int count = 0;
        if(x-1>0 && currentStep[x-1][y] == 0 ) count++;
        if(x+1<400 && currentStep[x+1][y] == 0) count++;
        if(x-1>0 && y-1>0 && currentStep[x-1][y-1] == 0) count++;
        if(x-1>0 && y+1<400 && currentStep[x-1][y+1] == 0) count++;
        if(y+1<400 && currentStep[x][y+1] == 0) count++;
        if(y-1>0 && currentStep[x][y-1] == 0) count++;
        if(x+1<400 && y+1<400 && currentStep[x+1][y+1] == 0) count++;
        if(x+1<400 && y-1>0 &&currentStep[x+1][y-1] == 0) count++;
        if(count == 3) return true;
        else return false;
    }
    private boolean isDell(int x, int y){
        int count = 0;
        if(x-1>0 && currentStep[x-1][y] == 1 ) count++;
        if(x+1<400 && currentStep[x+1][y] == 1) count++;
        if(x-1>0 && y-1>0 && currentStep[x-1][y-1] == 1) count++;
        if(x-1>0 && y+1<400 && currentStep[x-1][y+1] == 1) count++;
        if(y+1<400 && currentStep[x][y+1] == 1) count++;
        if(y-1>0 && currentStep[x][y-1] == 1) count++;
        if(x+1<400 && y+1<400 && currentStep[x+1][y+1] == 1) count++;
        if(x+1<400 && y-1>0 &&currentStep[x+1][y-1] == 1) count++;
        if(count < 2 || count > 3) return true;
        else return false;
    }
    public void lifeIteration(){
        for(int i=0; i<currentStep.length; i++)
            for(int j=0;j<currentStep[0].length;j++){
                if((currentStep[i][j] == 0) && isAdd(i,j))
                    nextStep[i][j] = 1;
                else if((currentStep[i][j] == 1) && isDell(i,j))
                    nextStep[i][j] = 0;
                else nextStep[i][j] = currentStep[i][j];
                    
            }
    }
    public void life(){
        while(true){
        lifeIteration();
        for(int i=0; i<currentStep.length; i++)
            for(int j=0;j<currentStep[0].length;j++)
                if(nextStep[i][j] == 1)
                    panel.drawPoint(j, j);
        currentStep = nextStep;//!!!!!!!!!!!!!!!!!!!!!!!!!!!
        
        }
    }
    public void launchFrame(){
        frame.setLayout(new BorderLayout());
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                buttonPressed = true;
                life();
            }
        });
        frame.add(button,BorderLayout.SOUTH);
        frame.addWindowListener(this);
        frame.addMouseListener(this);
        frame.add(panel,BorderLayout.CENTER);
        frame.setVisible(true);
        
    }
    @Override
    public void windowClosing(WindowEvent e){
        frame.dispose();
        
    }
    @Override
    public void mouseClicked(MouseEvent e){
        int x = e.getX()-8;
        int y = e.getY()-32;
        if(x>0 && y<400 && (!buttonPressed))
        {
            currentStep[x][y] = 1;
            panel.drawPoint(x,y );
        }
    }
    public void mousePressed(MouseEvent e){
        
    }
    public void mouseReleased(MouseEvent e){
        
    }
    public void mouseEntered(MouseEvent e){
        
    }
    public void mouseExited(MouseEvent e){
        
    }
    
}
