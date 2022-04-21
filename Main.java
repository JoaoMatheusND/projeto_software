import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        ArrayList<Register> accounts = new ArrayList<Register>();
        ArrayList<Register> backups = new ArrayList<Register>();
        boolean active = true;
        int choise;


        while(active)
        {
            System.out.println("Bem-vindo ao app");
            System.out.println("1 ==> Login\n2 ==> cadastro\n3 ==> Sair");
        
            choise = input.nextInt();
            input.nextLine();

            switch(choise)
            {
                case 1:
                        Login profile = new Login();
                        int index = profile.checkLogin(accounts);
                        
                        if(index > -1)
                        {
                            profile.Menu(accounts, index, backups);
                        }
                        break;
                case 2:
                        Register registro = new Register();
                        registro.setRegister(accounts, registro);
                        break;
                default:
                active = false;
                break;
            }
        }

        System.out.printf("\n Usuarios cadastrados [%s]", accounts.size());
        for(int i=0; i< accounts.size(); i++)
        {
            System.out.println(accounts.get(i).getUser());
        }
        input.close();
    }
}