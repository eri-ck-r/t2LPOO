/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package main;

public final class MenuOption
{
    private String label;
    private ConsoleOperation op;

    static final String[] game_menu = {
        "Editar cena;",  // "Obtenção" de uma cena
        "Editar todas as cenas;",
        "Adicionar cena;",
        "Carregar cena de arquivo;",
        "Escrever cena em arquivo;",
        "Remover cena;",
        "Remover todas as cenas;",
        "Exibir jogo;",
        "Sair."
    };

    static final String[] scene_menu = {
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

    static final String[] object_menu = {
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

    static final String[] component_menu = {
        "Obter classe;",  // Faz sentido?
        "Inspecionar;",
        "Voltar;",
        "Sair."
    };

    public MenuOption(String s, ConsoleOperation op)
    {
        label = s;
        this.op = op;
    }

    public String getLabel()
    {
        return label;
    }

    public ConsoleOperation getOperation()
    {
        return op;
    }

}  // MenuOption