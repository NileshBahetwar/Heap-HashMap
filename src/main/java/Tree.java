import java.util.*;
public class Tree {
    // Data member
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data,Node left,Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
        Node(int data){
            this.data=data;
        }
    }
    public static class Pair{
        int state;
        Node node;
        Pair(Node node,int state){
            this.node=node;
            this.state=state;
        }
    }
    public static void main(String[] args) {
        Integer[] arr={50,20,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
        Stack<Pair>st=new Stack<>();
        Node root=new Node(arr[0],null,null);
        Pair rtp=new Pair(root,1);
        st.push(rtp);
        int idx=0;
        while(st.size()>0){
            Pair top=st.peek();
            if(top.state==1){
                idx++;
                if(idx<arr.length && arr[idx]!=null){
                    top.node.left=new Node(arr[idx],null,null);
                    Pair lp=new Pair(top.node.left,1);
                    st.push(lp);
                }
                top.state++;
            }
            else if(top.state==2){
                idx++;
                if(idx<arr.length && arr[idx]!=null){
                    top.node.right=new Node(arr[idx],null,null);
                    Pair rp=new Pair(top.node.right,1);
                    st.push(rp);
                }
                top.state++;
            }
            else{
                st.pop();
            }
        }
        /************ Tree Level1 ***************/

       // display(root);
      /* 1.MultiSolver */
//        System.out.println(sizeOfTree(root));
//        System.out.println(sumOfTree(root));
//        System.out.println(maxOfTree(root));
//        System.out.println(heightOfTree(root));
//
//        /* 2.AllTraversal Iteratively */
//        inPrePostOrderTraversal(root);
//
//        /* 3.Node to Root Path */
//        Scanner sc=new Scanner(System.in);
//        int data= sc.nextInt();
//        path=new ArrayList<Integer>();
//        nodeToRootPath(root,data);
//        System.out.println(path);
//
//        /* 4.print K levels down */
//        int k=sc.nextInt();
//        printKlevelsDown(root,k);
//        printKlevelsDown2(root,k);

        /* 5.K nodes away from given data */
//        Scanner sc=new Scanner(System.in);
//        int k=sc.nextInt();
//        int data=sc.nextInt();
//         printKNodesAway(root,k,data);

        /* 6.pathToRoot Form leaf with in range */
//        Scanner sc=new Scanner(System.in);
//        int lo=sc.nextInt();
//        int hi=sc.nextInt();
//        pathRootFromLeaf(root,"",0,lo,hi);

        /* 7.left & right Cloned Tree */
//        Node ans=leftClonedTree(root);
//        Node ans1=rightClonedTree(root);
//        display(ans);
//
//        System.out.println();

        /* 8.left Cloned to Normal */
//        Node ans2=leftClonedToNormalTree(ans);
//        display(ans2);

        /* 9.remove leaves Node */
//        Node res=removeLeaves(root);
//        display(res);

        /* 10.Diameter of binary tree */
//      a.int ans=diameterOfBT(root);  // o(n^2)
//        System.out.println(ans);

//      b.DiaPair dp=Diameter(root);
//        System.out.println(dp.dia+" "+dp.ht);

        /* 11.Tilt Of Binary Tree*/
//        tilt=0;
//        int ans=tiltOfBinaryTree(root);
//        System.out.println(tilt);

        /* 12.check tree BST or Not */
//        BSTPair ans=isTreeBST(root);
//        System.out.println(ans.isBst);

        /* 13.Tree is balanced or not */
        //a. by static variable
//        isBalanced(root);
//        System.out.println(isBST);
        //b. by pair class
//        IsBalPair p=isBal(root);
//        System.out.println(p.isBalance);

        /* 14.Largest BST subtree */
//        PropertiesOfBST p=largestBstSubtree(root);
//        System.out.println(p.node.data+" @ "+ p.size);

        /************ Tree Level2 ***************/

         /*  1.InOrder Morris Traversal  */
//       ArrayList<Integer> ans =inorderMorrisTraversal(root);
//        System.out.println(ans);
         /* 2.PreOrder Morris Traversal */
//        ArrayList<Integer>ans=preOrderMorrisTraversal(root);
//        System.out.println(ans);
        /* 3.serialize & deserialize of BT */
//           String ans=serialize(root);
//           System.out.println(ans);
//           Node dAns=deserialize(ans);
//           display(dAns);
//        /* 4.width of BT */
//        int len=width(root);
//        /* 5.vertical order traversal of BT */
//        // method 1
//        List<List<Integer>> res = verticalOrderTraversal(root);
        // method 2
//        List<List<Integer>> res2 = verticalOrderTraversal2(root);
        /* 6.Bottom view of BT */
//        ArrayList<Integer>ans=bottomViewOfBT(root);\
        /* 6.Top view of BT */
//        ArrayList<Integer>ans=TopViewOfBT(root);
        /* 7.Diagonal order of BT */
//        ArrayList<ArrayList<Integer>> res = diagonalOrderTraversalClock(root);
//        ArrayList<ArrayList<Integer>> res2 = diagonalOrderTraversalAntiClock(root);

        /* 8.vertical orderSum */
//        ArrayList<Integer>ans=verticalOrderSumBFS(root);
//        ArrayList<Integer>ans1=verticalOrderSumDFS(root);
    }
    private static ArrayList<Integer>verticalOrderSumDFS(Node root){
        ArrayList<Integer>ans=new ArrayList<>();
        if(root==null)  return ans;

        int[] minMax=new int[2];
        width_(root,0,minMax);
        int len=minMax[1]-minMax[0]+1;
        for(int i=0;i<len;i++)   ans.add(0);
        dfs(root,Math.abs(minMax[0]),ans);
        return ans;
    }
    private static void dfs(Node root,int hl,ArrayList<Integer>ans){
        if(root==null)  return;

        ans.set(hl,ans.get(hl)+root.data);
        dfs(root.left,hl-1,ans);
        dfs(root.right,hl+1,ans);
    }
    private static ArrayList<Integer>verticalOrderSumBFS(Node root){
        ArrayList<Integer>ans=new ArrayList<>();
        if(root==null)  return ans;

        int[] minMax=new int[2];
        width_(root,0,minMax);
        int len=minMax[1]-minMax[0]+1;
        for(int i=0;i<len;i++)
            ans.add(0);

        LinkedList<vPair>q=new LinkedList<>();
        q.addLast(new vPair(root,Math.abs(minMax[0])));

        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                vPair rem = q.removeFirst();
                Node node=rem.node;
                int hl=rem.hl;
                ans.set(hl,ans.get(hl)+node.data);

                if(node.left!=null)  q.add(new vPair(node.left,hl-1));
                if(node.right!=null)  q.add(new vPair(node.right,hl-1));
            }
        }
        return ans;
    }
    private static ArrayList<ArrayList<Integer>>diagonalOrderTraversalAntiClock(Node root){
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        if(root==null)  return ans;

        LinkedList<Node>q=new LinkedList<>();
        q.add(root);
        while(q.size()>0){  // for all diagonal
            int size=q.size();
            ArrayList<Integer>myans=new ArrayList<>();
            while(size-->0){  // to traverse all component of curr diagonal level
                Node rem=q.removeFirst();
                while(rem!=null){   // curr component of traverse
                    myans.add(rem.data);
                    if(rem.right!=null)  q.addLast(rem.right);

                    rem=rem.left;
                }
            }
            ans.add(myans);
        }
        return ans;
    }
    private static ArrayList<ArrayList<Integer>>diagonalOrderTraversalClock(Node root){
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        if(root==null)  return ans;

        LinkedList<Node>q=new LinkedList<>();
        q.add(root);
        while(q.size()>0){  // for all diagonal
            int size=q.size();
            ArrayList<Integer>myans=new ArrayList<>();
            while(size-->0){  // to traverse all component of curr diagonal level
                Node rem=q.removeFirst();
                while(rem!=null){   // curr component of traverse
                    myans.add(rem.data);
                    if(rem.left!=null)  q.addLast(rem.left);

                    rem=rem.right;
                }
            }
            ans.add(myans);
        }
        return ans;
    }

    private static ArrayList<Integer>TopViewOfBT(Node root){
        ArrayList<Integer>ans = new ArrayList<>();
        if(root==null)  return ans;
        int[] minMax = new int[2];
        width_(root,0,minMax);
        int len = minMax[1]-minMax[0]+1;
        for(int i=0;i<len;i++)
            ans.add(null);
        LinkedList<vPair>q=new LinkedList<>();
        q.addLast(new vPair(root,Math.abs(minMax[0])));

        while(q.size()>0){
            int size=q.size();

            while(size-->0){
                vPair rem = q.removeFirst();
                Node node = rem.node;
                int hl = rem.hl;

                ans.set(hl,node.data);

                if(node.left!=null)   q.addLast(new vPair(node.left,hl-1));
                if(node.right!=null)   q.addLast(new vPair(node.right,hl+1));
            }
        }
        return ans;
    }
    private static ArrayList<Integer>bottomViewOfBT(Node root){
        ArrayList<Integer>ans = new ArrayList<>();
        if(root==null)  return ans;
        int[] minMax = new int[2];
        width_(root,0,minMax);
        int len = minMax[1]-minMax[0]+1;
        for(int i=0;i<len;i++)
            ans.add(null);
        LinkedList<vPair>q=new LinkedList<>();
        q.addLast(new vPair(root,Math.abs(minMax[0])));

        while(q.size()>0){
            int size=q.size();

            while(size-->0){
                vPair rem = q.removeFirst();
                Node node = rem.node;
                int hl = rem.hl;

                ans.set(hl,node.data);

                if(node.left!=null)   q.addLast(new vPair(node.left,hl-1));
                if(node.right!=null)   q.addLast(new vPair(node.right,hl+1));
            }
        }
        return ans;
    }
    private static List<List<Integer>>verticalOrderTraversal2(Node root){
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null)  return ans;
        LinkedList<vPair>q=new LinkedList<>();
        int[] minMax=new int[2];
        width_(root,0,minMax);

        int len=minMax[1]-minMax[0]+1;
        for(int i=0;i<len;i++)
            ans.add(new ArrayList<>());

        q.addLast(new vPair(root,Math.abs(minMax[0])));
        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                vPair rem = q.removeLast();
                Node node=rem.node;
                int hl=rem.hl;

                List<Integer>myans=ans.get(hl);
                myans.add(node.data);

                if(node.left!=null){
                    q.addLast(new vPair(node.left,hl-1));
                }
                if(node.right!=null){
                    q.addLast(new vPair(node.right,hl+1));
                }
            }
        }

        return ans;
    }
    private static int width(Node root){
        int[] ans=new int[2];
        width_(root,0,ans);
        return ans[1]-ans[0]+1;
    }
    private static void width_(Node root,int hl,int[] arr){
        if(root==null)  return;

        arr[0]=Math.min(arr[0],hl);
        arr[1]=Math.max(arr[1],hl);

        width_(root.left,hl-1,arr);
        width_(root.right,hl+1,arr);
    }
    public static class vPair{
        Node node=null;
        int hl;
        vPair(Node node,int hl){
            this.node=node;
            this.hl=hl;
        }
    }
    private static List<List<Integer>> verticalOrderTraversal(Node root){
        int maxhl=0,minhl=0;
        LinkedList<vPair>q=new LinkedList<>();
        List<List<Integer>>ans=new ArrayList<>();
        HashMap<Integer,List<Integer>>map=new HashMap<>();
        q.addLast(new vPair(root,0));
        while(q.size()>0){
           int size=q.size();
           while(size-->0){
               vPair rem = q.removeFirst();

               map.putIfAbsent(rem.hl,new ArrayList<>());
               List<Integer>myList=map.get(rem.hl);
               myList.add(rem.node.data);
               minhl=Math.min(minhl,rem.hl);
               maxhl=Math.max(maxhl,rem.hl);
               if(rem.node.left!=null){
                   q.addLast(new vPair(rem.node.left,rem.hl-1));
               }
               if(rem.node.right!=null){
                   q.addLast(new vPair(rem.node.right,rem.hl+1));
               }
           }
        }
        for(int i=minhl;i<=maxhl;i++){
            ans.add(map.get(i));
        }
        return ans;
    }
    private static Node deserialize(String str){
        String[] arr = str.split(" ");
        return deserialize(arr);
    }
    static int idx=0;
    private static Node deserialize(String[] arr){
        if(idx>=arr.length || arr[idx].equals("null")){
            return null;
        }
        Node node = new Node(Integer.parseInt(arr[idx++]));
        node.left = deserialize(arr);
        node.right = deserialize(arr);

        return node;
    }
    private static String serialize(Node root){
        StringBuilder sb=new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }
    private static void serialize(Node root,StringBuilder sb){
        if(root==null){
            sb.append("null");
            return;
        }
        sb.append(root.data+" ");
        serialize(root.left,sb);
        serialize(root.right,sb);

    }
    private static ArrayList<Integer>preOrderMorrisTraversal(Node root){
        Node curr=root;
        ArrayList<Integer>ans=new ArrayList<>();
        while(curr!=null){
            Node leftNode=curr.left;
            if(leftNode==null){
                ans.add(curr.data);
                curr=curr.right;
            }
            else{
                Node rightModeNode=getRightMostNode(leftNode,curr);
                if(rightModeNode.right==null){
                    ans.add(curr.data);
                    rightModeNode.right=curr;
                    curr=curr.left;
                }
                else{
                    rightModeNode.right=null;
                    curr=curr.right;
                }
            }
        }
        return ans;
    }
    private static void inorder(Node root,ArrayList<Integer>ans){
        if(root==null)  return;

        inorder(root.left,ans);
        ans.add(root.data);
        inorder(root.right,ans);
    }
    private static Node getRightMostNode(Node rightMost,Node curr){
         while(rightMost.right!=null && rightMost.right!=curr){
             rightMost=rightMost.right;
         }
         return rightMost;
    }
    private static ArrayList<Integer> inorderMorrisTraversal(Node node){
        ArrayList<Integer>ans=new ArrayList<>();
         Node curr=node;
         while(curr!=null){
             Node leftNode = curr.left;
             if(leftNode == null){
                 ans.add(curr.data);
                 curr=curr.right;
             }
             else{
                 Node rightMostNode=getRightMostNode(leftNode,curr);
                 if(rightMostNode.right==null){
                     rightMostNode.right=curr;
                     curr=curr.left;
                 }
                 else{
                     rightMostNode.right=null;
                     ans.add(curr.data);
                     curr=curr.right;
                 }
             }
         }
         return ans;
    }

    /************* Tree Level2 ***************/
    static class PropertiesOfBST{
        int max;
        int min;
        boolean isBST;
        Node node;
        int size;
    }
    private static PropertiesOfBST largestBstSubtree(Node root){
        if(root==null){
            PropertiesOfBST bp=new PropertiesOfBST();
            bp.max=Integer.MIN_VALUE;
            bp.min=Integer.MAX_VALUE;
            bp.isBST=true;
            bp.size=0;

            return bp;
        }
        PropertiesOfBST lp=largestBstSubtree(root.left);
        PropertiesOfBST rp=largestBstSubtree(root.right);
        PropertiesOfBST mp=new PropertiesOfBST();
        mp.isBST=lp.isBST && rp.isBST && (root.data>=lp.max && root.data<=rp.min);
        mp.max=Math.max(root.data,Math.max(lp.max,rp.max));
        mp.min=Math.max(root.data,Math.max(lp.min,rp.min));

       if(mp.isBST){
           mp.node=root;
           mp.size=lp.size+rp.size+1;
       }
       else if(lp.size>rp.size){
           mp.size=lp.size;
           mp.node=lp.node;
       }
       else{
           mp.size=rp.size;
           mp.node=rp.node;
       }
        return mp;
    }
    static class IsBalPair{
        boolean isBalance;
        int ht;
    }
    private static IsBalPair isBal(Node root){
        if(root==null){
            IsBalPair bp=new IsBalPair();
            bp.ht=0;
            bp.isBalance=true;
            return bp;
        }

        IsBalPair lp=isBal(root.left);
        IsBalPair rp=isBal(root.right);

        IsBalPair mp=new IsBalPair();
        mp.isBalance=Math.abs(lp.ht-rp.ht)<=1 && lp.isBalance && rp.isBalance;
        mp.ht=Math.max(lp.ht,rp.ht)+1;

        return mp;
    }
    static boolean isBST=true;
    private static int isBalenced(Node root){
        if(root==null){
            return 0; // ht in terms of nodes
        }
        int lb=isBalenced(root.left);
        int rb=isBalenced(root.right);
        int ht=Math.max(lb,rb)+1;
        int diff=Math.abs(lb-rb);
        if(diff>1){
            isBST=false;
        }
        return ht;
    }
    public static class BSTPair{
        boolean isBst;
        int min;
        int max;
    }
    private static BSTPair isTreeBST(Node root){
        if(root==null){
            BSTPair bp=new BSTPair();
            bp.min=Integer.MAX_VALUE;
            bp.max=Integer.MIN_VALUE;
            bp.isBst=true;
            return bp;
        }
        BSTPair lp=isTreeBST(root.left);
        BSTPair rp=isTreeBST(root.right);
        BSTPair mp=new BSTPair();
        mp.isBst=(lp.isBst && rp.isBst)&&(root.data>=lp.max && root.data<=rp.min);
        mp.min=Math.min(root.data,Math.min(lp.min,rp.min));
        mp.max=Math.max(root.data,Math.max(lp.max,rp.max));

        return mp;
    }
    static int tilt;
    private static int tiltOfBinaryTree(Node root){
        if(root==null)  return 0;
        int lt=tiltOfBinaryTree(root.left);
        int rt=tiltOfBinaryTree(root.right);
        int currTilt=Math.abs(lt-rt);
        tilt+=currTilt;

        return lt+rt+root.data;
    }
    public static class DiaPair{
        int ht;
        int dia;
    }
    private static DiaPair Diameter(Node root){
        if(root==null){
            DiaPair bp=new DiaPair();
            bp.ht=-1;
            bp.dia=0;
            return bp;
        }
        DiaPair lp=Diameter(root.left);
        DiaPair rp=Diameter(root.right);

        DiaPair mp=new DiaPair();
        mp.ht=Math.max(lp.ht,rp.ht)+1;

        int factorInEitherSide=lp.ht+rp.ht+2;
        mp.dia=Math.max(factorInEitherSide,Math.max(lp.dia,rp.dia));

        return mp;
    }
    private static int diameterOfBT(Node root){
        if(root==null)  return 0;
        int ld=diameterOfBT(root.left);
        int rd=diameterOfBT(root.right);
        int th=heightOfTree(root.left)+heightOfTree(root.right)+2;
        int dia=Math.max(th,Math.max(ld,rd));

        return dia;
    }
    private static Node removeLeaves(Node root){
        if(root==null)  return null;  // if it has only one child
        if(root.left==null && root.right==null){
            return null;
        }
        root.left=removeLeaves(root.left);
        root.right=removeLeaves(root.right);
        return root;
    }
    private static Node leftClonedToNormalTree(Node root){
        if(root==null)  return null;
        Node lctn=leftClonedToNormalTree(root.left.left);
        Node rtn=leftClonedToNormalTree(root.right);
        root.left=lctn;
        root.right=rtn;

        return root;
    }
    private static Node leftClonedTree(Node root){
        if(root==null)  return null;
        Node lct=leftClonedTree(root.left);
        Node rct=leftClonedTree(root.right);
        Node newNode=new Node(root.data,lct,null);

        root.left=newNode;
        root.right=rct;

        return root;
    }
    private static Node rightClonedTree(Node root){
        if(root==null)  return null;
        Node lct=rightClonedTree(root.left);
        Node rct=rightClonedTree(root.right);
        Node newNode=new Node(root.data,null,rct);

        root.left=lct;
        root.right=newNode;

        return root;
    }
    private static void pathRootFromLeaf(Node root,String psf,int sum,int lo,int hi){
        if(root==null)  return;  // if node has only one child
        if(root.left==null && root.right==null){
            sum+=root.data;
            if(sum>=lo && sum<=hi){
                System.out.println(psf+root.data);
            }
            return;
        }
        pathRootFromLeaf(root.left,psf+root.data+" ",sum+root.data,lo,hi);
        pathRootFromLeaf(root.right,psf+root.data+" ",sum+root.data,lo,hi);
    }
    static ArrayList<Node>paths;
    private static void printKNodesAway(Node node,int k,int data){
        paths=new ArrayList<>();
        nodeToRootPathForNode(node,data);
        for(int i=0;i<paths.size();i++){
            printKlevelsDown3(node,k-i,paths.get(i-1));
        }
    }
    private static void printKlevelsDown3(Node node,int k,Node blocker){
        if(node==null || k<0 || node==blocker)  return;
        if(k==0){
            System.out.println(node.data);
        }
        printKlevelsDown3(node.left,k-1,blocker);
        printKlevelsDown3(node.right,k-1,blocker);
    }

    private static boolean nodeToRootPathForNode(Node node,int data){
        if(node==null)  return false;
        if(node.data==data){
            paths.add(node);
            return true;
        }
        boolean filc=nodeToRootPathForNode(node.left,data);
        if(filc){
            paths.add(node);
            return true;
        }
        boolean firc=nodeToRootPathForNode(node.right,data);
        if(firc){
            paths.add(node);
            return true;
        }
        return false;
    }

    private static void printKlevelsDown2(Node root,int k){
        if(root==null || k<0){
            return;
        }
        if(k==0){
            System.out.print(root.data+" ");
        }
        printKlevelsDown2(root.left,k-1);
        printKlevelsDown2(root.right,k-1);
    }
    private static void printKlevelsDown(Node root,int k){
        int level=0;
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node rem=q.remove();
                if(level==k)
                    System.out.print(rem.data+" ");

                if(rem.left!=null)
                    q.add(rem.left);
                if(rem.right!=null)
                    q.add(rem.right);
            }
            level++;
        }
    }
    static ArrayList<Integer>path;
    private static boolean nodeToRootPath(Node root,int data){
        if(root==null)  return false;
        if(root.data==data){
            path.add(root.data);
            return true;
        }
        boolean filc=nodeToRootPath(root.left,data);
        if(filc){
            path.add(root.data);
            return true;
        }
        boolean firc=nodeToRootPath(root.right,data);
        if(firc){
            path.add(root.data);
            return true;
        }
        return false;
    }
    private static void inPrePostOrderTraversal(Node root){
        Stack<Pair>st=new Stack<>();
        Pair rp=new Pair(root,1);
        st.push(rp);
        String pre="";
        String in="";
        String post="";
        while(st.size()>0){
            Pair top=st.peek();
            if(top.state==1){
                if(top.node!=null){
                    pre+=top.node.data+" ";
                    Pair p=new Pair(top.node.left,1);
                    st.push(p);
                }
                top.state++;
            }
            else if(top.state==2){
                if(top.node!=null){
                    in+=top.node.data+" ";
                    Pair p=new Pair(top.node.right,1);
                    st.push(p);
                }
                top.state++;
            }
            else{
                if(top.node!=null)
                    post+=top.node.data+" ";

                st.pop();
                //top.state++;
            }
        }
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

    private static int heightOfTree(Node root){
        if(root==null){
            return -1; // in terms of edges
            //  return 0;//   int terms of nodes
        }
        int lh=heightOfTree(root.left);
        int rh=heightOfTree(root.right);
        int th=Math.max(lh,rh);

        return th+1;
    }

    private static int maxOfTree(Node root){
        int max=Integer.MIN_VALUE;
        if(root==null)  return 0;
        int lm=maxOfTree(root.left);
        int rm=maxOfTree(root.right);
        max=Math.max(lm,rm);
        max=Math.max(max,root.data);
        return max;
    }
    private static int sumOfTree(Node root){
        if(root==null)  return 0;
        int ls=sumOfTree(root.left);
        int rs=sumOfTree(root.right);
        return root.data+ls+rs;
    }
    private static int sizeOfTree(Node root){
        if(root==null)  return 0;
        int ls=sizeOfTree(root.left);
        int rs=sizeOfTree(root.right);
        return ls+rs+1;
    }
    private static void display(Node root){
        if(root==null)  return;
        String str="";
        str+=root.left==null ? "." : root.left.data;
        str+="<-"+root.data+"->";
        str+=root.right==null ? "." : root.right.data;

        System.out.println(str);

        display(root.left);
        display(root.right);

    }
}

