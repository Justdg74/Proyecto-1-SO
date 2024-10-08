/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import javax.swing.JLabel;
import Dashboards.Dashboard;
/**
 *
 * @author alexi
 */

/**
 * En esta clase se guardan los componentes terminados y las computadoras ensambladas
 * 
 */
public class Storehouse {
    private int motherboard;
    private int CPUs;
    private int RAMs;
    private int PowerSupplys;
    private int GraphicCards;
    private int daysRemaining; //Dias entrega
    private int deadLine; //Dias entrega original
    private int standardComputers;
    private int graphicCardComputers;
    private int standardCounter;
    private JLabel[] labels;
    private final String company;
    private double salary;
    private int dayspassed;
    private double incomes;
   private double costs; 
   private double utilities;


    public Storehouse(String comp) {
        this.motherboard = 0;
        this.CPUs = 0;
        this.RAMs = 0;
        this.PowerSupplys = 0;
        this.GraphicCards = 0;
        this.daysRemaining = 5;
        this.standardComputers = 0;
        this.graphicCardComputers = 0;
        this.standardCounter = 0;
        this.company = comp;
        this.salary = 0;
        this.dayspassed =0;
        this.incomes = 0;
        this.costs = 0;
        this.utilities = 0;
    }
    
    
    

    // Getters y Setters

    public int getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(int motherboard) {
        this.motherboard = motherboard;
    }

    public int getCPUs() {
        return CPUs;
    }

    public void setCPUs(int CPUs) {
        this.CPUs = CPUs;
    }

    public int getRAMs() {
        return RAMs;
    }

    public void setRAMs(int RAMs) {
        this.RAMs = RAMs;
    }

    public int getPowerSupplys() {
        return PowerSupplys;
    }

    public void setPowerSupplys(int PowerSupplys) {
        this.PowerSupplys = PowerSupplys;
    }

    public int getGraphicCards() {
        return GraphicCards;
    }

    public void setGraphicCards(int GraphicCards) {
        this.GraphicCards = GraphicCards;
    }

    public int getDaysRemaining() {
        return daysRemaining;
    }

    public void setDaysRemaining(int daysRemaining) {
        this.daysRemaining = daysRemaining;
        this.labels[5].setText(Integer.toString(this.daysRemaining));
            
    }

    public int getStandardComputers() {
        return standardComputers;
    }

    public void setStandardComputers(int standardComputers) {
        this.standardComputers = standardComputers;
    }

    public int getGraphicCardComputers() {
        return graphicCardComputers;
    }

    public void setGraphicCardComputers(int graphicCardComputers) {
        this.graphicCardComputers = graphicCardComputers;
    }

    public int getStandardCounter() {
        return standardCounter;
    }

    public void setStandardCounter(int standardCounter) {
        this.standardCounter = standardCounter;
    }
    
    public String getCompany() {
        return company;
    }
    
    /**
     * 
     * funcion addToStorehouse
     * 
     * Ejecutada por trabajadores cuando su acumulado sea mayor o igual a 1, segun sea su tipo ejecuta condicionales
     * para verificar si el almacen esta lleno.
     * 
     * Si no esta lleno:
     * Verifica si la cantidad a añadir excede del maximo, si excede, solo añade una parte para no exceder del maximo
     * Si no excede, añade la cantidad normalmente
     * 
     * Si esta lleno:
     * No hace nada 
     * 
     * @param amount
     * @param devType 
     */
    
