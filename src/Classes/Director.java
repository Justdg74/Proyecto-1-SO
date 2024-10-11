/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Dashboards.Dashboard;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
import javax.swing.JLabel;

/**
 *
 * @author diego
 */
public class Director extends Thread {
    private int sueldoph; //Sueldo por Hora del Director
    private Semaphore mutex; // Semáforo
    private int dayDuration; //Duración del día
    private float salarioAcc = 0; // Salario acumulado
    private Storehouse storehouse; //El Almacen común de toda la compañía, necesario para el contador de días
    private String estado; // Qué esta haciendo
    private int horaAleatoria; //La hora aleatoria para revisar al PM
    private double horas; //Conversión del día completo en horas
    private ProjectManager pm;
    
     public Director(int sueldoph, int dayDuration, Semaphore mutex, Storehouse storehouse, ProjectManager pm){
        this.sueldoph = sueldoph;
        this.dayDuration = dayDuration;
        this.mutex = mutex;
        this.storehouse = storehouse;
        this.estado = "Trabajando";
        this.horaAleatoria = 0;
        this.horas = this.dayDuration/24;
        this.pm = pm;
    }
    
     public int getSueldoph(){
        return sueldoph;
    }
    
    public void setSueldoph(int sueldoph){
        this.sueldoph = sueldoph;
    }
    
    public Semaphore getMutex(){
        return mutex;
    }
    
    public void setMutex(Semaphore mutex){
        this.mutex = mutex;
    }
    
    public int getDayDuration(){
        return dayDuration;
    }
    
    public void setDayDuration(int dayDuration){
        this.dayDuration = dayDuration;
    }
    
    public float getSalarioAcc(){
        return salarioAcc;
    }
    
    public void setSalarioAcc(float salarioAcc){
        this.salarioAcc = salarioAcc;
    }
    
    public Storehouse getStorehouse(){
        return storehouse;
    }
    
    public void setDrive(Storehouse drive){
        this.storehouse = drive;
    }
    
    public String getEstado(){
        return estado;
    }
    
    public void setEstado(String estado){
        this.estado = estado;
    }
    
    public int getHoraAleatoria(){
        return horaAleatoria;
    }
    
    public void setHoraAleatoria(int horaAleatoria){
        this.horaAleatoria = horaAleatoria;
    }
    
    public double getHoras(){
        return horas;
    }
    
    public void setHoras(int horas){
        this.horas = horas;
    }
    
    public ProjectManager getProjectManager(){
        return pm;
    }
    
    public void setProjectManager(ProjectManager pm){
        this.pm = pm;
    }
    
