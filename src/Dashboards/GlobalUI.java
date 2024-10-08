/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dashboards;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author digio
 */

public class GlobalUI {
    final static XYSeries MSI = new XYSeries( "MSI" );           

    final static XYSeries Apple = new XYSeries( "Apple" );
      
    final static XYSeriesCollection dataset = new XYSeriesCollection( );
    
    private static int daycounter = 0;

    public static XYSeries getMSI() {
        return MSI;
    }

    public static XYSeries getApple() {
        return Apple;
    }

    public static XYSeriesCollection getDataset() {
        return dataset;
    }
    
    public static void addMSI(int num1, int num2){
        getMSI().add(num1, num2);
    }
    
    public static void addApple(int num1, int num2){
        getApple().add(num1, num2);
    }   
    
    public static void addSeries(XYSeries serie){
        getDataset().addSeries(serie);
    }

    public static int getDaycounter() {
        return daycounter;
    }

    public static void setDaycounter(int daycounter) {
        GlobalUI.daycounter = daycounter;
    }
        
}
