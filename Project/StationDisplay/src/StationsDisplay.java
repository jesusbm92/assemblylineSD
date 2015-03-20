import javax.swing.*;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StationsDisplay extends JPanel
{
	public JFrame frame;
	public JPanel grid;
	public JPanel iconPanel;
	public ArrayList<JButton> listButton;
	
	public StationsDisplay(){
		frame = new JFrame("Graphical view of stations");
        frame.setSize(new Dimension(600,550));
        
        iconPanel = new JPanel();
        grid = new JPanel();
        listButton = new ArrayList<JButton>();

        for (int i = 1 ; i <= 10 ; i++ )
        {
        	listButton.add(new JButton("Station " + i));
        }
	}
	
	public void handler(){
		
		for (int i = 1 ; i <= 10 ; i++ )
        {
			int j = i;
			listButton.get(i-1).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               paintConstruction(j);
            }          
         }); 
        }
	}
	
	public void paintStations()
	{
		//Painting the stations
        for (int i = 1 ; i <= 10 ; i++)
        {
        JLabel lblM1 = new JLabel();
        lblM1.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\pic\\S" + i + ".png"));
        grid.add(lblM1);
        lblM1.setLocation(200, 10 + (i-1)*50);
        lblM1.setSize(40, 40);
        }
	}
	
	public void paintConstruction(int i)
	{
        System.out.println("C" + i);
        
        int Position = 0;
        while (Position < 170)
        {

            JLabel lblM2 = new JLabel();
            lblM2.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\pic\\First.png"));
            grid.add(lblM2);
            lblM2.setLocation(Position, 10 + (i-1)*50);
            lblM2.setSize(40, 40);
        	
            
			Graphics g =  this.frame.getGraphics();
			System.out.println(g != null);
			g.setColor(Color.WHITE);
			g.fillRect(0,0,800,600);
        	
        	//Wait to see the movement
        	for (int j = 0 ; j < 5000 ; j++)
        	{for (int k = 0 ; k < 10000 ; k++){}}
        	
        	JLabel lblM3 = new JLabel();
            lblM3.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\pic\\blanc.png"));
            grid.add(lblM3);
            lblM3.setLocation(Position, 10 + (i-1)*50);
            lblM3.setSize(40, 40);
        	Position++;
            System.out.println(Position);
        }
        

        /*JLabel lblM3 = new JLabel();
        lblM3.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\pic\\S0" + i + ".png"));
        grid.add(lblM3);
        lblM3.setLocation(0, 10 + (i-1)*50);
        lblM3.setSize(40, 40);*/
        
	}
	

	
    public static void main(String[] args)
    {
        StationsDisplay display = new StationsDisplay();

        display.grid.setLayout(null);
        display.iconPanel.setLayout(new BoxLayout(display.iconPanel, BoxLayout.Y_AXIS));
        display.handler();
        
        
        //init add
		for (JButton button : display.listButton) {
	        display.iconPanel.add(button);
		}
        display.frame.add(display.iconPanel);
        display.paintStations();


        //endOperations
        display.frame.setLayout(new GridLayout(1,2));
        display.frame.add(display.iconPanel);
        display.frame.add(display.grid);
        display.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.frame.setLocationRelativeTo(null);
        display.frame.setVisible(true);
    }
}