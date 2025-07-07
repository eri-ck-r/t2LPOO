/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

import java.io.*;

public class Console
{
    Game game;
    Scene currScene;
    GameObject currObject;
    Component currComponent;

    private final static InputStreamReader keyboard;
    private final static BufferedReader in;

    static
    {
        keyboard = new InputStreamReader(System.in);
        in = new BufferedReader(keyboard);
    }

    private Menu currMenu = Menu.GAME;

    private static final String[] game_menu = {
        "Editar cena;",  // "Obtenção" de uma cena
        "Editar todas as cenas;",
        "Adicionar cena;",
        //"Carregar cena de arquivo;", (?)
        //"Escrever cena em arquivo;", (?)
        "Remover cena;",
        "Remover todas as cenas;",
        "Exibir jogo;", 
        "Voltar;",
        "Sair."
    };

    private static final String[] scene_menu = {
        "Obter nome;",  // Faz sentido?
        "Editar nome;",
        "Adicionar objeto;",
        "Remover objeto;",
        "Remover todos os objetos",
        "Editar objeto;",  // Needs "show scene" invoked before to make sense
        "Editar todos os objetos;",
        "Exibir cena;",
        "Voltar;",
        "Sair."
    };

    private static final String[] object_menu = {
        "Obter nome;",  // Faz sentido?
        "Editar nome;",
        "Adicionar objeto;",
        "Remover objeto;",
        "Remover todos os objetos",
        "Editar objeto;",  // Needs "show object" invoked before to make sense
        "Editar todos os objetos;",
        "Editar componente;",
        "Adicionar componente;",
        "Remover componente;",
        "Remover todos os componentes;",
        "Exibir objeto;",
        "Voltar;",
        "Sair."
    };

    private static final String[] component_menu = {
        "Obter classe;",  // Faz sentido?
        "Inspecionar;",
        "Voltar;",
        "Sair."
    };

    public Console(Game g)
    {
        game = g;
    }

    public void clear_terminal()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush(); // Ensures the output is sent to the console ("terminal") immediately
    }

    public void key_listener()
    {
        try
        {
            int i = in.read();
            switch(currentMenu)
            {
                case Menu.GAME:
                {
                    switch(i)
                    {
                        case 0:
                        {
                            ask_name();
                            game.getScene(in.readLine());
                            
                        }
                    }
                }

            }
        }
        catch (IOException e)
        {
            System.out.println (e.getMessage());
        }

    }
    
    public void show_menu(String[] options)
    {
        System.out.println("-------------- Game Engine --------------\n\n");
        for(int j = 0; j < options.length; ++j)
        {
            System.out.printf("%d - %s\n", j, options[j]);
        }
        System.out.printf("Escolha: ");
    }

    public void ask_name()
    {
        System.out.println("Digite o nome: ");
    }

    private enum Menu
    {
        GAME,
        SCENE,
        OBJECT,
        COMPONENT
    }

}   // Console
