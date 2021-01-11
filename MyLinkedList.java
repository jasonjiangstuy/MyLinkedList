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
        add(size, value);
        return true;
    };
    public void add(int index, String value){
        if (index <= size && index >= 0){
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
                

            }
            size += 1;
        }else{
            throw new IndexOutOfBoundsException();
        }
    };
    public String get(int index){
        if (index < size && index >= 0){
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
        if (index < size && index >= 0){
            Node pointer = start;
            for (int i = 0; i < index; i++){
                pointer = pointer.getNext();
            }
            String hold = pointer.getData();
            Node myNew = new Node(value);
            pointer.getNext().setPrev(myNew);
            pointer.getPrev().setNext(myNew);
            myNew.setPrev(pointer.getPrev());
            myNew.setNext(pointer.getNext());
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
        if (result.length() > 3){
            // System.out.println(result);
            result = result.substring(0, result.length() - 2);
        }

        return result + "]";
    };

    public String toStringReversed(){
        Node pointer = end;
        // System.out.println(pointer);
        if (pointer == null){
            return "[]";
        }

        String result = "[";
        for (int i = size; i > 0; i--){
            // System.out.println(pointer.getData());
            result += pointer.getData();
            
            pointer = pointer.getPrev();
            result += ", ";
            // System.out.println(i);
        }
        if (result.length() > 3){
            // System.out.println(result);
            result = result.substring(0, result.length() - 2);
        }
        return result + "]";
    };
    public String remove(int index){
        if (index <= size && index >= 0){
            String result;
            if (size == 1){
                // removing the final element of a list (size 1 list)
                result = start.getData();
                end = null;
                start = null;
                size -= 1;
            }
            // removing the tail
            else if (index == size){
                result = end.getData();
                end = end.getPrev();
                end.setNext(null);
                size -= 1;
            }

            // head/
            else if (index == 0){
                result = start.getData();
                start = start.getNext();
                start.setPrev(null);
                size -= 1;
            }
            // , and removing from the middle
            else{
                Node pointer = start;
                for (int i = 0; i < index; i++){
                    pointer = pointer.getNext();
                }
                pointer.getPrev().setNext(pointer.getNext());
                pointer.getNext().setPrev(pointer.getPrev());
                result = pointer.getData();
                size -= 1;
            }
            return result;
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }

    public void extend(MyLinkedList other){
        end.setNext(other.start);
        other.start.setPrev(end);
        end = other.end;
        size += other.size;
        other.size = 0;
        other.start = null;
        other.end = null;
    }    
   }