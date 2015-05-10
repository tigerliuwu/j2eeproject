package appletsrc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.borland.jbcl.layout.XYConstraints;
import com.borland.jbcl.layout.XYLayout;

import edu.pm.vo.Targets;

public class DeleteDialog extends JDialog
{

	
    
	public DeleteDialog(Frame frame, String title, boolean modal,Targets target,Gantt gantt)
    {
        super(frame, title, modal);
        panel1 = new JPanel();
        borderLayout1 = new BorderLayout();
        jTabbedPane1 = new JTabbedPane();
        propPanel = new JPanel();
        propPanel2 = new JPanel();
        xYLayout1 = new XYLayout();
        projNameL = new JLabel();
        projNameT = new JLabel();
        sTimeL = new JLabel();
        sTimeT = new JLabel();
        eTimeL = new JLabel();
        eTimeT = new JLabel();
        buttonPanel = new JPanel();
        this.target=target;
        this.gantt=gantt;
			
        try
        {
            jbInit();
            setSize(new Dimension(300, 200));
            center();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public DeleteDialog(Targets target,Gantt gantt)
    {
        this(null, "删除任务", false,target,gantt);
        //md.setFrontDialog(this);
    }
    
    

    private void jbInit()
        throws Exception
    {
    	
			
        panel1.setLayout(borderLayout1);
        propPanel.setLayout(xYLayout1);
        projNameL.setText("任务名称:");
        projNameT.setText(target.getTargetName());
        sTimeT.setText("真的删除吗？");
       
        propPanel.add(projNameL, new XYConstraints(28, 20, 100, 36));
        propPanel.add(projNameT, new XYConstraints(100, 20, 162, 35));
        propPanel.add(sTimeT, new XYConstraints(100, 60, 130, 33));
        JButton ok = new JButton("确定");
        buttonPanel.add(ok);
        JButton cancle = new JButton("取消");
        buttonPanel.add(cancle);
        getRootPane().setDefaultButton(ok);
        ok.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
               // med.clearFontDialog();
            	//gantt.whatdo();
                dispose();
            }

        }
        );
        cancle.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
               // med.clearFontDialog();
            	//gantt.whatdo();
                dispose();
            }

        }
        );
        getContentPane().add(panel1);
        panel1.add(propPanel, "Center");
        panel1.add(buttonPanel, "South");
    }

    protected void center()
    {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension us = getSize();
        int x = (screen.width - us.width) / 2;
        int y = (screen.height - us.height) / 2;
        setLocation(x, y);
    }

    protected void processWindowEvent(WindowEvent evt)
    {
        WindowEvent _tmp = evt;
        if(evt.getID() == 201)
        {
           // med.clearFontDialog();
            dispose();
        }
    }

   // Mediator med;
    JPanel propPanel2;
    Gantt gantt;
    Targets target;
    JPanel panel1;
    BorderLayout borderLayout1;
    JTabbedPane jTabbedPane1;
    JPanel propPanel;
    XYLayout xYLayout1;
    JLabel projNameL;
    JLabel projNameT;
    JLabel sTimeL;
    JLabel sTimeT;
    JLabel eTimeL;
    JLabel eTimeT;
    JPanel buttonPanel;
    SimpleDateFormat myFmt1=new SimpleDateFormat("yyyy-MM-dd");
}
