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
        return add(size, value);
    };
    public boolean add(int index, String value){
        if (index <= size || index < 0){
            if (start != null){
                if (index == size){
                    // append item
                    Node hold = new Node(value);
                    end.setNext(hold);
                    hold.setPrev(end);
                    end = hold;                    
                }
                else if (index == 0){
                    // inset at 0
                    Node hold = new Node(value);
                    start.setPrev(hold);
                    hold.setNext(start);
                    start = hold;                    
                }
                else{
                    // search to insert ele
                    Node pointer = start;
                    for (int i = 0; i < index; i++){
                        pointer = pointer.getNext();
                    }
                    Node hold = new Node(value);
                    hold.setPrev(pointer.getPrev());
                    hold.setNext(pointer);
                    pointer.getPrev().setNext(hold);
                    pointer.setPrev(hold);
                }
            }
            else{
                // add node as the only value
                Node hold = new Node(value);
                start = hold;
                end = hold;
                size += 1;
                return true;
            }
            
        }else{
            throw new IndexOutOfBoundsException();
        }
        return true;
    };
    public String get(int index){
        if (index <= size || index < 0){
            Node pointer = start;
            for (int i = 0; i < index; i++){
                pointer = pointer.getNext();
            }
            return pointer.getData();
        }else{
            throw new IndexOutOfBoundsException();
        }
    };
    public String set(int index, String value){
        if (index <= size || index < 0){
            Node pointer = start;
            for (int i = 0; i < index; i++){
                pointer = pointer.getNext();
            }
            String hold = pointer.getData();
            Node myNew = new Node(value);
            pointer.getNext().setPrev(myNew);
            pointer.getPrev().setNext(myNew);
            pointer = myNew; // does this change all the pointers before, after
            return hold;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
    public String toString(){
        Node pointer = start;
        String result = "[";
        for (int i = 0; i < size; i++){
            result += pointer.getData();
            pointer = pointer.getNext();
            result += ", ";
        }
        return result.substring(0, result.length() - 1) + "]";
    };
    //Any helper method that returns a Node object MUST BE PRIVATE!
   }