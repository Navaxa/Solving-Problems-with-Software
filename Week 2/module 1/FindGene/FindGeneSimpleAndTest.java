
/**
 * Write a description of class findSimpleGene here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FindGeneSimpleAndTest {
    public String findSimpleGene(String dna) {
        String result = "";
        
        int startIndex = dna.indexOf("ATG");       
        if (startIndex == -1) {
            return "";
        }
        int stopIndex = dna.indexOf("TAA", startIndex + 3);
        if (stopIndex == -1) {
            return "";
        }
        result = dna.substring(startIndex, stopIndex + 3);
        
        /*
        if (startIndex == -1 || stopIndex == -1) {
            return result;
        }
        
        if ((stopIndex - startIndex) % 3 == 0) {
            result = dna.substring(startIndex, stopIndex + 3);
        }*/
        
        return result;
    }
    
    public void testSimpleGene() {
        // DNA with no ATG
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is " + dna);
            System.out.println("Gene is " + findSimpleGene(dna));
        
        // DNA with no TAA
        dna = "AATGCTAGGGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna));
        
        // DNA with no “ATG” and “TAA”
        dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna));
        
        // DNA with ATG, TAA and the substring between them is not a multiple of 3
        //dna = "ATGTAA";
        dna = "TTATAA";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna));
        
        // DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
        dna = "TAAGATATGGTGAAGTAA";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna));
    }
}
