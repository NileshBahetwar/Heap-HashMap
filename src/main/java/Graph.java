import java.util.*;
/*   7 8
0 1 10
1 3 10
1 2 10
2 3 10
3 4 10
4 5 10
5 6 10
4 6 10
 */

public class Graph {
    public static class EdgewW{
        int src;
        int nbr;
        EdgewW(int src,int nbr){
            this.src=src;
            this.nbr=nbr;
        }
    }
    static class Edge{
        int src;
        int nbr;
        int wt;
        Edge(int src,int nbr,int wt){
            this.src=src;
            this.nbr=nbr;
            this.wt=wt;
        }
    }
    static class Edge2{
        int src;
        int nbr;
        Edge2(int src,int nbr){
            this.src=src;
            this.nbr=nbr;
        }
    }
    static class EdgeD{
        int src;
        int nbr;
        EdgeD(int src,int nbr){
            this.src=src;
            this.nbr=nbr;
        }
    }
    static class Pair2{
        int v;
        String psf;
        Pair2(int v,String psf){
            this.v=v;
            this.psf=psf;
        }
    }
    public static class Pair5 implements Comparable<Pair5>{
        int r;
        String psf1;
        int w;
        Pair5(int r,String psf1,int w){
            this.r=r;
            this.psf1=psf1;
            this.w=w;
        }
        public int compareTo(Pair5 o){
            return this.w-o.w;
        }
    }
    static class Pairp implements Comparable<Pairp>{
        int v;
        int pv;
        int wt;
        Pairp(int v,int pv,int wt){
            this.v=v;
            this.pv=pv;
            this.wt=wt;
        }
        public int compareTo(Pairp o){
            return this.wt-o.wt;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int vertices=sc.nextInt();
        int edges=sc.nextInt();
//        ArrayList<Edge>[] graph=new ArrayList[vertices];
//        for(int i=0;i<vertices;i++){
//            graph[i]=new ArrayList<>();
//        }
//
//        for(int i=0;i<edges;i++){
//            int v1=sc.nextInt();
//            int v2=sc.nextInt();
//            int wt=sc.nextInt();
//
//            graph[v1].add(new Edge(v1,v2,wt));
//            graph[v2].add(new Edge(v2,v1,wt));
//        }
//        int src=sc.nextInt();
//        int dest=sc.nextInt();
//       boolean[] vis=new boolean[vertices];
//
//       /* 1.is path present */
//       boolean hasPath=findPath(graph,src,dest,vis);
//        System.out.println(hasPath);
//        /* 2.All paths  */
//        printAllPaths(graph,src,dest,vis,src+"");
//        /* 3.MultiSolver */
//        int criteria=sc.nextInt();
//        int k=sc.nextInt();
//        multisolver(graph,src,dest,vis,criteria,k,src+"",0);
//        System.out.println("Smallest path : "+spath);
//        System.out.println("Smallest path wt : "+spathwt);
//        System.out.println("Largest path : "+lpath);
//        System.out.println("Largest path wt : "+lpathwt);
//        System.out.println("Ceil path : "+cpath);
//        System.out.println("Ceil path wt : "+cpathwt);
//        System.out.println("floor path : "+fpath);
//        System.out.println("floor path wt : "+fpathwt);
//        System.out.println("kth Largest element : "+pq.peek().wsf);
//
//        /* 4.Get Connected Component */
//        getConnectedComponents(graph,vis);
//
//        /* 5.is graph connected */
//        boolean ans = isGraphConnected(graph,vis);
//
//        /* 6.Number Of isLand */
//        int row=sc.nextInt();
//        int col=sc.nextInt();
//        int[][] arr=new int[row][col];
//        for(int i=0;i<row;i++){
//            for(int j=0;j<col;j++) {
//                arr[i][j] = sc.nextInt();
//            }
//        }
//       boolean[][] visited=new boolean[row][col];
//        int cnt=0;
//        for(int i=0;i<row;i++){
//            for(int j=0;j<col;j++) {
//                if(arr[i][j]==0 && visited[i][j]==false){
//                    drawTreeComponent(arr,i,j,visited);
//                    cnt++;
//                }
//            }
//        }
//        System.out.println(cnt);

        /* 7.perfect friends */
//        int v=sc.nextInt();
//        int e=sc.nextInt();
//        ArrayList<EdgewW>[]graph2=new ArrayList[v];
//        for(int i=0;i<v;i++){
//            graph2[i]=new ArrayList<>();
//        }
//        for(int i=0;i<e;i++){
//            int v1=sc.nextInt();
//            int v2=sc.nextInt();
//
//            graph2[v1].add(new EdgewW(v1,v2));
//            graph2[v2].add(new EdgewW(v2,v1));
//        }
//        boolean[] vis=new boolean[v];
//        ArrayList<ArrayList<Integer>>comps=new ArrayList<>();
//        for(int i=0;i<v;i++){
//            if(vis[i]==false){
//                ArrayList<Integer>comp=new ArrayList<>();
//                dfs(graph2,i,comp,vis);
//                comps.add(comp);
//            }
//        }
//        int pairs=0;
//        for(int i=0;i<comps.size();i++){
//            for(int j=i+1;j<comps.size();j++){
//                pairs+=comps.get(i).size()+comps.get(j).size();
//            }
//        }
//        System.out.println(pairs);

        /* 8.Hamiltonian path and cycle */
//        HashSet<Integer>vis=new HashSet<>();
//        int src=sc.nextInt();
//        hamiltonianPathAndCycle(graph,vis,src,src+"",src);

        /* 9.Breadth first search */
        int v=sc.nextInt();
        int e=sc.nextInt();
        ArrayList<Edge2>[] graph2=new ArrayList[v];
        for(int i=0;i<v;i++){
            graph2[i]=new ArrayList<>();
        }
        for(int i=0;i<e;i++){
            int v1=sc.nextInt();
            int v2=sc.nextInt();

            graph2[v1].add(new Edge2(v1,v2));
            graph2[v2].add(new Edge2(v2,v1));

        }
//        int src=sc.nextInt();
//        boolean[] vis=new boolean[v];
//        bfs(graph2,src,vis,src+"");

        /* 10.is Graph cyclic */

//        for(int i=0;i<v;i++){
//            if(vis[i]==false){
//                boolean isCycle=isCyclic(graph2,i,vis);
//                if(isCycle){
//                    System.out.println(true);
//                    return;
//                }
//            }
//        }
//        System.out.println(false);

        /* 11.is Graph bipartite */
//        int[] visit=new int[v];
//        Arrays.fill(visit,-1);
//        for(int i=0;i<v;i++){
//            if(vis[i]==false){
//                boolean isBipartite=isGraphBipartite(graph2,i,visit);
//                if(isBipartite){
//                    System.out.println(true);
//                    return;
//                }
//            }
//        }
//        System.out.println(false);

        /* 12.spread infection */
//        int t=sc.nextInt();
//        int src=sc.nextInt();
//        int[] visi=new int[v];
//        int cnt=spreadInfection(graph2,t,visi,src);
//        System.out.println(cnt);

        /* 13.Dijkstra Algorithm */

//        int sr=sc.nextInt();
//        boolean[] vis=new boolean[v];
//        dijkstraAlgo(graph,sr,sr+"",0,vis);

        /* 13.Prims Algorithm */
//        boolean[] visi=new boolean[v];
//        primsAlgo(graph,visi);

        /* 14.Topological sort Algorithm */
//        ArrayList<EdgeD>[] graphD=new ArrayList[vertices];
//        for(int i=0;i<edges;i++){
//            graphD[i]=new ArrayList<>();
//        }
//        for(int i=0;i<edges;i++){
//            int v1=sc.nextInt();
//            int v2=sc.nextInt();
//
//            graphD[v1].add(new EdgeD(v1,v2));
//        }
//        boolean[] vis=new boolean[vertices];
//        Stack<Integer>st=new Stack<>();
//        for(int i=0;i<vertices;i++){
//            if(vis[i]==false){
//                topologicalSort(graphD,i,vis,st);
//            }
//        }
//        while(st.size()>0){
//            System.out.println(st.pop());
//        }
        boolean[] vis=new boolean[v];
        int src=sc.nextInt();
        iterativeDFS(graph2,vis,src);


        /************* Graph Level 2 ***************/
    }
    private static void iterativeDFS(ArrayList<Edge2>[] graph2,boolean[] vis,int src){
         Stack<Pair2>st=new Stack<>();
         st.push(new Pair2(src,src+""));

         while(st.size()>0){
             Pair2 rem=st.pop();

             if(vis[rem.v]==true){
                 continue;
             }

             vis[rem.v]=true;
             System.out.println(rem.v+" @ "+rem.psf);
             for(Edge2 e : graph2[rem.v]){
                 if(vis[e.nbr]==false){
                     st.push(new Pair2(e.nbr,rem.psf+e.nbr));
                 }
             }
         }
    }

