// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CalendarDialog.java

package appletsrc;


import com.borland.jbcl.layout.XYConstraints;
import com.borland.jbcl.layout.XYLayout;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

class CalendarDialog extends Dialog
{
    public static class CalendarTable extends JTable
    {

        public void changeSelection(int row, int column, boolean toggle, boolean extend)
        {
            super.changeSelection(row, column, toggle, extend);
            if(row == 0)
                return;
            Object obj = getValueAt(row, column);
            if(obj != null)
            {
                calendar.set(5, ((Integer)obj).intValue());
                text.setText(CalendarDialog.getStrDate(calendar));
                getParent().getParent().setVisible(false);
            }
        }

        private Calendar calendar;
        private JTextField text;

        public CalendarTable(TableModel model, Calendar calendar, JTextField _text)
        {
            super(model);
            this.calendar = calendar;
            text = _text;
        }
    }


    public CalendarDialog(Dialog ower, JTextField _text)
    {
        super(ower);
        calendar = new GregorianCalendar();
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e)
            {
                dispose();
            }

        }
);
        cPane = new Panel();
        text = _text;
        try
        {
            if(text.getText().equals(""))
                calendar = (GregorianCalendar)GregorianCalendar.getInstance();
            else
                calendar.setTime((new SimpleDateFormat("yyyy-MM-dd")).parse(text.getText()));
        }
        catch(Exception ex)
        {
            calendar = (GregorianCalendar)GregorianCalendar.getInstance();
        }
        init();
        add(cPane);
        setTitle("请选择时间");
        setSize(230, 190);
        setResizable(false);
    }

    public void init()
    {
        cPane.setLayout(new BorderLayout());
        yearsLabel = new JLabel("年");
        yearsLabel.setFont(new Font("Serif", 0, 12));
        yearsSpinner = new JSpinner();
        yearsSpinner.setEditor(new javax.swing.JSpinner.NumberEditor(yearsSpinner, "0000"));
        yearsSpinner.setValue(new Integer(calendar.get(1)));
        yearsSpinner.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent changeEvent)
            {
                int day = calendar.get(5);
                calendar.set(5, 1);
                calendar.set(1, ((Integer)yearsSpinner.getValue()).intValue());
                int maxDay = calendar.getActualMaximum(5);
                calendar.set(5, day <= maxDay ? day : maxDay);
                updateView();
            }

        }
);
        JPanel yearMonthPanel = new JPanel();
        cPane.add(yearMonthPanel, "North");
        yearMonthPanel.setLayout(new BorderLayout());
        yearMonthPanel.add(new JPanel(), "Center");
        JPanel yearPanel = new JPanel();
        yearMonthPanel.add(yearPanel, "West");
        yearPanel.setLayout(new XYLayout());
        yearPanel.add(yearsSpinner, new XYConstraints(0, 0, 60, 25));
        yearPanel.add(yearsLabel, new XYConstraints(60, 0, 50, 25));
        monthsLabel = new JLabel("月");
        monthsLabel.setFont(new Font("Serif", 0, 12));
        monthsComboBox = new JComboBox();
        for(int i = 1; i <= 12; i++)
            monthsComboBox.addItem(i + "");

        monthsComboBox.setSelectedIndex(calendar.get(2));
        monthsComboBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionEvent)
            {
                int day = calendar.get(5);
                calendar.set(5, 1);
                calendar.set(2, monthsComboBox.getSelectedIndex());
                int maxDay = calendar.getActualMaximum(5);
                calendar.set(5, day <= maxDay ? day : maxDay);
                updateView();
            }

        }
);
        monthsComboBox.setBackground(Color.white);
        JPanel monthPanel = new JPanel();
        yearMonthPanel.add(monthPanel, "East");
        monthPanel.setLayout(new XYLayout());
        monthPanel.add(monthsComboBox, new XYConstraints(250, 0, 50, 25));
        monthPanel.add(monthsLabel, new XYConstraints(300, 0, 50, 26));
        daysModel = new AbstractTableModel() {

            public int getRowCount()
            {
                return 7;
            }

            public int getColumnCount()
            {
                return 7;
            }

            public Object getValueAt(int row, int column)
            {
                if(row == 0)
                    return CalendarDialog.getHeader(column);
                row--;
                Calendar calendar = (Calendar)CalendarDialog.this.calendar.clone();
                calendar.set(5, 1);
                int dayCount = calendar.getActualMaximum(5);
                int moreDayCount = calendar.get(7) - 1;
                int index = row * 7 + column;
                int dayIndex = (index - moreDayCount) + 1;
                if(index < moreDayCount || dayIndex > dayCount)
                    return null;
                else
                    return new Integer(dayIndex);
            }

        }
