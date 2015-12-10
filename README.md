# dagger-testng
Mean to work just like https://github.com/saden1/hk2-testng.
## dependency
Add it as a `test`-scoped dependency.
~~~xml
<dependency>
  <groupId>com.github.jinahya</groupId>
  <artifactId>dagger-testng</artifactId>
  <scope>test</scope>
</dependency>
~~~
## usage
Use it just like you would do with [`@Guice`](http://testng.org/javadoc/org/testng/annotations/Guice.html) or `@HK2`.
~~~java
@Dagger(modules = MyModule.class)
public class MyTest {

    @Test
    public void test() {
    }

    @Inject
    String name;
}
~~~
