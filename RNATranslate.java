import java.util.*;
import java.util.ArrayList;
import java.util.List;

class AminoAcidTranslator {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter a sequence of RNA: "); // ask user for input
        String input = scnr.nextLine(); 

        System.out.println("Your seperated codons are:"); // display seperated version 
        for (String rna : seperate(input)) { // calls seperate function
            System.out.println(rna);
        }
    }
    
    private static List<String> seperate(String rna) {
        List<String> rnaString = new ArrayList<String>(); // intialize arraylist
        int length = rna.length(); // length of rna given
        for (int i = 0;  i < length; i+=3) { // go through entire string, seperate at every 3 chars
            rnaString.add(rna.substring(i, Math.min(length, i + 3)));
        }
        return rnaString; // return result of seperation
    }
}