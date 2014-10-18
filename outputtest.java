import java.io.*;
import java.util.*;

public class outputtest{

public outputtest(){

}
public static void main(String [] args) throws IOException{
 File out = new File("save.txt");
 FileWriter go = new FileWriter(out);
 go.write("Hello");
 go.write("\n");
 go.write("Cats");
 go.close();
}

}