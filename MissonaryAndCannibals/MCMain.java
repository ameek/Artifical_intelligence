package MissonaryAndCannibals;


import java.util.ArrayList;


public class MCMain {
	
	public static ArrayList<String> bfs(MCNode start)
	{
		ArrayList<MCNode> frontier = new ArrayList<MCNode>();
                ArrayList<MCNode> visitedList = new ArrayList<MCNode>();
		
                frontier.add(start);
		          System.out.println("Frontier added");
                while(!frontier.isEmpty())
		{
			// this is the BFS main loop
			MCNode top = frontier.remove(0);
//                        System.out.println("removing node from frondtier");
//                        System.out.println("actions of top"+ top.actions);
                        if(top.isGoal()){
			    return top.actions;
			}
                        
			if(!top.isDead()){
//                            System.out.println("is dead chacked");
                            visitedList.add(top);
                            MCNode child2c = top.move2C();
                            if(child2c !=null && !visitedList.contains(child2c)){
//                                System.out.println("move 2c done");
                                frontier.add(child2c);
                            }
                            MCNode child1c = top.move1C();
                            
//                            System.out.println(chi);
                            if(child1c !=null && !visitedList.contains(child1c)){
//                                System.out.println("move 1c done");
                                frontier.add(child1c);
                            }
                            MCNode child2m = top.move2M();
                            if(child2m !=null && !visitedList.contains(child2m)){
//                                System.out.println("move 2m done");
                                frontier.add(child2m);
                            }
                            MCNode child1m = top.move1M();
                            if(child1m !=null && !visitedList.contains(child1m)){
//                                System.out.println("move 1m done");
                                frontier.add(child1m);
                            }
                            MCNode child1m1c = top.move1M1C();
                            if(child1m1c !=null && !visitedList.contains(child1m1c)){
//                                System.out.println("move 1m1c done");
                                frontier.add(child1m1c);
                            }
                                                            
			}
			
		}
		return null;
	}
	
	public static void main(String ...args)
	{
		MCNode start = new MCNode();
		start.state.numberOfCanibals=3;
		start.state.numberOfMissionaries=3;
		start.state.isBoatOnLeft=true;
		
		MCNode goal = new MCNode();
		goal.state.numberOfCanibals=3;
		goal.state.numberOfMissionaries=2;
		goal.state.isBoatOnLeft=false;
		
		System.out.println(start);
                System.out.println(goal);
		
		System.out.println(start.isGoal());
		System.out.println(goal.isGoal());
		System.out.println(" checking dead state left side "+ goal.isDead());
		System.out.println(" cheaking dead state right side "+ start.isDead());
                System.out.println("____________________ running bfs for it________________-");
                System.out.println(MCMain.bfs(start));
//		MCNode childone = start.move2C();
//		System.out.println(start);
//		System.out.println(childone);
//		
//		MCNode childTwo = childone.move2C();
//		System.out.println(childTwo);
//        
//                childTwo = childTwo.move2M();
//		System.out.println(childTwo);
		
	}
}