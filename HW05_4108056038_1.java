public class HW05_4108056038_1 extends LLK {
    public static void main(String[] args) {
        HW05_4108056038_1 test = new HW05_4108056038_1();
        int[][] a = new int[][] {{1,1},{3,2},{3,3}};
        System.out.println(test.checkLLK(a));
    }
    public boolean checkLLK(int[][] array) {
        int i,j,k;
        int len=array.length;
        double[] slope = new double[len];
        for(i=len-1;i>=0;i--) {
            k=0;
            for(j=i-1;j>=0;j--) {
                slope[k++] = (double)(array[i][1]-array[j][1])/(array[i][0]-array[j][0]);
            }

            qsort(slope,0,k-1);

            for(j=0;j<k-1;j++) {
                if(slope[j]==slope[j+1]) {
                    return true;
                }
            }
        }
        return false;
    }

    private void qsort (double[] A,int l,int r) {
        double temp,p;
        int i,j;
        if(l<r) {
            i=l;
            j=r+1;
            p=A[l];
            do {
                do {
                   i++;
                   if(i>=A.length) break;
                }while(A[i]<p);
                do {
                    j--;
                    if(j<0) break;
                } while(A[j]>p);
                if(i<j) {
                    temp=A[i];
                    A[i]=A[j];
                    A[j]=temp;
                }
            }while (i<j);
            temp=A[l];
            A[l]=A[j];
            A[j]=temp;
            qsort(A,l,j-1);
            qsort(A,j+1,r);
        }      
    }
}