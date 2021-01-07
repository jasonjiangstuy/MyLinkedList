public class Node{
    private String data;
    private Node next, prev;
    public Node(String value){/*create a constructor*/
        data = value;
    }
    public void setData(String d){
        data = d;
    }

    public String getData(){
        return data;
    }
    public void setNext(Node d){
        next = d;
    }

    public Node getNext(){
        return next;
    }
    public void setPrev(Node d){
        prev = d;
    }

    public Node getPrev(){
        return prev;
    }
   }