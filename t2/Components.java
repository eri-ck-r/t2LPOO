/**
 *
 * @author Luiz Alexandre Espindola Cunha
 */

package main.t2;

public enum Components
{
  TRANSFORM(new Object() {
    private Scene.GameObject obj;  // Nao faz nada, ainda nao sei como fazer cada component saber qual obj o contem
    
    
    public Components type()
    {
      return Components.TRANSFORM;
    }
    
    public void inspect()
    {
      System.out.println(this.type());
      System.out.println(this.obj.getName());
      // imprimir os atributos
    }
  }),
  
  MESH(new Object() {
    private Scene.GameObject obj;
    
    
    public String type()
    {
      return "";
    }
    
    public void inspect()
    {
      System.out.println(this.type());
      System.out.println(this.obj.getName());
      // imprimir os atributos
    }
  }),
  
  LIGHT(new Object() {
    private Scene.GameObject obj;
    
    
    public String type()
    {
      return "";
    }
    
    public void inspect()
    {
      System.out.println(this.type());
      System.out.println(this.obj.getName());
      // imprimir os atributos
    }
  }),
  
  CAMERA(new Object() {
    private Scene.GameObject obj;
    
    
    public String type()
    {
      return "";
    }
    
    public void inspect()
    {
      System.out.println(this.type());
      System.out.println(this.obj.getName());
      // imprimir os atributos
    }
  });
  
  public void inspect()
  {
    System.out.println(this.getClass());
  }
  
  final Object comp;
  
  Components(Object comp)
  {
    this.comp = comp;
  }
  
}  // Components
