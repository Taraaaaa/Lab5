
public class Cane
{
    // instance variables - replace the example below with your own
    private Human owner;
    private double cost;
    
    public Cane() {}

    public Cane setOwner(Human owner) throws NullPointerException
    {
        if(owner == null)
        {
            throw new NullPointerException("The owner doesn't exist!");
        }
        else
        {
            this.owner = owner;
            return this;
        }
    }
    public Cane setCost(double cost) throws Exception{
        if(cost < 0){
            throw new Exception("A cane object can't have a negative cost: " + cost);
        }
        else{
            this.cost = cost;
            return this;
        }
    }
    
    public Human getOwner(){
        return this.owner;
    }
    public double getCost(){
        return this.cost;
    }
    
   @Override
    public String toString()
    {
        if (this.owner != null)
            return "Cane: "+"Owner: "+ this.getOwner() +",Cost: "+this.getCost();
        else
            return "Cane: "+"Owner: Not specified " +",Cost: "+this.getCost();
    }
    
    @Override
    public boolean equals(Object o) { 
   
        if (o == this) { 
            return true; 
        } 
  
        if (!(o instanceof Cane)) { 
            return false; 
        } 
          
        Cane c = (Cane) o; 

        if((this.cost == c.getCost()) && (this.owner == c.getOwner()))
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
        return (int)(cost + owner.getName().length()); 
    }
}