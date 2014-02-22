/*David Caballero
February 19, 2014
This program solves the Towers of hanoi problem while following to the rules of 
tower of hanoi. The 3 stacks represent the individual pegs: left being the 
starting peg, Middle being the middle peg, and right being the end peg. The 
program first checks to see if the input is in between the correct bounds. 
Once the correct amount of disc has been received it stores all the values into 
the beginning stack (left). Then calls the prinstack method to show the current 
state of all the pegs.  The move method is what movs the disks into the goal 
state. Once a disk has been initiate it calls the pritstack to show the new 
state. After all the moves have been completed it prints out the goal state.
THE END :)
*/
import java.util.*;
public class HanoiTowers {
   // public static int D;
    public static Stack left = new Stack(); 
    public static Stack middle = new Stack(); 
    public static Stack right = new Stack(); 
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int disc=0;
        do{
        System.out.println("Please input number of starting disks."
               + " Must be between 1 and 8, do not include 1 or 8.");
        disc = input.nextInt();
       }while(disc <=0 || disc>=8);    // Input Validation
       
       System.out.println("Amount of Disks: " +disc);
        for(int i=disc;i>0;i--){
        left.push ( new Integer(i) ); 
        }
       printstack();        // Prints state of all pegs
       move(disc,left,right,middle);
    }
    //Moves all pegs recursively to reach the goal state
public static void move(int n, Stack Start, Stack goal, Stack middle) {      
  if (n == 1) {
    goal.push(Start.pop());// Move disk from its starting point to the goal point
    printstack();          // Print new state
  }else {     
    move(n-1, Start, middle, goal);
    goal.push(Start.pop());
    printstack();          // Print new state
    move(n-1, middle, goal, Start);
  }        
}
public static void printstack(){ //Prints states
    System.out.print("___________");
       System.out.println("\nStart: "+left+"\nMiddle: "+middle+"\nGoal: "+right); 
}
}


