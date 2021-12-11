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
     * It create an object of the Enter Command if the collector is not null and
     * the ComplexNumber to push is not null
     *
     * @param collector is the data structur were take the operand.
     * @param toPush represent the number to push.
     * @see ComplexNumber, MyOperandCollection
     */
    public EnterCommand(MyOperandCollection collector, ComplexNumber toPush) {
        assert collector != null;
        this.collector = collector;
        assert toPush != null;
        this.toPush = toPush;

    }

    /**
     * It execute the operation of insert a ComplexNumber in the collection 
     * passed as param
     * @return true because the complexnumber is secure saved when this function is called.
     * @see ComplexNumber, MyOperandCollection
     */
    @Override
    public boolean execute() {
        collector.insert(this.toPush);
        return true;
    }

    /**
     * It execute the undo of the insert operation removing the last inserted
     * element.
     * @see ComplexNumber, MyOperandCollection
     */
    @Override
    public void undo() {
        collector.remove();
    }

}
