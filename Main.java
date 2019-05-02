import java.util.*;

public class Main {

    public static void delay(int delay) {

        try { 
            Thread.sleep(delay); 
        } 
        catch (Exception e) { 
            System.out.println(e); 
        }

    }

    public static void typeDelayEffect(int delay, String text, int delayMult) {

        for (int c = 0; c < text.length(); c++) {
            delay(
                !String.valueOf(text.charAt(c)).matches(".") ? delay * delayMult : delay
            );
            System.out.print(text.charAt(c));
        }

    }
    public static void main(String args[]) {

        LinkedListStack linkedListStack = new LinkedListStack();
        linkedListStack.push(new Node("apple"));
        linkedListStack.push(new Node("banana"));
        linkedListStack.push(new Node("cherry"));

        typeDelayEffect(
            10, 
            "=======Welcome to the CS_506 Stack Project=======\n" +
            "In this project I implement a stack using\n" +
            "a linked list. A stack has several methods.\nNamely:\n" +
            "1) peek()   //Returns item at the front of the stack\n" +
            "2) empty()  //Returns true if stack is empty, false otherwise.\n" +
            "3) search() //Searches for item in stack and returns index, -1 if it is not in stack.\n" +
            "4) pop()    //Removes and returns item at end of list.\n" +
            "5) push()   //Adds item to end of list.\n\n" +
            "Just type the command you would like to run on our stack (without parenthesis)\n" +
            "For search and push, enter the command, then a space, then the text you want to\n" + 
            "search or push.\n" +
            "Entering print will print all of the items in the stack.\n" +
            "-1 will exit the program\n\n",
            3
        );

        String input = "";
        String[] inputArr;

        while (!input.equals("-1")) {
            System.out.print("Enter Command: ");
            input = (new Scanner(System.in)).nextLine();
            inputArr = input.split(" ");
            if (inputArr.length == 1) {
                if (inputArr[0].equals("peek")) {
                    try {
                        System.out.println(linkedListStack.peak().getData());
                    }
                    catch(Exception e) {
                        System.out.println(e);
                    }
                }
                else if (inputArr[0].equals("empty")) {
                    System.out.println(linkedListStack.empty());
                }
                else if (inputArr[0].equals("pop")) {
                    try {
                        System.out.println(linkedListStack.pop().getData());
                    }
                    catch(Exception e) {
                        System.out.println(e);
                    }
                }
                else if (inputArr[0].equals("print")) {
                    linkedListStack.printList();
                }
                else {
                    System.out.println("command not recognized");
                }
            }
            else if (inputArr.length == 2){
                if (inputArr[0].equals("push")) {
                    linkedListStack.push(new Node(inputArr[1]));
                }
                else if (inputArr[0].equals("search")) {
                    System.out.println(linkedListStack.search(inputArr[1]));
                } 
                else {
                    System.out.println("command not recognized");
                }
            }
            else {
                if (!input.equals("-1")) {
                    System.out.println("command not recognized");
                }
            }
            
        }

    }
}