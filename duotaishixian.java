package array;

//如何体现多态
class Fu {
    // 方法
    public void print() {

    }

}

class Zi extends Fu {// 有继承关系
    public void print() {// 有方法的重写

    }

}

class Demo {
    public static void main(String[] args) {
        Fu fu = new Zi();// 父类引用指向子类的对象
    }
}
