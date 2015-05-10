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

import javax.swing.JPanel;

import edu.pm.vo.Targets;

public class DragPanel extends JPanel implements MouseMotionListener,MouseListener{
  
	 Date startDate = new Date(106,11,7);
	 int width = 782;
	 int height = 500;
	 int monthHeight = 20;
	 int dayHeight = 20;
	 int gridWidth = 20;
	 int dayCount = (width-2)/gridWidth;
	 int gridHeight = 20;
	 int targetHeight = 12;
	 List targetList = null;
	 
	
	 private Point startPoint = null;
	 private Point endPoint = null; 
	 
	 DragPanel(List targetList){
		 this.targetList=targetList;
		 if(targetList!=null&&targetList.size()>0){
			 Date startDate00 = new Date();
			 startDate00.setTime(((Targets)targetList.get(0)).getStartDatePlan().getTime()-(long)1000*24*3600);
			 this.startDate=startDate00;
		 }
		 
		 addMouseMotionListener(this);
		 addMouseListener(this);
	 }
	
	 public void paint(Graphics g) {
		  
		  super.paint(g);
		  
		  paintDays(g);

		  paintTargets(g);
	  
	 }
	 
	 
	private void paintDays(Graphics g) {
		
		g.setColor(new Color(240,240,240));
		g.fillRect(0,0,width,monthHeight+dayHeight);
		g.setColor(Color.BLACK);
		
		Date beginDate=new Date();
		beginDate.setTime(startDate.getTime());
		int day=0;
		int date=0;
		int this_month=0;
		int last_month=0;
		for(int i=0;i<dayCount;i++){
			date=beginDate.getDate();
			day=beginDate.getDay();
			this_month=beginDate.getMonth()+1;
			g.setColor(Color.GRAY);
			g.drawLine(i*gridWidth+1,monthHeight,i*gridWidth+1,monthHeight+dayHeight);
			g.setColor(Color.BLACK);
			//date
			g.drawString(date+"",i*gridWidth+4,monthHeight+dayHeight-4);
			//周末
			if(day==6||day==0){
				g.setColor(new Color(240,240,240));
				g.fillRect(i*gridWidth+1,monthHeight+dayHeight,gridWidth+1,height-monthHeight-dayHeight-3);
				g.setColor(Color.BLACK);
			}
			//month
			if(this_month!=last_month){
				if(date<27){
					g.drawString((beginDate.getYear()+1900)+"-"+this_month,i*gridWidth+4,monthHeight-4);
				}
				last_month=this_month;
				g.setColor(Color.GRAY);
				g.drawLine(i*gridWidth+1,1,i*gridWidth+1,monthHeight);
				g.setColor(Color.BLACK);
				
			}
			
			beginDate.setTime(beginDate.getTime()+(long)1000*24*3600);
		}
		
		g.setColor(Color.GRAY);
		g.drawLine(1,monthHeight-1,width-1,monthHeight-1);
		g.drawLine(1,monthHeight+dayHeight,width,monthHeight+dayHeight);
		// 边框
		g.drawLine(1,1,width-1,1);
		g.drawLine(1,height-1,width-1,height-1);
		g.drawLine(1,1,1,height-1);
		g.drawLine(width-5,1,width-5,height-1);
		g.setColor(Color.BLACK);
		
	}
	
	private void paintTargets(Graphics g) {

		Date startDate00=null;
		Date endDate00=null;
		int startGrid=0;
		int endGrid=0;
		int heightBase=dayHeight+monthHeight+1;
		
		int heightI=0;
		if(targetList!=null){
			for(int i=0;i<targetList.size();i++){
				Targets target=(Targets)targetList.get(i);
			
				startDate00=target.getStartDatePlan();
				endDate00=target.getEndDatePlan();
				if(startDate00!=null&&endDate00!=null&&target.getDraw()){
					startGrid=(int)((startDate00.getTime()-this.startDate.getTime())/(long)(1000*24*3600));
					endGrid=(int)((endDate00.getTime()-this.startDate.getTime())/(long)(1000*24*3600))+1;
					
					//判断是否当前可见
					if(!(startGrid>dayCount||endGrid<0)){
						// 画任务条
						int sx=startGrid*gridWidth+1;
						int sy=heightBase+heightI+((gridHeight-targetHeight)/2);
						int ex=sx+(endGrid-startGrid)*gridWidth;
						int ey=sy+targetHeight;
						// 判断任务类型
						if(target.getIsParent()!=null&&target.getIsParent().equals("1")){
							//父任务
							if(target.getSelected()){
								g.setColor(Color.RED);
							}
							int targetParentHeight=4;
							g.fillRect(sx+1,sy+4,ex-sx-1,targetParentHeight);
							int length3=4;
							Polygon angle3 =new Polygon();
							angle3.addPoint(sx+1,sy+4+targetParentHeight);
							angle3.addPoint(sx+1+length3,sy+4+targetParentHeight);
							angle3.addPoint(sx+1,sy+4+targetParentHeight+length3);
							g.fillPolygon(angle3);
							Polygon angle3_2 =new Polygon();
							angle3_2.addPoint(ex,sy+4+targetParentHeight);
							angle3_2.addPoint(ex-length3,sy+4+targetParentHeight);
							angle3_2.addPoint(ex,sy+4+targetParentHeight+length3);
							g.fillPolygon(angle3_2);
							g.setColor(Color.BLACK);
						}
						else{
							// 子任务
							g.drawRect(sx,sy,ex-sx,ey-sy);
							if(target.getSelected()){
								g.setColor(Color.RED);
							}
							else{
								g.setColor(new Color(64,160,192));
							}
							g.fillRect(sx+1,sy+1,ex-sx-1,ey-sy-1);
							g.setColor(Color.BLACK);
						}
						
					}
					//  画线
					g.setColor(Color.GRAY);
					g.drawLine(1,heightBase+heightI+gridHeight,width-1,heightBase+heightI+gridHeight);
					g.setColor(Color.BLACK);
					
					heightI+=gridHeight;
				}
				
			}
			
		}//if
		
		
		
	}
	
	public void mouseDragged(MouseEvent e){
		
	   endPoint=e.getPoint();
	  
	   int daysPass = (endPoint.x-startPoint.x)/gridWidth;
	  
	   if(daysPass!=0){
		  startDate.setTime(startDate.getTime()-daysPass*1000*24*3600);
		  startPoint=endPoint;
		  repaint();
	   }
	  
	}
	 
    public void mouseMoved(MouseEvent e){
    }
    
    public void mouseClicked(MouseEvent e){
    }
    
    public void mouseEntered(MouseEvent e){
    }
    
    public void mouseExited(MouseEvent e){
     
    }
    
    public void mousePressed(MouseEvent e){
    
    	startPoint=e.getPoint();
    	this.setCursor(new Cursor(Cursor.MOVE_CURSOR));
       
    }
    
    public void mouseReleased(MouseEvent e){

    	setCursor(new Cursor(Cursor.HAND_CURSOR));
    	
    }

	public List getTargetList() {
		return targetList;
	}

	public void setTargetList(List targetList) {
		this.targetList = targetList;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}


