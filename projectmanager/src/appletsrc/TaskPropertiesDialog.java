// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TaskPropertiesDialog.java

package appletsrc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.text.MaskFormatter;

import com.borland.jbcl.layout.XYConstraints;
import com.borland.jbcl.layout.XYLayout;

import edu.pm.vo.Targets;

// Referenced classes of package cn.ac.intec.ganttproject.dialog:
//            CalendarDialog

public class TaskPropertiesDialog extends JDialog
{

    public TaskPropertiesDialog(Frame frame, String title, boolean modal, Targets tk)
    {
        super(frame, "任务信息", modal);
        rowsData = new Vector();
        panel1 = new JPanel();
        borderLayout1 = new BorderLayout();
        jTabbedPane1 = new JTabbedPane();
        propPanel = new JPanel();
        memoPanel = new JPanel();
        productPanel = new JPanel();
        buttonPanel = new JPanel();
        xYLayout1 = new XYLayout();
        nameL = new JLabel();
        nameT = new JLabel();
        pSTimeL = new JLabel();
        pETimeL = new JLabel();
        rSTimeL = new JLabel();
        rETimeL = new JLabel();
        whetherMileStone = new JLabel();
        pWorkLoadL = new JLabel();
        pWorkLoadT = new JLabel();
        rWorkLoadL = new JLabel();
        rWorkLoadT = new JLabel();
        colorButton = new JButton("yan se");
        colorSpace = new JButton();
        try
        {
            task = tk;
            initParam();
            jbInit();
            setSize(new Dimension(350, 360));
            setResizable(false);
            center();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public TaskPropertiesDialog(Targets tk, Gantt med)
    {
        this(null, "", false, tk);
        this.med = med;
        //med.setFrontDialog(this);
    }

    private void initParam()
    {
        sTime = task.getStartDatePlan().toString();
        eTime = task.getEndDatePlan().toString();
        //planWorkLoad = task.getPlanWorkload();
       /* try
        {
            Date defaultDate = (new SimpleDateFormat("yyyy-MM-dd")).parse("1000-00-00");
            if(task.getRealStartTime().before(defaultDate))
                rSTime = " ";
            else
                rSTime = util.DateToString(task.getRealStartTime());
            if(task.getRealEndTime().before(defaultDate))
                rETime = " ";
            else
                rETime = util.DateToString(task.getRealEndTime());
            realWorkLoad = task.getRealWorkload();
        }
        catch(ParseException ex) { }*/
    }

    private void jbInit()
        throws Exception
    {
        MaskFormatter mf = new MaskFormatter("####-##-##");
        panel1.setLayout(borderLayout1);
        propPanel.setLayout(xYLayout1);
        nameL.setText("任务名" + ":");
        nameT.setText(task.getTargetName());
        pSTimeL.setText("计划开始时间" + ":");
        rSTimeL.setText("实际开始时间" + ":");
        pETimeL.setText("计划结束时间" + ":");
        rETimeL.setText("实际结束时间" + ":");
       // whetherMileStone.setText((task.getIsMileStone() ? GantteResource.getResourceItem("gantte.yes") : GantteResource.getResourceItem("gantte.no")) + GantteResource.getResourceItem("gantte.milestone"));
        pWorkLoadL.setText("计划工作量" + ":");
        rWorkLoadL.setText("实际工作量" + ":");
        pWorkLoadT.setText(planWorkLoad + " ");
        rWorkLoadT.setText(realWorkLoad + " ");
        pStimeT = new JLabel();
        rStimeT = new JLabel();
        pStimeT.setText(sTime);
        rStimeT.setText(rSTime);
        pEtimeT = new JLabel();
        rEtimeT = new JLabel();
        pEtimeT.setText(eTime);
        rEtimeT.setText(rETime);
        whetherMileStone.setForeground(Color.red);
        propPanel.add(nameT, new XYConstraints(140, 8, 125, 30));
        propPanel.add(nameL, new XYConstraints(25, 8, 125, 30));
        propPanel.add(pWorkLoadT, new XYConstraints(140, 30, 125, 30));
        propPanel.add(pWorkLoadL, new XYConstraints(25, 30, 125, 22));
        propPanel.add(rWorkLoadT, new XYConstraints(140, 60, 125, 30));
        propPanel.add(rWorkLoadL, new XYConstraints(25, 60, 125, 30));
        propPanel.add(pStimeT, new XYConstraints(140, 90, 125, 30));
        propPanel.add(pSTimeL, new XYConstraints(25, 90, 125, 30));
        propPanel.add(pEtimeT, new XYConstraints(140, 120, 125, 30));
        propPanel.add(pETimeL, new XYConstraints(25, 120, 125, 30));
        propPanel.add(rStimeT, new XYConstraints(140, 150, 125, 30));
        propPanel.add(rSTimeL, new XYConstraints(25, 150, 125, 30));
        propPanel.add(rEtimeT, new XYConstraints(140, 180, 125, 30));
        propPanel.add(rETimeL, new XYConstraints(25, 180, 125, 30));
        propPanel.add(whetherMileStone, new XYConstraints(28, 210, 157, 30));
        JButton ok = new JButton("ok");
        buttonPanel.add(ok);
        getRootPane().setDefaultButton(ok);
        ok.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                exit();
            }

        }
);
        JButton cancel = new JButton("cancle");
        buttonPanel.add(cancel);
        cancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
               // med.clearFontDialog();
                dispose();
            }

        }
);
        panel1.add(buttonPanel, "South");
        getContentPane().add(panel1);
        Box b1 = Box.createVerticalBox();
        b1.add(new JLabel("df"));
        tanotes = new JTextArea();
        //tanotes.setText(task.getNote());
        JScrollPane scrollPane = new JScrollPane(tanotes);
        scrollPane.setPreferredSize(new Dimension(300, 180));
        b1.add(scrollPane);
        memoPanel.add(b1, "Center");
        JButton bdate = new JButton(new ImageIcon(getClass().getResource("/icons/clock.gif")));
        bdate.setToolTipText("<html><body bgcolor=#FFFFBD>" + "time set" + "</body></html>");
        bdate.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                //tanotes.append("\n\n" + GanttCalendar.getDateAndTime() + "\n-------------------------------\n");
                tanotes.append("\n\n" + "GanttCalendar.getDateAndTime()" + "\n-------------------------------\n");
                
            }

        }
);
        memoPanel.add(bdate, "South");
        jTabbedPane1.setTabLayoutPolicy(1);
        panel1.add(jTabbedPane1, "Center");
        jTabbedPane1.add(propPanel, "target infor");
        //if(task.getCanBeTailed() != 0)
        if(true)
        {
            JPanel processInfoPanel = new JPanel();
            Box b2 = Box.createVerticalBox();
            JPanel tmp = new JPanel(new BorderLayout());
            //JLabel tail = new JLabel("gantte.currentprocess" + (task.getCanBeTailed() != 1 ? GantteResource.getResourceItem("gantte.cannot") : GantteResource.getResourceItem("gantte.can")) + GantteResource.getResourceItem("gantte.tailored"));
            JLabel tail = new JLabel("gantte.currentprocess" );
            
            tail.setForeground(Color.RED);
            tmp.add(tail, "West");
            b2.add(new JLabel(" "));
            JPanel tmp2 = new JPanel(new BorderLayout());
            tmp2.add(new JLabel("gantte.tailorprinciple"), "West");
            b2.add(tmp2);
            JTextArea tailGuideT = new JTextArea();
            //tailGuideT.setText(task.getTailGuider());
            tailGuideT.setEditable(false);
            JScrollPane scrollPane2 = new JScrollPane(tailGuideT);
            scrollPane2.setPreferredSize(new Dimension(300, 174));
            b2.add(scrollPane2);
            b2.add(tmp);
            processInfoPanel.add(b2, "Center");
            jTabbedPane1.add(processInfoPanel, "gantte.processinfo");
        }
      /*  Vector products = task.getWorkProduct();
        if(products.size() > 0)
        {
            Vector columnNames = new Vector();
            columnNames.add(GantteResource.getResourceItem("gantte.productname"));
            columnNames.add(GantteResource.getResourceItem("gantte.size"));
            columnNames.add(GantteResource.getResourceItem("gantte.unit"));
            for(int i = 0; i < products.size(); i++)
            {
                Vector rowData = new Vector();
                GanttWorkProduct tmp = (GanttWorkProduct)products.get(i);
                rowData.add(tmp.getName());
                rowData.add(tmp.getPlanSize());
                rowData.add(tmp.getSizeUnitId());
                rowsData.add(rowData);
            }

            for(int i = 0; i < 5; i++)
            {
                Vector rowData = new Vector();
                rowData.add("");
                rowData.add("");
                rowData.add("");
                rowsData.add(rowData);
            }

            productTable = MyTable.creatTable(rowsData, columnNames);
            productTable.setEnabled(false);
            productTable.setRowHeight(25);
            productTable.getColumnModel().getColumn(1).setMaxWidth(40);
            productTable.getColumnModel().getColumn(2).setMaxWidth(40);
            JScrollPane scroll = new JScrollPane(productTable);
            scroll.setPreferredSize(new Dimension(300, 220));
            productPanel.add(scroll);
            jTabbedPane1.add(productPanel, GantteResource.getResourceItem("gantte.workproduct"));
        }*/
        JScrollPane scroll = new JScrollPane(productTable);
        scroll.setPreferredSize(new Dimension(300, 220));
        productPanel.add(scroll);
        jTabbedPane1.add(productPanel, "gantte.workproduct");
        
        jTabbedPane1.add(memoPanel, "gantte.memo");
    }

    protected void center()
    {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension us = getSize();
        int x = (screen.width - us.width) / 2;
        int y = (screen.height - us.height) / 2;
        setLocation(x, y);
    }

    private void exit()
    {
       // task.setNote(tanotes.getText());
       // med.clearFontDialog();
        dispose();
    }

    protected void processWindowEvent(WindowEvent evt)
    {
        WindowEvent _tmp = evt;
        if(evt.getID() == 201)
        {
            //med.clearFontDialog();
            dispose();
        }
    }

    Targets task;
    private Gantt med;
    Vector rowsData;
    String sTime;
    String eTime;
    String rSTime;
    String rETime;
    double planWorkLoad;
    double realWorkLoad;
    JPanel panel1;
    BorderLayout borderLayout1;
    JTabbedPane jTabbedPane1;
    JPanel propPanel;
    JPanel memoPanel;
    JPanel productPanel;
    JPanel buttonPanel;
    XYLayout xYLayout1;
    JLabel nameL;
    JLabel nameT;
    JLabel pSTimeL;
    JLabel pETimeL;
    JLabel rSTimeL;
    JLabel rETimeL;
    JLabel whetherMileStone;
    JLabel pWorkLoadL;
    JLabel pWorkLoadT;
    JLabel rWorkLoadL;
    JLabel rWorkLoadT;
    JLabel pStimeT;
    JLabel pEtimeT;
    JLabel rStimeT;
    JLabel rEtimeT;
    JButton colorButton;
    JButton colorSpace;
    CalendarDialog startCalendarDialog;
    CalendarDialog endCalendarDialog;
    protected static JColorChooser colorChooser = new JColorChooser();
    JTextArea tanotes;
    JTable productTable;



}
