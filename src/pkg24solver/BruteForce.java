/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg24solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Ivana Clairine
 */
public class BruteForce {
    String operators="+,-,*,/";
    Stack<Double> stack;
    
    public BruteForce(){
        stack = new Stack<>();
    }
    
    public boolean isSolveable(String[] input){
        
        for(int i=0; i<input.length; i++){
//            System.out.println("input[" + i + "]: " + String.valueOf(input[i]));
            if(isOperator(input[i].charAt(0))){
                if(stack.size() < 2)
                    return false;
                else{
                    double op1 = stack.pop();
                    double op2 = stack.pop();
                    
                    double res = evaluateCount (op1, op2, input[i].charAt(0));
                    stack.push(res);
                }
            }
            else{
                stack.push(Double.valueOf(String.valueOf(input[i].charAt(0))));
            }
        }
        
        if(stack.size()==1)
            return true;
        
        return false;
    }
    
    public boolean isValid (String[] input){
        Stack<Integer> temp = new Stack<>();
        for(int i=0; i<input.length; i++){
            if(isOperator(input[i].charAt(0))){
                if(temp.size() < 2)
                    return false;
            }
            else{
                temp.push(Integer.valueOf(String.valueOf(input[i].charAt(0))));
            }
        }
        
        return true;
    }
    
    public boolean isOperator(char c){
        if(c == '+' || c == '-' || c == '*' || c == '/')
            return true;
        return false;
    }
    
