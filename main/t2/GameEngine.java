/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

public class GameEngine
{
    private BasicList<Game> games;

    public GameEngine()
    {
        games = new BasicList<Game>();
    }

    public void addGame(Game game)
    {
        games.add(game);
    }

    public void addGame(String name)
    {
        Game newGame = new Game(name);
        addGame(newGame);
    }

    public Game getGame(String name)
    {
        return games.getElement(name);
    }

    public boolean removeGame(String name)
    {
        return games.removeElement(name);
    }

    public void clear()
    {
        games.clear();
    }

    public void display()
    {
        for(Game g : games)
        {
            g.display();
        }
    }

}  // GameEngine
