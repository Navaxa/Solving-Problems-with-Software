
/**
 * Write a description of class Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Part4 {
    
    public void findLink (){
        URLResource url = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
    
        for(String line : url.lines()){
            int index = line.toLowerCase().indexOf("youtube.com");
            if(index != -1){
                int startIndex = line.lastIndexOf("\"", index);
                int lastIndex = line.indexOf("\"", index);
                
                System.out.println("Youtube: " + line.substring(startIndex + 1, lastIndex));
                                
            }
        }
    }
    
    
}
