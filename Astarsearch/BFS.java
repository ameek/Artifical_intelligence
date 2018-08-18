package Astarsearch;

import java.util.*;
public class BFS {

	public static ArrayList<Integer> bfs(Node start)
	{
//		Comparator<Node> comparator = new Node();
                PriorityQueue<Node> frontier = new PriorityQueue<Node>(new Node()); 
                //ArrayList<Node> frontier= new ArrayList<Node>();
		ArrayList<Node> visitedList= new ArrayList<Node>();
		
//		frontier.add(start);
                frontier.add(start);
		while(!frontier.isEmpty()){
//                    int intMin= Integer.MAX_VALUE;
//                    int lowestIndex = 0;
//                    for(int i=0 ; i< frontier.size();i++ ){
//                        
//                        Node temp = frontier.get(i);
//                        int tempCost = temp.getTotalCost();
//                        
//                        if(tempCost <= intMin){
//                            intMin = tempCost;
//                            lowestIndex = i;
//                            
//                        }
//                        
//                    }
//                    System.out.println("min cost " + lowestIndex);
//                    int minIndex = frontier.indexOf(Collection.min(frontier));
                  
                        //1. remove an item from frontier, top
//			Node top = frontier.remove(lowestIndex);
//                        System.out.println(" total cost " +top.totalCost());
                        
                        Node top = frontier.poll();

			// 2. if top is goal then return top.actions
			if(top.isGoal())
				return top.actions;
			//3. add top to visited list
			if(!visitedList.contains(top))
			{
				visitedList.add(top);
				Node up=top.performUp();
				if(up!=null) 
					frontier.add(up);
				Node down=top.performDown();
				if(down!=null) 
					frontier.add(down);
				Node left = top.performLeft();
				if(left != null) 
					frontier.add(left);
				Node right = top.performRight();
				if(right !=  null )
					frontier.add(right);
			}
			// 4. generate 4 children
			// 5. add each children to frontier if 
			// they are not null and 
			//not in the visited list
			
		}
		
		return null;
	}
	
	public static void main(String ...args)
	{
		Node start = new Node();
		start.state[0][0]=6;
		start.state[0][1]=3;
		start.state[0][2]=2;
		start.state[1][0]=7;
		start.state[1][1]=1;
		start.state[1][2]=4;
		start.state[2][0]=8;
		start.state[2][1]=0;
		start.state[2][2]=5;


                
		System.out.println(start.isGoal());
		System.out.println(start);
		System.out.println(start.performUp());
		System.out.println(start.performDown());
		System.out.println(start.performLeft());
		System.out.println(start.performRight());
		
		System.out.println(bfs(start));
                
	

	}
}
