/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Rafael
 */
public class ComponentesPrograma {
    //JPanel localizado onde está os campos e percorrer entre eles para limpar.
    public void LimpaTela (JPanel container) {
        Component components[] = container.getComponents();
        for (Component component : components ) {
            if(component instanceof JTextField){
                ((JTextField) component).setText(null);
            }
        }
    }
    
}
