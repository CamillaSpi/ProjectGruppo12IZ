package commandClassPackage;

import modelClassPackage.ComplexNumber;
import modelClassPackage.MyOperandCollection;

/**
 *
 * @author Gruppo 12 IZ
 */
public class EnterCommand implements Command {

    private final MyOperandCollection collector;
    private final ComplexNumber toPush;

    /**
     * <p>
     * It create an object of the Enter Command if the collector is not null and
     * the ComplexNumber to push is not null
     *</p> <!-- -->
     * @param collector is the data structur were take the operand.
     * @param toPush represent the number to push.
      * @see ComplexNumber 
     * @see MyOperandCollection 
     */
    public EnterCommand(MyOperandCollection collector, ComplexNumber toPush) {
        assert collector != null;
        this.collector = collector;
        assert toPush != null;
        this.toPush = toPush;

    }

    /**
     * <p>
     * It execute the operation of insert a ComplexNumber in the collection 
     * passed as param
     * </p> <!-- -->
     * @return true because the complexnumber is secure saved when this function is called.
      * @see ComplexNumber 
     * @see MyOperandCollection 
     */
    @Override
    public boolean execute() {
        collector.insert(this.toPush);
        return true;
    }

    /**
     * <p>
     * It execute the undo of the insert operation removing the last inserted
     * element.
     * </p> <!-- -->
     * @see ComplexNumber 
     * @see MyOperandCollection 
     */
    @Override
    public void undo() {
        collector.remove();
    }

}
