# set base image to start dockerfile
# alpine = small base image
FROM node:alpine

# copy all files from project into base image
# under a new directory called 'app'
COPY . /app

# change our working directory to our newly made folder 
# so prefixing it is no longer neccessary 
# for all following instructions
WORKDIR /app

# execute command for node to run your js 
# through your docker container
CMD node app.js