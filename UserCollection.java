/**
 * @author Burak
 * @version 1.2
 * 
 */
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserCollection {


	CopyOnWriteArrayList<User> userList=new CopyOnWriteArrayList<User>();
	CopyOnWriteArrayList<Integer> signinList=new CopyOnWriteArrayList<Integer>();

	public UserCollection() {
		
	}

	public void addUser(int userID,String name,  String userName, String pass,String DoB,String school){
		User u=new User(userID, name, userName, pass, DoB, school);
		userList.add(u);
		
		
	}
	
	public void ADDUSER(int userID,String name,  String userName, String pass,String DoB,String school){
		System.out.println("-----------------------");
		System.out.println("Command: ADDUSER\t"+name+"\t"+userName+"\t"+pass+"\t"+DoB+"\t"+school);
		User u=new User(userID, name, userName, pass, DoB, school);
		userList.add(u);
		System.out.println(name+" has been successfully added.");
		
		
	}
	
	public void REMOVEUSER(int userID){
		System.out.println("-----------------------");
		System.out.println("Command: REMOVEUSER\t"+userID);
		int userExit=0;
		for(User user : userList){
			if(user.getUserID()==userID){
				userExit=1;
				userList.remove(user);
				System.out.println("User has been successfully removed.");
			}
		}
		
		if(userExit==0){
			System.out.println("No such user!");
		}
			
	}
	
	public void SIGNIN(String userName,String pass){
		System.out.println("-----------------------");
		System.out.println("Command: SIGNIN\t"+userName+"\t"+pass);
		int nameExit=0;
		int passExit=0;
		
		if(signinList.size()<1){	
			for(User user:userList){
				if(user.getUserName().equals(userName)){
					nameExit=1;
					if(user.getPass().equals(pass)){
						passExit=1;
						System.out.println("You have successfully signed in.");
						signinList.add(user.getUserID());
						user.lastLogin=new Date();
						
					}
				}	
		}
			if(nameExit==0){
				System.out.println("No such user!");
			}
			else if(nameExit==1 && passExit==0){
				System.out.println("Invalid username or password! Please try again.");
			}
		}
		
	
	}
	
	public void SIGNOUT(){
		System.out.println("-----------------------");
		System.out.println("Command: SIGNOUT");
		for(Integer id:signinList){
			for(User user:userList){
				if(user.getUserID()==id){
					signinList.remove(id);
					System.out.println("You have successfully signed out.");
				}
			}
		}
	}
	
	public void UPDATEPROFILE(String name,String DoB,String school){
		System.out.println("-----------------------");
		System.out.println("Command: UPDATEPROFILE\t"+name+"\t"+DoB+"\t"+school);
		int signExit=0;
		for(User user:userList){
			for(Integer id:signinList){
				if(user.getUserID()==id){
					signExit=1;
						user.setName(name);
						user.setDoB(DoB);
						user.setSchool(school);
						System.out.println("Your user profile has been successfully updated.");
					}
				}
			}
		
		if(signExit==0){
			System.out.println("Error: Please sign in and try again.");
		}
	}
	
	public void CHPASS(String oldPass,String newPass){
		System.out.println("-----------------------");
		System.out.println("Command: CHPASS\t"+oldPass+"\t"+newPass);
		int signExit=0;
		int passExit=0;
		
		for(User user:userList){
				for(Integer id:signinList){
					if(user.getUserID()==id){
						signExit=1;
						if(user.getPass().equals(oldPass)){
							passExit=1;
							user.setPass(newPass);
						
					}
				}
			}
		}
		if(signExit==0){
			System.out.println("Error: Please sign in and try again.");
		}
		else if(passExit==0){
			System.out.println("Password mismatch! Please, try again.");
		}
		
	}
	
	public void ADDFRIEND(String userName){
		System.out.println("-----------------------");
		System.out.println("Command: ADDFRIEND\t"+userName);
		int signExit=0;
		int userExit=0;
		int added=0;
		for(User user:userList){
			for(Integer id:signinList){
				if(user.getUserID()==id){
					signExit=1;
					for(User otherUser:userList){
						if(userName.equals(otherUser.getUserName())){
							userExit=1;
							if(!user.friendList.contains(userName)){
								added=1;
								user.friendList.add(userName);
								System.out.println(userName+" has been successfully added to your friend list.");
							
							}
						}		
					}
				}
			}
		}
		if(signExit==0){
			System.out.println("Error: Please sign in and try again.");
		}
		else if(userExit==0){
			System.out.println("No such user!");
		}
		else if(added==0){
			System.out.println("This user is already in your friend list!");
		}
		
	}
	
	public void REMOVEFRIEND(String userName){
		System.out.println("-----------------------");
		System.out.println("Command: REMOVEFRIEND\t"+userName);
		int signExit=0;
		int friendExit=0;
		
		for(User user:userList){
			for(Integer id:signinList){
				if(user.getUserID()==id){
					signExit=1;
					for(String usern:user.friendList){
						if(userName.equals(usern)){
							friendExit=1;
							user.friendList.remove(userName);
							System.out.println(userName+" has been successfully removed from your friend list.");
						}
					}
				
				}
			}
		}
		
		if(signExit==0){
			System.out.println("Error: Please sign in and try again.");
		}
		else if(friendExit==0){
			System.out.println("No such friend!");
		}
	
		
	}
	
	public void LISTUSERS(){
		System.out.println("-----------------------");
		System.out.println("Command: LISTUSERS");
		int signExit=0;
		
		for(User user:userList){
			for(Integer id:signinList){
				if(user.getUserID()==id){
					signExit=1;
		
					for(User allUser:userList){
						System.out.println("Name: "+allUser.getName()+
								"\nUsername: "+allUser.getUserName()+
								"\nDate of Birth: "+allUser.getDoB()+
								"\nSchool: "+allUser.getSchool()+
								"\n---------------------------");
					}
		
				}
			}
		}
		
		if(signExit==0){
			System.out.println("Error: Please sign in and try again.");
		}
		
	
		
	}
	
	public void BLOCK(String userName){
		System.out.println("-----------------------");
		System.out.println("Command: BLOCK\t"+userName);
		int signExit=0;
		int userExit=0;
		
		for(User user:userList){
			for(Integer id:signinList){
				if(user.getUserID()==id){
					signExit=1;
					for(User usern:userList){
						if(userName.equals(usern.getUserName())){
							userExit=1;
							
							user.blockedList.add(userName);
							System.out.println(userName+" has been successfully blocked.");
								
							
						}
					}
		
					
		
				}
			}
		}
		
		if(signExit==0){
			System.out.println("Error: Please sign in and try again.");
		}
		else if(userExit==0){
			System.out.println("No such user!");
		}
		
	
		
	}
	
	public void UNBLOCK(String userName){
		System.out.println("-----------------------");
		System.out.println("Command: UNBLOCK\t"+userName);
		int signExit=0;
		int blockExit=0;
		
		for(User user:userList){
			for(Integer id:signinList){
				if(user.getUserID()==id){
					signExit=1;
					for(String blockUsers:user.blockedList){
						if(userName.equals(blockUsers)){
							blockExit=1;
							user.blockedList.remove(userName);
							System.out.println(userName+" has been successfully unblocked.");
						}
					}
	
				}
			}
		}
		
		if(signExit==0){
			System.out.println("Error: Please sign in and try again.");
		}
		else if(blockExit==0){
			System.out.println("No such user in your blocked users list!");
		}
		
	
		
	}
	
	public void SHOWBLOCKEDFRIENDS(){
		System.out.println("-----------------------");
		System.out.println("Command: SHOWBLOCKEDFRIENDS");
		int signExit=0;
		int blockUserExit=0;
		int blockFriendExit=0;
		for(User user:userList){
			for(Integer id:signinList){
				if(user.getUserID()==id){
					signExit=1;
					if(user.blockedList.size()>0){
						blockUserExit=1;
						for(String friends:user.friendList){
							for(String blocks:user.blockedList){
								if(blocks.equals(friends)){
									blockFriendExit=1;
									for(User allUser:userList){
										if(allUser.getUserName().equals(blocks)){
									System.out.println("Name: "+allUser.getName()+
											"\nUsername: "+allUser.getUserName()+
											"\nDate of Birth: "+allUser.getDoB()+
											"\nSchool: "+allUser.getSchool()+
											"\n---------------------------");
										}
									}
									
								}
							}
						}
					}
				
	
				}
			}
		}
		
		if(signExit==0){
			System.out.println("Error: Please sign in and try again.");
		}
		else if(blockUserExit==0){
			System.out.println("You haven’t blocked any users yet!");
		}
		else if(blockFriendExit==0){
			System.out.println("You haven’t blocked any friends yet!");
		}
		
		
	
		
	}
	
	public void SHOWBLOCKEDUSERS(){
		System.out.println("-----------------------");
		System.out.println("Command: SHOWBLOCKEDUSERS");
		int signExit=0;
		int blockUserExit=0;
		for(User user:userList){
			for(Integer id:signinList){
				if(user.getUserID()==id){
					signExit=1;
					if(user.blockedList.size()>0){
						blockUserExit=1;
						for(User allUser:userList){
							for(String blocks:user.blockedList){
								if(allUser.getUserName().equals(blocks)){
							System.out.println("Name: "+allUser.getName()+
									"\nUsername: "+allUser.getUserName()+
									"\nDate of Birth: "+allUser.getDoB()+
									"\nSchool: "+allUser.getSchool()+
									"\n---------------------------");
								}
							}
						}
					}
				
	
				}
			}
		}
		
		if(signExit==0){
			System.out.println("Error: Please sign in and try again.");
		}
		else if(blockUserExit==0){
			System.out.println("You haven’t blocked any users yet!");
		}
		
		
	}
	
	public void LISTFRIENDS(){
		System.out.println("-----------------------");
		System.out.println("Command: LISTUSERS");
		int signExit=0;
		int noFriend=0;
		
		for(User user:userList){
			for(Integer id:signinList){
				if(user.getUserID()==id){
					signExit=1;
					if(user.friendList.size()>0){
						noFriend=1;
		
						for(User allUser:userList){
							for(String friend:user.friendList){
								if(friend.equals(allUser.getUserName())){
									System.out.println("Name: "+allUser.getName()+
											"\nUsername: "+allUser.getUserName()+
											"\nDate of Birth: "+allUser.getDoB()+
											"\nSchool: "+allUser.getSchool()+
											"\n---------------------------");
								}
							
							}
						}
					}
		
				}
			}
		}
		
		if(signExit==0){
			System.out.println("Error: Please sign in and try again.");
		}
		else if(noFriend==0){
			System.out.println("You haven’t added any friends yet!");
		}
		
	
		
	}
	
	public void ADDPOSTTEXT(String text,double longitude, double latitude,String taggedUsers) throws ParseException{
		
		System.out.println("-----------------------");
		System.out.println("Command: ADDPOST-TEXT\t"+text+"\t"+longitude+"\t"+latitude+"\t"+taggedUsers);
		
		int signExit=0;
		Location loc = new Location(longitude,latitude);
		CopyOnWriteArrayList<String> taggedList=new CopyOnWriteArrayList<String>();
		String[] tags = taggedUsers.split(":");
		
		for(User user:userList){
			for(Integer id:signinList){
				if(user.getUserID()==id){
					signExit=1;
					if(tags.length>0){
						for(int i=0;i<tags.length;i++){
							int tagExit=0;
							for(String usern:user.friendList){
								if(tags[i].equals(usern)){
									for(User alls : userList){
										if(alls.getUserName().equals(tags[i])){
											tagExit=1;
											taggedList.add(alls.getName());
										}
									}
									
									
								}
							}
							if(tagExit==0){
								for(User users:userList){
									if(tags[i].equals(users.getUserName())){
										System.out.println(users.getName()+" is not your friend, and will not be tagged!");
									}
								}
								
							}
							
						}	
						
					}
					Date postDate = new Date();
					
					
					UUID postID = UUID.randomUUID();
					TextPosts tPost = new TextPosts(postID, postDate, text,loc.getLongitude(), loc.getLatitude(),taggedList);
					user.posts.add(tPost);
					System.out.println("The post has been successfully added.");
					
				}
			}
			
		}
		if(signExit==0){
			System.out.println("Error: Please sign in and try again.");
		}
		
		
	}
	
	public void ADDPOSTIMAGE(String text,double longitude, double latitude,String taggedUsers,String imageName, String resolution){
			
			System.out.println("-----------------------");
			System.out.println("Command: ADDPOST-IMAGE\t"+text+"\t"+longitude+"\t"+latitude+"\t"+taggedUsers+"\t"+imageName+"\t"+resolution);
			
			int signExit=0;
			Location loc = new Location(longitude,latitude);
			CopyOnWriteArrayList<String> taggedList=new CopyOnWriteArrayList<String>();
			String[] tags = taggedUsers.split(":");
			
			for(User user:userList){
				for(Integer id:signinList){
					if(user.getUserID()==id){
						signExit=1;
						if(tags.length>0){
							for(int i=0;i<tags.length;i++){
								int tagExit=0;
								for(String usern:user.friendList){
									if(tags[i].equals(usern)){
										for(User alls : userList){
											if(alls.getUserName().equals(tags[i])){
												tagExit=1;
												taggedList.add(alls.getName());
											}
										}
										
									}
								}
								if(tagExit==0){
									for(User users:userList){
										if(tags[i].equals(users.getUserName())){
											System.out.println(users.getName()+" is not your friend, and will not be tagged!");
										}
									}
									
								}
								
							}	
							
						}
						Date postDate = new Date();
						UUID postID = UUID.randomUUID();
						ImagePosts tPost = new ImagePosts(postID, postDate, text,loc.getLongitude(), loc.getLatitude(),taggedList,imageName,resolution);
						user.posts.add(tPost);
						System.out.println("The post has been successfully added.");
						
					}
				}
				
			}
			if(signExit==0){
				System.out.println("Error: Please sign in and try again.");
			}
			
			
		}
	
	public void ADDPOSTVIDEO(String text,double longitude, double latitude,String taggedUsers,String videoName, double vidDur){
		
		System.out.println("-----------------------");
		System.out.println("Command: ADDPOST-VIDEO\t"+text+"\t"+longitude+"\t"+latitude+"\t"+taggedUsers+"\t"+videoName+"\t"+vidDur);
		
		int signExit=0;
		int durExit=0;
		Location loc = new Location(longitude,latitude);
		CopyOnWriteArrayList<String> taggedList=new CopyOnWriteArrayList<String>();
		String[] tags = taggedUsers.split(":");
		
		for(User user:userList){
			for(Integer id:signinList){
				if(user.getUserID()==id){
					signExit=1;
					if(tags.length>0){
						if(vidDur<=10){
							durExit=1;
							for(int i=0;i<tags.length;i++){
								int tagExit=0;
								for(String usern:user.friendList){
									if(tags[i].equals(usern)){
										for(User alls : userList){
											if(alls.getUserName().equals(tags[i])){
												tagExit=1;
												taggedList.add(alls.getName());
											}
										}
										
									}
								}
								if(tagExit==0){
									for(User users:userList){
										if(tags[i].equals(users.getUserName())){
											System.out.println(users.getName()+" is not your friend, and will not be tagged!");
										}
									}
									
								}
								
							}
						}
							
						
					}
					Date postDate = new Date();
					UUID postID = UUID.randomUUID();
					VideoPosts tPost = new VideoPosts(postID, postDate, text,loc.getLongitude(), loc.getLatitude(),taggedList,videoName,vidDur);
					user.posts.add(tPost);
					System.out.println("The post has been successfully added.");
					
				}
			}
			
		}
		if(signExit==0){
			System.out.println("Error: Please sign in and try again.");
		}
		else if(durExit==0){
			System.out.println("Error: Your video exceeds maximum allowed duration of 10 minutes.");
		}
		
		
	}
	
	public void REMOVELASTPOST(){
		System.out.println("-----------------------");
		System.out.println("Command: REMOVELASTPOST");
		int signExit=0;
		int postExit=0;
		
		for(User user:userList){
			for(Integer id:signinList){
				if(user.getUserID()==id){
					signExit=1;
					if(user.posts.size()>0){
						postExit=1;
						int lastPost=user.posts.size()-1;
						user.posts.remove(lastPost);
						System.out.println("Your last post has been successfully removed.");
						
					}
				
		
				}
			}
		}
		
		if(signExit==0){
			System.out.println("Error: Please sign in and try again.");
		}
		else if(postExit==0){
			System.out.println("Error: You don't have any posts.");
		}
		
	
		
	}
	
	public void SHOWPOSTS(String userName){
		System.out.println("-----------------------");
		System.out.println("Command: SHOWPOSTS\t"+userName);
		int postExit=0;
		int userExit=0;
		
		
		for(User allUser : userList){
			if(userName.equals(allUser.getUserName())){
				userExit=1;
				if(allUser.posts.size()>0){
					postExit=1;
					System.out.println("**************\n"
							+ userName+"’s Posts\n"
							+ "**************");
					for(Post post : allUser.posts){
						if(post.getClass().equals(TextPosts.class)){
							System.out.println(post.toString());
						}
						else if(post.getClass().equals(ImagePosts.class)){
							System.out.println(post.toString());
						}
						else if(post.getClass().equals(VideoPosts.class)){
							System.out.println(post.toString());
						}
									
					}
							
				}
			}
		}
					
		
		if(postExit==0){
			System.out.println("Error: You don't have any posts.");
		}
		else if(userExit==0){
			System.out.println("No such user!");
		}
		
		
		
	}





	
	
	
	
	

}
