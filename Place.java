import java.util.*;
import java.lang.*;
public class Place
{
    
    private List <Object> objects = new ArrayList<Object>();
    private List <Human> people = new ArrayList<Human>();
    private Location location;
    public Place(double x, double y)
    {
        this.location = new Location(x,y);
    }
    
    public void setPeople(List <Human> people) 
    {
        this.people = people;
    }
    public void setObjects(List <Object> objects)
    {
        this.objects = objects;
    }
    public void addPerson(Human person) 
    {
        this.people.add(person);
    }
    public void addObject(Object object) 
    {
        this.objects.add(object);
    }
    public List<Human> getPeople()
    {
        return this.people;
    }
    public List<Object> getObjects()
    {
        return this.objects;
    }
    public Location getLocation()
    {
        return this.location;
    }
    
    @Override
    public String toString()
    {
        return this.getClass() + " contains " + getPeople() + " and "+ getObjects() ;
    }
    @Override
    public boolean equals(Object o) { 
   
        if (o == this) { 
            return true; 
        } 
  
        if (!(o instanceof Place)) { 
            return false; 
        } 
          
        Place c = (Place) o; 

        if((this.people == c.getPeople()) && (this.objects == c.getObjects()))
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
        return people.size() + objects.size();
    }
}
