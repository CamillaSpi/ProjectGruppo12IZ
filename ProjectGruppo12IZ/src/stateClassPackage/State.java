/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateClassPackage;

import projectgruppo12iz.FXMLDocumentController;

/**
 *
 * @author GRUPPO 12 IZ
 */
public abstract class State {
    
    FXMLDocumentController controller;
    
    public State(FXMLDocumentController controller){
        this.controller = controller;
    }

    public abstract void onButtonOne();

    public abstract void onButtonTwo();

    public abstract void setStateStandard();

    public abstract void setStateVariables();

    public abstract void setStateOperations();
    
    public abstract void setStateTranscendetal();
    
}