   @Override
   public void run(){
        while(true){
     
            if(this.storehouse.getDaysRemaining() <= 0){
                try{
                    this.estado = "Entregando computadoras";
                    changeStateText(); 
                    sleep(this.dayDuration);      
                    this.mutex.acquire(); // Wait, empieza la parte crítica
                    
                    this.storehouse.setDaysRemaining(this.storehouse.getDeadLine());//Reinicia los días requeridos
                    Dashboard.getApple_Deadline_Counter().setText(Integer.toString(this.storehouse.getDaysRemaining()));
                    Dashboard.getMSI_Deadline_Counter().setText(Integer.toString(this.storehouse.getDaysRemaining()));
                   
                    if(this.storehouse.getStandardComputers() <= 0 && this.storehouse.getGraphicCardComputers() <= 0){
                        System.out.println("NO SE ENTREGO NINGUNA COMPUTADORA");
                    }else{
                        if(this.storehouse.getStandardComputers() > 0){
                        this.storehouse.calcularGananciaS(this.storehouse.getStandardComputers());
                        this.storehouse.setStandardComputers(0);
                      
                        
                    }
                        if(this.storehouse.getGraphicCardComputers() > 0){
                            this.storehouse.calcularGananciaGC(this.storehouse.getStandardComputers());
                            this.storehouse.setGraphicCardComputers(0);
                          
                        }
                    }                 
                                        
                    this.mutex.release(); //Signal, termina la parte crítica
                }catch(InterruptedException ex){
                        Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("error en director en run cuando entrega "+this.storehouse.getCompany());
                }                
            }else if(this.storehouse.getDaysRemaining()>0) {
               
                //Acá abajo está todo el código de el director cuando NO esta entregando computadoras
                Random random = new Random();
                while((this.horaAleatoria=random.nextInt(24))==0) {
                    this.horaAleatoria=random.nextInt(24);
                }
                //horaAleatoria = 16;
              
                //Aquí van a pasar las 24 horas
                for(int i = 1; i <= 24; i++){
                    try{                        
                        //System.out.println(this.estado);
                        this.estado = "Trabajando";
                        changeStateText();
                        //System.out.println("Estado: "+this.estado);
                        if(i == this.horaAleatoria){
                            //System.out.println(i+" numero "+"hora aleatoria: "+this.horaAleatoria);
                            this.estado = "Revisando al Project Manager";
                            changeStateText();
                            if(this.horaAleatoria <=16){
                                                           
                            }
                            mutex.acquire();
                            
                            boolean continuar=checkPm();
                            //System.out.println(pm.getEstado()+" el pm esta");
                            if(!continuar){
                            sleep((long) (this.horas/(60/17)));
                           
                            continuar=checkPm();
                            //System.out.println(pm.getEstado()+" el pm esta");
                            }
                            if(!continuar) {
                            sleep((long) (this.horas/(60/17)));
                            
                            checkPm();
                            }
                            mutex.release();
                            
                            
                        }
                        //System.out.println("horaaa "+this.horas);
                        sleep((long) (this.horas/(12/7))); //Se llevan los 35 minutos que se requieren
                    }catch(InterruptedException ex){
                        Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("error en director en run cuando no entrega "+this.storehouse.getCompany());
                    }
                }                
            }            
            obtenerSalario();            
        }
    }
   
    public void changeStateText(){
        if(this.storehouse.getCompany().compareTo("Apple") == 0){
            Dashboard.getApple_Director_State().setText(this.estado);
        }else{
            Dashboard.getMSI_Director_State().setText(this.estado);
        }        
    }  
        
    public void obtenerSalario() {
        try{
            this.mutex.acquire();
            this.storehouse.setCosts(this.storehouse.getCosts()+this.sueldoph*24); //al costo le sumo lo que gano el empleado ese dia            
            this.mutex.release();
            this.salarioAcc+=this.sueldoph*24;
            
        }catch(InterruptedException ex) {
                Logger.getLogger(Workers.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error!!! del Director en obtenerSalario ");
        }
            
    }
    
    public void changeFailText(){
        if(this.storehouse.getCompany().compareTo("Apple") == 0){
//            System.out.println("Atrapado el de Apple");
            Dashboard.getApple_Fail_Counter().setText(Integer.toString(this.getProjectManager().getFaltas()));
            Dashboard.getApple_Discount_Counter().setText(Integer.toString(this.getProjectManager().getDineroDescontado()) +"$");
        }else{
//            System.out.println("Atrapado el de MSI!");
            Dashboard.getMSI_Fail_Counter().setText(Integer.toString(this.getProjectManager().getFaltas()));
            Dashboard.getMSI_Discount_Counter().setText(Integer.toString(this.getProjectManager().getDineroDescontado()) +"$");
        }     
    }
    
    public boolean checkPm(){
        if(this.getProjectManager().getEstado().equals("Viendo One Piece")){
                
                this.getProjectManager().setFaltas(this.getProjectManager().getFaltas() + 1);
                this.getProjectManager().setDineroDescontado(this.getProjectManager().getDineroDescontado() + 100);
                this.getProjectManager().setSalarioacc(this.getProjectManager().getSalarioacc() - 100);
                changeFailText();
                return true;
        } else{
            return false;
        
        }
    }
}
