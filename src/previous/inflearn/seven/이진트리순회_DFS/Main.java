package previous.inflearn.seven.이진트리순회_DFS;

public class Main {

    static Node root;

    public static void main(String[] args) {
        nodeSetting();

        System.out.print("전위탐색 시작 : ");
        beforeSearch(root);
        System.out.println();

        System.out.print("중위탐색 시작 : ");
        middleSearch(root);
        System.out.println();

        System.out.print("후위탐색 시작 : ");
        afterSearch(root);
    }

    //전위탐색
    public static void beforeSearch(Node node){
        System.out.print(node.data+" ");
        if(node.ln != null) beforeSearch(node.ln);
        if(node.rn != null) beforeSearch(node.rn);
    }

    //중위탐색
    public static void middleSearch(Node node){
        if(node.ln != null) middleSearch(node.ln);
        System.out.print(node.data+" ");
        if(node.rn != null) middleSearch(node.rn);
    }

    //후위탐색
    public static void afterSearch(Node node){
        if(node.ln != null) afterSearch(node.ln);
        if(node.rn != null) afterSearch(node.rn);
        System.out.print(node.data+" ");
    }

    public static class Node{
        int data;
        Node ln = null;
        Node rn = null;

        public Node(int data){
            this.data = data;
        }
    }

    public static void nodeSetting(){
        root = new Node(1);
        root.ln = new Node(2);
        root.rn = new Node(3);
        root.ln.ln = new Node(4);
        root.ln.rn = new Node(5);
        root.rn.ln = new Node(6);
        root.rn.rn = new Node(7);
    }
}
