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
    public void clear(){
        
    }
    public void drop(){
        
    }
    public void dup(){
        
    }
    
    /**
    * It swap (if there are more than two elements in the collection) the last two element inserted 
    * <p> <!-- -->
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
    
    public void over(){
        
    }
    
    

}
