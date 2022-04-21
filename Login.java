import java.util.ArrayList;
import java.util.Scanner;

public class Login
{
	public int checkLogin(ArrayList<Register> accounts)
	{
		String user, password; boolean check = false; int index = 0;
		Scanner input = new Scanner(System.in); 
		String okay;
		if(accounts.isEmpty())
		{
			System.out.printf("\nSem cadastros.\n\n");
			return -1;
		}
		System.out.printf("\nNome de usuario:\n=> ");
		user = input.nextLine();
		System.out.printf("Senha:\n=> ");
		password = input.nextLine();
		
		for(int i = 0; i < accounts.size(); i++)
		{
			if(user.intern() == (accounts.get(i).getUser()).intern()
					&& password.intern() == (accounts.get(i).getPassword()).intern())
				{
					check = true; index = i; break;
				}
		}
		if(!check)
		{
			System.out.printf("Nome de usuario ou senha incorretos\n");
			System.out.printf("[1] Continue\n=> ");
			okay = input.nextLine();
			System.out.printf("\n");
			return -1;
		}
		else
			return index;
	}
	
	public void Menu(ArrayList<Register> accounts, int index, ArrayList<Register> backups)
	{
		System.out.printf("\n");
		boolean active = true; int user_choise;
		Scanner input = new Scanner(System.in);

		int decision; int index2; 
		if(!accounts.get(index).entire.invites.isEmpty())
		{
			for(int i = 0; i < accounts.get(index).entire.invites.size(); i++)
			{
				System.out.printf("Voce tem uma solicitacao de amizade feita por %s\n"
						+ "Deseja aceitar? [1] Sim [2] Nao\n=> ", accounts.get(index).entire.invites.get(i).getUser());
				decision = input.nextInt(); input.nextLine();
				switch(decision)
				{
					case 1:
						Friend new_friend = new Friend();
						new_friend.name = accounts.get(index).entire.invites.get(i).getName();
						new_friend.user = accounts.get(index).entire.invites.get(i).getUser();
						accounts.get(index).entire.friends.add(new_friend);
						
						Friend new_friend2 = new Friend();
						Index_profile search = new Index_profile();
						index2 = search.searchIndex(accounts, accounts.get(index).entire.invites.get(i).getUser());
						new_friend2.name = accounts.get(index).entire.getName();
						new_friend2.user = accounts.get(index).getUser();
						accounts.get(index2).entire.friends.add(new_friend2);
						System.out.printf("%s agora e seu amigo!\n", accounts.get(index).entire.invites.get(i).getUser());
						System.out.printf("[1] Continue\n=> ");
						String okay;
						okay = input.nextLine();
						System.out.printf("\n");
						break;
						
					case 2:
						System.out.printf("Solicitacao de amizade recusada!\n");
						System.out.printf("[1] Continue\n=> ");
						okay = input.nextLine();
						System.out.printf("\n");
						break;
						
				}	
			}
		}
		accounts.get(index).entire.invites.clear();

		for(int i = 0; i < accounts.get(index).entire.communities.size(); i++)
		{
			for(int j = 0; j < accounts.get(index).entire.communities.get(i).invites.size(); j++)
			{
				System.out.printf("%s esta pedindo permissao para participar "
						+ "da sua comunidade \"%s\"\n[1] Aceitar [2] Recusar\n=> ",
						accounts.get(index).entire.communities.get(i).invites.get(j).name,
						accounts.get(i).entire.communities.get(i).name);
				decision = input.nextInt(); input.nextLine();
				if(decision==1)
				{
					Friend new_member = new Friend();
					new_member.user = accounts.get(index).entire.communities.get(i).invites.get(j).user;
					new_member.name = accounts.get(index).entire.communities.get(i).invites.get(j).name;
					accounts.get(index).entire.communities.get(i).member.add(new_member);
					System.out.printf("Adicionado(a) aos membros da sua comunidade!\n[1] Continue\n=> ");
					String okay = input.nextLine();
					System.out.printf("\n");
					
				}
			}
			accounts.get(index).entire.communities.get(i).invites.clear();
		}
		
		/* Inicio do Menu */
		while(active)
		{
			System.out.printf("");
			System.out.printf("Amigos [%s]:", accounts.get(index).entire.friends.size());
			for (int i = 0; i < accounts.get(index).entire.friends.size(); i++)
			{
				System.out.printf(" %s ", accounts.get(index).entire.friends.get(i).user);
			}
			System.out.printf("\n");
			System.out.printf("Caixa de entrada [%s].\n", accounts.get(index).entire.messages.size());
			System.out.printf("\n[1] Editar perfil\n[2] Adicionar amigo\n[3] Enviar mensagem\n[4] Ler mensagens da caixa de entrada\n"
					+ "[5] Criar comunidade\n[6] Entrar em comunidade\n[7] Suas comunidades, mensagens e membros.\n[8] Enviar mensagem para comunidade\n"
					+ "[9] Recuperar dados\n[10] Excluir conta\n"
					+ "[11] Salvar dados (backup) e Logoff\n=> ");
			
			user_choise = input.nextInt();
			input.nextLine();
			
			switch(user_choise)
			{
				case 1:
					accounts.get(index).entire.setProfile();
					break;
				case 2:
					Friend friend = new Friend();
					System.out.printf("\nDigite o nome de usuario do amigo:\n=>");
					String user = input.nextLine(); 
                    boolean check = false;  
                    int friend_index=0;
					if(!accounts.isEmpty())
					{
						for(int i = 0; i < accounts.size(); i++)
						{
							if(user.intern() == (accounts.get(i).getUser()).intern())
							{
								friend_index = i; 
                                check = true; 
                                break;
							}
						}
						if(!check)
						{
							System.out.printf("\nUsuario nao existe.\n");
							break;
						}
					}
					if (!accounts.get(index).entire.friends.isEmpty())
					{
						for(int i=0; i < accounts.get(index).entire.friends.size(); i++)
						{
							if(user.intern() == (accounts.get(index).entire.friends.get(i).user).intern())
							{
								check = false; 
                                break;
							}
						}
						if(!check)
						{
							System.out.printf("\nUsuario ja foi adicionado.\n");
							break;
						}
					}
					
					Invite new_invite = new Invite();
					new_invite.setName(accounts.get(index).entire.getName());
					new_invite.setUser(accounts.get(index).getUser());
					accounts.get(friend_index).entire.invites.add(new_invite);
					
					System.out.printf("\nO convite de amizade foi enviado para %s!\n\n", user);
					break;
				case 3:
					System.out.printf("Enviar mensagem para:\n=> ");
					user = input.nextLine();
					Index_profile new_search = new Index_profile();
					int user_index = new_search.searchIndex(accounts, user);
					if(user_index == -1)
					{
						System.out.printf("Usuario nao existe.\n"); break;
					}
					Message mensagem = new Message();
					mensagem.to_user = user;
					mensagem.from_user = accounts.get(index).getUser();
					mensagem.getMessage();
					accounts.get(user_index).entire.messages.add(mensagem);
					System.out.println("Mensagem enviada para "+user);
					System.out.printf("[1] Continue\n=> ");
					String okay;
					okay = input.nextLine();
					System.out.printf("\n");
					break;
				case 4:
					if(!accounts.get(index).entire.messages.isEmpty())
					{
						for(int i = 0; i < accounts.get(index).entire.messages.size(); i++)
						{
							System.out.printf("Mensagem de %s:\n\"%s\"\n"
									+ "[1] Continue\n=> ", accounts.get(index).entire.messages.get(i).from_user,
									accounts.get(index).entire.messages.get(i).message);
							okay = input.nextLine();
							System.out.printf("\n");	
						}
					}
					else
					{
						System.out.printf("Sem mensagens!\n");
						System.out.printf("[1] Continue\n=> ");
						okay = input.nextLine();
						System.out.printf("\n");
					}
					break;
				case 5:
					community comunidade = new community();
					comunidade.setCommunity(accounts.get(index).getUser());
					accounts.get(index).entire.communities.add(comunidade);
					Friend new_friend2 = new Friend();
					new_friend2.user = accounts.get(index).user;
					new_friend2.name = accounts.get(index).entire.getName();
					accounts.get(index).entire.communities.get(0).member.add(new_friend2);
					System.out.printf("Comunidade criada!\n");
					System.out.printf("[1] Continue\n=> ");
					okay = input.nextLine();
					System.out.printf("\n");
					break;
				case 6:
					decision = 0;
					System.out.printf("Comunidades do iFace:\n\n");
					for(int i = 0; i < accounts.size(); i++)
					{
						if(accounts.get(i).user.intern() != accounts.get(index).user.intern()
								&& !accounts.get(i).entire.communities.isEmpty())
						{
							for(int j = 0; j < accounts.get(i).entire.communities.size(); j++)
							{
								System.out.printf("Admin: %s\nNome: %s\nDescricao: %s\n\n",
										accounts.get(i).entire.communities.get(j).user_admin,
										accounts.get(i).entire.communities.get(j).name,
										accounts.get(i).entire.communities.get(j).theme);
								decision = 1;
							}							
						}
					}
					
					if(decision == 1)
					{
						System.out.printf("Deseja entrar em alguma?\n[1] Sim [2] Nao\n=> ");
						decision = input.nextInt(); input.nextLine();						
					}
					
					if(decision == 1)
					{
						System.out.printf("Digite o nome:\n=> ");
						okay = input.nextLine();
						for(int i = 0; i < accounts.size(); i++)
						{
							if(accounts.get(i).user.intern() != accounts.get(index).user.intern()
									&& !accounts.get(i).entire.communities.isEmpty())
							{
								for(int j = 0; j < accounts.get(i).entire.communities.size(); j++)
								{
									if(okay.intern() == accounts.get(i).entire.communities.get(j).name.intern())
									{
										for(int k = 0; k < accounts.get(i).entire.communities.get(j).member.size(); k++)
										{
											if(accounts.get(index).user.intern() == accounts.get(i).entire.communities.get(j).member.get(k).user.intern())
											{
												decision = 0; break;
											}
										}
										if(decision == 0)
											break;
										Invite invite = new Invite();
										invite.user = accounts.get(index).user;
										invite.name = accounts.get(index).entire.getName();
										accounts.get(i).entire.communities.get(j).invites.add(invite);
										System.out.printf("A solicitacao foi enviada para %s\n\n", accounts.get(i).entire.communities.get(j).user_admin);
										System.out.printf("[1] Continue\n=> ");
										okay = input.nextLine();
										System.out.printf("\n"); decision = 0;
										break;
									}
								}
							}
							if(decision==0)
								break;
						}
					}
					else
					{
						System.out.printf("Comunidade nao foi encontrada ou voce ja faz parte.\n");
						System.out.printf("[1] Continue\n=> ");
						okay = input.nextLine();
						System.out.printf("\n");
					}
					
					break;
				case 7:
					for(int i = 0; i < accounts.size(); i++)
					{
						for(int j = 0; j < accounts.get(i).entire.communities.size(); j++)
						{
							for(int k = 0; k < accounts.get(i).entire.communities.get(j).member.size(); k++)
							{
								if(accounts.get(index).user.intern() == accounts.get(i).entire.communities.get(j).member.get(k).user.intern() )
								{
									System.out.printf("\n---------------\n");
									System.out.printf("Admin: %s\nNome: %s\nDescricao: %s\nMembros:\n",
											accounts.get(i).entire.communities.get(j).user_admin,
											accounts.get(i).entire.communities.get(j).name,
											accounts.get(i).entire.communities.get(j).theme);
									for(int l = 0; l < accounts.get(i).entire.communities.get(j).member.size(); l++)
									{
										System.out.printf(" -> %s\n", accounts.get(i).entire.communities.get(j).member.get(l).getUser());
									}
									for(int m = 0; m < accounts.get(i).entire.communities.get(j).messages.size(); m++)
									{
										System.out.printf("Mensagem de %s:\n%s\n", accounts.get(i).entire.communities.get(j).messages.get(m).from_user,
												accounts.get(i).entire.communities.get(j).messages.get(m).message);
									}
									System.out.printf("---------------\n\n");
								}
							}
						}
					}
					System.out.printf("[1] Continue\n=> ");
					okay = input.nextLine();
					System.out.printf("\n");
					break;
				case 8:
					System.out.printf("Comunidades do iFace:\n\n");
					for(int i = 0; i < accounts.size(); i++)
					{
						if(accounts.get(i).user.intern() != accounts.get(index).user.intern()
								&& !accounts.get(i).entire.communities.isEmpty())
						{
							for(int j = 0; j < accounts.get(i).entire.communities.size(); j++)
							{
								System.out.printf("Nome: %s\nDescricao: %s\n\n",
										accounts.get(i).entire.communities.get(j).name,
										accounts.get(i).entire.communities.get(j).theme);
							}
						}
					}
					System.out.printf("Deseja enviar mensagem para qual?\n=> ");
					okay = input.nextLine(); decision = 1;
					for(int i = 0; i < accounts.size(); i++)
					{
						for(int j = 0; j < accounts.get(i).entire.communities.size(); j++)
						{
							if(okay.intern() == accounts.get(i).entire.communities.get(j).name.intern())
							{
								Message new_message2 = new Message();
								new_message2.from_user = accounts.get(i).getUser();
								new_message2.getMessage();
								accounts.get(i).entire.communities.get(j).messages.add(new_message2);
								System.out.printf("Mensagem enviada!\n[1] Continue\n=> ");
								okay = input.nextLine();
								System.out.printf("\n");
								decision = 0;
							}
							if(decision==0)
								break;
						}
						if(decision == 0)
							break;
					}
					if(decision == 1)
					{
						System.out.printf("Comunidade nao encontrada.\n[1] Continue\n=> ");
						okay = input.nextLine();
						System.out.printf("\n");
					}
					break;
				case 9:
					boolean go = false;

                    if(backups.isEmpty()){
                        System.out.println("\nNão há dados a recuperar.\n");
                        break;
                    }
					for(int i=0; i < backups.size(); i++)
					{
						if(backups.get(i).user.intern()==accounts.get(index).user.intern())
						{
							go = true; 
							Register save = new Register();
							save.entire.user = backups.get(i).entire.getUser();
							save.entire.name = backups.get(i).entire.getName();
                            save.entire.age = backups.get(i).entire.getAge();
                            save.entire.country = backups.get(i).entire.getCountry();
                            save.entire.schooling = backups.get(i).entire.getSchooling();
                            save.entire.gender = backups.get(i).entire.getGender();
                            save.entire.about = backups.get(i).entire.getAbout();
							save.entire.communities =  (ArrayList<community>) backups.get(i).entire.communities.clone();
							for(int j=0; j < backups.get(i).entire.communities.size(); j++)
							{
								save.entire.communities.get(j).messages = (ArrayList<Message>) backups.get(i).entire.communities.get(j).messages.clone();
								save.entire.communities.get(j).member = (ArrayList<Friend>) backups.get(i).entire.communities.get(j).member.clone();
								save.entire.communities.get(j).invites = (ArrayList<Invite>) backups.get(i).entire.communities.get(j).invites.clone();
							}
							save.entire.friends =  (ArrayList<Friend>) backups.get(i).entire.friends.clone();
							save.entire.messages =  (ArrayList<Message>) backups.get(i).entire.messages.clone();
							save.entire.invites =  (ArrayList<Invite>) backups.get(i).entire.invites.clone();
							backups.remove(i);
							accounts.remove(index);
							accounts.add(save);
							break;
						}
					}
					if(!go)
					{
						System.out.printf("Sem backup.\n[1] Continue\n=> ");
						okay = input.nextLine();
						System.out.printf("\n");
						break;
					}
					
					System.out.printf("Ultimo backup restaurado!\nVoce voltara a tela inicial.\n[1] Continue\n=> ");
					okay = input.nextLine();
					System.out.printf("\n");
					active = false;
					break;
				case 10:
					System.out.printf("Apagar conta?\n[1] Sim [2] Nao\n=> ");
					decision = input.nextInt(); input.nextLine();
					if(decision == 1)
					{
						for(int i = 0; i < accounts.size(); i++)
						{
							for(int j=0; j < backups.size(); j++)
							{
								if(backups.get(j).user.intern()==accounts.get(index).user.intern())
								{
									backups.remove(j);
									break;
								}
							}
							if(accounts.get(i).user.intern() == accounts.get(index).user.intern())
							{
								for(int j = 0; j < accounts.get(i).entire.communities.size(); j++)
								{
									accounts.get(i).entire.communities.get(j).invites.clear();
									accounts.get(i).entire.communities.get(j).member.clear();
									accounts.get(i).entire.communities.get(j).messages.clear();
								}
								accounts.get(i).entire.communities.clear();
								accounts.get(i).entire.friends.clear();
								accounts.get(i).entire.messages.clear();
								accounts.get(i).entire.invites.clear();
							}
							else
							{
								for(int j = 0; j < accounts.get(i).entire.communities.size(); j++)
								{
										for(int k = 0; k < accounts.get(i).entire.communities.get(j).invites.size(); k++)
										{
											if(accounts.get(index).user.intern() == accounts.get(i).entire.communities.get(j).invites.get(k).user.intern())
												accounts.get(i).entire.communities.get(j).invites.remove(k);							
										}
										for(int k = 0; k < accounts.get(i).entire.communities.get(j).member.size(); k++)
										{
											if(accounts.get(index).user.intern() == accounts.get(i).entire.communities.get(j).member.get(k).user.intern())
												accounts.get(i).entire.communities.get(j).member.remove(k);							
										}
										for(int k = 0; k < accounts.get(i).entire.communities.get(j).messages.size(); k++)
										{
											if(accounts.get(index).user.intern() == accounts.get(i).entire.communities.get(j).messages.get(k).from_user.intern())
												accounts.get(i).entire.communities.get(j).messages.remove(k);							
										}
								}
								for(int j = 0; j < accounts.get(i).entire.friends.size(); j++)
								{
									if(accounts.get(index).user.intern() == accounts.get(i).entire.friends.get(j).user.intern())
										accounts.get(i).entire.friends.remove(j);
								}
								for(int j = 0; j < accounts.get(i).entire.messages.size(); j++)
								{
									if(accounts.get(index).user.intern() == accounts.get(i).entire.messages.get(j).from_user.intern())
										accounts.get(i).entire.messages.remove(j);
								}
								for(int j = 0; j < accounts.get(i).entire.invites.size(); j++)
								{
									if(accounts.get(index).user.intern() == accounts.get(i).entire.invites.get(j).user.intern())
										accounts.get(i).entire.invites.remove(j);
								}
							}
						}
						accounts.remove(index);
						active = false;
						System.out.printf("Conta apagada!\n[1] Continue\n=> ");
						okay = input.nextLine();
						System.out.printf("\n");
					}
					break;
				case 11:
					Register save = new Register();
					save.entire.user = accounts.get(index).entire.getUser();
                    save.password = accounts.get(index).password;
                    save.entire.name = accounts.get(index).entire.getName();
                    save.entire.age = accounts.get(index).entire.getAge();
                    save.entire.country = accounts.get(index).entire.getCountry();
                    save.entire.schooling = accounts.get(index).entire.getSchooling();
                    save.entire.gender = accounts.get(index).entire.getGender();
                    save.entire.about = accounts.get(index).entire.getAbout();
					save.entire.communities =  (ArrayList<community>) accounts.get(index).entire.communities.clone();
					for(int i=0; i < accounts.get(index).entire.communities.size(); i++)
					{
						save.entire.communities.get(i).messages = (ArrayList<Message>) accounts.get(index).entire.communities.get(i).messages.clone();
						save.entire.communities.get(i).member = (ArrayList<Friend>) accounts.get(index).entire.communities.get(i).member.clone();
						save.entire.communities.get(i).invites = (ArrayList<Invite>) accounts.get(index).entire.communities.get(i).invites.clone();
					}
					save.entire.friends =  (ArrayList<Friend>) accounts.get(index).entire.friends.clone();
					save.entire.messages =  (ArrayList<Message>) accounts.get(index).entire.messages.clone();
					save.entire.invites =  (ArrayList<Invite>) accounts.get(index).entire.invites.clone();
					for(int i=0; i < backups.size(); i++)
					{
						if(backups.get(i).user.intern() == save.user.intern())
						{
							backups.remove(i); 
                            break;
						}
					}
					backups.add(save);
					active = false;
					break;
			}
		}
	}
}