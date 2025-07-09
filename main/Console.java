/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package main;

import java.util.*;
import java.io.*;
import t2.*;

public class Console
{
    GameEngine engine;
    Game currGame;
    Scene currScene;
    GameObject currGameObject;
    Component currComponent;

    Scanner sc = new Scanner(System.in);

    private String[] currMenu = engine_menu;


    static final String[] engine_menu = {
        "Editar jogo;", 
        "Remover jogo;",
        "Remover todos os jogos;",
        "Exibir jogos;",
        "Sair."
    };

    static final String[] game_menu = {
        "Editar cena;",  // "Obtenção" de uma cena
        "Editar todas as cenas;",
        "Adicionar cena;",
        "Carregar cena de arquivo;",
        "Escrever cena em arquivo;",
        "Remover cena;",
        "Remover todas as cenas;",
        "Exibir jogo;",
        "Voltar;",
        "Sair."
    }; 

    static final String[] scene_menu = {
        "Obter nome;",
        "Editar nome;",
        "Adicionar objeto;",
        "Remover objeto;",
        "Remover todos os objetos",
        "Editar objeto;",
        "Editar todos os objetos;",
        "Exibir cena;",
        "Voltar;",
        "Sair."
    };

    static final String[] object_menu = {
        "Obter nome;",
        "Editar nome;",
        "Adicionar objeto;",
        "Remover objeto;",
        "Remover todos os objetos",
        "Editar objeto;",
        "Editar todos os objetos;",
        "Editar componente;",
        "Adicionar componente;",
        "Remover componente;",
        "Remover todos os componentes;",
        "Exibir objeto;",
        "Voltar;",
        "Sair."
    };

    static final String[] component_menu = {
        "Obter classe;",
        "Inspecionar;",
        "Voltar;",
        "Sair."
    };

    public Console(GameEngine engine)
    {
        this.engine = engine;
    }

    public void clear_terminal()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush(); // Ensures the output is sent to the console ("terminal") immediately
    }
    
    public void key_listener()
    {
        boolean sair = false;
        while(!sair)
        {
            show_menu(currMenu);
            int i = sc.nextInt();
            if(currMenu == engine_menu)
            {
                switch(i)
                {
                    case 1:
                    {
                        String name = sc.nextLine();
                        currGame = engine.getGame(name);
                        currMenu = game_menu;
                    }
                    case 2:
                    {

                    }
                    case 3:
                    {

                    }
                    case 4:
                    {

                    }
                    case 5:
                    {

                    }
                }
            }
            else if(currMenu == game_menu)
            {
                switch(i)
                {
                    case
                }
            }
            else if(currMenu == scene_menu)
            {

            }
            else if(currMenu == object_menu)
            {

            }
            else if(currMenu == component_menu)
            {

            }
        }
        // LE O PRIMEIRO
        

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

    public String[] getMenu()
    {
        return currMenu;
    }

}   // Console