    /**
     * Funcion para añadir componentes al drive
     * @param amount cantidad del componente a añadir
     * @param workType tipo de trabajador, determina que es el componente que se esta guardando
     * @throws InterruptedException 
     * 
     * Primero se verifica el tipo de trabajador que hace la peticion de guardado para determinar el componente a guardar
     * 
     * Luego se verifica si el almacen para ese componente esta lleno, en caso de no estarlo se procede a verificar si 
     * el acumulado a guardar excede de la capacidad del almacen.
     * 
     * En caso de exceder, la cantidad actual del almacen se colocara en su maximo
     * De no exceder, se carga normalmente el acumulado
     * 
     * Si el almacen esta lleno no se hace nada
     */
    public void addToStorehouse(int amount, int workType)throws InterruptedException {
        switch (workType){
        
            case 0: //MotherboardProduction
                if (this.motherboard < 25){
                    if ((this.motherboard + amount) > 25){
                        this.motherboard += (25 - this.motherboard);
                
                    }else{
                        this.motherboard += amount;
                    }
                    
                    this.labels[0].setText(Integer.toString(this.motherboard));
                    
                }
                break;
                
            case 1: //CPUProduction
                if (this.CPUs < 20){
                    if ((this.CPUs + amount) > 20){
                        this.CPUs += (20 - this.CPUs);
                
                    }else{
                        this.CPUs += amount;
                    }
                    
                    this.labels[1].setText(Integer.toString(this.CPUs));
                    
                }
                break;
                
            case 2: //RAMProduction
                if (this.RAMs < 55){
                    if ((this.RAMs + amount) > 55){
                        this.RAMs += (55 - this.RAMs);
                
                    }else{
                        this.RAMs += amount;
                    }
                    
                    this.labels[2].setText(Integer.toString(this.RAMs));
                    
                }
                break;
                
            case 3: //PowerSupplyProduction
                if (this.PowerSupplys < 35){
                    if ((this.PowerSupplys + amount) > 35){
                        this.PowerSupplys += (35 - this.PowerSupplys);
                
                    }else{
                        this.PowerSupplys += amount;
                    }
                    
                    this.labels[3].setText(Integer.toString(this.PowerSupplys));
                    
                }
                
                break;
            
            case 4:  //GraphicCardProduction
                if (this.GraphicCards < 10){
                    if ((this.GraphicCards + amount) > 10){
                        this.GraphicCards += (10 - this.GraphicCards);
                
                    }else{
                        this.GraphicCards += amount;
                    }
                    
                    this.labels[4].setText(Integer.toString(this.GraphicCards));
                    
                }
                break;
        }
    }
    
    /**
     * Funcion que verifica si es posible ensamblar un computador
     * 
     * Primero se verifica a que compañia se pertenece
     * 
     * Luego se verifica si es necesario realiza run computador con tarjeta grafica segun el contador de computadores sin tarjeta
     * 
     * Se retorna un booleano que indicara si se cumplen las condiciones
     * @return boolean
     */
    public boolean canAssembleComputer() {
        if(this.company.equals("Apple")){
            if(this.standardCounter >= 5){
                return this.motherboard >= 2 && this.CPUs >= 1 && this.RAMs >= 4 && this.PowerSupplys >= 4 && this.GraphicCards >= 2;
                
            }else{
                return this.motherboard >= 2 && this.CPUs >= 1 && this.RAMs >= 4 && this.PowerSupplys >= 4;
            }
            
        }else{
            if(this.standardCounter >= 6){
                return this.motherboard >= 2 && this.CPUs >= 3 && this.RAMs >= 4 && this.PowerSupplys >= 6 && this.GraphicCards>= 6;
                
            }else{
                return this.motherboard >= 2 && this.CPUs >= 3 && this.RAMs >= 4 && this.PowerSupplys >= 6;
            }
        }
    }
    
