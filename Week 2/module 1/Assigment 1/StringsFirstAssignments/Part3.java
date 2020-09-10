
/**
 * Write a description of class Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    
    public boolean twoOccurrences (String stringa, String stringb){
        int count = 0;
        int firstOccurrence = stringb.indexOf(stringa);
        int lastOcurrence = stringb.lastIndexOf(stringa);
        if(firstOccurrence != lastOcurrence) return true;
        else return false;
    }
    
    public void testing (){ 
        System.out.println(twoOccurrences ("by", "A story by Abby Long"));
        System.out.println(lastPart ("an", "banana"));
    }
    
    public String lastPart (String stringa, String stringb){
        int firstOccurrence = stringb.indexOf(stringa);
        if(firstOccurrence == -1)
        return stringb;
        
        return stringb.substring(firstOccurrence + stringa.length());
    }
}
