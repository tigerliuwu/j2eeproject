package edu.dlmu.sei.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Insets;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.TextTitle;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.BarRenderer;
import org.jfree.chart.renderer.StandardXYItemRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.DefaultCategoryDataset;
import org.jfree.data.DefaultPieDataset;
import org.jfree.data.XYSeries;
import org.jfree.data.XYSeriesCollection;
import org.jfree.data.time.TimeSeriesCollection;


public class ChartUtil {
  public static String createCommonBarChart(String title,String XAxisName,String YAxisName,DefaultCategoryDataset dataset,HttpSession session) {

    String filename = null;
    try{
      if (dataset.getRowCount() == 0) {
        dataset.addValue(new Long(0),null,"无数据！");
      }
      CategoryAxis categoryAxis = new CategoryAxis(XAxisName);

      ValueAxis valueAxis = new NumberAxis(YAxisName);
      valueAxis.setAxisLineVisible(true);
      BarRenderer renderer = new BarRenderer();
      renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
      renderer.setDrawBarOutline(true);
      Plot plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);

      JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot,false);
      chart.setBackgroundPaint(java.awt.Color.white);

      //  Write the chart image to the temporary directory
      ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());

      filename = ServletUtilities.saveChartAsPNG(chart, 600, 360, info, session);

    } catch (Exception e) {
      System.out.println("Exception - " + e.toString());
      e.printStackTrace(System.out);
      filename = "public_error_500x300.png";
    }
    return filename;
  }

  public static String createCommonXYChart(String title,String XAxisName,String YAxisName,XYSeries series,HttpSession session) {

    String filename = null;
    try {
      if (series.getItemCount() == 0) {
        series.add(new Long(0),new Long(0));
      }
      XYSeriesCollection xyDataset = new XYSeriesCollection(series);

      //  Create the chart object
      NumberAxis XAxis = new NumberAxis(XAxisName);
      NumberAxis YAxis = new NumberAxis(YAxisName);
      YAxis.setAutoRangeIncludesZero(false);  // override default
      StandardXYItemRenderer renderer = new StandardXYItemRenderer(
          StandardXYItemRenderer.LINES + StandardXYItemRenderer.SHAPES,
          null, null);
      renderer.setShapesFilled(true);
      XYPlot plot = new XYPlot(xyDataset, XAxis, YAxis, renderer);

      JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, false);
      chart.setBackgroundPaint(java.awt.Color.white);

      //  Write the chart image to the temporary directory
      ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
      filename = ServletUtilities.saveChartAsPNG(chart, 600, 360, info, session);

    } catch (Exception e) {
      System.out.println("Exception - " + e.toString());
      e.printStackTrace(System.out);
      filename = "public_error_500x300.png";
    }
    return filename;
  }

  public static String createCommonPieChart(String title,DefaultPieDataset data,HttpSession session) {
    String filename = null;
    try {
      if (data.getItemCount() == 0) {
        data.setValue("无数据！",new Long(0));
      }
      PiePlot plot = new PiePlot(data);
      plot.setInsets(new Insets(0, 5, 5, 5));
      plot.setToolTipGenerator(new StandardPieToolTipGenerator());
      JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, true);
      chart.setBackgroundPaint(java.awt.Color.white);

      //  Write the chart image to the temporary directory
      ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
      filename = ServletUtilities.saveChartAsPNG(chart, 600, 360, info, session);

    } catch (Exception e) {
      System.out.println("Exception - " + e.toString());
      e.printStackTrace(System.out);
      filename = "public_error_500x300.png";
    }
    return filename;
  }
  
  /**
	 * create date chart 
	 * made by guojc 
	 * date 2006-05-20
	 */
  public static String createDateChart(String title,String XAxisName,String YAxisName,TimeSeriesCollection  data,HttpSession session) {

	    String filename = null;
	    try{
	      
	      JFreeChart chart =ChartFactory.createTimeSeriesChart(title,XAxisName,YAxisName,data,true,true,false);
          chart.setTitle(new TextTitle(title, new Font("宋体", Font.PLAIN, 20)));
          chart.setBackgroundPaint(new GradientPaint(0, 0, Color.white, 0, 1000, Color.white));
          
	      //  Write the chart image to the temporary directory
	      ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
	      filename = ServletUtilities.saveChartAsPNG(chart, 600, 360, info, session);

	    } catch (Exception e) {
	      System.out.println("Exception - " + e.toString());
	      e.printStackTrace(System.out);
	      filename = "public_error_600x360.png";
	    }
	    return filename;
	  }
  
  
  /**
	 * create bar chart 
	 * made by guojc 
	 * date 2006-12-12
	 */
  public static String createBar3DChart(String title,String XAxisName,String YAxisName,DefaultCategoryDataset  data,HttpSession session) {

	    String filename = null;
	    try{
	      
	      JFreeChart chart =ChartFactory.createBarChart3D(title,XAxisName,YAxisName,data,PlotOrientation.VERTICAL,true,false,false);
	      chart.setTitle(new TextTitle(title, new Font("宋体", Font.PLAIN, 20)));
	      chart.setBackgroundPaint(new GradientPaint(0, 0, Color.white, 0, 1000, Color.white));
        
	      //  Write the chart image to the temporary directory
	      ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
	      filename = ServletUtilities.saveChartAsPNG(chart, 600, 360, info, session);

	    } catch (Exception e) {
	      System.out.println("Exception - " + e.toString());
	      e.printStackTrace(System.out);
	      filename = "public_error_600x360.png";
	    }
	    return filename;
	  }

}

