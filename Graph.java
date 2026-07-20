package Graph;

public class Graph {
    int size;
    String[] vertices;
    boolean[][] a;//adjancency matrix

    public Graph(String[] args) {
        size = args.length;
        vertices = new String[size];
        a = new boolean[size][size];
        System.arraycopy(args,0,vertices,0,size);
    }

    public void add(String v,String w){
        int i = index(v), j = index(w);
        a[i][j]= a[j][i] = true;
    }

    private int index(String v){
        for(int i=0; i<size ; i++)
            if(vertices[i].equals(v))
            return i;
            return a.length;
    }

    public String toString(){
        StringBuffer buff =new StringBuffer("{"+ vertex(0));
        for(int i=1; i<size; i++)
            buff.append(","+vertex(i));
            return buff + "}";
    }

    private String vertex(int i){
        StringBuffer buf = new StringBuffer(vertices[i]+":");
        for(int j=0; j<size; j++)
            if(a[i][j])
                buf.append(vertices[j]);
            return buf+ " ";
    }

    public static void main(String[] args) {
        String[] vertices = { "A", "B", "C", "D" ,"E", "F","G"};
        Graph graph = new Graph(vertices);

        // Add edges between vertices
        graph.add("A", "B");
        //graph.add("A", "C");
        //graph.add("A", "D");
       // graph.add("A", "F");
        graph.add("B", "C");
        //graph.add("B", "F");
        //graph.add("C", "C");
        graph.add("C", "E");
        graph.add("C", "G");
        graph.add("D", "F");
        //graph.add("D", "G");
        graph.add("E", "F");
        //graph.add("E", "G");



        // Print the graph
        System.out.println(graph);
    }

}


