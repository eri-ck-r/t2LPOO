/**
 *
 * @author Erick Rodrigues de Lemos Ribeiro
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

import java.util.*;
import java.io.*;


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
        "Edit Transform;",
        "Add component;",
        "Remove component;",
        "Remove all components;",
        "Display object;",
        "Return;",
        "Exit."
    };

    static final String[] component_menu = {
        "Get class;",
        "Inspect;",
        "Return;",
        "Exit."
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
            showMenu(currMenu);
            exit = nextMenuSelector();
        }

    }
    
    public void showMenu(String[] options)
    {
        msgMenuHeader();
        for(int j = 0; j < options.length; ++j)
        {
            System.out.printf("%d - %s\n", j+1, options[j]);
        }
        System.out.printf("Choose: ");
    }

    private boolean nextMenuSelector()
    {
        int i = sc.nextInt();
        sc.nextLine();

        if(currMenu == engine_menu)
            return engineMenuOptions(i);

        else if(currMenu == game_menu)
            return gameMenuOptions(i);

        else if(currMenu == scene_menu)
            return sceneMenuOptions(i);

        else if(currMenu == object_menu)
            return objectMenuOptions(i);

        else  // if(currMenu == component_menu)
            return componentMenuOptions(i);
    }

    private boolean engineMenuOptions(int i)
    {
        switch(i)
        {
            case 1:
            {
                String sceneToEdit = getInputName();
                Game temp = engine.getGame(sceneToEdit);
                if(temp != null)
                {
                    currMenu = game_menu;
                    currGame = temp;
                }
                else
                {
                    System.out.println(sceneToEdit + " not found!");
                    pause();
                }
                break;
            }

            case 2:
            {
                engine.addGame(getInputName());
                break;
            }

            case 3:
            {
                String sceneToEdit = getInputName();
                if(engine.removeGame(sceneToEdit))
                    System.out.println("Successfully removed!");
                else
                    System.out.println(sceneToEdit + " not found!");
                pause();
                break;
            }

            case 4:
            {
                engine.clear();
                break;
            }

            case 5:
            {
                engine.display();
                sc.nextLine();
                break;
            }
            case 6:
            {
                return true;
            }

            default:
            {
                System.out.println("Invalid " + "number" + "!");
                pause();
            }
        }
        return false;
    }

    private boolean gameMenuOptions(int i)
    {
        switch(i)
        {
            case 1:
            {
                String sceneToEdit = getInputName();
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
                break;
            }

            case 2:
            {
                currGame.addScene(getInputName());
                break;
            }

            case 3:
            {
                String file_name = getInputName();
                try(FileInputStream in = new FileInputStream(file_name);
                ObjectInputStream objIn = new ObjectInputStream(in))
                {
                    currGame.addScene((Scene)objIn.readObject());
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
                break;
            }

            case 4:
            {
                String fileName = getInputName();
                try(FileOutputStream out = new FileOutputStream(fileName);
                ObjectOutputStream objOut = new ObjectOutputStream(out))
                {
                    String scene_to_write = getInputName();
                    Scene temp = currGame.getScene(scene_to_write);
                    if(temp != null)
                        objOut.writeObject(currGame.getScene(scene_to_write));
                    else
                        System.out.println(scene_to_write + " not found!");
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
                break;
            }

            case 5:
            {
                String editScene = getInputName();
                if(currGame.removeScene(editScene))
                    System.out.println("Successfully removed!");
                else
                    System.out.println(editScene + " not found!");
                pause();
                break;
            }

            case 6:
            {
                currGame.clearScenes();
                break;
            }

            case 7:
            {
                currGame.display();
                sc.nextLine();
                break;
            }

            case 8:
            {
                currMenu = engine_menu;
                break;    
            }

            case 9:
            {
                return true;
                   
            }

            default:
            {
                System.out.println("Invalid " + "number" + "!");
                pause();
            }
        }
            return false;
    }

    private boolean sceneMenuOptions(int i)
    {
        switch(i)
        {
            case 1:
            {
                System.out.println(currScene.getName());
                break;
            }

            case 2:
            {
                String newName = getInputName();
                currScene.setName(newName);
                break;
            }

            case 3:
            {
                String newObj = getInputName();
                currScene.addObject(newObj);
                break;
            }

            case 4:
            {
                String removeObj = getInputName();
                currScene.removeObject(removeObj);
                break;
            }

            case 5:
            {
                currScene.clear();
                break;
            }

            case 6:
            {
                String editObj = getInputName();
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
                break;
            }

            case 7:
            {
                currScene.display("");
                sc.nextLine();
                break;
            }

            case 8:
            {
                currMenu = game_menu;
                break;
            }

            case 9:
                return true;

            default:
            {
                System.out.println("Invalid " + "number" + "!");
                pause();
            }
        }
        return false;
    }

    private boolean objectMenuOptions(int i)
    {
        switch(i)
        {
            case 1:
            {
                System.out.println(currGameObject.getName());
                break;
            }

            case 2:
            {
                String newName = getInputName();
                currGameObject.setName(newName);
                break;
            }

            case 3:
            {
                String newName = getInputName();
                currGameObject.addObject(newName);
                break;
            }

            case 4:
            {
                String objName = getInputName();
                currGameObject.removeObject(objName);
                break;
            }

            case 5:
            {
                currGameObject.clearChildren();
                break;
            }

            case 6:
            {
                String editObj = getInputName();
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
                break;
            }

            case 7:
            {
                System.out.println("1. Edit Position;");
                System.out.println("2. Edit Rotation;");
                System.out.println("3. Edit Scale;");
                System.out.print("Select: ");
                int opt = sc.nextInt();

                switch(opt)
                {
                    case 1:
                    {
                        Vector3 newPos = new Vector3();
                        double coord;
                        System.out.println("Type the new position: ");
                        coord = sc.nextDouble();
                        newPos.set(0, coord);
                        coord = sc.nextDouble();
                        newPos.set(1, coord);
                        coord = sc.nextDouble();
                        newPos.set(2, coord);
                        currGameObject.changePosition(newPos, false);
                        break;
                    }

                    case 2:
                    {
                        Vector3 newRot = new Vector3();
                        double coord;
                        System.out.println("Type the new rotation: ");
                        coord = sc.nextDouble();
                        newRot.set(0, coord);
                        coord = sc.nextDouble();
                        newRot.set(1, coord);
                        coord = sc.nextDouble();
                        newRot.set(2, coord);
                        currGameObject.changeRotation(newRot, false);
                        break;
                    }

                    case 3:
                    {
                        System.out.println("Type the new scale: ");
                        currGameObject.changeScale(sc.nextInt(), false);
                        break;
                    }

                    default:
                    {
                        System.out.println("Invalid " + "number" + "!");
                        pause();
                        break;
                    }
                }
                break;
            }

            case 8:
            {
                String newComponent = getInputName();
                switch(newComponent)    
                {   
                    case("Mesh"):
                        currGameObject.addComponent(new Mesh(currGameObject));
                    case("Light"):
                        currGameObject.addComponent(new Light(currGameObject));
                    case("Camera"):
                        currGameObject.addComponent(new Camera(currGameObject));
                }
                break;
            }

            case 9:
            {
                currGameObject.removeComponent(getInputName());
                break;
            }

            case 10:
            {
                currGameObject.clearComponents();
                break;
            }

            case 11:
            {
                currGameObject.display("");
                sc.nextLine();
                break;
            }

            case 12:
            {
                currMenu = scene_menu;
                break;
            }

            case 13:
            {
                return true;
            }

            default:
            {
                System.out.println("Invalid " + "number" + "!");
                pause();
            }
        }
        return false;
    }

    private boolean componentMenuOptions(int i)
    {
        switch(i)
        {
            case 1:
            {
                currComponent.getClass();
                break;
            }

            case 2:
            {
                currComponent.displayAttributes("");
                sc.nextLine();
                break;
            }

            case 3:
            {
                currMenu = object_menu;
                break;
            }

            case 4:
            {
                return true;
            }

            default:
            {
                System.out.println("Invalid " + "number" + "!");
                pause();
            }
        }
        return false;
    }

    static public String getInputName()
    {
        System.out.printf("Type the name: ");
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

    static private void msgMenuHeader()
    {
        System.out.println("-------------- Game Engine --------------");

    }

}   // Console
