import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Arrays;

class AminoAcidTranslator {
    
    // set up of hashmap to store codon definitions
    final static Map<String, String> CODON_MAP  = new HashMap<>();

    static {
        CODON_MAP.put("UUU", "Phenylalanine");
        CODON_MAP.put("UUC", "Phenylalanine");

        CODON_MAP.put("UUA", "Leucine");
        CODON_MAP.put("UUG", "Leucine");
        CODON_MAP.put("CUU", "Leucine");
        CODON_MAP.put("CUC", "Leucine");
        CODON_MAP.put("CUA", "Leucine");
        CODON_MAP.put("CUG", "Leucine");

        CODON_MAP.put("AUG", "Methionine (START CODON)");

        CODON_MAP.put("GUU", "Valine");
        CODON_MAP.put("GUC", "Valine");
        CODON_MAP.put("GUA", "Valine");
        CODON_MAP.put("GUG", "Valine");

        CODON_MAP.put("UCU", "Serine");
        CODON_MAP.put("UCC", "Serine");
        CODON_MAP.put("UCA", "Serine");
        CODON_MAP.put("UCG", "Serine");
        CODON_MAP.put("AGU", "Serine");
        CODON_MAP.put("AGC", "Serine");

        CODON_MAP.put("CCU", "Proline");
        CODON_MAP.put("CCC", "Proline");
        CODON_MAP.put("CCA", "Proline");
        CODON_MAP.put("CCG", "Proline");

        CODON_MAP.put("ACU", "Threonine");
        CODON_MAP.put("ACC", "Threonine");
        CODON_MAP.put("ACA", "Threonine");
        CODON_MAP.put("ACG", "Threonine");

        CODON_MAP.put("GCU", "Alanine");
        CODON_MAP.put("GCC", "Alanine");
        CODON_MAP.put("GCA", "Alanine");
        CODON_MAP.put("GCG", "Alanine");

        CODON_MAP.put("UAU", "Tyrosine");
        CODON_MAP.put("UAC", "Tyrosine");

        CODON_MAP.put("CAU", "Histidine");
        CODON_MAP.put("CAC", "Histidine");

        CODON_MAP.put("CAA", "Glutamine");
        CODON_MAP.put("CAG", "Glutamine");

        CODON_MAP.put("AAU", "Asparagine");
        CODON_MAP.put("AAC", "Asparagine");

        CODON_MAP.put("AAA", "Lysine");
        CODON_MAP.put("AAG", "Lysine");

        CODON_MAP.put("GAU", "Aspartic Acid");
        CODON_MAP.put("GAC", "Aspartic Acid");
        CODON_MAP.put("GAA", "Glutamic Acid");
        CODON_MAP.put("GAG", "Glutamic Acid");

        CODON_MAP.put("UGU", "Cysteine");
        CODON_MAP.put("UGC", "Cysteine");

        CODON_MAP.put("UGG", "Tryptophan");

        CODON_MAP.put("CGU", "Arginine");
        CODON_MAP.put("CGC", "Arginine");
        CODON_MAP.put("CGA", "Arginine");
        CODON_MAP.put("CGG", "Arginine");
        CODON_MAP.put("AGA", "Arginine");
        CODON_MAP.put("AGG", "Arginine");

        CODON_MAP.put("GGU", "Glycine");
        CODON_MAP.put("GGC", "Glycine");
        CODON_MAP.put("GGA", "Glycine");
        CODON_MAP.put("GGG", "Glycine");

        CODON_MAP.put("AUU", "Isoleucine");
        CODON_MAP.put("AUC", "Isoleucine");
        CODON_MAP.put("AUA", "Isoleucine");

        CODON_MAP.put("UAA", "STOP CODON");
        CODON_MAP.put("UAG", "STOP CODON");
        CODON_MAP.put("UGA", "STOP CODON");
    }
    public static void main(String[] args) {
        String userInput = getInput(); // calls getInput() to ask for user input of a string

        System.out.println("Your translated sequence is: ");
        System.out.println(RNAtranslate(userInput)); // calls RNAtranslate() to translate user inputted RNA
    }
    // start of methods 

    // calls the two helper functions of seperate() and translate() to convert the RNA to matching protein 
    static List<String> RNAtranslate(String rnaSequence) {
        return translate(seperate(rnaSequence));
    }

    // method to get user input
    static String getInput() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter a sequence of RNA with no spaces in between. Make sure to only use valid codons!"); // ask user for input
        String input = scnr.nextLine();

        return input;
    }

    //  method used to seperate up the inputted string into every 3 letters to represent a codon
    private static List<String> seperate(String rnaSequence) {
        return Arrays.asList(rnaSequence.split("(?<=\\G.{3})")); // regex used to split every 3 chars
    }

    // method that translates the seperated sequence into matching codons 
    private static List<String> translate(List<String> codons) {
        final List<String> translatedRNA = new ArrayList<String>(); // intialize arraylist
        // for each codon, search for matching entry in codon hash map and add to list 
        for (String codon : codons) { 
            translatedRNA.add(CODON_MAP.get(codon));
        }
        return translatedRNA;
    }
}