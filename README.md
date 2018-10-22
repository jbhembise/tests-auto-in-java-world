# Tests auto in Java world
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

## Main frameworks

### JUnit

Current version : **V5.3.1**

First release : **1998**

Gradle tasks : 
- JUnit4 : `./gradlew clean testJUnit4`
- JUnit5 : `./gradlew clean testJUnit5`

### TestNG

Current version : **V6.10**

First release : **September 2004**

Gradle task : `./gradlew clean testNG`

## Mocking frameworks

### Mockito

Current version : **V2.23.0**

First release : **March 2008**

Gradle task : `./gradlew clean testMockito`

### EasyMock

Current version : **V3.6**

First release : **November 2005**

Gradle task : `./gradlew clean testEasyMock`

### PowerMock

Current version : **V1.7.4**

First release : **November 2008**

Github URL : https://github.com/powermock/powermock

### JMockit

Current version : **V1.43**

First release : **June 2006**

Gradle task : `./gradlew clean testJMockit`

### JMock

Current version : **V2.9.0**

First release : **2007**

Github URL : https://github.com/jmock-developers/jmock-library

Gradle task : `./gradlew clean testJMock`

## Server mocking librairies

### Greenmail

### Wiremock

## Specifications / BDD frameworks

### Cucumber JVM

Gradle task : `./gradlew clean testCucumber`

### Gauge

Gradle task : `./gradlew clean testGauge`

### Concordion

Current version : **V2.2.0**

Latest release : **July 2018**

First release : **2008**

Github URL : https://github.com/concordion/concordion

### JNario

### Serenity BDD

### Specsy

Current version : **V2.3.2**

Latest release : **Jan 2017**

First release : **Aug 2010**

### JGiven

Gradle task : `./gradlew clean testJGiven`

### SPOCK framework

Current version : **V1.1**

First release : **March 2015**

Gradle task : `./gradlew clean testSpock`

### SPEK framework

Current version : **V2.0.0-rc1**

First release : **September 2016**

Gradle task : `./gradlew clean testSpek`

## Assertions librairies

### Hamcrest (Java)

Current version : **V1.3**

First release : **July 2007**

Gradle task : `./gradlew clean testAssertions`

### AssertJ (Java)

Current version : **V3.11.1**

First release : **March 2013**

Gradle task : `./gradlew clean testAssertions`

### Google Truth (Java)

Current version : **V0.42**

First release : **May 2017**

Gradle task : `./gradlew clean testAssertions`

### HamKrest (Kotlin)

### ExpecKt (Kotlin)

### Kluent (Kotlin)

## Property Based Testing

### Jqwik

Current version : **V0.8.11**

First release : **March 2018**

Test engine (JUnit) : `jqwik`

Gradle task : `./gradlew clean testJqwik`

### JUnit-quickcheck

Current version : **V0.8.5**

First release : **February 2017**

Gradle task : `./gradlew clean testJunitQuickCheck`

### QuickTheories

Current version : **V0.25**

First release : **December 2015**

## Code coverage

### JaCoCo
`./gradlew clean jacocoTestReport`

### Cobertura
`./gradlew clean coberturaReport`

### Attlassian Clover

### EMMA

## Mutation testing

### PIT

Current version : **V1.4.3**

Latest release : **Sept. 2018**

First release : **May 2014**

Github URL : https://github.com/hcoles/pitest

Disadvantages : 
- compliance with Java 10 ?

Gradle task : `./gradlew clean pitest`

### Javalanche

Github URL : https://github.com/david-schuler/javalanche

Disadvantages :
- No release yet (use `git clone`)
- launching using Ant `ant -f javalanche.xml mutationTest`
- Requires Javalanche JAR compiled to be launched
- Source code must be compiled toward **Java 6**, otherwise errors like `Expected stackmap frame at this location.` would occur.

### Major

Current version : **V1.3.2**

Latest release : **May 2017**

## API testing

### Karate DSL

### REST-assured

## Database / JPA testing

### DbSetup

Current version : **V2.1.0**

Latest release : **June 2016**

First release : **June 2013**

### DbUnit

Current version : **V2.6.0**

Latest release : **October 2018**

First release : **Feb 2002**

### AssertJ-DB

### JPA unit

Current version : **V0.5.0**

Latest release : **July 2018**

First release : **Aug 2017**

Github URL : https://github.com/dadrus/jpa-unit
