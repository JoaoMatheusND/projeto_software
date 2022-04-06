import java.util.ArrayList;
import java.util.Scanner;

import javax.lang.model.element.Element;

public class Login
{
    public boolean checkLog(ArrayList<Register> accounts)
    {
        Scanner input = new Scanner(System.in);

        String username,
            password,
            aux;
        boolean check = false;
        int index = 0;

        if(accounts.isEmpty())
        {
            System.out.println("Sem cadastros registrados até o momento.");
            return false;
        }

        System.out.print("Inisra o nome de usuário: ");
        username = input.nextLine();
        System.out.print("Senha: ");
        password = input.nextLine();

        for(int i = 0; i < accounts.sixe(); i++)
        {
            if(username.intern() == (accounts.get(i).getUsername().intern())
            && password.intern() == (accounts.get(i).getPassaword()).inter())
            {
                check = true;
                index = i;
                break;
            }
        }

        if(!check)
        {
            System.out.println("Nome de usuário ou senha incorretos");
            return false;
        }
        else
        {
            return index;
        }   

        public void menu(ArrayList<Register> accounts, ArrayList<Register> backups, int index)
        {
            Scanner input = new Scanner(System.in);

            boolean active = true;
            int short_one, decision, index2;

            if(!accounts.get(index).new_profile.invites.isEmpty())
            {
                for(int i = 0; i < accounts.get(index).new_profile.invites.size(); i++)
                {
                    System.out.println("Há uma nova solicitação:\n "+accounts.get(index).new_profile.invites.get(i).apresentation());
                    System.out.println("Gostarian de aceiar?\n1 - Aceito.\n2 - Não aceito");

                    short_one = input.nextInt();
                    
                    if(short_one == 1)
                    {
                        Friend new_friend = new Friend();
                        Friend self_invite = new Friend();
                        Index_profile search = new Index_profile();
                        index2 = search.searchIndex(accounts, accounts.get(index).new_profile.invites.get(i).getUser());

                        new_friend.name = accounts.get(index).new_profile.invites.getName();
                        new_friend.user = accounts.get(index).new_profile.invites.getUser();
                        accounts.get(index).new_profile.friends.add(new_friend);

                        self_invite.name = accounts.get(index).new_profile.getName();
                        self_invite.user = accounts.get(index).new_profile.getUser();
                        accounts.get(index2).new_profile.friends.add(self_invite);

                        System.out.println("Parabéns agora vocês são amigos!!!");

                    }
                    else if(short_one == 2)
                    {
                        System.out.printfln("Solicitação de amizade recusada");
                    }

                    }
                }
                accounts.get(ihndex).new_profile.invites.clear();
            }

            for(int i = 0; i < accounts.get(index).new_profile.comunnities.size(); i++)
            {
                for(int j = 0; j < accounts.get(index).new_profile.comunnities.get(i).invites.size(); i++)
                {
                    System.out.println(accounts.get(index).new_profile.invites.get(i).apresentation()+".\n estar querendo participar da sua comunidade: "+
                    accounts.get(i).new_profile.comunnities.get(i).name+"\n Digite sim para aceitar e nao para recusar: ");
                    
                    String aux = input.nextInt();

                    if(aux == "sim")
                    {
                    Friends member = new Friend();

                    member.name = accounts.get(index).new_profile.comunnities.get(i).invites.get(j).name;
                    member.user = accounts.get(index).new_profile.comunnities.get(i).invites.get(j).user;

                    accounts.get(index).new_profile.comunnities.get(i).member.add(member);

                    System.out.println("Membro adicioado com sucesso!!!");
                    }
                } 
                accounts.get(index).new_profile.comunnities.get(i).invites.clear();
            }

            while(active)
            {
                System.out.println(accounts.get(index).new_profile.my_profile());
                System.out.println("Amigos ["+accounts.get(index).friends.sizeof()+"]:");

                for(int i=0; i< accounts.get(index).new_profile.friends.size(); i++)
                {
                    System.out.println("==> "+accounts.get(index).new_profile.friends.get(i).user());
                }

                System.out.println("Caixa de entrada ["+accounts.get(index).new_friend.message.size()+"]");

                System.out.println("1 ==> Editar perfil\n"+
                                   "2 ==> Adicionar amigo\n"+
                                   "3 ==> Enviarmensagem\n"+
                                   "4 ==> Ler mensagens\n"+
                                   "5 ==> Criar comunidade\n"+
                                   "6 ==> Entrar em comunidade\n"+
                                   "7 ==> Ver minhas comunidades\n"+
                                   "8 ==> Enviar mensagem em comunidade\n"+
                                   "9 ==> Rcuperar dados\n"+
                                   "10 ==> Excluir conta"+
                                   "11 ==> Sair");

                short_one = input.nextInt();

                switch(short_one)
                {
                    case 1:
                            accounts.get(index).new_profile.setProfile();
                            break;
                    case 2:
                            Friend new_friend = new Friend();
                            String username;
                            boolean check = false;
                            int friend_index = 0;

                            System.out.print("Digite o nome de usuário a quem quer enviar convite: ");
                            username = input.nextLine();

                            if(!accounts.isEmpty())
                            {
                                for(int i = 0; i<accounts.size(); i++)
                                {
                                    friend_index = i;
                                    check = true;
                                    break;
                                }
                                if(!check)
                                {
                                    System.out.println("Usuário não estra cadastrado");
                                    break;
                                }
                            }

                            if(accounts.get(index).new_profile.friends.isEmty())
                            {
                                for(int i=0; i < (accounts.get(index).new_profile.friends.size(); i++)
                                {
                                    if(username.intern() == (accounts.get(index).new_profile.friends.get(i).user).intern())
                                    {
                                        check = false;
                                        break;
                                    }
                                }
                                if(!check)
                                {
                                    System.out.println("Usuário já é seu amigo");
                                    break;0
                                }
                            }

                            Invite convite = new Invite();
                            convite.setname(accounts.get(index).new_profile.getName());
                            convite.setUser(accounts.get(index).getUser());
                            accounts.get(friend_index).new_profile.invites.add(convite);

                            System.out.println("Convite enviado com sucesso!");
                            break;
                    case 3:
                            Index_profile search = new Index_profile();
                            Message mensagem = new Message();

                            System.out.println("Enviar mensagem para: ");
                            username = input.nextLine();

                            int friend_index = search(accounts, username);

                            if(friend_index == -1){
                                System.out.println("Usuário não cadastrado.");
                                break;
                            }

                            mensagem.to = username;
                            mensagem.from = accounts.get(index).getUser();
                            mensagem.getMessage();

                            accounts.get(friend_index).new_profile.mensagem.add(mensagem);
                            break;
                    case 4:
                            

                };
            }
        }
}