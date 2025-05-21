import java.util.*;

public class MRNAConverter {
    public static boolean validDNA(String DNA) {
        DNA = DNA.toUpperCase();
        String valid = "ATCG";

        int i = 0;
        while (i < DNA.length()) {
            if (!valid.contains(DNA.charAt(i) + "")) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static String getMRNA(String DNA, int strandType) {
        DNA = DNA.toUpperCase();
        return strandType == 1 ? fromCoding(DNA) : fromTemplate(DNA);
    }

    private static String fromCoding(String DNA) {
        DNA = DNA.toUpperCase();
        String mRNA = "";
        for (int i = 0; i < DNA.length(); i++) {
            char base = DNA.charAt(i);
            switch (base) {
                case 'A':
                    mRNA += "A";
                    break;
                case 'T':
                    mRNA += "U";
                    break;
                case 'G':
                    mRNA += "G";
                    break;
                case 'C':
                    mRNA += "C";
                    break;
                default:
                    System.out.println("invalid DNA sequence");
                    break;
            }
        }
        return mRNA;
    }

    private static String fromTemplate(String DNA) {
        DNA = DNA.toUpperCase();
        String mRNA = "";
        for (int i = DNA.length() - 1; i >= 0; i--) {
            char base = DNA.charAt(i);
            switch (base) {
                case 'A':
                    mRNA += "U";
                    break;
                case 'T':
                    mRNA += "A";
                    break;
                case 'G':
                    mRNA += "C";
                    break;
                case 'C':
                    mRNA += "G";
                    break;
                default:
                    System.out.println("invalid DNA sequence");
                    break;
            }
        }
        return mRNA;
    }
}
