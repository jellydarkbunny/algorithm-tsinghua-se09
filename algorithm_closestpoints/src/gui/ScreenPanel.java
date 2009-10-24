package gui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import java.util.ArrayList;

import entity.MyPoint;
import entity.MyPointPair;
public class ScreenPanel extends JPanel implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4612042272345426221L;
	private ArrayList <MyPoint> points;
	private ArrayList <MyPointPair> lines;
	public ScreenPanel(){
		points = new ArrayList<MyPoint>();
		lines = new ArrayList<MyPointPair>();
		addMouseListener(this);		
	}
	public void clearPoints(){
		points.clear();
		lines.clear();
		repaint();
	}
	public void setPoints(ArrayList <MyPoint> points){
		this.points = points;
	}
	public ArrayList <MyPoint>getPoints(){
		return points;
	}
	
	public void setLines(ArrayList<MyPointPair> lines){
		this.lines = lines;
	}
	public void paint(Graphics g){
		super.paint(g);
		for(int i =0;i<points.size();i++){
			MyPoint p = points.get(i);
			g.fillRect((int)p.getX(),(int)p.getY(),2,2);
		}
		for(int i = 0;i<lines.size();i++){
			MyPointPair line = lines.get(i);
			int a = (int)line.getP1().getX();
			int b = (int)line.getP1().getY();
			int c = (int)line.getP2().getX();
			int d = (int)line.getP2().getY();
			g.drawLine(a,b, c, d);
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int x = arg0.getX();
		int y = arg0.getY();
		MyPoint p = new MyPoint(x,y);
		points.add(p);
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
