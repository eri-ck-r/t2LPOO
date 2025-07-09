package main;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class ObjectWriter {
    public static void main(String[] args) {
        teste_ser obj = new teste_ser("@@@@@@@@@@@@", 123);

        try (FileOutputStream fileOut = new FileOutputStream("objec.ser");
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(obj);
            System.out.println("Object serialized and saved to object.se");



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}