
/**
 * Write a description of class BabyBirths here.
 * 
 * @author (Miguel Nava) 
 * @version (0.0.1)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
public class BabyBirths {
    
    public void printNames () {
        FileResource fr = new FileResource();
        for(CSVRecord record : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(record.get(2));
            if(numBorn <= 100) {
                System.out.println("Name " + record.get(0) +
                                " Gender " + record.get(1) +
                                " Num Born " + record.get(2));
            }
        }
    }
    
    public void totalBirths(FileResource fr){
        int totalBirth = 0;
        int f = 0;
        int m = 0;
        for(CSVRecord record : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(record.get(2));
            totalBirth += numBorn;
            String gender = record.get(1);
            if(gender.equals("M")){
                m ++;
            }
            if(gender.equals("F")){
                f ++;
            }
            
        }
        System.out.println("total births: " + totalBirth);
        System.out.println("total births girls: " + f);
        System.out.println("total births boys: " + m);
    }
    
    public void testTotalBirths(){
        FileResource fr = new FileResource("data/yob1900.csv");
        totalBirths(fr);
    }
    
    public int getRank (int year, String name, String gender) {
        int range = 0;
        FileResource fr = new FileResource("data/yob" + year + ".csv");
        for(CSVRecord record : fr.getCSVParser(false)){
            String n = record.get(0);
            String g = record.get(1);
            if(g.equals(gender)){
                range++;
                if(n.equals(name)){
                    break;
                }
            }            
        }
        return range;
    }
    
    public void testGetRank(){
        System.out.println(getRank(1971, "Frank", "M"));
    }
    
    public String getName (int year, int rank, String gender){
        FileResource fr = new FileResource("data/yob" + year +".csv");
        int r = 0;
        for(CSVRecord record : fr.getCSVParser(false)){
            String g = record.get(1);
            if(g.equals(gender)){
                r ++;
                if(r == rank){
                    return record.get(0);
                }
            }            
        }
        return "NOT NAME";
    }
    
    public void testGetName(){
        System.out.println(getName(1982, 450, "M"));
    }
    
    public void whatIsNameInYear (String name, int year, int newYear, String OfGender){
        int popularRank = getRank(year, name, OfGender);
        String popularName = getName(newYear, popularRank, OfGender);
        System.out.println(name + " born in " + year + " would be " + 
                            popularName + " if she was born in " + newYear);
    }
    
    public void testWhatIsNameInYear(){
        whatIsNameInYear("Owen", 1974, 2014, "M");
    }
    
    public int yearOfHighestRank (String name, String gender){
        int year = Integer.MIN_VALUE;
        int rank = Integer.MAX_VALUE;
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()) {
            int currentYear = Integer.parseInt(f.getName().substring(3, 7));
            int currentRank = getRank(currentYear, name, gender);
            
            if (currentRank != -1 && currentRank < rank) {
                rank = currentRank;
                year = currentYear;
            }
            
        } 
        
        if (year == Integer.MIN_VALUE) {
            return -1;
        } else {
            return year;
        }
    }
    
    public void testYearOfHighestRank() {
        String name = "Mich";
        String gender = "M";
        System.out.println(name + " most popular year is " + yearOfHighestRank(name, gender));
    }
    
    public double getAverageRank (String name, String gender){
        DirectoryResource dr = new DirectoryResource();
        double countRank= 0.0 ;
        double count = 0.0;
        for (File file : dr.selectedFiles()) {
            int year = Integer.parseInt(file.getName().substring(3, 7));
            int rank = getRank (year, name, gender);
            
            if(rank != -1){
                countRank += rank;
                count ++;
            }
        }
        double res = countRank/count; 
        System.out.println("countRank: " + countRank);
        System.out.println("count: " + count);
        System.out.println("res: " + res);
        if(count == 0){
            res = -1.0;
        }
        return res;
    }
    
    public void testGetAverageRank () {
        System.out.println(getAverageRank("Robert", "M"));
    }
    
    public int getTotalBirthsRankedHigher (int year, String name, String gender){
        FileResource fr = new FileResource("data/yob" + year +".csv");
        int countName = 0;
        int birth = 0;
        for(CSVRecord record : fr.getCSVParser(false)){
            String n = record.get(0);
            String g = record.get(1);
            int numBirths = Integer.parseInt(record.get(2));
            
            if (n.equals(name) && g.equals(gender)){
                birth = numBirths;
            }
            if(g.equals(gender)){
                if(numBirths >= birth){
                    countName += numBirths;
                }
            }
            
                       
        }
        return countName-birth;
    }
    
    public void testGetTotalBirthsRankedHigher(){
        System.out.println(getTotalBirthsRankedHigher(1990, "Drew", "M"));
    }
}
