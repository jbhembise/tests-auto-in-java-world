# Tests auto in Java world

![alt text](https://raw.githubusercontent.com/jbhembise/tests-auto-in-java-world/master/doc/java_island_terra_incognita.png "Discover Tests Auto in Java Island")

Overview of tests auto concepts and solutions in Java ecosystem.

The purpose of this project is to bootstrap and experiment a couple of libraries / frameworks concerning automatic testing.

Criteria of selection : 
- Modern / Up to date
- Popular
- Opensource projects
- Free
- Out of Spring ecosystem

Solutions out of the scope of this study (regarding above criteria) : 
- **JTest** (not free) 
- **Spring Test / Spring MockMvc** (Spring ecosystem)
- **JDave** (latest release in January 2011)
- **Jameleon** (latest release in April 2013)
- **Jester** (latest release in April 2005)
- **µJava** (latest release in June 2013)
- **Bacterio** (not existing anymore ?)
- **Jumble** (latest release in May 2015)
- **Judy** (latest release in February 2014)
- **Jakarta Cactus** (latest release in July 2005)
- **Unitils** (latest release in December 2011)
- **JWebUnit** (latest release in October 2015)
- **The Grinder** (latest release in April 2015)
- **JCrawler** (latest release in April 2013)
- **Jetif** (latest release in May 2006)

## Unit and Integration frameworks

### JUnit

*The most famous testing framework in Java world.*

- Current version : **V5.3.1**
- Latest release : **September 2018**
- First release : **1998**
- Github URLs : 
    - JUnit4 : https://github.com/junit-team/junit4
    - JUnit5 : https://github.com/junit-team/junit5
- Gradle tasks : 
    - JUnit4 : `./gradlew clean testJUnit4`
    - JUnit5 : `./gradlew clean testJUnit5`

### TestNG

*A serious competitor of Junit, inspiring it and inspired from it.*

- Current version : **V6.10**
- Latest release : **September 2018**
- First release : **September 2004**
- Github URL : https://github.com/cbeust/testng
- Gradle task : `./gradlew clean testNG`

## Mocking frameworks

### Mockito

*The most famous mocking framework. 
It respects well the AAA pattern, allowing expectations after the call of the method to test.* 

- Current version : **V2.23.0**
- Latest release : **October 2018**
- First release : **March 2008**
- Github URL : https://github.com/mockito/mockito
- Gradle task : `./gradlew clean testMockito`

### EasyMock

*A modern mocking framework.*

- Current version : **V4.0.1**
- Latest release : **October 2018**
- First release : **November 2005**
- Github URL : https://github.com/easymock/easymock
- Gradle task : `./gradlew clean testEasyMock`

### PowerMock

*Easymock and Mockito extension to mock with more powerful capabilities (static and final methods for example).*

- Current version : **V2.0.0 RC1**
- Latest release : **October 2018**
- First release : **November 2008**
- Github URL : https://github.com/powermock/powermock

### JMockit

*A mocking framework that have by default more capabilities than classic ones, like mocking private, static or final methods.*

- Current version : **V1.43**
- Latest release : **September 2018**
- First release : **June 2006**
- Github URL : https://github.com/jmockit/jmockit1
- Gradle task : `./gradlew clean testJMockit`

### JMock

*Another alternative, old-fashioned.*

- Current version : **V2.9.0**
- Latest release : **October 2018**
- First release : **2007**
- Github URL : https://github.com/jmock-developers/jmock-library
- Gradle task : `./gradlew clean testJMock`

## Server mocking librairies

### Greenmail

*A useful library to simulate a mail server.*

- Current version : **V1.5.8**
- Latest release : **August 2018**
- First release : **2007**
- Github URL : https://github.com/greenmail-mail-test/greenmail

### Wiremock

*A usefull library mock a SOAP / REST remote API.*

- Current version : **V2.19.0**
- Latest release : **September 2018**
- First release : **2011**
- Github URL : https://github.com/tomakehurst/wiremock

## Specifications / BDD frameworks

### Cucumber JVM

*The so famous BDD framework, adapted to JVM, based on Gherkin specifications files.*

- Current version : **V4.2.0**
- Latest release : **October 2018**
- First release : **2012**
- Github URL : https://github.com/cucumber/cucumber-jvm
- Gradle task : `./gradlew clean testCucumber`

### Gauge

*An recent alternative using Markdown syntax for specifications files.*

- Current version : **V1.0.3**
- Latest release : **October 2018**
- First release : **June 2018**
- Github URL : https://github.com/getgauge/gauge
- Gradle task : `./gradlew clean testGauge`

### Concordion

*An alternative using HTML syntax for specifications files.*

- Current version : **V2.2.0**
- Latest release : **July 2018**
- First release : **2008**
- Github URL : https://github.com/concordion/concordion

### JNario

*An executable specifications framework for Java, mixing Cucumber syntax and Java for Acceptance tests, and another light DSL for Unit tests.*

- Current version : **V1.0.0**
- Latest release : **July 2014**
- First release : **July 2012**
- Github URL : https://github.com/sebastianbenz/Jnario

### Serenity BDD

*A BDD framework on top of JUnit4, Cucumber or JBehave, allowing coding Unit and Acceptance tests using BDD style.*

- Current version : **V2.0.11**
- Latest release : **October 2018**
- First release : **June 2015**
- Github URL : https://github.com/serenity-bdd/serenity-core
- Gradle task : `./gradlew clean testSerenityBDD aggregate`

### JGiven

*A developer-friendly framework using plain Java syntax for writing BDD-style tests.*

To have nice HTML report, execute `./gradlew clean test` and have a look at `build/reports/jgiven/test/html/index.html`

- Current version : **V0.16.1**
- Latest release : **September 2018**
- First release : **April 2014**
- Github URL : https://github.com/TNG/JGiven
- Gradle task : `./gradlew clean testJGiven`

### Specsy framework

*A BDD framework for Scala.*

- Current version : **V2.3.2**
- Latest release : **Jan 2017**
- First release : **Aug 2010**
- Github URL : https://github.com/luontola/specsy

### SPOCK framework

*A popular BDD framework written in Groovy.*

- Current version : **V1.1**
- Latest release : **May 2017**
- First release : **March 2015**
- Github URL : https://github.com/spockframework/spock
- Gradle task : `./gradlew clean testSpock`

### SPEK framework

*A BDD framework written in Kotlin.*

- Current version : **V2.0.0-rc1**
- Latest release : **September 2018**
- First release : **September 2016**
- Github URL : https://github.com/spekframework/spek
- Gradle task : `./gradlew clean testSpek`

## Assertions librairies

### Hamcrest (Java)

*An old and popular assertions library, existing in many languages, using nested matchers.*

- Current version : **V1.3**
- Latest release : **July 2012**
- First release : **July 2007**
- Github URL : https://github.com/hamcrest/JavaHamcrest
- Gradle task : `./gradlew clean testAssertions`

### AssertJ (Java)

*A modern and powerful assertions library.*

- Current version : **V3.11.1**
- Latest release : **August 2018**
- First release : **March 2013**
- Github URL : https://github.com/joel-costigliola/assertj-core
- Gradle task : `./gradlew clean testAssertions`

### Google Truth (Java)

*A nice competitor of AssertJ, simple and powerful.*

- Current version : **V0.42**
- Latest release : **July 2018**
- First release : **May 2017**
- Github URL : https://github.com/google/truth
- Gradle task : `./gradlew clean testAssertions`

### HamKrest (Kotlin)
TODO

### ExpecKt (Kotlin)
TODO

### Kluent (Kotlin)
TODO

## Property Based Testing

### Jqwik

*A PBT framework, based on annotations for classic cases or generators for more complex properties.*

- Current version : **V0.9.1**
- First release : **March 2018**
- Latest release : **October 2018**
- Github URL : https://github.com/jlink/jqwik
- Gradle task : `./gradlew clean testJqwik`

### JUnit-quickcheck

*A PBT framework, similar to Jqwik.*

- Current version : **V0.8.5**
- Latest release : **May 2018**
- First release : **February 2017**
- Github URL : https://github.com/pholser/junit-quickcheck
- Gradle task : `./gradlew clean testJunitQuickCheck`

### QuickTheories

*A PBT framework, using fluent Java API to produce random inputs.*

- Current version : **V0.25**
- Latest release : **February 2018**
- First release : **December 2015**
- Github URL : https://github.com/ncredinburgh/QuickTheories
- Gradle task : `./gradlew clean testQuickTheories`

## Code coverage

### JaCoCo

*Popular Java code coverage library.*

- Current version : **V0.8.2**
- Latest release : **August 2018**
- First release : **2013**
- Github URL : https://github.com/jacoco/jacoco
- Gradle task : `./gradlew clean jacocoTestReport`

### Cobertura

*Another well-known coverage library for Java.*

- Current version : **V2.1.1**
- Latest release : **February 2015**
- First release : **February 2005**
- Github URL : https://github.com/cobertura/cobertura
- Gradle task : `./gradlew clean coberturaReport`

### Atlassian Clover
TODO

### EMMA
TODO

## Mutation testing

### PIT

*A modern Mutation testing tool that integrates well with Continuous Integration.*

- Current version : **V1.4.3**
- Latest release : **Sept. 2018**
- First release : **May 2014**
- Github URL : https://github.com/hcoles/pitest
- Gradle task : `./gradlew clean pitest`

### Javalanche

*An old fashioned Mutation testing tool.*

- Current version : **V0.4**
- Github URL : https://github.com/david-schuler/javalanche

Disadvantages :
- No release yet (use `git clone`)
- launching using Ant `ant -f javalanche.xml mutationTest`
- Requires Javalanche JAR compiled to be launched
- Source code must be compiled toward **Java 6**, otherwise errors like `Expected stackmap frame at this location.` would occur.

### Major

*Another Mutation testing tool, using `ant` and `javac`.*

- Current version : **V1.3.2**
- Latest release : **May 2017**

## API testing

### Karate DSL
TODO

### REST-assured
TODO

## Database / JPA testing

### DbSetup

*Utility to insert test samples into tests implying a database. Use Fluent Java API.*

- Current version : **V2.1.0**
- Latest release : **June 2016**
- First release : **June 2013**
- Github URL : https://github.com/Ninja-Squad/DbSetup

### DbUnit

*Utility to insert test samples into tests implying a database. Use XML configuration file.*

- Current version : **V2.6.0**
- Latest release : **October 2018**
- First release : **Feb 2002**
- Github URL : https://github.com/sebastianbergmann/dbunit

### AssertJ-DB

*Assertions to test values in tests implying a database.*

- Current version : **V1.2.0**
- Latest release : **May 2017**
- First release : **May 2015**
- Github URL : https://github.com/joel-costigliola/assertj-db

### JPA Unit

*JUnit extension to test javax.persistence entities.*

- Current version : **V0.5.0**
- Latest release : **July 2018**
- First release : **Aug 2017**
- Github URL : https://github.com/dadrus/jpa-unit