;
        daysTable = new CalendarTable(daysModel, calendar, text);
        daysTable.setFont(new Font("Serif", 0, 12));
        daysTable.setCellSelectionEnabled(true);
        daysTable.setSelectionMode(0);
        cPane.add(daysTable, "Center");
    }

    public static String getHeader(int index)
    {
        switch(index)
        {
        case 0: // '\0'
            return WEEK_SUN;

        case 1: // '\001'
            return WEEK_MON;

        case 2: // '\002'
            return WEEK_TUE;

        case 3: // '\003'
            return WEEK_WED;

        case 4: // '\004'
            return WEEK_THU;

        case 5: // '\005'
            return WEEK_FRI;

        case 6: // '\006'
            return WEEK_SAT;
        }
        return null;
    }

    public void updateView()
    {
        daysModel.fireTableDataChanged();
        daysTable.setRowSelectionInterval(calendar.get(4), calendar.get(4));
        daysTable.setColumnSelectionInterval(calendar.get(7) - 1, calendar.get(7) - 1);
    }

    public void doReSet(String strDate)
    {
        try
        {
            if(strDate.equals(""))
                calendar = (GregorianCalendar)GregorianCalendar.getInstance();
            else
                calendar.setTime((new SimpleDateFormat("yyyy-MM-dd")).parse(strDate));
        }
        catch(Exception ex)
        {
            calendar = (GregorianCalendar)GregorianCalendar.getInstance();
        }
        yearsSpinner.setValue(new Integer(calendar.get(1)));
        monthsComboBox.setSelectedIndex(calendar.get(2));
    }

    public static String getStrDate(Calendar _calendar)
    {
        int year = _calendar.get(1);
        int month = _calendar.get(2) + 1;
        int day = _calendar.get(5);
        String strMonth;
        if(month < 10)
            strMonth = "0" + month;
        else
            strMonth = "" + month;
        String strDay;
        if(day < 10)
            strDay = "0" + day;
        else
            strDay = "" + day;
        return year + "-" + strMonth + "-" + strDay;
    }

    public static final String WEEK_SUN ="日";
    public static final String WEEK_MON ="一";
    public static final String WEEK_TUE ="二";
    public static final String WEEK_WED ="三";
    public static final String WEEK_THU = "四";
    public static final String WEEK_FRI = "五";
    public static final String WEEK_SAT = "六";
    public static final Color background;
    public static final Color foreground;
    public static final Color headerBackground;
    public static final Color headerForeground;
    public static final Color selectedBackground;
    public static final Color selectedForeground;
    private JLabel yearsLabel;
    private JSpinner yearsSpinner;
    private JLabel monthsLabel;
    private JComboBox monthsComboBox;
    private JTable daysTable;
    private AbstractTableModel daysModel;
    private GregorianCalendar calendar;
    private Panel cPane;
    private JTextField text;

    static 
    {
        background = Color.white;
        foreground = Color.black;
        headerBackground = Color.blue;
        headerForeground = Color.white;
        selectedBackground = Color.blue;
        selectedForeground = Color.white;
    }



}
