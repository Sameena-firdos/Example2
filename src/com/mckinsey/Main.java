package com.mckinsey;

import java.util.Scanner;

class Converter{

    public boolean ruleOne(String word){

        char temp=word.charAt(0);
        if(temp == 'a' || temp=='e' || temp=='i' || temp=='o' || temp=='u')
            return true;
        if(word.length()>=2)
        {

            String substr=word.substring(0,2);

            if(substr.equals("xr") || substr.equals("yt")){

                return true;
            }
        }
        return false;
    }
    public int ruleThree(String word){
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) == 'q' && word.charAt(i + 1) == 'u') {
                return i + 1;
            }
        }
        return -1;

    }
    public int ruleFour(String word){
        String str = "aeiou";

        for(int i=0;i<word.length()-1;i++){
            if(str.indexOf(word.charAt(i)) == -1){
              if(word.charAt(i+1)=='y')
                  return i+1;
            }

        }
        return -1;
    }
    public int ruleTwo(String word){
        for(int i=0;i<word.length();i++){
            String str = "aeiou";
            if(str.indexOf(word.charAt(i)) != -1)
                return i;
        }
        return -1;
    }

    public String pigToLatinConverter(String word){
        boolean first=ruleOne(word);
        if(first==true){

            word+="ay";
            return word;
        }
        else{
            int third=ruleThree(word);
            if(third!=-1){

                String temp = word.substring(third + 1, word.length());
                temp += word.substring(0, third + 1);
                temp += "ay";
                return temp;
            }
            int four=ruleFour(word);
            if(four!=-1){

                String temp = word.substring(four , word.length());
                temp += word.substring(0, four);
                temp += "ay";
                return temp;
            }
            int two=ruleTwo(word);
            if(two!=-1){

                String temp = word.substring(two, word.length());
                temp += word.substring(0, two);
                temp += "ay";
                return temp;

            }

        }
        return word;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        Converter obj=new Converter();

        System.out.println("Enter Input String");
        String string=sc.nextLine();
        String ans="";
        String[] temp=string.split(" ");
        for(String wd: temp){
            wd=wd.trim();
            if(wd.length()>0)
                ans=ans+" "+obj.pigToLatinConverter(wd);
        }
        System.out.println("Converted string : "+ ans.trim());


    }
}
