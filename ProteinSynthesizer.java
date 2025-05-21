import java.util.*;

public class ProteinSynthesizer extends MRNAConverter {
    static String codonWheel(String codon) {
        switch (codon.charAt(0)) {
            case 'U':
                switch (codon.charAt(1)) {
                    case 'U':
                        if (codon.charAt(2) == 'U' || codon.charAt(2) == 'C') {
                            return  "phe";
                        } else {
                            return  "leu";
                        }
                    case 'C':
                        return  "ser";
                    case 'A':
                        if (codon.charAt(2) == 'U' || codon.charAt(2) == 'C') {
                            return  "tyr";
                        } else {
                            return  "STOP";
                        }
                    case 'G':
                        if (codon.charAt(2) == 'U' || codon.charAt(2) == 'C') {
                            return  "cys";
                        } else if (codon.charAt(2) == 'G') {
                            return  "trp";
                        } else {
                            return "STOP";
                        }
                    default:
                        return "invalid codon";
                }
            case 'C':
                switch (codon.charAt(1)) {
                    case 'U':
                        return "leu";
                    case 'C':
                        return "pro";
                    case 'A':
                        if (codon.charAt(2) == 'U' || codon.charAt(2) == 'C') {
                            return "his";
                        } else {
                            return "gln";
                        }
                    case 'G':
                        return "arg";
                    default:
                        return "invalid codon";
                }
            case 'A':
                switch (codon.charAt(1)) {
                    case 'U':
                        if (codon.charAt(2) == 'G') {
                            return "met";
                        } else {
                            return "ile";
                        }
                    case 'C':
                        return "thr";
                    case 'A':
                        if (codon.charAt(2) == 'G' || codon.charAt(2) == 'C') {
                            return "asn";
                        } else {
                            return "lys";
                        }
                    case 'G':
                        if (codon.charAt(2) == 'G' || codon.charAt(2) == 'C') {
                            return "ser";
                        } else {
                            return "arg";
                        }
                }
            case 'G':
                switch (codon.charAt(1)) {
                    case 'U':
                        return "val";
                    case 'C':
                        return "ala";
                    case 'A':
                        if (codon.charAt(2) == 'G' || codon.charAt(2) == 'C') {
                            return "asp";
                        } else {
                            return "glu";
                        }
                    case 'G':
                        return "gly";
                }
            default:
                return "invalid codon";
        }
    }

    static void printProteins(String mRNA) {
        int startIndex = -1;
        // establish reading frame!
        for (int i = 0; i < mRNA.length() - 3; i++) {
            if (mRNA.charAt(i) == 'A' && mRNA.charAt(i + 1) == 'U' && mRNA.charAt(i + 2) == 'G') {
                startIndex = i;
                break;
            }
        }

        // translation!
        if (startIndex == -1) {
            System.out.println("start codon not found, unable to translate");
        } else {
            for (int i = startIndex; i < mRNA.length() - 3; i += 3) {
                String codon = mRNA.substring(i, i + 3);
                String aminoAcid = codonWheel(codon);
                if (!aminoAcid.equals("STOP")) {
                    System.out.print(aminoAcid + " ");
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        while (true) {
            System.out.print("Enter 1 for coding strand and 2 for template strand (0 to exit) >>> ");
            int strandType = console.nextInt();

            while (strandType != 1 && strandType != 2 && strandType != 0) {
                System.out.println("invalid input, try again");
                System.out.print("Enter 1 for coding strand and 2 for template strand (0 to exit) >>> ");
                strandType = console.nextInt();
            }

            if (strandType == 1) {
                System.out.print("Enter the DNA coding strand 5' -> 3'(enter 0 to exit) >>> ");
            } else if (strandType == 2) {
                System.out.print("Enter the DNA template strand 5' -> 3' (enter 0 to exit) >>> ");
            } else {
                break;
            }

            String DNA = console.next().toUpperCase();
            if (DNA.equals("0")) {
                break;
            }

            if (validDNA(DNA)) {
                String mRNA = getMRNA(DNA, strandType);
                System.out.println("Transcribed mRNA sequence >>> " + mRNA);
                System.out.print("Translated protein >>> ");
                printProteins(mRNA);
                System.out.println();
            } else {
                System.out.println("Invalid DNA string");
            }
            System.out.println();
        }
    }
}
