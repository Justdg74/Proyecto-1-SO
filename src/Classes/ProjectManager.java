/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author alexi
 */
public class ProjectManager extends Thread{
    private int salary;
    private int dayDuration;
    private int hourDuration;
    private int minDuration;
    private  Storehouse storehouse;
    private Semaphore mutex;
    private String currentState;
    private JLabel label;
    
    
    public ProjectManager(int day, int hour, int min ,Storehouse storehouse, Semaphore m, JLabel label) {
        this.salary = 40;
        this.dayDuration = day;
        this.hourDuration = hour;
        this.minDuration = min;
        this.storehouse = storehouse;
        this.mutex = m;
        this.currentState = "Trabajando";
        this.label = label;
    }
    
    @Override
    public void run(){
        while(true){
            try{
                //Al iniciar el dia, inicia su rutina de trabajar y alternar viendo anime
                susTime();                
                /*Segun el tiempo que pasa viendo anime, espera el resto para el siguiente dia y baja en 1 el contador
                de dias restantes*/
                if (((this.hourDuration/2)*32) + (this.hourDuration*8) < this.dayDuration){
                    sleep((this.hourDuration*8) + (this.dayDuration - (((this.hourDuration/2)*32) + (this.hourDuration*8))));
                    this.mutex.acquire(1);
                    countDay();
                    this.mutex.release();
                }else{
                    sleep(this.hourDuration*8);
                    this.mutex.acquire(1);
                    countDay();
                    this.mutex.release();
                }
                
                
                
                
            }catch (InterruptedException ex){
                System.out.println(ex);
                        }
        }
    }
    
    
     public void susTime() {
        for (int i = 1; i <= 16; i++){
            try {
                this.currentState = "Viendo Anime";
                this.label.setText(this.currentState);
                sleep(this.hourDuration/2);  
                
                 
                this.currentState = "Trabajando";
                this.label.setText(this.currentState);
                sleep(this.hourDuration/2);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
                }
}
     
      public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }
    
    public void countDay(){
        this.storehouse.setDaysRemaining(this.storehouse.getDaysRemaining() - 1);
        this.storehouse.addSalary(salary);
        daysPassed();
    }
    
    public void daysPassed(){
        this.storehouse.addDayspassed();
    }

}
