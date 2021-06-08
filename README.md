# FolderSize

Is a simple program to find huge files which could be deleted to free up space on your drive.
Since in Windows its not possible to sort folders by size, I came up with this small program written in Java.

![Example Picture](https://cdn.discordapp.com/attachments/750785691427930182/851828828393570374/unknown.png)


# Getting started

## Prerequisite
- Maven
- Java

## 
- Clone the Project
- `cd Foldersize`
- `mvn clean package`
- You'll find a `FolderSize-x.x.jar` in the target folder
- For better usability I've added the JAR to my "Right Click Menu"  
![Example Right Click Menu](https://cdn.discordapp.com/attachments/851836326688063488/851836337647910942/unknown.png)

If you want that aswell follow [this tutorial](https://www.howtogeek.com/howto/windows-vista/add-any-application-to-the-desktop-right-click-menu-in-vista/)
and **use the JAR as Value**

## Troubleshooting
I've encountered problems when the JAR was not on my main drive (C:\ in my case), thats why the build.bat moves the created JAR to a location on my C: drive. Obviously the Value of the last step needs to be ajusted