    private static void topologicalSort(ArrayList<EdgeD>[] graphD,int src,boolean[] vis,Stack<Integer>st){
          vis[src]=true;
          for(EdgeD e : graphD[src]){
              if(vis[e.nbr]==false){
                  topologicalSort(graphD,e.nbr,vis,st);
              }
          }
          st.push(src);
    }
    private static void primsAlgo(ArrayList<Edge>[] graph,boolean[] vis){
        PriorityQueue<Pairp>pq=new PriorityQueue<>();
        pq.add(new Pairp(0,-1,0));

        while(pq.size()>0){
            Pairp rem=pq.remove();

            if(vis[rem.v]==true)  continue;

            vis[rem.v]=true;

            System.out.println("["+rem.v+"-"+rem.pv+" @ "+rem.wt);

            for(Edge e : graph[rem.v]){
                if(vis[e.nbr]==false){
                    pq.add(new Pairp(e.nbr,rem.v,e.wt));
                }
            }
        }
    }

    private static void dijkstraAlgo(ArrayList<Edge>[] graph,int src,String psf,int wt,boolean[] vis){
        PriorityQueue<Pair5>pq=new PriorityQueue<>();
        pq.add(new Pair5(src,src+"",wt));

        while(pq.size()>0){
            Pair5 rem=pq.remove();

            if(vis[rem.r]==true)  continue;

            vis[rem.r]=true;

            System.out.println(rem.r+" via "+rem.psf1+" @ "+rem.w);

            for(Edge e : graph[rem.r]){
                if(vis[e.nbr]==false){
                    pq.add(new Pair5(e.nbr,rem.psf1+e.nbr,rem.w+e.wt));
                }
            }
        }
    }
    static class Pair4{
        int n;
        int time;
        Pair4(int n,int time){
            this.n=n;
            this.time=time;
        }
    }

