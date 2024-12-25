class outerClass{
    int x = 10;

    class innerClass1{
        int y = 20;
        void show(){
            System.out.println("innerClass1's method - accessing from outerClass's method & static main method + accessing outClass's members (x): " + x);
        }
    }

    void display1(){
        innerClass1 inc1 = new innerClass1();
        inc1.show();
    }

    static class innerClass2{
        int x = 30;
        void show(){
            System.out.println("Static innerClass2's method - accessing from outerClass's method & static main method (x): " + x);
        }
    }

    void display2(){
        innerClass2 ic2 = new innerClass2();
        ic2.show();
    }

    private class innerClass3{
        int z = 20;
        void show(){
            System.out.println("private innerClass3's method - accessing from outerClass's method (z): " + z);
        }
    }

    void display3(){
        innerClass3 inc3 = new innerClass3();
        inc3.show();
    }
}

public class JavaClasses {
    public static void main(String[] args) {
        outerClass oc = new outerClass();
        outerClass.innerClass1 ic1 = oc.new innerClass1();
        ic1.show();
        oc.display1();

        outerClass.innerClass2 ic2 = new outerClass.innerClass2();
        ic2.show();
        oc.display2();

        // Error: innerClass3 has private access in outerClass
        // outerClass.innerClass3 ic3 = oc.new innerClass3();
        // ic3.show();
        // System.out.println("Accessing private innerClass3's member (z):" + ic3.z);
        oc.display3();
    }
}