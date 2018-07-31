/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JOptionPane;

/**
 *
 * @author Marco
 */
public class Vista {    
    public int menu(){                
        return Integer.parseInt(JOptionPane.showInputDialog("1. Nombre de todos los estudiantes \n 2. Consultar estudiante \n 3. Salir"));               
    }
    public int pedirInt(){
        return Integer.parseInt(JOptionPane.showInputDialog("Ingrese cedula a consultar"));
    }
    public void mostrar(String cadena) {
        JOptionPane.showConfirmDialog(null, cadena);
    }
}
