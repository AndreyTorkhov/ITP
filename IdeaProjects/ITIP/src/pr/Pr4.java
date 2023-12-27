package pr;

import java.util.*;

public class Pr4 {
    public static void main(String[] args){
        System.out.println("_________1");
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println("_________2");
        System.out.println(generateBrackets(3));
        System.out.println("_________3");
        System.out.println(binarySystem(4));
        System.out.println("_________4");
        System.out.println(alphabeticRow("abab"));
        System.out.println("_________5");
        System.out.println(countingChar("aaabbcdd"));
        System.out.println("_________6");
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println("_________7");
        System.out.println(uniqueSubstring("123412324"));
        System.out.println("_________8");
        int[][] sw={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(shortestWay(sw));
        System.out.println("_________9");
        String input = "t3o the5m 1One all6 r4ule ri2ng";
        String[] reorderedWords = numericOrder(input);
        for (String word : reorderedWords) {
            System.out.print(word + " ");}
        System.out.println(" ");
        System.out.println("_________10");
        System.out.println(switchNums(519,723));
    }

    //1
    public static String nonRepeatable(String str) {
        if (str.isEmpty()) {
            return "";
        }
        char first = str.charAt(0);
        String rest = nonRepeatable(str.substring(1).replace(String.valueOf(first), ""));
        return first + rest;
    }

    //2
    public static List<String> generateBrackets(int n) {
        List<String> result = new ArrayList<>();
        generateCombinations(n, n, "", result);
        return result;
    }

    public static void generateCombinations(int left, int right, String str, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }

        if (left > 0) {
            generateCombinations(left - 1, right, str + "(", result);
        }
        if (right > left) {
            generateCombinations(left, right - 1, str + ")", result);
        }
    }

    //3
    public static List<String> binarySystem(int n) {
        List<String> result = new ArrayList<>();
        generateBinary(n, "", result);
        return result;
    }

    private static void generateBinary(int n, String prefix, List<String> result) {
        if (n == 0) {
            result.add(prefix);
        } else {
            if (prefix.equals("")) {
                generateBinary(n - 1, "0", result);
                generateBinary(n - 1, "1", result);
            } else {
                if (prefix.charAt(prefix.length() - 1) == '0') {
                    generateBinary(n - 1, prefix + "1", result);
                } else {
                    generateBinary(n - 1, prefix + "0", result);
                    generateBinary(n - 1, prefix + "1", result);
                }
            }
        }
    }

