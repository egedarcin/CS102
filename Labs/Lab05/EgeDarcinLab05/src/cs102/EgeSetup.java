/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102;

/**
 *
 * @author egedarcho
 */
public class EgeSetup extends BasicSetup{
    
    private static String[] words = {"Deniz", "Kum" , "Sahil" , "Bayram" , "Darcho" , "Heleloy","NaBerSin"};
   
    
    @Override
    public String chooseSecretWord()
	{
		int random = (int) (Math.random() * words.length );
		return words[ random];
	}
    
}
