package hashdict;

//import java.util.LinkedList;
//Creates and implements a hash table to check spelling.

class LinkedList{
    
    private node head, tail;
    private int size;
    
    class node{
        private String    value;
        private node      link;
        private node      back;
        node(){};
        node(String value){this.value=value;}
        
        public String    getValue(){return value;}
        public void      setValue(String value){this.value=value;}
        public node      getLink(){return link;}
        public void      setLink(node link){this.link=link;}
        public node      getBack(){return back;}
        public void      setBack(node back){this.back=back;}
    }
    
    public LinkedList(){};
    public int getSize(){return size;}
    public void add(String s) {
        node temp;
        temp = new node(s);
        if(size==0) head=temp;
        else tail.setLink(temp);
        tail=temp;
        size++;
    }
    
    public boolean contains(String s) {
        node temp;
        temp = head;
        if (size==0) return false;
        while(temp!=null) {
            if (temp.getValue().equalsIgnoreCase(s)) return true;
            temp=temp.getLink();
        }
        return false;
    }
}

public class HashTable {
    LinkedList[] hashtable;
    private final int size;
    
    HashTable(){
        //Constructor that implements a hash table with a default of 1000 items.
        size = 1000;
        hashtable = new LinkedList[size];
    }
    
    HashTable(int n){
        //overloaded constructor
        size = n;
        hashtable = new LinkedList[size];
        for(int i = 0; i < size; i++) {
            hashtable[i] = new LinkedList();
        }
    }
    
    public long pow(long a, long b) {
        int c;
        c=1;
        for(int i = 0; i < b; i++) {
            c*=a;
        }
        return c;
    }
    
    public long hashVal(String s){
        //generates the hash value for the word.
        long total, exponent, cNum;
        char c;

        total = 0;
        
        for(int i = 0; i < s.trim().length(); i++){
            switch(i%4) {
                case(0): exponent=3; break;
                case(1): exponent=2; break;
                case(2): exponent=1; break;
                case(3): exponent=0; break;
                default: exponent=-1; //never happens
            }
            c = s.toLowerCase().trim().charAt(i);
            cNum = (int) c;
            if(cNum == 39){ // for apostrophe
                cNum = 27;
            }
            else if(cNum == 45) //for hyphen
                cNum = 28;
            else if (cNum == 44){ //for comma
                cNum=0;
            }
            else
            cNum = cNum - 96;
            total = pow(31,exponent) * cNum + total;
        }
        return total;
    }
    
    public void insert(String s){
        //Places the word into the hash table.
        int index;
        index = (int)hashVal(s)%size;
        hashtable[index].add(s);
    }
    
    public boolean contains(String s){
        //checks to see if the word is in the hash table.
        int index;
        boolean check;
        index = (int)(hashVal(s)%size);
        if(index<0) return false;
        check = hashtable[index].contains(s);
        return check;
    }
    
    public int count(){
        //counts the number of items in the spell check dictionary.
        int count = 0;
        for(int i = 0; i < size; i++){
            if (hashtable[i] != null)
                count = count + hashtable[i].getSize();
        }
        return count;
    }
}
