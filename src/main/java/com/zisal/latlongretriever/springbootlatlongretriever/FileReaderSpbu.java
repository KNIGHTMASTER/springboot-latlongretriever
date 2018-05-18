package com.zisal.latlongretriever.springbootlatlongretriever;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 5/18/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class FileReaderSpbu {

    public List<String> getSpbuName() {
        List<String> result = new ArrayList<>();
        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("spbu.spbu").getFile());

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.substring(0,2).concat("-").concat(line.substring(2, line.length()));
                result.add(line);
            }

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
