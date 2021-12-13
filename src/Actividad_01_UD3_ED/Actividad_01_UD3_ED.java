/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividad_01_UD3_ED;//Esto es un cometario echo por airam

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author ana
 */
public class Actividad_01_UD3_ED 
{
    private static byte[] intermedio = new byte[1000];
    private static String nombreFichero = "fichero.dat";
    private static FileInputStream intermediario = null;
    private static BufferedInputStream juanitoJuarez = null;

    public static void inicializateFiles() throws FileNotFoundException
    {
        intermediario = new FileInputStream(nombreFichero);
        juanitoJuarez = new BufferedInputStream(intermediario);
    }
    
    public static int showFileText() throws IOException
    {
        int total = 0;
        int nRead = 0;
        while((nRead = intermediario.read(intermedio)) != -1) 
        {
            System.out.println(new String(intermedio));
            total += nRead;
        }
        
        return total;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        try 
        {
            inicializateFiles();
            
            int total = showFileText();           

            System.out.println("\nLeídos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( juanitoJuarez != null && intermediario != null )
                {
                    intermediario.close();
                    juanitoJuarez.close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }
    
}
