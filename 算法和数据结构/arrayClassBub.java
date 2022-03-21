package array;

public class review01 {
    // 程序执行的入口 用来测试
    public static void main(String[] args) {
        ArrayClassBub arrayClassBub = new ArrayClassBub(100);

        // 新增数组元素
        arrayClassBub.insert(11);
        arrayClassBub.insert(23);
        arrayClassBub.insert(45);
        arrayClassBub.insert(21);
        arrayClassBub.insert(66);
        arrayClassBub.insert(44);
        arrayClassBub.insert(77);
        arrayClassBub.insert(99);
        arrayClassBub.insert(88);

        arrayClassBub.display();
        // 冒泡排序的执行
        arrayClassBub.bubsort();
        arrayClassBub.display();

    }
}

// 构建一个无序数组
// 创建一个数组封装的类
class ArrayClassBub {
    private long[] arr;// 定义一个长整型的数组
    private int nElems;// 定义元素的个数，也就是当前数组的长度

    // 通过数组类的构造方法对数组和元素初始化
    public ArrayClassBub(int maxSize) {// maxSize是数组的最大的长度
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

    // 实现冒泡排序算法，为无序数组排序，从小到大
    public void bubsort() {
        // 定义外边界和内边界
        int outer;
        int inner;
        for (outer = nElems - 1; outer > 1; outer--) {
            for (inner = 0; inner < outer; inner++) {
                if (arr[inner] > arr[inner + 1]) {// 前面的元素比后面的元素大，交换位置
                    long temp = arr[inner];
                    arr[inner] = arr[inner + 1];
                    arr[inner + 1] = temp;

                }
            }
            inner = 0;// 在outer--之间 让inner重新初始化让inner回到第一个元素上去
        }

    }

}
