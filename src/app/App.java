package app;

public class App {
    public static void main(String[] args) throws Exception
    {
        

        int[] nums = {10, 7, 24, 43, 4, 14, 8, 47, 34, 54, 53};

        // print unsorted array
        System.out.println("Unsorted Array");
        for (int i : nums)
        {
            System.out.print(i + ", ");
        }
        System.out.println('\n');
        

        // System.out.println("Insertion Sort");
        // InsertionSort(nums);

        System.out.println("Merge Sort");
        MergeSort(nums, 0, nums.length - 1);

        for (int i : nums)
        {
            System.out.print(i + ", ");
        }
    }

    public static void InsertionSort(int[] _nums)
    {
        int key;
        int i;
        for (int j = 1; j < _nums.length; j++)
        {
            key = _nums[j];
            i = j - 1;
            while (i > -1 && _nums[i] > key)
            {
                _nums[i + 1] = _nums[i];
                i -= 1;
            }
            _nums[i + 1] = key;
        }
    }

    public static void Merge(int[] _nums, int l, int m, int r)
    {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;

        // create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // load temp arrays
        for(i = 0; i < n1; i++)
        {
            L[i] = _nums[l + i];
        }
        for(j = 0; j < n2; j++)
        {
            R[j] = _nums[m + 1 + j];
        }

        // reset indices
        i = 0;
        j = 0;
        k = l;

        // merge the temp arrays
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                _nums[k] = L[i];
                i++;
            }
            else
            {
                _nums[k] = R[j];
                j++;
            }

            k++;
        }

        // copy any leftovers
        while (i < n1)
        {
            _nums[k] = L[i];
            i++;
            k++;
        }
        while (j < n2)
        {
            _nums[k] = R[j];
            j++;
            k++;
        }
    }

    public static void MergeSort(int[] _nums, int l, int r)
    {
        if (l < r)
        {
            int m = (l + r) / 2;
            MergeSort(_nums, l, m);
            MergeSort(_nums, m + 1, r);
            Merge(_nums, l, m, r);
        }
    }

}