    private static int spreadInfection(ArrayList<Edge2>[] graph2,int t,int[] vis,int src){
        ArrayDeque<Pair4>q=new ArrayDeque<>();
        q.add(new Pair4(src,1));
        int cnt=0;
        while(q.size()>0){
            Pair4 rem=q.removeFirst();

            if(vis[rem.n]>0){
                continue;
            }
            vis[rem.n]=rem.time;
            if(rem.time>t){
                break;
            }
            cnt++;

            for(Edge2 e : graph2[rem.n]){
                if(vis[e.nbr]==0){
                    q.add(new Pair4(e.nbr,rem.time+1));
                }
            }
        }
        return cnt;
    }

    static class Pair3{
        int a;
        String psf;
        int level;
        Pair3(int a,String psf,int level){
            this.a=a;
            this.psf=psf;
            this.level=level;
        }
    }
    private static boolean isGraphBipartite(ArrayList<Edge2>[]graph2,int v,int[] vis){
        ArrayDeque<Pair3>q=new ArrayDeque<>();
        q.add(new Pair3(v,v+"",0));

        while(q.size()>0){
            Pair3 rem=q.removeFirst();

            if(vis[rem.a]!=-1){
                if(rem.level!=vis[rem.a])
                    return false;
            }
            else{
                vis[rem.a]=rem.level;
            }

            for(Edge2 e : graph2[rem.a]){
                if(vis[e.nbr]==-1){
                    q.add(new Pair3(e.nbr,rem.psf+e.nbr,rem.level+1));
                }
            }
        }
        return true;
    }
    private static boolean isCyclic(ArrayList<Edge2>[] graph2,int v,boolean[] vis){
        ArrayDeque<Pair2> q = new ArrayDeque<>();
        q.add(new Pair2(v,v+""));
        while(q.size()>0){
            Pair2 rem =q.removeFirst();

            if(vis[rem.v]==true)
                return true;

            vis[rem.v]=true;

            for(Edge2 e : graph2[rem.v]){
                if(vis[e.nbr]==false){
                    q.add(new Pair2(e.nbr,rem.psf+e.nbr));
                }
            }
        }
        return false;
    }

    private static void bfs(ArrayList<Edge2>[] graph2,int src,boolean[] vis,String psf){
        ArrayDeque<Pair2>q=new ArrayDeque<>();
        /* 1)remove 2)mark* visited 3)work 4)add* */
        q.add(new Pair2(src,src+""));
        while(q.size()>0){
            Pair2 rem=q.removeFirst();

            if(vis[rem.v]==true)  continue;

            vis[rem.v]=true;

            System.out.println(rem.v+" @ "+rem.psf);

            for(Edge2 e : graph2[rem.v]){
                if(vis[e.nbr]==false){
                    q.add(new Pair2(e.nbr,rem.psf+e.nbr));
                }
            }
        }
    }
    private static void hamiltonianPathAndCycle(ArrayList<Edge>[]graph,HashSet<Integer>vis,int src,String psf,int osrc){
        if(vis.size()==graph.length-1){
            System.out.println(psf);
            boolean isCycle=false;
            for(Edge eb : graph[src]){
                if(eb.nbr==osrc){
                    isCycle=true;
                    break;
                }
            }
            if(isCycle){
                System.out.println("*");
            }
            else{
                System.out.println(".");
            }
            return;
        }
        vis.add(src);
        for(Edge e : graph[src]){
            if(vis.contains(e.nbr)==false){
                hamiltonianPathAndCycle(graph,vis,e.nbr,psf+e.nbr,osrc);
            }
        }
        vis.remove(src);
    }
    private static void dfs(ArrayList<EdgewW>[]graph2,int v,ArrayList<Integer>comp,boolean[] vis){
        vis[v]=true;
        comp.add(v);
        for(EdgewW e : graph2[v]){
            if(vis[e.nbr]==false){
                dfs(graph2,e.nbr,comp,vis);
            }
        }
    }
    private static void drawTreeComponent(int[][] arr,int i,int j,boolean[][] vis){
            if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]==1 || vis[i][j]==true)
                return ;

