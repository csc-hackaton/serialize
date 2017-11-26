package version;

import java.io.*;
import serialize.iulian.com.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void serialize(Object o, String filename){
        try {
            FileOutputStream fileOut =  new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(o);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in %s\n",filename);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    static void deserialize(Employee p, String filename){
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            p = p.getClass().cast(in.readObject());
            in.close();
            fileIn.close();
            System.out.println(p);
        } catch (InvalidClassException e){
            e.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Person class not found");
            c.printStackTrace();
        }
    }
    public static void main( String[] args )
    {
        Employee e =new Employee();
//      serialize(e,"employeev3.ser");
       deserialize(e,"employeev1.ser");
//        deserialize(e,"employeev2.ser");
//        deserialize(e,"employeev3.ser");
    }
}
