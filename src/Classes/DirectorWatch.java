/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;


import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;


/**
 *
 * @author digio
 */
public class DirectorWatch {
    
    private int salary;
    private int dayDuration;
    private int hourDuration;
    private int minuteDuration;
    private Director dir;
    private Storehouse storehouse;
    private JLabel label;
   private Company company;
    private Semaphore mutex;
    
    public DirectorWatch(int day, int hora, int min, Director dir, JLabel label, Company comp){
    this.salary = 60;
    this.dayDuration = day;
    this.dir = dir;
    this.hourDuration = hora;
    this.minuteDuration = min;
    this.label = label;
    this.company = comp;
    this.storehouse = this.company.getCompanyStorehouse();
    this.mutex = this.company.getMutex();
    }
    
    public void run(){
        /**
         * Ejecucion del director, si no hay 0 dias restantes, revisa al pm en una hora aleatoria cambiando el booleano de
         * activacion para el thread que ejecuta las reviciones
         * al final de los 25 minutos de la revision, cambia el booleano para desactivar al thread de revision
         * 
         * Si hay 0 dias restantes, procede a vender los juegos
         */
        System.out.println(this.minuteDuration);
        while(true){
            try {
                
                if(storehouse.getDaysRemaining() > 0){
                
                    int randomHour = randHour();
                    int upperWait = this.hourDuration * randomHour;
                    int lowerWait = this.hourDuration * (24 - randomHour - 1);

                    for(int i = 0; i < 3; i++){
                        switch (i){

                            case 0:
                                this.dir.setPaused(true);
                                this.label.setText("Labores administrativas");
                                sleep(upperWait);
                                break;

                            case 1:
                                this.dir.setPaused(false);
                                this.label.setText("Revisando al PM");
                                sleep(this.minuteDuration * 35);
                                break;

                            case 2:
                                this.dir.setPaused(true);
                                this.label.setText("Labores administrativas");
                                this.dir.setWasLazy(false);
                                sleep(this.dayDuration - ((this.minuteDuration*35) + upperWait));
                        }
                    }
                    
                    this.mutex.acquire(1);
                    this.storehouse.addSalary(salary);
                    this.mutex.release();
            
                }else{
                    this.mutex.acquire(1);
                    this.sellComputer();
                    this.mutex.release();
                }
            
            } catch (InterruptedException ex) {
                Logger.getLogger(DirectorWatch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    
    }
    
    /**
     * Funcion de hora aleatoria
     * @return 
     */
    public int randHour(){
        Random random = new Random();
        return random.nextInt(24 - 1) + 1;
    }
    
    /**
     * Funcion de venta de computadoras
     * 
     * Se revisa de que compañia se trata para determinar la ganancia por computadora
     * 
     * Luego se calcula la ganancia segun las ventas, se añade el salario del director para este dia
     * se carga el salario acumulado en el drive para este deadline, se calculan las utilidades.
     * 
     * Despues se reinicia el salario para este deadline, la cantidad de computadoras con y sin tarjeta grafica
     * la cantidad de dias restantes y las faltas del pm
     */
    
    public void sellComputer(){
        if(this.company.getCompanyName().equals("Apple")){
            this.company.addIncome((this.storehouse.getStandardComputers()* 100000) + (this.storehouse.getGraphicCardComputers() * 150000));       
        }else{
            this.company.addIncome((this.storehouse.getStandardComputers() * 180000) + (this.storehouse.getGraphicCardComputers() * 250000));
        }
        
        this.storehouse.addSalary(this.salary);
        this.company.addSalary(this.storehouse.getSalary());
        this.company.setUtilities(this.company.getIncome() - this.company.getSalary());
        this.storehouse.setSalary(0);
        this.storehouse.setStandardComputers(0);
        this.storehouse.setGraphicCardComputers(0);
        this.storehouse.setDaysRemaining(this.storehouse.getDeadLine());
        System.out.println(this.storehouse.getDeadLine());
        System.out.println(this.storehouse.getDaysRemaining());
        this.dir.setPmPenalties(0);
        this.dir.getFaultLabel().setText(Integer.toString(this.dir.getPmPenalties()));
        
    }
    
    
    
}
