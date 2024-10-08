/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.concurrent.Semaphore;
import javax.swing.JLabel;

/**
 *
 * @author alexi
 */
public class Assemblers extends Thread{
    private Storehouse storehouse;
    private Semaphore mutex;
    private double salary = 50;
    private boolean isActive = true;
    private int dayDuration;

    public Assemblers(Storehouse storehouse, Semaphore m, int day) {
        this.storehouse = storehouse;
        this.mutex = m;
        this.dayDuration = day;
    }
    
    @Override
    public void run() {
        while (isActive) {
            try {
                // Verificar si hay suficientes componentes para ensamblar una computadora
                this.mutex.acquire(1);
                if (this.storehouse.canAssembleComputer()) { //Si todos los componentes pasan sus requerimientos de produccion para ensamblar

                    // Consumir componentes
                    storehouse.assembleComputer();
                    this.storehouse.addSalary(this.salary);
                    this.mutex.release();
                    // Dormir durante el tiempo necesario para el ensamblaje
                    // (Aquí dormimos por un tiempo corto. Ajustar según sea necesario.)
                    sleep(this.dayDuration*2);

                    // Agregar el computador ensamblado al almacen
                    

                } else {
                    this.storehouse.addSalary((this.salary));
                    this.mutex.release();
                    sleep(this.dayDuration);
                }
                
            } catch (InterruptedException e) {
                System.out.println("Ensamblador interrumpido.");
            }
        }
    }


    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Storehouse getStorehouse() {
        return storehouse;
    }

    public void setStorehouse(Storehouse storehouse) {
        this.storehouse = storehouse;
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDayDuration() {
        return dayDuration;
    }

    public void setDayDuration(int dayDuration) {
        this.dayDuration = dayDuration;
    }

    
    
}
