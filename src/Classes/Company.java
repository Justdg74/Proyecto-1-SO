/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.concurrent.Semaphore;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author alexi
 */
public class Company {
    private String companyName;
    
    private LinkedList motherboardProducers;
    private LinkedList CPUProducers;
    private LinkedList RAMProducers;
    private LinkedList powerSupProducers;
    private LinkedList graphicCardProducers;
    private LinkedList assemblers;
    
    //private ProjectManager pm;
    //private Director dir;
    //private DirectorWatch dirWatch;
    
    private Semaphore mutex;
    private Storehouse companyStorehouse;
    
    private double income;
    private double salary;
    private double utilities;
    
    private int dayDuration;
    private int hourDuration;
    private int minDuration;
    
    private JLabel[] labels;
    
    private int maxWorkers;
    
    public Company(int maxWorkers, String company){
        this.mutex = new Semaphore(1);
        this.companyStorehouse = new Storehouse(company);
 
        this.motherboardProducers = new LinkedList();
        this.CPUProducers = new LinkedList();
        this.RAMProducers = new LinkedList();
        this.powerSupProducers = new LinkedList();
        this.graphicCardProducers = new LinkedList();
        this.assemblers = new LinkedList();
               
        this.utilities = 0;
        this.income = 0;
        this.salary = 0;
        
        this.maxWorkers = maxWorkers;
        
        this.companyName = company;
        
        
    }

    public int getMaxWorkers() {
        return maxWorkers;
    }

    public void setMaxWorkers(int maxWorkers) {
        this.maxWorkers = maxWorkers;
    }
    
    

    public LinkedList getMotherboardProducers() {
        return motherboardProducers;
    }

    public LinkedList getAssemblers() {
        return assemblers;
    }

    public void setAssemblers(LinkedList assemblers) {
        this.assemblers = assemblers;
    }
    

    public void setMotherboardProducers(LinkedList motherboardProducers) {
        this.motherboardProducers = motherboardProducers;
    }

    public LinkedList getCPUProducers() {
        return CPUProducers;
    }

    public void setCPUProducers(LinkedList CPUProducers) {
        this.CPUProducers = CPUProducers;
    }

    public LinkedList getRAMProducers() {
        return RAMProducers;
    }

    public void setRAMProducers(LinkedList RAMProducers) {
        this.RAMProducers = RAMProducers;
    }

    public LinkedList getPowerSupProducers() {
        return powerSupProducers;
    }

    public void setPowerSupProducers(LinkedList powerSupProducers) {
        this.powerSupProducers = powerSupProducers;
    }

    public LinkedList getGraphicCardProducers() {
        return graphicCardProducers;
    }

    public void setGraphicCardProducers(LinkedList graphicCardProducers) {
        this.graphicCardProducers = graphicCardProducers;
    }

    //public ProjectManager getPm() {
    //   return pm;
    //}

    //public void setPm(ProjectManager pm) {
    //    this.pm = pm;
    //}

    //public Director getDir() {
    //    return dir;
    //}

    //public void setDir(Director dir) {
    //  this.dir = dir;
    //}

    //public DirectorWatch getDirWatch() {
    //    return dirWatch;
    //}

    //public void setDirWatch(DirectorWatch dirWatch) {
    //    this.dirWatch = dirWatch;
    //}

