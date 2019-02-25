/**
 * @author Burak
 * @version 1.2
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		UserCollection coll = new UserCollection();
		
		int userID=0;
		//Read user.txt
		try {
					
			Scanner read_file = new Scanner(new File(args[0]));
			while(read_file.hasNextLine()){
			String line = read_file.nextLine();
			String[] part = line.split("\t");
				
			userID++;
			coll.addUser(userID, part[0], part[1], part[2], part[3], part[4]);
		
	
			}
		read_file.close();
		} catch (FileNotFoundException ex) {
			System.out.println("No File Found!");
			return;
					
					
			}
		
		//Read command.txt
		
		try {
			
			Scanner read_file = new Scanner(new File(args[1]));
			while(read_file.hasNextLine()){
			String line = read_file.nextLine();
			String[] part2 = line.split("\t");
			
			if(new String("ADDUSER").equals(part2[0])){
				userID++;
				coll.ADDUSER(userID, part2[1], part2[2], part2[3], part2[4], part2[5]);
				
			}
			
			else if(new String("REMOVEUSER").equals(part2[0])){
				coll.REMOVEUSER(Integer.parseInt(part2[1]));
			}
			
			else if(new String("SIGNIN").equals(part2[0])){
				coll.SIGNIN(part2[1], part2[2]);
			}
			
			else if(new String("SIGNOUT").equals(part2[0])){
				coll.SIGNOUT();
			}
			
			else if(new String("LISTUSERS").equals(part2[0])){
				coll.LISTUSERS();;
			}
			
			else if(new String("UPDATEPROFILE").equals(part2[0])){
				coll.UPDATEPROFILE(part2[1], part2[2], part2[3]);;
			}
			
			else if(new String("CHPASS").equals(part2[0])){
				coll.CHPASS(part2[1], part2[2]);;
			}
			
			else if(new String("ADDFRIEND").equals(part2[0])){
				coll.ADDFRIEND(part2[1]);;
			}
			
			else if(new String("REMOVEFRIEND").equals(part2[0])){
				coll.REMOVEFRIEND(part2[1]);;
			}
			
			else if(new String("LISTFRIENDS").equals(part2[0])){
				coll.LISTFRIENDS();
			}
			
			else if(new String("BLOCK").equals(part2[0])){
				coll.BLOCK(part2[1]);
			}
			
			else if(new String("SHOWBLOCKEDFRIENDS").equals(part2[0])){
				coll.SHOWBLOCKEDFRIENDS();
			}
			
			else if(new String("UNBLOCK").equals(part2[0])){
				coll.UNBLOCK(part2[1]);
			}
			
			else if(new String("SHOWBLOCKEDUSERS").equals(part2[0])){
				coll.SHOWBLOCKEDUSERS();
			}
			
			else if(new String("ADDPOST-TEXT").equals(part2[0])){
				coll.ADDPOSTTEXT(part2[1], Double.parseDouble(part2[2]), Double.parseDouble(part2[3]), part2[4]);
			}
			
			else if(new String("ADDPOST-IMAGE").equals(part2[0])){
				coll.ADDPOSTIMAGE(part2[1], Double.parseDouble(part2[2]), Double.parseDouble(part2[3]), part2[4], part2[5], part2[6]);
			}
			
			else if(new String("ADDPOST-VIDEO").equals(part2[0])){
				coll.ADDPOSTVIDEO(part2[1], Double.parseDouble(part2[2]), Double.parseDouble(part2[3]), part2[4], part2[5], Double.parseDouble(part2[6]));
			}
			
			else if(new String("REMOVELASTPOST").equals(part2[0])){
				coll.REMOVELASTPOST();
			}
			
			else if(new String("SHOWPOSTS").equals(part2[0])){
				coll.SHOWPOSTS(part2[1]);
			}
			
			
			
			
		
	
			}
		read_file.close();
		} catch (FileNotFoundException ex) {
			System.out.println("No File Found!");
			return;
					
					
			}
		
		
		
		
		
		
		
		
		
		
		
		
		}
		
	}
