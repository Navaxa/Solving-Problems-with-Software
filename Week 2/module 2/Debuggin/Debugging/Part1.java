
/**
 * Write a description of class Part1 here.
 * 
 * @author (Miguel Nava) 
 * @version (a version number or a date)
 */
public class Part1 {
    public void findAbc (String input){
        int index = input.indexOf("abc");
        while (true) {
            if (index == -1 || index >= input.length() - 3) {
                break;
            }
            
            
            String found = input.substring(index+1, index+4);
            System.out.println(found);
            System.out.println("indice: " + index);
            index = input.indexOf("abc", index+3);
            System.out.println("indice last update: " + index);
        }
        
    }
    public void test() {
        //findAbc("abcd");
        findAbc("abcabcabcabca");
    }
}