    public List<String[]> getCombination(String number){
        List<String[]> returnedCombination = new ArrayList<>();
        List<List<String>> retCombArr = new ArrayList<>();
        int it = 0;
        
        String seed = number+','+operators;
        List<String> himpunan = new ArrayList<String>(Arrays.asList(seed.split(",")));
//        System.out.println("himpunan: " + himpunan.toString());
        String[] tempCombination = new String[7];
        
        //lokasi 1
        for(int idx1 = 0; idx1 < 8; idx1++){
            
            List<String> himp1 = new ArrayList<String>(himpunan);
            tempCombination[0] = himp1.get(idx1);
            if(!isOperator(himp1.get(idx1).charAt(0))){
                himp1.remove(idx1);
            }
            
            //lokasi 2
            for(int idx2 = 0; idx2<himp1.size(); idx2++){
                List<String> himp2 = new ArrayList<String>(himp1);
                tempCombination[1] = himp2.get(idx2);
                if(!isOperator(himp2.get(idx2).charAt(0))){
                    himp2.remove(idx2);
                }
                
                //lokasi 3
                for(int idx3 = 0; idx3<himp2.size(); idx3++){
                    List<String> himp3 = new ArrayList<String>(himp2);
                    tempCombination[2] = himp3.get(idx3);
                    if(!isOperator(himp3.get(idx3).charAt(0))){
                        himp3.remove(idx3);
                    }
                    
                    //lokasi 4
                    for(int idx4 = 0; idx4<himp3.size(); idx4++){
                        List<String> himp4 = new ArrayList<String>(himp3);
                        tempCombination[3] = himp4.get(idx4);
                        if(!isOperator(himp4.get(idx4).charAt(0))){
                            himp4.remove(idx4);
                        }

//                       //lokasi 5
                        for(int idx5 = 0; idx5<himp4.size(); idx5++){
                            List<String> himp5 = new ArrayList<String>(himp4);
                            tempCombination[4] = himp5.get(idx5);
                            if(!isOperator(himp5.get(idx5).charAt(0))){
                                himp5.remove(idx5);
                            }
                            
                            //lokasi 6
                            for(int idx6 = 0; idx6<himp5.size(); idx6++){
                                List<String> himp6 = new ArrayList<String>(himp5);
                                tempCombination[5] = himp6.get(idx6);
                                if(!isOperator(himp6.get(idx6).charAt(0))){
                                    himp6.remove(idx6);
                                }
                                
                                //lokasi 7
                                for(int idx7 = 0; idx7<himp6.size(); idx7++){
                                    List<String> himp7 = new ArrayList<String>(himp6);
                                    tempCombination[6] = himp7.get(idx7);
                                    if(!isOperator(himp7.get(idx7).charAt(0))){
                                        himp7.remove(idx7);
                                    }
                                    
                                    String[] tempCombination1 = new String[7];
                                    for(int i=0; i<tempCombination.length; i++){
                                        tempCombination1[i] = String.copyValueOf(tempCombination[i].toCharArray());
                                    }
                                    
                                    returnedCombination.add(tempCombination1);
//                                    System.out.print("tempCombination: ");
//                                    for(int i=0; i<7; i++){
//                                        System.out.print(tempCombination[i]+',');
//                                    }
//                                    System.out.println("it: " + it);
//                                    it++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return returnedCombination;
    }
    
    private double evaluateCount(double op1, double op2, char charAt) {
//        System.out.println("op1: " + op1 + ", op2: " + op2 + ", operator: " + charAt);
        
        if(charAt == '+')
            return op1+op2;
        if(charAt == '-')
            return op2-op1;
        if(charAt == '*')
            return op1*op2;
        if(charAt == '/')
            return op2/op1;
        
        return -999;
    }
    
    public String getSolution(List<String[]> combination){
        String solution = "";
        boolean found = false;
        int i = 0;
        
        while(!found && i < combination.size()){
            stack = new Stack<>();
            
//            String temp = Arrays.toString(combination.get(i));
            
//            System.out.println("i: " + String.valueOf(i) + ", String[]: " + temp);
            if(isSolveable(combination.get(i))){
//                System.out.println("isi stack: " + stack.size());
                double res = stack.pop();
                if(res > 23.9 && res < 24.1)
                {
                    found = true;
                    for(int j=0; j<7; j++){
                        solution += combination.get(i)[j];
                    }
                }
                else {
                    i++;
                }
            }
            else i++;
        }
        
        
        return solution;
    }
    
    String postfixToInfix(String postfix) {
        class Expression {
            String op, ex;
            int prec = 3;
 
            Expression(String e) {
                ex = e;
            }
 
            Expression(String e1, String e2, String o) {
                ex = String.format("%s %s %s", e1, o, e2);
                op = o;
                prec = operators.indexOf(o) / 2;
            }
        }
 
        Stack<Expression> expr = new Stack<>();
 
        for (char c : postfix.toCharArray()) {
            int idx = operators.indexOf(c);
            if (idx != -1) {
 
                Expression r = expr.pop();
                Expression l = expr.pop();
 
                int opPrec = idx / 2;
 
                if (l.prec < opPrec)
                    l.ex = '(' + l.ex + ')';
 
                if (r.prec <= opPrec)
                    r.ex = '(' + r.ex + ')';
 
                expr.push(new Expression(l.ex, r.ex, "" + c));
            } else {
                expr.push(new Expression("" + c));
            }
        }
        return expr.peek().ex;
    }
    
    String postfixToInfix2(String postfix) {
 
        Stack<String> expr = new Stack<>();
 
        for (char c : postfix.toCharArray()) {
            System.out.println("c: " + c);
            
            int idx = operators.indexOf(c);
            if (idx != -1) {
 
                String right = expr.pop();
                String left = expr.pop();
                
                String temp = "";
                if(idx < 3){
                    temp = '(' + left + c + right + ')';
                }
                else temp = left + c + right;
                
                expr.push(temp);
            } else {
                expr.push(String.valueOf(c));
            }
        }
        
        return expr.peek();
    }
    
    public static void main(String[] args){
        String input = "12+";
        BruteForce game = new BruteForce();
//        if(game.isSolveable(input))
//         System.out.println(input + ": " + String.valueOf(game.stack.pop()));
//        System.out.println("ivana");
//        List<String[]> combination = game.getCombination("2,3,1,6");
//        for(int i=0; i<combination.size(); i++){
//            System.out.println("isi combination: " + Arrays.toString(combination.get(i)));
//        }
        String hasil = game.getSolution(game.getCombination("3,3,7,7"));
        System.out.println(hasil);
        System.out.println(game.postfixToInfix2(hasil));
    }

}
