package MissonaryAndCannibals;

import java.util.*;

public class MCNode {
	MCState state = new MCState();
	ArrayList<String> actions = new ArrayList<String>();
	
	MCNode()
	{
		
	}
	
	MCNode(MCNode other)
	{
		this.state = new MCState(other.state);
		this.actions = new ArrayList<String>(other.actions);
	}
	
	public boolean isGoal()
	{
		if(state.isBoatOnLeft==false && state.numberOfCanibals == 0 && 
                        state.numberOfMissionaries == 0)
			return true;
		return false;
	}
	
        public boolean isDead(){
//            System.out.println(state);
            if((state.numberOfMissionaries!=0&&state.numberOfCanibals > state.numberOfMissionaries) || OtherSideIsDead() ){
                return true;
            }
            else
                return false;
	}
        
        public boolean OtherSideIsDead(){
            if ((3-state.numberOfMissionaries)!=0 &&3-state.numberOfCanibals > 3-state.numberOfMissionaries) {
                return true;
            }
            else
                return false;
        }
        
	public MCNode move2C()
	{
		if(state.isBoatOnLeft)
		{
			// boat on left
			if(state.numberOfCanibals>=2)
			{
				// action is possible
				MCNode temp = new MCNode(this);
				temp.state.numberOfCanibals = temp.state.numberOfCanibals -2; 
				temp.state.isBoatOnLeft=false;
				temp.actions.add("2c_l");
				return temp;
			}
			else
				return null; // action not possible
		}
		else
		{
			// boat on right
			if(3-state.numberOfCanibals>=2)
			{
				// action possible
				MCNode temp= new MCNode(this);
				temp.state.numberOfCanibals = temp.state.numberOfCanibals+2;
				temp.state.isBoatOnLeft=true;
				temp.actions.add("2C_r");
				return temp;
			}
			else 
				return null; 
			
		}
	}
	
	public MCNode move1C()
	{
		if(state.isBoatOnLeft)
		{
			// boat on left
			if(state.numberOfCanibals>=1)
			{
				// action is possible
				MCNode temp = new MCNode(this);
				temp.state.numberOfCanibals= temp.state.numberOfCanibals -1; 
				temp.state.isBoatOnLeft=false;
				temp.actions.add("1c_l");
				return temp;
			}
			else
				return null; // action not possible
		}
		else
		{
			// boat on right
			if(3-state.numberOfCanibals>=1)
			{
				// action possible
				MCNode temp= new MCNode(this);
				temp.state.numberOfCanibals = temp.state.numberOfCanibals + 1;
				temp.state.isBoatOnLeft=true;
				temp.actions.add("1C_r");
				return temp;
			}
			else 
				return null; 
			
		}
	}
	
	public MCNode move2M(){
	    if(state.isBoatOnLeft){
	        //boat on left side
	        if(state.numberOfMissionaries >= 2){
	            MCNode temp = new MCNode(this);
	            temp.state.numberOfMissionaries = temp.state.numberOfMissionaries - 2;
	            temp.state.isBoatOnLeft = false;
	            temp.actions.add("2M_l");
	            return temp;
	        }
	        else{
	            return null; // action not possible
	        }
	    }
	    else{
            //boat on right
            if(3-state.numberOfMissionaries >= 2){
                MCNode temp = new MCNode(this);
                temp.state.numberOfMissionaries = temp.state.numberOfMissionaries + 2;
                temp.state.isBoatOnLeft = true;
                temp.actions.add("2M_r");
                return temp;
            }
            else{
                return null;
            }
	    }
	}
	
	public MCNode move1M(){
	    if(state.isBoatOnLeft){
	        //boat on left side
	        if(state.numberOfMissionaries >= 1){
	            MCNode temp = new MCNode(this);
	            temp.state.numberOfMissionaries = temp.state.numberOfMissionaries - 1;
	            temp.state.isBoatOnLeft = false;
	            temp.actions.add("1M_l");
	            return temp;
	        }
	        else{
	            return null; // action not possible
	        }
	    }
	    else{
            //boat on right
            if(3-state.numberOfMissionaries >= 1){
                MCNode temp = new MCNode(this);
                temp.state.numberOfMissionaries = temp.state.numberOfMissionaries + 1;
                temp.state.isBoatOnLeft = true;
                temp.actions.add("1M_r");
                return temp;
            }
            else{
                return null;
            }
	    }
	}
    public MCNode move1M1C(){
        if(state.isBoatOnLeft){
            if(state.numberOfMissionaries >= 1 && state.numberOfCanibals >= 1  ){
                MCNode temp = new MCNode(this);
                temp.state.numberOfMissionaries = temp.state.numberOfMissionaries - 1;
                temp.state.numberOfCanibals = temp.state.numberOfCanibals - 1;
                temp.state.isBoatOnLeft = false; //found bug
                temp.actions.add("1C_l-1M_l ");
                return temp;
            }
            else{
                return null;
            }
        }
        else{
            if(3-state.numberOfMissionaries >= 1 && 3-state.numberOfCanibals >= 1){
                MCNode temp = new MCNode(this);
                temp.state.numberOfMissionaries = temp.state.numberOfMissionaries + 1;
                temp.state.numberOfCanibals = temp.state.numberOfCanibals + 1;
                temp.state.isBoatOnLeft = true; //found bug
                temp.actions.add("1C_r-1M_r ");
                return temp;
            }
            else{
                return null;
            }
        }
    }
    
	@Override
	public String toString() {
		return "MCNode [state=" + state + ", actions=" + actions + "]";
	}

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MCNode other = (MCNode) obj;
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        return true;
    }

        

        
        
	
}