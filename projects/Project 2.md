# Project 2

With Project 1 out of the way, it's time to work as a part of a larger group to build a full-stack application leveraging Spring for the application server and HTML, CSS, and JavaScript for UI! The concept and functionality for this application will be up to you are your teammates! More information on the requirements for this project are found below.

## High-Level Requirements

Application must leverage the full stack: 
- PostGreSQL for persistence 
- API built with Java 8 and Spring 5
- UI built with HTML, CSS, and JavaScript


Technology framework requirements: 
- Java API will leverage the Spring Framework 
- Java API will use Spring Data JPA to communicate with the DB
- Java API will be RESTful (though HttpSession will be permitted)
- Java API will be unit tested using JUnit and Mockito, with coverage reports generated using Jacoco 
- Complete CI/CD pipelines will use AWS (CodePipeline, CodeBuild, Elastic Beanstalk, and S3)
 

Other requirements: 
- Application will demonstrate at least ten individual user stories 
- Application will leverage at least one external API 
- Application's own data model must be sufficiently complex (i.e. >2 tables) 
- SQL DB will be deployed to the cloud
- Java API will be deployed to the cloud (AWS EC2) 
- UI application will be deployed to the cloud (AWS S3) 
- Java API will have >=80% test (line) coverage for service layer (confirmed by Jacoco coverage report)
- Java API will leverage Spring's MockMvc for integration/e2e tests of controller endpoints
- Java API will be adequately documents (Java Docs and web endpoint documentation [Swagger/OpenAPI])
- At least one external API must be leveraged


Suggested bonus goals:
- Create your UI application using Angular
- Angular UI will have >= 60% test (line) coverage for all custom components (confirmed by Jasmine/Karma coverage report)
- Secure your Java API using JWTs

## Other Thoughts

The project concepts must be approved by the trainer. Remember to keep user stories clear and unambiguous. Keep in mind that you only have 2 weeks to work on this project so make your MVP something attainable. In addition to your project proposal, teams should also structure themselves with one team leader and a person or persons who fulfill the role of Gitflow manager and DevOps engineer.  Lastly, avoid the temptation to divide work into "API" and "UI", all associates must implement logic on both sides of the stack! 

## Repositories

In order to make your repositories accessible to your AWS accounts via CodePipeline, it is recommended that you create two repositories under your own personal account. One team member can host the repo for the API (while also being the manager of its CI/CD pipeline), and another member can host the repo for the UI (again, managing its CI/CD pipeline).

## Presentations

Presentations will occur on the morning of Friday, June 3rd, 2022. All team members must have a speaking role in the presentation of the application, and a PowerPoint slideshow must accompany your presentation.