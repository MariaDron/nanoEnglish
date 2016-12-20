package nanoEnglish;

public class User {
	
	String nick;
	String password;
	String email;
	int level;
	
	public User(){
		this.nick = "";
		this.email = "";
		this.password = "";
		this.level = 0;
	}
	
	public User(String nick, String email, String password){
		this.nick = nick;
		this.email = email;
		this.password = password;
		this.level = 0;
	}
}

class Dickt{
	String word, trans1, trans2, trans3, trans4, trans5;
	
	public Dickt(){
		this.word = "";
		this.trans1 = "";
		this.trans2 = "";
		this.trans3 = "";
		this.trans4 = "";
		this.trans5 = "";
	}
	
	public Dickt(String word, String trans1, String trans2, String trans3, String trans4, String trans5){
		this.word = word;
		this.trans1 = trans1;
		this.trans2 = trans2;
		this.trans3 = trans3;
		this.trans4 = trans4;
		this.trans5 = trans5;
	}
}