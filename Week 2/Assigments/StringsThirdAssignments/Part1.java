
/**
 * Write a description of class Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1){
            int diff = currIndex - startIndex;
            if(diff % 3 == 0){
                return currIndex;
            } else {
                currIndex = dna.indexOf(stopCodon,currIndex + 1);
            }
        }
        
        return dna.length();
    }
    public void testFindStop() {
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        int dex = findStopCodon(dna, 0, "TAA");
        if (dex != 9) System.out.println("error on 9");
        dex = findStopCodon(dna, 9, "TAA");
        if (dex != 21) System.out.println("error on 21");
        dex = findStopCodon(dna, 1, "TAA");
        if (dex != -1) System.out.println("error on 26");
        dex = findStopCodon(dna, 0, "TAG");
        if (dex != -1) System.out.println("error on 26");
        System.out.println("Test finalished");
    }
    public String findGene(String dna){
      int startIndex = dna.indexOf("ATG");
      if(startIndex == -1){
          return "";
      }
      int taaIndex = findStopCodon(dna, startIndex, "TAA");
      int tagIndex = findStopCodon(dna, startIndex, "TAG");
      int tgaIndex = findStopCodon(dna, startIndex, "TGA");
      int temp = Math.min(taaIndex, tagIndex);
      //int minIndex = Math.min(temp, tgaIndex);
      int minIndex =0;
      
      if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)){
          minIndex = tgaIndex;
        } else {
          minIndex = taaIndex; 
        }
      
      if (minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)){
          minIndex = tagIndex;
        }
      if (minIndex == -1){
          return "";
      }
      return dna.substring(startIndex, minIndex + 3);
    }
    public void testFindGene() {
        String dna = "AATGCTAACTAGCTGACTAAT";
        String gene = findGene(dna);
        if(!gene.equals("ATGCCCGGGAAATAA")){
            System.out.println("error");
        }
        System.out.println("Test finalished");
    }
    public void printAllGenes(String dna){
        int startIndex = 0;
        while(true){
            String currGene = findGene(dna);
            if(currGene.isEmpty()){
                break;
            }
             System.out.println(currGene);
             startIndex = dna.indexOf(currGene,startIndex)+ currGene.length();
                
        }
       
    }

    public StorageResource getAllGenes(String dna){
        int startIndex = 0;
        StorageResource gene = new StorageResource();
        while(true){
            String currGene = findGene(dna);
            if(currGene.isEmpty()){
                break;
            }
            gene.add(currGene);
            System.out.println(currGene);
            startIndex = dna.indexOf(currGene,startIndex)+ currGene.length();
                
        }
        return gene;
    }
    public void testOn(String dna){ 
        if(dna.isEmpty()){
            dna = "empty string"; 
        }
        System.out.println("Testing printAllGenes on: " + dna);
        StorageResource genes = getAllGenes(dna);
        int count = 0;
        for(String s: genes.data()){
            System.out.println(s);
            count ++;
        }
        System.out.println("number of genes: " + count);
        //printAllGenes(dna);        
    }
    public void test() {
        testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
        testOn("");
        testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
    }
    
    public double cgRatio(String dna) {
		double charRatio = 0.0;
		double strLen = dna.length();

		for(int i = 0; i < strLen; i++) {
			if(dna.charAt(i) == 'C' || dna.charAt(i) == 'G') {
				charRatio++;
			}
		}

		double ratio = charRatio / strLen;
		return ratio;
	}
    
    public void countCTG () {
        System.out.println(cgRatio("ATGCCATAG"));
    }
    
    public void processGenes (StorageResource sr){
        int countCad = 0;
        int countCadRel = 0;
        int genMaxLaegest = 0;
        int countGenes = 0;
        for (String s : sr.data()){
            if(s.length() > 60){
                System.out.println(s);
                countCad ++;
            }
            double re = cgRatio(s);
            if(re > 0.35){
                System.out.println("Cad's relations: " + re);
                countCadRel ++;
            }
            
            if(s.length() > genMaxLaegest) {
                genMaxLaegest = s.length();
            }
            countGenes ++;
        }
        System.out.println("number String > 9 characters: " + countCad); 
        System.out.println("number Cad's relation > 0.35: " + countCadRel);
        System.out.println("Gen most largest: " + genMaxLaegest);
        System.out.println("number of genes: " + countGenes);
    }
    public void testProcessGenes(){
        FileResource fr = new FileResource("brca1line.txt");
        StorageResource sr = getAllGenes(fr.asString().toUpperCase());
        processGenes(sr);
    }
}
