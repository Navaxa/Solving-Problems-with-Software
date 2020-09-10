
/**
 * Write a description of class Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinGeneWhile {
    
    
    
    public String findSimpleGene (String dna) {
        int startIndex = dna.indexOf("ATG");
        int currenIndex = dna.indexOf("TAA", startIndex + 3);
        
        while(currenIndex != -1) {
            if((currenIndex - startIndex) % 3 == 0){
                return dna.substring(startIndex, currenIndex + 3);
            } else {
                currenIndex = dna.indexOf("TAA", currenIndex + 1);
            }
        }
        return "";
    }
    
    public void testSimpleGene () {

        String dna = "AATGCGTAATTAATCG";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna));
        
        dna = "CGATGGTTGATAAGCCTAAGTATATAA";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna));
        
        dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna));

    }
}
