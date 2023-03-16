package jhangman1;

import java.io.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Words {

    private ArrayList<Word> listOfWords;
    private Random rand;
    private Word emergencyWord;

    public Words() {
        this.listOfWords = new ArrayList<>();
        this.rand = new Random();
        this.emergencyWord = new Word("attack");
    }

    public void addWordsToListOfWords(String wordCategory) {
       
        try {
            //File words = new File("C:\\Users\\PC\\Documents\\NetBeansProjects\\JHangman1\\src\\words" + wordCategory + ".txt");
            File words = new File("words/" + wordCategory + ".txt");
            Scanner reader = new Scanner(words);

            while (reader.hasNextLine()) {
                String data = reader.nextLine().strip();
                Word word = new Word(data.toLowerCase());
                word.splitWordToLetters();
                this.listOfWords.add(word);
            }

            reader.close();
        }
        catch (FileNotFoundException e) { 
        }
    }

    public Word selectRandomWord() {
        /*
        Selects a random word from the list of words
         */

        if (this.listOfWords.size() > 0) {
            int upperbound = this.listOfWords.size();
            return this.listOfWords.get(rand.nextInt(upperbound));
        }
        return this.emergencyWord;
    }

    public void resetListOfWords() {
        this.listOfWords.clear();
    }
}
