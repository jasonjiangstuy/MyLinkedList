public class MyLinkedList{
    private int size;
    private Node start,end;  
    public MyLinkedList(){/*create a constructor*/
        // for a empty list
        size = 0;    
    }
   
    public int size(){
        return size;
    };
    public boolean add(String value){

    };
    public boolean add(int index, String value){
        if (index <= size || index < 0){
            if (start != null){

            }
            else{
                Node hold = new Node(value);
            }
        }else{
            throw new IndexOutOfBoundsException();
        }
    };
    public String get(int index);
    public String set(int index, String value);
    public String toString();
    //Any helper method that returns a Node object MUST BE PRIVATE!
   }