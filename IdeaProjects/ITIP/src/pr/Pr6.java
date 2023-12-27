package pr;

import java.util.*;

public class Pr6 {
    public static void main(String[] args) {
        System.out.println("==============1==============");
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));
        System.out.println("==============2==============");
        System.out.println(collect("intercontinentalisationalism", 6));
        System.out.println(collect("strengths", 3));
        System.out.println(collect("pneum", 15));
        System.out.println("==============3==============");
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));
        System.out.println("==============4==============");
        int[] arr1 = {1, 2, 3, 9, 4, 5, 15};
        int[] arr2 = {1, 2, 3, 9, 4, 15, 3, 5};
        int[] arr3 = {1, 2, -1, 4, 5, 6, 10, 7};
        int[] arr4 = {1, 2, 3, 4, 5,  6, 7, 8, 9, 10};
        int[] arr5 = {100, 12, 4, 1, 2};
        System.out.println(Arrays.toString(twoProduct(arr1, 45)));
        System.out.println(Arrays.toString(twoProduct(arr2, 45)));
        System.out.println(Arrays.toString(twoProduct(arr3, 20)));
        System.out.println(Arrays.toString(twoProduct(arr4, 10)));
        System.out.println(Arrays.toString(twoProduct(arr5, 15)));
        System.out.println("==============5==============");
        System.out.println(Arrays.toString(isExact(6)));
        System.out.println(Arrays.toString(isExact(24)));
        System.out.println(Arrays.toString(isExact(125)));
        System.out.println(Arrays.toString(isExact(720)));
        System.out.println(Arrays.toString(isExact(1024)));
        System.out.println(Arrays.toString(isExact(40320)));
        System.out.println("==============6==============");
        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));
        System.out.println("==============7==============");
        System.out.println(pilish_string("HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESINVOLVINGQUANTUMMECHANICSANDALLTHESECRETSOFTHEUNIVERSE"));
        System.out.println(pilish_string("FORALOOP"));
        System.out.println(pilish_string("CANIMAKEAGUESSNOW"));
        System.out.println(pilish_string("33314444"));
        System.out.println(pilish_string("TOP"));
        System.out.println(pilish_string("X"));
        System.out.println(pilish_string(""));
        System.out.println("==============8==============");
        System.out.println(generateNonconsecutive("3 + 5 * ( 2 - 6 )"));
        System.out.println(generateNonconsecutive("6.5 - 18 / ( -1 + 4 )"));
        System.out.println("==============9==============");
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));
        System.out.println("==============10==============");
        System.out.println(findLCS("abcd","bd"));
        System.out.println(findLCS("aggtab","gxtxamb"));
    }

    //1
    public static String hiddenAnagram(String str, String anagram) {
        str = str.toLowerCase().replaceAll("[^a-z]", "");
        char[] characters = anagram.toLowerCase().replaceAll(" ", "").toCharArray();
        Arrays.sort(characters);
        for (int i = 0; i < str.length() - characters.length + 1; i++) {
            String res = str.substring(i, i + characters.length);
            char[] resChar = res.toCharArray();
            Arrays.sort(resChar);
            if (Arrays.equals(resChar, characters)) {
                return res;
            }
        }
        return "notfound";
    }

    //2
    public static ArrayList<String> collect(String str, Integer x) {
        ArrayList<String> res = new ArrayList<>();
        generateSubstrings(str, 0, x, res);
        Collections.sort(res);
        return res;
    }

    private static void generateSubstrings(String str, int start, int length, ArrayList<String> res) {
        if (start + length <= str.length()) {
            res.add(str.substring(start, start + length));
            generateSubstrings(str, start + length, length, res);
        }
    }

    //3
    public static String nicoCipher(String message, String key) {
        int l = message.length() / key.length() + 1;
        char[][] grid = new char[l][key.length()];
        char[] sortedKey = key.toCharArray();
        Arrays.sort(sortedKey);
        int[] order = new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            for (int j = 0; j < key.length(); j++) {
                if (key.charAt(i) == sortedKey[j]) {
                    order[i] = j + 1;
                    sortedKey[j] = '\u0000';
                    break;}}}
        int index = 0;
        for (int row : order) {
            int numIter = 0;
            for (int column = 0; column <= message.length() / key.length(); column++) {
                if (index + numIter * key.length() >= message.length()) {
                    break;
                }
                if (grid[column][row - 1] == '\u0000') {
                    grid[column][row - 1] = message.charAt(index + numIter * key.length());
                } else {
                    row += 1;
                    column -= 1;}
                numIter += 1;}
            index += 1;}
        StringBuilder encodedMessage = new StringBuilder();
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < key.length(); j++) {
                if (grid[i][j] == '\u0000') {
                    encodedMessage.append(" ");
                } else {
                    encodedMessage.append(grid[i][j]);}}}
        return encodedMessage.toString();
    }

    //4
    public static int[] twoProduct(int[] arr, int n) {
        LinkedList<int[]> pairs = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            int first = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                int second = arr[j];
                if (first * second == n) {
                    int[] pair = new int[]{first, second, j - i};
                    pairs.add(pair);
                }
            }
            Collections.sort(pairs, Comparator.comparingInt(diff -> diff[2]));
        }
        if (!pairs.isEmpty()) {
            int[] res = new int[2];
            int[] pair = pairs.get(0);
            res[0] = pair[0];
            res[1] = pair[1];
            return res;
        } else {
            int[] res = new int[0];
            return res;
        }
    }

    //5
    public static int[] isExact(int x) {
        int count = 2;
        int mult = 1;
        int[] res = new int[2];
        factorial(x, count, mult, res);
        if (res[0] == 0) {
            return new int[0];
        }
        return res;
    }

    private static void factorial(int x, int count, int mult, int[] res) {
        if (x == 1) {
            res[0] = x;
            res[1] = 1;
        }
        if (x > mult) {
            factorial(x, count + 1, mult * count, res);
        } else if (x == mult) {
            res[0] = x;
            res[1] = count - 1;
        }
    }

    //6
    public static String fractions(String str) {
        String intNum = str.substring(0, str.indexOf('.'));
        String beforePeriod = str.substring(str.indexOf('.') + 1, str.indexOf('('));
        String period = str.substring(str.indexOf('(') + 1, str.indexOf(')'));
        int numerator, denominator;
        if (beforePeriod.isEmpty()) {
            denominator = Integer.parseInt("9".repeat(period.length()));
            numerator = Integer.parseInt(period) + Integer.parseInt(intNum) * denominator;
        } else {
            denominator = Integer.parseInt("9".repeat(period.length()) + "0".repeat(beforePeriod.length()));
            numerator = Integer.parseInt(beforePeriod + period) - Integer.parseInt(beforePeriod) + Integer.parseInt(intNum) * denominator;
        }
        return simplify(numerator, denominator);
    }

    private static String simplify(int numerator, int denominator) {
        for (int i = Math.min(numerator, denominator); i >= 2; i--) {
            if (numerator % i == 0 && denominator % i == 0) {
                numerator /= i;
                denominator /= i;
            }
        }
        return numerator + "/" + denominator;
    }


    //7
    public static String pilish_string(String str) {
        if (str.isEmpty()) {
            return "";
        }
        int[] pi = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9};
        String res = "";
        int startIndex = 0;
        for (int i : pi) {
            if (startIndex >= str.length()) {
                break;
            }
            if (startIndex + i > str.length()) {
                res += str.substring(startIndex);
                res += (str.charAt(str.length() - 1) + "").repeat(i - (str.length() - startIndex));
            } else {
                res += str.substring(startIndex, startIndex + i) + " ";
            }
            startIndex += i;
        }
        return res.trim();
    }

    //8
    public static double generateNonconsecutive(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<String> op = new Stack<>();
        String[] tokenList=str.split(" ");
        for (String token:tokenList){
            if (token.matches("(-)?\\d+(\\.\\d+)?")){
                sb.append(token);
                sb.append(' ');}
            else if (token.equals("(")){
                op.push(token);
            }else if (token.equals(")")){
                String top=op.pop();
                while (!top.equals("(")){
                    sb.append(top);
                    sb.append(' ');
                    top=op.pop();
                }
            }else if (isOperator(token)){
                while ((!op.isEmpty()) && (priority(op.peek())>=priority(token))){
                    sb.append(op.pop());
                    sb.append(' ');}
                op.push(token);
            }}while (!op.isEmpty()){sb.append(op.pop());sb.append(' ');}
        return postfixEvaluate(sb.toString());}
    private static boolean isOperator(String ch) {
        return ch.equals("*") || ch.equals("/") || ch.equals("+") || ch.equals("-");
    }

    private static int priority(String operator) {
        switch (operator) {
            case "(":
                return 1;
            case "*":
            case "/":
                return 3;
            case "+":
            case "-":
                return 2;
        }
        return 0;
    }

    private static double postfixEvaluate(String str){
        Stack<Double> operand=new Stack<>();
        String[] tokens=str.split("\\s+");
        for (String token:tokens){
            if (token.matches("(-)?\\d+(\\.\\d+)?")){
                operand.push(Double.parseDouble(token));
            }
            else{double operand2=operand.pop();
                double operand1=operand.pop();
                double result=calculation(token,operand1,operand2);
                operand.push(result);
            }}
        return operand.pop();}
    private static double calculation(String operator, double x, double y){
        if (operator.equals("+")){return x+y;}
        else if (operator.equals("-")){return x-y;}
        else if (operator.equals("*")){return x*y;}
        else if (operator.equals("/")){
            if (y==0){throw new ArithmeticException("Деление на ноль");}
            return x/y;
        }
        else{throw new IllegalArgumentException("Неправильный ввод");}
    }

    //9
    public static String isValid(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            map.put(current, map.getOrDefault(current, 0) + 1);
        }

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int count : map.values()) {
            frequencyMap.put(count, frequencyMap.getOrDefault(count, 0) + 1);
        }

        if (frequencyMap.size() > 2) {
            return "NO";
        } else if (frequencyMap.size() <= 1) {
            return "YES";
        } else {
            int key1 = -1, key2 = -1, count1 = 0, count2 = 0;

            for(int key : frequencyMap.keySet()){
                if (key1==-1){
                    key1=key;
                    count1 = frequencyMap.get(key1);
                } else {
                    key2=key;
                    count2=frequencyMap.get(key2);
                }

            }

            if ((count1 == 1 && (key1 - 1 == key2 || key1 == 1)) || (count2 == 1 && (key2 - 1 == key1 || key2 == 1))) {
                return "YES";
            } else {
                return "NO";
            }
        }
    }

    //10
    public static String findLCS(String str1, String str2) {
        int[][] dpMatrix = buildDPMatrix(str1, str2);
        return reconstructLCS(str1, str2, dpMatrix);
    }
    private static int[][] buildDPMatrix(String x, String y) {
        int[][] dpMatrix = new int[x.length() + 1][y.length() + 1];
        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dpMatrix[i][j] = dpMatrix[i - 1][j - 1] + 1;
                } else {
                    dpMatrix[i][j] = Math.max(dpMatrix[i][j - 1], dpMatrix[i - 1][j]);
                }
            }
        }
        return dpMatrix;
    }
    private static String reconstructLCS(String x, String y, int[][] dpMatrix) {
        StringBuilder lcs = new StringBuilder();
        int xIndex = x.length();
        int yIndex = y.length();
        while (xIndex > 0 && yIndex > 0) {
            if (x.charAt(xIndex - 1) == y.charAt(yIndex - 1)) {
                lcs.append(x.charAt(xIndex - 1));
                xIndex--;
                yIndex--;
            } else if (dpMatrix[xIndex - 1][yIndex] > dpMatrix[xIndex][yIndex - 1]) {
                xIndex--;
            } else {
                yIndex--;
            }
        }
        return lcs.reverse().toString();
    }
}
