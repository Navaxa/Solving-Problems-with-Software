
/**
 * Write a description of class Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {

    public int howMany (String stringa, String stringb) {
        int occurrence = 0;
        int startIndex = 0;
        while(true){
            int apper = stringb.indexOf(stringa, startIndex);
            if(apper == -1){
                break;
            }
            occurrence++;
            startIndex = apper + stringa.length();
        }
        return occurrence;
    }
    
    public void testHowMany(){
        System.out.println(howMany("GAA", "ATGAACGAATTGAATC"));
        System.out.println(howMany("AA", "ATAAAA"));
        
    }
    
}
