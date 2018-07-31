/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.RandomAccessFile;

/**
 *
 * @author Marco
 */
public class Modelo {
    RandomAccessFile estu;
    RandomAccessFile cursos;
    RandomAccessFile matricula;
    String cadena;
    int temp, cod,t;
    public void crear(){
        try {
            //creacion archivos            
            estu = new RandomAccessFile("ListaEstudiantes.txt", "rw");
            cursos = new RandomAccessFile("Cursos.txt", "rw");
            matricula = new RandomAccessFile("Matricula.txt", "rw");
            //ingresar informacion en los archivos
            //estudiantes
            estu.seek(0);
            estu.writeInt(789); estu.writeUTF("Alberto Boj Garcia  "); estu.writeInt(18);
            estu.writeInt(654); estu.writeUTF("Amparo Ramos Torres "); estu.writeInt(17);
            estu.writeInt(159); estu.writeUTF("Antonio Box Alonso  "); estu.writeInt(19);
            estu.writeInt(357); estu.writeUTF("Armin Osterreich    "); estu.writeInt(18);
            estu.writeInt(137); estu.writeUTF("Eduardo Albaladejo  "); estu.writeInt(18);            
            //cursos
            cursos.seek(0);
            cursos.writeInt(999); cursos.writeUTF("Estadistica         ");
            cursos.writeInt(998); cursos.writeUTF("Sistemas 1          ");
            cursos.writeInt(997); cursos.writeUTF("Arte                ");
            cursos.writeInt(996); cursos.writeUTF("Literatura          ");
            cursos.writeInt(995); cursos.writeUTF("Matematicas         ");            
            //matricula
            matricula.seek(0);
            matricula.writeInt(789); matricula.writeInt(999);
            matricula.writeInt(789); matricula.writeInt(998);            
            matricula.writeInt(654); matricula.writeInt(998);
            matricula.writeInt(654); matricula.writeInt(997);
            matricula.writeInt(159); matricula.writeInt(997);
            matricula.writeInt(159); matricula.writeInt(996);
            matricula.writeInt(357); matricula.writeInt(996);
            matricula.writeInt(357); matricula.writeInt(995);
            matricula.writeInt(137); matricula.writeInt(995);
            matricula.writeInt(137); matricula.writeInt(999);            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
    public String listarEstu(){
        try {
            cadena="";
            estu.seek(0);
            estu.skipBytes(4);
            for (int i = 0; i < estu.length(); i++) {
                cadena += estu.readUTF() + "\n";
                estu.skipBytes(8);
                i=(int) estu.getFilePointer();
            }
        } catch (Exception e) {
        }    
        return cadena;
    }
    public String cursosEstu(int cedu){
        try {
            cadena="";
            estu.seek(0);
            cadena += buscarEstu(cedu)+"\n";
            matricula.seek(0);
            for (int i = 0; i < matricula.length(); i++) {                
                temp = matricula.readInt();                
                if(temp==cedu){
                    cod = matricula.readInt();
                    cadena += buscarCursos(cod) + "\n";
                }else{
                    matricula.skipBytes(4);
                }
                i = (int) matricula.getFilePointer();
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cadena;
    }
    public String buscarEstu(int cedula){
        try {            
            estu.seek(0);
            String cad; 
            for (int i = 0; i < estu.length(); i++) {                
                temp = estu.readInt();
                System.out.println("hola"+temp);
                if(temp==cedula){
                    cad = estu.readUTF();                    
                    return cad;
                }else{                    
                    estu.skipBytes(26);
                }                                
                i = (int) estu.getFilePointer();                
            }
        } catch (Exception e) {
        }
        return null;
    }
    public String buscarCursos(int cod){
        try {
            cursos.seek(0);
           for(int i=0; i<cursos.length(); i++){
               t = cursos.readInt();               
               if(t==cod){
                   return cursos.readUTF();
               }else{
                   cursos.skipBytes(22);
               }              
               i = (int) cursos.getFilePointer();
           }
        } catch (Exception e) {
        }
        return null;
    }
}
