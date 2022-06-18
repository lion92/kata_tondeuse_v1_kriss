package read;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Read {
    private String path;
    private String recup;

    public Read(String path) {
        this.path = path;
        this.recup="";
    }

    public String reading() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.path));

            String lecture;
            try {
                while ((lecture = reader.readLine()) != null) {
                    this.recup = this.recup + lecture + "\n";
                }
            } catch (IOException io) {
                System.out.println(io);

            }
        } catch (FileNotFoundException fileEx) {
            System.out.println(fileEx);
        }

        return this.recup;
    }

}
