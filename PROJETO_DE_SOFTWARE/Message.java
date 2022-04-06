import java.util.Scanner;

public class Message
{
    public String to_user, from_user, message;
    Scanner mensagem = new Scanner(System.in);

    public void getMessage()
    {
        System.out.println("Qual sua mensagem:");
        this.message = mensagem.nextLine();
    }

    public String returnMessage()
    {
        return this.message;
    }
}