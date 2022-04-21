import java.util.ArrayList;

public class Index_profile
{
    public int searchIndex(ArrayList<Register> accounts, String current_user)
    {
        for(int i = 0; i < accounts.size(); i++)
        {
            if(current_user.intern() == (accounts.get(i).getUser()).intern()) return i;
        }
        return -1;
    }
}