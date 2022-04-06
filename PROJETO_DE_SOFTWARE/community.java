import java.util.ArrayList;
import java.util.Scanner;

public class Community
{
    String name, theme, descri, user_admin;

    ArrayList<Message> messages = new ArrayList<Message>();
    ArrayList<Friend> friends = new ArrayList<Friend>();
    ArrayList<Invite> invites = new ArrayList<Invite>();

    Scanner input = new Scanner(System.in);

    public void setCommuunity(String user){
        user_admin = user;

        System.out.println("Qual o nome da sua comunidade?");
        name = input.nextLine();

        System.out.println("Qual o tema da sua comunidade?");
        theme = input.nextLine();

        System.out.println("fale um pouco como será essa comunidade: ");
        descri = input.nextLine();
    }
}