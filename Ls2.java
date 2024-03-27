package lessons2;

public class Ls2 {
    public static void main(String[] args) {
        TestRunner.run(Ls2.class);
    }

    @Test
    public void test1() {
        System.out.println("Test 1");
    }

    @BeforeEach
    public void test2() {
        System.out.println("BeforeEach 1");
    }

    @Test
    void test3() {
        System.out.println("Test 2");
    }

    @BeforeEach
    void test4() {
        System.out.println("BeforeEach 2");
    }

    @AfterEach
    void test5() {
        System.out.println("AfterEach 1");
    }

    @AfterAll
    void test6() {
        System.out.println("AfterAll");
    }

    @BeforeAll
    void test7() {
        System.out.println("BeforeAll");
    }

    @AfterEach
    void test8() {
        System.out.println("AfterEach 2");
    }

}
