/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Dashboards;

import Classes.Company;
import Classes.Director;
//import Classes.DirectorWatch;
import Classes.Workers; 
import Classes.Storehouse;
import Classes.Assemblers;
import Classes.LinkedList;
import Classes.ProjectManager;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;
import javax.swing.JLabel;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author digio
 */
public class Dashboard extends javax.swing.JFrame {
    //Se inicializan las compañias con parametros por defecto
        Company apple = new Company(18, "Apple");
        Company msi = new Company(20, "MSI");
        boolean iniciado=false;
        int max_apple = 18; //Carnet de Alexia Leon termina en 6
        int max_msi = 20; //Carnet de Diego Di Giosa termina en 8
        private String path;
    
        //Se inicializa la variable de duracion de dia
        int dayDuration;
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        this.setLocationRelativeTo(null);        
        
         //Se pasan los labels correspondientes a cada compañia y sus drives para manipular la interfaz        
        JLabel[] appStorehouseLabels = {Almacen_Placas_Apple, Almacen_CPU_Apple, Almacen_RAM_Apple, Almacen_FuenteA_Apple, Almacen_Tarjetas_Apple, Apple_Deadline_Counter, Apple_Cont_SinTarjeta, Apple_Cont_ConTarjeta};
        
        
        JLabel[] msiStorehouseLabels = {Almacen_Placas_MSI, Almacen_CPU_MSI, Almacen_RAM_MSI, Almacen_FuenteA_MSI, Almacen_Tarjetas_MSI, MSI_Deadline_Counter, MSI_Cont_SinTarjeta, MSI_Cont_ConTarjeta};  
        
        
        
        
        this.apple.getCompanyStorehouse().setLabels(appStorehouseLabels);
        
