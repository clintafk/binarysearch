public class BinarySearch {
    int[] arr = {2,4,6,8,9,10,20,33,44,45,68,88,0,0};
    int loc; 

    public boolean binary_search(int el) {
        int[] list = arr;
        int first=0, last=list.length-1, mid=-1;
        boolean found = false;

        while (first<=last && !found) {
            mid = (first+last)/2;
            if (list[mid] == el) found = true;
            else if (list[mid] > el) last = mid-1;
            else first=mid+1;
        }

        this.loc = mid+1;
        if(found) return true;
        return false;

    }

    public void delete(int el) {
        if (binary_search(el)) {
            int newLen = 0;

            for(int i: this.arr) {
                if (i == 0) break;
                newLen += 1;
            }

            for(int i=loc-1; i<=newLen; i++) {
                this.arr[i] = arr[i+1];
            }

            System.out.println(el+" is removed from the list.");
        }
        else System.out.println(el+ " is not found in the list."); 
    }

    public void search(int el) {
        if (binary_search(el)) System.out.println(el + " is found at location " + this.loc + ".");
        else System.out.println(el+ " is not found in the list."); 
    }

    public void display() {
        System.out.print("Elements of the list: ");

        for(int el: this.arr) {
            if (el==0) break;
            System.out.print(el+" ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        BinarySearch myObj = new BinarySearch();

        myObj.search(8);
        myObj.search(45);
        myObj.search(88);
        myObj.search(90);
        myObj.delete(9);

        myObj.display();
    }
}
