package nanoEnglish;

import java.util.Comparator;

public class Dictionary_Structure {

    public String word;
    public String translation1;
    public String translation2;
    public String translation3;
    public String translation4;
    public String translation5;

    public Dictionary_Structure() {
        word = "";
        translation1 ="";
        translation2 ="";
        translation3 ="";
        translation4 ="";
        translation5 ="";
    }

    public Dictionary_Structure(String word, String translation1,String translation2,String translation3,
    		String translation4,String translation5) {
        this.word = word;
        this.translation1 = translation1;
        this.translation2 = translation2;
        this.translation3 = translation3;
        this.translation4 = translation4;
        this.translation4 = translation5;
    }
    
    public String getWord() {
        return word;
    }
    public String getTranslation1() {
        return translation1;
    }
    public String getTranslation2() {
        return translation2;
    }
    public String getTranslation3() {
        return translation3;
    }
    public String getTranslation4() {
        return translation4;
    }
    public String getTranslation5() {
        return translation5;
    }
}
