package appletsrc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import edu.pm.vo.Targets;

public class Gantt extends JApplet {

	boolean isStandalone = false;

	ScrollPanel jScrollPane1 = null;

	List targetList = null;

	JTree jTree1;

	DragPanel jPanel1 = null;

	JPanel jPanel0 = null;
	
	JPopupMenu   popMenu = null;
	
	Font myfont=new Font("SansSerif",   0,   12);

	HashMap map = null;

	public Gantt() {

	}

	public void init() {

		try {
			
			dataInit();

			jbInit();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	private void dataInit() {
		try {

			URL url = new URL(getCodeBase(), "/pm/ganttTargetAction.do");
			URLConnection con = url.openConnection();
			con.setUseCaches(false);
			InputStream in = con.getInputStream();
			ObjectInputStream objStream;
			objStream = new ObjectInputStream(in);
			targetList = (List) objStream.readObject();

		} catch (Exception e) {
			e.printStackTrace();

		}

		// test data

		/*for (int i = 1; i < 5; i++) {
			Targets target = new Targets();
			target.setDisplayColor("red");
			target.setTargetName("T000000000000000000" + i);
			target.setStartDatePlan(new Date(106, 11, 7));
			Date endDate = new Date(106, 11, 7);
			endDate.setTime(endDate.getTime() + (long) 1000 * 3600 * 24 * 7 * i);
			target.setEndDatePlan(endDate);
			target.setIsParent("" + i % 2);
			targetList.add(target);
		}*/
		

	}

		


	/** Component initialization */

	private void jbInit() throws Exception {
		
		
			

		this.setSize(new Dimension(982, 500));

		jPanel0 = new JPanel();

		this.getContentPane().add(jPanel0, BorderLayout.WEST);

		jPanel1 = new DragPanel(targetList);

		this.getContentPane().add(jPanel1, BorderLayout.CENTER);

		jPanel1.setBackground(Color.WHITE);

		jPanel1.setBorder(javax.swing.BorderFactory.createLoweredBevelBorder());

		jPanel1.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// label ----------------------------------------------------------------------------
		JLabel jLabel1 = new JLabel();

		jLabel1.setFont(new java.awt.Font("宋体", 1, 20));

		jLabel1.setText("  Gantt 项目计划");

		jLabel1.setOpaque(true);

		jLabel1.setBackground(new Color(240, 240, 240));

		jLabel1.setPreferredSize(new Dimension(100, 39));

		jPanel0.setLayout(new BorderLayout());

		jPanel0.add(jLabel1, BorderLayout.NORTH);

		jScrollPane1 = new ScrollPanel(targetList);

		jScrollPane1.setPreferredSize(new Dimension(200, 4));

		jPanel0.add(jScrollPane1, BorderLayout.CENTER);

		jPanel0.setBorder(javax.swing.BorderFactory.createLoweredBevelBorder());

		treeInit();
		
		jScrollPane1.getViewport().add(jTree1, null);
		
		// pop menu -----------------------------------------------------------------------------
		popMenu = new JPopupMenu(); 
		JMenuItem newItem = new JMenuItem("新建子任务");
		JMenuItem deleteItem = new JMenuItem("删除任务");
		JMenuItem inforItem = new JMenuItem("任务信息");
		newItem.setFont(myfont);
		deleteItem.setFont(myfont);
		inforItem.setFont(myfont);
		popMenu.add(newItem);
		popMenu.addSeparator();
		popMenu.add(deleteItem);
		popMenu.addSeparator();
		popMenu.add(inforItem);
		newItem.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				newTarget();
				} 
			}
		); 
		deleteItem.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				deleteTarget();
				} 
			}
		);
		inforItem.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				inforTarget();
				} 
			}
		);
		
		
	}
	
	private void treeInit() {
		
// tree ----------------------------------------------------------------------------
		
		
		ImageIcon projectIcon = new ImageIcon(getClass().getResource(
				"project.gif"));
		ImageIcon notleafIcon = new ImageIcon(getClass().getResource(
				"notleaf.gif"));
		ImageIcon leafIcon = new ImageIcon(getClass()
				.getResource("leaf.gif"));
		ImageIcon assignedleafIcon = new ImageIcon(getClass().getResource(
				"assignedleaf.gif"));

		MyNode root = null;
		
		map=new HashMap();

		if (targetList != null) {
			
			root = new MyNode((Targets) targetList.get(0), projectIcon);
			for (int i = 1; i < targetList.size(); i++) {
				Targets target = (Targets) targetList.get(i);
				
				ImageIcon thisIcon = null;
				if (target.getIsParent() != null
						&& target.getIsParent().equals("1")) {
					thisIcon = notleafIcon;
				} else {
					if (target.getStatus() != null
							&& target.getStatus().equals("001")) {
						thisIcon = leafIcon;
					} else {
						thisIcon = assignedleafIcon;
					}
				}
				MyNode aNode = new MyNode(target, thisIcon);
				
				target.setSelected(false);

				if (target.getParentId() == null) {
					root.add(aNode);
					target.setDraw(true);
				} else {
					MyNode parent = (MyNode) map.get(target.getParentId());
					parent.add(aNode);
					target.setDraw(false);
				}

				map.put(target.getId(), aNode);

			}
		}

		jTree1 = new JTree(root);

		jTree1.setCellRenderer(new MyRenderer());
		
		
		jTree1.addMouseListener(new java.awt.event.MouseAdapter() {

			public void mousePressed(MouseEvent e) {

				treeClicked(e);

			}
			public void mouseReleased(MouseEvent e){
				
				treeReleased(e);
				
		    }
			
		});


	}

	

	public void treeClicked(MouseEvent e) {
		// 各项颜色变回黑色
		Enumeration en=((MyNode)jTree1.getModel().getRoot()).depthFirstEnumeration();
		 if(en!=null){
			 while(en.hasMoreElements()){
				 MyNode aNode = (MyNode)en.nextElement();
				 aNode.setColor(null);
				 Targets target=(Targets)aNode.getUserObject();
				 target.setSelected(false);
			 }
		 }
		 // 选中项变红色
		TreePath path = jTree1.getPathForLocation(e.getX(),e.getY());
		MyNode selectNode =null;
		if(path!=null ){
			selectNode = (MyNode) path.getLastPathComponent();
			selectNode.setColor(Color.RED);
			Targets target=(Targets)selectNode.getUserObject();
			target.setSelected(true);
		}
		// left key
		if(SwingUtilities.isLeftMouseButton(e)) {
			// 重新计算展开项
			for (int i = 1; i < targetList.size(); i++) {
				Targets target = (Targets) targetList.get(i);
				MyNode node = (MyNode) map.get(target.getId());
				path = new TreePath(node.getPath());
				target.setDraw(jTree1.isVisible(path));
			}
			// left 2 click 右面视图更新开始时间
			int dd = e.getClickCount();
			if(dd==2){
				if(selectNode!=null&&((Targets)selectNode.getUserObject()).getStartDatePlan()!=null){
					Date startDate = new Date();
					startDate.setTime(((Targets)selectNode.getUserObject()).getStartDatePlan().getTime()-(long)1000*24*3600);
					jPanel1.setTargetList(targetList);
					jPanel1.setStartDate(startDate);
				}
			}
			
		}//left key
		
		jScrollPane1.repaint();
		jPanel1.repaint();
	}
	public void treeReleased(MouseEvent e) {

		if(SwingUtilities.isRightMouseButton(e)) {
			TreePath path = jTree1.getPathForLocation(e.getX(),e.getY());
			if(path!=null ){
				 
				 MyNode node = (MyNode) path.getLastPathComponent();
				 
				 popMenu.show(jTree1,e.getX(),e.getY()); 
				 
				 jScrollPane1.repaint();
				 jPanel1.repaint();
				
			}
		}
		
	}
	
	public Targets getSelectedTarget(){
		Enumeration en=((MyNode)jTree1.getModel().getRoot()).depthFirstEnumeration();
		Targets target=null;
		 if(en!=null){
			 while(en.hasMoreElements()){
				 MyNode aNode = (MyNode)en.nextElement();
				 if(aNode.getColor()!=null){
					 target=(Targets)aNode.getUserObject();
					 break;
				 }
			 }
		 }
		return target;
	}
	
	public void newTarget(){
		
		NewDialog dlg = new NewDialog(this);
        dlg.setModal(true);
        dlg.show();
         
	}
	
	public void newTargetBack(Targets newTarget){
		Targets parentTarget=getSelectedTarget();
		newTarget.setParentId(parentTarget.getId());
		try {
			URL url = new URL(getCodeBase(),"/pm/targetCreateAction.do");
			URLConnection con = url.openConnection();
			con.setUseCaches(false);
			con.setDoOutput(true);
			con.setRequestProperty("Content-type", "application/octest-stream");
			// 写入对象
			ObjectOutputStream objectout = new ObjectOutputStream(con.getOutputStream());
			objectout.writeObject(newTarget);

			objectout.flush();
			objectout.close();

			DataInputStream dis = new DataInputStream(con.getInputStream());
			
			// 重新从服务器读取数据
			getContentPane().removeAll();
			init();
			
			// String txt = dis.readLine();
			// dis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	public void deleteTarget(){
		Targets target=getSelectedTarget();
		
		/*DeleteDialog dlg = new DeleteDialog(target,this);
        dlg.setModal(true);
        dlg.show();*/
		
		int  ii = JOptionPane.showConfirmDialog(null,"删除任务："+target.getTargetName(),"删除确认",JOptionPane.YES_NO_OPTION );
        if(ii==0){
        	try {
    			URL url = new URL(getCodeBase(),"/pm/targetDeleteAction.do");
    			URLConnection con = url.openConnection();
    			con.setUseCaches(false);
    			con.setDoOutput(true);
    			con.setRequestProperty("Content-type", "application/octest-stream");
    			// 写入对象
    			ObjectOutputStream objectout = new ObjectOutputStream(con.getOutputStream());
    			objectout.writeObject(target);

    			objectout.flush();
    			objectout.close();

    			DataInputStream dis = new DataInputStream(con.getInputStream());
    			
    			// 重新从服务器读取数据
    			getContentPane().removeAll();
    			init();

    		} catch (Exception e) {
    			e.printStackTrace();
    		}
        }//if
	}
	
	public void inforTarget(){
		Targets target=getSelectedTarget();
		
		InforDialog dlg = new InforDialog(target,this);
        dlg.setModal(true);
        dlg.show();
	
	}
	
	public void inforTargetBack(Targets target){
		try {
			URL url = new URL(getCodeBase(),"/pm/targetModifyAction.do");
			URLConnection con = url.openConnection();
			con.setUseCaches(false);
			con.setDoOutput(true);
			con.setRequestProperty("Content-type", "application/octest-stream");
			// 写入对象
			ObjectOutputStream objectout = new ObjectOutputStream(con.getOutputStream());
			objectout.writeObject(target);

			objectout.flush();
			objectout.close();

			DataInputStream dis = new DataInputStream(con.getInputStream());
			
			// 重新从服务器读取数据
			getContentPane().removeAll();
			init();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
