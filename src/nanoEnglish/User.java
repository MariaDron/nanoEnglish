package nanoEnglish;

public class User {
	
	String name;
	int level;
	
	public User(String name, int level){
		this.name = name;
		this.level = level;
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
