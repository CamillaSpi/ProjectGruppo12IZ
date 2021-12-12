/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelClassPackage;

import java.util.LinkedList;
import java.util.List;

/**
 * This class contains two lists, one is the one visible on the outside, the 
 * other is hidden, not making the elements inside visible in any way unless 
 * they are recalled from the visible list (as they are necessary to include 
 * the exact number of visible elements).
 *
 * @author Gruppo 12 IZ
 * 
 */
public class OperandCollection{
    private final List<ComplexNumber> l;
    private final List<ComplexNumber> l1;
    private final int k;

    /**
    * <p>
    * It creates an object of this class, so inizialize the two data structure,
    * and the number of element that must be visible to the outside, so the element
    * stored in the first data structure.
    * </p> <!-- -->
    * a parameter within the collection.
    * @param k is an integer number that represent the number of element visible 
    * in the class concurrently.
    * @see ComplexNumber
    */
    public OperandCollection(int k) {
        this.l = new LinkedList();
        this.l1 = new LinkedList();
        this.k = k;
    }

    /**
    * <p>
    * return the vissible list.
    * </p> <!-- -->
    * a parameter within the collection.
    * @return the list ov visible element.
    * @see ComplexNumber
    */
    public List<ComplexNumber> getL() {
        return l;
    }
    
    /**
    *<p> 
    * It inserts (if the param is not null) at the top of the collection an 
    * object complexNumber  passed as a parameter within the function. it also 
    * could pass the last operand of the visible list as the first of the invisible, 
    * if the number of element of the first list after the insertion is major 
    * that the visible number established.
    * </p> <!-- -->
    * 
    * @param a complex number to enter in the structure.
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
    *<p> 
    * It remouves at the top of the collection the first object complexNumber. 
    * it also could take the first operand of the invisible structure as last 
    * of the visible structure, if the number  of element of the first list after
    * the remove is minor that the visible number established.
    * </p> <!-- -->
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
    * <p>
    * It returns without remove (if the collection is not empty) the complexNumber 
    * at the top of the collection.
    * </p> <!-- -->
    * @return the top complexNumber or null
    * @see ComplexNumber
    */
    public ComplexNumber last(){
        if(!l.isEmpty())
            return l.get(0);
        
        return null;
    }
    
    /**
    * <p>
    * It returns without remove (if the collection has at least two element) the
    * second complexNumber from the top of the collection.
    * </p> <!-- -->
    * @return the second element complexNumber or null
    * @see ComplexNumber
    */
    public ComplexNumber secondLast(){
        if(l.size() > 1)
            return l.get(1);
        
        return null;
    }
    
    /**
    * <p>
    * It returns the number of elements inside the collection as the sum of 
    * visible and invisible.
    * </p> <!-- -->
    * @return the int length.
    */
    public int collectionLength(){
        return l.size() + l1.size();
    }
    
}
