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
    Stack<Integer> stack;
    
    public BruteForce(){
        stack = new Stack<>();
    }
    
    public boolean isSolveable(String input){
        
        for(int i=0; i<input.length(); i++){
            if(isOperator(input.charAt(i))){
                if(stack.size() < 2)
                    return false;
                else{
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    
                    int res = evaluateCount (op1, op2, input.charAt(i));
                    stack.push(res);
                }
            }
            else{
                stack.push(Integer.valueOf(String.valueOf(input.charAt(i))));
            }
        }
        
        if(stack.size()==1)
            return true;
        
        return false;
    }
    
    public boolean isOperator(char c){
        if(c == '+' || c == '-' || c == '*' || c == '/')
            return true;
        return false;
    }
    
    public List<String[]> getCombination(String number){
        List<String[]> returnedCombination = new ArrayList<>();
        int it = 0;
        
        String seed = number+','+operators;
        List<String> himpunan = new ArrayList<String>(Arrays.asList(seed.split(",")));
        System.out.println("himpunan: " + himpunan.toString());
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
                                    
                                    returnedCombination.add(tempCombination);
//                                    
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
    
    private int evaluateCount(int op1, int op2, char charAt) {
        System.out.println("op1: " + op1 + ", op2: " + op2 + ", operator: " + charAt);
        
        if(charAt == '+')
            return op1+op2;
        if(charAt == '-')
            return op1-op2;
        if(charAt == '*')
            return op1*op2;
        if(charAt == '/')
            return op1/op2;
        
        return -999;
    }
    
    public static void main(String[] args){
        String input = "12+";
        BruteForce game = new BruteForce();
//        if(game.isSolveable(input))
//         System.out.println(input + ": " + String.valueOf(game.stack.pop()));
        System.out.println(game.getCombination("2,3,1,6").size());
    }

}
