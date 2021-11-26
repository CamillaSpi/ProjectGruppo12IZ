/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelClassPackage;

/**
 *
 * @author nando
 */
public class MyOperandCollection extends OperandCollection {

    @Override
    public void clear() {

    }
    
    /**
    * It returns the last number inserted inside the collection.
    * <p> <!-- -->
    * @return true if the element was remove, otherwise false
    */
    public boolean drop() {
        //io remove last elements!
        int size = super.collectionLength();
        if (super.collectionLength() == 0)
            return false;
        super.remove();
        return size - 1 == super.collectionLength();

    }

    public boolean dup() {
        int size = this.collectionLength();
        if(size>0)
            this.insert(this.last());
        return size+1 == this.collectionLength();
    }

    public void swap() {

    }

    public void over() {

    }

}