    public Semaphore getMutex() {
        return mutex;
    }

    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }

    public Storehouse getCompanyStorehouse() {
        return companyStorehouse;
    }

    public void setCompanyStorehouse(Storehouse companyStorehouse) {
        this.companyStorehouse = companyStorehouse;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
        this.labels[7].setText(Double.toString(this.income));
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
        this.labels[9].setText(Double.toString(this.salary));
    }

    public int getDayDuration() {
        return dayDuration;
    }

    public void setDayDuration(int dayDuration) {
        this.dayDuration = dayDuration;
    }

    public int getHourDuration() {
        return hourDuration;
    }

    public void setHourDuration(int hourDuration) {
        this.hourDuration = hourDuration;
    }

    public int getMinDuration() {
        return minDuration;
    }

    public void setMinDuration(int minDuration) {
        this.minDuration = minDuration;
    }

    public void addWorker(int type, int cantidad){
     
        if(type==0) {
            for (int i = 1; i<=cantidad; i++) {
                Workers motherboard =new Workers(0,this.getCompanyName(),dayDuration,this.getCompanyStorehouse(),getMutex());
                Node workNode = new Node(motherboard);
                getMotherboardProducers().insertStart(workNode);
                motherboard.start();
            }
        }
        if(type==1) {
            for (int i = 1; i<=cantidad; i++) {
                Workers cpu =new Workers(1,this.getCompanyName(),dayDuration,this.getCompanyStorehouse(),getMutex());
                Node workNode = new Node(cpu);
                getCPUProducers().insertStart(workNode);
                cpu.start();
            }
        }
        if(type==2) {
            for (int i = 1; i<=cantidad; i++) {
                Workers ram =new Workers(2,this.getCompanyName(),dayDuration,this.getCompanyStorehouse(),getMutex());
                Node workNode = new Node(ram);
                getRAMProducers().insertStart(workNode);
                ram.start();
            }
        }
        if(type==3) {
            for (int i = 1; i<=cantidad; i++) {
                Workers psupply =new Workers(3,this.getCompanyName(),dayDuration,this.getCompanyStorehouse(),getMutex());
                Node workNode = new Node(psupply);
                getPowerSupProducers().insertStart(workNode);
                psupply.start();
            }
        }
        if(type==4) {
           for (int i = 1; i<=cantidad; i++) {
                Workers graphicCard =new Workers(4,this.getCompanyName(),dayDuration,this.getCompanyStorehouse(),getMutex());
                Node workNode = new Node(graphicCard);
                getGraphicCardProducers().insertStart(workNode);
                graphicCard.start();
            }
        }
        
        if(type==5) {
            for (int i = 1; i<=cantidad; i++) {
                Workers assembler =new Workers(5,this.getCompanyName(),dayDuration,this.getCompanyStorehouse(),getMutex());
                Node workNode = new Node(assembler);
                getAssemblers().insertStart(workNode);
                assembler.start();
            }
        
        }
    }

  
    
    public void removeWorker(int workerType){
    
        Node tempNode;
        Workers tempWorker;
        
        switch(workerType){
        
            
            
            case 0:
                
                tempNode = this.motherboardProducers.getFirst();
                tempWorker = Workers.class.cast(tempNode.getData());
                tempWorker.setIsActive(false);
                this.motherboardProducers.delFirst();
           ;
                
                break;
                
            case 1:
                
                tempNode = this.CPUProducers.getFirst();
                tempWorker = Workers.class.cast(tempNode.getData());
                tempWorker.setIsActive(false);
                this.CPUProducers.delFirst();
    
                
                break;
                
            case 2:
                
                tempNode = this.RAMProducers.getFirst();
                tempWorker = Workers.class.cast(tempNode.getData());
                tempWorker.setIsActive(false);
                this.RAMProducers.delFirst();
          
                break;
                
            case 3:
                
                tempNode = this.powerSupProducers.getFirst();
                tempWorker = Workers.class.cast(tempNode.getData());
                tempWorker.setIsActive(false);
                this.powerSupProducers.delFirst();
            
                break;
                
            case 4:
                
                tempNode = this.graphicCardProducers.getFirst();
                tempWorker = Workers.class.cast(tempNode.getData());
                tempWorker.setIsActive(false);
                this.graphicCardProducers.delFirst();
                
                
                break;
                
            case 5:
                
                tempNode = this.assemblers.getFirst();
                tempWorker = Workers.class.cast(tempNode.getData());
                tempWorker.setIsActive(false);
                this.assemblers.delFirst();
               
                
                break;
            
        }
        
        //this.labels[0].setText(Integer.toString(this.motherboardProducers.getlSize() + this.CPUProducers.getlSize() + this.RAMProducers.getlSize() + this.powerSupProducers.getlSize() + this.graphicCardProducers.getlSize() + this.assemblers.getlSize()));
        //this.labels[7].setText(Integer.toString(this.motherboardProducers.getlSize() + this.CPUProducers.getlSize() + this.RAMProducers.getlSize() + this.powerSupProducers.getlSize() + this.graphicCardProducers.getlSize() + this.assemblers.getlSize()));
        
    }

    public JLabel[] getLabels() {
        return labels;
    }

    public void setLabels(JLabel[] labels) {
        this.labels = labels;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getUtilities() {
        return utilities;
    }

    public void setUtilities(double utilities) {
        this.utilities = utilities;
        this.labels[8].setText(Double.toString(this.utilities));
    }
    
    public void addSalary(double salary){
        this.salary += salary;
        this.labels[9].setText(Double.toString(this.salary));
    }
    
    public void addIncome(double income){
        this.income += income;
        this.labels[7].setText(Double.toString(this.income));
    }
 
    public void devLimitNotice(){
        JOptionPane.showMessageDialog(null, "Limite de desarrolladores alcanzado, incremente el maximo para poder añadir más");
    }
    
}
