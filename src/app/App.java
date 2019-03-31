package app;

public class App {
    public static void main(String[] args) throws Exception
    {
        

        int[] nums = {10, 7, 24, 43, 4, 14, 8, 47, 34, 54, 53};
        //int[] nums = {7, 2, 1, 9};

        // print unsorted array
        System.out.println("Unsorted Array");
        for (int i : nums)
        {
            System.out.print(i + ", ");
        }
        System.out.println('\n');
        

        // System.out.println("Insertion Sort");
        // InsertionSort(nums);

        //System.out.println("Merge Sort");
        //MergeSort(nums, 0, nums.length - 1);

        System.out.println("Quick Sort");
        QuickSort(nums, 0, nums.length - 1);

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

    public static void Merge(int[] _nums, int first, int mid, int last)
    {
        int i, j, k;
        int lSize = mid - first + 1;
        int rSize = last - mid;

        // create temp arrays
        int L[] = new int[lSize];
        int R[] = new int[rSize];

        // load temp arrays
        for(i = 0; i < lSize; i++)
        {
            L[i] = _nums[first + i];
        }
        for(j = 0; j < rSize; j++)
        {
            R[j] = _nums[mid + 1 + j];
        }

        // reset indices
        i = 0;
        j = 0;
        k = first;

        // merge the temp arrays
        while (i < lSize && j < rSize)
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
        while (i < lSize)
        {
            _nums[k] = L[i];
            i++;
            k++;
        }
        while (j < rSize)
        {
            _nums[k] = R[j];
            j++;
            k++;
        }
    }

    public static void MergeSort(int[] _nums, int first, int last)
    {
        if (first < last)
        {
            int mid = (first + last) / 2;
            MergeSort(_nums, first, mid);
            MergeSort(_nums, mid + 1, last);
            Merge(_nums, first, mid, last);
        }
    }

    public static int Partition(int[] _nums, int p, int r)
    {
        int tmp;
        int x = _nums[r];
        int i = p - 1;
        for(int j = p; j < r; j++)
        {
            if (_nums[j] <= x)
            {
                i++;
                tmp = _nums[j];
                _nums[j] = _nums[i];
                _nums[i] = tmp;
            }
        }
        
        _nums[r] = _nums[i + 1];
        _nums[i+ 1] = x;
        
        return i + 1;
    }

    public static void QuickSort(int[] _nums, int p, int r)
    {
        if (p < r)
        {
            int q = Partition(_nums, p, r);
            QuickSort(_nums, p, q - 1);
            QuickSort(_nums, q + 1, r);
        }
    }
}
