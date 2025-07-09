/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

public class GameObject implements NamedObject
{
    protected String name;
    private Scene scene;
    private GameObject parent;
    private GameObjectList children;
    private ComponentList components;
    private Transform transform;  // e pode?

    public GameObject(Scene s)
    {
        scene = s;
        children = new GameObjectList();
        components = new ComponentList();
        transform = new Transform(this);
        components.add(transform);  // Não entendi
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
    public void removeAllObjects()
    {
        children.clear();
    }

    public void forEach()
    {
        //TODO
    }

    public void display(String s)
    {
        System.out.println(s + "    Object name: "+name);
        s = s + "  ";
        System.out.println(s + "  {");
        if(parent != null)
            System.out.println(s + "    Parent: " + parent.getName());
        System.out.println(s + "    Components:");
        System.out.println(s + "    {");
        for(Component c : components)
            c.display(s);
        System.out.println(s + "    }");
        System.out.println(s + "    Children:");
        System.out.println(s + "    {");
        for(GameObject obj : children)
            obj.display(s + "  ");
        System.out.println(s + "    }");
        System.out.println(s + "  }");
    }

    public boolean addComponent(Component component)
    {
        return components.addComponent(component);
    }

    public boolean removeComponent(String name)
    {
        return components.removeComponent(name);
    }

    public void removeAllComponents()
    {
        Component transform = components.getFirst();
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
        // TODO mudar para todos os objetos filho desse com o offset desse
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
        // TODO mudar para todos os objetos filho desse com o offset desse
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
        // TODO mudar para todos os objetos filhos
        transform.setScale(s);
        if(allChildren)
        {
            for(GameObject child : children)
                child.transform.setScale(s);
        }
    }
}
