import java.io.File;
import java.util.Scanner;

public class Main{
    private ArrayList<String> genes = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(new File("Test.txt"));
        Main CLASS = new Main(); //Used to access the methods in this class
        int L = Integer.parseInt(scan.nextLine());
        int V = Integer.parseInt(scan.nextLine());
        int D = Integer.parseInt(scan.nextLine());
        //The total number of genes is # valid genes + # diseased genes
        for (int i = 0; i < V + D; i++) CLASS.genes.addNode(scan.nextLine());
        CLASS.SORT(0, V + D); //Merge Sort the genes
        int M = Integer.parseInt(scan.nextLine());
        int G = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < G; i++){
            String P = scan.next();
            String Q = scan.next();
            double ans = CLASS.BFS(P, Q, M);
            System.out.println(ans == -1 ? "NO" : "YES\n" + ans);
        }
    }

    public double BFS(String start, String end, int M){
        double ans = -1;
        Queue<Triple> q = new Queue<>();
        q.enqueue(new Triple(start, 1, 0));
        while (!q.isEmpty()){
            Triple cur = q.dequeue();
            //If number of mutations exceeds limit
            if (cur.z > M) continue;
            if (cur.x.equals(end)){
                //Found valid answer; update final answer
                ans = Math.max(ans, cur.y);
                continue;
            }
            //RULE 1
            String swapped = cur.x.charAt(cur.x.length()-1) + cur.x.substring(1, cur.x.length()-1) + cur.x.charAt(0);
            //If the modified gene exists, add to the queue
            if (BS(swapped)) q.enqueue(new Triple(swapped, cur.y * 0.02, cur.z + 1));
            //RULE 2
            ArrayList<Integer> indices = new ArrayList<>();
            for (int i = 0; i < cur.x.length() - 1; i++){
                if (cur.x.charAt(i) == cur.x.charAt(i+1)) indices.addNode(i);
            }
            for (int i = 0; i < indices.size(); i++){
                int index = indices.getNode(i);
                String beginning = cur.x.substring(0, index), ending = cur.x.substring(index + 2);
                String addA = beginning + "A" + ending;
                String addC = beginning + "C" + ending;
                String addG = beginning + "G" + ending;
                String addT = beginning + "T" + ending;
                if (BS(addA)) q.enqueue(new Triple(addA, cur.y * 0.06, cur.z + 1));
                if (BS(addC)) q.enqueue(new Triple(addC, cur.y * 0.06, cur.z + 1));
                if (BS(addG)) q.enqueue(new Triple(addG, cur.y * 0.06, cur.z + 1));
                if (BS(addT)) q.enqueue(new Triple(addT, cur.y * 0.06, cur.z + 1));
            }
            //RULE 3
            indices = new ArrayList<>(); //Clear the ArrayList
            for (int i = 0; i < cur.x.length() - 1; i++){
                //Check if any part of the gene has "GT" or "TG" in it
                if (cur.x.charAt(i) == 'G' && cur.x.charAt(i + 1) == 'T') indices.addNode(i);
                if (cur.x.charAt(i) == 'T' && cur.x.charAt(i + 1) == 'G') indices.addNode(i);
            }
            for (int i = 0; i < indices.size(); i++){
                int index = indices.getNode(i);
                String beginning = cur.x.substring(0, index + 1), ending = cur.x.substring(index + 1);
                String addA = beginning + "A" + ending;
                String addC = beginning + "C" + ending;
                String addG = beginning + "G" + ending;
                String addT = beginning + "T" + ending;
                if (BS(addA)) q.enqueue(new Triple(addA, cur.y * 0.08, cur.z + 1));
                if (BS(addC)) q.enqueue(new Triple(addC, cur.y * 0.08, cur.z + 1));
                if (BS(addG)) q.enqueue(new Triple(addG, cur.y * 0.08, cur.z + 1));
                if (BS(addT)) q.enqueue(new Triple(addT, cur.y * 0.08, cur.z + 1));
            }
        }
        return ans;
    }

    private void SORT(int start, int end){
        if (end - start > 1){
            int middle = (start + end) / 2;
            SORT(start, middle);
            SORT(middle, end);
            CombineList(start, end);
        }
    }

    private void CombineList(int start, int end){
        int middle = (start + end) / 2, pointX = start, pointY = middle;
        ArrayList<String> array = new ArrayList<>();
        while (pointX < middle && pointY < end){
            String first = genes.getNode(pointX), second = genes.getNode(pointY);
            if (first.compareTo(second) <= 0){
                array.addNode(first);
                pointX++;
            }else{
                array.addNode(second);
                pointY++;
            }
        }
        while (pointX < middle) array.addNode(genes.getNode(pointX++));
        while (pointY < end) array.addNode(genes.getNode(pointY++));
        for (int i = 0; i < end - start; i++) genes.replaceNode(array.getNode(i), i + start);
    }

    private boolean BS(String s){
        int l = 0, r = genes.size() - 1;
        while (l <= r){
            int m = (l + r) / 2;
            String temp = genes.getNode(m);
            if (s.compareTo(temp) == 0) return true;
            else if (s.compareTo(temp) > 0) l = m + 1;
            else r = m - 1;
        }
        return false;
    }
}