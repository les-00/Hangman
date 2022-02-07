/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import javafx.geometry.Insets;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

/**
 *
 * @author lesib
 */
public class HangManGame extends Pane {
    
    private String trueWord = "HELLOWORLD";
    private String current  = trueWord;
    private char[] wordToUser;
    private Text myText = new Text();
    private VBox root = new VBox(25);
    private Stickman stickman = new Stickman();
    private String uText, uText1="Guess a word: ";
    public HangManGame() {
        createWordToUser();
        setupRoot();
        getChildren().add(root);
    }
    
    
    private void setupRoot()
    {
        myText.setText(uText);
        root.getChildren().addAll(myText, stickman);
        root.setPadding(new Insets(10));
        setupListeners();
    }
    private void  createWordToUser()
    {
        wordToUser = new char[trueWord.length()];
        for(int i =0;i<trueWord.length();i++)
            wordToUser[i]='*';
        uText = uText1 + String.valueOf(wordToUser);
    }
    
    public void setupListeners(String e)
    {
    	String key = e;
    	System.out.println(e);
        if(key.length() == 1)
        {
            updateUserText(key.charAt(0));
        }
    }
    
    public void setupListeners()
    {
    
    	setOnKeyPressed(e ->
    	{
    		
    		String key = String.valueOf(e.getCode());
        	System.out.println(e);
            if(key.length() == 1)
            {
                updateUserText(key.charAt(0));
            }
            else if(e.getCode() == KeyCode.ENTER)
            {
            	if(stickman.isPlay())
            		stickman.stopAnim();
            	else
            		stickman.playAnim();
            }
            
            //e.consume();
    	});
    }
    
    private void updateUserText(char keyPressed)
    {
        int i = current.indexOf(keyPressed);
        
        if(i != -1)
        {
            current = current.replaceFirst(String.valueOf(keyPressed) , " ");
            wordToUser[i] = keyPressed;
            myText.setText(uText1 + String.valueOf(wordToUser));
            System.out.println(String.valueOf(wordToUser));
            System.out.println("current:" +current);
        }
    }
}
