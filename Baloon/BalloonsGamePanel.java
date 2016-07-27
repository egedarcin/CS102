/*
 * @Author: Ege Darcin
 * 24.03.2016
 * Lab04b
 * Version 1.1
 */
//importing required methods
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import shapes.*;


public class BalloonsGamePanel extends JPanel {
  //variables
  static final int DEFAULT_WIDTH = 800;
  static final int DEFAULT_HEIGHT = 800;
  static final int MAX_ELAPSED_TIME = 300;
  static final int UPDATE_PERIOD = 100;
  static final int INIT_BALLOONS = 25;
  static final int MIN_BALLOONS = 15;
  
  //constrctors
  ShapeContainer balloons;
  Timer timer;
  JLabel pointsLabel = new JLabel();
  JLabel timeLabel = new JLabel();
  int points;
  int passedTime;
  MouseListener pin;
  
  
  //panel design
  public BalloonsGamePanel() {
    this.add(this.pointsLabel);
    this.add(this.timeLabel);
    this.setBackground(Color.red);
    this.setPreferredSize(new Dimension(800, 800));
    this.pin = new Pin();
    this.timer = new Timer(100, new GrowListener());
    this.initGame();
  }
  
  //initiation of the game
  private void initGame() {
    this.passedTime = 0;
    this.points = 0;
    this.pointsLabel.setText("Score: " + this.points);
    this.timeLabel.setText("Time: " + this.passedTime);
    this.balloons = new ShapeContainer();
    this.addRandomBalloons(25, 800, 800);
    this.addMouseListener(this.pin);
    this.timer.start();
  }
  
  //addrandomballoon method
  private void addRandomBalloons(int number, int width, int height) {
    for (int i = 0; i < number; ++i) {
      int x = (int)(Math.random() * (double)width);
      int y = (int)(Math.random() * (double)height);
      Balloon b = new Balloon(x, y);
      this.balloons.add(b);
    }
  }
  //draw and paint component
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Iterator<Shape> it = this.balloons.iterator();
    while (it.hasNext()) {
      ((Drawable)((Object)it.next())).draw(g);
    }
  }
  
  private class GrowListener implements ActionListener {
    private GrowListener() {
    }
    //action performed, grows balloons if not clicked
    @Override
    public void actionPerformed(ActionEvent e) {
      Iterator<Shape> it = BalloonsGamePanel.this.balloons.iterator();
      while (it.hasNext()) {
        ((Balloon)it.next()).grow();
         BalloonsGamePanel.this.timeLabel.setText("Time: " + BalloonsGamePanel.this.passedTime);
        
      }
      //removed and adds balloons
      BalloonsGamePanel.this.balloons.removeSelected();
      if (BalloonsGamePanel.this.balloons.size() < 15) {
        BalloonsGamePanel.this.addRandomBalloons(1, BalloonsGamePanel.this.getWidth(), BalloonsGamePanel.this.getHeight());
      }
      
      //game time checker
      BalloonsGamePanel.this.repaint();
      ++BalloonsGamePanel.this.passedTime;
      if (BalloonsGamePanel.this.passedTime >= 250) {
        BalloonsGamePanel.this.timer.stop();
        BalloonsGamePanel.this.removeMouseListener(BalloonsGamePanel.this.pin);
        
        //end game popup
        int again = JOptionPane.showConfirmDialog(BalloonsGamePanel.this, "Wanna play? ", "I'm bored", 0);
        if (again == 0) {
          BalloonsGamePanel.this.initGame();
        }
      }
    }
  }
  //pin, which uses mouseadapter and selected, and counts if the gamer clicks more than 1 balloon.
  private class Pin extends MouseAdapter {
    private Pin() {
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
      int popCount = BalloonsGamePanel.this.balloons.selectAllAt(e.getX(), e.getY());
      if (popCount >= 2) {
        BalloonsGamePanel.this.points += popCount;
        BalloonsGamePanel.this.pointsLabel.setText("Points: " + BalloonsGamePanel.this.points);
        BalloonsGamePanel.this.timeLabel.setText("Time: " + BalloonsGamePanel.this.passedTime);
      }
    }
  } 
}