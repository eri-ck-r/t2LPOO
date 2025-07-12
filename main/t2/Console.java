/**
 *
 * @author Erick Rodrigues de Lemos Ribeiro
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

import java.io.*;
import java.util.*;
import t2.Camera.CameraType;
import t2.Light.LightType;


public class Console
{
    static GameEngine engine;
    static Game currGame;
    static Scene currScene;
    static GameObject currGameObject;
    static Component currComponent;

    static Scanner sc = new Scanner(System.in);

    static final String[] engine_menu = {
        "Edit game;", 
        "Add game;",
        "Remove game;",
        "Remove all games;",
        "Show games;",
        "Exit."
    };

    static final String[] game_menu = {
        "Edit scene;",  // "Obtenção" de uma cena
        "Add scene;",
        "Read scene from file;",
        "Write scene in file;",
        "Remove scene;",
        "Remove all scenes;",
        "Show game;",
        "Return;",
        "Exit."
    }; 

    static final String[] scene_menu = {
        "Get name;",
        "Edit name;",
        "Add object;",
        "Remove object;",
        "Remove all objects",
        "Edit object;",
        "Display scene;",
        "Return;",
        "Exit."
    };

    static final String[] object_menu = {
        "Get name;",
        "Edit name;",
        "Add child object;",
        "Remove child object;",
        "Remove all child objects",
        "Edit child object;",
        "Edit component;",
        "Add component;",
        "Remove component;",
        "Remove all components;",
        "Display object;",
        "Return;",
        "Exit."
    };

    static final String[] component_menu = {
        "Get class;",
        "Edit attributes;",
        "Inspect;",
        "Return;",
        "Exit."
    };

    static final String[] transform_menu = {
        "Edit position;",
        "Edit rotation;",
        "Edit scale;",
        "Return;",
        "Exit."
    };
    
    static final String[] mesh_menu = {
        "Edit name;",
        "Edit material;",
        "Return;",
        "Exit."
    };

    static final String[] light_menu = {
        "Edit color;",
        "Edit type;",
        "Return;",
        "Exit."
    };

    static final String[] light_type_menu = {
        "Punctual;",
        "Directional."
    };

    static final String[] camera_menu = {
        "Edit type;",
        "Edit angle;",
        "Edit clipping planes distance;",
        "Return;",
        "Exit."
    };
    
    static final String[] camera_type_menu = {
        "Parallel;",
        "Perspective."
    };
    
    static private String[] currMenu = engine_menu;

    public Console(GameEngine engine)
    {
        Console.engine = engine;
    }

    public Console()
    {
        this(new GameEngine());
    }

    public void clearTerminal()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush(); // Ensures the output is sent to the console ("terminal") immediately
    }
    
    public void terminalInterface()
    {
        boolean exit = false;
        while(!exit)
        {
            clearTerminal();
            if(currMenu == engine_menu)
                showMenu(currMenu, "Engine");
            else if(currMenu == game_menu)
                showMenu(currMenu, "Game: " + currGame.getName());
            else if(currMenu == scene_menu)
                showMenu(currMenu, "Scene: " + currScene.getName());
            else if(currMenu == object_menu)
                showMenu(currMenu, "Object: " + currGameObject.getName());
            else // if(currMenu == component_menu)
                showMenu(currMenu, "Component: " + currComponent.getName());
            exit = nextMenuSelector();
        }
    }
    
    public void showMenu(String[] options, String type)
    {
        System.out.println("-------------- " + type + " --------------");
        for(int j = 0; j < options.length; ++j)
        {
            System.out.printf("%d - %s\n", j+1, options[j]);
        }
        System.out.printf("Choose: ");
    }

    private boolean nextMenuSelector()
    {
        String i = sc.nextLine();
        //sc.nextLine();

        if(currMenu == engine_menu)
            return engineMenuOptions(i);

        else if(currMenu == game_menu)
            return gameMenuOptions(i);

        else if(currMenu == scene_menu)
            return sceneMenuOptions(i);

        else if(currMenu == object_menu)
            return objectMenuOptions(i);

        else if(currMenu == component_menu)
            return componentMenuOptions(i);

        else if(currMenu == transform_menu)
            return transformMenuOptions(i);

        else if(currMenu == mesh_menu)
            return meshMenuOptions(i);

        else if(currMenu == light_menu)
            return lightMenuOptions(i);

        else if(currMenu == light_type_menu)
            return lightTypeMenuOptions(i);

        else if(currMenu == camera_menu)
            return cameraMenuOptions(i);

        else // if(currMenu == camera_type_menu)
            return cameraTypeMenuOptions(i);
    }

    private boolean engineMenuOptions(String i)
    {
        switch(i)
        {
            case "1" ->             
            {
                String gameToEdit = getInputName("game");
                Game temp = engine.getGame(gameToEdit);
                if(temp != null)
                {
                    currMenu = game_menu;
                    currGame = temp;
                }
                else
                {
                    System.out.println(gameToEdit + " not found!");
                    pause();
                }
            }

            case "2" ->             
            {
                engine.addGame(getInputName("game"));
            }

            case "3" ->             
            {
                String gameToEdit = getInputName("game");
                    if(engine.removeGame(gameToEdit))
                    System.out.println("Successfully removed!");
                else
                    System.out.println(gameToEdit + " not found!");
                pause();
            }

            case "4" ->             
            {
                engine.clear();
            }

            case "5" ->             
            {
                engine.display();
                sc.nextLine();
            }

            case "6" -> 
            {
                return true;
            }

            default ->
            {
                System.out.println("Invalid number!");
                pause();
            }
        }
        return false;
    }

    private boolean gameMenuOptions(String i)
    {
        switch(i)
        {
            case "1" ->
            {
                String sceneToEdit = getInputName("scene");
                Scene temp = currGame.getScene(sceneToEdit);
                if(temp != null)
                {
                    currMenu = scene_menu;
                    currScene = temp;
                }
                else
                {
                    System.out.println(sceneToEdit + " not found!");
                    pause();
                }
            }

            case "2" ->
            {
                currGame.addScene(getInputName("scene"));
            }

            case "3" ->
            {
                String fileName = getInputName("file");
                try(FileInputStream in = new FileInputStream(fileName);
                    ObjectInputStream objIn = new ObjectInputStream(in))
                {
                    currGame.addScene((Scene)objIn.readObject());
                }
                catch(IOException | ClassNotFoundException e)
                {
                    System.out.println(e.getMessage());
                    pause();
                }
            }

            case "4" ->
            {
                String fileName = getInputName("file");
                try(FileOutputStream out = new FileOutputStream(fileName);
                    ObjectOutputStream objOut = new ObjectOutputStream(out))
                {
                    String sceneToWrite = getInputName("scene");
                    Scene temp = currGame.getScene(sceneToWrite);
                    if(temp != null)
                        objOut.writeObject(currGame.getScene(sceneToWrite));
                    else
                        System.out.println(sceneToWrite + " not found!");
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }

            case "5" ->
            {
                String editScene = getInputName("scene");
                if(currGame.removeScene(editScene))
                    System.out.println("Successfully removed!");
                else
                    System.out.println(editScene + " not found!");
                pause();
            }

            case "6" ->
            {
                currGame.clearScenes();
            }

            case "7" ->
            {
                currGame.display();
                sc.nextLine();
            }

            case "8" ->
            {
                currMenu = engine_menu;
            }

            case "9" ->
            {
                return true;
            }

            default ->
            {
                System.out.println("Invalid number!");
                pause();
            }
        }
            return false;
    }

    private boolean sceneMenuOptions(String i)
    {
        switch(i)
        {
            case "1" ->
            {
                System.out.println(currScene.getName());
            }

            case "2" ->
            {
                String newName = getInputName("new scene's");
                currScene.setName(newName);
            }

            case "3" ->
            {
                String newObj = getInputName("object");
                currScene.addObject(newObj);
            }

            case "4" ->
            {
                String removeObj = getInputName("object");
                currScene.removeObject(removeObj);
            }

            case "5" ->
            {
                currScene.clear();
            }

            case "6" ->
            {
                String editObj = getInputName("object");
                GameObject temp = currScene.getObject(editObj);
                if(temp != null)
                {
                    currMenu = object_menu;
                    currGameObject = temp;
                }
                else
                {
                    System.out.println(editObj + " not found!");
                    pause();
                }
            }

            case "7" ->
            {
                currScene.display("");
                sc.nextLine();
            }

            case "8" ->
            {
                currMenu = game_menu;
            }

            case "9" ->
            {
                return true;
            }

            default ->
            {
                System.out.println("Invalid number!");
                pause();
            }
        }
        return false;
    }

    private boolean objectMenuOptions(String i)
    {
        switch(i)
        {
            case "1" ->
            {
                System.out.println(currGameObject.getName());
            }

            case "2" ->
            {
                String newName = getInputName("object");
                currGameObject.setName(newName);
            }

            case "3" ->
            {
                String newName = getInputName("new object's");
                currGameObject.addObject(newName);
            }

            case "4" ->
            {
                String objName = getInputName("object");
                currGameObject.removeObject(objName);
            }

            case "5" ->
            {
                currGameObject.clearChildren();
            }

            case "6" ->
            {
                String editObj = getInputName("object");
                GameObject temp = currGameObject.getObject(editObj);
                if(temp != null)
                {
                    currGameObject = temp;
                }
                else
                {
                    System.out.println(editObj + " not found!");
                    pause();
                }
            }

            case "7" ->
            {
                String editComp = getInputName("component's class");
                Component temp = currGameObject.getComponent(editComp);
                if(temp != null)
                {
                    currMenu = component_menu;
                    currComponent = temp;
                }
                else
                {
                    System.out.println(editComp + " not found!");
                    pause();
                }
            }

            case "8" ->             
            {
                String newComponent = getInputName("component");
                switch(newComponent)    
                {   
                    case("Mesh") ->
                    {
                        currGameObject.addComponent(new Mesh(currGameObject));
                    }
                    case("Light") ->
                    {
                        currGameObject.addComponent(new Light(currGameObject));
                    }
                    case("Camera") ->
                    {
                        currGameObject.addComponent(new Camera(currGameObject));
                    }
                }
            }

            case "9" ->
            {
                currGameObject.removeComponent(getInputName("component"));
            }

            case "10" ->
            {
                currGameObject.clearComponents();
            }

            case "11" ->
            {
                currGameObject.display("");
                sc.nextLine();
            }

            case "12" ->
            {
                if(currGameObject.isChild())    
                    currGameObject = currGameObject.getParent();
                else
                    currMenu = scene_menu;
            }

            case "13" ->
            {
                return true;
            }

            default ->
            {
                System.out.println("Invalid number!");
                pause();
            }
        }
        return false;
    }

    private boolean componentMenuOptions(String i)
    {
        switch(i)
        {
            case "1" ->
            {
                currComponent.getClass();
            }

            case "2" ->
            {
                String type = currComponent.getName();
                switch(type)
                {
                    case "Transform" ->
                    {
                        currMenu = transform_menu;
                    }
                    case "Mesh" ->
                    {
                        currMenu = mesh_menu;
                    }
                    case "Light" ->
                    {
                        currMenu = light_menu;
                    }
                    case "Camera" ->
                    {
                        currMenu = camera_menu;
                    }
                }
            }

            case "3" ->
            {
                currComponent.displayAttributes("");
                sc.nextLine();
            }

            case "4" ->
            {
                currMenu = object_menu;
            }

            case "5" ->
            {
                return true;
            }

            default ->
            {
                System.out.println("Invalid number!");
                pause();
            }
        }
        return false;
    }

    private boolean transformMenuOptions(String i)
    {
        boolean forEveryChild = false;
        switch(i)
        {
            case "1" ->
            {
                Vector3 newPos = new Vector3();
                double coord;
                System.out.printf("Type the new position: ");
                for(int j = 0; j < 3; ++j)
                {
                    coord = sc.nextDouble();
                    newPos.set(j, coord);
                }
                currGameObject.changePosition(newPos, forEveryChild);
            }
            case "2" ->
            {
                Vector3 newRot = new Vector3();
                double coord;
                System.out.printf("Type the new rotation: ");
                for(int j = 0; j < 3; ++j)
                {
                    coord = sc.nextDouble();
                    newRot.set(j, coord);
                }
                currGameObject.changeRotation(newRot, forEveryChild);
            }
            case "3" ->
            {
                System.out.printf("Type the new scale: ");
                currGameObject.changeScale(sc.nextDouble(), forEveryChild);
            }
            case "4" ->
            {
                currMenu = component_menu;
            }
            case "5" ->
            {
                return true;
            }
            default ->
            {
                System.out.println("Invalid number!");
                pause();
            }
        }
        return false;
    }

    private boolean meshMenuOptions(String i)
    {
        switch(i)
        {
            case "1" ->
            {
                String newName = getInputName("new");
                ((Mesh)currComponent).setLabel(newName);
            }
            case "2" ->
            {
                String newMaterial = getInputName("new material's");
                ((Mesh)currComponent).setMaterial(newMaterial);
            }
            case "3" ->
            {
                currMenu = component_menu;
            }
            case "4" ->
            {
                return true;
            }
            default ->
            {
                System.out.println("Invalid number!");
                pause();
            }
        }
        return false;
    }

    private boolean lightMenuOptions(String i)
    {
        switch(i)
        {
            case "1" ->
            {
                int[] color = new int[3];
                System.out.printf("Type the new color: ");
                for(int j = 0; j < 3; ++j)
                {
                    color[j] = sc.nextInt();
                }
                
                ((Light)currComponent).setColor(new Color(color[0], color[1], color[2]));
            }
            case "2" ->
            {
                currMenu = light_type_menu;
            }
            case "3" ->
            {
                currMenu = component_menu;
            }
            case "4" ->
            {
                return true;
            }
            default ->
            {
                System.out.println("Invalid number!");
                pause();
            }
        }
        return false;
    }

    private boolean lightTypeMenuOptions(String i)
    {
        switch(i)
        {
            case "1" ->
            {
                ((Light)currComponent).setType(LightType.PUNCTUAL);
                currMenu = light_menu;

            }
            case "2" ->
            {
                ((Light)currComponent).setType(LightType.PUNCTUAL);
                currMenu = light_menu;
            }
            default ->
            {
                System.out.println("Invalid number!");
                pause();
            }
        }
        return false;
    }

    private boolean cameraMenuOptions(String i)
    {
        switch(i)
        {
            case "1" ->
            {
                currMenu = camera_type_menu;
            }
            case "2" ->
            {
                System.out.printf("Type the new angle: ");
                ((Camera)currComponent).setAngle(sc.nextDouble());
            }
            case "3" ->
            {
                System.out.printf("Type the new distance (two values): ");
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                ((Camera)currComponent).setPlaneDist(x, y);
            }
            case "4" ->
            {
                currMenu = component_menu;
            }
            case "5" ->
            {
                return true;
            }
            default ->
            {
                System.out.println("Invalid number!");
                pause();
            }
        }
        return false;
    }

    private boolean cameraTypeMenuOptions(String i)
    {
        switch(i)
        {
            case "1" ->
            {
                ((Camera)currComponent).setType(CameraType.PARALLEL);
                currMenu = camera_menu;
            }
            case "2" ->
            {
                ((Camera)currComponent).setType(CameraType.PERSPECTIVE);
                currMenu = camera_menu;
            }
            default ->
            {
                System.out.println("Invalid number!");
                pause();
            }
        }
        return false;
    }

    static public String getInputName(String s)
    {
        System.out.printf("Type the %s name: ", s);
        return sc.nextLine();
    }

    static private void pause()
    {
        try
        {
            Thread.sleep(700);
        }
        catch(InterruptedException e)
        {
            System.out.println("Unable to pause. " + e.getMessage());
        }
    }

}   // Console
