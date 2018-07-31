/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo;
import Vista.Vista;

/**
 *
 * @author Marco
 */
public class Controlador {
    Vista vista;
    Modelo modelo;
    public Controlador(Vista vis, Modelo mode) {
        this.modelo = mode;
        this.vista = vis;
        iniciar();
    }    
    public void iniciar(){        
        modelo.crear();
        int op=0;
        while(op!=3){
            op = vista.menu();
            switch(op){
                case 1:
                    String temp = modelo.listarEstu();
                    vista.mostrar(temp);
                    break;
                case 2:
                    int aux = vista.pedirInt();
                    String t = modelo.cursosEstu(aux);
                    vista.mostrar(t);
                    break;
                case 3:
                    
                    break;
                default:
                    break;
            }
        }
    }
}
