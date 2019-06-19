import java.util.*;
public class main
{
        public static void main(String args[])
        {
            try{
                Human s = new Human();
                Human c1 = new Human();
                Human c2 = new Human();
                Human c3 = new Human();
                Cane c = new Cane();
                Place place = new Place();
                Place hotel = new Hotel();
                Place car = new Car();
                Place train = new Train();
                Place hollow = new Hollow();
                s.setName("scuperfield");
                c.setOwner(s);            
                s.buy(c);
                s.setLocation(train);
                List l = new ArrayList<Place>();
                l.add(hotel);
                l.add(train);
                l.add(car);
                l.add(hollow);
                s.hasBeenTo(l);
                s.lose(c, place);
                System.out.println(s.searchFor(c));
            }
            catch(NullPointerException e)
            {
                System.out.println(e.getMessage());
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
            
    }
    
}
