/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzhostelmanagementsystem;

import java.util.Random;

/**
 *
 * @author Killi
 */
public class Week12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rn = new Random();
        
        int number_ls[] = new int[100];
        
        for(int i=0; i<number_ls.length; i++){
            number_ls[i] = rn.nextInt();
        }
        
        for(int i: number_ls){
            System.out.println(i);
        }
        try{
            System.out.println(number_ls[100]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Out Of Bounds");
        }
        
    }
    
}
