package main;
    
import java.io.Serializable;

public class teste_ser implements Serializable {
    private String name;
    private int value;

    public teste_ser(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // Getters and setters (optional, but good practice)
    public String getName() { return name; }
    public int getValue() { return value; }
}