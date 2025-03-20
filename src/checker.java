import java.util.Scanner;

public class checker {
    public static void main(String[] args) {
        String origin;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        origin = sc.nextLine();

        StringBuilder s = new StringBuilder();

        for(int i = 0;i < origin.length();i ++) {
            char tmp = origin.charAt(i);
            if (tmp == ' ') continue;
            if (true) { // check the letter validity
                s.append(tmp);
            }

        }




        boolean isWFF = true;
        int NumBra = 0;
        int LastChar = 0;
        /*
        1 : atom
        2 : operator
        3 : parentheses
        */

        for(int i = 0;i < s.length();i ++){

            if(s.charAt(i) == '(') {
                NumBra ++;
                LastChar = 3;

            }

            if(s.charAt(i) == ')'){
                NumBra --;
                LastChar = 3;
            }



            //Numbra always >= 0








        }










    }
}
