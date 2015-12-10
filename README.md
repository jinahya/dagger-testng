# dagger-testng
[![Dependency Status](https://www.versioneye.com/user/projects/56694ea643cfea0032000073/badge.svg)](https://www.versioneye.com/user/projects/56694ea643cfea0032000073)
[![Build Status](https://travis-ci.org/jinahya/dagger-testng.svg)](https://travis-ci.org/jinahya/dagger-testng)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.jinahya/dagger-testng.svg)](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22dagger-testng%22)

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
