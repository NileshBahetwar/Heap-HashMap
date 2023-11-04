
import java.util.*;
public class GenTree {
   public static class Pair{
       int level;
       Node node;
       Pair(int level,Node node){
           this.level=level;
           this.node=node;
       }
   }
    private static class Node{
        Node(){

        }
        Node(int val){
            this.data=val;
        }
        int data;
        ArrayList<Node>children=new ArrayList<>();
    }
    private static Node constructNode(int[] arr){
       Node root=null;
       Stack<Node>st=new Stack<>();
       for(int i=0;i<arr.length;i++){
           if(arr[i]==-1)  st.pop();
           else{
               Node t=new Node();
               t.data=arr[i];
               if(st.size()>0){
                   st.peek().children.add(t);
               }
               else{
                   root=t;
               }
               st.push(t);
           }
       }
       return root;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Node node=null;
        int[] arr={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        /* this array for Maximum sum Subtree*/
        //int[] arr={10,20,-50,-1,60,-1,-1,30,-70,-1,80,-110,-1,120,-1,-1,90,-1,-1,40,-100,-1,-1,-1};
        Node root=constructNode(arr);
        Stack<Node>st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==-1){
                st.pop();
            }
            else {
                Node t = new Node();
                t.data = arr[i];
                if(st.size()>0)
                     st.peek().children.add(t);
                else node=t;

                st.push(t);
            }
        }

        // System.out.println(size(node));

        // System.out.println(maxInTree(node));

        // System.out.println(minInTree(node));

        // System.out.println(height(node));

        // levelOrder(node);

       // levelOrderLineWise(node);

       // levelOrderLineWiseZZ(node);

       // levelOrderLineWise2(node);

       // levelOrderLineWise3(node);

       // levelOrderLineWise4(node);

        //mirrorOfTree(node);

       // removeLeaves(node);

       // linearize(node);

       // linearize2(node);

        //System.out.println(findEle(node,1100));

        // ArrayList<Integer> ans= nodeToRootPath(node,11);
        //  if(ans.size()==0) System.out.println("no path exist");
        //   for(Integer val : ans){
        //  System.out.print(val+" ");
        // }

       // System.out.println(LCA(node,120,70));

//         sz=0;
//         min=Integer.MAX_VALUE;
//         max=Integer.MIN_VALUE;
//         multiSolver(root,0);
//        System.out.println("size:"+sz+", ht: "+ht+", min: "+min+", max:"+max);
        //display(node);

        /* predecessor and successor */
//        int data=sc.nextInt();
//         predecessor=null;
//         successor=null;
//         state=0;
//        predecessorandsuccessor(root,data);
//        if(predecessor!=null){
//            System.out.println("pre : "+predecessor.data);
//        }else{
//            System.out.println("null");
//        }
//
//        if(successor!=null){
//            System.out.println("pre : "+successor.data);
//        }else{
//            System.out.println("null");
//        }

        /* Ceil & Floor */
//        int data=sc.nextInt();
//        ceil=Integer.MAX_VALUE;
//        floor=Integer.MIN_VALUE;
//        ceilAndFloor(root,data);

        /* Kth Largest element */
//        int k=sc.nextInt();
//        System.out.println(kthLargestEle(root,k));
//        System.out.println(kthSmallestEle(root,k));

        /* Maximum sum Subtree*/

//        maxSumSubtree(root);
//        System.out.println(maxSumFromsubtree);

        /* Diameter of tree */
//        diameterOfTree(root);
//        System.out.println(dia);

        /* Iterator Pre and Post Order */
//        preAndPostOrder(root);

