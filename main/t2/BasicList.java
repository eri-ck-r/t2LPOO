/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

import java.util.ArrayList;

public abstract class BasicList<T extends NamedObject> extends ArrayList<T> 
{
    public T getElement(String name)
    {
        for(int i = 0 ; i < this.size(); i++)
        {
            if(this.get(i).getName().equals(name))
                return this.get(i);
        }
        return null;
    }

    public boolean removeElement(String name)
    {
        for(int i = 0 ; i < this.size(); i++)
        {
            if(this.get(i).getName().equals(name))
            {
                this.remove(i);
                return true;
            }
        }
        return false;
    }

}
