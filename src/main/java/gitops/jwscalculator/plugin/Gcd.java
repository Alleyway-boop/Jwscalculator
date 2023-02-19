package gitops.jwscalculator.plugin;

import gitops.jwscalculator.sdk.ICalculate;

public class Gcd implements ICalculate{

    private double result;
    public double calculate(double m,double n){
        int a=(int)m, b=(int)n;
        if(a<b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (a % b != 0) {  
            int temp = a % b;  
            a = b;  
            b = temp;  
        }  
        System.out.println(m+"D"+n+"="+b);
        return result=b; 
    }
}