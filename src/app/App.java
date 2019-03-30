package app;

public class App {
    public static void main(String[] args) throws Exception {
        

        int[] nums = {10, 7, 24, 43, 4, 14, 8, 47, 34, 54, 53};

        int[] result;
        System.out.println("Unsorted Array");
        for (int i : nums)
        {
            System.out.print(i + ", ");
        }
        System.out.println('\n');
        System.out.println("Insertion Sort");
        result = InsertionSort(nums);

        for (int i : result)
        {
            System.out.print(i + ", ");
        }
    }

    public static int[] InsertionSort(int[] _nums)
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

        return _nums;
    }

    public static int[] MergeSort(int[] _nums, int l, int r)
    {
        if (l < r)
        {
            int m = (l + r) / 2;
            MergeSort(_nums, l, m);
            MergeSort(_nums, m + 1, r);

        }

        return _nums;
    }

}
