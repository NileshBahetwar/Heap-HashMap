import java.util.*;
public class BackTracking {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // 1 Printing Abbreviations
//         Scanner sc=new Scanner(System.in);
//         String s=sc.next();
//         printAbbrevations(s,"",0,0);
//         System.out.println();

         // 2 N Queens
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        boolean[] cols=new boolean[n];
//        boolean[] ndiag=new boolean[2*n-1];
//        boolean[] rdiag=new boolean[2*n-1];
//        boolean[][] board=new boolean[n][n];
//        NQueens(board,0,cols,ndiag,rdiag,"");

        // 3.max Score
        int nw=sc.nextInt();
        String[] words = new String[nw];
        for(int i=0;i<nw;i++)
            words[i]=sc.next();

        int nl=sc.nextInt();
        char[] letters = new char[nl];
        for(int i=0;i<nl;i++)
            letters[i]=sc.next().charAt(0);

        int[] score = new int[26];
        for(int i=0;i<score.length;i++)
            score[i]=sc.nextInt();

        if(words==null || words.length==0 || letters==null || letters.length==0){
            System.out.println(0);
            return;
        }

        int[] farr=new int[26];
        for(char c : letters){
            farr[c-'a']++;
        }

        int ans = maxScore(words,farr,score,0);
        System.out.println(ans);

        // 5 Josephus problem
//        int n=sc.nextInt();
//        int k=sc.nextInt();
//        int ans=josephus(n,k);
//        System.out.println(ans);
    }
    private static int maxScore(String[] words,int[] farr,int[] score,int idx){
        if(idx==words.length)  return 0;
            int notInclude=0+maxScore(words,farr,score,idx+1);
            String word=words[idx];
            boolean flag=true;
            int sword=0;
            for(int i=0;i<word.length();i++){
                char c=word.charAt(i);
                if(farr[c-'a']==0){
                    flag=false;
                }
                farr[c-'a']--;
                sword+=score[c-'a'];
            }
            int Include=0;
            if(flag){
                Include=sword+maxScore(words,farr,score,idx+1);
            }
            for(int i=0;i<word.length();i++){
                char c=word.charAt(i);
                farr[c-'a']++;
            }
            return Math.max(Include,notInclude);
    }
    private static int josephus(int n,int k){
        if(n==1){
            return 0;
        }
       int x=josephus(n-1,k);
       int y=(x+k)%n;

       return y;
    }
    private static void NQueens(boolean[][] board,int row,boolean[] cols,boolean[] ndiag,boolean[] rdiag,String asf){

          if(row==board.length){
              System.out.println(asf.substring(0,asf.length()-1));
              return;
          }

           for(int col=0;col<board.length;col++){
               if(cols[col]==false && ndiag[col+row]==false && rdiag[row-col+board.length-1]==false){
                   board[row][col]=true;
                   cols[col]=true;
                   ndiag[col+row]=true;
                   rdiag[row-col+board.length-1]=true;

                   NQueens(board,row+1,cols,ndiag,rdiag,asf+row+"-"+col+",");

                   board[row][col]=false;
                   cols[col]=false;
                   ndiag[col+row]=false;
                   rdiag[row-col+board.length-1]=false;
               }
           }
    }
    //  1
    private static void printAbbrevations(String s,String asf,int cnt,int idx){
        if(idx==s.length()){
            if(cnt==0)
            System.out.println(asf);
            else
            System.out.println(asf+cnt);

            return;
        }

        // considering curr character
        if(cnt>0)
            printAbbrevations(s,asf+cnt+s.charAt(idx),0,idx+1);
        else
            printAbbrevations(s,asf+s.charAt(idx),0,idx+1);
        // not considering curr character
        printAbbrevations(s,asf,cnt+1,idx+1);
    }
}
