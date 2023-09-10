import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int firsttrain=50;
    public static int secondtrain=50;
    public static int thirdtrain=50;
    public static int count=0;

    //****************************************** ANSI Color ********************************************************
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String GREEN_BRIGHT = "\033[0;92m";
    public static final String BLUE_BRIGHT = "\033[0;94m";

    // BackGround Color
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";


    //******************************************** Color End ********************************************************
    public static ArrayList<String> name= new ArrayList<String>(50);
    public static ArrayList<String> phoneNum= new ArrayList<String>(50);
    public static ArrayList<Integer> fares= new ArrayList<Integer>(50);
    public static ArrayList<Integer> seatNum=new ArrayList<Integer>(50);
    public static ArrayList<String> trainDetails= new ArrayList<String>(50);
    public static void main(String[] args) {
        ArrayList<String> station = new ArrayList<>(List.of("Delhi","Jaipur","Prayagraj","Mumbai"));
        System.out.println("\t\t\t\t\t\t\t ***************************");
        System.out.println(ANSI_RED+"\t\t\t\t\t\t\t Railway Reservation System"+ANSI_RESET);
        System.out.println("\t\t\t\t\t\t\t ***************************");
        System.out.println();
        System.out.println(ANSI_BLUE+"Now available stations are:" +station+ANSI_RESET);
        boolean loop=true;

        while(loop) {
            System.out.println(ANSI_BLUE_BACKGROUND+ANSI_BLACK+"*****************************************************************************"+ANSI_RESET);
            System.out.println(ANSI_BLUE_BACKGROUND+ANSI_BLACK+"Available Train between Four Station :                                       "+ANSI_RESET);
            System.out.println(ANSI_BLUE_BACKGROUND+ANSI_BLACK+"*****************************************************************************"+ANSI_RESET);
            System.out.println(ANSI_GREEN+"Train Name\t\t\t" + "Time\t\t\t" + "Passenger Strength\t\t\t" + "Train Number");
            System.out.println("Mumbai-Delhi\t\t" + "13:05\t\t\t\t\t" + firsttrain + "\t\t\t\t\t1010(Mumbai Superfast)");
            System.out.println("Delhi-Jaipur\t\t" + "7:00\t\t\t\t\t" + secondtrain + "\t\t\t\t\t2013(Delhi SuperFast)");
            System.out.println("Prayagraj-Delhi\t\t" + "10:00\t\t\t\t\t" + thirdtrain + "\t\t\t\t\t3045(Prayagraj EXP)"+ANSI_RESET);
            System.out.println("*****************************************************************************");
            System.out.println(BLUE_BRIGHT+"1.Book Your Ticket              "+ANSI_RESET);
            System.out.println(BLUE_BRIGHT+"2.Display All Ticket information"+ANSI_RESET);
            System.out.println(BLUE_BRIGHT+"3.Search Your Own Ticket.       "+ANSI_RESET);
            System.out.println(BLUE_BRIGHT+"4.Cancle Your Ticket            "+ANSI_RESET);
            System.out.println(BLUE_BRIGHT+"5.Exit From The Code            "+ANSI_RESET);
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Your Choose: ");
            int x= sc.nextInt();
            try {
                switch (x) {
                    case 1:
                        try {
                            System.out.println("Enter Train Number: ");
                            int trainNum = sc.nextInt();
                            if (SeatAvailability(trainNum)) {
                                BookingFunction(trainNum);
                                break;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    case 2:
                        DisplayAllTicket();
                        break;
                    case 3:
                            if (name.size() > 0) {
                                System.out.println("Enter your Phone Number: ");
                                String phone = sc.next();
                                for (int i = 0; i < name.size(); i++) {
                                    if (phone.equals(phoneNum.get(i))) {
                                        SearchTicket(phone);
                                        break;
                                    } else if (i == name.size() - 1) {
                                        System.out.println("Ticket is not Book Yet....");
                                        break;
                                    }
                                }
                                break;
                            } else {
                                System.out.println("Today Ticket Booking not started.");
                                break;
                            }

                    case 4:
                            if (name.size() > 0) {
                                System.out.println("Enter your Phone Number: ");
                                String phoneNo = sc.next();
                                for (int i = 0; i < name.size(); i++) {
                                    if (phoneNo.equals(phoneNum.get(i))) {
                                        cancelTicket(phoneNo, i);
                                        break;
                                    } else if (i == name.size() - 1) {
                                        System.out.println("Ticket is not Book Yet....");
                                        break;
                                    }
                                }
                                break;
                            } else {
                                System.out.println("Today Ticket Booking not started.");
                                break;
                            }

                    case 5:
                        System.out.println("Enjoy Your Day!!!!!!");
                        loop = false;
                        break;

                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }

    }


    // CanCeling function
    public static void cancelTicket(String phone,int i){
        try {
            if (phone.equals(phoneNum.get(i))) {
                name.remove(i);
                seatNum.remove(i);
                phoneNum.remove(i);
                trainDetails.remove(i);
                fares.remove(i);
            }
        }
        catch (Exception o){
            System.out.println("Exception occcur");
        }

    }

    // All Ticket Display Function.......................
    public static void DisplayAllTicket(){
        System.out.println();
        System.out.println("***************************************************************************************************");
        System.out.println(GREEN_BRIGHT+"Sno\t\t\t\t\tTicket Owner\t\t\t\t\tSeat Number\t\t\t\t\tTrain Ticket Price\t\t\t\t\t\t\t\tTrain Details"+ANSI_RESET);
        if(name.size()>0) {
            for (int i=0;i<name.size();i++) {
                System.out.println(GREEN_BRIGHT+(i + 1) + "\t\t\t\t\t" + name.get(i) + "\t\t\t\t\t" + seatNum.get(i) + "\t\t\t\t\t\t\t\t" + fares.get(i) + "\t\t\t\t\t\t\t\t\t\t\t" + trainDetails.get(i)+ANSI_RESET);
            }
        }
        else{
            System.out.println("No Ticket Is Book So far......");
        }
        System.out.println("***************************************************************************************************");
    }


    // Search Train Ticket Function.............................
    public static void SearchTicket(String phone){
        System.out.println();
        for(int i=0;i<name.size();i++) {
                String p = phoneNum.get(i);
                if (phone.equals(p)) {
                    System.out.println("***************************************************************************************************");
                    System.out.println(GREEN_BRIGHT+"Sno\t\t\t\t\tTicket Owner\t\t\t\t\tSeat Number\t\t\t\t\tTrain Ticket Price\t\t\t\t\t\t\t\tTrain Details"+ANSI_RESET);
                    System.out.println(GREEN_BRIGHT+(i + 1) + "\t\t\t\t\t" + name.get(i) + "\t\t\t\t\t" + seatNum.get(i) + "\t\t\t\t\t\t\t\t" + fares.get(i) + "\t\t\t\t\t\t\t\t\t\t\t" + trainDetails.get(i)+ANSI_RESET);
                    System.out.println("***************************************************************************************************");
                }

        }
    }





    // Booking funtion start ----------------------------------------
    public static void BookingFunction(int trainNum){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("Enter Your Name :");
            String name1 = sc.nextLine();
            name.add(name1);
            System.out.println("Enter Your Phone Number: ");
            String phone = sc.nextLine();
            phoneNum.add(phone);
            Random rand = new Random();
            Integer seatNo = rand.nextInt(1000 - 500 + 1) + 500;
            seatNum.add(seatNo);
            if (trainNum == 1010) {
                System.out.println("Ticket Price: 1000");
                fares.add(1000);
                trainDetails.add("Mumbai-Delhi   13:05   Mumbai Superfast");
                firsttrain = firsttrain - 1;
            } else if (trainNum == 2013) {
                System.out.println("Ticket Price: 500");
                fares.add(500);
                trainDetails.add("Delhi-Jaipur   7:00    Delhi Superfast");
                secondtrain = secondtrain - 1;
            } else {
                System.out.println("Ticket Price: 800");
                fares.add(800);
                trainDetails.add("Prayagraj-Delhi    10:00      Prayagraj EXP");
                thirdtrain = thirdtrain - 1;
            }
            count = count + 1;
            System.out.println("Ticket Booking is sucessfully Done.......");
        }
        catch (Exception o){
            o.printStackTrace();
        }


    }

    // seat is available or not function ---------------------------------------
    public static boolean SeatAvailability(int trainNum){
        System.out.println();
        if(trainNum==1010){
            if(firsttrain==0){
                return false;
            }
            else{
                return true;
            }
        } else if (trainNum==2013) {
            if(secondtrain==0){
                return false;
            }
            else{
                return true;
            }
        } else if (trainNum==3045) {
            if(thirdtrain==0){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            System.out.println("Choose right Train Number....");
            return false;
        }
    }

    //------------------------function end---------------------------


}