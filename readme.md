# 目录 #

## demo1 单例模式 ##

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

## demo2 建造者模式 ##

![](https://i.imgur.com/svEDWTc.png)

1.1 Product -- 抽象产品类

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

1.2 产品实体类

	public class MacBook extends Computer {

	    @Override
	    public void setOs() {
	        mOs = "Mac OS X 10.10";
	    }
	}

1.3 Builder -- 抽象Builder类,规范产品的组件

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

1.4 ConcreateBuilder -- 具体的Builder类,负责具体的组件过程

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

1.5 Director -- 统一组装过程

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

1.6 测试类

	public class Test {

	    public static void main(String[] args) {
	        Builder builder = new MacBookBuilder();
	        Director director = new Director(builder);
	        Computer computer = director.construct("英特尔主机", "三星显示器");
	    }
	}

## demo3 原型模式 ##

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

## demo4 工厂方法模式 ##

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

## demo5 抽象工厂模式 ##

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

## demo6 策略模式 ##

![](https://i.imgur.com/RtX1iPK.png)

1.1 Strategy -- 策略

	public interface IPriceStrategy {

	    int calculatePrice(int millis);
	}

1.2 ConcreateStrategy -- 具体策略

	public class BicyclerStrategy implements IPriceStrategy {

	    @Override
	    public int calculatePrice(int millis) {
	        return millis;
	    }
	}

	public class BusStrategy implements IPriceStrategy {

	    @Override
	    public int calculatePrice(int millis) {
	        return 2 * millis;
	    }
	}

1.3 Context -- 环境类,内部维护一个Strategy的实例

	public class Travel {

	    private IPriceStrategy mPriceStrategy;

	    public Travel(IPriceStrategy priceStrategy) {
	        mPriceStrategy = priceStrategy;
	    }

	    public int calculatePrice(int millis) {
	        return mPriceStrategy.calculatePrice(millis);
	    }
	}

1.4 测试

	public class Client {

	    public static void main(String[] args) {
	        Travel travel = new Travel(new BusStrategy());
	        int price = travel.calculatePrice(10);
	        System.out.println(price);

	        travel = new Travel(new BicyclerStrategy());
	        price = travel.calculatePrice(10);
	        System.out.println(price);
	    }
	}

## demo7 状态模式 ##

![](https://i.imgur.com/SDWTyW2.png)

1.1 State -- 状态接口

	public interface TvState {

	    // 切换频道
	    void changeChannel();
	}

1.2 ConcreateState -- 具体状态类

	public class PowerOffState implements TvState {

	    @Override
	    public void changeChannel() {
	    }
	}

	public class PowerOnState implements TvState {

	    @Override
	    public void changeChannel() {
	        System.out.println("change channel");
	    }
	}

1.3 Context --环境类,维护State的实例

	public interface PowerController {

	    // 开机
	    void powerOn();

	    // 关机
	    void powerOff();
	}

	public class TvController implements PowerController {

	    // 默认关机状态
	    private TvState mTvState = new PowerOffState();

	    @Override
	    public void powerOn() {
	        mTvState = new PowerOnState();
	        System.out.println("power on");
	    }

	    @Override
	    public void powerOff() {
	        mTvState = new PowerOffState();
	        System.out.println("power off");
	    }

	    // 下一个频道
	    public void changeChannel() {
	        mTvState.changeChannel();
	    }
	}

1.4 测试

	public class Client {

	    public static void main(String[] args) {
	        TvController controller = new TvController();
	        controller.changeChannel();

	        controller.powerOn();
	        controller.changeChannel();

	        controller.powerOff();
	        controller.changeChannel();
	    }
	}

## demo8 责任链模式 ##

![](https://i.imgur.com/aSLWlUM.png)

1.1 Handler -- 抽象处理者

	public abstract class Handler {

	    // 设置下一级的处理者
	    protected Handler mNextHandler;

	    public void setNextHandler(Handler nextHandler) {
	        mNextHandler = nextHandler;
	    }

	    // 处理请求
	    public abstract <T extends Handler> void handleRequest(Class<T> condition);
	}

1.2 ConcreateHandler -- 具体处理者

	public class ConcreateHandlerA extends Handler {

	    @Override
	    public <T extends Handler> void handleRequest(Class<T> condition) {
	        if (condition.getName().equalsIgnoreCase(ConcreateHandlerA.class.getName())) {
	            System.out.println("A work");
	        } else {
	            if (mNextHandler != null) {
	                mNextHandler.handleRequest(condition);
	            } else {
	                System.out.println("A work");
	            }
	        }
	    }
	}

	public class ConcreateHandlerB extends Handler {

	    @Override
	    public <T extends Handler> void handleRequest(Class<T> condition) {
	        if (condition.getName().equalsIgnoreCase(ConcreateHandlerB.class.getName())) {
	            System.out.println("B work");
	        } else {
	            if (mNextHandler != null) {
	                mNextHandler.handleRequest(condition);
	            } else {
	                System.out.println("B work");
	            }
	        }
	    }
	}

1.3 测试类

	public class Client {

	    public static void main(String[] args) {
	        Handler handlerA = new ConcreateHandlerA();
	        Handler handlerB = new ConcreateHandlerB();
	        Handler handlerC = new Handler() {
	            @Override
	            public <T extends Handler> void handleRequest(Class<T> condition) {
	                System.out.println("C work");
	            }
	        };

	        // 设置下一级
	        handlerA.setNextHandler(handlerB);

	        handlerA.handleRequest(handlerA.getClass());
	        handlerA.handleRequest(handlerB.getClass());
	        handlerA.handleRequest(handlerC.getClass());

	        // 输出
	        // A work
	        // B work
	        // B work
	    }
	}

## demo9 解释器模式 ##

![](https://i.imgur.com/HxbF4xl.png)

1. 角色介绍

    AbstractExpression -- 抽象表达式.声明一个抽象的解释操作父类,并定义一个抽象的解释方法,其具体的实现在各个子类解释器中完成

	TerminalExpression -- 终结符表达式.实现文法中与终结符有关的解释操作.文法中的每一个终结符都有一个具体的终结表达式与之对应

	NonterminalExpression -- 非终结符表达式.实现文法中与非终结符有关的解释操作

	Context -- 上下文环境类

	Client -- 客户类.解析表达式,构建抽象语法树,执行具体的解释操作等

2. 实现计算器的加减法

	2.1 AbstractExpression

		/**
		 * 抽象算数运算解释器
		 */
		public abstract class ArithmeticExpression {

		    // 抽象解析方法
		    public abstract int interpreter();
		}

	2.2 TerminalExpression

		/**
		 * 数字解释器
		 */
		public class NumExpression extends ArithmeticExpression {

		    private int mNum;

		    public NumExpression(int num) {
		        this.mNum = num;
		    }

		    @Override
		    public int interpreter() {
		        return this.mNum;
		    }
		}

	2.3 NonterminalExpression

		/**
		 * 运算符号抽象解释器
		 */
		public abstract class OperatorExpression extends ArithmeticExpression {

		    // 存储运算符号两边的数字解释器
		    protected ArithmeticExpression mExp1, mExp2;

		    public OperatorExpression(ArithmeticExpression exp1, ArithmeticExpression exp2) {
		        mExp1 = exp1;
		        mExp2 = exp2;
		    }
		}

		/**
		 * 加法运算抽象解释器
		 */
		public class AdditionExpression extends OperatorExpression {

		    public AdditionExpression(ArithmeticExpression exp1, ArithmeticExpression exp2) {
		        super(exp1, exp2);
		    }

		    @Override
		    public int interpreter() {
		        return mExp1.interpreter() + mExp2.interpreter();
		    }
		}

		/**
		 * 减法运算抽象解释器
		 */
		public class SubtractionExpression extends OperatorExpression {

		    public SubtractionExpression(ArithmeticExpression exp1, ArithmeticExpression exp2) {
		        super(exp1, exp2);
		    }

		    @Override
		    public int interpreter() {
		        return mExp1.interpreter() - mExp2.interpreter();
		    }
		}

	2.4 Client

		/**
		 * 处理和解释相关的一些业务
		 */
		public class Calculator {

		    private Stack<ArithmeticExpression> mExpStack = new Stack<>();

		    public Calculator(String expression) {
		        // 两个临时变量,存储运算符左右两边的解释器
		        ArithmeticExpression exp1, exp2;

		        // 根据空格分割表达式字符串
		        String[] elements = expression.split(" ");

		        for (int i = 0; i < elements.length; i++) {
		            // 判断运算符号
		            switch (elements[i].charAt(0)) {
		                case '+':
		                    // 加号运算符
		                    // 将栈中的解释器弹出作为运算符左边的解释器
		                    exp1 = mExpStack.pop();
		                    // 将运算符号数组下标下一个元素构造为一个数字解释器
		                    exp2 = new NumExpression(Integer.valueOf(elements[++i]));
		                    // 通过上面两个数字解释器构造加号运算解释器
		                    mExpStack.push(new AdditionExpression(exp1, exp2));
		                    break;

		                case '-':
							// 减号运算符
		                    // 将栈中的解释器弹出作为运算符左边的解释器
		                    exp1 = mExpStack.pop();
		                    // 将运算符号数组下标下一个元素构造为一个数字解释器
		                    exp2 = new NumExpression(Integer.valueOf(elements[++i]));
		                    // 通过上面两个数字解释器构造减号运算解释器
		                    mExpStack.push(new SubtractionExpression(exp1, exp2));
		                    break;

		                default:
		                    // 为数字
		                    // 直接构造数字解释器并压入堆栈
		                    mExpStack.push(new NumExpression(Integer.valueOf(elements[i])));
		                    break;
		            }
		        }
		    }

		    // 计算最终结果
		    public int calculate() {
		        return mExpStack.pop().interpreter();
		    }
		}

	2.5 测试类

		public class Client {

		    public static void main(String[] args) {
		        Calculator calculator = new Calculator("10 + 15 - 5 - 10 + 20");
		        int num = calculator.calculate();
		        System.out.println(num);
		    }
		}

## demo10 命令模式 ##

![](https://i.imgur.com/MlreLNL.png)

1. 角色介绍

	Receiver -- 接收者角色.这个类负责具体实施或执行一个请求

	Command -- 命令角色.定义所有具体命令类的抽象接口

	ConcreteCommand -- 具体命令角色.这个类实现了 Command 接口,在 execute 方法中调用接收者角色的相关方法,在接收者和命令执行的具体行为之间加以弱耦合

	Invoker -- 请求者角色.职责是调用命令对象执行的具体请求

	Client -- 客户端角色

2. 模板代码

	2.1 接收者

		public class Receiver {

		    // 真正执行具体命令逻辑的方法
		    public void action() {
		        System.out.println("执行具体操作");
		    }
		}

	2.2 抽象命令接口

		public interface Command {

		    // 执行具体操作的命令
		    void execute();
		}

	2.3 具体命令类

		public class ConcreteCommand implements Command {

		    // 持有一个对接收者对象的引用
		    private Receiver mReceiver;

		    public ConcreteCommand(Receiver receiver) {
		        mReceiver = receiver;
		    }

		    @Override
		    public void execute() {
		        // 调用接收者的相关方法来执行具体逻辑
		        mReceiver.action();
		    }
		}

	2.4 请求者类

		public class Invoker {

		    // 持有一个对相应命令对象的引用
		    private Command mCommand;

		    public Invoker(Command command) {
		        mCommand = command;
		    }

		    public void action() {
		        // 调用具体命令对象的相关方法,执行具体命令
		        mCommand.execute();
		    }
		}

	2.5 客户类

		public class Client {

		    public static void main(String[] args) {
		        // 构造一个接收者对象
		        Receiver receiver = new Receiver();
		        // 根据接收者对象构造命令对象
		        Command command = new ConcreteCommand(receiver);
		        // 根据具体的对象构造请求者对象
		        Invoker invoker = new Invoker(command);
		        // 执行请求方法
		        invoker.action();
		    }
		}

### demo11 观察者模式 ###

![](https://i.imgur.com/B0xH516.png)

1. 角色关系

	Subject -- 抽象主题,也就是被观察者角色.抽象主题负责把所有观察者对象的引用保存到一个集合中,每个主题都可以有任意数量的观察者,主要提供一个接口,可以增加和删除观察者对象

	ConcreteSubject -- 具体主题,该角色将有关状态存入具体观察者对象,在具体主题的内部状态发生改变时,给所有注册过的观察者发送通知

	Observer -- 抽象观察者,是观察者的抽象类,定义了一个接口,使得在得到主题的更改通知时更新自己

	ConcreteObserver -- 具体观察者

2. 模板代码

	2.1 Subject

		public abstract class Subject {

		    abstract void notifyObservers(Object object);

		    abstract void addObserver(Observer observer);

		    abstract void removeObserver(Observer observer);
		}

	2.2 ConcreateSubject

		public class ConcreteSubject extends Subject {

		    private List<Observer> mObserverList = new ArrayList<>();

		    @Override
		    void notifyObservers(Object object) {
		        for (Observer observer : mObserverList) {
		            observer.update(object);
		        }
		    }

		    @Override
		    void addObserver(Observer observer) {
		        mObserverList.add(observer);
		    }

		    @Override
		    void removeObserver(Observer observer) {
		        mObserverList.remove(observer);
		    }
		}

	2.3 Observer

		public interface Observer {

		    void update(Object object);
		}

	2.4 ConcreateObserver

		public class ConcreteObserver implements Observer {

		    @Override
		    public void update(Object object) {
		        System.out.println(object);
		    }
		}

## demo12 备忘录模式 ##

![](https://i.imgur.com/dDosfW4.png)

1. 角色关系

	Originator -- 负责创建一个备忘录,记录恢复自身内部状态.同时 Originator 还可以根据需要决定 Memento 自身的哪些内部状态

	Memento -- 备忘录角色,用于存储 Originator 的内部状态,并且可以防止 Originator 以外的对象访问 Memoto

	Caretaker -- 负责存储备忘录,不能对备忘录的内容进行操作和访问,只能够将备忘录传递给其他对象

2. 简单模板

    	public class Originator {

		    private String state;

		    public Memento createMemento() {
		        return new Memento(state);
		    }

		    public void restoreMemento(Memento memento) {
		        this.state = memento.getState();
		    }

		    public String getState() {
		        return state;
		    }

		    public void setState(String state) {
		        this.state = state;
		        System.out.println("当前状态：" + this.state);
		    }
		}

		public class Memento {

		    private String state;

		    public Memento(String state){
		        this.state = state;
		    }

		    public String getState() {
		        return state;
		    }

		    public void setState(String state) {
		        this.state = state;
		    }
		}

		public class Caretaker {

		    private Memento memento;

		    public Memento retrieveMemento() {
		        return this.memento;
		    }

		    public void saveMemento(Memento memento) {
		        this.memento = memento;
		    }
		}

		public class Client {

		    public static void main(String[] args) {
		        Originator o = new Originator();
		        Caretaker c = new Caretaker();

		        o.setState("On");
		        c.saveMemento(o.createMemento());

		        o.setState("Off");
		        o.restoreMemento(c.retrieveMemento());

		        System.out.println(o.getState());

		        // 输出结果:
		        // 当前状态：On
		        // 当前状态：Off
		        // On
		    }
		}
