package edu.dlmu.sei.util;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

class MyNode extends DefaultMutableTreeNode{
	private String icon="";
	
	private String text="";

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}

class MyCellRenderer extends JLabel implements TreeCellRenderer{

    public Component getTreeCellRendererComponent(JTree tree,Object value,boolean selected,boolean expanded,boolean leaf,int row,boolean hasFocus){
        DefaultMutableTreeNode node=(DefaultMutableTreeNode)value;
        if(node instanceof MyNode){
        setText(((MyNode)node).getText());
        setIcon(new ImageIcon(((MyNode)node).getIcon()));
        //这里针对单个节点还可以进行其他设置....
        }
        return this;
    }
}

public class test {
	public static void main(String[] args) {
		JTree tree = new JTree();
		
		MyCellRenderer aa = new MyCellRenderer();
		tree.setCellRenderer(aa);
		JScrollPane sp = new JScrollPane(tree);
		JFrame f = new JFrame();
		f.getContentPane().add(sp, BorderLayout.CENTER);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	
	

	
	
}