             vis[i][j]=true;
             drawTreeComponent(arr,i-1,j,vis);
             drawTreeComponent(arr,i,j+1,vis);
             drawTreeComponent(arr,i+1,j,vis);
             drawTreeComponent(arr,i,j-1,vis);
    }
    private static boolean isGraphConnected(ArrayList<Edge>[] graph,boolean[] vis){
        int cnt=0;
        for(int i=0;i<vis.length;i++){
            dfs(graph,vis,i);
            cnt++;
        }
        return cnt==1;
    }
    private static void dfs(ArrayList<Edge>[] graph,boolean[] vis,int v){
          vis[v]=true;
          for(Edge e : graph[v]){
              if(vis[e.nbr]==false){
                  dfs(graph,vis,e.nbr);
              }
          }
    }
    private static void getConnectedComponents(ArrayList<Edge>[] graph,boolean[] vis){
        ArrayList<ArrayList<Integer>> comps=new ArrayList<>();
          for(int i=0;i<vis.length;i++){
              if(vis[i]==false){
                  ArrayList<Integer>comp=new ArrayList<>();
                  drawTreeAndGenComp(graph,vis,comp,i);
                  comps.add(comp);
              }
          }
        System.out.println(comps);
    }
    private static void drawTreeAndGenComp(ArrayList<Edge>[] graph,boolean[] vis,ArrayList<Integer>comp,int v){
        vis[v]=true;
        comp.add(v);
        for( Edge e : graph[v]){
            if(vis[e.nbr]==false){
                drawTreeAndGenComp(graph,vis,comp,e.nbr);
            }
        }
    }
    static String spath;
    static String lpath;
    static int spathwt=Integer.MAX_VALUE;
    static int lpathwt=Integer.MIN_VALUE;

    static String cpath;
    static String fpath;
    static int cpathwt=Integer.MAX_VALUE;
    static int fpathwt=Integer.MIN_VALUE;

    static PriorityQueue<Pair>pq=new PriorityQueue<>();
    static class Pair implements Comparable<Pair>{
        int wsf;
        String psf;

        Pair(int wsf,String psf){
            this.wsf=wsf;
            this.psf=psf;
        }
        public int compareTo(Pair o){
            return this.wsf-o.wsf;
        }
    }
    private static void multisolver(ArrayList<Edge>[] graph,int src,int dest,boolean[] vis,int criteria,int k,String psf,int wsf){
        if(src==dest){
            if(wsf<spathwt){
                spathwt=wsf;
                spath=psf;
            }
            if(wsf>lpathwt){
                lpathwt=wsf;
                lpath=psf;
            }
            if(wsf>criteria && wsf<cpathwt){
                    cpathwt=wsf;
                    cpath=psf;
            }
            if(wsf<criteria && wsf>fpathwt){
                fpathwt=wsf;
                fpath=psf;
            }
            if(pq.size()<k){
                pq.add(new Pair(wsf,psf));
            }
            else{
                if(wsf>pq.peek().wsf)
                    pq.remove();

                pq.add(new Pair(wsf,psf));
            }
            return;
        }
        vis[src]=true;
        for(Edge e : graph[src]){
            if(vis[e.nbr]==false){
                multisolver(graph,e.nbr,dest,vis,criteria,k,psf+e.nbr,wsf+e.wt);
            }
        }
        vis[src]=false;
    }
    private static void printAllPaths(ArrayList<Edge>[] graph,int src,int dest,boolean[] vis,String psf){
        if(src==dest){
            System.out.println(psf);
            return ;
        }
        vis[src]=true;
        for(Edge e : graph[src]){
            if(vis[e.nbr]==false){
                printAllPaths(graph,e.nbr,dest,vis,psf+e.nbr);
            }
        }
        vis[src]=false;
    }
    private static boolean findPath(ArrayList<Edge>[] graph,int src,int dest,boolean[] vis){
        if(src==dest)  return true;
        vis[src]=true;
        for(Edge e : graph[src]){
            if(vis[e.nbr]==false){
                boolean hasPath=findPath(graph,e.nbr,dest,vis);
                if(hasPath)   return true;
            }
        }
        return false;
    }
}
