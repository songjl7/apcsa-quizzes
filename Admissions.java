import java.util.Scanner;

public class Admissions{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter last name");
        String lastname = scanner.next();
        System.out.println("Enter SAT score (0-1600)");
        int sat = scanner.nextInt();
        System.out.println("Enter class rank percentile (0-99)");
        int rank = scanner.nextInt();
        System.out.println("Enter number of awards");
        int awards  = scanner.nextInt();
        System.out.println("Enter State of residence");
        String residence = scanner.next();

        scanner.close();

        int elite = 0;
        int solid = 0;
        int nope = 0;
        String reason = "";
        String admitstatus = "";
        
        if (1499 < sat && sat > 1500){
            elite++;
        } else if (1400 < sat && sat < 1500){
            solid++;
        } else {
            nope++;
        }
        
        if (rank >= 95){
            elite++;
        } else if (rank >= 90 && rank < 95){
            solid++;
        } else {
            nope++;
        }
        
        if (awards >= 10){
            elite++;
        } else if (awards == 8 || awards == 9){
            solid++;
        } else {
            nope++;
        }
        
        if (residence.equals("Colorado")){
            elite++;
        } else if (residence.equals("Florida")){
            nope++;
        } else {
            solid++;
        }

        if (lastname.equals("Padjen") && nope == 0){
            admitstatus = "admitted";
            reason = "your last name is Padjen and you had no statuses lower than acceptable.";
        } else if (elite >= 1){
            admitstatus = "admitted";
            reason = "you have one or more elite statuses.";
        } else if (solid >=2 ){
            admitstatus = "admitted";
            reason = "you have two or more solid statuses.";
        } else if (nope > 0){
            admitstatus = "not admitted";
            reason = "you were not acceptable in one or more categories";
        }

        System.out.println("You were " + admitstatus + " because " + reason);
    }
}