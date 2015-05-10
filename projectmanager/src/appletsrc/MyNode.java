package appletsrc;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @author guo
 *
 */
public class MyNode extends DefaultMutableTreeNode{
	private ImageIcon icon=null;
	
	private String text="";
	
	private Color color = null;
	
	public MyNode(String text,ImageIcon icon){
		super(text);
		this.text=text;
		this.icon=icon;
	}
	
	public MyNode(Object obj,ImageIcon icon){
		super(obj);
		this.icon=icon;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}