        this.msi.getCompanyStorehouse().setLabels(msiStorehouseLabels);
        
        
        //Se refleja la lectura la lectura de desarrolladores maximos de cada compañia    
        Cont_Trabajadores_Apple.setText(Integer.toString(this.apple.getMaxWorkers()));
        Cont_Trabajadores_MSI.setText(Integer.toString(this.msi.getMaxWorkers()));
        
    }
         public String getPath() {
        return path;
        }

        public void setPath(String path) {
        this.path = path;
        }

    public JLabel getAlmacen_CPU_Apple() {
        return Almacen_CPU_Apple;
    }

    public void setAlmacen_CPU_Apple(JLabel Almacen_CPU_Apple) {
        this.Almacen_CPU_Apple = Almacen_CPU_Apple;
    }

    public JLabel getAlmacen_CPU_MSI() {
        return Almacen_CPU_MSI;
    }
    
    public void setAlmacen_CPU_MSI(JLabel Almacen_CPU_MSI) {
        this.Almacen_CPU_MSI = Almacen_CPU_MSI;
    }

    public JLabel getAlmacen_FuenteA_Apple() {
        return Almacen_FuenteA_Apple;
    }

    public void setAlmacen_FuenteA_Apple(JLabel Almacen_FuenteA_Apple) {
        this.Almacen_FuenteA_Apple = Almacen_FuenteA_Apple;
    }

    public JLabel getAlmacen_FuenteA_MSI() {
        return Almacen_FuenteA_MSI;
    }

    public void setAlmacen_FuenteA_MSI(JLabel Almacen_FuenteA_MSI) {
        this.Almacen_FuenteA_MSI = Almacen_FuenteA_MSI;
    }

    public JLabel getAlmacen_Placas_Apple() {
        return Almacen_Placas_Apple;
    }

    public void setAlmacen_Placas_Apple(JLabel Almacen_Placas_Apple) {
        this.Almacen_Placas_Apple = Almacen_Placas_Apple;
    }

    public JLabel getAlmacen_Placas_MSI() {
        return Almacen_Placas_MSI;
    }

    public void setAlmacen_Placas_MSI(JLabel Almacen_Placas_MSI) {
        this.Almacen_Placas_MSI = Almacen_Placas_MSI;
    }

    public JLabel getAlmacen_RAM_Apple() {
        return Almacen_RAM_Apple;
    }

    public void setAlmacen_RAM_Apple(JLabel Almacen_RAM_Apple) {
        this.Almacen_RAM_Apple = Almacen_RAM_Apple;
    }

    public JLabel getAlmacen_RAM_MSI() {
        return Almacen_RAM_MSI;
    }

    public void setAlmacen_RAM_MSI(JLabel Almacen_RAM_MSI) {
        this.Almacen_RAM_MSI = Almacen_RAM_MSI;
    }

    public JLabel getAlmacen_Tarjetas_Apple() {
        return Almacen_Tarjetas_Apple;
    }

    public void setAlmacen_Tarjetas_Apple(JLabel Almacen_Tarjetas_Apple) {
        this.Almacen_Tarjetas_Apple = Almacen_Tarjetas_Apple;
    }

    public JLabel getAlmacen_Tarjetas_MSI() {
        return Almacen_Tarjetas_MSI;
    }

    public void setAlmacen_Tarjetas_MSI(JLabel Almacen_Tarjetas_MSI) {
        this.Almacen_Tarjetas_MSI = Almacen_Tarjetas_MSI;
    }

    public JLabel getApple_Cont_ConTarjeta() {
        return Apple_Cont_ConTarjeta;
    }

    public void setApple_Cont_ConTarjeta(JLabel Apple_Cont_ConTarjeta) {
        this.Apple_Cont_ConTarjeta = Apple_Cont_ConTarjeta;
    }

    public JLabel getApple_Cont_SinTarjeta() {
        return Apple_Cont_SinTarjeta;
    }

    public void setApple_Cont_SinTarjeta(JLabel Apple_Cont_SinTarjeta) {
        this.Apple_Cont_SinTarjeta = Apple_Cont_SinTarjeta;
    }

    public static JLabel getApple_Deadline_Counter() {
        return Apple_Deadline_Counter;
    }

    public void setApple_Deadline_Counter(JLabel Apple_Deadline_Counter) {
        this.Apple_Deadline_Counter = Apple_Deadline_Counter;
    }

    public static JLabel getApple_Director_State() {
        return Apple_Director_State;
    }

    public void setApple_Director_State(JLabel Apple_Director_State) {
        this.Apple_Director_State = Apple_Director_State;
    }

    public static JLabel getApple_Discount_Counter() {
        return Apple_Discount_Counter;
    }

    public void setApple_Discount_Counter(JLabel Apple_Discount_Counter) {
        this.Apple_Discount_Counter = Apple_Discount_Counter;
    }

    public static JLabel getApple_Fail_Counter() {
        return Apple_Fail_Counter;
    }

    public void setApple_Fail_Counter(JLabel Apple_Fail_Counter) {
        this.Apple_Fail_Counter = Apple_Fail_Counter;
    }

    public static JLabel getApple_Gain_Counter() {
        return Apple_Gain_Counter;
    }

    public void setApple_Gain_Counter(JLabel Apple_Gain_Counter) {
        this.Apple_Gain_Counter = Apple_Gain_Counter;
    }

    public static JLabel getApple_Loss_Counter() {
        return Apple_Loss_Counter;
    }

    public void setApple_Loss_Counter(JLabel Apple_Loss_Counter) {
        this.Apple_Loss_Counter = Apple_Loss_Counter;
    }

    public static JLabel getApple_Pm_State() {
        return Apple_Pm_State;
    }

    public void setApple_Pm_State(JLabel Apple_Pm_State) {
        this.Apple_Pm_State = Apple_Pm_State;
    }

    public static JLabel getApple_Utility_Counter() {
        return Apple_Utility_Counter;
    }

    public void setApple_Utility_Counter(JLabel Apple_Utility_Counter) {
        this.Apple_Utility_Counter = Apple_Utility_Counter;
    }

    public JLabel getMSI_Cont_ConTarjeta() {
        return MSI_Cont_ConTarjeta;
    }

    public void setMSI_Cont_ConTarjeta(JLabel MSI_Cont_ConTarjeta) {
        this.MSI_Cont_ConTarjeta = MSI_Cont_ConTarjeta;
    }

    public JLabel getMSI_Cont_SinTarjeta() {
        return MSI_Cont_SinTarjeta;
    }

    public void setMSI_Cont_SinTarjeta(JLabel MSI_Cont_SinTarjeta) {
        this.MSI_Cont_SinTarjeta = MSI_Cont_SinTarjeta;
    }

    public static JLabel getMSI_Deadline_Counter() {
        return MSI_Deadline_Counter;
    }

    public void setMSI_Deadline_Counter(JLabel MSI_Deadline_Counter) {
        this.MSI_Deadline_Counter = MSI_Deadline_Counter;
    }

    public static JLabel getMSI_Director_State() {
        return MSI_Director_State;
    }

    public void setMSI_Director_State(JLabel MSI_Director_State) {
        this.MSI_Director_State = MSI_Director_State;
    }

    public static JLabel getMSI_Discount_Counter() {
        return MSI_Discount_Counter;
    }

    public void setMSI_Discount_Counter(JLabel MSI_Discount_Counter) {
        this.MSI_Discount_Counter = MSI_Discount_Counter;
    }

    public static JLabel getMSI_Fail_Counter() {
        return MSI_Fail_Counter;
    }

    public void setMSI_Fail_Counter(JLabel MSI_Fail_Counter) {
        this.MSI_Fail_Counter = MSI_Fail_Counter;
    }

    public static JLabel getMSI_Gain_Counter() {
        return MSI_Gain_Counter;
    }

    public void setMSI_Gain_Counter(JLabel MSI_Gain_Counter) {
        this.MSI_Gain_Counter = MSI_Gain_Counter;
    }

    public static JLabel getMSI_Loss_Counter() {
        return MSI_Loss_Counter;
    }

    public void setMSI_Loss_Counter(JLabel MSI_Loss_Counter) {
        this.MSI_Loss_Counter = MSI_Loss_Counter;
    }

    public static JLabel getMSI_Pm_State() {
        return MSI_Pm_State;
    }

    public void setMSI_Pm_State(JLabel MSI_Pm_State) {
        this.MSI_Pm_State = MSI_Pm_State;
    }

    public static JLabel getMSI_Utility_Counter() {
        return MSI_Utility_Counter;
    }

    public void setMSI_Utility_Counter(JLabel MSI_Utility_Counter) {
        this.MSI_Utility_Counter = MSI_Utility_Counter;
    }
        
 
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        Inicio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Cont_Deadline = new javax.swing.JSpinner();
        Cont_Day_Duration = new javax.swing.JSpinner();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        LogoApple = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        LogoMSI = new javax.swing.JLabel();
        IniciarSimulacion = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        Apple = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        Cont_Placas_Apple = new javax.swing.JSpinner();
        Cont_CPU_Apple = new javax.swing.JSpinner();
        Cont_RAM_Apple = new javax.swing.JSpinner();
        Cont_FuenteA_Apple = new javax.swing.JSpinner();
        Cont_Tarjetas_Apple = new javax.swing.JSpinner();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        Cont_Ensamblador_Apple = new javax.swing.JSpinner();
        Cont_Trabajadores_Apple = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Apple_Director_State = new javax.swing.JLabel();
        Apple_Pm_State = new javax.swing.JLabel();
        Apple_Fail_Counter = new javax.swing.JLabel();
        Apple_Discount_Counter = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Apple_Deadline_Counter = new javax.swing.JLabel();
        Apple_Gain_Counter = new javax.swing.JLabel();
        Apple_Loss_Counter = new javax.swing.JLabel();
        Apple_Utility_Counter = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        Almacen_Placas_Apple = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        Almacen_CPU_Apple = new javax.swing.JLabel();
        Almacen_RAM_Apple = new javax.swing.JLabel();
        Almacen_FuenteA_Apple = new javax.swing.JLabel();
        Almacen_Tarjetas_Apple = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        Apple_Cont_SinTarjeta = new javax.swing.JLabel();
        Apple_Cont_ConTarjeta = new javax.swing.JLabel();
        AppleIcon = new javax.swing.JLabel();
        MSI = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        MSI_Director_State = new javax.swing.JLabel();
        MSI_Pm_State = new javax.swing.JLabel();
        MSI_Fail_Counter = new javax.swing.JLabel();
        MSI_Discount_Counter = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        MSI_Deadline_Counter = new javax.swing.JLabel();
        MSI_Gain_Counter = new javax.swing.JLabel();
        MSI_Loss_Counter = new javax.swing.JLabel();
        MSI_Utility_Counter = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        Cont_Placas_MSI = new javax.swing.JSpinner();
        Cont_CPU_MSI = new javax.swing.JSpinner();
        Cont_RAM_MSI = new javax.swing.JSpinner();
        Cont_FuenteA_MSI = new javax.swing.JSpinner();
        Cont_Tarjetas_MSI = new javax.swing.JSpinner();
        Cont_Ensamblador_MSI = new javax.swing.JSpinner();
        Cont_Trabajadores_MSI = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        Almacen_Placas_MSI = new javax.swing.JLabel();
        Almacen_CPU_MSI = new javax.swing.JLabel();
        Almacen_RAM_MSI = new javax.swing.JLabel();
        Almacen_FuenteA_MSI = new javax.swing.JLabel();
        Almacen_Tarjetas_MSI = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        MSI_Cont_SinTarjeta = new javax.swing.JLabel();
        MSI_Cont_ConTarjeta = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        IconMSI = new javax.swing.JLabel();
        Grafico = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        panelChart = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Inicio.setName(""); // NOI18N
        Inicio.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DURACIÓN DE DÍAS");
        Inicio.add(jLabel1);
        jLabel1.setBounds(30, 390, 150, 50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DEADLINES");
        Inicio.add(jLabel2);
        jLabel2.setBounds(30, 450, 80, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ESTABLECE UNA CONFIGURACIÓN INICIAL:");
        Inicio.add(jLabel3);
        jLabel3.setBounds(30, 370, 320, 20);
        Inicio.add(Cont_Deadline);
        Cont_Deadline.setBounds(180, 440, 70, 30);

        Cont_Day_Duration.setValue(1);
        Cont_Day_Duration.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Cont_Day_DurationStateChanged(evt);
            }
        });
        Inicio.add(Cont_Day_Duration);
        Cont_Day_Duration.setBounds(180, 400, 70, 30);

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("PRODUCTORES DE  ");
        jLabel4.setToolTipText("");

        LogoApple.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LogoApple.png"))); // NOI18N
        LogoApple.setText("jLabel102");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogoApple, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogoApple, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        Inicio.add(jPanel7);
        jPanel7.setBounds(0, 0, 440, 500);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel54.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel54.setText("COMPUTADORAS");

        LogoMSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LogoMSI.png"))); // NOI18N

        IniciarSimulacion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        IniciarSimulacion.setText("INICIAR SIMULACION");
        IniciarSimulacion.setToolTipText("");
        IniciarSimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarSimulacionActionPerformed(evt);
            }
        });

        SaveButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SaveButton.setText("GUARDAR");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(LogoMSI)))
                .addContainerGap(100, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IniciarSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(LogoMSI, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(IniciarSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        Inicio.add(jPanel8);
        jPanel8.setBounds(440, 0, 430, 500);

        jTabbedPane1.addTab("Inicio", Inicio);

        Apple.setBackground(new java.awt.Color(51, 51, 51));
        Apple.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("TRABAJADORES DISPONIBLES:");

        Cont_Placas_Apple.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Cont_Placas_AppleStateChanged(evt);
            }
        });

        Cont_CPU_Apple.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Cont_CPU_AppleStateChanged(evt);
            }
        });

        Cont_RAM_Apple.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Cont_RAM_AppleStateChanged(evt);
            }
        });

        Cont_FuenteA_Apple.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Cont_FuenteA_AppleStateChanged(evt);
            }
        });

        Cont_Tarjetas_Apple.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Cont_Tarjetas_AppleStateChanged(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Productores de placas base:");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Productores de CPUs:");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Productores de Memoria RAM:");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Productores de Fuente de alimentacion:");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Productores de tarjetas graficas:");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Ensambladores:");

        Cont_Ensamblador_Apple.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Cont_Ensamblador_AppleStateChanged(evt);
            }
        });

        Cont_Trabajadores_Apple.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Cont_Trabajadores_Apple.setForeground(new java.awt.Color(255, 255, 255));
        Cont_Trabajadores_Apple.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Cont_Trabajadores_Apple, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cont_RAM_Apple, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cont_CPU_Apple, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cont_Placas_Apple, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cont_FuenteA_Apple, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cont_Tarjetas_Apple, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cont_Ensamblador_Apple, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(Cont_Trabajadores_Apple))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(Cont_Placas_Apple, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cont_CPU_Apple, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cont_RAM_Apple, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cont_FuenteA_Apple, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(Cont_Tarjetas_Apple, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(Cont_Ensamblador_Apple, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        Apple.add(jPanel1);
        jPanel1.setBounds(10, 210, 360, 280);

        jPanel2.setBackground(new java.awt.Color(7, 121, 131));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ESTADOS");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("DIRECTOR:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PROJECT MANAGER:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("FALTAS DEL PM:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("SUELDO DESCONTADO:");

        Apple_Director_State.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Apple_Director_State.setForeground(new java.awt.Color(255, 255, 255));
        Apple_Director_State.setText("Trabajando");

        Apple_Pm_State.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Apple_Pm_State.setForeground(new java.awt.Color(255, 255, 255));
        Apple_Pm_State.setText("Trabajando");

        Apple_Fail_Counter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Apple_Fail_Counter.setForeground(new java.awt.Color(255, 255, 255));
        Apple_Fail_Counter.setText("0");

        Apple_Discount_Counter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Apple_Discount_Counter.setForeground(new java.awt.Color(255, 255, 255));
        Apple_Discount_Counter.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Apple_Pm_State, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Apple_Director_State, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Apple_Fail_Counter, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Apple_Discount_Counter, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Apple_Director_State))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Apple_Pm_State))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(Apple_Fail_Counter)
                    .addComponent(Apple_Discount_Counter))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        Apple.add(jPanel2);
        jPanel2.setBounds(10, 60, 510, 140);

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("DEADLINE: ");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("GANANCIAS:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("GASTOS:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("UTILIDAD:");

        Apple_Deadline_Counter.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Apple_Deadline_Counter.setForeground(new java.awt.Color(255, 255, 255));
        Apple_Deadline_Counter.setText("0");

        Apple_Gain_Counter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Apple_Gain_Counter.setForeground(new java.awt.Color(255, 255, 255));
        Apple_Gain_Counter.setText("0");

        Apple_Loss_Counter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Apple_Loss_Counter.setForeground(new java.awt.Color(255, 255, 255));
        Apple_Loss_Counter.setText("0");

        Apple_Utility_Counter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Apple_Utility_Counter.setForeground(new java.awt.Color(255, 255, 255));
        Apple_Utility_Counter.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Apple_Deadline_Counter, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Apple_Gain_Counter, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(Apple_Loss_Counter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Apple_Utility_Counter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Apple_Deadline_Counter)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(Apple_Gain_Counter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(Apple_Loss_Counter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(Apple_Utility_Counter))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        Apple.add(jPanel3);
        jPanel3.setBounds(530, 60, 330, 140);

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("APPLE");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(569, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Apple.add(jPanel4);
        jPanel4.setBounds(-10, 0, 810, 60);

        jPanel5.setBackground(new java.awt.Color(97, 115, 169));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("ALMACEN:");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Placas Base:");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("CPUs:");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Memorias RAM:");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("F. Alimentacion:");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Tarjetas Graficas:");

        Almacen_Placas_Apple.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Almacen_Placas_Apple.setForeground(new java.awt.Color(255, 255, 255));
        Almacen_Placas_Apple.setText("0");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("/25");

        Almacen_CPU_Apple.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Almacen_CPU_Apple.setForeground(new java.awt.Color(255, 255, 255));
        Almacen_CPU_Apple.setText("0");

        Almacen_RAM_Apple.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Almacen_RAM_Apple.setForeground(new java.awt.Color(255, 255, 255));
        Almacen_RAM_Apple.setText("0");

        Almacen_FuenteA_Apple.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Almacen_FuenteA_Apple.setForeground(new java.awt.Color(255, 255, 255));
        Almacen_FuenteA_Apple.setText("0");

        Almacen_Tarjetas_Apple.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Almacen_Tarjetas_Apple.setForeground(new java.awt.Color(255, 255, 255));
        Almacen_Tarjetas_Apple.setText("0");

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("/20");

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("/55");

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("/35");

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("/10");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(63, 63, 63))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Almacen_CPU_Apple, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(Almacen_Tarjetas_Apple, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                                            .addComponent(Almacen_FuenteA_Apple, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Almacen_RAM_Apple, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(53, 53, 53)
                                    .addComponent(Almacen_Placas_Apple, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(Almacen_Placas_Apple)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(Almacen_CPU_Apple)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(Almacen_RAM_Apple)
                    .addComponent(jLabel47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(Almacen_FuenteA_Apple)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(Almacen_Tarjetas_Apple)
                    .addComponent(jLabel49))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        Apple.add(jPanel5);
        jPanel5.setBounds(380, 210, 200, 180);

        jPanel6.setBackground(new java.awt.Color(102, 102, 255));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("COMP. FABR:");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Sin Tarjetas Graficas:");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Con Tarjetas Graficas:");

        Apple_Cont_SinTarjeta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Apple_Cont_SinTarjeta.setForeground(new java.awt.Color(255, 255, 255));
        Apple_Cont_SinTarjeta.setText("0");

        Apple_Cont_ConTarjeta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Apple_Cont_ConTarjeta.setForeground(new java.awt.Color(255, 255, 255));
        Apple_Cont_ConTarjeta.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Apple_Cont_ConTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel38)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Apple_Cont_SinTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel36)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(Apple_Cont_SinTarjeta))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel38)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Apple_Cont_ConTarjeta)
                    .addComponent(jLabel39))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Apple.add(jPanel6);
        jPanel6.setBounds(380, 400, 200, 90);

        AppleIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-apple-256.png"))); // NOI18N
        Apple.add(AppleIcon);
        AppleIcon.setBounds(580, 230, 250, 240);

        jTabbedPane1.addTab("Apple", Apple);

        MSI.setBackground(new java.awt.Color(51, 51, 51));

        jPanel10.setBackground(new java.awt.Color(255, 102, 102));

        jLabel56.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("ESTADOS");

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("DIRECTOR:");

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("PROJECT MANAGER:");

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("FALTAS DEL PM:");

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("SUELDO DESCONTADO:");

        MSI_Director_State.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MSI_Director_State.setForeground(new java.awt.Color(255, 255, 255));
        MSI_Director_State.setText("Trabajando");

        MSI_Pm_State.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MSI_Pm_State.setForeground(new java.awt.Color(255, 255, 255));
        MSI_Pm_State.setText("Trabajando");

        MSI_Fail_Counter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MSI_Fail_Counter.setForeground(new java.awt.Color(255, 255, 255));
        MSI_Fail_Counter.setText("0");

        MSI_Discount_Counter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MSI_Discount_Counter.setForeground(new java.awt.Color(255, 255, 255));
        MSI_Discount_Counter.setText("0");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MSI_Director_State, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MSI_Pm_State, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MSI_Fail_Counter, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MSI_Discount_Counter, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MSI_Director_State, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel57))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MSI_Pm_State)
                    .addComponent(jLabel58))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jLabel60)
                    .addComponent(MSI_Discount_Counter)
                    .addComponent(MSI_Fail_Counter))
                .addGap(18, 18, 18))
        );

        jPanel11.setBackground(new java.awt.Color(255, 204, 153));

        jLabel65.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("DEADLINE:");

        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("GANANCIAS:");

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("GASTOS:");

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("UTILIDAD:");

        MSI_Deadline_Counter.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        MSI_Deadline_Counter.setForeground(new java.awt.Color(255, 255, 255));
        MSI_Deadline_Counter.setText("0");

        MSI_Gain_Counter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MSI_Gain_Counter.setForeground(new java.awt.Color(255, 255, 255));
        MSI_Gain_Counter.setText("0");

        MSI_Loss_Counter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MSI_Loss_Counter.setForeground(new java.awt.Color(255, 255, 255));
        MSI_Loss_Counter.setText("0");

        MSI_Utility_Counter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MSI_Utility_Counter.setForeground(new java.awt.Color(255, 255, 255));
        MSI_Utility_Counter.setText("0");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel68, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                            .addComponent(jLabel67, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MSI_Loss_Counter, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MSI_Utility_Counter, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MSI_Gain_Counter, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MSI_Deadline_Counter, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(MSI_Deadline_Counter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(MSI_Gain_Counter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(MSI_Loss_Counter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(MSI_Utility_Counter))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(255, 0, 102));

        jLabel73.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("TRABAJADORES DISPONIBLES:");

        jLabel85.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setText("Productores de placas base:");

        jLabel86.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setText("Productores de CPUs:");

        jLabel87.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setText("Productores de memorias RAM:");

        jLabel88.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setText("Productores de Fuente de alimentacion:");

        jLabel89.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setText("Productores de tarjetas graficas:");

        jLabel90.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setText("Ensambladores:");

        Cont_Placas_MSI.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Cont_Placas_MSIStateChanged(evt);
            }
        });

        Cont_CPU_MSI.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Cont_CPU_MSIStateChanged(evt);
            }
        });

        Cont_RAM_MSI.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Cont_RAM_MSIStateChanged(evt);
            }
        });

        Cont_FuenteA_MSI.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Cont_FuenteA_MSIStateChanged(evt);
            }
        });

        Cont_Tarjetas_MSI.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Cont_Tarjetas_MSIStateChanged(evt);
            }
        });

        Cont_Ensamblador_MSI.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Cont_Ensamblador_MSIStateChanged(evt);
            }
        });

        Cont_Trabajadores_MSI.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Cont_Trabajadores_MSI.setForeground(new java.awt.Color(255, 255, 255));
        Cont_Trabajadores_MSI.setText("0");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                .addComponent(Cont_Tarjetas_MSI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Cont_Ensamblador_MSI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Cont_FuenteA_MSI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Cont_Placas_MSI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Cont_CPU_MSI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Cont_RAM_MSI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cont_Trabajadores_MSI, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(Cont_Trabajadores_MSI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel85)
                    .addComponent(Cont_Placas_MSI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel86)
                    .addComponent(Cont_CPU_MSI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cont_RAM_MSI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel87))
                .addGap(15, 15, 15)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cont_FuenteA_MSI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel88))
                .addGap(12, 12, 12)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel89)
                    .addComponent(Cont_Tarjetas_MSI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cont_Ensamblador_MSI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel90))
                .addGap(16, 16, 16))
        );

        jPanel13.setBackground(new java.awt.Color(255, 153, 102));
        jPanel13.setForeground(new java.awt.Color(255, 255, 255));

        jLabel74.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("ALMACEN:");

        jLabel75.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("Placas Base:");

        jLabel76.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("CPUs:");

        jLabel77.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("Memorias RAM:");

        jLabel78.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setText("F. Alimentacion:");

        jLabel79.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setText("Tarjetas Graficas:");

        Almacen_Placas_MSI.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Almacen_Placas_MSI.setForeground(new java.awt.Color(255, 255, 255));
        Almacen_Placas_MSI.setText("0");

        Almacen_CPU_MSI.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Almacen_CPU_MSI.setForeground(new java.awt.Color(255, 255, 255));
        Almacen_CPU_MSI.setText("0");

        Almacen_RAM_MSI.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Almacen_RAM_MSI.setForeground(new java.awt.Color(255, 255, 255));
        Almacen_RAM_MSI.setText("0");

        Almacen_FuenteA_MSI.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Almacen_FuenteA_MSI.setForeground(new java.awt.Color(255, 255, 255));
        Almacen_FuenteA_MSI.setText("0");

        Almacen_Tarjetas_MSI.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Almacen_Tarjetas_MSI.setForeground(new java.awt.Color(255, 255, 255));
        Almacen_Tarjetas_MSI.setText("0");

        jLabel97.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(255, 255, 255));
        jLabel97.setText("/25");

        jLabel98.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(255, 255, 255));
        jLabel98.setText("/20");

        jLabel99.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(255, 255, 255));
        jLabel99.setText("/55");

        jLabel100.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(255, 255, 255));
        jLabel100.setText("/35");

        jLabel101.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(255, 255, 255));
        jLabel101.setText("/10");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Almacen_Placas_MSI, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(Almacen_CPU_MSI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Almacen_RAM_MSI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Almacen_FuenteA_MSI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Almacen_Tarjetas_MSI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel74)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(Almacen_Placas_MSI)
                    .addComponent(jLabel97))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(Almacen_CPU_MSI)
                    .addComponent(jLabel98))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(Almacen_RAM_MSI)
                    .addComponent(jLabel99))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(Almacen_FuenteA_MSI)
                    .addComponent(jLabel100))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(Almacen_Tarjetas_MSI)
                    .addComponent(jLabel101))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 153, 153));

        jLabel80.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setText("COMP. FABR:");

        jLabel81.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setText("Sin Tarjetas Graficas:");

        jLabel82.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setText("Con Tarjetas Graficas:");

        MSI_Cont_SinTarjeta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MSI_Cont_SinTarjeta.setForeground(new java.awt.Color(255, 255, 255));
        MSI_Cont_SinTarjeta.setText("0");

        MSI_Cont_ConTarjeta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MSI_Cont_ConTarjeta.setForeground(new java.awt.Color(255, 255, 255));
        MSI_Cont_ConTarjeta.setText("0");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MSI_Cont_ConTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(MSI_Cont_SinTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel80)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81)
                    .addComponent(MSI_Cont_SinTarjeta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82)
                    .addComponent(MSI_Cont_ConTarjeta))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel55.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("MSI");

        IconMSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/IconMSI (2).png"))); // NOI18N

        javax.swing.GroupLayout MSILayout = new javax.swing.GroupLayout(MSI);
        MSI.setLayout(MSILayout);
        MSILayout.setHorizontalGroup(
            MSILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MSILayout.createSequentialGroup()
                .addGroup(MSILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MSILayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(MSILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MSILayout.createSequentialGroup()
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(MSILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(IconMSI, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MSILayout.createSequentialGroup()
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(MSILayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        MSILayout.setVerticalGroup(
            MSILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MSILayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(MSILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(MSILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MSILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MSILayout.createSequentialGroup()
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(134, 134, 134))
                        .addComponent(IconMSI, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MSILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("MSI", MSI);

        jPanel17.setLayout(null);

        jPanel18.setBackground(new java.awt.Color(51, 51, 51));

        jPanel15.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel16.setBackground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        panelChart.setBackground(new java.awt.Color(204, 204, 204));
        panelChart.setForeground(new java.awt.Color(255, 255, 255));
        panelChart.setLayout(new java.awt.BorderLayout());

        jLabel18.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("GRÁFICO DE GANANCIAS");

        jLabel19.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Apple");

        jLabel20.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("MSI");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap(48, Short.MAX_VALUE)
                        .addComponent(panelChart, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19))
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(jLabel18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelChart, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout GraficoLayout = new javax.swing.GroupLayout(Grafico);
        Grafico.setLayout(GraficoLayout);
        GraficoLayout.setHorizontalGroup(
            GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GraficoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142))
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        GraficoLayout.setVerticalGroup(
            GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GraficoLayout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(58, 58, 58)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(503, 503, 503))
        );

        jTabbedPane1.addTab("Grafico", Grafico);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cont_Ensamblador_MSIStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Cont_Ensamblador_MSIStateChanged
        if(iniciado == true){
            if((int)this.Cont_Ensamblador_MSI.getValue() <= 0){
                this.Cont_Ensamblador_MSI.setValue(1);
                this.repaint();
            }
            else if((int)this.Cont_Placas_MSI.getValue() + (int)this.Cont_CPU_MSI.getValue() + (int)this.Cont_RAM_MSI.getValue() + (int)this.Cont_FuenteA_MSI.getValue() + (int)this.Cont_Ensamblador_MSI.getValue() + (int)this.Cont_Tarjetas_MSI.getValue() > max_msi){
                JOptionPane.showMessageDialog(null,"Número máximo de Empleados Alcanzado!");
                this.Cont_Ensamblador_MSI.setValue((int)this.Cont_Ensamblador_MSI.getValue() - 1);
                this.repaint();
            }
            else{
                int cont = msi.getAssemblers().getlSize();
                int cont2 = (int) Cont_Ensamblador_MSI.getValue();

                if (cont > cont2){
                    while (cont > cont2){
                        msi.removeWorker(5);
                        cont --;
                    }
                }else if (cont < cont2){

                    while (cont < cont2){

                        msi.addWorker(5,1);
                        cont ++;
                    }
                }
            }
        }else{
            this.Cont_Ensamblador_MSI.setValue(1);
            this.repaint();
        }
    }//GEN-LAST:event_Cont_Ensamblador_MSIStateChanged

    private void Cont_Tarjetas_MSIStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Cont_Tarjetas_MSIStateChanged

        if((int)this.Cont_Tarjetas_MSI.getValue() <= 0){
            this.Cont_Tarjetas_MSI.setValue(1);
            this.repaint();
        }
        else if((int)this.Cont_Placas_MSI.getValue() + (int)this.Cont_CPU_MSI.getValue() + (int)this.Cont_RAM_MSI.getValue() + (int)this.Cont_FuenteA_MSI.getValue() + (int)this.Cont_Ensamblador_MSI.getValue() + (int)this.Cont_Tarjetas_MSI.getValue() > max_msi){
            JOptionPane.showMessageDialog(null,"Número máximo de Empleados Alcanzado!");
            this.Cont_Tarjetas_MSI.setValue((int)this.Cont_Tarjetas_MSI.getValue() - 1);
            this.repaint();
        }
        else{
            int cont = msi.getGraphicCardProducers().getlSize();
            int cont2 = (int) Cont_Tarjetas_MSI.getValue();

            if (cont > cont2){
                while (cont > cont2){
                    msi.removeWorker(4);
                    cont --;
                }
            }else if (cont < cont2){

                while (cont < cont2){

                    msi.addWorker(4,1);
                    cont ++;
                }
            }
        }
    }//GEN-LAST:event_Cont_Tarjetas_MSIStateChanged

    private void Cont_FuenteA_MSIStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Cont_FuenteA_MSIStateChanged
        if(iniciado == true){
            if((int)this.Cont_FuenteA_MSI.getValue() <= 0){
                this.Cont_FuenteA_MSI.setValue(1);
                this.repaint();
            }
            else if((int)this.Cont_Placas_MSI.getValue() + (int)this.Cont_CPU_MSI.getValue() + (int)this.Cont_RAM_MSI.getValue() + (int)this.Cont_FuenteA_MSI.getValue() + (int)this.Cont_Ensamblador_MSI.getValue() + (int)this.Cont_Tarjetas_MSI.getValue() > max_msi){
                JOptionPane.showMessageDialog(null,"Número máximo de Empleados Alcanzado!");
                this.Cont_FuenteA_MSI.setValue((int)this.Cont_FuenteA_MSI.getValue() - 1);
                this.repaint();
            }
            else{
                int cont = msi.getPowerSupProducers().getlSize();
                int cont2 = (int) Cont_FuenteA_MSI.getValue();

                if (cont > cont2){
                    while (cont > cont2){
                        msi.removeWorker(3);
                        cont --;
                    }
                }else if (cont < cont2){

                    while (cont < cont2){

                        msi.addWorker(3,1);
                        cont ++;
                    }
                }
            }
        }else{
            this.Cont_FuenteA_MSI.setValue(1);
            this.repaint();
        }
    }//GEN-LAST:event_Cont_FuenteA_MSIStateChanged

    private void Cont_RAM_MSIStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Cont_RAM_MSIStateChanged
        if(iniciado == true){
            if((int)this.Cont_RAM_MSI.getValue() <= 0){
                this.Cont_RAM_MSI.setValue(1);
                this.repaint();
            }
            else if((int)this.Cont_Placas_MSI.getValue() + (int)this.Cont_CPU_MSI.getValue() + (int)this.Cont_RAM_MSI.getValue() + (int)this.Cont_FuenteA_MSI.getValue() + (int)this.Cont_Ensamblador_MSI.getValue() + (int)this.Cont_Tarjetas_MSI.getValue() > max_msi){
                JOptionPane.showMessageDialog(null,"Número máximo de Empleados Alcanzado!");
                this.Cont_RAM_MSI.setValue((int)this.Cont_RAM_MSI.getValue() - 1);
                this.repaint();
            }
            else{
                int cont = msi.getRAMProducers().getlSize();
                int cont2 = (int) Cont_RAM_MSI.getValue();

                if (cont > cont2){
                    while (cont > cont2){
                        msi.removeWorker(2);
                        cont --;
                    }
                }else if (cont < cont2){

                    while (cont < cont2){

                        msi.addWorker(2,1);
                        cont ++;
                    }
                }
            }
        }else{
            this.Cont_RAM_MSI.setValue(1);
            this.repaint();
        }
    }//GEN-LAST:event_Cont_RAM_MSIStateChanged

    private void Cont_CPU_MSIStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Cont_CPU_MSIStateChanged
        if(iniciado == true){
            if((int)this.Cont_CPU_MSI.getValue() <= 0){
                this.Cont_CPU_MSI.setValue(1);
                this.repaint();
            }
            else if((int)this.Cont_Placas_MSI.getValue() + (int)this.Cont_CPU_MSI.getValue() + (int)this.Cont_RAM_MSI.getValue() + (int)this.Cont_FuenteA_MSI.getValue() + (int)this.Cont_Ensamblador_MSI.getValue() + (int)this.Cont_Tarjetas_MSI.getValue() > max_msi){
                JOptionPane.showMessageDialog(null,"Número máximo de Empleados Alcanzado!");
                this.Cont_CPU_MSI.setValue((int)this.Cont_CPU_MSI.getValue() - 1);
                this.repaint();
            }
            else{
                int cont = msi.getCPUProducers().getlSize();
                int cont2 = (int) Cont_CPU_MSI.getValue();

                if (cont > cont2){
                    while (cont > cont2){
                        msi.removeWorker(1);
                        cont --;
                    }
                }else if (cont < cont2){

                    while (cont < cont2){

                        msi.addWorker(1,1);
                        cont ++;
                    }
                }
            }
        }else{
            this.Cont_CPU_MSI.setValue(1);
            this.repaint();
        }
    }//GEN-LAST:event_Cont_CPU_MSIStateChanged

    private void Cont_Placas_MSIStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Cont_Placas_MSIStateChanged
        if(iniciado == true){
            if((int)this.Cont_Placas_MSI.getValue() <= 0){
                this.Cont_Placas_MSI.setValue(1);
                this.repaint();
            }
            else if((int)this.Cont_Placas_MSI.getValue() + (int)this.Cont_CPU_MSI.getValue() + (int)this.Cont_RAM_MSI.getValue() + (int)this.Cont_FuenteA_MSI.getValue() + (int)this.Cont_Ensamblador_MSI.getValue() + (int)this.Cont_Tarjetas_MSI.getValue() > max_msi){
                JOptionPane.showMessageDialog(null,"Número máximo de Empleados Alcanzado!");
                this.Cont_Placas_MSI.setValue((int)this.Cont_Placas_MSI.getValue() - 1);
                this.repaint();
            }
            else{
                int cont = msi.getMotherboardProducers().getlSize();
                int cont2 = (int) Cont_Placas_MSI.getValue();

                if (cont > cont2){
                    while (cont > cont2){
                        msi.removeWorker(0);
                        cont --;
                    }
                }else if (cont < cont2){

                    while (cont < cont2){

                        msi.addWorker(0,1);
                        cont ++;
                    }
                }
            }
        }else{
            this.Cont_Placas_MSI.setValue(1);
            this.repaint();
        }
    }//GEN-LAST:event_Cont_Placas_MSIStateChanged

    private void Cont_Ensamblador_AppleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Cont_Ensamblador_AppleStateChanged
        if(iniciado == true){
            if((int)this.Cont_Ensamblador_Apple.getValue() <= 0){
                this.Cont_Ensamblador_Apple.setValue(1);
                this.repaint();
            }
            else if((int)this.Cont_Placas_Apple.getValue() + (int)this.Cont_CPU_Apple.getValue() + (int)this.Cont_RAM_Apple.getValue() + (int)this.Cont_FuenteA_Apple.getValue() + (int)this.Cont_Ensamblador_Apple.getValue() + (int)this.Cont_Tarjetas_Apple.getValue() > max_apple){
                JOptionPane.showMessageDialog(null,"Número máximo de Empleados Alcanzado!");
                this.Cont_Ensamblador_Apple.setValue((int)this.Cont_Ensamblador_Apple.getValue() - 1);
                this.repaint();
            }
            else{
                int cont = apple.getAssemblers().getlSize();
                int cont2 = (int) Cont_Ensamblador_Apple.getValue();

                if (cont > cont2){
                    while (cont > cont2){
                        apple.removeWorker(5);
                        cont --;
                    }
                }else if (cont < cont2){

                    while (cont < cont2){
                        apple.addWorker(5,1);
                        cont ++;
                    }
                }
            }
        }else{
            this.Cont_Tarjetas_Apple.setValue(1);
            this.repaint();
        }
    }//GEN-LAST:event_Cont_Ensamblador_AppleStateChanged

    private void Cont_Tarjetas_AppleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Cont_Tarjetas_AppleStateChanged
        if(iniciado == true){
            if((int)this.Cont_Tarjetas_Apple.getValue() <= 0){
                this.Cont_Tarjetas_Apple.setValue(1);
                this.repaint();
            }
            else if((int)this.Cont_Placas_Apple.getValue() + (int)this.Cont_CPU_Apple.getValue() + (int)this.Cont_RAM_Apple.getValue() + (int)this.Cont_FuenteA_Apple.getValue() + (int)this.Cont_Ensamblador_Apple.getValue() + (int)this.Cont_Tarjetas_Apple.getValue() > max_apple){
                JOptionPane.showMessageDialog(null,"Número máximo de Empleados Alcanzado!");
                this.Cont_Tarjetas_Apple.setValue((int)this.Cont_Tarjetas_Apple.getValue() - 1);
                this.repaint();
            }
            else{
                int cont = apple.getGraphicCardProducers().getlSize();
                int cont2 = (int) Cont_Tarjetas_Apple.getValue();

                if (cont > cont2){
                    while (cont > cont2){
                        apple.removeWorker(4);
                        cont --;
                    }
                }else if (cont < cont2){

                    while (cont < cont2){

                        apple.addWorker(4,1);
                        cont ++;
                    }
                }
            }
        }else{
            this.Cont_Tarjetas_Apple.setValue(1);
            this.repaint();
        }
    }//GEN-LAST:event_Cont_Tarjetas_AppleStateChanged

    private void Cont_FuenteA_AppleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Cont_FuenteA_AppleStateChanged
        if(iniciado == true){
            if((int)this.Cont_FuenteA_Apple.getValue() <= 0){
                this.Cont_FuenteA_Apple.setValue(1);
                this.repaint();
            }
            else if((int)this.Cont_Placas_Apple.getValue() + (int)this.Cont_CPU_Apple.getValue() + (int)this.Cont_RAM_Apple.getValue() + (int)this.Cont_FuenteA_Apple.getValue() + (int)this.Cont_Ensamblador_Apple.getValue() + (int)this.Cont_Tarjetas_Apple.getValue() > max_apple){
                JOptionPane.showMessageDialog(null,"Número máximo de Empleados Alcanzado!");
                this.Cont_FuenteA_Apple.setValue((int)this.Cont_FuenteA_Apple.getValue() - 1);
                this.repaint();
            }
            else{
                int cont = apple.getPowerSupProducers().getlSize();
                int cont2 = (int) Cont_FuenteA_Apple.getValue();

                if (cont > cont2){
                    while (cont > cont2){
                        apple.removeWorker(3);
                        cont --;
                    }
                }else if (cont < cont2){

                    while (cont < cont2){

                        apple.addWorker(3,1);
                        cont ++;
                    }
                }
            }
        }else{
            this.Cont_FuenteA_Apple.setValue(1);
            this.repaint();
        }
    }//GEN-LAST:event_Cont_FuenteA_AppleStateChanged

    private void Cont_RAM_AppleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Cont_RAM_AppleStateChanged
        if(iniciado == true){
            if((int)this.Cont_RAM_Apple.getValue() <= 0){
                this.Cont_RAM_Apple.setValue(1);
                this.repaint();
            }
            else if((int)this.Cont_Placas_Apple.getValue() + (int)this.Cont_CPU_Apple.getValue() + (int)this.Cont_RAM_Apple.getValue() + (int)this.Cont_FuenteA_Apple.getValue() + (int)this.Cont_Ensamblador_Apple.getValue() + (int)this.Cont_Tarjetas_Apple.getValue() > max_apple){
                JOptionPane.showMessageDialog(null,"Número máximo de Empleados Alcanzado!");
                this.Cont_RAM_Apple.setValue((int)this.Cont_RAM_Apple.getValue() - 1);
                this.repaint();
            }
            else{
                int cont = apple.getRAMProducers().getlSize();
                int cont2 = (int) Cont_RAM_Apple.getValue();

                if (cont > cont2){
                    while (cont > cont2){
                        apple.removeWorker(2);
                        cont --;
                    }
                }else if (cont < cont2){

                    while (cont < cont2){

                        apple.addWorker(2,1);
                        cont ++;
                    }
                }
            }
        }else{
            this.Cont_RAM_Apple.setValue(1);
            this.repaint();
        }
    }//GEN-LAST:event_Cont_RAM_AppleStateChanged

    private void Cont_CPU_AppleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Cont_CPU_AppleStateChanged
        if(iniciado == true){
            if((int)this.Cont_CPU_Apple.getValue() <= 0){
                this.Cont_CPU_Apple.setValue(1);
                this.repaint();
            }
            else if((int)this.Cont_Placas_Apple.getValue() + (int)this.Cont_CPU_Apple.getValue() + (int)this.Cont_RAM_Apple.getValue() + (int)this.Cont_FuenteA_Apple.getValue() + (int)this.Cont_Ensamblador_Apple.getValue() + (int)this.Cont_Tarjetas_Apple.getValue() > max_apple){
                JOptionPane.showMessageDialog(null,"Número máximo de Empleados Alcanzado!");
                this.Cont_CPU_Apple.setValue((int)this.Cont_CPU_Apple.getValue() - 1);
                this.repaint();
            }
            else{
                int cont = apple.getCPUProducers().getlSize();
                int cont2 = (int) Cont_CPU_Apple.getValue();

                if (cont > cont2){
                    while (cont > cont2){
                        apple.removeWorker(1);
                        cont --;
                    }
                }else if (cont < cont2){

                    while (cont < cont2){

                        apple.addWorker(1,1);
                        cont ++;
                    }
                }
            }
        }else{
            this.Cont_CPU_Apple.setValue(1);
            this.repaint();
        }
    }//GEN-LAST:event_Cont_CPU_AppleStateChanged

    private void Cont_Placas_AppleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Cont_Placas_AppleStateChanged
        if(iniciado == true){
            if((int)this.Cont_Placas_Apple.getValue() <= 0){
                this.Cont_Placas_Apple.setValue(1);
                this.repaint();
            }
            else if((int)this.Cont_Placas_Apple.getValue() + (int)this.Cont_CPU_Apple.getValue() + (int)this.Cont_RAM_Apple.getValue() + (int)this.Cont_FuenteA_Apple.getValue() + (int)this.Cont_Ensamblador_Apple.getValue() + (int)this.Cont_Tarjetas_Apple.getValue() > max_apple){
                JOptionPane.showMessageDialog(null,"Número máximo de Empleados Alcanzado!");
                this.Cont_Placas_Apple.setValue((int)this.Cont_Placas_Apple.getValue() - 1);
                this.repaint();
            }
            else{
                int cont = apple.getMotherboardProducers().getlSize();
                int cont2 = (int) Cont_Placas_Apple.getValue();

                if (cont > cont2){
                    while (cont > cont2){
                        apple.removeWorker(0);
                        cont --;
                    }
                }else if (cont < cont2){

                    while (cont < cont2){

                        apple.addWorker(0,1);
                        cont ++;
                    }
                }
            }
        }else{
            this.Cont_Placas_Apple.setValue(1);
            this.repaint();
        }
    }//GEN-LAST:event_Cont_Placas_AppleStateChanged

    private void IniciarSimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarSimulacionActionPerformed
        //se lee el txt
        if (iniciado==false){
            iniciado=true;
            JFileChooser file = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(".TXT","txt");
            file.setFileSelectionMode(JFileChooser.FILES_ONLY);
            file.setFileFilter(filter);
            int selection=file.showOpenDialog(this);

            if(selection==JFileChooser.APPROVE_OPTION) {
                File archive=file.getSelectedFile();
                String path=archive.getAbsolutePath();
                setPath(path);

                if(!path.contains("txt")) {
                    JOptionPane.showMessageDialog(null, "Por favor elija un archivo del tipo txt");
                }
                else {
                    try{
                        File archivo = new File (path);
                        FileReader fr = new FileReader(archivo);
                        BufferedReader br = new BufferedReader(fr);

                        String cadena;
                        String complete="";

                        while ((cadena=br.readLine())!=null) { //lee hasta llegar a null que significa que se acabo el archivo

                            if(!cadena.isEmpty()&& !cadena.isBlank()) { //revisa que la linea no sea vacia/que el tamaño de la cadena sea 0
                                complete+=cadena+"\n";
                            }
                        }

                        fr.close();
                        br.close();
                        complete=complete.trim(); //quita linea en blanco al final
                        //el !"".equals es para verificar que el string no sea solo un espacio en blanco
                        if(!"".equals(complete)) {
                            String[] info;
                            String [] todo=complete.split(";");
                            String [] Dias=todo[0].split("\n");
                            int duracionDias=Integer.parseInt(Dias[1]);
                            if(duracionDias<=0) {
                                throw new Exception("La duracion del dia no puede ser 0");
                            }
                            this.Cont_Day_Duration.setValue(duracionDias);
                            //System.out.println(duracionDias); //todo bien aqui
                            String[] Diasdead=todo[1].split("\n");
                            //System.out.println(Diasdead[1]);
                            int Deadline=Integer.parseInt(Diasdead[2]);
                            if(Deadline<=0) {
                                throw new Exception("El tiempo de entrega no puede ser 0");
                            }
                            this.Cont_Deadline.setValue(Deadline);
                            getApple_Deadline_Counter().setText(Integer.toString(Deadline)); //5
                            getMSI_Deadline_Counter().setText(Integer.toString(Deadline));

                            //ya tengo la duracion del dia y la deadline se crean/agregan las cosas
                            apple.setDayDuration(duracionDias); //3000 milseg, 3 seg
                            msi.setDayDuration(duracionDias);

                            apple.getCompanyStorehouse().setDeadLine(Deadline); //5 days
                            apple.getCompanyStorehouse().setDaysRemaining(Deadline);

                            msi.getCompanyStorehouse().setDeadLine(Deadline);
                            msi.getCompanyStorehouse().setDaysRemaining(Deadline);

                            //Conversion de hora y minutos
                            int hourDuration = (dayDuration/24);
                            int minDuration = hourDuration/60;

                            if(hourDuration == 0){
                                hourDuration = 1;
                            }
                            if(minDuration == 0){
                                minDuration = 1;
                            }

                            ProjectManager appleMan = new ProjectManager(40, duracionDias,this.apple.getMutex(),this.apple.getCompanyStorehouse());
                            Director appleDir = new Director(60,duracionDias,this.apple.getMutex(), this.apple.getCompanyStorehouse(),appleMan);
                            //DirectorWatch appleWatch = new DirectorWatch( this.dayDuration, hourDuration, minDuration, appleDir, Apple_Director_State, this.apple);

                            ProjectManager MsiMan = new ProjectManager(40,duracionDias, this.msi.getMutex(),this.msi.getCompanyStorehouse());
                            Director MsiDir = new Director(60,duracionDias,this.apple.getMutex(), this.msi.getCompanyStorehouse(), MsiMan);
                            //DirectorWatch MsiWatch = new DirectorWatch(this.dayDuration, hourDuration, minDuration, MsiDir, MSI_Director_State,this.msi);

                            //todo2 tiene cosas de cartoon
                            todo[2]=todo[2].trim();
                            String [] infocom1=todo[2].split("-");
                            //todo3 tiene cosas de nick
                            todo[3]=todo[3].trim();
                            String [] infocom2=todo[3].split("-");

                            if (infocom1[0].compareTo("Cartoon")==0) { //el if es porsia
                                //                     System.out.println("jajajaj "+infocom1[0]);
                                //                     System.out.println(infocom1[1]);
                                infocom1[1]=infocom1[1].trim();
                                String [] divTra=infocom1[1].split(":");
                                divTra[1]=divTra[1].trim();
                                String [] trabajadores=divTra[1].split("\n");

                                for (int i = 0; i < trabajadores.length; i++) {
                                    //System.out.println(i+" "+trabajadores[i]);
                                    String [] cantidad=trabajadores[i].split(",");
                                    //cantidad[0] debe tener el nombre del trabajador y el [1] la cantidad de ese tipo
                                    //cuando se vaya a crear el dev le paso i que seria el tipo y cantidad[1] que seria la cantidad
                                    //System.out.println(cantidad[1]);
                                    if(Integer.parseInt(cantidad[1])>0) {
                                        msi.addWorker(i,Integer.parseInt(cantidad[1]));
                                    }else {
                                        throw new Exception("La cantidad de trabajadores no puede ser 0");
                                    }

                                }
                                if(msi.getMotherboardProducers().getlSize()+msi.getCPUProducers().getlSize()+msi.getRAMProducers().getlSize()+msi.getPowerSupProducers().getlSize()+msi.getGraphicCardProducers().getlSize()+msi.getAssemblers().getlSize()>20){
                                    throw new Exception("La cantidad de trabajadores no puede ser 0");
                                }
                                //MsiMan.start();
                                //MsiDir.start();
                                //MsiWatch.start();
                                System.out.println("Listo msi");
                                this.Cont_Placas_MSI.setValue(msi.getMotherboardProducers().getlSize());
                                this.Cont_CPU_MSI.setValue(msi.getCPUProducers().getlSize());
                                this.Cont_RAM_MSI.setValue(msi.getRAMProducers().getlSize());
                                this.Cont_FuenteA_MSI.setValue(msi.getPowerSupProducers().getlSize());
                                this.Cont_Tarjetas_MSI.setValue(msi.getGraphicCardProducers().getlSize());
                                this.Cont_Ensamblador_MSI.setValue(msi.getAssemblers().getlSize());

                            }
                            else if (infocom1[0].compareTo("Nick")==0) {
                                infocom1[1]=infocom1[1].trim();
                                String [] divTra=infocom1[1].split(":");
                                divTra[1]=divTra[1].trim();
                                String [] trabajadores=divTra[1].split("\n");

                                for (int i = 0; i < trabajadores.length; i++) {
                                    //System.out.println(i+" "+trabajadores[i]);
                                    String [] cantidad=trabajadores[i].split(",");
                                    //cantidad[0] debe tener el nombre del trabajador y el [1] la cantidad de ese tipo
                                    //cuando se vaya a crear el dev le paso i que seria el tipo y cantidad[1] que seria la cantidad
                                    //System.out.println(cantidad[1]);
                                    if(Integer.parseInt(cantidad[1])>0) {
                                        apple.addWorker(i,Integer.parseInt(cantidad[1]));
                                    } else {
                                        throw new Exception("La cantidad de trabajadores no puede ser 0");
                                    }

                                }
                                //appleMan.start();
                                //appleDir.start();
                                //appleWatch.start();
                                this.Cont_Placas_Apple.setValue(apple.getMotherboardProducers().getlSize());
                                this.Cont_CPU_Apple.setValue(apple.getCPUProducers().getlSize());
                                this.Cont_RAM_Apple.setValue(apple.getRAMProducers().getlSize());
                                this.Cont_FuenteA_Apple.setValue(apple.getPowerSupProducers().getlSize());
                                this.Cont_Tarjetas_Apple.setValue(apple.getGraphicCardProducers().getlSize());
                                this.Cont_Ensamblador_Apple.setValue(apple.getAssemblers().getlSize());

                            }

                            if (infocom2[0].compareTo("Cartoon")==0) {
                                //                     System.out.println("jejejeje "+infocom2[0]);
                                //                     System.out.println(infocom2[1]);
                                infocom1[1]=infocom1[1].trim();
                                String [] divTra=infocom1[1].split(":");
                                divTra[1]=divTra[1].trim();
                                String [] trabajadores=divTra[1].split("\n");

                                for (int i = 0; i < trabajadores.length; i++) {
                                    //System.out.println(i+" "+trabajadores[i]);
                                    String [] cantidad=trabajadores[i].split(",");
                                    //cantidad[0] debe tener el nombre del trabajador y el [1] la cantidad de ese tipo
                                    //cuando se vaya a crear el dev le paso i que seria el tipo y cantidad[1] que seria la cantidad
                                    //System.out.println(cantidad[1]);
                                    if(Integer.parseInt(cantidad[1])>0) {
                                        msi.addWorker(i,Integer.parseInt(cantidad[1]));
                                    }else {
                                        throw new Exception("La cantidad de trabajadores no puede ser 0");
                                    }

                                }

                                //MsiMan.start();
                                //MsiDir.start();
                                //MsiWatch.start();
                                this.Cont_Placas_MSI.setValue(msi.getMotherboardProducers().getlSize());
                                this.Cont_CPU_MSI.setValue(msi.getCPUProducers().getlSize());
                                this.Cont_RAM_MSI.setValue(msi.getRAMProducers().getlSize());
                                this.Cont_FuenteA_MSI.setValue(msi.getPowerSupProducers().getlSize());
                                this.Cont_Tarjetas_MSI.setValue(msi.getGraphicCardProducers().getlSize());
                                this.Cont_Ensamblador_MSI.setValue(msi.getAssemblers().getlSize());
                            }
                            else if (infocom2[0].compareTo("Nick")==0) {
                                String [] divTra=infocom2[1].split(":");
                                divTra[1]=divTra[1].trim();
                                String [] trabajadores=divTra[1].split("\n");
                                System.out.println(infocom2[0]);
                                for (int i = 0; i < trabajadores.length; i++) {
                                    //System.out.println(i+" "+trabajadores[i]);
                                    String [] cantidad=trabajadores[i].split(",");
                                    //cantidad[0] debe tener el nombre del trabajador y el [1] la cantidad de ese tipo
                                    //cuando se vaya a crear el dev le paso i que seria el tipo y cantidad[1] que seria la cantidad
                                    //System.out.println(cantidad[1]);
                                    if(Integer.parseInt(cantidad[1])>0) {
                                        apple.addWorker(i,Integer.parseInt(cantidad[1]));
                                    }else {
                                        throw new Exception("La cantidad de trabajadores no puede ser 0");
                                    }

                                }
                                if(apple.getMotherboardProducers().getlSize()+apple.getCPUProducers().getlSize()+apple.getRAMProducers().getlSize()+apple.getPowerSupProducers().getlSize()+apple.getGraphicCardProducers().getlSize()+apple.getAssemblers().getlSize()>18){
                                    throw new Exception("La cantidad de trabajadores no puede ser 0");
                                }
                                //appleMan.start();
                                //appleDir.start();
                                //appleWatch.start();
                                this.Cont_Placas_Apple.setValue(apple.getMotherboardProducers().getlSize());
                                this.Cont_CPU_Apple.setValue(apple.getCPUProducers().getlSize());
                                this.Cont_RAM_Apple.setValue(apple.getRAMProducers().getlSize());
                                this.Cont_FuenteA_Apple.setValue(apple.getPowerSupProducers().getlSize());
                                this.Cont_Tarjetas_Apple.setValue(apple.getGraphicCardProducers().getlSize());
                                this.Cont_Ensamblador_Apple.setValue(apple.getAssemblers().getlSize());

                                System.out.println("Listo Apple");

                            }

                            appleMan.start();
                            appleDir.start();
                            //appleWatch.start();
                            MsiMan.start();
                            MsiDir.start();
                            //MsiWatch.start();

                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erorr!!!! Asegurate de haber cargado el archivo correcto");
                        System.exit(0);
                    }
                }

                GlobalUI.addMSI(0, 0);
                GlobalUI.addApple(0, 0);
                GlobalUI.addSeries(GlobalUI.getMSI());
                GlobalUI.addSeries(GlobalUI.getApple());

                JFreeChart chart = ChartFactory.createXYLineChart("Utilidad vs Tiempo", "Utilidad (Millones $)", "Tiempo (Días)", GlobalUI.dataset, PlotOrientation.HORIZONTAL, false, true, false);

                final XYPlot plot = chart.getXYPlot( );

                ChartPanel barPanel = new ChartPanel(chart);

                XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
                renderer.setSeriesPaint( 0 , Color.RED );
                renderer.setSeriesPaint( 1 , Color.BLUE);
                renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
                renderer.setSeriesStroke( 1 , new BasicStroke( 4.0f ) );
                plot.setRenderer( renderer );

                panelChart.removeAll();
                panelChart.add(barPanel);
                panelChart.validate();

            }else {
                JOptionPane.showMessageDialog(null, "ERROR");
                System.exit(0);
            }
        } else{
            JOptionPane.showMessageDialog(null, "La simulacion ya ha iniciado");
        }

    }//GEN-LAST:event_IniciarSimulacionActionPerformed

    private void Cont_Day_DurationStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Cont_Day_DurationStateChanged
        if(iniciado == true){
            if((int)this.Cont_Day_Duration.getValue() <= 0){
                this.Cont_Day_Duration.setValue(1);
                this.repaint();
            }
        }else{
            this.Cont_Day_Duration.setValue(1);
            this.repaint();
        }

    }//GEN-LAST:event_Cont_Day_DurationStateChanged


    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Almacen_CPU_Apple;
    private javax.swing.JLabel Almacen_CPU_MSI;
    private javax.swing.JLabel Almacen_FuenteA_Apple;
    private javax.swing.JLabel Almacen_FuenteA_MSI;
    private javax.swing.JLabel Almacen_Placas_Apple;
    private javax.swing.JLabel Almacen_Placas_MSI;
    private javax.swing.JLabel Almacen_RAM_Apple;
    private javax.swing.JLabel Almacen_RAM_MSI;
    private javax.swing.JLabel Almacen_Tarjetas_Apple;
    private javax.swing.JLabel Almacen_Tarjetas_MSI;
    private javax.swing.JPanel Apple;
    private javax.swing.JLabel AppleIcon;
    private javax.swing.JLabel Apple_Cont_ConTarjeta;
    private javax.swing.JLabel Apple_Cont_SinTarjeta;
    private static javax.swing.JLabel Apple_Deadline_Counter;
    private static javax.swing.JLabel Apple_Director_State;
    private static javax.swing.JLabel Apple_Discount_Counter;
    private static javax.swing.JLabel Apple_Fail_Counter;
    private static javax.swing.JLabel Apple_Gain_Counter;
    private static javax.swing.JLabel Apple_Loss_Counter;
    private static javax.swing.JLabel Apple_Pm_State;
    private static javax.swing.JLabel Apple_Utility_Counter;
    private javax.swing.JSpinner Cont_CPU_Apple;
    private javax.swing.JSpinner Cont_CPU_MSI;
    private javax.swing.JSpinner Cont_Day_Duration;
    private javax.swing.JSpinner Cont_Deadline;
    private javax.swing.JSpinner Cont_Ensamblador_Apple;
    private javax.swing.JSpinner Cont_Ensamblador_MSI;
    private javax.swing.JSpinner Cont_FuenteA_Apple;
    private javax.swing.JSpinner Cont_FuenteA_MSI;
    private javax.swing.JSpinner Cont_Placas_Apple;
    private javax.swing.JSpinner Cont_Placas_MSI;
    private javax.swing.JSpinner Cont_RAM_Apple;
    private javax.swing.JSpinner Cont_RAM_MSI;
    private javax.swing.JSpinner Cont_Tarjetas_Apple;
    private javax.swing.JSpinner Cont_Tarjetas_MSI;
    private javax.swing.JLabel Cont_Trabajadores_Apple;
    private javax.swing.JLabel Cont_Trabajadores_MSI;
    private javax.swing.JPanel Grafico;
    private javax.swing.JLabel IconMSI;
    private javax.swing.JButton IniciarSimulacion;
    private javax.swing.JPanel Inicio;
    private javax.swing.JLabel LogoApple;
    private javax.swing.JLabel LogoMSI;
    private javax.swing.JPanel MSI;
    private javax.swing.JLabel MSI_Cont_ConTarjeta;
    private javax.swing.JLabel MSI_Cont_SinTarjeta;
    private static javax.swing.JLabel MSI_Deadline_Counter;
    private static javax.swing.JLabel MSI_Director_State;
    private static javax.swing.JLabel MSI_Discount_Counter;
    private static javax.swing.JLabel MSI_Fail_Counter;
    private static javax.swing.JLabel MSI_Gain_Counter;
    private static javax.swing.JLabel MSI_Loss_Counter;
    private static javax.swing.JLabel MSI_Pm_State;
    private static javax.swing.JLabel MSI_Utility_Counter;
    private javax.swing.JButton SaveButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panelChart;
    // End of variables declaration//GEN-END:variables
}
