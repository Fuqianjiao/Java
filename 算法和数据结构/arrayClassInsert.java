package array;

public class review04 {
    public static void main(String[] args) {
        ArrayClassInsert arrayClassInsert = new ArrayClassInsert(100);

        // 新增数组元素
        arrayClassInsert.insert(11);
        arrayClassInsert.insert(23);
        arrayClassInsert.insert(45);
        arrayClassInsert.insert(21);
        arrayClassInsert.insert(66);
        arrayClassInsert.insert(44);
        arrayClassInsert.insert(77);
        arrayClassInsert.insert(99);
        arrayClassInsert.insert(88);

        arrayClassInsert.display();
        arrayClassInsert.insertSort();// 执行插入排序
        arrayClassInsert.display();

    }

}

// 构建一个无序数组
// 创建一个数组封装的类
class ArrayClassInsert {
    private long[] arr;// 定义一个长整型的数组
    private int nElems;// 定义元素的个数，也就是当前数组的长度

    // 通过数组类的构造方法对数组和元素初始化
    public ArrayClassInsert(int maxSize) {// maxSize是数组的最大的长度
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

    // 实现插入排序算法，从小到大的排序
    public void insertSort() {
        int outer;
        int inner;
        long temp;
        for (outer = 1; outer < nElems; outer++) {// 开始的时候outer定位在第二个元素
            inner = outer;// 初始化一起
            temp = arr[outer];// outer指向的数组元素放在temp的临时变量里面
            while (inner > 0 && arr[inner - 1] > temp) {
                arr[inner] = arr[inner - 1];
                --inner;// 先减后操作

            }
            // 把开始拿走的数据插回来
            arr[inner] = temp;

        }
    }

}
