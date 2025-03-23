import java.util.Objects;
import java.util.Scanner;
import static java.lang.Character.isLetter;

public class checker {
    public static void main(String[] args) {

        String origin = "0";
        int AtomCounter = 0;

        while(origin != "-1") {

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a string,or enter -1 to exit");
            origin = sc.nextLine();
            StringBuilder s = new StringBuilder();

            if(Objects.equals(origin, "-1")) {
                System.out.println("-------THE ENDING-------");
                break;
            }

            for (int i = 0; i < origin.length(); i++) {
                char tmp = origin.charAt(i);
                if (tmp == ' ') continue;
                if (isValid(tmp)) s.append(tmp);
            }

            boolean isWFF = true;
            int NumBra = 0;
            int LastChar = 0;

        /*
        1 : atom
        2 : operator
        3 : parentheses
        */

            if(s.charAt(0) != '(' || s.charAt(s.length() - 1) != ')') {
                isWFF = false;
            }
            if(isWFF){
                for(int i = 0; i < s.length();i ++) {
                    char tmp = s.charAt(i);

                    if(tmp == '('){
                        NumBra ++;
                        LastChar = 3;
                        continue;
                    }
                    if (tmp == ')') {
                        NumBra --;
                        LastChar = 3;
                        continue;
                    }
                    if (NumBra < 0) {
                        isWFF = false;
                        break;
                    }
                    //Numbra always >= 0

                    if (isLetter(tmp)) {
                        if (LastChar == 1) {
                            isWFF = false;
                            break;
                        }
                        LastChar = 1;
                        AtomCounter ++;
                        continue;
                    }

                    if (tmp == '∧' || tmp == '∨' || tmp == '→' || tmp == '↔' || tmp == '¬') {
                        LastChar = 2;
                        continue;
                    }
                }
            }

            if(NumBra != 0) isWFF = false;
            if(AtomCounter == 0) isWFF = false;

            //output
            if (isWFF) System.out.println(s + " is a WFF");
            else       System.out.println(s + " is not a WFF");

        }

    }

    private static boolean isValid(char ch) {
        return isLetter(ch) || ch == '∧' || ch == '∨' || ch == '→' ||
                ch == '↔' || ch == '(' || ch == ')' || ch == '¬';
    }
}