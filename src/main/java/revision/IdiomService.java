package revision;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IdiomService {
    
    public List<String> readFile (String fullPathFileName) throws IOException{

        // Open a file for reading line-by-line
        File file = new File(fullPathFileName);
        BufferedReader br = new BufferedReader(new FileReader(file));

        // Store the read idiom from file
        List<String> idiomList = new ArrayList<>();

        String line;

        while((line=br.readLine())!=null){
            idiomList.add(line);
        }

        br.close();

        return idiomList;
    }

    public String randomIdiom(List<String> idioms){
        Random rand = new Random();
        String randomIdiom;
        if (idioms.size() > 0){
            int randomIndex = rand.nextInt(idioms.size());
            randomIdiom = idioms.get(randomIndex);
        } else {
            randomIdiom = "No idiom found";
        }
        return randomIdiom;
    }

    public void showAllIdioms (List<String> idioms){
        idioms.forEach(s -> System.out.println(s));
        // alternative way to print each line:
        // idioms.forEach(System.out::println);
    }

    
}
