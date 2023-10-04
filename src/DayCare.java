import java.util.Scanner;
public class DayCare {
    static Scanner console = new Scanner(System.in);
    static String [] daycareSpaces;
    static int capacity;
    public static void main(String[] args){
        startUp();

    }
    public static void startUp(){
        System.out.println("Welcome to Doggy Daycare!");
        System.out.println("Please enter number of spaces available for today.");

        capacity = Integer.parseInt(console.nextLine());
        daycareSpaces = new String[capacity];
        menu();
    }
    public static void menu(){
        boolean exit = false;
        do{
            System.out.println("What would you like to do?");
            System.out.println("1. Check a dog into daycare");
            System.out.println("2 Check a dog out of daycare");
            System.out.println("3. View all dogs in our care");
            System.out.println("4. Exit");
            System.out.println("Please enter Choice: ");
            int choice = Integer.parseInt(console.nextLine());

            switch (choice){
                case 1:
                    checkInDog();
                    break;
                case 2:
                    checkOutDog();
                    break;
                case 3:
                    viewAllDogs();
                    break;
                case 4:
                    System.out.println("\n Goodbye.");
                    exit = true;
                    break;
                default:
                    System.out.println("Not valid");
            }
        }while(!exit);
    }

    public static void checkInDog(){
        System.out.println("\nWhat is the dog's name?");
        String dogName = console.nextLine();
        for(int i = 0; i < daycareSpaces.length; i++){
            if(daycareSpaces[i] ==  null){
                daycareSpaces[i] = dogName;
                System.out.println("\nSuccessfully checked in");
                return;
            }
        }
        System.out.println("\n Sorry, we are full");

    }

    public static void checkOutDog(){
        System.out.println("\n What is your dog's name?");
        String dogName = console.nextLine();
        for(int i = 0; i < daycareSpaces.length; i++){
            if(daycareSpaces[i] != null){
                if(daycareSpaces[i].equalsIgnoreCase(dogName)) {
                    daycareSpaces[i] = null;
                    System.out.println("\nSuccessfully checked out");
                    return;
                }
            }
        }
        System.out.println("\nSorry, we have lost your dog");
    }

    public static void viewAllDogs(){
        System.out.println("\n Current dogs in our care");
        int available = 0;
        for(int i = 0; i < daycareSpaces.length; i++){
            if(daycareSpaces[i] != null){
                System.out.println(daycareSpaces[i]);
            }else{
                available++;
            }

        }
        System.out.println("Availablity: "+ available);

    }
}
