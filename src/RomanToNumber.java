import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.exit;

public class RomanToNumber {
    public int result = 0;
    public int romanToInt(String s) {
        int i = 0;
        int number;
        String explanation = "";


        LinkedHashMap<Character, Integer> romanSymbols = new LinkedHashMap<>();
        romanSymbols.put('I',1);
        romanSymbols.put('V',5);
        romanSymbols.put('X',10);
        romanSymbols.put('L',50);
        romanSymbols.put('C',100);
        romanSymbols.put('D',500);
        romanSymbols.put('M',1000);
        Pattern pattern = Pattern.compile("^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
        Matcher match = pattern.matcher(s);

        if(s.length() > 0 && s.length()<=15 && match.find()){
            while(i < s.length()){

                if(romanSymbols.containsKey(s.charAt(i))){
                    if(i>0){
                        number = (checkBefore(s.charAt(i),s.charAt(i-1)));
                        if( number != 0) {
                            result = result - romanSymbols.get(s.charAt(i-1));
                            result = result + number;
                            explanation = explanation+s.charAt(i-1)+s.charAt(i)+" = "+String.valueOf(number)+" ";
                            number = 0;
                        }
                        else{
                            result = result + romanSymbols.get(s.charAt(i));
                            explanation = explanation+s.charAt(i)+" = "+romanSymbols.get(s.charAt(i))+" ";
                        }

                    }
                    else{
                        result = result + romanSymbols.get(s.charAt(i));
                        explanation = explanation+s.charAt(i)+" = "+romanSymbols.get(s.charAt(i))+" ";
                    }

                    i++;
                }
                else{
                    System.out.println("Please enter a valid roman letter");
                    exit(0);
                }
            }
        }
        System.out.println("Explanation : "+explanation);

        return result;
    }

    public int checkBefore(char a, char b){

        int number = 0;
        switch(a){
            case 'V':
                if(b == 'I'){
                    number = 4;

                }
                break;
            case 'X':
                if(b == 'I'){
                    number =  9;

                }
                break;
            case 'L':
                if(b == 'X'){
                    number =  40;

                }
                break;
            case 'C':
                if(b == 'X'){
                    number =  90;

                }
                break;
            case 'D':
                if(b == 'C'){
                    number =  400;

                }
                break;
            case 'M':
                if(b == 'C'){
                    number =  900;

                }
                break;
        }
        return number;
    }

    public static void main(String[] args){
        RomanToNumber romanToNumber = new RomanToNumber();
        System.out.println("Output :"+ romanToNumber.romanToInt("IV"));
    }
}
