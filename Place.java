import java.util.*;
public class Place
{
    
    private List <Object> objects = new ArrayList<Object>();
    private List <Human> people = new ArrayList<Human>();
    
    public Place(){}
    
    public void setPeople(List <Human> people) throws NullPointerException
    {
        if(people == null)
        {
            throw new NullPointerException("The people list doesn't exist!");
        }
        else
        {
            this.people = people;
        }
    }
    public void setObjects(List <Object> objects) throws NullPointerException
    {
        if(objects == null)
        {
            throw new NullPointerException("The objects list doesn't exist!");
        }else{
            this.objects = objects;
        }
    }
    public void addPerson(Human person) throws NullPointerException
    {
        if(person == null)
        {
            throw new NullPointerException("The person doesn't exist!");
        }
            this.people.add(person);
    }
    public void addObject(Object object) throws NullPointerException
    {
        if (object == null)
        {
            throw new NullPointerException("The object doesn't exist!");
        }
        else{
            this.objects.add(object);
        }
    }
    public List<Human> getPeople()
    {
        return people;
    }
    public List<Object> getObjects()
    {
        return objects;
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
