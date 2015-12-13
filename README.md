# dagger-testng
[![GitHub license](https://img.shields.io/github/license/jinahya/dagger-testng.svg)](http://www.apache.org/licenses/LICENSE-2.0)
[![Dependency Status](https://www.versioneye.com/user/projects/56694ea643cfea0032000073/badge.svg)](https://www.versioneye.com/user/projects/56694ea643cfea0032000073)
[![Build Status](https://travis-ci.org/jinahya/dagger-testng.svg)](https://travis-ci.org/jinahya/dagger-testng)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.jinahya/dagger-testng.svg)](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22dagger-testng%22)
[![Domate via Paypal](https://img.shields.io/badge/donate-paypal-blue.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_cart&business=A954LDFBW4B9N&lc=KR&item_name=GitHub&amount=5%2e00&currency_code=USD&button_subtype=products&add=1&bn=PP%2dShopCartBF%3adonate%2dpaypal%2dblue%2epng%3aNonHosted)

means to work just like [@Guice](http://testng.org/javadoc/org/testng/annotations/Guice.html).
## dependencies
Add it as a `test`-scoped dependency.
```xml
<dependency>
  <groupId>com.github.jinahya</groupId>
  <artifactId>dagger-testng</artifactId>
  <scope>test</scope>
</dependency>
```
You, of course, should add related dependencies by yourself.
```xml
<dependency>
  <groupId>com.squareup.dagger</groupId>
  <artifactId>dagger</artifactId>
  <scope>test</scope>
</dependency>
<dependency>
  <groupId>com.squareup.dagger</groupId>
  <artifactId>dagger-compiler</artifactId>
  <scope>test</scope>
</dependency>
<dependency>
  <groupId>org.testng</groupId>
  <artifactId>testng</artifactId>
  <scope>test</scope>
</dependency>
```
## usages
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
<hr/>
[![Domate via Paypal](https://img.shields.io/badge/donate-paypal-blue.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_cart&business=A954LDFBW4B9N&lc=KR&item_name=GitHub&amount=5%2e00&currency_code=USD&button_subtype=products&add=1&bn=PP%2dShopCartBF%3adonate%2dpaypal%2dblue%2epng%3aNonHosted)
