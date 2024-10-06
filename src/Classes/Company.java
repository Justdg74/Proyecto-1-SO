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

    public void addWorker(Workers worker){
        if((this.motherboardProducers.getlSize() + this.CPUProducers.getlSize() + this.RAMProducers.getlSize() + this.powerSupProducers.getlSize() + this.graphicCardProducers.getlSize() + this.assemblers.getlSize()) < this.maxWorkers){
            Node workerNode = new Node(worker);
            switch (worker.getWorkType()){

                case "MotherboardProduction":
                    this.motherboardProducers.insertEnd(workerNode);
                    this.labels[1].setText(Integer.toString(this.motherboardProducers.getlSize()));
                    //this.labels[8].setText(Integer.toString(this.motherboardProducers.getlSize()));
                    break;

                case "CPUProduction":
                    this.CPUProducers.insertEnd(workerNode);
                    this.labels[2].setText(Integer.toString(this.CPUProducers.getlSize()));
                    //this.labels[9].setText(Integer.toString(this.CPUProducers.getlSize()));
                    break;

                case "RAMProduction":
                    this.RAMProducers.insertEnd(workerNode);
                    this.labels[3].setText(Integer.toString(this.RAMProducers.getlSize()));
                    //this.labels[10].setText(Integer.toString(this.RAMProducers.getlSize()));
                    break;

                case "PowerSupplyProduction":
                    this.powerSupProducers.insertEnd(workerNode);
                    this.labels[4].setText(Integer.toString(this.powerSupProducers.getlSize()));
                    //this.labels[11].setText(Integer.toString(this.powerSupProducers.getlSize()));
                    break;

                case "GraphicCardProduction":
                    this.graphicCardProducers.insertEnd(workerNode);
                    this.labels[5].setText(Integer.toString(this.graphicCardProducers.getlSize()));
                    //this.labels[12].setText(Integer.toString(this.graphicCardProducers.getlSize()));
                    break;
            }        

            this.labels[0].setText(Integer.toString(this.motherboardProducers.getlSize() + this.CPUProducers.getlSize() + this.RAMProducers.getlSize() + this.powerSupProducers.getlSize() + this.graphicCardProducers.getlSize() + this.assemblers.getlSize()));
            //this.labels[7].setText(Integer.toString(this.motherboardProducers.getlSize() + this.CPUProducers.getlSize() + this.RAMProducers.getlSize() + this.powerSupProducers.getlSize() + this.graphicCardProducers.getlSize() + this.assemblers.getlSize()));
            worker.start();
            
        }else{
            devLimitNotice();
        }
    }

    
    public void addAssembler(Assemblers assembler){
        if((this.motherboardProducers.getlSize() + this.CPUProducers.getlSize() + this.RAMProducers.getlSize() + this.powerSupProducers.getlSize() + this.graphicCardProducers.getlSize() + this.assemblers.getlSize()) < this.maxWorkers){
            Node integNode = new Node(assembler);
            this.assemblers.insertEnd(integNode);
            this.labels[6].setText(Integer.toString(this.assemblers.getlSize()));
            //this.labels[13].setText(Integer.toString(this.assemblers.getlSize()));
            
            this.labels[0].setText(Integer.toString(this.motherboardProducers.getlSize() + this.CPUProducers.getlSize() + this.RAMProducers.getlSize() + this.powerSupProducers.getlSize() + this.graphicCardProducers.getlSize() + this.assemblers.getlSize()));
            //this.labels[7].setText(Integer.toString(this.motherboardProducers.getlSize() + this.CPUProducers.getlSize() + this.RAMProducers.getlSize() + this.powerSupProducers.getlSize() + this.graphicCardProducers.getlSize() + this.assemblers.getlSize()));
            assembler.start();
        }
    }

    public void removeAssembler(){
        if (this.assemblers.getlSize() > 1) {
            Node tempNode;
            Assemblers tempInte;

            tempNode = this.assemblers.getLast();
            tempInte = Assemblers.class.cast(tempNode.getData());
            tempInte.setIsActive(false);
            this.assemblers.delLast();
            this.labels[6].setText(Integer.toString(this.assemblers.getlSize()));
            //this.labels[13].setText(Integer.toString(this.assemblers.getlSize()));
            this.labels[0].setText(Integer.toString(this.motherboardProducers.getlSize() + this.CPUProducers.getlSize() + this.RAMProducers.getlSize() + this.powerSupProducers.getlSize() + this.graphicCardProducers.getlSize() + this.assemblers.getlSize()));
            //this.labels[7].setText(Integer.toString(this.motherboardProducers.getlSize() + this.CPUProducers.getlSize() + this.RAMProducers.getlSize() + this.powerSupProducers.getlSize() + this.graphicCardProducers.getlSize() + this.assemblers.getlSize()));
        
        }
       
    }
    
    
    public boolean canDecreaseMaxDevs() {
        int totalDevs = motherboardProducers.getlSize() + CPUProducers.getlSize() + RAMProducers.getlSize() + powerSupProducers.getlSize() + graphicCardProducers.getlSize() + assemblers.getlSize();
        return totalDevs < maxWorkers;
    }
    
 /*
    public void activateDevs(){
        Node tempNode = this.motherboardProducers.getlFirst();
        for(int i = 0; i < this.motherboardProducers.getlSize(); i++){
            GameDeveloper tempWorker = GameDeveloper.class.cast(tempNode.getData()); 
            tempWorker.start();
            tempNode = tempNode.getpNext();
        }
        
        tempNode = this.CPUProducers.getlFirst();
        for(int i = 0; i < this.CPUProducers.getlSize(); i++){
            GameDeveloper tempWorker = GameDeveloper.class.cast(tempNode.getData()); 
            tempWorker.start();
            tempNode = tempNode.getpNext();
        }
        
        tempNode = this.RAMProducers.getlFirst();
        for(int i = 0; i < this.RAMProducers.getlSize(); i++){
            GameDeveloper tempWorker = GameDeveloper.class.cast(tempNode.getData()); 
            tempWorker.start();
            tempNode = tempNode.getpNext();
        }
        
        tempNode = this.powerSupProducers.getlFirst();
        for(int i = 0; i < this.powerSupProducers.getlSize(); i++){
            GameDeveloper tempWorker = GameDeveloper.class.cast(tempNode.getData()); 
            tempWorker.start();
            tempNode = tempNode.getpNext();
        }
        
        tempNode = this.graphicCardProducers.getlFirst();
        for(int i = 0; i < this.graphicCardProducers.getlSize(); i++){
            GameDeveloper tempWorker = GameDeveloper.class.cast(tempNode.getData()); 
            tempWorker.start();
            tempNode = tempNode.getpNext();
        }
    
    }
*/
    
    public void removeWorker(String workerType){
    
        Node tempNode;
        Workers tempWorker;
        
        switch(workerType){
        
            
            
            case "MotherboardProduction":
                
                tempNode = this.motherboardProducers.getLast();
                tempWorker = Workers.class.cast(tempNode.getData());
                tempWorker.setIsActive(false);
                this.motherboardProducers.delLast();
                this.labels[1].setText(Integer.toString(this.motherboardProducers.getlSize()));
                //this.labels[8].setText(Integer.toString(this.motherboardProducers.getlSize()));
                
                break;
                
            case "CPUProduction":
                
                tempNode = this.CPUProducers.getLast();
                tempWorker = Workers.class.cast(tempNode.getData());
                tempWorker.setIsActive(false);
                this.CPUProducers.delLast();
                this.labels[2].setText(Integer.toString(this.CPUProducers.getlSize()));
                //this.labels[9].setText(Integer.toString(this.CPUProducers.getlSize()));
                
                break;
                
            case "RAMProduction":
                
                tempNode = this.RAMProducers.getLast();
                tempWorker = Workers.class.cast(tempNode.getData());
                tempWorker.setIsActive(false);
                this.RAMProducers.delLast();
                this.labels[3].setText(Integer.toString(this.RAMProducers.getlSize()));
                //this.labels[10].setText(Integer.toString(this.RAMProducers.getlSize()));
                
                break;
                
            case "PowerSupplyProduction":
                
                tempNode = this.powerSupProducers.getLast();
                tempWorker = Workers.class.cast(tempNode.getData());
                tempWorker.setIsActive(false);
                this.powerSupProducers.delLast();
                this.labels[4].setText(Integer.toString(this.powerSupProducers.getlSize()));
                //this.labels[11].setText(Integer.toString(this.powerSupProducers.getlSize()));
                
                break;
                
            case "GraphicCardProduction":
                
                tempNode = this.graphicCardProducers.getLast();
                tempWorker = Workers.class.cast(tempNode.getData());
                tempWorker.setIsActive(false);
                this.graphicCardProducers.delLast();
                this.labels[5].setText(Integer.toString(this.graphicCardProducers.getlSize()));
                //this.labels[12].setText(Integer.toString(this.graphicCardProducers.getlSize()));
                
                break;
            
        }
        
        this.labels[0].setText(Integer.toString(this.motherboardProducers.getlSize() + this.CPUProducers.getlSize() + this.RAMProducers.getlSize() + this.powerSupProducers.getlSize() + this.graphicCardProducers.getlSize() + this.assemblers.getlSize()));
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
