package appletsrc;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JScrollPane;

import edu.pm.vo.Targets;

public class ScrollPanel extends JScrollPane{
  
	 List targetList = null;
	 
	 ScrollPanel(List targetList){
		 this.targetList=targetList;
		 
	 }
	
	 public void paint(Graphics g) {
		  
		  super.paint(g);
		  
		  paintLines(g);
		  
	 }
	 
	 
	private void paintLines(Graphics g) {
		
		g.setColor(new Color(220,220,220));
		if(targetList!=null){
			int heightI=20;
			for(int i=0;i<targetList.size();i++){
				Targets target =(Targets)targetList.get(i);
				if(target.getDraw()){
					g.drawLine(1,heightI,200-3,heightI);
					heightI+=20;
				}
				
			}
		}
		
		
	}
	

	public List getTargetList() {
		return targetList;
	}

	public void setTargetList(List targetList) {
		this.targetList = targetList;
	}

}


