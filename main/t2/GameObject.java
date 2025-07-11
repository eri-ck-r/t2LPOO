/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

import java.io.Serializable;
import java.util.function.Consumer;

public class GameObject implements NamedObject, Serializable
{
    protected String name;
    private Scene scene;
    private GameObject parent;
    private BasicList<GameObject> children;
    private ComponentList components;
    private Transform transform;
    
    public GameObject(Scene s)
    {
        scene = s;
        children = new BasicList<GameObject>();
        components = new ComponentList();
        components.add(new Transform(this));
        transform = (Transform)components.getFirst();
    }

    public GameObject(Scene s, String name)
    {
        this(s);
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void addObject(GameObject obj)
    {
        children.add(obj);
    }

    public void addObject(String name)
    {
        addObject(new GameObject(this.scene, name));
    }

    public GameObject getObject(String name)
    {
        return children.getElement(name);
    }

    public boolean removeObject(String name)
    {
        return children.removeElement(name);
    }

    // "...do tipo Transform, o qual não poderá ser
    // removido da lista de componentes de O"
    //
    // Ou seja, não dá pra deixar Transform
    // ficar independente de GameObjectList
    public void clearChildren()
    {
        children.clear();
    }

    public void forEachChildren(Consumer<GameObject> f)
    {
        children.forEach(f);
    }

    public boolean addComponent(Component component)
    {
        return components.addComponent(component);
    }

    public boolean removeComponent(String name)
    {
        return components.removeComponent(name);
    }

    public void clearComponents()
    {
        var transform = components.getFirst();
        components.clear();
        components.add(transform);
    }

    /**
     *
     * @param v New position
     * @param allChildren True to apply new offset to all children
     */
    public void changePosition(Vector3 v, boolean allChildren)
    {
        Vector3 dPos = v.sub(transform.getPosition());
        transform.setPosition(v);
        if(allChildren)
        {
            for (GameObject child : children)
            child.transform.setPosition(dPos);
        }
    }
    
    /**
     *
     * @param v New rotation
     * @param allChildren True to apply new rotation offset to all children
     */
    public void changeRotation(Vector3 v, boolean allChildren)
    {
        Vector3 dRotation = v.sub(transform.getRotation());
        transform.setRotation(v);
        if(allChildren)
        {
            for(GameObject child : children)
            child.transform.setRotation(dRotation);
        }
    }
    
    /**
     *
     * @param s New scale
     * @param allChildren True to apply new scale to all children
     */
    public void changeScale(double s, boolean allChildren)
    {
        transform.setScale(s);
        if(allChildren)
        {
            for(GameObject child : children)
                child.transform.setScale(s);
            }
    }

    public void display(String s)
    {
        System.out.println(s + "Object name: "+name);
        System.out.println(s + "{");
        String aux = s + "  ";
        System.out.println(s + "Parent: " + (parent != null ? parent.getName() : "null"));
        System.out.println(aux + "Components:");
        System.out.println(aux + "{");
        
        components.forEach( c -> {c.display(aux);});
        
        System.out.println(aux + "}");
        System.out.println(aux + "Children:");
        System.out.println(aux + "{");
        
        children.forEach( o -> {o.display(aux + "  ");});
    
        System.out.println(aux + "}");
        System.out.println(s + "}");
    }
}