        /* serialize and deserialize */
        String ans = serialize(root);
        Node res = deserialize(ans);
    }
    private static Node deserialize(String str){
       if(str.length()==0)  return null;

       String[] arr = str.split(" ");
       LinkedList<Node>st = new LinkedList<>();
       for(int i=0;i<arr.length-1;i++){
           String s=arr[i];
           if(s.equals("-1")){
               Node node = st.removeFirst();
               st.getFirst().children.add(node);
           }
           else{
               Node node = new Node(Integer.parseInt(s));
               st.addFirst(node);
           }
       }
       return st.removeFirst();
    }
    private static String serialize(Node root){
       if(root==null)  return "";
       StringBuilder sb = new StringBuilder();
       serialize_(root,sb);
       return sb.toString();
    }
    private static void serialize_(Node root,StringBuilder sb){
         sb.append(root.data+" ");
         for(Node child : root.children){
             serialize_(child,sb);
         }
         sb.append("-1 ");
    }
    public static class Duo{
         Node node;
         int state;
         Duo(Node node,int state){
          this.node=node;
          this.state=state;
        }
    }
    private static void preAndPostOrder(Node node){
       Stack<Duo>st=new Stack<>();
       String pre="";
       String post="";
       st.push(new Duo(node,-1));
       while(st.size()>0){
           Duo top=st.peek();
           if(top.state==-1){
               pre+=top.node.data+" ";
               top.state++;
           }
           else if(top.state==top.node.children.size()){
               post+=top.node.data;
               top.state++;
           }
           else{
                 Duo cp=new Duo(top.node.children.get(top.state),-1);
                 st.push(cp);
                 top.state++;
           }
       }
        System.out.println(pre);
        System.out.println(post);
    }
    static int dia=Integer.MIN_VALUE;
    private static int diameterOfTree(Node node){
        int highest_depth=-1;
        int sec_highest_depth=-1;

        for(Node child : node.children){
            int curr_height=diameterOfTree(child);
            if(curr_height>highest_depth){
                sec_highest_depth=highest_depth;
                highest_depth=curr_height;
            }
            else if(curr_height>sec_highest_depth){
                sec_highest_depth=curr_height;
            }
        }
        if(highest_depth+sec_highest_depth+2>dia){
            dia=highest_depth+sec_highest_depth+2;
        }
        highest_depth+=1;
        return highest_depth;
    }
    static int maxSumFromsubtree=Integer.MIN_VALUE;
    private static int maxSumSubtree(Node node){
       int sum=0;
       for(Node child : node.children){
           int cs=maxSumSubtree(child);
           sum+=cs;
       }
       sum+=node.data;
       if(sum>maxSumFromsubtree){
           maxSumFromsubtree=sum;
       }
       return sum;
    }
    private static  int kthSmallestEle(Node node,int k){
       ceil=Integer.MAX_VALUE;
       int factor=Integer.MIN_VALUE;
       for(int i=0;i<k;i++){
           ceilAndFloor(node,factor);
           factor=ceil;
           ceil=Integer.MAX_VALUE;
       }
       return factor;
    }
    private static int kthLargestEle(Node node,int k){
         floor=Integer.MIN_VALUE;
         int factor=Integer.MAX_VALUE;
         for(int i=0;i<k;i++){
             ceilAndFloor(node,factor);
             factor=floor;
             floor=Integer.MIN_VALUE;
         }
         return factor;
    }
    static int ceil;
    static int floor;
    private static void ceilAndFloor(Node node,int data){

        if(node.data>data){
            if(node.data<ceil){
                ceil=node.data;
            }
        }
        if(node.data<data){
            if(node.data>floor){
                floor=node.data;
            }
        }
        for(Node child : node.children){
            ceilAndFloor(child,data);
        }
    }
    private static void predecessorandsuccessor(Node root,int data){
        if(state==0){
            if(root.data==data){
                state++;
            }
            else{
                predecessor=root;
            }
        }
        else if(state==1){
            successor=root;
        }

        for(Node child : root.children){
            predecessorandsuccessor(child,data);
        }
    }
    static Node predecessor;
    static Node successor;
    static int state;
    static int sz;
    static int ht;
    static int min;
    static int max;
    private static void multiSolver(Node root,int depth){
       sz++;
       ht=Math.max(ht,depth);
       min=Math.min(min,root.data);
       max=Math.max(max,root.data);

       for(Node child : root.children){
           multiSolver(child,depth+1);
       }
    }
    // 18
    private static int LCA(Node node,int d1,int d2){
         ArrayList<Integer>path1=nodeToRootPath(node,d1);
         ArrayList<Integer>path2=nodeToRootPath(node,d2);
         int i=path1.size()-1;
         int j=path2.size()-1;
         while((i>=0 && j>=0) && path1.get(i)==path2.get(j)){
            i--;
            j--;
        }
         i++;
         j++;
         return path1.get(i);
    }
    // 17
    private static ArrayList<Integer>nodeToRootPath(Node node,int data){
       if(node.data==data){
           ArrayList<Integer>ans=new ArrayList<>();
           ans.add(node.data);
           return ans;
       }
       for(Node child : node.children){
           ArrayList<Integer>ans=nodeToRootPath(child,data);
           if(ans.size()>0){
               ans.add(node.data);
               return ans;
           }
       }
       return new ArrayList<>();
    }
    // 16
    private static boolean findEle(Node node,int data){
       if(node.data==data){
           return true;
       }
       for(Node child : node.children){
           boolean cn=findEle(child,data);
           if(cn)  return true;
       }
       return false;
    }
    // 15
    private static Node linearize2(Node node){
        if(node.children.size()==0){
            return node;
        }
       Node lkt=linearize2(node.children.get(node.children.size()-1));
       while(node.children.size()>1){
           Node last=node.children.remove(node.children.size()-1);
           Node sl=node.children.get(node.children.size()-1);
           Node slkt=linearize2(sl);
           slkt.children.add(last);
       }
       return lkt;
    }
    // 14  >> o(n^2)
    private static void linearize(Node node){

       for(Node child : node.children){
           linearize(child);
       }

       while(node.children.size()>1){
           Node ln=node.children.remove(node.children.size()-1);
           Node slc=node.children.get(node.children.size()-1);
           Node slt=tailNode(slc);
           slt.children.add(ln);
       }
    }
    private static Node tailNode(Node node){
       while(node.children.size()==1){
           node=node.children.get(0);
       }
       return node;

    }
    // 13
    private static void removeLeaves(Node node){
       for(int i=node.children.size()-1;i>=0;i--){
          Node child=node.children.get(i);
          if(child.children.size()==0){
              node.children.remove(child);
          }
       }
       for(Node child : node.children){
           removeLeaves(child);
       }
    }
    // 12
    private static void mirrorOfTree(Node node){
           for(Node child : node.children){
               mirrorOfTree(child);
           }
           Collections.reverse(node.children);
    }
    // 11
    private static void levelOrderLineWise4(Node node){
        Queue<Pair>q=new ArrayDeque<>();
        q.add(new Pair(1,node));
        int level=1;
        while(q.size()>0){
            Pair p =q.remove();
            Node n =p.node;
           // int level=p.level;
            if(p.level>level){
                level=p.level;
                System.out.println();
            }
            System.out.print(n.data+" ");
            for(Node child : n.children){
                Pair cp=new Pair(level+1,child);
                q.add(cp);
            }
        }
    }
    // 10
    private static void levelOrderLineWise3(Node node){
        Queue<Node>q=new ArrayDeque<>();
        q.add(node);
        while(q.size()>0){
            int size=q.size();
            for(int i=0;i<size;i++){
                node=q.remove();
                System.out.print(node.data+" ");

                for(Node child : node.children){
                    q.add(child);
                }
            }
            System.out.println();
        }
    }
    // 9
    private static void levelOrderLineWise2(Node node){
        Queue<Node>q=new ArrayDeque<>();
        q.add(node);
        q.add(new Node(-1));
        while(q.size()>0){
            node=q.remove();
            if(node.data!=-1){
                System.out.print(node.data+" ");
                for(Node child : node.children){
                    q.add(child);
                }
            }
            else{
                if(q.size()>0){
                    q.add(new Node(-1));
                    System.out.println();
                }
            }
        }
    }
    // 8
    private static void levelOrderLineWiseZZ(Node node){
        int lvl=0;
        Stack<Node>ms=new Stack<>();
        ms.push(node);
        Stack<Node>cs=new Stack<>();

        while(ms.size()>0){
            node=ms.pop();
            System.out.print(node.data+" ");
            if(lvl%2==0){
               for(int i=0;i<node.children.size();i++){
                   cs.push(node.children.get(i));
               }
            }
            else{
                 for(int i=node.children.size()-1;i>=0;i--){
                     cs.push(node.children.get(i));
                 }
            }
            if(ms.size()==0){
                ms=cs;
                cs=new Stack<>();
                lvl++;
                System.out.println();
            }
        }
    }
    // 7
    private static void  levelOrderLineWise(Node node){
        Queue<Node>mq=new ArrayDeque<>();
        mq.add(node);
        Queue<Node>cq=new ArrayDeque<>();

        while(mq.size()>0){
            node=mq.remove();
            System.out.print(node.data+" ");

            for(Node child : node.children){
                cq.add(child);
            }

            if(mq.size()==0){
                mq=cq;
                cq=new ArrayDeque<>();
                System.out.println();
            }
        }
    }
    // 6
    private static void levelOrder(Node node){
        Queue<Node>q=new ArrayDeque<>();
        q.add(node);
        while(q.size()>0){
            node=q.remove();
            System.out.print(node.data+" ");
            for(Node child : node.children){
                q.add(child);
            }
        }
    }
    // 5
    private static int height(Node node){
        // int ht=0; ... in terms of nodes
        int ht=-1; //... in terms of edges
        for(Node child : node.children){
            int ch=height(child);
            ht=Math.max(ht,ch);
        }
        return ht+1;
    }
    // 4
    private static int minInTree(Node node){
        int min=Integer.MAX_VALUE;
        for(Node child : node.children){
            int cm=minInTree(child);
            min=Math.min(min,cm);
        }
        min=Math.min(node.data,min);
        return min;
    }
   // 3
    private static int maxInTree(Node node){
        int max=Integer.MIN_VALUE;
        for(Node child : node.children){
            int cm=minInTree(child);
            max=Math.min(max,cm);
        }
        max=Math.min(node.data,max);
        return max;
    }
    // 2
   public static int size(Node node){
        int sz=0;
        for(Node child : node.children){
            int cs=size(child);
            sz+=cs;
        }
        return sz+1;
   }
   //  1
    private static void display(Node node){
        String s=node.data+"-> ";
        for(Node child : node.children){
            s+=child.data+",";
        }
        s+=".";
        System.out.println(s);

        for(Node child : node.children){
            display(child);
        }
    }
}
