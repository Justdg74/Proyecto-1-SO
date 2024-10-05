/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
import javax.swing.JLabel;

/**
 *
 * @author alexi
 */
public class Director {
    private Storehouse storehouse;
    private Semaphore mutex;
    private ProjectManager pm;
    private boolean paused;
    private int minuteDuration;
    private boolean wasLazy;
    private int pmPenalties;
    private JLabel label;
    private JLabel faultLabel;
    
    public Director(Storehouse storehouse, Semaphore m, ProjectManager proj, int min, JLabel label, JLabel fault){
        this.storehouse = storehouse;
        this.mutex = m;
        this.pm = proj;
        this.minuteDuration = min;
        this.paused = false;
        this.wasLazy = false;
        this.pmPenalties = 0;
        this.label = label;
        this.faultLabel = fault;
    }
    
    @Override
    public void run(){
        try {
            //Se toman pausas cortas entre ejecucion
            sleep(10);
            while(true){
                //Si ya es la hora de revisar el project manager, el condicional sera cierto y se ejecuta el codigo correspondiente
                if(!this.paused){
                    
                    //Si el pm no esta trabajando y aun no se le ha colocado una falta, se procede a colocarle una falta
                    if(!"Trabajando".equals(this.pm.getCurrentState()) && !this.wasLazy){
                        this.mutex.acquire(1);
                        faultPM();
                        this.mutex.release();
                    }
                    
                sleep(5);
                    
                    
                }else{
                    try {
                        sleep(this.minuteDuration);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
               } catch (InterruptedException ex) {
            Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }
    
     public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public boolean isWasLazy() {
        return wasLazy;
    }

    public void setWasLazy(boolean wasLazy) {
        this.wasLazy = wasLazy;
    }

    public int getPmPenalties() {
        return pmPenalties;
    }

    public void setPmPenalties(int pmPenalties) {
        this.pmPenalties = pmPenalties;
    }
 
    /**
     * Funcion para registrar fallas del pm
     */
    public void faultPM(){
        /**
         * Se modifica el booleano que indica que ya se penalizo al pm
         * Aumentan en 1 las penalizaciones para este deadline y se reduce su salario en 100
         */
        this.wasLazy = true;
        this.pmPenalties += 1;
        this.label.setText(Integer.toString(this.pmPenalties));
        this.faultLabel.setText(Integer.toString(this.pmPenalties*100));
        this.storehouse.setSalary(this.storehouse.getSalary() - (100/1000));
    }

    public JLabel getFaultLabel() {
        return faultLabel;
    }

    public void setFaultLabel(JLabel faultLabel) {
        this.faultLabel = faultLabel;
    }
    
}
