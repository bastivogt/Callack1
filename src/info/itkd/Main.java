package info.itkd;

public class Main {

    public static void main(String[] args) {
	    count(0, 10, 1, (Integer c) -> {
            System.out.println("START: " + c);
        }, (Integer c) -> {
            System.out.println("CHANGE: " + c);
        }, (Integer c) -> {
            System.out.println("FINISH: " + c);
        });

        System.out.println("---------------------------------------------------");

        count(20, 30, 2, new IAction1<Integer>() {
            @Override
            public void action(Integer p) {
                System.out.println("START_2: " + p);
            }
        }, null, null);

        System.out.println("---------------------------------------------------");

        doSomething((String name, Integer age) -> {
            System.out.println(name + ", " + age);
        });
    }

    public static void count(int start, int finish, int step, IAction1<Integer> cbStart, IAction1<Integer> cbChange, IAction1<Integer> cbFinish) {
        int count = start;
        if(cbStart != null) {
            cbStart.action(count);
        }
        for(; count < finish; count += step) {
            if(cbChange != null) {
                cbChange.action(count);
            }
        }
        if(cbFinish != null) {
            cbFinish.action(count);
        }
    }

    public static void doSomething(IAction2<String, Integer> callback) {
        for(int i = 0; i < 100; i += 10) {
            System.out.println(i);
        }
        if(callback != null) {
            callback.action("Basti", 41);
        }
    }
}
