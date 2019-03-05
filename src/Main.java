import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.util.Hashtable;


public class Main {

    public static void transformStringIntoSortedArrayOfChar(String line){
        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i < line.length(); i++){
            list.add(line.charAt(i));
        }
        Collections.sort(list);
        System.out.println(list);
    }


    public static void main (String[] args) {

        try{
            File DicoFile = new File("/amuhome/t17001743/IdeaProjects/tp2algo/minidico.txt");
            Scanner scan = new Scanner(DicoFile);

            while(scan.hasNextLine()){
                String line = scan.nextLine();
                transformStringIntoSortedArrayOfChar(line);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Fichier non trouvé");
        }



        Hashtable<Integer, String> h = new Hashtable<Integer, String>();

        h.put(3, "");
        h.put(2, "");
        h.put(1, "");

        // checking hash table h
        System.out.println("" + h);

        // clear hash table h
        h.clear();

    }
}
