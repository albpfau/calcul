package com.company;
import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        int i,j;
        boolean stc;
        String sum;
        String[] v;
        char[] pbl;
        boolean Arabic,Roman;
        Scanner scan=new Scanner(System.in);
        while(true){
            System.out.println("Введите операцию: ");
            sum=scan.nextLine();
            sum=sum.replaceAll("\\s+","");
            stc=false;
            pbl=new char[sum.length()];
            pbl=sum.toCharArray();
            for(i=0;i<pbl.length;i++){
                switch(pbl[i]){
                    case '+' : stc=true;break;
                    case '-' : stc=true;break;
                    case '*' : stc=true;break;
                    case '/' : stc=true;break;
                }
                if(stc)break;
                if((!stc)&&((i+1)==pbl.length)){
                    System.out.println("Неверная операция");
                    break;
                }
            }
            if(!stc){System.out.println("Операция не найдена");}
            v=sum.split(String.valueOf("\\"+pbl[i]));
            if (v.length>2){
                System.out.println("Неверная операция");
            } else {
                Arabic = false;
                Roman = false;
                for (j = 0; j < 2; j++) {
                    if (j == 0 || Arabic == true) {
                        switch (v[j]) {
                            case "1":
                                Arabic = true;
                                break;
                            case "2":
                                Arabic = true;
                                break;
                            case "3":
                                Arabic = true;
                                break;
                            case "4":
                                Arabic = true;
                                break;
                            case "5":
                                Arabic = true;
                                break;
                            case "6":
                                Arabic = true;
                                break;
                            case "7":
                                Arabic = true;
                                break;
                            case "8":
                                Arabic = true;
                                break;
                            case "9":
                                Arabic = true;
                                break;
                            case "10":
                                Arabic = true;
                                break;
                            default:
                                Arabic = false;
                        }
                    }
                }
                for (j = 0; j < 2; j++) {
                    if (j == 0 || Roman == true) {
                        switch (v[j]) {
                            case "I":
                                Roman = true;
                                break;
                            case "II":
                                Roman = true;
                                break;
                            case "III":
                                Roman = true;
                                break;
                            case "IV":
                                Roman = true;
                                break;
                            case "V":
                                Roman = true;
                                break;
                            case "VI":
                                Roman = true;
                                break;
                            case "VII":
                                Roman = true;
                                break;
                            case "VIII":
                                Roman = true;
                                break;
                            case "IX":
                                Roman = true;
                                break;
                            case "X":
                                Roman = true;
                                break;
                            default:
                                Roman = false;
                                break;
                        }
                    }
                }
                if (Arabic) {
                    switch (pbl[i]) {
                        case '+':
                            System.out.println("=" + add(Integer.valueOf(v[0]), Integer.valueOf(v[1])));
                            break;
                        case '-':
                            System.out.println("=" + subtract(Integer.valueOf(v[0]), Integer.valueOf(v[1])));
                            break;
                        case '*':
                            System.out.println("=" + multiply(Integer.valueOf(v[0]), Integer.valueOf(v[1])));
                            break;
                        case '/':
                            System.out.println("=" + divide(Integer.valueOf(v[0]), Integer.valueOf(v[1])));
                            break;
                    }
                } else if (Roman) {
                    switch (pbl[i]) {
                        case '+':
                            System.out.println("=" + arabictoroman(add(romantoarabic(v[0]), romantoarabic(v[1]))));
                            break;
                        case '-':
                            System.out.println("=" + arabictoroman(subtract(romantoarabic(v[0]), romantoarabic(v[1]))));
                            break;
                        case '*':
                            System.out.println("=" + arabictoroman(multiply(romantoarabic(v[0]), romantoarabic(v[1]))));
                            break;
                        case '/':
                            if ((divide(romantoarabic(v[0]), romantoarabic(v[1])) % 1) == 0) {
                                System.out.println("=" + arabictoroman((int) divide(romantoarabic(v[0]), romantoarabic(v[1]))));
                            }
                            break;
                    }
                }
            }
        }
    }
    private static int add(int a,int b){
        return a+b;
    }
    private static int subtract(int a,int b){
        return a-b;
    }
    private static int multiply(int a,int b){
        return a*b;
    }
    private static float divide(float a,float b){
        return a/b;
    }
    private static int romantoarabic(String r){
        int a;
        switch (r){
            case"I": a=1;break;
            case"II": a=2;break;
            case"III": a=3;break;
            case"IV": a=4;break;
            case"V": a=5;break;
            case"VI": a=6;break;
            case"VII": a=7;break;
            case"VIII": a=8;break;
            case"IX": a=9;break;
            case"X": a=10;break;
            default: a=0;System.out.println("Ошибка");
        }
        return a;
    }
    static int arabic[]  = {1, 4, 5, 9, 10, 50, 100, 500};
    static String roman[]  = { "I", "IV", "V", "IX", "X", "L", "C", "D"};
    private static String arabictoroman(int a){
        if(a==0){
            System.out.println("0 отсутствует ");
            return "Ошибка";
        } else {
            String r="";
            int n=a,i;
            if(a<0){
                n=-a;
            }
            while (n>0){
                for(i=0;i<arabic.length;i++){
                    if(n<arabic[i]){
                        n-=arabic[i-1];
                        r+=roman[i-1];
                        break;
                    }
                }
            }
            if(a<0){
                return "-"+r;
            }else {
                return r;
            }
        }
    }
}