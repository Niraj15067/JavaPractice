package com.lamda;

public class Main {
    public static void main(String[] args) {
        System.out.println(stringPrint(6));
    }
    public static String stringPrint(int n){
      char sb[] = new char[n];
      if((n%2)!=0){
        for(int i=0;i<n;i++){
          sb[i]='a';
        }
      }else{
        for(int i=0;i<n;i++){
          if(i==n-1){
            sb[i]='b';
          }else{
            sb[i]='a';
          }
        } 
      }
      return new String(sb);
    }
  }
