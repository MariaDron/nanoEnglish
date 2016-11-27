package nanoEnglish;

public class User {
	
	String nick;
	String password;
	String email;
	int level;
	
	public User(String nick, String email, String password){
		this.nick = nick;
		this.email = email;
		this.password = password;
	}
	
	public void read_Dictionary(){
		if (level == 1){
			ReadDictionary file_reader = new ReadDictionary("LowLevel");
		}
		if (level == 2){
			ReadDictionary file_reader = new ReadDictionary("IntermediateLevel");
		}
		if (level == 3){
			ReadDictionary file_reader = new ReadDictionary("HighLevel");
		}
	}
}
