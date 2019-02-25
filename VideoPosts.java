import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class VideoPosts extends TextPosts {
	
	String videoName;
	double vidDur;
	
	public VideoPosts(UUID postID, Date postDate, String text, double longitude, double latitude,
			CopyOnWriteArrayList<String> tagged, String videoName, double vidDur) {
		super(postID, postDate, text, latitude, longitude, tagged);
		this.videoName=videoName;
		this.vidDur=vidDur;
		
	}

	public String getVideoName() {
		return videoName;
	}

	public double getVidDur() {
		return vidDur;
	}
	
	public String toString(){
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		String postDate = df.format(getPostDate());
		
		if(tagged.size()==0){
			return getText()+"\nDate: "+postDate+
					"\nLocation: "+getLongitude()+", "+getLatitude()+
					"\nVideo: "+getVideoName()+"\nVideo duration: "+getVidDur()+" minutes"+
							"\n----------------------";	
		}
		else{
			String tags="";
			for(int i=0;i<tagged.size();i++){				
				tags += tagged.get(i)+", ";
			}
			return getText()+"\nDate: "+postDate+
					"\nLocation: "+getLongitude()+", "+getLatitude()+
					"\nVideo: "+getVideoName()+"\nVideo duration: "+getVidDur()+" minutes"+
					"\nFriends tagged in this post: "+tags.substring(0, tags.length()-2)+
					"\n----------------------";
		}
		
	}
	


}
