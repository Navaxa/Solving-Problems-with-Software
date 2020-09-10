
/**
 * Write a description of class Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    
    public String findSimpleGene (String dna, String startCodon, String stopCodon) {
        int startIndex = dna.indexOf(startCodon);
        if (startIndex == -1)return "";
        
        int stopIndex = dna.indexOf(stopCodon, startIndex + 3);
        if (stopIndex == -1) return "";
      
        return dna.substring(startIndex, stopIndex + 3);
    }
    
    public void testSimpleGene () {
        // DNA with no ATG
        String startCodon = "ATG";
        String stopCodon = "TAA";
        
        String dna = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println("DNA strand is " + dna);
            System.out.println("Gene is " + findSimpleGene(dna, startCodon, stopCodon));
        
        // DNA with no TAA
        dna = "AATGCTAGGGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna, startCodon, stopCodon));
        
        // DNA with no “ATG” and “TAA”
        dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna, startCodon, stopCodon));
        
        // DNA with ATG, TAA and the substring between them is not a multiple of 3
        //dna = "ATGTAA";
        dna = "TTATAA";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna, startCodon, stopCodon));
        
        // DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
        dna = "TAAGATATGGTGAAGTAA";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna, startCodon, stopCodon));
    }

}
