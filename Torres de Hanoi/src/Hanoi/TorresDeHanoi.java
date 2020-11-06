package Hanoi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase que se encarga de la logica del juego torres de hanoi
 * 
 */
public class TorresDeHanoi implements Serializable {

    
    String cadena;
    ArrayList<String> cadenas;
    //guarda el numero de pasos completos
    int contador;

    public TorresDeHanoi() {
        cadena = "";
        cadenas= new ArrayList<>();
        contador=0;
    }

    
    public void hanoi(int num, int inicio, int auxiliar, int fin) throws IOException {
        if (num == 1) {
            cadena = "MOVER DE LA TORRE " + inicio + " A LA TORRE " + fin;
            contador++;
            cadenas.add(cadena);
            
        } else {
            hanoi(num - 1, inicio, fin, auxiliar);
            cadena = "MOVER DE LA TORRE " + inicio + " A LA TORRE " + fin;
            contador++;
            cadenas.add(cadena);
            
            hanoi(num - 1, auxiliar, inicio, fin);
        }
    }

    public void guardarSolucion(File guarda) throws IOException {
        PrintWriter salida=null;
        try{
            FileWriter fileWriter = new FileWriter(guarda+".txt");
            salida = new PrintWriter(fileWriter);
             
            for (String cad : cadenas){
                salida.println(cad);
                salida.println();
            }
            
        }finally{
            if (salida != null){
                salida.close();
            }
        }
        
    }
    
    /**
     * Meotodo para verificar si ya acabo el juego
     * @param n
     * @param numeroArosTorre3
     * @return 
     */
    public boolean verificarFinalJuego(int n, int numeroArosTorre3){
        
        return n==numeroArosTorre3;
    }

    /**
     * Metodo que retorna el minimo de movimientos segun el numero de aros
     * @return 
     */
    public int getContador() {
        return contador;
    }

    /**
     * Metodo para setear el contador
     * @param contador 
     */
    public void setContador(int contador) {
        this.contador = contador;
    }
    
    
}
