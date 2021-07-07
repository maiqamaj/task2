package jo.secondstep.sort;

public class SortAlgorithm implements Sort {
	public static void main(String[] arge) {

		System.out.print("Sort Algorithm\n");
		int[] data = new int[] { 8, 2, 6, 10, 7, 4 };
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
		SortAlgorithm Array = new SortAlgorithm();
		// System.out.print("Quick Sort Algorithm\n");
		// Array.QuickSort(data, 0, data.length - 1);
		// System.out.print("Bubble Sort Algorithm\n");
		// Array.BubbleSort(data,data.length);
		System.out.print("Marge Sort Algorithm\n");
		Array.MargeSort(data, 0, data.length - 1);
		// System.out.print("Selection Sort Algorithm\n");
		// Array.SelectionSort(data);
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}

	}

	@Override
	public void QuickSort(int[] data, int start, int end) {
		int pivot = end;
		int i = start - 1;
		int j = start;
		if (end - start <= 0) {
			return;
		}
		while (j < pivot) {
			if (data[j] < data[pivot]) {
				i++;
				int item = data[i];
				data[i] = data[j];
				data[j] = item;

			}
			j++;

		}

		int pivotvalue = data[pivot];
		for (int k = end; k > i + 1; k--) {
			data[k] = data[k - 1];
		}
		data[i + 1] = pivotvalue;

		if (i != -1) {
			QuickSort(data, start, i);
		}

		if (i + 2 <= end) {
			QuickSort(data, i + 2, end);
		}

	}

	@Override
	public void BubbleSort(int[] data, int size) {
		if (size == 1)
			return;

		for (int i = 0; i < size - 1; i++) {
			int max = data[i];
			int item = data[i + 1];
			if (max > data[i + 1]) {
				data[i + 1] = max;
				data[i] = item;
			}
		}
		BubbleSort(data, --size);
	}

	@Override
	public void MargeSort(int[] data, int left, int rigth) {
		if (left < rigth) {
			int middle = left + (rigth - left) / 2;
			MargeSort(data, left, middle);
			MargeSort(data, middle + 1, rigth);

			Marge(data, left, rigth, middle);

		}

	}

	public void Marge(int[] data, int left, int rigth, int middle) {

		int sizeSubArray1 = middle - left + 1;
		int sizeSubArray2 = rigth - middle;
		int[] SubArray1 = new int[sizeSubArray1];
		int[] SubArray2 = new int[sizeSubArray2];

		for (int i = 0; i < sizeSubArray1; i++) {
			SubArray1[i] = data[left + i];
		}

		for (int i = 0; i < sizeSubArray2; i++) {
			SubArray2[i] = data[middle + 1 + i];
		}
		int i = 0, j = 0;
		int k = left;
		for (; i < sizeSubArray1 && j < sizeSubArray2;) {
			if (SubArray1[i] <= SubArray2[j]) {
				data[k] = SubArray1[i];
				i++;
			} else {
				data[k] = SubArray2[j];
				j++;
			}
			k++;
		}

		for (; i < sizeSubArray1; i++) {
			data[k] = SubArray1[i];
			k++;
		}

		for (; j < sizeSubArray2; j++) {
			data[k] = SubArray2[j];
			k++;
		}

	}

	@Override
	public void SelectionSort(int[] data) {
		for (int i = 0; i < data.length; i++) {
			int min = data[i];
			int j = i + 1;
			int k = i;
			while (j < data.length) {

				if (min > data[j]) {
					min = data[j];
					k = j;
				}
				j++;
			}

			int item = data[i];
			data[i] = min;
			data[k] = item;

		}
	}

}
