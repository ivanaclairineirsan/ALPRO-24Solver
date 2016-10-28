/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg24solver;


/**
 *
 * @author Ivana Clairine
 */
public class Main {

    /**
     * @param args the command line arguments
     */
     
        
    public static void main(String[] args){
        BruteForce game = new BruteForce();
        String input = "11,2,1,6";
        
        String[] hasil = game.getSolution(game.getCombination(input));
        System.out.println("Angka masukan: " + input);
        System.out.println("==== BRUTE FORCE ====");
        if(!hasil.equals(""))
            System.out.println("Solusi: " + game.postfixToInfix(hasil));
        else
            System.out.println("Tidak ada solusi");
        System.out.println("=====================");
    }
}
