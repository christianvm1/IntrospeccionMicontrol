/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introspeccionmicontrol;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import jdk.nashorn.internal.objects.NativeDebug;
import miscontroles.MiControl;

/**
 *
 * @author chris
 */
public class IntrospeccionMiControl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MiControl micontrol = new MiControl();
        System.out.println("La clase a la que pertenece micontrol es: " + micontrol.getClass());
        
        Class c1 = micontrol.getClass();
        
        muestraLosCampos(c1);
        muestraLosConstructores(c1);
        muestraLosMetodos(c1);
        
        
    }

    private static void muestraLosConstructores(Class c1) {
        Constructor[] constructores = c1.getDeclaredConstructors();
        System.out.println("Los constructores de la clase son: ");
        
        for(Constructor c: constructores)
        {
            String nombre = c.getName();
            System.out.print("  " + Modifier.toString(c.getModifiers()));
            System.out.print("  " + nombre + "(");
            Class[] tipoParams = c.getParameterTypes();
            
            
            for(int i = 0; i < tipoParams.length; i++)
            {
                if(i > 0) System.out.print(", ");
                System.out.print(tipoParams[i].getTypeName() + " ");
                System.out.print(tipoParams[i].getName());
            }
            System.out.println(")");
        }
    }

    private static void muestraLosMetodos(Class c1) {
        Method[] metodos = c1.getDeclaredMethods();
        
        System.out.println("Los métodos de la clase son: ");
        
        for(Method m: metodos)
        {
            String nombre = m.getName();
            System.out.print("  " + Modifier.toString(m.getModifiers()));
            System.out.print("  " + nombre + "(");
            Class[] tipoParams = m.getParameterTypes();
            
            for(int i = 0; i < tipoParams.length; i++)
            {
                if(i > 0) System.out.print(", ");
                System.out.print(tipoParams[i].getTypeName() + " ");
                System.out.print(tipoParams[i].getName());
            }
            System.out.println(")");
        }
    }

    private static void muestraLosCampos(Class c1) {
        Field[] campos = c1.getDeclaredFields();
        System.out.println("Los campos de la clase son: ");
        
        for(Field c: campos)
        {
            String nombre = c.getName();
            System.out.print("  " + Modifier.toString(c.getModifiers()));
            System.out.print("  " + c.getType().toString());
            System.out.print("  " + nombre + "\n");
        }
    }
    
}
