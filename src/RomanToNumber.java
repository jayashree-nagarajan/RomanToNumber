import java.util.LinkedHashMap;

public class RomanToNumber {
    public int result = 0;
    public int romanToInt(String s) {
        int i = 0;
        LinkedHashMap<Character, Integer> romanSymbols = new LinkedHashMap<>();
        romanSymbols.put('I',1);
        romanSymbols.put('V',5);
        romanSymbols.put('X',10);
        romanSymbols.put('L',50);
        romanSymbols.put('C',100);
        romanSymbols.put('D',500);
        romanSymbols.put('M',1000);
        System.out.println("romanSymbols Map :"+romanSymbols);
        while(i < s.length()){
            System.out.println(s.charAt(i));
            if(romanSymbols.containsKey(s.charAt(i))){

                   if((i > 0) && (checkBefore(s.charAt(i),s.charAt(i-1)))) {
                       i++;
                   }
                   else{
                       result = result + romanSymbols.get(s.charAt(i));
                   }
                i++;
            }


        }
        return result;
    }

    public boolean checkBefore(char a, char b){
        boolean flag = false;
        switch(a){
            case 'V':
                if(b == 'I'){
                    result = result + 4;
                    flag = true;
                }
                break;
            case 'X':
                if(b == 'I'){
                    result = result + 9;
                    flag = true;
                }
        }
        return flag;
    }

    public static void main(String[] args){
        RomanToNumber romanToNumber = new RomanToNumber();
        System.out.println("Output :"+ romanToNumber.romanToInt("XXI"));
    }
}
