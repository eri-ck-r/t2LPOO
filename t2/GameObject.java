package t2;

public class GameObject
{
    protected String name;
    private Scene scene;
    private GameObject parent;
    private GameObjectList children;
    private ComponentList components;
    private Transform transform;

    public GameObject()
    {
        children = new GameObjectList();
        components = new ComponentList();
        transform = new Transform(this);
        components.add(transform);
    }
    public GameObject(String name)
    {
        this.name = name;
    }

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

    public void removeAllObjects()
    {
        children.clear();
    }

    public void forEach()
    {
        //TODO
    }

    public void display()
    {
        System.out.println("Object name: "+name);
        if(parent != null)
            System.out.println(name+"'s parent: "+parent.getName());
        System.out.println(name+"'s "+components.size()+" components");
        for(Component c : components)
            c.display();
        System.out.println(name+"'s "+children.size()+" children: ");
        for(GameObject obj : children)
            obj.display();

    }

    public void addComponent(Component component)
    {
        String newCompType = component.getName();
        for (Component c : components)
        {
            if(c.getName().equals(newCompType))
            {
                System.out.println(newCompType+" already exists");
                return;
            }
        }
        components.add(component);
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
