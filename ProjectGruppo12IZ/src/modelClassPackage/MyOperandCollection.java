/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelClassPackage;

/**
 *
  * @author Gruppo 12 IZ
 */
public class MyOperandCollection extends OperandCollection {

    public MyOperandCollection(int k) {
        super(k);
    }   
    
    /**
     * <p>
    * It swap (if there are at least two elements in the collection) the last two element inserted 
    * </p> <!-- -->
    * @return a boolean true if the operation is executed correctly, false otherwise
    * @see OperandCollection
    */
    public boolean swap(){
        if(this.collectionLength() >= 2){
            ComplexNumber last = this.remove();
            ComplexNumber seclast = this.remove();
            this.insert(last);
            this.insert(seclast);
            return true;
        }
        else
            return false;   
    }
    
 
    /**
    * <p>
    * It remove the last number inserted inside the collection.
    * </p> <!-- -->
    * @return true if the element was remove, otherwise false
    * @see OperandCollection
    */
    public boolean drop() {
        int size = this.collectionLength();
        if (size == 0)
            return false;
        this.remove();
        return size - 1 == this.collectionLength();

    }

    /**
    * <p>
    * It duplicate the last number inserted inside the collection.
    * </p> <!-- -->
    * @return true if the element was add, otherwise false
    */
    public boolean dup() {
        int size = this.collectionLength();
        if(size > 0)
            this.insert(this.last());
        return size + 1 == this.collectionLength();
    }
    
    
    /**
    * <p>
    * It duplicate the seconds last number and inserted inside the collection.
    * </p> <!-- -->
    * @return true if the seconds last element was duplicate and inserted, otherwise false
    */
    public boolean over() {
    //push a copy of the seconds last elements
    int size = this.collectionLength();
        if (size == 0 || size < 2)
            return false;
        ComplexNumber last = this.remove();
        ComplexNumber toCopy = this.last();
        this.insert(last);
        this.insert(toCopy);
        return size + 1 == this.collectionLength();
    }

    /**
    * <p>
    * It remove all elements inside the collection.
    * </p> <!-- -->
    * @return true if all the elements in the stack have been deleted, false if the stack was already empty.
    */
    public boolean clear(){
        int size = this.collectionLength();
        if(size==0)
            return false;
        for(int i = 0; i<size; i++){
            this.remove();
        }
        return this.collectionLength()==0;
    }
    
}
