import java.sql.Array;
import java.util.*;
public class Recursion {
   public static void main(String[] args) {
     // int[] arr={3,7,33,2,5,4,2,55,2,11,5,65,45};
// 1. System.out.println(firstIndOfEle(arr,2,0));

// 2. System.out.println(lastIndOfEle(arr,2,0));

// 3.  int[] ans=allIndices(arr,2,0,0);
//    for(int i=0;i<ans.length;i++)
//    System.out.print(ans[i]+" ");

// 4.  String s="abc";
//  ArrayList<String>res=getSubSequenece(s);
// for(int i=1;i<res.size();i++){
// System.out.print(res.get(i)+" ");
// }

// 5.
//      Scanner sc = new Scanner(System.in);
//      int n = sc.nextInt();
//      int[] keys = new int[n];
//      for(int i=0;i<n;++i){
//         keys[i] = sc.nextInt();
//      }
//      ArrayList <String> ans=oldPhone(n,keys);
//      for(String i:ans) System.out.print(i+" ");

// 6.
//      Scanner input = new Scanner(System.in);
//      int n = input.nextInt();
//      ArrayList<String> paths = getStairPaths(n);
//      System.out.println(paths);

// 7.
//      Scanner sc=new Scanner(System.in);
//      int n,m;
//      n=sc.nextInt();
//      m=sc.nextInt();
//   7.1  // ArrayList<String>ans=getMazePath(n,m);
//   7.2   ArrayList<String>ans=getMazePathWithJump(n,m);
//      System.out.println(ans);

       Scanner sc=new Scanner(System.in);
       //String s=sc.next();
// 8.  printSubsequence(s,"");

// 9.  printKeypad(s,"");
//

// 10. int n=sc.nextInt();
//     printStairPaths(n,"");

// 11.   int n=sc.nextInt();
//       int m=sc.nextInt();
//       printMazePath(0,0,n,m,"");

// 12.   String s=sc.next();
//      printEncoding(s,"");

// 13.  int n,m;
//      n=sc.nextInt();
//      m=sc.nextInt();
//      int[][] arr=new int[n][m];
//      for(int i=0;i<n;i++){
//         for(int j=0;j<m;j++){
//            arr[i][j]=sc.nextInt();
//         }
//      }
//      boolean[][] visited=new boolean[n][m];
//      floodFill(arr,0,0,"",visited);

//  14. int n=sc.nextInt();
//      int[] arr=new int[n];
//      for(int i=0;i<n;i++)
//         arr[i]=sc.nextInt();
//      int target=sc.nextInt();
//      printTragetSumSubset(arr,0,0,"",target);

//  15. int n=sc.nextInt();
//      NQueens(n);

//  16. int n,r,c;
//      n=sc.nextInt();
//      r=sc.nextInt();
//      c=sc.nextInt();
//      int[][] chess=new int[n][n];
//      kNightsTour(chess,r,c,1);
   }

   private static void kNightsTour(int[][] chess,int r,int c,int move){
      if(r<0 || c<0 || r>=chess.length || c>=chess.length || chess[r][c]>0){
         return;
      }
      else if(move==chess.length*chess.length){
         chess[r][c]=move;
         display(chess);
         System.out.println();
         chess[r][c]=0;
         return;
      }
      chess[r][c]=move;
      kNightsTour(chess,r-2,c+1,move+1);
      kNightsTour(chess,r-1,c+2,move+1);
      kNightsTour(chess,r+1,c+2,move+1);
      kNightsTour(chess,r+2,c+1,move+1);
      kNightsTour(chess,r+2,c-1,move+1);
      kNightsTour(chess,r+1,c-2,move+1);
      kNightsTour(chess,r-1,c-2,move+1);
      kNightsTour(chess,r-2,c-1,move+1);
      chess[r][c]=0;
   }
   private static void display(int[][] chess){
      for(int i=0;i<chess.length;i++){
         for(int j=0;j<chess[0].length;j++){
            System.out.print(chess[i][j]+" ");
         }
         System.out.println();
      }
   }

