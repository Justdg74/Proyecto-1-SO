/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author alexi
 */

/**
     * Clase de todos los trabajadores
     * 
     * En esta clase estan las funciones para: medir el desempenio de los trabajadores (run), produccion en el tiempo en dias 
     * (configureWorkerByCompany, y guardar en el almacen los componentes terminados.
     */

public class Workers extends Thread {
    private double earnings;
    private double hourlyRate;
    private double dailyOutput;
    private double accumulatedOutput;
    private String workType;
    private boolean isActive = true;
    private String company; // Capcom or SquareEnix
    private int dayDuration;
    private Storehouse storehouse;
    private Semaphore mutex;
    public Workers(String workType, String company, int day, Storehouse storehouse, Semaphore m){
        this.workType = workType;
        this.company = company;
        this.earnings = 0;
        this.accumulatedOutput = 0;
        this.configureWorkerByComponent();
        this.dayDuration = day;
        this.storehouse = storehouse;
        this.mutex = m;
    }
    
     @Override
    public void run() {
        while (this.isActive) {
            try {
                
                this.produceComputerComponent();
                this.mutex.acquire();
                this.storehouse.addSalary(hourlyRate);
                this.mutex.release();
                sleep(this.dayDuration); 
            } catch (InterruptedException ex) {
                System.out.println("Error in developer thread.");
            }
        }
        
    }

    /**
     * Funcion para la construccion de los trabajadores
     * 
     * Segun su compañia y su tipo, determina su salario y produccion por dia
     */
    private void configureWorkerByComponent() {
        if (this.company.equals("Apple")) {
            switch (this.workType) {
                case "MotherboardProduction":
                    this.hourlyRate = 20;
                    this.dailyOutput = 1.0/3; // 1 placa base cada 3 días
                    break;
                case "CPUProduction":
                    this.hourlyRate = 26;
                    this.dailyOutput = 1.0/3; // 1 CPU cada 3 días
                    break;
                case "RAMProduction":
                    this.hourlyRate = 40;
                    this.dailyOutput = 2; // 2 RAM cada día
                    break;
                case "PowerSupplyProduction":
                    this.hourlyRate = 16;
                    this.dailyOutput = 5; // 5 fuentes de alimentacion cada día
                    break;
                case "GraphicCardProduction":
                    this.hourlyRate = 34;
                    this.dailyOutput = 0.5; // 1 Tarjeta cada 2 días
                    break;
                case "Assembler":
                    this.hourlyRate = 50;
                    this.dailyOutput = 0.5; // 1 computador cada 2 días
                    break;
                default:
                    // Manejo de componentes no definidos
                    break;
            }
        } else if (this.company.equals("MSI")) {
            switch (this.workType) {
                case "MotherboardProduction":
                    this.hourlyRate = 20;
                    this.dailyOutput = 0.25; // 1 placa cada 4 días
                    break;
                case "CPUProduction":
                    this.hourlyRate = 26;
                    this.dailyOutput = 0.25; // 1 CPU cada 4 días
                    break;
                case "RAMProduction":
                    this.hourlyRate = 40;
                    this.dailyOutput = 1; // 1 RAM cada día
                    break;
                case "PowerSupplyProduction":
                    this.hourlyRate = 16;
                    this.dailyOutput = 5; // 5 fuentes de alimentacion cada día
                    break;
                case "GraphicCardProduction":
                    this.hourlyRate = 34;
                    this.dailyOutput = 0.5; // 1 Tarjeta Grafica cada 2 días
                    break;
                case "Assembler":
                    this.hourlyRate = 50;
                    this.dailyOutput = 0.5; // 1 computador cada 2 días
                    break;
                default:
                    // Manejo de componentes no definidos
                    break;
            }
        }
    }
    
    
    /**
     * Trabajo de los desarrolladores
 
 Cada dia suman a su acumulado
 
 Si el acumulado es 1 o mas lo cargan al storehouse y reinician su acumulado
     */
    public void produceComputerComponent() {
        this.accumulatedOutput += this.dailyOutput;
        if(this.accumulatedOutput >= 1){
            try {
                int roundAcc = (int) Math.floor(this.accumulatedOutput);
                this.mutex.acquire(1);
                this.storehouse.addToStorehouse(roundAcc, this.workType);
                this.mutex.release();
                this.accumulatedOutput = 0;
            } catch (InterruptedException ex) {
                Logger.getLogger(Workers.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public double getEarnings() {
        return earnings;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getDailyOutput() {
        return dailyOutput;
    }

    public double getAccumulatedOutput() {
        return accumulatedOutput;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean b){
        this.isActive = b;
    }

    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setDailyOutput(double dailyOutput) {
        this.dailyOutput = dailyOutput;
    }

    public void setAccumulatedOutput(double accumulatedOutput) {
        this.accumulatedOutput = accumulatedOutput;
    }


    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
        this.configureWorkerByComponent(); // Reconfigure based on the new company
    }
    
    public String getWorkType() {
        return this.workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
        configureWorkerByComponent(); //  llamar a este método aquí para reconfigurar automáticamente al desarrollador cuando cambies su componente.
    }
}
