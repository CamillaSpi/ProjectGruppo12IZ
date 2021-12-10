/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelClassPackage;

import java.util.LinkedList;
import java.util.List;

/**
 * This is defined as an extension of the java Stack class adapted for acalculator use
 * container complexNumber.
 *
 * @author Gruppo 12 IZ
 * 
 */
public class OperandCollection{
    private final List<ComplexNumber> l;
    private final List<ComplexNumber> l1;
    private final int k;

    public OperandCollection(int k) {
        this.l = new LinkedList();
        this.l1 = new LinkedList();
        this.k = k;
    }

    public List<ComplexNumber> getL() {
        return l;
    }
    
    /**
    * It inserts (if the param is not null) at the top of the collection a complexNumber object passed as 
    * <p> <!-- -->
    * a parameter within the collection.
    * @param a complex number to enter
    * @see ComplexNumber
    */
    public void insert(ComplexNumber a){
        if(a != null){
            l.add(0, a);
            if(l.size()>this.k)
                l1.add(0, l.remove(this.k));                
        }
       
    }
    /**
    * It removes and returns (if the collection is not empty) the complexNumber at the top of the collection.
    * <p> <!-- -->
    * @return the complexNumber removed or null
    * @see ComplexNumber
    */
    public ComplexNumber remove(){
        if(!l.isEmpty()){
            ComplexNumber tmp = l.remove(0);
            if(l.size() < this.k && l1.size() > 0)
                l.add(this.k-1, l1.remove(0));
            return tmp;
            
        }
        
        return null;
    }
    
    /**
    * It returns without remove (if the collection is not empty) the complexNumber at the top of the collection.
    * <p> <!-- -->
    * @return the top complexNumber or null
    * @see ComplexNumber
    */
    public ComplexNumber last(){
        if(!l.isEmpty())
            return l.get(0);
        
        return null;
    }
    
    /**
    * It returns without remove (if the collection has at least two element) the second complexNumber from the top of the collection.
    * <p> <!-- -->
    * @return the second element complexNumber or null
    * @see ComplexNumber
    */
    public ComplexNumber secondLast(){
        if(l.size() > 1)
            return l.get(1);
        
        return null;
    }
    
    /**
    * It returns the number of elements inside the collection.
    * <p> <!-- -->
    * @return the int length
    */
    public int collectionLength(){
        return l.size() + l1.size();
    }
    
}