   private static void NQueens(int n){
      int[][] chess=new int[n][n];
      theQueen(chess,0,"");
      System.out.println("No of Ways to Queen can safely placed are: "+cnt);
   }
   static int cnt=0;
   private static void theQueen(int[][] chess,int row,String qsf){
      if(row==chess.length){
         System.out.println(qsf.substring(0,qsf.length()-1));
         cnt++;
         return ;
      }
      for(int col=0;col<chess.length;col++){
         if(isItSafePlaceFotTheQueen(chess,row,col)){
            chess[row][col]=1;
            theQueen(chess,row+1,qsf+row+"-"+col+",");
            chess[row][col]=0;
         }
      }
   }
   private static boolean isItSafePlaceFotTheQueen(int[][] chess,int row,int col){
         for(int i=row-1,j=col;i>=0;i--){
            if(chess[i][j]==1)
               return false;
         }
         for(int i=i=row-1,j=col-1 ; i>=0 && j>=0 ;i--,j--){
            if(chess[i][j]==1)
               return false;
         }
         for(int i=row-1,j=col+1;i>=0 && j<chess.length;i--,j++){
            if(chess[i][j]==1)
               return false;
         }
         return true;
   }
   private static void printTragetSumSubset(int[] arr,int idx,int sum,String sos,int target){
      if(idx==arr.length){
         if(sum==target)
            System.out.println(target+"="+sos.substring(0,sos.length()-1));
         return;
      }
      printTragetSumSubset(arr,idx+1,sum+arr[idx],sos+arr[idx]+"+",target);
      printTragetSumSubset(arr,idx+1,sum,sos,target);
   }
   private static void floodFill(int[][] arr,int row,int col,String psf,boolean[][] visited){
          if(row<0 || col<0 || row==arr.length || col==arr[0].length || arr[row][col]==1 || visited[row][col]==true){
             return;
          }
          if(row==arr.length-1 && col==arr[0].length-1){
             System.out.println(psf);
             return;
          }
          visited[row][col]=true;
          floodFill(arr,row-1,col,psf+"t",visited);
          floodFill(arr,row,col-1,psf+"l",visited);
          floodFill(arr,row+1,col,psf+"d",visited);
          floodFill(arr,row,col+1,psf+"r",visited);
          visited[row][col]=false;

// TC : 6 7
//      0 1 0 0 0 0 0
//      0 1 0 1 1 1 0
//      0 0 0 0 0 0 0
//      1 0 1 1 0 1 1
//      1 0 1 1 0 1 1
//      1 0 0 0 0 0 0
//      ddrdddrrrrr
//      ddrrttrrrrddlldddrr
//      ddrrrrdddrr
   }
   private static void printEncoding(String s,String asf){
       if(s.length()==0){
          System.out.println(asf);
          return;
       }
       else if(s.length()==1){
          char c=s.charAt(0);
          if(c=='0'){
             return;
          }
          else{
             int cval=c-'0';
             char ch=(char)('a'+cval-1);
             asf=asf+ch;
             System.out.println(asf);

          }
       }
       else{
            char c=s.charAt(0);
            String roq=s.substring(1);
            if(c=='0'){
               return;
            }
            else{
               int cval=c-'0';
               char ch=(char)('a'+cval-1);
               printEncoding(roq,asf+ch);
            }

            String ch12=s.substring(0,2);
            String sub=s.substring(2);

            int val=Integer.parseInt(ch12);
            if(val<=26){
               char code=(char)('a'+val-1);
               printEncoding(sub,asf+code);
            }
       }
   }
   private static void printMazePath(int sr,int sc,int dr,int dc,String ans){
      
      if(sc==dc && sr==dr){
         System.out.println(ans);
         return;
      }
      if(sc<dc)
       printMazePath(sc+1,sr,dr,dc,ans+"h");
      if(sr<dr)
       printMazePath(sc,sr+1,dr,dc,ans+"v");
   }
   private static void printStairPaths(int n,String ans){
         if(n<0)  return;
         if(n==0){
            System.out.println(ans);
         }
         printStairPaths(n-1,ans+1);
         printStairPaths(n-2,ans+2);
         printStairPaths(n-3,ans+3);
   }
   private static void printKeypad(String s,String ans){
      if(s.length()==0){
         System.out.println(ans);
         return;
      }
      char c=s.charAt(0);
      String sub=s.substring(1);
      int idx=c-'0';

      String button=str[idx];
      for(int i=0;i<button.length();i++){
         char ch=button.charAt(i);
         printKeypad(sub,ans+ch);
      }
   }
   private static void printSubsequence(String s,String ans){
      if(s.length()==0){
         if(ans.length()!=0)
         System.out.println(ans);
         return;
      }
      char c=s.charAt(0);
      String sub=s.substring(1);
      printSubsequence(sub,""+ans);
      printSubsequence(sub,c+ans);

   }
   private static ArrayList<String>getMazePathWithJump(int n,int m){
      ArrayList<String>ans=helper2(1,1,n,m);
      Collections.sort(ans);
      return ans;
   }

