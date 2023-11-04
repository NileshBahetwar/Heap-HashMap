import java.util.*;
//import java.util.Scanner;

public class Heap {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // 1.employee and managers
        HashMap<String,String>hm=new HashMap<>();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            hm.put(sc.next(),sc.next());
        }
        findCount(hm);

        // 2.
    }
    private static void findCount(HashMap<String,String>hm){
        String ceo="";
        HashMap<String,HashSet<String>> tree = new HashMap<>();
        for(String emp : hm.keySet()){
            String man = hm.get(emp);

            if(man.equals(emp)){
                ceo=man;
            }
            else{
                if(tree.containsKey(man)){
                    HashSet<String>emps=tree.get(man);
                    emps.add(emp);
                }
                else{
                    HashSet<String>emps=new HashSet<>();
                    emps.add(emp);
                    tree.put(man,emps);
                }
            }
        }
        HashMap<String,Integer>res=new HashMap<>();
        getSize(tree,ceo,res);
        for(String emp : res.keySet()){
            System.out.println(emp+" "+res.get(emp));
        }
    }
    private static int getSize(HashMap<String,HashSet<String>>tree,String man,HashMap<String,Integer>res){
        if(tree.containsKey(man)==false){
            res.put(man,0);
            return 1;
        }
        int sz=0;
        for(String emp : tree.get(man)){
            int cs=getSize(tree,emp,res);
            sz+=cs;
        }
        res.put(man,sz);

        return sz+1;
    }
}
