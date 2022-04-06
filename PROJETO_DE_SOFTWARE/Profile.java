import java.util.ArrayList;
import java.util.Scanner;

public class Profile
{
    Scanner input = new Scanner(System.in);

    String name = "[edit_name]", 
           age = "[edit_age]",
           gender = "[edit_gender]",
           country = "[edit_country]",
           schooling = "[edit_schooling]",
           about = "[edit_about]";
    boolean aux = false;

    ArrayList<Friend> friends = new ArrayList<Friend>();
    ArrayList<Message> messages = new ArrayList<Message>();
    ArrayList<Invite> invites = new ArrayList<Invite>();
    ArrayList<Community> communities = new ArrayList<Community>();

    public void setProfile()
    {
        setName();
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
        System.out.println("Digite seu nome: ");
        name = input.nextLine();
    }

    public void setAge()
    {
        System.out.println("Digite sua idade: ");
        age = input.nextLine();
    }

    public void setGender()
    {
        System.out.println("Digite seu gênero: ");
        gender = input.nextLine();
    }

    public void setCountry()
    {
        System.out.println("Digite seu pais: ");
        country = input.nextLine();
    }

    public void setSchooling()
    {
        System.out.println("Digite sua escolaridade: ");
        schooling = input.nextLine();
    }

    public void setAbout()
    {
        System.out.println("Gostaria de falar algo sobre você: ");
        about = input.nextLine();
    }

    public String getName()
    {
        return name;
    }

    public String getAge()
    {
        return age;
    }

    public String getGender()
    {
        return gender;
    }

    public String getCountry()
    {
        return country;
    }

    public String getSchooling()
    {
        return schooling;
    }

    public String getAbout()
    {
        return about;
    }
}