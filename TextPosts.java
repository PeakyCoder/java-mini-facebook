/**
 * @author Burak
 * @version 1.2
 * 
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;


public class TextPosts extends Post {
	
	CopyOnWriteArrayList<String> tagged=new CopyOnWriteArrayList<String>();
	
	public TextPosts(UUID postID, Date postDate, String text, double longitude, double latitude, CopyOnWriteArrayList<String> tagged)  {
		super(postID, postDate, text, latitude, longitude);
		this.tagged=tagged;
	}


	public String toString(){
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		String postDate = df.format(getPostDate());
		
		if(tagged.size()==0){
			return getText()+"\nDate: "+postDate+
					"\nLocation: "+getLongitude()+", "+getLatitude()+
					"\n----------------------";		
		}
		else{
			String tags="";
			for(int i=0;i<tagged.size();i++){				
				tags += tagged.get(i)+", ";
			}
			return getText()+"\nDate: "+postDate+
					"\nLocation: "+getLongitude()+", "+getLatitude()+
					"\nFriends tagged in this post: "+tags.substring(0, tags.length()-2)+
					"\n----------------------";		
		}
		
	}


	

}
