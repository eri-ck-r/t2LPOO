//package main;

import java.io.*;

public class ObjectReader
{
    public static Object read()
    {
        Object o = new Object();
        try(FileInputStream in = new FileInputStream("object.ser");
            ObjectInputStream objin = new ObjectInputStream(in))
        {
            System.out.println("!!!!");
            o = objin.readObject();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return o;
    }

    public static void main(String[] args)
    {
        Object s = ObjectReader.read();
        System.out.println(((teste_ser)s).getName());
    }
}