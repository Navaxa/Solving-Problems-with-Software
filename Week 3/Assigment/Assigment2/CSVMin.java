
/**
 * Write a description of class CSVMin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMin {
    public CSVRecord coldestHourInFile (CSVParser parser){
        CSVRecord largestSoFar = null;
        //For each row (currentRow) in the CSV File
        for (CSVRecord currentRow : parser) {
            //If largestSoFar is nothing
            largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
        }
        //The largestSoFar is the answer
        return largestSoFar;
    }
    
    public void testColdestHourInFile() {
        String relative = "C:/Users/Navaxa/Documents/Documentos/BlueJ/Solving Problems with Software/Week 3/CSVmax/data/2014/weather-2014-05-01.csv";
        FileResource fr = new FileResource(relative);
        CSVRecord largest = coldestHourInFile(fr.getCSVParser());
        System.out.println("Cold temperature was " + largest.get("TemperatureF") +
                   " at " + largest.get("TimeEDT"));
    }
    
    public CSVRecord coldtestInManyDays() {
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        // iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            // use method to get largest in file.
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
        }
        //The largestSoFar is the answer
        return largestSoFar;
    }
    
    public void testColdtestInManyDays () {
        CSVRecord largest = coldtestInManyDays();
        System.out.println("Cold temperature was " + largest.get("TemperatureF") +
                   " at " + largest.get("DateUTC"));
    }
    
    public CSVRecord getLargestOfTwo(CSVRecord currentRow, CSVRecord largestSoFar){
        if (largestSoFar == null) {
                largestSoFar = currentRow;
            }
            //Otherwise
            else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                //Check if currentRow’s temperature > largestSoFar’s
                if (currentTemp < largestTemp) {
                    
                    //If so update largestSoFar to currentRow
                    largestSoFar = currentRow;
                }
            }
        return largestSoFar;
    }
    
    public File fileWithColdestTemperature (){
                         
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        File file = null;
        // iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            // use method to get largest in file.
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            if (largestSoFar == null) {
                largestSoFar = currentRow;
            }
            //Otherwise
            else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                //Check if currentRow’s temperature > largestSoFar’s
                if (currentTemp < largestTemp) {
                    
                    //If so update largestSoFar to currentRow
                    largestSoFar = currentRow;
                    file = f;
                }
            }
        }
        //The largestSoFar is the answer
  
        return file;
    }
    
    public void testFileWithColdestTemperature (){
        File nameFile = fileWithColdestTemperature();
        System.out.println("Coldest day was in file: " + nameFile.getName()); 
        
        String relative = nameFile.toString();
        FileResource fr = new FileResource(relative);
        CSVRecord largest = coldestHourInFile(fr.getCSVParser());
        
        System.out.println("Cold temperature was " + largest.get("TemperatureF") +
                   " at " + largest.get("TimeEST"));
                   
        System.out.println("All the Temperatures on the coldest day were:");
       
        
        for(CSVRecord currentRow : fr.getCSVParser()){
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            System.out.println(nameFile.getName() + " " + currentTemp);
        }
    }
    
    public CSVRecord getLowerHumidity(CSVRecord currentRow, CSVRecord largestSoFar){
        if (largestSoFar == null) {
                largestSoFar = currentRow;
            }
            //Otherwise
            else {
                               
                int currentTemp = Integer.parseInt(currentRow.get("Humidity"));
                int largestTemp = Integer.parseInt(largestSoFar.get("Humidity"));
                //Check if currentRow’s temperature > largestSoFar’s
                if (currentTemp < largestTemp) {
                    
                    //If so update largestSoFar to currentRow
                    largestSoFar = currentRow;
                }
            }
        return largestSoFar;
    }
    
    public CSVRecord lowestHumidityInFile (CSVParser parser){
        CSVRecord lowerSoFar = null;
        //For each row (currentRow) in the CSV File
        for (CSVRecord currentRow : parser) {
            //If largestSoFar is nothing
            lowerSoFar = getLowerHumidity(currentRow, lowerSoFar);
        }
        //The largestSoFar is the answer
        return lowerSoFar;
    }
    
    public void testLowestHumidityInFile (){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        
        System.out.println("Lowest Humidity was " + csv.get("Humidity") +
                   " at " + csv.get("DateUTC"));
    }
    
    public CSVRecord lowerHumidityInManyFiles () {
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        // iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            // use method to get largest in file.
            CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
            largestSoFar = getLowerHumidity(currentRow, largestSoFar);
        }
        //The largestSoFar is the answer
        return largestSoFar;
    }
    
    public void testLowestHumidityInManyFiles  () {
        CSVRecord csv = lowerHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + csv.get("Humidity") +
                   " at " + csv.get("DateUTC"));
    }
    
    public double averageTemperatureInFile (CSVParser parser){
        int count = 0;
        double countHumidity = 0.0;
        for(CSVRecord r : parser){
            countHumidity  += Double.parseDouble(r.get("TemperatureF"));
            count ++;
        }
        
        
        return countHumidity/count;
    }
    
    public void testAverageTemperatureInFile () {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double average = averageTemperatureInFile(parser);
        
        System.out.println("Average temperature in file is " + average);
    }
    
    public double averageTemperatureWithHighHumidityInFile (CSVParser parser, int value){
        int count = 0;
        double countHumidity = 0.0;
        for(CSVRecord r : parser){
            int currentTemp = Integer.parseInt(r.get("Humidity"));
            
            if (currentTemp >= value){
                countHumidity  += Double.parseDouble(r.get("TemperatureF"));
                count ++;
            }
            
        }
        if(countHumidity == 0.0){
            return 0.0;
        }
        return countHumidity/count;
    }
    
    public void testAverageTemperatureWithHighHumidityInFile (){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double average = averageTemperatureWithHighHumidityInFile(parser, 80);
        if ( average == 0.0){
            System.out.println("No temperatures with that humidity");
        } else {
            System.out.println("Average Temp when high Humidity is " + average);
        }
    }
}
