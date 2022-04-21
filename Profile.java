import java.util.ArrayList;
import java.util.Scanner;

public class Profile
{
    Scanner input = new Scanner(System.in);

    String name = "[edit_name]", 
           user = "[edit_user]",
           age = "[edit_age]",
           gender = "[edit_gender]",
           country = "[edit_country]",
           schooling = "[edit_schooling]",
           about = "[edit_about]";
    boolean aux = false;

    ArrayList<Friend> friends = new ArrayList<Friend>();
    ArrayList<Message> messages = new ArrayList<Message>();
    ArrayList<Invite> invites = new ArrayList<Invite>();
    ArrayList<community> communities = new ArrayList<community>();

    public void setProfile()
    {
        setName();
        setUser();
        setAge();
        setGender();
        setCountry();
        setSchooling();
        setAbout();
    }

    public String apresentation()
    {
        return "Prazer!, sou "+getName()+", sou "+getGender()+" e tenho "+getAge()+", sou de"+getCountry()+" e sobre mim:\n"+getAbout();
    }
                                                                                                 
    public String my_profile()
    {
        return "Olar"+this.name+"este é seu perfil:\n"+this.gender+", "+this.age+", "+this.country+", "+schooling+", "+this.about;
    }

    public void setName()
    {
        System.out.println("Digite seu nome:\n=>");
        name = input.nextLine();
    }

    public void setUser()
    {
        System.out.println("Digite seu username:\n=>");
        user = input.nextLine();
    }

    public void setAge()
    {
        System.out.println("Digite sua idade:\n=>");
        age = input.nextLine();
    }

    public void setGender()
    {
        System.out.println("Digite seu gênero:\n=>");
        gender = input.nextLine();
    }

    public void setCountry()
    {
        System.out.println("Digite seu pais:\n=>");
        country = input.nextLine();
    }

    public void setSchooling()
    {
        System.out.println("Digite sua escolaridade:\n=>");
        schooling = input.nextLine();
    }

    public void setAbout()
    {
        System.out.println("Gostaria de falar algo sobre você:\n=>");
        about = input.nextLine();
    }

    public String getName()
    {
        return this.name;
    }

    public String getUser()
    {
        return this.user;
    }

    public String getAge()
    {
        return this.age;
    }

    public String getGender()
    {
        return this.gender;
    }

    public String getCountry()
    {
        return this.country;
    }

    public String getSchooling()
    {
        return this.schooling;
    }

    public String getAbout()
    {
        return this.about;
    }
}