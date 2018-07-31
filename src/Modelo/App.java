/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Controlador;
import Vista.Vista;

/**
 *
 * @author Marco
 */
public class App {
    
    public static void main (String args []){
        Vista vis = new Vista();
        Modelo mode = new Modelo();
        Controlador cont;
        cont = new Controlador(vis, mode);
    }
}
