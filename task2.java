import org.w3c.dom.ls.LSOutput;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner v = new Scanner(System.in);
        //1
        System.out.println("Введите слово и число ");
        String wrd = v.nextLine();
        int a1 = v.nextInt();
        System.out.println(t1(wrd,a1));
        //2
        System.out.println("введите количство элементов массива ");
        int a2 = v.nextInt();
        int mas[] = new int [a2];
        for (int i = 0; i < a2; i++){
            mas[i] = v.nextInt();
        }
        System.out.println("Искомая разница " +t2(mas));
        //3
        System.out.println("введите количство элементов массива ");
        int a3 = v.nextInt();
        int mas3[] = new int[a3];
        for (int i = 0; i < a3; i++){
            mas[i] = v.nextInt();
        }
        System.out.println("Результат " +t3(mas));
        //4
        System.out.println("4) Введите кол-во элементов массива: ");
        int a4 = v.nextInt();
        int[] mas4 =new int[a4];
        for (int i = 0; i < a4; i++) {
            mas4[i] = v.nextInt();
        }
        int[] mass4 = t4(mas4);
        //5
        System.out.println("Введите десятичное число ");
        String a5=v.nextLine();
        System.out.println("Кол-во знаков после точки " +t5(a5));
        //6
        System.out.println("Введите числo ");
        int a6 =v.nextInt();
        v.nextLine();
        System.out.println("Число Фибоначчи " +t6(a6));
        //7
        System.out.println("Введите индекс ");
        String a7 = v.nextLine();
        System.out.println("Реальный ли индекс " +t7(a7));
        //8
        System.out.println("Введите две строки ");
        String a81=v.nextLine();
        String a82=v.nextLine();
        System.out.println("Странная ли пара " +t8(a81,a82));
        //9
        System.out.println("Введите слово и префикс с тире на конце ");
        String a91=v.nextLine();
        String b91=v.nextLine();
        System.out.println("Является ли префиксный аргумент префиксом: " +t91(a91,b91));
        System.out.println("Введите слово и префикс с тире на конце ");
        String a92=v.nextLine();
        String b92=v.nextLine();
        System.out.println("Является ли суффиксный аргумент суффиксом " +t92(a92,b92));
        //10
        System.out.println("10) Введите шаг поледовательности: ");
        int a10 = v.nextInt();
        System.out.println("Кол-во полей на данном шаге: " +t10(a10));
    }
    //Вызываемые функции
    //1
    public static String t1(String word,int a1) {
        char[] wrd = word.toCharArray();
        String woord = "";
        for (char c : wrd) {
            for (int j = 0; j < a1; j++) {
                woord += c;
            }
        }
        return woord;
    }
    //2
    public static int t2(int[] mas){
        int max = -99999;
        int min = 99999;
        for (int value : mas){
            if (min > value)
                min = value;
            if (max < value)
                max = value;
        }
        return max - min;
    }
    //3
    public static boolean t3(int[] mas3){
        double sum=0;
        for (int value : mas3) {
            sum += value;
        }
        return sum/mas3.length%1==0;
    }
    //4
    public  static int[] t4(int[] mas4){
        int[] mass4=new int[mas4.length];
        for (int i = 0; i < mas4.length; i++) {
            for (int j = i; j >= 0; j--) {
                mass4[i]+=mas4[j];
            }
        }
        return mass4;
    }
    //5
    public static int t5(String a5){
        String[] su= a5.split("\\.");
        return su[1].toCharArray().length;
    }
    //6
    public static int t6(int a6){
        int[] Fib=new int[a6];
        Fib[0]=1;
        Fib[1]=2;
        for (int i = 2; i < a6; i++) {
            Fib[i]=Fib[i-1]+Fib[i-2];
        }
        return Fib[a6-1];
    }
    //7
    public static boolean t7(String a7){
        int len=a7.length();
        boolean dig=a7.matches("[\\d]+");
        return (len==5 && dig);
    }
    //8
    public static boolean t8(String a81, String a82){
        if (a81.isEmpty() && a82.isEmpty())
            return true;
        return a81.toCharArray()[0]==a82.toCharArray()[a82.toCharArray().length-1]
                && a81.toCharArray()[a81.toCharArray().length-1]==a82.toCharArray()[0];

    }
    //9
    public static boolean t91(String a91, String b91){
        boolean rez = false;
        int counter = 0;
        char[] cPref = b91.toCharArray();
        int len = cPref.length;
        char[] cWord = a91.toCharArray();
        for (int i = 0; i < len-1; i++) {
            if (cPref[i] == cWord[i])
                counter += 1;
        }
        if (counter==len-1)
            rez=true;
        return  rez && cPref[len-1]=='-';
    }

    public static boolean t92(String a92, String b92) {
        boolean rez = false;
        int counter = 0;
        char[] cSuff = b92.toCharArray();
        int slen = cSuff.length;
        char[] cWord = a92.toCharArray();
        int len = cWord.length;
        for (int i = len - 1; i > len - cSuff.length-1; i--) {
            if (cSuff[slen-1] == cWord[i])
                counter += 1;
            slen -= 1;
        }
        if (counter == cSuff.length-1)
            rez = true;
        return rez && cSuff[0] == '-';
    }
    //10
    public static int t10(int a10){
        int rez=0;
        for (int i = 0; i < a10; i++) {
            if ((i+1)%2!=0)
                rez+=3;
            else rez-=1;
        }
        return rez;
    }


}
