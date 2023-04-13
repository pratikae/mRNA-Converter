import java.util.*;
import java.io.*;

public class ProteinSynthesizer extends MRNAConverter {
    static String getProtein(String codon) {

        if (codon.equals("TTT") || codon.equals("TTC")) {
            return "Phe";
        } else if (codon.equals("TTA") || codon.equals("TTG") || codon.equals("CTT") || codon.equals("CTC") || codon.equals("CTA") || codon.equals("CTG")) {
            return "Lue";
        } else if (codon.equals("ATT") || codon.equals("ATC") || codon.equals("ATA")) {
            return "Ile";
        } else if (codon.equals("ATG")) {
            return "Met";
        } else if (codon.substring(0, 2).equals("GT")) {
            return "Val";
        } else if (codon.substring(0, 2).equals("TC")) {
            return "Ser";
        } else if (codon.substring(0, 2).equals("CC")) {
            return "Pro";
        } else if (codon.substring(0, 2).equals("AC")) {
            return "Thr";
        } else if (codon.substring(0, 2).equals("GC")) {
            return "Ala";
        } else if (codon.substring(0, 2).equals("CG")) {
            return "Arg";
        } else if (codon.substring(0, 2).equals("GG")) {
            return "Gly";
        } else if (codon.equals("TAT") || codon.equals("TAC")) {
            return "Tyr";
        } else if (codon.equals("CAT") || codon.equals("CAC")) {
            return "His";
        } else if (codon.equals("CCA") || codon.equals("CAG")) {
            return "Gln";
        } else if (codon.equals("AAT") || codon.equals("AAC")) {
            return "Asn";
        } else if (codon.equals("AAA") || codon.equals("AAG")) {
            return "Lys";
        } else if (codon.equals("GAT") || codon.equals("GAC")) {
            return "Asp";
        } else if (codon.equals("GAA") || codon.equals("GAG")) {
            return "Glu";
        } else if (codon.equals("TGT") || codon.equals("TGC")) {
            return "Cys";
        } else if (codon.equals("TGG")) {
            return "Trp";
        } else if (codon.equals("AGT") || codon.equals("AGC")) {
            return "Ser";
        } else if (codon.equals("AGA") || codon.equals("AGG")) {
            return "Arg";
        } else if (codon.equals("TAA") || codon.equals("TAG") || codon.equals("TGA")) {
            return "STOP";
        } else {
            return "";
        }

    }

    static void printProteins(String mRNA) {
        if (mRNA.length() % 3 != 0) {
            return;
        }

        int i = 0;
        while (i < mRNA.length()) {
            String codon = mRNA.substring(i, i + 3);
            String protein = getProtein(codon);
            if (!protein.equals("STOP")) {
                System.out.println(protein);
            } else {
                return;
            }

            i += 3;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(new File("input.txt"));
        while (console.hasNext()) {
            printProteins(getMRNA(console.next()));
        }
    }


}
