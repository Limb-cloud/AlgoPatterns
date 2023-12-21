package org.example.patterns;

interface IteratorImpl {
    boolean hasNext();
    Object next();
}

interface Container {
    IteratorImpl getIterator();
}

class NameRepository implements Container {
    public String names[] = {"John", "Mike", "Sarah", "Kate"};

    public IteratorImpl getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements IteratorImpl {

        int index;

        public boolean hasNext() {
            if(index < names.length){
                return true;
            }
            return false;
        }

        public Object next() {
            if(this.hasNext()){
                return names[index++];
            }
            return null;
        }
    }
}

public class Iterator {
    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for(IteratorImpl iter = namesRepository.getIterator(); iter.hasNext();){
            String name = (String)iter.next();
            System.out.println("Name : " + name);
        }
    }
}
