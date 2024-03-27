package lessons2;

import java.lang.reflect.Modifier;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestRunner {

    public static void run(Class<?> testClass) {
        final Object testObj = initTestObj(testClass);

        List<Method> listM = methodSort(testClass);

        for (Method method : listM) {

            try {
                method.invoke(testObj);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static Object initTestObj(Class<?> testClass) {
        try {
            Constructor<?> noArgsConstructor = testClass.getConstructor();
            return noArgsConstructor.newInstance();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Нет конструктора по умолчанию");
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Не удалось создать объект тест класса");
        }
    }

    private static List<Method> methodSort(Class<?> testClass) {
        int beforeEach = 1;
        int countTest = 1;
        int afterAll = 1;
        Map<String, Method> methodMap = new HashMap<>();

        for (Method testMethod : testClass.getDeclaredMethods()) {
            int modifier = testMethod.getModifiers();
            if (Modifier.isPrivate(modifier)) {
                continue;
            }
            if (testMethod.getAnnotation(Test.class) != null) {
                countTest++;
                methodMap.put("T" + String.valueOf(countTest), testMethod);
            }
            if (testMethod.getAnnotation(BeforeEach.class) != null) {
                beforeEach++;
                methodMap.put("B" + String.valueOf(beforeEach), testMethod);
            }
            if (testMethod.getAnnotation(AfterEach.class) != null) {
                afterAll++;
                methodMap.put("A" + String.valueOf(afterAll), testMethod);
            }
            if (testMethod.getAnnotation(BeforeAll.class) != null) {
                methodMap.put("S", testMethod);
            }
            if (testMethod.getAnnotation(AfterAll.class) != null) {
                methodMap.put("F", testMethod);
            }
        }
        List<Method> listM = new ArrayList<>();
        listM.add(methodMap.get("S"));
        for (int i = 0; i < methodMap.size() - 2; i++) {
            if (beforeEach > 1) {
                listM.add(methodMap.get("B" + String.valueOf(beforeEach)));
                beforeEach--;
            }
            if (countTest > 1) {
                listM.add(methodMap.get("T" + String.valueOf(countTest)));
                countTest--;
            }
            if (afterAll > 1) {
                listM.add(methodMap.get("A" + String.valueOf(afterAll)));
                afterAll--;
            }
        }
        listM.add(methodMap.get("F"));
        return listM;
    }
}
