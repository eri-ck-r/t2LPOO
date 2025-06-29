package t2;

public class GameObject
{
    protected String name;
    private Scene scene;
    private GameObject parent;
    private GameObjectList children;
    private ComponentList components;

    public GameObject()
    {
        children = new GameObjectList();
        components = new ComponentList();
        components.add(new Transform(this));
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

    public boolean addComponent(Component component)
    {
        String newCompType = component.getName();
        for (Component c : components)
        {
            if(c.getName().equals(newCompType))
            {
                System.out.println(newCompType+" already exists");
                return false;
            }
        }
        return components.add(component);
    }

    public boolean removeComponent(String name)
    {
        return components.removeComponent(name);
    }

    public void removeAllComponents()
    {
        Component transform = components.get(0);
        components.clear();
        components.add(transform);
    }
}
