import java.io.FileNotFoundException;
import java.util.*;

public class MRNAConverter {
    static boolean validDNA(String DNA) {
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

    static String getMRNA(String DNA) {

        DNA = DNA.toUpperCase();
        String mRNA = "";
        int i = 0;
        while (i < DNA.length()) {
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
                    System.out.println("Invalid DNA string");
                    System.exit(1);
            }

            i++;
        }

        return mRNA;
    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the DNA string (enter 0 to exit) >>> ");
            String DNA = console.next().toUpperCase();
            if (DNA.equals("0")) {
                break;
            }

            if (validDNA(DNA)) {
                System.out.println("Corresponding mRNA strand >>> " + getMRNA(DNA));
            } else {
                System.out.println("Invalid DNA string");
            }
        }


    }
}
