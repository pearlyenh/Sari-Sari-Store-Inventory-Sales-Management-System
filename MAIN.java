package SARISARISTORE;
import java.util.Scanner;
// product first 
public class MAIN{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quick reposity purposes");
        System.out.println("TO DO LIST");
        System.out.println("[1] Finish GCR");
        System.out.println("[2] Quick repository");
        System.out.println("[3] Study for STS");
        System.out.println("[4] Study for DSA");
        System.out.println("{5] Prepare for things tomorrow");
        System.out.println("[6] Rizal Quick Notes for active oral recitation");
        System.out.println("Enter an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println("You have done finish the GCR.");               
                break;
            case 2:
                System.out.println("To DO LIST");
                break;
            
        
            default:
                break;
        }
    }
}