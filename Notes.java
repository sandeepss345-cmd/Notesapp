import java.io.*;
import java.util.Scanner;

public class NotesApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n1. Write Note");
            System.out.println("2. Read Notes");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); // consume newline

            if(ch==1){
                System.out.print("Enter note: ");
                String note = sc.nextLine();
                try{
                    FileWriter fw = new FileWriter("notes.txt", true);
                    fw.write(note + "\n");
                    fw.close();
                    System.out.println("Note saved.");
                }catch(IOException e){
                    System.out.println("Error: " + e.getMessage());
                }
            }else if(ch==2){
                try{
                    BufferedReader br = new BufferedReader(new FileReader("notes.txt"));
                    String line;
                    System.out.println("\n--- Notes ---");
                    while((line = br.readLine()) != null){
                        System.out.println("- " + line);
                    }
                    br.close();
                }catch(FileNotFoundException e){
                    System.out.println("No notes found.");
                }catch(IOException e){
                    System.out.println("Error: " + e.getMessage());
                }
            }else if(ch==3){
                System.out.println("Exiting...");
                break;
            }else{
                System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
