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


    public static void putDictCharInHashtable(ArrayList<Character> list){
        Hashtable<Integer, String> h = new Hashtable<Integer, String>();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == list.get(i+1)){
                h.put(i, "");
            }

        }
            h.put(3, "");
        h.put(2, "");
        h.put(1, "");
    }


    public static void main (String[] args) {

        Hashtable<String, String> hashMots = new Hashtable<>();
        ArrayList<String> listeMots = new ArrayList<>();

        try{
            File DicoFile = new File("/home/samantha/IdeaProjects/tp2algo/minidico.txt");     // à changer
            Scanner scan = new Scanner(DicoFile);

            while(scan.hasNextLine()){
                String mot = scan.nextLine();
                String motTrié = sortString(mot);
                listeMots.add(mot);
                hashMots.put(motTrié, mot);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Fichier non trouvé");
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir un mot à répétitions R :");
        String motRepet = sc.nextLine();

        foreach

        listeMots.clear();
        hashMots.clear();

    }
}
