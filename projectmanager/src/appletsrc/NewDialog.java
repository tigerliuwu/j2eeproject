package appletsrc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.borland.jbcl.layout.XYConstraints;
import com.borland.jbcl.layout.XYLayout;

import edu.dlmu.sei.util.CoreUtils;
import edu.pm.vo.Targets;

public class NewDialog extends JDialog
{
	Font myfont=new Font("SansSerif",   0,   12);

	public NewDialog(Frame frame, String title, boolean modal,Gantt gantt)
    {
		
        super(frame, title, modal);
       
        panel1 = new JPanel();
        borderLayout1 = new BorderLayout();
        jTabbedPane1 = new JTabbedPane();
        jTabbedPane1.setFont(myfont);
        propPanel = new JPanel();
        propPanel2 = new JPanel();
        xYLayout1 = new XYLayout();
        projNameL = new JLabel();
        projNameL.setFont(myfont);
        sTimeL = new JLabel();
        sTimeL.setFont(myfont);
        eTimeL = new JLabel();
        eTimeL.setFont(myfont);
        sTimeText = new JTextField();
        eTimeText = new JTextField();
        targetNameText= new JTextField();
        buttonPanel = new JPanel();
        this.gantt=gantt;
			
        try
        {
            jbInit();
            setSize(new Dimension(300, 250));
            center();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public NewDialog(Gantt gantt)
    {
        this(null, "新建任务", false,gantt);
        //md.setFrontDialog(this);
    }
    
    

    private void jbInit()
        throws Exception
    {
    	
			
        panel1.setLayout(borderLayout1);
        propPanel.setLayout(xYLayout1);
        projNameL.setText("任务名称:");
        sTimeL.setText("开始时间:");
        eTimeL.setText("结束时间:");
       
        propPanel.add(projNameL, new XYConstraints(28, 20, 100, 36));
        propPanel.add(targetNameText, new XYConstraints(100, 20, 150, 25));
        propPanel.add(sTimeL, new XYConstraints(28, 60, 100, 36));
        propPanel.add(sTimeText, new XYConstraints(100, 60, 150, 25));
        propPanel.add(eTimeL, new XYConstraints(28, 100, 100, 36));
        propPanel.add(eTimeText, new XYConstraints(100, 100, 150, 25));
        
        JButton ok = new JButton("确定");
        ok.setFont(myfont);
        buttonPanel.add(ok);
        JButton cancle = new JButton("取消");
        cancle.setFont(myfont);
        buttonPanel.add(cancle);
        getRootPane().setDefaultButton(ok);
        ok.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
            	Targets target =new Targets();
            	target.setTargetName(targetNameText.getText().trim());
            	target.setStartDatePlan(CoreUtils.parseDate(sTimeText.getText().trim()));
            	target.setEndDatePlan(CoreUtils.parseDate(eTimeText.getText().trim()));
            	gantt.newTargetBack(target);
                dispose();
            }

        }
        );
        cancle.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
               // med.clearFontDialog();
                dispose();
            }

        }
        );
        
        getContentPane().add(panel1);
        panel1.add(jTabbedPane1, "Center");
        jTabbedPane1.add(propPanel, "新建子任务");
        // jTabbedPane1.add(propPanel2, "project property2");
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
    JLabel sTimeL;
    JLabel eTimeL;
    JPanel buttonPanel;
    
    JTextField targetNameText;
    JTextField sTimeText;
    JTextField eTimeText;
    JRadioButton child;
    JRadioButton brother;
    SimpleDateFormat myFmt1=new SimpleDateFormat("yyyy-MM-dd");
}
