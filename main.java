import java.util.*;
import java.time.LocalDateTime;
public class main
{
        public static void main(String args[])
        {
            try{

                Cane c = new Cane();
                Place place = new Place(10, 20);
                
                Place train = new Train(4, 3);
                Place hollow = new Hollow(7, 1);
                Human s = new Human("scuperfield", train);
                c.setOwner(s);            
                s.buy(c);
                s.hasBeenTo(new Hollow(7,1),LocalDateTime.of(2017,9,14,6,20));
                s.hasBeenTo(new Hotel(2,10),LocalDateTime.of(2017,9,14,8,40));
                s.hasBeenTo(new Car(5,2),LocalDateTime.of(2017,9,14,11,0));
                s.hasBeenTo(train,LocalDateTime.of(2017, 9, 15, 4, 30));
                s.lose(c);
                System.out.println(s.searchFor(c));
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
            
    }
    
}