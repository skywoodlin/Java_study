package basic.forUmlShow;

/**
 * Created by xjlin on 2019/1/29.
 */
public class TestClassForUML{
    TestClassForUML() {}
    public static TestClassForUML getTestClassForUML(){return new TestClassForUML();}
    private String a;
    public static class InternalPublicStaticClassForUML{}
    private static class InternalPrivateStaticClassForUML{}
    public final class TestFinalClassForUML{ }
    interface InterfaceForUML2{ }
    public static abstract class AbstractClassForUML3{ }
    public String getA(){ return a; }
    public void setA(String a){ this.a = a; }
}
class TestClassForUML2 extends TestClassForUML{ }
class TestClassForUML4 implements TestClassForUML.InterfaceForUML2{ }
class TestClassForUML5 extends TestClassForUML.AbstractClassForUML3{ }

