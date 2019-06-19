import java.util.*;
import java.awt.*;
public class Place
{
    
    private ArrayList <Object> objects = new ArrayList<Object>();
    private ArrayList <Human> people = new ArrayList<Human>();
    private Point location;
    public Place(int x, int y)
    {
        this.location = new Point(x,y);
    }
    
    public void setPeople(ArrayList <Human> people) 
    {
        this.people = people;
    }
    public void setObjects(ArrayList <Object> objects)
    {
        this.objects = objects;
    }
    public void add(Human person) 
    {
        this.people.add(person);
    }
    public void add(Object object) 
    {
        this.objects.add(object);
    }
    public void remove(Human person) 
    {
        this.people.remove(person);
    }
    public void remove(Object object) 
    {
        this.objects.remove(object);
    }
    
    public ArrayList<Human> getPeople()
    {
        return this.people;
    }
    public ArrayList<Object> getObjects()
    {
        return this.objects;
    }
    public Point getLocation()
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