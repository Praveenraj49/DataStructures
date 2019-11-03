/**
 * Created by Praveen on 2/18/2018.
 */
import java.util.*;
import java.util.stream.Collectors;

public class Graph {

    private int V;
    private LinkedList<Integer> adj[] ;

    Graph (int v)
    {
        V  =v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            adj[i]  =  new LinkedList<>();
        }
    }

    void addEdge(int v , int w)
    {
        adj[v].add(w);
    }

    private void topologicalSortUtil(int v , boolean[] visited , Deque<Integer> stack)
    {
        visited[v] = true;
        ListIterator<Integer> it = adj[v].listIterator();
        Integer i;
        while(it.hasNext())
        {
            i= it.next();
            if(!visited[i])
            {
                topologicalSortUtil(i,visited,stack);
            }

        }
        stack.push(new Integer(v));

    }

    public List<Integer> topologicalSort()
    {
      boolean[] visited  = new boolean[V];
      Deque<Integer> stack = new ArrayDeque<>();
      for(int i=0;i<V;i++)
      {
          if(!visited[i])
          {
              topologicalSortUtil(i,visited,stack);
          }
      }

      return stack.stream().collect(Collectors.toList());

    }

    private boolean isCycleUtil(int v, boolean[] visited , int parent)
    {
        visited[v] = true;
        ListIterator<Integer> it = adj[v].listIterator();
        while(it.hasNext())
        {
            Integer i  = it.next();
            if(!visited[i])
            {
                 if (isCycleUtil(i ,visited,v))
                 {
                     return true;
                 }
            }
            else if (i != parent)
            {
                return true;
            }
        }
        return false;
    }

    public boolean isCycle()
    {
        boolean[] visited  = new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                if(isCycleUtil(i, visited,-1))
                    return true;
            }
        }
        return false;
    }
    int getMaxRegion()
    {
        boolean[] visited  =  new boolean[V];
        int max  = 0;

        for(int i=0;i<V;i++)
        {

            if(!visited[i]) {
                int count =1;
                max = Math.max(max, getMaxRegion(i, visited,count));
            }
        }
        return max*2 -1;
    }

    private int getMaxRegion(int i , boolean[] visited,int count)
    {

        visited[i] = true;
        Iterator<Integer> it = adj[i].iterator();
        while(it.hasNext())
        {
            Integer j  = it.next();
            if(!visited[j])
            {
              count=  getMaxRegion(j, visited,++count);
            }
        }

        return count;

    }

    public List<Integer> getEmployeeId(int employeeId)
    {
        List<Integer> employeeLists = new ArrayList<>();
        boolean[] visited  = new boolean[V];
        getEmployeeId(employeeId , visited ,employeeLists);
        return employeeLists;

    }

    private void getEmployeeId(int employeeId , boolean[] visited , List<Integer> employeeLists)
    {
        visited[employeeId] = true;
        Iterator<Integer> it = adj[employeeId].iterator();
        while(it.hasNext())
        {
            Integer j = it.next();
            if(!visited[j])
            {
                employeeLists.add(j);
                getEmployeeId(j,visited,employeeLists);
            }
        }
    }

    public  static  String getItineary (List<List<String>> boardingPasses)
    {
        Map<String , Integer> airPortMap  = new HashMap<>();

        Map<Integer , String> reverseMap = new HashMap<>();

        int index = 1;

        for(List<String> bp  : boardingPasses )
        {
            if(!airPortMap.containsKey(bp.get(0)))
            {
                airPortMap.put(bp.get(0) ,index);
                index +=1;
            }

            if(!airPortMap.containsKey(bp.get(1)))
            {
                airPortMap.put(bp.get(1) ,index);
                index +=1;
            }
        }


        for(Map.Entry<String , Integer> entry : airPortMap.entrySet())
        {
            reverseMap.put(entry.getValue(), entry.getKey());
        }

        Graph graph = new Graph(airPortMap.size());

        for(List<String> bp :boardingPasses)
        {
            graph.addEdge(airPortMap.get(bp.get(0)) , airPortMap.get(bp.get(1)));
        }

         List<Integer > itinerary  = graph.topologicalSort();

        StringBuilder  builder  = new StringBuilder();

        for(Integer i : itinerary)
        {
            builder.append(reverseMap.get(i));
            builder.append(",");
        }

        return builder.toString();

    }


}
