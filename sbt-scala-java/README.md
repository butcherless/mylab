# POC: Jacoco coverage with Scala and Java code

## Steps:

* clone this repo: `git clone https://github.com/butcherless/mylab.git`
* change to dir: `cd mylab/sbt-scala-java`
* generate the **sbt** coverage report: `sbt clean jacoco`
* open the index file: `open target/scala-2.12/jacoco/report/html/index.html`
* generate the **gradle** coverage report: `./gradlew clean test jacocoTestReport`
* open the index file: `open build/reports/jacoco/test/html/index.html`