# FolderSize

Is a simple program to find huge files which could be deleted to free up space on your drive.
Since in Windows its not possible to sort folders by size, I came up with this small program written in Java.

![Example Picture](https://cdn.discordapp.com/attachments/750785691427930182/851828828393570374/unknown.png)


# Getting started



# 0. Build it yourself

## Prerequisite
- Maven
- Java

Next clone the project and build it with maven.

- Clone the Project
- `cd Foldersize`
- `mvn clean package`
- You'll find a `FolderSize-x.x.jar` in the target folder

# 1. Add Jar to Context-Menu
For better usability I've added the JAR to my "Right Click Menu"  
![Example Right Click Menu](https://cdn.discordapp.com/attachments/851836326688063488/851836337647910942/unknown.png)

If you want that aswell you'll need to create a batch file with the following command
```sh
@echo off
java -jar [absolute path to jar]
```

The absolut path is also the reason why I dont include it in the repo.
More in [this tutorial](https://www.howtogeek.com/howto/windows-vista/add-any-application-to-the-desktop-right-click-menu-in-vista/).

Next:

- Go into `Computer\HKEY_CLASSES_ROOT\Directory\Background\shell`
- Add `FolderSize` as new Key
- Add `Command` as new Key of `FolderSize`
- The Value of the command should be path to the batch file

![Example of Registry](https://media.discordapp.net/attachments/851836326688063488/966656770363760660/unknown.png?width=731&height=115)

## Troubleshooting
I've encountered problems when the JAR was not on my main drive (C:\ in my case), thats why the build.bat moves the created JAR to a location on my C: drive. Obviously the Value of the last step needs to be ajusted
