package pr;

import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Pr5 {
    public static void main(String[] args) {
        System.out.println("_________1");
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println("_________2");
        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("A4", "B2"));
        System.out.println(spiderVsFly("A4", "C2"));
        System.out.println(spiderVsFly("H1", "A3"));
        System.out.println(spiderVsFly("G4", "A3"));
        System.out.println("_________3");
        System.out.println(digitsCount(4666L));
        System.out.println("_________4");
        String[] arr1={"trance", "recant"};
        System.out.println(totalPoints(arr1,"recant"));
        System.out.println("_________5");
        System.out.println(sumsUp(new int[]{1, 2, 3, 4, 5}));
        System.out.println(sumsUp(new int[]{1, 2, 3, 7, 9}));
        System.out.println(sumsUp(new int[]{10, 9, 7, 2, 8}));
        System.out.println(sumsUp(new int[]{1, 6, 5, 4, 8, 2, 3, 7}));
        System.out.println("_________6");
        String[] arr2={"95%", "83%", "90%", "87%", "88%", "93%"};
        System.out.println(takeDownAverage(arr2));
        System.out.println("_________7");
        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("decode", "almost last task!", 4));
        System.out.println("_________8");
        System.out.println(setSetup(5,3));
        System.out.println("_________9");
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));
        System.out.println("_________10");
        System.out.println(isNew(103));
    }

    //1
    public static boolean sameLetterPattern(String str1, String str2)
    {
        if(str1.length() != str2.length()) {
            return false;
        }

        HashMap<Character, Integer> first = new HashMap<>();
        HashMap<Character, Integer> second = new HashMap<>();

        for(int i = 0; i < str1.length(); i++) {
            if(first.get(str1.charAt(i)) != second.get(str2.charAt(i))) return false;
            first.put(str1.charAt(i), i);
            second.put(str2.charAt(i), i);
        }
        return true;
    }

    //2
    public static String spiderVsFly(String spider, String fly) {
        char[] radials = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

        int spiderRadial = spider.codePointAt(0);
        int spiderRing = spider.codePointAt(1);
        int flyRadial = fly.codePointAt(0);
        int flyRing = fly.codePointAt(1);

        if (spiderRadial == flyRadial && spiderRing == flyRing) {
            return fly;
        }

        if (spiderRing == 48) {
            spiderRadial = flyRadial;
        }

        int radialDistance = Math.abs(spiderRadial - flyRadial);
        int oppositeRadialDistance = Math.abs(spiderRadial > flyRadial ? radials.length - (spiderRadial-65) + (flyRadial-65) : (spiderRadial-65) + radials.length - (flyRadial-65));
        int minDistance = Math.min(radialDistance, oppositeRadialDistance);

        int ringDiff = (spiderRing - flyRing >= 0 ? (spiderRing - flyRing > 0 ? -1 : 0) : 1);
        int radialDiff = (radialDistance == oppositeRadialDistance) ? -1 : 1;

        String toCenter = Character.toString((char) (spiderRadial)) + ((char) (spiderRing - 1));
        String towardsRing = Character.toString((char) spiderRadial) + ((char) (spiderRing + ringDiff));

        int index = (spiderRadial - 65 + radialDiff > 0 ? spiderRadial - 65 + radialDiff : spiderRadial - 65 + radialDiff + 8) % 8;
        String towardsRadial = Character.toString(radials[index]) + ((char) spiderRing);

        if (minDistance >= 3 && minDistance <= 4) {
            return spider + "-" + spiderVsFly(toCenter, fly);
        } else {
            if (spiderRing > flyRing) {
                return spider + "-" + spiderVsFly(towardsRing, fly);
            } else {
                if (spiderRadial != flyRadial) {
                    return spider + "-" + spiderVsFly(towardsRadial, fly);
                } else {
                    return spider + "-" + spiderVsFly(towardsRing, fly);
                }
            }
        }
    }



    //3
    public static int digitsCount(long x){
        int count=1;
        if (x/10==0){return count;}
        else{return count+digitsCount(x/10);}
    }


    //4
    public static int totalPoints(String[] words, String ans) {
        int total = 0;
        int win = 0;
        int count = 0;
        for (String word : words) {
            if (check(word, ans)) {
                if (word.length() == 3) {
                    total += 1;
                }
                if (word.length() == 4) {
                    total += 2;
                }
                if (word.length() == 5) {
                    total += 3;
                }
                if (word.length() == 6) {
                    if (word.equals(ans)) {
                        win = 1;
                    }
                    total += 4;
                    count++;
                }
            }
        }
        return total + count*win*50;
    }

    public static boolean check(String word, String ans) {
        for (int i = 0; i < word.length(); i++) {
            int ind = ans.indexOf(word.charAt(i));
            if (ind == -1) {
                return false;
            }
            String start = ans.substring(0, ind);
            String finish = ans.substring(ind + 1);
            ans = start + finish;
        }
        return true;
    }

    //5
    public static ArrayList<ArrayList<Integer>> sumsUp(int[] arr) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            for (int key : map.keySet()) {
                if (key + num == 8) {
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(Math.min(key, num));
                    pair.add(Math.max(key, num));
                    res.add(pair);
                    map.remove(key);
                    break;
                }
            }
            map.put(num, 1);
        }

        return res;
    }

    //6
    public static String takeDownAverage(String[] arr) {
        if (arr.length == 0)
            return "0%";
        double sum = 0;
        for (String str : arr) {
            int number = Integer.parseInt(str.split("%")[0]);
            sum += number;
        }
        double avg = sum / arr.length;
        double res = (arr.length + 1) * (avg - 5) - sum;
        return (int) Math.round(res) + "%";
    }

    //7
    public static String caesarCipher(String mode, String str, int shift) {
        if (mode.equals("decode")) {
            shift *= -1;
        }
        str = str.toUpperCase();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int el = str.codePointAt(i);
            int number = el + shift;
            if (el >= 65 && el <= 90) {
                if (number < 65) {
                    number = 91 - (65 - number);
                } else if (number > 90) {
                    number = 64 + (number - 90);
                }
                res.append((char) number);
            } else {
                res.append((char) el);
            }
        }
        return res.toString();
    }


    //8
        public static int setSetup(int n,int k){
            if (n==k) return 1;
            if (k==0) return 1;
            else{return n*setSetup(n-1,k-1);}
        }


    //9
    public static String timeDifference(String cityA, String stringDate, String cityB) {
        HashMap<String, TimeZone> timeZones = new HashMap<>();
        timeZones.put("Los Angeles", SimpleTimeZone.getTimeZone("GMT-8"));
        timeZones.put("New York", SimpleTimeZone.getTimeZone("GMT-5"));
        timeZones.put("Caracas", SimpleTimeZone.getTimeZone("GMT-4:30"));
        timeZones.put("Buenos Aires", SimpleTimeZone.getTimeZone("GMT-3"));
        timeZones.put("London", SimpleTimeZone.getTimeZone("GMT"));
        timeZones.put("Rome", SimpleTimeZone.getTimeZone("GMT+1"));
        timeZones.put("Moscow", SimpleTimeZone.getTimeZone("GMT+3"));
        timeZones.put("Tehran", SimpleTimeZone.getTimeZone("GMT+3:30"));
        timeZones.put("New Delhi", SimpleTimeZone.getTimeZone("GMT+5:30"));
        timeZones.put("Beijing", SimpleTimeZone.getTimeZone("GMT+8"));
        timeZones.put("Canberra", SimpleTimeZone.getTimeZone("GMT+10"));
        SimpleDateFormat inputFormat = new SimpleDateFormat("MMMM d, yyyy H:m", Locale.US);
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-M-d HH:mm", Locale.US);

        inputFormat.setTimeZone(timeZones.get(cityA));
        outputFormat.setTimeZone(timeZones.get(cityB));
        try {
            return outputFormat.format(inputFormat.parse(stringDate));
        } catch (ParseException ignored) {
            return "error";
        }
    }

    //10
    public static boolean isNew(int n) {
        ArrayList<Integer> digits = new ArrayList<>();
        int number = n;
        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }
        Collections.sort(digits);
        number = 0;
        int i = 0;
        while (!digits.isEmpty()){
            if (number == 0 && digits.get(i) == 0){
                i++;
            }else {
                number = number * 10 + digits.remove(i);
                i = 0;
            }
        }
        return number == n;
    }
}

