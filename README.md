<pre>
# MakerSharks Assignment 
 
 
Steps to access this backend project 
Step-1: Clone the repository
Step-2: This repo consists of folders like controller,model,dto(Data transfer object), repository, service folders 
Step-3: Go to application.properties file set the username and password  
        Note: The database here is in in-memory i.e everytime u restart the application u get new table and u have to enter the details everytime 
          If u dont need that way then you can change " spring.datasource.url=jdbc:h2:file:./db/supplierdb " in your application.properties file   
Step-4: As u run the application , it will run in 8080 port , you can change it by changing the valu in application.properties file 
Step-5: Initially there is no data stored in our table , so after you run the SpringbootProjectApplication.java file , the application gets started 
Step-6: Go to your browser and search for http:localhost:8080/h2-console, then the h2 console will be displayed enter the username and password as given in application.properties file 
Step-7: As you enter username and password and select Connect button , your table will be displayed in left-side , you can select on Supplier table and in right side console 
        For data values enter demo data like  
        INSERT INTO Supplier (supplier_Id, company_name, website, location, manufacturing, nature) VALUES 
        (1, 'Alpha Manufacturing', 'http://www.alphamfg.com', 'India', 'coating', 'small_scale'), 
        (2, 'Beta Industries', 'http://www.betaind.com', 'India', '_3d_printing', 'medium_scale'), 
        (3, 'Gamma Corp', 'http://www.gammacorp.com', 'USA', 'moulding', 'large_scale'), 
        (4, 'Delta Fabricators', 'http://www.deltafab.com', 'India', 'casting', 'small_scale'), 
        (5, 'Epsilon Works', 'http://www.epsilonworks.com', 'Germany', 'casting', 'medium_scale'), 
        (6, 'Zeta Engineering', 'http://www.zetaengg.com', 'India', 'coating', 'small_scale'), 
        (7, 'Eta Tech', 'http://www.etatech.com', 'India', '_3d_printing', 'large_scale'), 
        (8, 'Theta Industries', 'http://www.thetai.com', 'USA', 'casting', 'medium_scale'), 
        (9, 'Iota Manufacturing', 'http://www.iotamfg.com', 'India', 'coating', 'small_scale'), 
        (10, 'Kappa Systems', 'http://www.kappasys.com', 'India', '_3d_printing', 'medium_scale'); 
 
    This is the demo data values to be stored in your table for checking the working of your project 
Step-8: (i)You can go to postman and type url as http://localhost:8080/api/supplier/query?pageNo=0&pageSize=4 and select POST request 
  And in body, choose raw category and change type to json now you can enter json type as  
   Example:{"location":"India", 
            "nature":"small_scale", 
            "manufacturing":"casting" 
            } 
       On clicking SEND  
       The Reponse content will be displayed containing suppliers based on location, nature and manufacturing only 4 suppliers data in each page  
      And if there is more data , you can navigate to different oages by changing pageNo in url  
     
 
      (ii) You can do this curl command line as 
 curl -X POST "http://localhost:8080/api/supplier/query?pageNo=0&pageSize=3" -H "accept: application/json" -H "Content-Type: application/json" -d '{ 
        "location": "USA", 
        "nature": "large_scale", 
        "manufacturing": "coating" 
      }' 
(Note: Its not specific that you have to give all 3 values location, nature and manufacturing  
You can give one or two or three 
If you dont give any value then all the supplier details will get displayed. 
 
This way you can check the working of the code  
 
Supplierdto class in dto folder contains location,nature and manufacturing specification . It eases our work while reading from the Requestbody, instead of defining location , nature and manufacturing again .
We can access all those from a single object. 
 
Responsecontent class file contains specification of our response , how it should be displayed so that we can read parameters to frontend 
It contains the format  
{ 
    "supplierlist": [], 
    "pageNo": 0, 
    "pageSize": 10, 
    "totalElements": 0, 
    "totalPages": 0, 
    "last": true 
} 
supplierlist- contains the supplier details in list format.    
pageNo- denotes which page user currently is. 
pageSize- denotes the number of suppliers in each page. 
totalELements- deontes the total number of suppliers in database 
totalPages- denotes how many pages are needed to display the supplier details depending on the pageSize 
last- boolean value denotes whether it is last page or not. 
 
Supplier details contains 
 - supplier id  
 - company name 
 - location  
 - website 
 - manufacturing type(moulding, 3d_printing, casting, coating)  
 - nature of business(small_scale, medium_scale, large_scale) 
</pre>
