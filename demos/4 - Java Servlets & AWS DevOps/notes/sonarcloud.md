# SonarCloud
* What is SonarCloud used for?
SonarCloud is the leading online service to catch Bugs and Security Vulnerabilities in your Pull Requests and throughout your code repositories.

* What are some of the features of SonarCloud?
The main features of SonarCloud are:
- 23 languages: Java, JS, C#, C/C++, Objective-C, TypeScript, Python, ABAP, PLSQL, T-SQL and more.
- Thousands of rules to track down hard-to-find bugs and quality issues thanks to powerful static code analyzers.
- Cloud CI Integrations, with Travis, Azure DevOps, BitBucket, AppVeyor and more.
- Deep code analysis, to explore all source files, whether in branches or pull requests, to reach a green Quality Gate and promote the build.
- Fast and Scalable

* So what is the difference between a bug, a vunerabilitity, and a code smell?
## Bug
- A coding mistake that can lead to an error or unexpected behavior at runtime.

## Vunerability
- A point in your code that's open to attack

## Code Smell
- A maintainability issue that makes your code confusing and difficult to maintain
- Code smells are usually not bugs; they are not technically incorrect and do not prevent the program from functioning. Instead, they indicate weaknesses in design that may slow down development or increase the risk of bugs or failures in the future.
- Here are 2 easy ways to reduce the number of code smells in your projects:
    - Refactor the smelling code as long as there's time on a project
    - Go heavy on unit testing and documentation to reduce the chances of code smelling

* What is a quality gate?
- A quality gate is an indicator that tells you whether your code meets the minimum level of quality required for your project. It consists of a set of conditions that are applied to the results of each analysis.
- With the Quality Gate, you can enforce ratings (reliability, security, security review, and maintainability) based on metrics on overall code and new code. These metrics are part of the default quality gate.
- How do I change the quality of gate in Sonarcloud?
    1. You cannot edit the Sonar Way, it's built-in. You have to create a new Quality Gate after your initial analysis by clicking "Set Up New Code Definition".
    2. Once assigning the Quality Gate to a project, you will need to reanalyze the project.

* References:
- [SonarCloud Documentation](https://docs.sonarcloud.io/)
- [What is a Code Smell & Common Mistakes](https://www.bitegarden.com/what-is-code-smell-and-common-mistakes)