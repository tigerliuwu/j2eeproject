/**
 * 
 */
package appletsrc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.TreeCellRenderer;

public class MyRenderer extends JPanel implements TreeCellRenderer {
	private MyCellRenderer renderer = new MyCellRenderer();

	public MyRenderer() {
		super(new BorderLayout());
		this.add(renderer, BorderLayout.CENTER);
		this.setBorder(BorderFactory.createEmptyBorder(0, 0, 2, 0));
		this.setOpaque(false);
		
	}

	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean selected, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {
		renderer.getTreeCellRendererComponent(tree, value, selected,
				expanded, leaf, row, hasFocus);
		this.revalidate();
		return this;
	}
	
class MyCellRenderer extends JLabel implements TreeCellRenderer{
	
	    public Component getTreeCellRendererComponent(JTree tree,Object value,boolean selected,boolean expanded,boolean leaf,int row,boolean hasFocus){
	        
	    	MyNode node=(MyNode)value;
	        
	        setText(node.getUserObject().toString());

	        setIcon(node.getIcon());
	        
	        if(node.getColor()!=null){
	        	 setForeground(Color.red); 
	        	 this.setBackground(Color.BLUE);
	        }else{
	        	 setForeground(Color.BLACK);  
	        	
	        }
	       
	        
	        /*if(hasFocus) {
	        	 setForeground(Color.red);  
	        }
	        else{
	        	setForeground(Color.BLACK);  
	        }*/
	        
	        setFont(new Font("SansSerif",   0,   12) ); 
		    
	        return this;
	    }
	    
	    
	}//class inner
}//class
