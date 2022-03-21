package array;

public class review02 {
    // 程序的入口
    public static void main(String[] args) {
        OrderArray orderArray = new OrderArray(100);
        orderArray.insert(15);
        orderArray.insert(44);
        orderArray.insert(55);
        orderArray.insert(22);

        orderArray.display();
        System.out.println(orderArray.find(22));
        orderArray.delete(22);
        orderArray.display();

    }
}

// 封装一个数组
class OrderArray {
    // 定义
    private long[] arr;
    private int nElems;

    // OrderArray的构造方法初始化数组
    public OrderArray(int maxSize) {
        arr = new long[maxSize];
        nElems = 0;
    }

    // 插入一个新的数据项
    public void insert(long data) {
        // 找到插入数据的位置
        int i;
        for (i = 0; i < nElems; i++) {
            if (arr[i] > data) {
                break;
            }
        }
        // 找到和没有找到
        if (i < nElems) {// 找到的情况
            for (int j = nElems; j > i; j--) {
                if (j < arr.length) {
                    arr[j] = arr[j - 1];
                }
            }
            arr[i] = data;
            nElems++;

        } else {// 没找到
            if (nElems < arr.length) {
                arr[nElems] = data;
                nElems++;
            }

        }

    }

    // 遍历
    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    // 查找指定大的元素，二分查找算法
    // 如果找到了找到我要找的数据，返回找到数据的索引值，没找到，返回数组的当前长度
    public int find(long searchData) {
        int lowerBound = 0;
        int upperBound = nElems - 1;// 数组当前长度减一
        int curint;// 对数组进行二分时候，除再中间元素对应的索引值
        while (true) {
            curint = (lowerBound + upperBound) / 2;
            if (arr[curint] == searchData) {
                return curint;
            } else if (lowerBound > upperBound) {
                // 没有要查找的元素
                return nElems;
                // 二分
            } else {
                if (arr[curint] > searchData) {
                    upperBound = curint - 1;
                } else {
                    lowerBound = curint + 1;
                }

            }

        }
    }

    // 删除某一个指定的某一个元素
    public void delete(long data) {
        int i = find(data);// 二分查找
        if (i < nElems) {
            // 找到了
            for (int j = i; j < nElems; j++) {
                arr[j] = arr[j + 1];
            }
            nElems--;// 当前长度减一
        }

    }

}