    //4
    public static String alphabeticRow(String str) {
        String maxRow = "" + str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            char current = str.charAt(i);
            char previous = str.charAt(i - 1);
            maxRow = currentRowType(current, (previous + 1), "" + str.charAt(0), 1, 1, maxRow);
            maxRow = currentRowType(current, (previous - 1), "" + str.charAt(0), 1, 1, maxRow);
        }
        return maxRow;
    }

    public static String currentRowType(char current, int previous, String currentRow, int k, int max, String maxRow) {
        if (current == previous) {
            k++;
            currentRow += current;
            if (k > max) {
                max = k;
                maxRow = currentRow;
            } else if (k == max && currentRow.length() > maxRow.length()) {
                maxRow = currentRow;
            }
        } else {
            k = 1;
            currentRow = "" + current;
        }
        return maxRow;
    }

    //5
    public static String countingChar(String str){
        if (str.isEmpty()) {
            return "";
        }

        List<String> countSymbol = new ArrayList<>();
        char currentChar = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == currentChar) {
                count++;
            } else {
                countSymbol.add(currentChar + String.valueOf(count));
                currentChar = str.charAt(i);
                count = 1;
            }
        }

        countSymbol.add(currentChar + String.valueOf(count));

        Collections.sort(countSymbol, (a, b) -> {
            int countA = Integer.parseInt(a.substring(1));
            int countB = Integer.parseInt(b.substring(1));
            return Integer.compare(countA, countB);
        });

        StringBuilder result = new StringBuilder();
        for (String s : countSymbol) {
            result.append(s);
        }

        return result.toString();
    }

    //6
    public static int convertToNum(String str){
        String[] parts = str.split(" ");
        int result = 0;
        int currentNumber = 0;

        for (String part : parts) {
            int number = parseWord(part);

            if (number == -1) {
                return -1;
            }

            if (number == 100) {
                if (currentNumber == 0) {
                    currentNumber = 1;
                }
                result += currentNumber * number;
                currentNumber = 0;
            } else {
                currentNumber += number;
            }
        }

        return result + currentNumber;
    }

    public static int parseWord(String word) {
        switch (word.toLowerCase()) {
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
            case "ten":
                return 10;
            case "eleven":
                return 11;
            case "twelve":
                return 12;
            case "thirteen":
                return 13;
            case "fourteen":
                return 14;
            case "fifteen":
                return 15;
            case "sixteen":
                return 16;
            case "seventeen":
                return 17;
            case "eighteen":
                return 18;
            case "nineteen":
                return 19;
            case "twenty":
                return 20;
            case "thirty":
                return 30;
            case "forty":
                return 40;
            case "fifty":
                return 50;
            case "sixty":
                return 60;
            case "seventy":
                return 70;
            case "eighty":
                return 80;
            case "ninety":
                return 90;
            case "hundred":
                return 100;
            default:
                return -1;
        }
    }

    //7
    public static String uniqueSubstring(String str){
        int max=0;
        int start=0;
        int currentLength=0;
        int currentSymb=0;
        char[] chars=str.toCharArray();
        for (int i=0;i<chars.length;i++){
            char currentChar = chars[i];
            for (int j=i-1; j>=currentSymb;j--){
                if (str.charAt(j)==currentChar){
                    currentSymb=j+1;
                    break;
                }
            }currentLength=i-currentSymb+1;
            if (currentLength>max){
                max=currentLength;
                start=currentSymb;
            }
        }
        return str.substring(start,start+max);
    }

    //8
    public static int shortestWay(int[][] x){
        int m=x.length;
        int n=x[0].length;

        int[][] cage= new int[m][n];
        cage[0][0]=x[0][0];
        for(int i=1;i<m;i++){
            cage[i][0]=cage[i-1][0]+x[i][0];
        }
        for (int j=1;j<n;j++){
            cage[0][j]=cage[0][j-1]+x[0][j];
        }
        for (int i=1;i<m;i++){
            for (int j =1;j<n;j++){
                cage[i][j]=Math.min(cage[i-1][j],cage[i][j-1])+x[i][j];
            }
        }return cage[m-1][n-1];
    }

    //9
    public static String[] numericOrder(String x){
        String[] words=x.split(" ");
        String[] reorder=new String[words.length];
        for (String word: words){
            for (int i=0;i<word.length();i++){
                if (Character.isDigit(word.charAt(i))){
                    int index=word.charAt(i)-'0'-1;
                    word=word.replaceAll(word.charAt(i)+"","");
                    reorder[index]=word.toString();
                }
            }
        }return reorder;
    }

    //10
    public static int switchNums(int x,int y){
        int[] digits1=new int[String.valueOf(x).length()];
        int[] digits2=new int[String.valueOf(y).length()];
        for (int i=0;i<String.valueOf(x).length();i++){
            digits1[i]=String.valueOf(x).charAt(i)-'0';
        }
        for (int i=0;i<String.valueOf(y).length();i++){
            digits2[i]=String.valueOf(y).charAt(i)-'0';
        }
        Arrays.sort(digits1);
        int startLocal=digits1.length-1;
        int startGlobal=digits1.length-1;
        for(int i=0;i<digits2.length;i++){
            while (startLocal>0){
                if (digits2[i]<digits1[startLocal]){
                    digits2[i]=digits1[startLocal];
                    startLocal--;
                    startGlobal--;
                }else{startLocal--;}
            }startLocal=startGlobal;

        }
        int res=0;
        for (int digit: digits2){
            res=res*10+digit;
        }
        return res;
    }
}
