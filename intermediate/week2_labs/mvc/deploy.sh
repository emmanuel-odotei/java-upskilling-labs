#!/bin/bash

# Define variables
PROJECT_DIR="C:\Users\EmmanuelOppong\Videos\Tutorials\Java\Intermediate Labs\Labs\Week 2\lab_2_mvc_db - deploy\target"
WAR_FILE="lab_2_mvc_db-0.0.1-SNAPSHOT.war"
TOMCAT_DIR="C:\Users\EmmanuelOppong\Downloads\Compressed\apache-tomcat-10.1.26\webapps"
TOMCAT_PROGRAM_FILES_DIR="C:\Users\EmmanuelOppong\Downloads\Compressed\apache-tomcat-10.1.26\bin"  # Adjust according to your Tomcat version

# Check if the WAR file exists in the project directory
if [ ! -f "$PROJECT_DIR/$WAR_FILE" ]; then
  echo "WAR file not found in the project directory: $PROJECT_DIR"
  exit 1
fi

# Copy the WAR file to the Tomcat webapps directory
cp "$PROJECT_DIR/$WAR_FILE" "$TOMCAT_DIR"

# Check if the copy was successful
if [ $? -eq 0 ]; then
  echo "WAR file successfully copied to Tomcat webapps directory."
else
  echo "Failed to copy WAR file to Tomcat webapps directory."
  exit 1
fi
# change directory to tomcat
cd "$TOMCAT_PROGRAM_FILES_DIR"
# Start Tomcat server
./startup.sh

