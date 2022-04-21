import java.util.ArrayList;
import java.util.Scanner;

public class community
{
    String name, theme, descri, user_admin;

    ArrayList<Message> messages = new ArrayList<Message>();
    ArrayList<Friend> friends = new ArrayList<Friend>();
    ArrayList<Invite> invites = new ArrayList<Invite>();
    ArrayList<Friend> member = new ArrayList<Friend>();

    Scanner input = new Scanner(System.in);

    public void setCommunity(String user){
        user_admin = user;

        System.out.println("Qual o nome da sua comunidade?\n=>");
        name = input.nextLine();

        System.out.println("Qual o tema da sua comunidade?\n=>");
        theme = input.nextLine();

        System.out.println("fale um pouco como será essa comunidade:\n=>");
        descri = input.nextLine();
    }

    public String getname(){
        return this.name;
    }
}