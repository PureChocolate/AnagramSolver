import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Anagram{

    static ArrayList<String> list = new ArrayList<String>();

    public static void file(){
        String filePath = "D:/Code/Anagram/wlist_match1.txt";
        try{
            BufferedReader lineReader = new BufferedReader(new FileReader(filePath));
            String lineText = null;
            //Scanner read = new Scanner(new File("D:/Code/Anagram/words.txt"));
            while((lineText = lineReader.readLine()) != null){
                list.add(lineText);
            }
            lineReader.close();
        }
        catch(IOException e){
            System.out.println("IOEx");
        }
        
    }

    public static ArrayList<String> solve(String word){
        ArrayList<String> ret = new ArrayList<String>();
        //boolean match = false;
        ArrayList<String> tempList = new ArrayList<String>();
        String temp = "" + word;
        for(int j = 0; j < temp.length(); j++){
            tempList.add(Character.toString(temp.charAt(j)));
        }
        int count = 0;
        for(int i = 0; i < list.size(); i++){
            String holderWord = list.get(i).toLowerCase();
            ArrayList<String> holdList = new ArrayList<String>();
            for(int k = 0; k < holderWord.length(); k++){
                holdList.add(Character.toString(holderWord.charAt(k)));
            }
            Collections.sort(tempList);
            Collections.sort(holdList);
            if(tempList.equals(holdList)){
                ret.add(" " + holderWord + " (word place: " + count + ")");
            }
            count++;
        }
        return ret;
    }

    public static void main(String args[]){
        file();
        System.out.println("List length: " + list.size());
        String ana = JOptionPane.showInputDialog("Enter the anagram! (no caps)");
        String anag = ana.toLowerCase();
        ArrayList<String> c = solve(anag);
        System.out.print("Words found:");
        for(int u = 0; u < c.size(); u++){
            System.out.print(c.get(u));
        }
        ///System.out.println(list.get(466543));       
    }
}