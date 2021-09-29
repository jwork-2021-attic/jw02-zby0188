package task2;

public class SelectionSorter implements Sorter {

    private int[] a;

    @Override
    public void load(int[] a) {
        this.a = a;
    }

    private void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + a[i] + "<->" + a[j] + "\n";
    }

    private String plan = "";

    @Override
    public void sort() {
        for(int i = 0; i < a.length - 1; i++) {
            int k = i;
            for(int j = k + 1; j < a.length; j++){
                if(a[j] < a[k]){ 
                    k = j;
                }
            }
            if(i != k){
                swap(i,k);
            }    
        }
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

}
