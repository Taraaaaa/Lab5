import java.util.*;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
public class Human implements livable
{
    private String name;
    private boolean sleepingState;
    private List <Object> belongings = new ArrayList<Object>();
    private Place location;
    Memory memory = new Memory();
    
    public Human(){
    }
    public Human setName(String name) throws NullPointerException
    {
        if (name == null)
        {
            throw new NullPointerException("The name doesn't exist!");
        }
        else
        {
            this.name = name;
            return this;
        }
    }
    public String getName()
    {
        return this.name;
    }
    public Human setLocation(Place place) throws NullPointerException
    {
        if (place == null)
        {
            throw new NullPointerException("This place doesn't exist!");
        }
        this.location = place;
        place.addPerson(this);
        System.out.println(this.getName()+ " is in "+place.getClass().getName());
        return this;
    }
    public Place getLocation()
    {
        return location;
    }
    public void sleep()
    {
        this.sleepingState = false;
        System.out.println(this.getName() + " slept");
    }
    public void wakeUp()
    {
        this.sleepingState = true;
        System.out.println(this.getName() + " woke up");
    }
    public String getState()
    {
        if (sleepingState = true)
            return "Awake";
        else
            return "Asleep";   
    }
    public void buy(Object object) throws Exception
    {
        if(belongings.contains(object))
        {
            throw new Exception(this.getName()+" already has "+ object.getClass().getName());
        }
        else
        {
            this.belongings.add(object);
            System.out.println(this.getName() + " bought " + object.getClass().getName());
        }
    }
    public void lose(Object object, Place place) throws Exception
    {
        if(!this.belongings.contains(object))
        {
            throw new Exception(this.getName()+" doesn't have this object!");
        }else if(place == null)
        {
            throw new NullPointerException("This place doesn't exist!");
        }
        else{
            this.belongings.remove(object);
            place.addObject(object);
            System.out.println(this.getName() + " lost "+ object.getClass().getName());
    
        }
    }
    public void lose(Object object) throws Exception
    {
        if(!this.belongings.contains(object))
        {
            throw new Exception(this.getName()+" doesn't have this object!");
        }
        else{
            this.belongings.remove(object);
            System.out.println(this.getName() + " lost "+ object.getClass().getName());
    
        }
    }
    public List getBelongings()
    {
        return this.belongings;
    }
    public String searchFor(Object object) throws NullPointerException
    {
        if (object == null)
        {
            throw new NullPointerException("The object doesn't exist!");
        }
        else{
            System.out.println(this.getName() + " is searching for "+ object.getClass().getName());
            for(int i = 0;i < memory.getHasBeenTo().size(); i++)
            {
                Place p = memory.getHasBeenTo().get(i);
                System.out.println(this.getName()+ " is thinking if he has put " + object.getClass().getName()+ " in "+ p.getClass().getName());
                if (p.getObjects().contains(object))
                    return this.getName()+ " found " + object.getClass().getName()+ " in " + p.getClass().getName();
            }
            return this.getName() + " did not find " + object.getClass().getName()+"!";
        }   
    }
    public void hasBeenTo(Vector <Place> places, Vector <LocalDateTime> dateTime) throws NullPointerException
    {
        if(places == null)
        {
            throw new NullPointerException("The list of places doesn't exist!");
        }
        else if(dateTime == null)
        {
            throw new NullPointerException("The list of dates and times doesn't exist!");
        }
        else
        {
            memory.hasBeenTo.add(places);
            memory.hasBeenTo.add(dateTime);
        }
    }
    public void hasBeenTo(Place place, LocalDateTime dateTime) throws NullPointerException
    {
        if(place == null)
        {
            throw new NullPointerException("The list of places doesn't exist!");
        }
        else
        {
        memory.hasBeenTo;
        }
    }
    public Human.Memory getMemory()
    {
        return this.memory;
    }
    
    @Override
    public String toString()
    {
        return "Name: "+ this.getName()+ ", State: "+this.getState() + 
        ", Belongings: "+ this.getBelongings() + this.getMemory();
    }
    
    @Override
    public boolean equals(Object o) { 
   
        if (o == this) { 
            return true; 
        } 
  
        if (!(o instanceof Human)) { 
            return false; 
        } 
          
        Human c = (Human) o; 

        if((this.name == c.getName()) && (this.getState() == c.getState())&& 
        (this.belongings == c.getBelongings()) && (this.memory == c.getMemory())&&(this.location == c.getLocation()))
        {
            return true;
        }else
        {
            return false;
        }
    }
    @Override
    public int hashCode()
    {
        return this.name.length() + belongings.size() + memory.hashCode() + getLocation().getClass().getName().length();
    } 
    class Memory
    {
        List <Vector> hasBeenTo = new ArrayList();
        public Memory setHasBeenTo(Vector <Place> places, Vector <LocalDateTime> DateTime) throws NullPointerException
        {
            if(places == null)
            {
                throw new NullPointerException("The list of Places doesn't exist!");
            }
            else
            {
                hasBeenTo = places;
                return this;
            }
        }
        public List<Place> getHasBeenTo()
        {
            return hasBeenTo;
        }
        
        @Override
        public String toString()
        {
            
                return "Memory: " + "has been to: "+ getHasBeenTo();     
        }
    
        @Override
        public boolean equals(Object o) { 
       
            if (o == this) { 
                return true; 
            } 
      
            if (!(o instanceof Memory)) { 
                return false; 
            } 
              
            Memory c = (Memory) o; 
    
            if(this.getHasBeenTo() == c.getHasBeenTo())
            {
                return true;
            }else
            {
                return false;
            }
        } 
        @Override
        public int hashCode()
        {
            return hasBeenTo.size();
        }
    
    
    }
    
}
