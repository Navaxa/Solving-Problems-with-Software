/**
 * Write a description of class tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class Part1 {
    
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "cocoa"));
        
    }
    
    public String countryInfo (CSVParser parser, String country){
        String export = "";
        String values = "";
        for(CSVRecord record: parser){
            String c = record.get("Country");
            if (c.contains(country)){
                export = record.get("Exports");
                values = record.get("Value (dollars)");
                return country + ":" + export + ":" + values;
            }
           
        }
        return "NOT FOUND";
    }
    
    public void listExportersTwoProducts (CSVParser parser, String exportItem1, String exportItem2){
        for(CSVRecord record: parser){
            String export = record.get("Exports");
            if (export.contains(exportItem1) && export.contains(exportItem2)){
                System.out.println(record.get("Country"));
            }
           
        }
    }
    public void testlistExportersTwoProducts(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "cotton", "flowers");
    }
    
    public int numberOfExporters (CSVParser parser, String exportItem){
        int count = 0;
        for(CSVRecord record: parser){
            String export = record.get("Exports");
            if (export.contains(exportItem)){
                count ++;
            }
           
        }
        return count;
    }
    public void testNumberOfExporters(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(numberOfExporters(parser, "cocoa"));
        
    }
    
    public void bigExporters (CSVParser parser, String cant){
      for(CSVRecord record: parser){
            String value = record.get("Value (dollars)");
            if (value.length() > cant.length()){
                System.out.print(record.get("Country") + " ");
                System.out.println(value);
            }
           
        }          
    }
    
    public void testBigExporters(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");
        
    }
}
