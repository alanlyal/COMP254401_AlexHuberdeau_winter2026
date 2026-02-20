package ex3;
import java.util.Scanner;
import java.io.File;
public class Task3 {
    public static void find(File path, String filename)
    {
        if (path == null || !path.exists()) //if the path is invalid
        {
            return;
        }
        if(path.isDirectory())
        {
            File[] files = path.listFiles(); // give access to files
            if (files != null)// if the direcoty is usable
            {
                for(File f : files)// loop through each file
                {
                    find(f, filename);//look through inside of each file
                }
            }
        } else if (path.getName().equals(filename))//if the file and the name mathces
        {
            System.out.println("i found the file: "+ path.getAbsolutePath());
        }
    }
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("please enter the folder path: ");
        String path = scan.nextLine();
        System.out.println("enter the file you want me to search for: ");
        String file = scan.nextLine();
        File root = new File(path);
        find(root, file);
        scan.close();
    }
    //
}
