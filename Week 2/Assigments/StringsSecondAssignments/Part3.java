
/**
 * Write a description of class Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    
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
    
    public int countGenes (String dna){
        String gen = findGene(dna);
        System.out.println(gen);
        if(gen.length() == -1){
            return 0;
        }
        int res = gen.length()/3;
        return res;
    }
    
    public void testCountGenes () {
        System.out.println(countGenes("ATGTAAGATGCCCTAGT"));
        System.out.println(countGenes("GATGCCCTAGT"));
    }
}
