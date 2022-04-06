import java.util.ArrayList;
import java.util.Scanner;
import java.util.Scanner;

public class Main
{
    Scanner input = new Scanner(System.in);
    ArrayList<Register> accounts = new ArrayList<Register>();
    ArrayList<Register> backup = new ArrayList<Register>();
    boolean activw = true;
    int choise;

    while(active)
    {
        System.out.printfln("Bem-vindo ao app");
        System.out.println("1 ==> Login\n2 ==> cadastro\n3 ==> Sair");

        choise = input.nextInt();
        input.nextLine();

        switch(choise)
        {
            case 1:
                    Login profile = new Login();
                    int index = profile.checkLog(accounts);

                    if(index > -1)
                    {
                        profile.menu(accounts, index, backups);
                    }
                    break;
            case 2:
                    Register registro = new Register();
                    registro.SetRegister(accounts, registro);
                    break;
            default:
            active = false;
            break;
        }
    }

    System.out.printf("\n Usuarios cadastrados [%s]", accounts.size());

    for(int i=0; i< accounts.size(); i++)
    {
        System.out.println(acounts.get(i).username);
    }
    input.close();
}