/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author alexi
 */
public class LinkedList {
    private Node First;
    private Node Last;
    private int lSize = 0;

    /**
     * @return the First
     */
    public Node getFirst() {
        return First;
    }

    /**
     * @param First the First to set
     */
    public void setFirst(Node First) {
        this.First = First;
    }

    /**
     * @return the Last
     */
    public Node getLast() {
        return Last;
    }

    /**
     * @param Last the Last to set
     */
    public void setLast(Node Last) {
        this.Last = Last;
    }

    /**
     * @return the lSize
     */
    public int getlSize() {
        return lSize;
    }

    /**
     * @param lSize the lSize to set
     */
    public void setlSize(int lSize) {
        this.lSize = lSize;
    }
 
    
    public LinkedList(){
        this.First = null;
        this.Last = null;
        this.lSize = 0;
    }
    
    public boolean isEmpty(){
        return this.First == null;
    }
    
    
    public void insertStart(Node data){
    if(isEmpty()){
        this.First = data;
        this.Last = data;
    }else{
        data.setpNext(this.First);
        this.First = data;
        }
    this.lSize++;
    }
    
    public void insertEnd(Node data){
        if(isEmpty()){
            this.First = data;
            this.Last = data;
        }else{
            this.Last.setpNext(data);
            this.Last = data;
        }
        this.lSize++;
        }
    
    public Node delFirst(){
        if(isEmpty()){
        return null;
        }else{
            Node aux = this.First;
            this.First = aux.getpNext();
            this.lSize--;
            return aux;
        }
    }
    
    public Node delLast(){
        if(isEmpty()){
            return null;
        }else{
            Node aux = this.First;
            Node previousLast = this.Last;
            for(int i = 0; i < this.lSize - 1; i++){
                aux = aux.getpNext();
            }
            aux.setpNext(null);
            this.Last = aux;
            this.lSize--;
            return previousLast;
        }   
    }
    
    public String printList(){
        if(isEmpty()){
            return null;
        }else{
            String fullList = "";
            Node aux = First;
            for(int i = 0; i < lSize; i++){
                fullList += aux.getData() + "\n";
                aux = aux.getpNext();
                }
            return fullList;
            }
    } 
}
