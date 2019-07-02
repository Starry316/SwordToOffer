package sword2offer.q2;

/**
 * @Author starry
 * 实现一个单例模式
 * 懒汉式较简单理解 线程安全 效率不高 但是可以延时加载
 * 之后对jvm有认识后再补充其他的
 *
 */
public class Q2 {
    // 私有构造函数
    private Q2(){}

    // 懒汉式 声明时不创建。需要时创建
    private static Q2 singleton;

    public static synchronized Q2 getSinleton(){
        if (singleton == null){
            singleton = new Q2();
        }
        return singleton;
    }

    // 方法2 静态内部类
//    private static class SingletonClassInstance{
//        private static final SingletonDemo3 instance=new SingletonDemo3();
//    }
//
//    private SingletonDemo3(){}
//
//    public static SingletonDemo3 getInstance(){
//        return SingletonClassInstance.instance;
//    }


//    方法3 枚举实现单例
//    public enum SingletonDemo4 {
//
//        //枚举元素本身就是单例
//        INSTANCE;
//
//        //添加自己需要的操作
//        public void singletonOperation(){
//        }
//    }
}
