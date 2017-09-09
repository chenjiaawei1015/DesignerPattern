# 目录 #

### demo1 单例模式 ###

![](https://i.imgur.com/AXS6jfS.png)

1. 恶汉模式

		public class Person1 {

	    	private static Person1 sPerson1 = new Person1();

	    	private Person1() {
	    	}

	    	public static Person1 getInstance() {
	    	    return sPerson1;
	    	}
		}

2. 懒汉模式

		public class Person2 {

		    private static Person2 sPerson;

		    private Person2() {
		    }

		    public static synchronized Person2 getInstance() {
		        if (sPerson == null) {
		            sPerson = new Person2();
		        }
		        return sPerson;
		    }
		}

3. DCL

		public class Person3 {

		    private static Person3 sPerson;

		    private Person3() {
		    }

		    public static Person3 getInstance() {
		        if (sPerson == null) {
		            synchronized (Person3.class) {
		                if (sPerson == null) {
		                    sPerson = new Person3();
		                }
		            }
		        }
		        return sPerson;
		    }
		}

4. 静态内部类

		public class Person4 {

		    private Person4() {
		    }

		    public static Person4 getInstance() {
		        return PersonInstance.sInstance;
		    }

		    private static class PersonInstance {
		        static Person4 sInstance = new Person4();
		    }

		}

5. 枚举

		public enum Person5 {
		    INSTANCE
		}

6. 容器

		public class InstanceManager {

		    // 程序的开始,将多个单例类型进行注入到统一的管理类中

		    private static Map<String, Object> mInstanceMap = new HashMap<>();

		    private InstanceManager() {
		    }

		    public static void registerInstance(String key, Object instance) {
		        if (!mInstanceMap.containsKey(key)) {
		            mInstanceMap.put(key, instance);
		        }
		    }

		    public static Object getInstance(String key) {
		        return mInstanceMap.get(key);
		    }
		}

### demo2 建造者模式 ###

![](https://i.imgur.com/svEDWTc.png)

1. Product -- 抽象产品类

		public abstract class Computer {

		    // 主机
		    protected String mBoard;
		    // 显示器
		    protected String mDisplay;
		    // 操作系统
		    protected String mOs;

		    protected Computer() {
		    }

		    public void setBoard(String board) {
		        mBoard = board;
		    }

		    public void setDisplay(String display) {
		        mDisplay = display;
		    }

		    public abstract void setOs();
		}

2. 产品实体类

		public class MacBook extends Computer {

		    @Override
		    public void setOs() {
		        mOs = "Mac OS X 10.10";
		    }
		}

3. Builder -- 抽象Builder类,规范产品的组件

		public abstract class Builder {

		    // 设置主机
		    public abstract void buildBoard(String board);

		    // 设置显示器
		    public abstract void buildDisplay(String display);

		    // 设置操作系统
		    public abstract void buildOs();

		    // 创建电脑
		    public abstract Computer create();
		}

4. ConcreateBuilder -- 具体的Builder类,负责具体的组件过程

		public class MacBookBuilder extends Builder {

		    private Computer mComputer = new MacBook();

		    @Override
		    public void buildBoard(String board) {
		        mComputer.setBoard(board);
		    }

		    @Override
		    public void buildDisplay(String display) {
		        mComputer.setDisplay(display);
		    }

		    @Override
		    public void buildOs() {
		        mComputer.setOs();
		    }

		    @Override
		    public Computer create() {
		        return mComputer;
		    }
		}

5. Director -- 统一组装过程

		public class Director {

		    private Builder mBuilder;

		    public Director(Builder builder) {
		        mBuilder = builder;
		    }

		    public Computer construct(String board, String display) {
		        mBuilder.buildBoard(board);
		        mBuilder.buildDisplay(display);
		        mBuilder.buildOs();
		        return mBuilder.create();
		    }
		}

6. 测试类

		public class Test {

		    public static void main(String[] args) {
		        Builder builder = new MacBookBuilder();
		        Director director = new Director(builder);
		        Computer computer = director.construct("英特尔主机", "三星显示器");
		    }
		}
