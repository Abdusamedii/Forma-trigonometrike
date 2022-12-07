import java.util.*;
import javax.swing.*;

public class NjeProv{

    public NjeProv() {
        Scanner sc = new Scanner(System.in);
        System.out.println("zgjidh metoden qe deshironi ta beni: 1.Matrica");
        int x = sc.nextInt();

        if(x == 1){
        Scanner a = new Scanner(System.in);
        System.out.print("Shkruani rangun e matrices: ");
        int rangu = a.nextInt();
        if(rangu == 3){
            Matrica m = new Matrica(rangu,rangu);
            m.lexoElementet();
            m.printoMatricen();
            m.Sarusit(m);
            System.out.println("test1");
        }
        else if(rangu == 4){
            Matrica m = new Matrica(rangu,rangu);
            m.lexoElementet();
            m.printoMatricen();
            System.out.println(m.metodaEMinoreve(m));
            System.out.println("test1");
        }
        else if(rangu != 3 || rangu != 4){
            JOptionPane.showMessageDialog(null, "Matrixa duhet te jete 3x3/4x4", "Gabim ne te dhena", JOptionPane.ERROR_MESSAGE);
        }
    }
        
    }

    public static void main(String[] args) {
        new NjeProv();
    }

}
