import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.util.Hashtable;


public class Main {

    public static String sortString(String line){
        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i < line.length(); i++){
            list.add(line.charAt(i));
        }
        Collections.sort(list);
        String s = new String();

        for(int i = 0; i < list.size(); i++){
            s += list.get(i);
        }
        System.out.println(s);
        return s;
    }


    public static boolean wordIsInwordRepet(String word, String wordRepet){
        ArrayList<Character> listLettersWordRepet = new ArrayList<>();

        for(int i = 0; i < wordRepet.length(); i++)
            listLettersWordRepet.add(wordRepet.charAt(i));

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int j = listLettersWordRepet.indexOf(c);
            if(j >= 0) listLettersWordRepet.remove(j);
            else return false;
        }
        return true;
    }


    static public String complementaryOfWordForWordRepet(String word, String wordRepet){
        ArrayList<Character> listLettersWordRepet = new ArrayList<>();

        for(int i = 0; i < wordRepet.length(); i++)
            listLettersWordRepet.add(wordRepet.charAt(i));

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int j = listLettersWordRepet.indexOf(c);
            if(j >= 0) listLettersWordRepet.remove(j);
            else return "";
        }
        String s = new String();

        for(int i = 0; i < listLettersWordRepet.size(); i++){
            s += listLettersWordRepet.get(i);
        }
        return s;
    }


    /*public static void putDictCharInHashtable(ArrayList<Character> list){
        Hashtable<Integer, String> h = new Hashtable<Integer, String>();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == list.get(i+1)){
                h.put(i, "");
            }

        }
            h.put(3, "");
        h.put(2, "");
        h.put(1, "");
    }*/


    public static void main (String[] args) {

        Hashtable<String, String> hashMots = new Hashtable<>();
        ArrayList<String> listWords = new ArrayList<>();

        try{
            File DicoFile = new File("/home/samantha/IdeaProjects/tp2algo/minidico.txt");     // à changer
            Scanner scan = new Scanner(DicoFile);

            while(scan.hasNextLine()){
                String word = scan.nextLine();
                String sortedWord = sortString(word);
                listWords.add(word);
                hashMots.put(sortedWord, word);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Fichier non trouvé");
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir un mot à répétitions R :");
        String wordRepet = sc.nextLine();

        for(String word : listWords){
            if(!wordIsInwordRepet(word, wordRepet)) continue;

            String wordComplementary = complementaryOfWordForWordRepet(word, wordRepet);
            String result = hashMots.get(wordComplementary);
            if(result != null) System.out.println(result);
        }

        /*boolean résultat = wordIsInwordRepet("ddab", "abbadd");
        System.out.println(résultat);*/

        //System.out.println(complementaryOfWordForWordRepet("ddab", "abbadd"));

        listWords.clear();
        hashMots.clear();

    }
}
