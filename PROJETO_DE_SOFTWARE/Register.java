import java.util.ArrayList;
import java.util.Scanner;

public class Register
{
    Scanner input = new Scanner(System.in);

    Profile entire = new Profile();
    String user, password;

    public String getUser()
    {
        return user;
    }

    public void setUser()
    {
        System.out.println("Qual o seu nome de usuario: ");
        user = input.nextLine();
    }

    public void setPassword()
    {
        System.out.println("Qual sua senha?");
        password = input.nextLine();
    }
    
    
    public void setRegister(ArrayList<Register> accounts, Register new_register)
    {
        setUser();

        if(!accounts.isEmpty())
        {
            for(int i = 0; i < accounts.size(); i++)
            {
                if(user.intern() == (accounts.get(i).getUser()).intern())
                {
                    System.out.println("Esse usuário já estar cadastrado.");
                }
            }
        }
        setPassword();
        new_register.entire.setName();
        accounts.add(new_register);
        System.out.println("Parabéns!!, agora você faz parte do Iface.");

    }
}