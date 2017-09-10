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

### demo3 原型模式 ###

![](https://i.imgur.com/Wj5OXen.png)

	public class Person implements Cloneable {

	    public String name;
	    public ArrayList<Person> friendList;

	    @Override
	    public Person clone() throws CloneNotSupportedException {
	        return shallowCopy();
	    }

	    /**
	     * 浅拷贝
	     */
	    private Person shallowCopy() throws CloneNotSupportedException {
	        return (Person) super.clone();
	    }

	    /**
	     * 深拷贝
	     */
	    private Person deepCopy() throws CloneNotSupportedException {
	        Person person = (Person) super.clone();
	        person.friendList = (ArrayList<Person>) friendList.clone();
	        return person;
	    }
	}

### demo4 工厂方法模式 ###

![](https://i.imgur.com/XwW32FH.png)

1. 静态工厂模式/简单工厂模式

	1.1 产品抽象类

		public abstract class Product {

		    // 产品类的抽象方法,由具体的产品类进行实现
		    public abstract void showProductName();
		}

	1.2 具体产品类

		public class ConcreateProductA extends Product {

		    @Override
		    public void showProductName() {
		        System.out.println("Product A");
		    }
		}

		public class ConcreateProductB extends Product {

		    @Override
		    public void showProductName() {
		        System.out.println("Product B");
		    }
		}

	1.3 工厂抽象

		public abstract class Factory {

		    // 创建产品
		    public abstract Product createProduct();
		}

	1.4 工厂实体

		public class ConcreateFactory extends Factory {

		    @Override
		    public Product createProduct() {
		        // 生产具体的产品
		        return new ConcreateProductA();
		        // return new ConcreateProductB();
		    }
		}

	1.5 测试

		public class Client {

		    public static void main(String[] args) {
		        Factory factory = new ConcreateFactory();
		        Product product = factory.createProduct();
		        product.showProductName();
		    }
		}

2. 静态工厂模式/简单工厂模式的变种

	2.1 工厂抽象

		public abstract class Factory {

		    // 创建产品
		    public abstract <T extends Product> T createProduct(Class<T> clazz);
		}

	2.2 工厂具体

		public class ConcreateFactory extends Factory {

		    @Override
		    public <T extends Product> T createProduct(Class<T> clazz) {
		        Product p = null;
		        try {
		            p = (Product) Class.forName(clazz.getName()).newInstance();
		        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
		            e.printStackTrace();
		        }
		        return (T) p;
		    }
		}

	2.3 测试

		public class Client {

		    public static void main(String[] args) {
		        Factory factory = new ConcreateFactory();
		        Product product = factory.createProduct(ConcreateProductB.class);
		        product.showProductName();
		    }
		}

3. 多工厂模式

	3.1 方式1的变种,每个产品对应着一个工厂类

		public class ConcreateFactoryA extends Factory {

		    @Override
		    public Product createProduct() {
		        return new ConcreateProductA();
		    }
		}

		public class ConcreateFactoryB extends Factory {

		    @Override
		    public Product createProduct() {
		        return new ConcreateProductB();
		    }
		}

	3.2 测试

		public class Client {

		    public static void main(String[] args) {
		        Factory factory = new ConcreateFactoryA();
		        Product product = factory.createProduct();
		        product.showProductName();

		        factory = new ConcreateFactoryB();
		        product = factory.createProduct();
		        product.showProductName();
		    }
		}

### demo5 抽象工厂模式 ###

![](https://i.imgur.com/7YjCypT.png)

1.1 AbstractProduct -- 抽象产品

	public abstract class AbstractProductA {

	    // 每个具体产品需要实现的方法
	    public abstract void method();
	}

	public abstract class AbstractProductB {

	    // 每个具体产品需要实现的方法
	    public abstract void method();
	}

1.2 ConcreateProduct -- 具体产品

	public class ConcreateProductA1 extends AbstractProductA {

	    @Override
	    public void method() {
	        System.out.println("product A1");
	    }
	}

	public class ConcreateProductA2 extends AbstractProductA {

	    @Override
	    public void method() {
	        System.out.println("product A2");
	    }
	}

	public class ConcreateProductB1 extends AbstractProductB {

	    @Override
	    public void method() {
	        System.out.println("product B1");
	    }
	}

	public class ConcreateProductB2 extends AbstractProductB {

	    @Override
	    public void method() {
	        System.out.println("product B2");
	    }
	}

1.3 AbstractFactory -- 抽象工厂

	public abstract class AbstractFactory {

	    // 创建产品A
	    public abstract AbstractProductA createProductA();

	    // 创建产品B
	    public abstract AbstractProductB createProductB();
	}

1.4 ConcreateFactory -- 具体工厂

	public class ConcreateFactory1 extends AbstractFactory {

	    @Override
	    public AbstractProductA createProductA() {
	        return new ConcreateProductA1();
	    }

	    @Override
	    public AbstractProductB createProductB() {
	        return new ConcreateProductB1();
	    }
	}

	public class ConcreateFactory2 extends AbstractFactory {

	    @Override
	    public AbstractProductA createProductA() {
	        return new ConcreateProductA2();
	    }

	    @Override
	    public AbstractProductB createProductB() {
	        return new ConcreateProductB2();
	    }
	}

1.5 测试

	public class Client {

	    public static void main(String[] args) {

	        AbstractFactory factory = new ConcreateFactory1();
	        AbstractProductA productA = factory.createProductA();
	        AbstractProductB productB = factory.createProductB();
	        productA.method();
	        productB.method();
	    }
	}