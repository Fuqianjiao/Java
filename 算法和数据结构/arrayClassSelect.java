package array;

public class review03 {
    public static void main(String[] args) {
        ArrayClassSelect arrayClassSelect = new ArrayClassSelect(100);
        // 新增数组元素
        arrayClassSelect.insert(11);
        arrayClassSelect.insert(23);
        arrayClassSelect.insert(45);
        arrayClassSelect.insert(21);
        arrayClassSelect.insert(66);
        arrayClassSelect.insert(44);
        arrayClassSelect.insert(77);
        arrayClassSelect.insert(99);
        arrayClassSelect.insert(88);

        arrayClassSelect.display();
        arrayClassSelect.selectSort();// 执行选择排序
        arrayClassSelect.display();

    }

}

// 构建一个无序数组
// 创建一个数组封装的类
class ArrayClassSelect {
    private long[] arr;// 定义一个长整型的数组
    private int nElems;// 定义元素的个数，也就是当前数组的长度

    // 通过数组类的构造方法对数组和元素初始化
    public ArrayClassSelect(int maxSize) {// maxSize是数组的最大的长度
        arr = new long[maxSize];// 对数组进行初始化
        nElems = 0;// 对元素长度进行初始化

    }

    // 如何新增元素
    public void insert(long data) {
        arr[nElems] = data;
        nElems++;
    }

    // 如何查找元素
    public boolean find(long searchData) {
        // 定义一个索引(如果找到就停在这个索引上)
        int i;
        // 遍历所有的元素
        for (i = 0; i < nElems; i++) {
            if (searchData == arr[i]) {
                break;
            }
        }
        if (i == nElems) {
            return false;
        } else {
            return true;
        }
    }

    // 如何删除元素
    public void delete(long targetData) {
        int i;
        for (i = 0; i < nElems; i++) {
            if (targetData == arr[i]) {
                break;
            }
        }
        if (i == nElems) {
            System.out.println("没有找到要删除的数据:" + targetData);
        } else {
            // 把后面的那个元素移到前面
            for (int j = i; j < nElems; j++) {
                arr[j] = arr[j + 1];
            }
            nElems--;
        }
    }

    // 如何遍历元素
    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 实现选择排序算法，从小到大的排序
    public void selectSort() {
        int outer;
        int inner;
        int min;
        for (outer = 0; outer < nElems - 1; outer++) {
            min = outer;// 每次循环初始化min指向outer的位置，身下的元素中的第一个
            for (inner = outer + 1; inner < nElems; inner++) {
                if (arr[min] > arr[inner]) {
                    min = inner;
                }
            } // 每次循环完后，min指向的元素
              // 找到最小元素后，和outer指向的元素交换位置
            long temp = arr[outer];
            arr[outer] = arr[min];
            arr[min] = temp;
        }
    }
}
