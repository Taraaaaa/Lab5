
public interface livable
{
   
    void sleep();
    void wakeUp();
    void buy(Object object) throws Exception;
    void lose(Object object, Place place) throws Exception;
    void lose(Object object) throws Exception;
    String searchFor(Object object);
}
