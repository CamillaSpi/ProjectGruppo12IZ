/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateClassPackage;

/**
 *
 * @author GRUPPO 12 IZ
 */
public interface State {

    public void onPressEnter();

    public void onButtonOne();

    public void onButtonThree();

    public void setStateStandard();

    public void setStateVariables();

    public void setStateOperations();
    
}
