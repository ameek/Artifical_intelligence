package MissonaryAndCannibals;


public class MCState {
	int numberOfMissionaries=-1;
	int numberOfCanibals=-1;
	boolean isBoatOnLeft=false;
	
	public MCState() {
	}

	public MCState(int numberOfMissionaries, int numberOfCanibals, boolean isBoatOnLeft) {
		this.numberOfMissionaries = numberOfMissionaries;
		this.numberOfCanibals = numberOfCanibals;
		this.isBoatOnLeft = isBoatOnLeft;
	}
	
	public MCState(MCState other)
	{
		this.numberOfCanibals =other.numberOfCanibals;
		this.numberOfMissionaries = other.numberOfMissionaries;
		this.isBoatOnLeft = other.isBoatOnLeft;
	}

	@Override
	public String toString() {
		return "MCState [numberOfMissionaries=" + numberOfMissionaries + ", numberOfCanibals=" + numberOfCanibals
				+ ", isBoatOnLeft=" + isBoatOnLeft + "]";
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
        final MCState other = (MCState) obj;
        if (this.numberOfMissionaries != other.numberOfMissionaries) {
            return false;
        }
        if (this.numberOfCanibals != other.numberOfCanibals) {
            return false;
        }
        if (this.isBoatOnLeft != other.isBoatOnLeft) {
            return false;
        }
        return true;
    }
	

}