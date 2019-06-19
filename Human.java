import java.util.*;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
public class Human implements livable
{
    private String name;
    private boolean sleepingState;
    private List <Object> belongings = new ArrayList<Object>();
    private Place place;
    Memory memory = new Memory();
    
    public Human(String name, Place place){
        this.name = name;
        this.place = place;
        place.add(this);
        System.out.println(this.getName()+ " is in "+place.getClass().getName());
    }
    public String getName()
    {
        return this.name;
    }
    public Place getPlace()
    {
        return place;
    }
    public String getState()
    {
        if (sleepingState = true)
            return "Awake";
        else
            return "Asleep";   
    }
    public List getBelongings()
    {
        return this.belongings;
    }
    
    public void move(Place place)
    {
        this.place.remove(this);
        this.place = place;
        place.add(this);
        System.out.println(this.getName()+ " moved to "+place.getClass().getName());
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
            place.add(object);
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
    public String searchFor(Object object)
    {
        System.out.println(this.getName() + " is searching for "+ object.getClass().getName());
        for(int i = 0;i < memory.getPastLocations().size(); i++)
        {
            Place p = memory.getPastLocations().get(i).getPlace();
            System.out.println(this.getName()+ " is thinking if he has put " + object.getClass().getName()+ " in "+ p.getClass().getName());
            if (p.getObjects().contains(object))
                return this.getName()+ " found " + object.getClass().getName()+ " in " + p.getClass().getName();
        }
        return this.getName() + " did not find " + object.getClass().getName()+"!";   
    }
    
    public void hasBeenTo(Place place, LocalDateTime dateTime) 
    {
        memory.addPastLocation(place, dateTime);
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
        (this.belongings == c.getBelongings()) && (this.memory == c.getMemory())&&(this.place == c.getPlace()))
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
        return this.name.length() + belongings.size() + memory.hashCode() + getPlace().getClass().getName().length();
    } 
    class Memory
    {
        Vector <PastLocation> PL = new Vector();
        
        public Memory addPastLocation(PastLocation pl)
        {
            this.PL.add(pl);
            return this;
        }
        public Memory addPastLocation(Place place, LocalDateTime dateTime)
        {
            this.PL.add(new PastLocation(place, dateTime));
            return this;
        }
        public Vector<PastLocation> getPastLocations()
        {
            return this.PL;
        }
        
        class PastLocation
        {
            Place place;
            LocalDateTime dateTime;
            PastLocation(Place place, LocalDateTime dateTime)
            {
                this.place = place;
                this.dateTime = dateTime; 
            }
            public Place getPlace()
            {
                return this.place;
            }
            public LocalDateTime getDateTime()
            {
                return this.dateTime;
            }
        }
    
    }
}