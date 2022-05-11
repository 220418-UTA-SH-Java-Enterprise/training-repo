# My EC2 Challenge
0. Create a public repo called "My EC2 Challenge".
1. Make a Maven WAR project titled "EC2Challenge".
- In your app, you will need two endpoints:
    - /login = login existing user (POST)
        - CONSTRAINT: user can be hardcoded in (ex. User user = new User(1, "jsmith", "password");)
        - Successful = 200
        - Unsuccessful = 400
    - /home = the main page after login (GET)
        - CONSTRAINT: a user must be logged in to view page
            - Therefore, redirect user to /login if not logged in
- You will need to implement the front controller design pattern for this app:
    - Folder structure:
        EC2Challenge
        |
        src/main/java
            |
            com.revature.web
                |
                FrontController.java
                RequestHelper.java
            com.revature.models
                |
                User.java
- For help to making your web app, please follow the HelloServlets or HelloFrontController demos.

2. After app is finished and is fully running, deploy it to an EC2 instance.
a. Create an EC2 Instance on AWS with a security group that consists of "Custom TCP" on port 8080
b. If you're on Windows right click on your folder where you've stored your pem file, click Gitbash Here
c. SSH into your EC2 instance by copy and paste the ssh command that allows you to connect to your Linux EC2 instance with your pem key, similar to this:
```
ssh -i "my-key-pair.pem" ec2-user@ec2-18-224-70-167.us-east-2.compute.amazonaws.com
```

d. Setup your EC2 environment
```
sudo yum install java-1.8.0-openjdk-devel -y
sudo yum install maven -y
sudo yum install git -y
sudo amazon-linux-extras install tomcat8.5 -y
```
e. Launch Tomcat Server and deploy your application
git clone <your repo>
cd <your repo>
cd <your app>
mvn package
f. Copy .war file from our app's target folder to our EC2's Tomcat Webapp folder
- This is how we copy the .war file from our target foler to tomcaps webapps folder
```
sudo cp target/ServletDemoAndLogin-0.0.1-SNAPSHOT.war /var/lib/tomcat/webapps/

```
g. Start your Tomcat server in your EC2
sudo service tomcat start
```
h. Navigate to your EC2 endpoint on port 8080 to view your application hosted on Tomcat
i. Done! Send your trainer of your app working at each endpoint via PM on Slack.

# References:
- [Resource](https://blog.devops4me.com/aws-tutorial-how-to-install-tomcat-in-aws-ec2-install/)
- [Resource](https://stackoverflow.com/questions/26637550/how-to-install-tomcat-in-amazon-web-services-ec2)
