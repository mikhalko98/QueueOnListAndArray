import java.util.Scanner;

public class Main {
    private int n;
    private String st;
    private LinkedList a = new LinkedList();
    private Scanner in = new Scanner(System.in);
    private Scanner str = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        menu();
    }

    private void menu() {
        int check = 1;
        int act;
        while (check == 1) {
            textMenu();
            act = in.nextInt();
            switch (act) {
                case 1:
                    createStack();
                    break;
                case 2:
                    if (!a.isEmpty()) addElement();
                    else System.out.println("Stack empty");
                    break;
                case 3:
                    if (!a.isEmpty()) a.deleteEl();
                    else System.out.println("Stack empty");
                    break;
                case 4:
                    if (!a.isEmpty()) a.show();
                    else System.out.println("Stack empty");
                    break;
                case 5:
                    correctStr();
                    break;
                case 6:
                    check = 0;
                    break;
                default:
                    System.out.println("Incorrectly");
                    break;
            }
        }
    }

    private void addElement() {
        System.out.print("Enter line: ");
        st = str.nextLine();
        a.Add(st);
    }

    private void createStack() {
        System.out.print("Enter number: ");
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter line " + (i + 1) + " : ");
            st = str.nextLine();
            a.Add(st);
        }
    }

    private void textMenu() {
        System.out.println("Enter number:");
        System.out.println("1 - Create stack ");
        System.out.println("2 - Add element in stack ");
        System.out.println("3 - Delete first ");
        System.out.println("4 - Show stack");
        System.out.println("5 - Correct brackets");
        System.out.println("6 - Exit");
    }

    private void correctStr() {
        String st;
        System.out.print("Enter str: ");
        st = str.nextLine();
        if (checkStr(st)) System.out.println("Correct");
        else System.out.println("Incorrect");
    }

    private boolean checkStr(String st) {
        LinkedList s = new LinkedList();
        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) == '(' || st.charAt(i) == '[')
                s.Add(st.charAt(i));
            else {
                if (s.isEmpty()) return false;
                else {
                    if (st.charAt(i) == ')')
                        if (s.getfirst().getValue().equals('('))
                            s.deleteEl();
                        else return false;
                    if (st.charAt(i) == ']')
                        if (s.getfirst().getValue().equals('['))
                            s.deleteEl();
                        else return false;
                }
            }
        }
        return s.isEmpty();
    }
}
