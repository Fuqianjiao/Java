package array.Leecode;

public class xishu {
    public static void main(String[] args) {
        //一般的玩法，浪费内存空间，读取数据的时候，效率更高以先，用空间换时间
        long[][] arr = new long[9][7];//创建一个二维数组，就要占用63个内存空间
        arr[1][3] = 3;
        arr[3][0] = 1;
        arr[3][1] = 4;
        arr[4][2] = 7;
        arr[5][5] = 5;
        //一般这种做法在输出显示的时候，有效率一些
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "   ");
            }
            System.out.println();
        }

        //对稀疏数组进行压缩的玩法
        Node[] nodes = new Node[6];
        nodes[0] = new Node(9, 7, 5);//第一部分
        nodes[1] = new Node(1, 1, 3);//第二部分
        nodes[2] = new Node(3, 0, 1);
        nodes[3] = new Node(3, 1, 4);
        nodes[4] = new Node(4, 2, 7);
        nodes[5] = new Node(5, 5, 5);

        System.out.println("---------对压缩后的稀疏数组进行操作，要显示出和上一般玩法一样的效果-------");
        for (int i = 0; i < nodes[0].getRow(); i++) {
            for (int j = 0; j < nodes[0].getCol(); j++) {
                //判断当前（i，j）坐标，有咩有有效的内容值，输出，没有输出0
                int k;
                //循环第二个部分
                for (k = 1; k < nodes.length; k++) {
                    if (nodes[k].getRow() == i && nodes[k].getCol() == j) {
                        break;
                    }
                    if (k < nodes.length) {//证明这里存在有效内容值
                        System.out.print(nodes[k].getVal() + "   ");

                    } else {
                        System.out.print("0   ");
                    }

                }
                System.out.println();
            }
        }
    }
}

class Node {//结点的类
    private int row;//行
    private int col;//列
    private long val;//数值

    //构造方法对三个封装的属性进行初始化
    public Node(int row, int col, long val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public long getVal() {
        return val;
    }
}
