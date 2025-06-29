package t2;

public class GameObject
{
    protected String name;
    private GameObject parent;
    private GameObjectList children;
    private ComponentList components;

    public GameObject(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