   private static ArrayList<String>helper2(int sr,int sc,int dr,int dc){
      if(sr==dr && sc==dc){
         ArrayList<String>bres=new ArrayList<>();
         bres.add("");
         return bres;
      }
      ArrayList<String>paths=new ArrayList<>();
      for(int ms=1;ms<=dc-sc;ms++){
         ArrayList<String>hpath=helper2(sr,sc+ms,dr,dc);
         for(String hp : hpath){
              paths.add("h"+ms+hp);
         }
      }
      for(int ms=1;ms<=dr-sr;ms++){
         ArrayList<String>vpath=helper2(sr+ms,sc,dr,dc);
         for(String vp : vpath){
            paths.add("v"+ms+vp);
         }
      }
      for(int ms=1;ms<=dr-sr;ms++){
         ArrayList<String>dpath=helper2(sr+ms,sc+ms,dr,dc);
         for(String dp : dpath){
            paths.add("d"+ms+dp);
         }
      }
      return paths;
   }
   private static ArrayList<String>getMazePath(int n,int m){
      ArrayList<String>res=helper(1,1,n,m);
      return res;
   }
   private static ArrayList<String>helper(int sr,int sc,int dr,int dc){
      if(sr==dr && sc==dc){
         ArrayList<String>bres=new ArrayList<>();
         bres.add("");
         return bres;
      }
      ArrayList<String>hpath=new ArrayList<>();
      ArrayList<String>vpath=new ArrayList<>();
      ArrayList<String>dpath=new ArrayList<>();
      if(sc<dc){
         hpath=helper(sr,sc+1,dr,dc);
      }
      if(sr<dr){
         vpath=helper(sr+1,sc,dr,dc);
      }
      if(sc<dc && sr<dr){
         dpath=helper(sr+1,sr+1,dr,dc);
      }
      ArrayList<String>paths=new ArrayList<>();
      for(String path : hpath){
         paths.add("h"+path);
      }
      for(String path : vpath){
         paths.add("v"+path);
      }
      for(String path : dpath){
         paths.add("d"+path);
      }
      return paths;
   }
   private static ArrayList<String> getStairPaths(int n){
      if(n<0){
         ArrayList<String>bres=new ArrayList<>();
         return bres;
      }
      if(n==0){
         ArrayList<String>bres=new ArrayList<>();
         bres.add("");
         return bres;
      }
      ArrayList<String>path1=getStairPaths(n-1);
      ArrayList<String>path2=getStairPaths(n-2);
      ArrayList<String>path3=getStairPaths(n-3);

      ArrayList<String>ans=new ArrayList<>();
      for(String path : path1){
         ans.add(1+path);
      }
      for(String path : path2){
         ans.add(2+path);
      }
      for(String path : path3){
         ans.add(3+path);
      }
      return ans;
   }
   public static String[] str={"","ABC","DEF","GHI","JKL","MNO","PQRS","TU","VWX","YZ"};
   private static ArrayList<String> oldPhone(int n,int[] keys){
        String s="";
        for(int i=0;i<n;i++){
           s+=keys[i];
        }
       ArrayList<String>ans=getKeypad(s);
       return ans;
   }
   private static ArrayList<String>getKeypad(String s){
      if(s.length()==0){
         ArrayList<String> bres=new ArrayList<>();
         bres.add("");
         return bres;
      }
      char c=s.charAt(0);
      String sub=s.substring(1);
      int digit=c-'0';
      ArrayList<String>rres=getKeypad(sub);
      ArrayList<String>mres=new ArrayList<>();
      String curr=str[digit];

      for(int i=0;i<curr.length();i++){
         char ch=curr.charAt(i);
         for(String p : rres){
            mres.add(ch+p);
         }
      }
      return mres;
   }
   private static ArrayList<String> getSubSequenece(String s){
      if(s.length()==0){
         ArrayList<String>bres=new ArrayList<>();
         bres.add("");
         return bres;
      }
      char c=s.charAt(0);
      String sub=s.substring(1);
      ArrayList<String>rres=getSubSequenece(sub);
      ArrayList<String>mres=new ArrayList<>();
      for(String seq : rres){
         mres.add(""+seq);
         mres.add(c+seq);
      }
      return mres;
   }
   private static int[] allIndices(int[] arr,int data,int idx,int fsf){
       if(idx==arr.length){
          return new int[fsf];
       }
        if(arr[idx]==data){
           int[] ans=allIndices(arr,data,idx+1,fsf+1);
           ans[fsf]=idx;
           return ans;
        }
        else{
           int[] ans=allIndices(arr,data,idx+1,fsf);
           return ans;
        }
   }
   private static int lastIndOfEle(int[] arr,int data,int idx){
      if(idx==arr.length)  return -1;
      int lastInd=lastIndOfEle(arr,data,idx+1);
      if(lastInd==-1){  // my team members not able complete the task
         if(arr[idx]==data){  // my team members not able to do then let me try
            return idx;
         }
         else{ // if i also not able to do that task
            return -1;
         }
      }
      else{ // my team members themselves able to complete the task
         return lastInd;
      }
   }
   private static int firstIndOfEle(int[] arr,int data,int idx){
      // 1.PostOrder
      // if(idx==arr.length)  return -1;
      // int ansInd=firstIndOfEle(arr,data,idx+1);
      // if(arr[idx]==data){
      //   return idx;
      // }
      // else{
      //    return ansInd;
      // }

      // 2.InOrder
      if(idx==arr.length)  return -1;
      if(arr[idx]==data){
         return idx;
      }
      else{
         int ansInd=firstIndOfEle(arr,data,idx+1);
         return ansInd;
      }
   }
}