    /**
     * Funcion para el ensamblaje computadres (utilizada por el ensamblador)
     * 
     * Primero se verifica a que compañia se pertenece para determinar los requerimientos del computador
     * luego se verifica si  la computadora a ensamblar debe tener tarjeta grafica o no
     * segun las condiciones que se cumplan, se restan las partes utilizadas para el ensamblaje de la computadora
     * 
     * si fue una computadora estandar, se aumenta en 1 la cantidad de computadoras estandar en el almacen y se aumenta el contador
     * que indica cuantos computadoras estandar se han realizado
     * 
     * si fue una computadora con tarjeta grafica, se aumenta en 1 la cantidad de computadoras con tarjeta grafica en el almacen y se reinicia el contador de
     * cuantas computadoras estandar se han hecho
     */
    public void assembleComputer() {
        if(this.company.equals("Apple")){
            this.motherboard -= 2;
            this.CPUs -= 1;
            this.RAMs -= 4;
            this.PowerSupplys -= 4;
            
            if(this.standardCounter >= 5){
                this.GraphicCards -= 2;
                this.standardCounter = 0;
                this.graphicCardComputers += 1;
                
            }else{
                this.standardCounter += 1;
                this.standardComputers += 1;
            }
                
        }else{
            this.motherboard -= 2;
            this.CPUs -= 3;
            this.RAMs -= 4;
            this.PowerSupplys -= 6;
            
            if(this.standardCounter >= 6){
                this.GraphicCards -= 5;
                this.standardCounter = 0;
                this.graphicCardComputers += 1;
                
            }else{
                this.standardCounter += 1;
                this.standardComputers += 1;
            }
        
        }
        
        this.labels[0].setText(Integer.toString(this.motherboard));
        this.labels[1].setText(Integer.toString(this.CPUs));
        this.labels[2].setText(Integer.toString(this.RAMs));
        this.labels[3].setText(Integer.toString(this.PowerSupplys));
        this.labels[4].setText(Integer.toString(this.GraphicCards));
        this.labels[6].setText(Integer.toString(this.standardComputers));
        this.labels[7].setText(Integer.toString(this.graphicCardComputers));
        
        
        
        
        
    }
    public JLabel[] getLabels() {
        return labels;
    }

    public void setLabels(JLabel[] labels) {
        this.labels = labels;
    }

    public int getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(int deadLine) {
        this.deadLine = deadLine;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public void addSalary(double salary){
        this.salary += ((salary/1000)*24);
    }

    public int getDayspassed() {
        return dayspassed;
    }

    public void setDayspassed( int dayspassed) {
        this.dayspassed = dayspassed;
        
    }
    
    public void addDayspassed() {
        this.dayspassed += 1;
        this.labels[8].setText(Integer.toString(this.dayspassed));
    
    }
    
     public double getCosts(){
        return costs;
    }
    
    public void setCosts(double costs){
        this.costs = costs;
    }
    
    public double getIncomes(){
        return incomes;
    }
    
    public void setIncomes(double incomes){
        this.incomes = incomes;
    }
    
    public double getUtilities(){
        return utilities;
    }
    
    public void setUtilities(double utilities){
        this.utilities = utilities;
    }

    
     public void calcularGananciaS(float incomes){
        if(this.company.compareTo("Apple") == 0){
            setIncomes(getIncomes() + incomes*100000);
            setUtilities(getIncomes() - getCosts());
            Dashboard.getApple_Gain_Counter().setText(Integer.toString((int) getIncomes())+"$");
            Dashboard.getApple_Utility_Counter().setText(Integer.toString((int) ((int) getIncomes() - getCosts()))+"$");
            //Global.addNk((int) getUtilidad(), (Global.getDaycounter()-1)/2);
        }else{
            setIncomes(getIncomes() + incomes*180000);
            setUtilities(getIncomes() - getCosts());
            Dashboard.getMSI_Gain_Counter().setText(Integer.toString((int) getIncomes())+"$");
            Dashboard.getMSI_Utility_Counter().setText(Integer.toString((int) ((int) getIncomes() - getCosts()))+"$");
            //Global.addCn((int) getUtilidad(), (Global.getDaycounter()-1)/2);
        }
        System.out.println("GANANCIAS:"+ getCompany() + " " + getIncomes());
    }
    
    public void calcularGananciaGC(float incomes){
        if(this.company.compareTo("Apple") == 0){
            setIncomes(getIncomes() + incomes*150000);
            setUtilities(getIncomes() - getCosts());
            Dashboard.getApple_Gain_Counter().setText(Integer.toString((int) getIncomes())+"$");
            Dashboard.getApple_Utility_Counter().setText(Integer.toString((int) ((int) getIncomes() - getCosts()))+"$");
        }else{
            setIncomes(getIncomes() + incomes*250000);
            setUtilities(getIncomes() - getCosts());
            Dashboard.getMSI_Gain_Counter().setText(Integer.toString((int) getIncomes())+"$");
            Dashboard.getMSI_Utility_Counter().setText(Integer.toString((int) ((int) getIncomes() - getCosts()))+"$");
        }
    }
}
